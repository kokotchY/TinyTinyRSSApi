package be.kokotchy.api.tinytinyrss.response;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigResponse extends ResponseContent {
	private ConfigResponseContent content = new ConfigResponseContent();

	public ConfigResponseContent getContent() {
		return content;
	}

	public void setContent(ConfigResponseContent content) {
		this.content = content;
	}
}
