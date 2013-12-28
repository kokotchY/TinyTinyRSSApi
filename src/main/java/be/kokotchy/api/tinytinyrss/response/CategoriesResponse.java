package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesResponse extends ResponseContent {

	private List<CategoriesResponseElement> content = new ArrayList<>();

	public List<CategoriesResponseElement> getContent() {
		return content;
	}

	public void setContent(List<CategoriesResponseElement> content) {
		this.content = content;
	}
}
