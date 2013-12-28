package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.FeedsResponse;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 11:23 AM
 */
public class GetFeedsQuery extends DefaultTinyTinyRSSQuery {

	private long catId;

	public GetFeedsQuery(int apiLevel) {
		this(apiLevel, 0);
	}

	public GetFeedsQuery(int apiLevel, long catId) {
		super(apiLevel, "getFeeds");
		this.catId = catId;
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonParser, FeedsResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}

	@Override
	public Map<String, String> getParameters() {
		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("cat_id", ""+catId);
		return parameters;

	}
}
