package be.kokotchy.api.tinytinyrss.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultTinyTinyRSSQuery implements TinyTinyRSSQuery {

    private String operation;

    public DefaultTinyTinyRSSQuery(String operation) {
        this.operation = operation;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public Map<String, String> getParameters() {
        return new HashMap<>();
    }
}
