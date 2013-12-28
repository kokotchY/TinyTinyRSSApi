package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeadlinesResponse extends ResponseContent {

	private List<HeadlinesResponseContent> content = new ArrayList<>();

	public List<HeadlinesResponseContent> getContent() {
		return content;
	}

	public void setContent(List<HeadlinesResponseContent> content) {
		this.content = content;
	}
}
