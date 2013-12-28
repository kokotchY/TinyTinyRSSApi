package be.kokotchy.api.tinytinyrss.response;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrefResponse extends ResponseContent {
	private PrefResponseContent content = new PrefResponseContent();

	public PrefResponseContent getContent() {
		return content;
	}

	public void setContent(PrefResponseContent content) {
		this.content = content;
	}
}
