package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.CategoriesResponse;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: canas
 * Date: 12/27/13
 * Time: 1:30 PM
 */
public class GetCategoriesQuery extends DefaultTinyTinyRSSQuery {

	private boolean enableNested;
	private boolean includeEmpty;
	private boolean unreadOnly;

	public GetCategoriesQuery(int apiLevel) {
		this(apiLevel, true, true, true);
	}

	/**
	 * Create a new getCategories query with specifics parameters
	 * @param apiLevel Level of the api
	 * @param unreadOnly Flag to have only categories with unread items
	 * @param enableNested Flag to switch to nested mode, only returns topmost categories
	 * @param includeEmpty Flag to include empty categories
	 */
	public GetCategoriesQuery(int apiLevel, boolean unreadOnly, boolean enableNested, boolean includeEmpty) {
		super(apiLevel, "getCategories");
		this.unreadOnly = unreadOnly;

		this.enableNested = enableNested;
		this.includeEmpty = includeEmpty;
	}

	@Override
	public Map<String, String> getParameters() {
		HashMap<String, String> parameters = new HashMap<>();
		parameters.put("unread_only", unreadOnly ? "true" : "false");
		parameters.put("enable_nested", enableNested ? "true" : "false");
		parameters.put("include_empty", includeEmpty ? "true" : "false");
		return parameters;
	}

	@Override
	public ResponseContent readContent(JsonParser jsonParser) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonParser, CategoriesResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean hasReadContent() {
		return true;
	}

	public boolean isEnableNested() {
		return enableNested;
	}

	public void setEnableNested(boolean enableNested) {
		this.enableNested = enableNested;
	}

	public boolean isIncludeEmpty() {
		return includeEmpty;
	}

	public void setIncludeEmpty(boolean includeEmpty) {
		this.includeEmpty = includeEmpty;
	}

	public boolean isUnreadOnly() {
		return unreadOnly;
	}

	public void setUnreadOnly(boolean unreadOnly) {
		this.unreadOnly = unreadOnly;
	}
}
