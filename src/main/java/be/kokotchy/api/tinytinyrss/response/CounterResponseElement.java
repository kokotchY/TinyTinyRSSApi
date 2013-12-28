package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/26/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CounterResponseElement extends ResponseContentElement {
	private String id;
	private int counter;
	@JsonProperty("auxcounter")
	private int auxCounter;
	@JsonProperty("has_img")
	private boolean hasImg;
	private String kind;
	private String updated;

	public int getAuxCounter() {
		return auxCounter;
	}

	public void setAuxCounter(int auxCounter) {
		this.auxCounter = auxCounter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean getHasImg() {
		return hasImg;
	}

	public void setHasImg(boolean hasImg) {
		this.hasImg = hasImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "CounterResponseElement{" +
				"auxCounter=" + auxCounter +
				", id='" + id + '\'' +
				", counter=" + counter +
				", hasImg=" + hasImg +
				", kind='" + kind + '\'' +
				", updated='" + updated + '\'' +
				'}';
	}
}
