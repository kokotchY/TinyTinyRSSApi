package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.PrefResponse;
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
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetPrefQuery extends DefaultTinyTinyRSSQuery {
	private String prefName;

	public GetPrefQuery(int apilevel, String prefName) {
		super(apilevel, "getPref");
		this.prefName = prefName;
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		try {
			return new ObjectMapper().readValue(jsonParser, PrefResponse.class);
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
		parameters.put("pref_name", prefName);
		return parameters;
	}
}
