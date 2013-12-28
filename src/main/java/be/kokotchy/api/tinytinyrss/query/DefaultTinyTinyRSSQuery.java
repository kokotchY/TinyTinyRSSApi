package be.kokotchy.api.tinytinyrss.query;

import com.fasterxml.jackson.core.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class DefaultTinyTinyRSSQuery implements TinyTinyRSSQuery {

	private int apiLevel;
	private String operation;

    public DefaultTinyTinyRSSQuery(int apiLevel, String operation) {
	    this.apiLevel = apiLevel;
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

	@Override
	public boolean hasReadContent() {
		return false;
	}

	public int getApiLevel() {
		return apiLevel;
	}
}
