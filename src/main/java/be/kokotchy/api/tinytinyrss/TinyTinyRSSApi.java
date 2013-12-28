package be.kokotchy.api.tinytinyrss;

import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSError;
import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSResponse;
import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSStatus;
import be.kokotchy.api.tinytinyrss.query.*;
import be.kokotchy.api.tinytinyrss.response.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * User: canas
 * Date: 10/13/13
 * Time: 2:14 PM
 */
public class TinyTinyRSSApi {

	private int apilevel;
	private String host;
    private int port;
    private String directory;
    private Logger logger = LogManager.getLogger(TinyTinyRSSApi.class);
    private URL url;
    private String sid;
    private boolean displayContent = false;

    public TinyTinyRSSApi(String host, int port, String directory) {
        this.host = host;
        this.port = port;
        this.directory = directory;
    }

    public TinyTinyRSSResponse query(TinyTinyRSSQuery query) {
        HttpClient httpClient = new HttpClient();
        String pattern = "http://%s:%d/%s";
        PostMethod method = new PostMethod(String.format(pattern, host, port, directory + "/api/"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        QueryUtil.writeQuery(outputStream, query, sid);
        logger.debug("Sending \"{}\"", outputStream.toString());
        method.setRequestEntity(new ByteArrayRequestEntity(outputStream.toByteArray()));
        TinyTinyRSSResponse response = new TinyTinyRSSResponse();
        try {
            int code = httpClient.executeMethod(method);
            logger.debug("Code: " + code);
            for (Header header : method.getResponseHeaders()) {
                logger.debug("- " + header.getName() + "=" + header.getValue());
            }

            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(method.getResponseBodyAsStream());
            if (jsonParser.nextToken() != JsonToken.START_OBJECT) {
                logger.error("The json doesn't start with a start object");
            }

//            if (displayContent) {
//	            displayResponse(jsonParser);
//	            return null;
//            }

	        if (query.hasReadContent()) {
		        response.setContent2(query.readContent(jsonParser));
	        } else {
	            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
	                String name = jsonParser.getCurrentName();
	                jsonParser.nextToken();
	                String text = jsonParser.getText();
	                switch (name) {
	                    case "seq":
	                        if (!"null".equals(text)) {
	                            response.setSequence(Integer.parseInt(text));
	                        }
	                        break;
	                    case "status":
	                        if (!"null".equals(text)) {
	                            response.setStatus(TinyTinyRSSStatus.values()[Integer.parseInt(text)]);
	                        }
	                        break;
	                    case "content":
			                response.setContent(readContent(jsonParser));
	                        break;
	                    case "error":
	                        response.setError(TinyTinyRSSError.valueOf(text));
	                        break;
	                    default:
	                        logger.debug("Unknown Reading {} = {}", name, jsonParser.getCurrentToken());
	                        break;
	                }
	            }
            }
            logger.debug("Response[seq={},status={},error={},", response.getSequence(), response.getStatus(),
                    response.getError());
            Map<String, String> content = response.getContent();
            if (content != null) {
                for (Map.Entry<String, String> entry : content.entrySet()) {
                    logger.debug("{}={},", entry.getKey(), entry.getValue());
                }
            } else {
                logger.debug("Empty content");
            }
            logger.debug("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

	private void displayResponse(JsonParser jsonParser) {
		if (displayContent) {
			logger.debug("Display content");
		}
        try {
            JsonToken token = jsonParser.nextToken();
            while (token != JsonToken.END_OBJECT) {
                switch (token) {
                    case START_OBJECT:
                    case END_OBJECT:
                    case START_ARRAY:
                    case END_ARRAY:
                        logger.debug(token.asString()+"("+token+")");
                        break;
                    case FIELD_NAME:
                        logger.debug("Field: "+jsonParser.getCurrentName());
                        break;
                    default:
                        logger.debug("Default: "+token);
                }
                token = jsonParser.nextToken();
            }
            logger.debug(token.asString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> readContent(JsonParser jsonParser) throws IOException {
        Map<String, String> result = new HashMap<>();
        JsonToken jsonToken = jsonParser.nextToken();
        if (displayContent) {
            while (jsonToken != JsonToken.END_OBJECT) {
                logger.debug(String.format("A token: %s, text %s", jsonParser.getCurrentName(),
                        jsonParser.getText()));
	            String name = jsonParser.getCurrentName();
	            jsonParser.nextToken();
	            result.put(name, jsonParser.getText());
	            jsonToken = jsonParser.nextToken();
            }
            logger.debug("End of object: "+jsonParser.getText());
        } else {
            while (jsonToken != JsonToken.END_OBJECT) {
                String name = jsonParser.getCurrentName();
                jsonParser.nextToken();
                result.put(name, jsonParser.getText());
                jsonToken = jsonParser.nextToken();
            }
        }
        return result;
    }

    public boolean login(String user, String pass) {
        TinyTinyRSSResponse query = query(new LoginQuery(apilevel, user, pass));
        sid = query.getContent().get("session_id");
	    try {
		    this.apilevel = getApiLevel();
	    } catch (Exception e) {
		    logger.error("Impossible to retrieve api level", e);
		    this.apilevel = 0;
	    }
        return sid != null;
    }

    public URL getUrl() {
        return url;
    }

    public String getSid() {
        return sid;
    }

    public boolean isLoggedIn() {
        TinyTinyRSSResponse query = query(new IsLoggedInQuery(apilevel));
        return Boolean.parseBoolean(query.getContent().get("status"));
    }

    public int getApiLevel() {
        TinyTinyRSSResponse query = query(new GetApiLevelQuery(apilevel));
        return Integer.parseInt(query.getContent().get("level"));
    }

    public String getVersion() {
        TinyTinyRSSResponse query = query(new GetVersionQuery(apilevel));
        return query.getContent().get("version");
    }

    public int getUnread() {
        TinyTinyRSSResponse query = query(new GetUnreadQuery(apilevel));
        return Integer.parseInt(query.getContent().get("unread"));
    }

    public String getCounters() {
        TinyTinyRSSResponse query = query(new GetCountersQuery(apilevel));

        return "bla";
    }

    public String getCounters(String output) {
        TinyTinyRSSResponse query = query(new GetCountersQuery(apilevel, output));
	    if (query == null) {
		    System.out.println("Query is null but shouldn't be...");
	    } else {
	        return query.getContent().get("counter");
	    }

	    return "bla";
    }

    public void setDisplayContent(boolean value) {
        displayContent = value;
    }

	public FeedsResponse getFeeds(long catId) {
		return (FeedsResponse) query(new GetFeedsQuery(apilevel, catId)).getContent2();
	}

	public CategoriesResponse getCategories() {
		return (CategoriesResponse) query(new GetCategoriesQuery(apilevel)).getContent2();
	}

	/**
	 * Return unread categories (excludes empty categories)
	 * @return
	 */
	public CategoriesResponse getUnreadCategories() {
		return (CategoriesResponse) query(new GetCategoriesQuery(apilevel, true, false, false)).getContent2();
	}

	public HeadlinesResponse getHeadlines(long feedId, int limit) {
		GetHeadlinesQuery query = new GetHeadlinesQuery(apilevel, feedId);
		query.setLimit(limit);
		return (HeadlinesResponse) query(query).getContent2();
	}

	public ArticleResponse getArticle(long articleId) {
		return (ArticleResponse)  query(new GetArticleQuery(apilevel, articleId)).getContent2();
	}

	public ConfigResponse getConfig() {
		return (ConfigResponse) query(new GetConfigQuery(apilevel)).getContent2();
	}

	public PrefResponse getPref(String prefName) {
		return (PrefResponse) query(new GetPrefQuery(apilevel, prefName)).getContent2();
	}

	public PrefsResponse getPrefs() {
		return (PrefsResponse) query(new GetPrefsQuery(apilevel)).getContent2();
	}

	public LabelsResponse getLabels() {
		return (LabelsResponse) query(new GetLabelsQuery(apilevel)).getContent2();
	}
}
