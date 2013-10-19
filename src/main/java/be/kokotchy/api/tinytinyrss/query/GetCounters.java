package be.kokotchy.api.tinytinyrss.query;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetCounters extends DefaultTinyTinyRSSQuery {

    private String output;

    public GetCounters() {
        this("flc");
    }

    public GetCounters(String output) {
        super("getCounters");
        this.output = output;
    }

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> parameters = super.getParameters();
        parameters.put("output_mode", output);
        return parameters;
    }
}
