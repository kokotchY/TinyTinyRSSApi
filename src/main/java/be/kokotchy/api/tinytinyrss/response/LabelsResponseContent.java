package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LabelsResponseContent extends ResponseContentElement {
	private long id;
	private String caption;
	@JsonProperty("fg_color")
	private String fgColor;
	@JsonProperty("bg_color")
	private String bgColor;
	private boolean checked;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getFgColor() {
		return fgColor;
	}

	public void setFgColor(String fgColor) {
		this.fgColor = fgColor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
}
