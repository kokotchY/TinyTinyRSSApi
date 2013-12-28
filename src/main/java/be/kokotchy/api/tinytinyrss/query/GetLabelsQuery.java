package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.LabelsResponse;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetLabelsQuery extends DefaultTinyTinyRSSQuery {
	public GetLabelsQuery(int apilevel) {
		super(apilevel, "getLabels");
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		try {
			return new ObjectMapper().readValue(jsonParser, LabelsResponse.class);
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return null;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}
}
