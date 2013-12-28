package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.ArticleResponse;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetArticleQuery extends DefaultTinyTinyRSSQuery {
	private final long articleId;

	public GetArticleQuery(int apiLevel, long articleId) {
		super(apiLevel, "getArticle");
		this.articleId = articleId;
	}


	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonParser, ArticleResponse.class);
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Map<String, String> getParameters() {
		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("article_id", ""+articleId);
		return parameters;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}
}
