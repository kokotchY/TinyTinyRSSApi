package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.ConfigResponse;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetConfigQuery extends DefaultTinyTinyRSSQuery {
	public GetConfigQuery(int apilevel) {
		super(apilevel, "getConfig");
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonParser, ConfigResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}
}
