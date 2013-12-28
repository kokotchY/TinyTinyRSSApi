package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetCountersQuery extends DefaultTinyTinyRSSQuery {

    private String output;

    public GetCountersQuery(int apiLevel) {
        this(apiLevel, "flc");
    }

    public GetCountersQuery(int apiLevel, String output) {
        super(apiLevel, "getCounters");
        this.output = output;
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = super.getParameters();
        parameters.put("output_mode", output);
        return parameters;
    }

    @Override
    public ResponseContent readContent(JsonParser jsonParser) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
