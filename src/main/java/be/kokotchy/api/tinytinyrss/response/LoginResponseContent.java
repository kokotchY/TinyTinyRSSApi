package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginResponseContent extends ResponseContentElement {
	@JsonProperty("session_id")
	private String sessionId;

	@JsonProperty("api_level")
	private int apiLevel;

	public int getApiLevel() {
		return apiLevel;
	}

	public void setApiLevel(int apiLevel) {
		this.apiLevel = apiLevel;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
