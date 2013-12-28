package be.kokotchy.api.tinytinyrss.response;

import be.kokotchy.api.tinytinyrss.model.TinyTinyRSSError;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResponseContentElement {
	private TinyTinyRSSError error;

	public TinyTinyRSSError getError() {
		return error;
	}

	public void setError(TinyTinyRSSError error) {
		this.error = error;
	}
}
