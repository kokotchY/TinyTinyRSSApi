package be.kokotchy.api.tinytinyrss.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LabelsResponse extends ResponseContent {
	private List<LabelsResponseContent> content = new ArrayList<>();

	public List<LabelsResponseContent> getContent() {
		return content;
	}

	public void setContent(List<LabelsResponseContent> content) {
		this.content = content;
	}
}
