package be.kokotchy.api.tinytinyrss.response;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginResponse extends ResponseContent {
	private LoginResponseContent content;

	public LoginResponseContent getContent() {
		return content;
	}

	public void setContent(LoginResponseContent content) {
		this.content = content;
	}

}
