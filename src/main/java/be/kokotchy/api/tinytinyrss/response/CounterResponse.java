package be.kokotchy.api.tinytinyrss.response;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/26/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CounterResponse extends ResponseContent {

	private List<CounterResponseElement> content;

	public List<CounterResponseElement> getContent() {
		return content;
	}

	public void setContent(List<CounterResponseElement> content) {
		this.content = content;
	}
}
