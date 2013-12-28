package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleResponse extends ResponseContent {
	private List<ArticleResponseContent> content = new ArrayList<>();

	public List<ArticleResponseContent> getContent() {
		return content;
	}

	public void setContent(List<ArticleResponseContent> content) {
		this.content = content;
	}
}
