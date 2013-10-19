package be.kokotchy.api.tinytinyrss;

import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSError;
import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSResponse;
import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSStatus;
import be.kokotchy.api.tinytinyrss.query.GetApiLevelQuery;
import be.kokotchy.api.tinytinyrss.query.GetCounters;
import be.kokotchy.api.tinytinyrss.query.GetUnread;
import be.kokotchy.api.tinytinyrss.query.GetVersionQuery;
import be.kokotchy.api.tinytinyrss.query.IsLoggedInQuery;
import be.kokotchy.api.tinytinyrss.query.LoginQuery;
import be.kokotchy.api.tinytinyrss.query.QueryUtil;
import be.kokotchy.api.tinytinyrss.query.TinyTinyRSSQuery;
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
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TinyTinyRSSApi {

    private String host;
    private int port;
    private String directory;
    private Logger logger = LogManager.getLogger(TinyTinyRSSApi.class);
    private URL url;
    private String sid;

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

    private Map<String, String> readContent(JsonParser jsonParser) throws IOException {
        Map<String, String> result = new HashMap<>();
        JsonToken jsonToken = jsonParser.nextToken();
        while (jsonToken != JsonToken.END_OBJECT) {
            String name = jsonParser.getCurrentName();
            jsonParser.nextToken();
            result.put(name, jsonParser.getText());
            jsonToken = jsonParser.nextToken();
        }
        return result;
    }

    public boolean login(String user, String pass) {
        TinyTinyRSSResponse query = query(new LoginQuery(user, pass));
        sid = query.getContent().get("session_id");
        return sid != null;
    }

    public URL getUrl() {
        return url;
    }

    public String getSid() {
        return sid;
    }

    public boolean isLoggedIn() {
        TinyTinyRSSResponse query = query(new IsLoggedInQuery());
        return Boolean.parseBoolean(query.getContent().get("status"));
    }

    public int getApiLevel() {
        TinyTinyRSSResponse query = query(new GetApiLevelQuery());
        return Integer.parseInt(query.getContent().get("level"));
    }

    public String getVersion() {
        TinyTinyRSSResponse query = query(new GetVersionQuery());
        return query.getContent().get("version");
    }

    public int getUnread() {
        TinyTinyRSSResponse query = query(new GetUnread());
        return Integer.parseInt(query.getContent().get("unread"));
    }

    public String getCounters() {
        TinyTinyRSSResponse query = query(new GetCounters());

        return "bla";
    }
}
