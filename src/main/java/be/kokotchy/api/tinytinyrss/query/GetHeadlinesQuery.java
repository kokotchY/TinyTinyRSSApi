package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.HeadlinesResponse;
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
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetHeadlinesQuery extends DefaultTinyTinyRSSQuery {
	private int limit = -1;
	private long feedId;

	public GetHeadlinesQuery(int apilevel, long feedId) {
		super(apilevel, "getHeadlines");
		this.feedId = feedId;
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		ObjectMapper objectMapper = new ObjectMapper();
		HeadlinesResponse result = null;
		try {
			return objectMapper.readValue(jsonParser, HeadlinesResponse.class);
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return null;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	@Override
	public Map<String, String> getParameters() {
		HashMap<String, String> parameters = new HashMap<>();
		if (limit > 1) {
			parameters.put("limit", ""+limit);
		}
		parameters.put("feed_id", "" + feedId);
		return parameters;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public long getFeedId() {
		return feedId;
	}
}
