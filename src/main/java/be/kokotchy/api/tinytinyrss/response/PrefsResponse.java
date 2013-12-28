package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrefsResponse extends ResponseContent {
	private List<String> content = new ArrayList<>();

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}
}
