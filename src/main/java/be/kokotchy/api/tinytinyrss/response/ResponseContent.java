package be.kokotchy.api.tinytinyrss.response;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResponseContent {
	private int seq;
	private int status;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
