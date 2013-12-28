package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class FeedsResponse extends ResponseContent {

	private List<FeedsResponseElement> content = new ArrayList<>();

	public List<FeedsResponseElement> getContent() {
		return content;
	}

	public void setContent(List<FeedsResponseElement> content) {
		this.content = content;
	}

}
