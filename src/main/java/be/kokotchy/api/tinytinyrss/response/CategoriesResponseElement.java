package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesResponseElement extends ResponseContentElement {

	private long id;
	private String title;
	private long unread;
	@JsonProperty("order_id")
	private int orderId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getUnread() {
		return unread;
	}

	public void setUnread(long unread) {
		this.unread = unread;
	}
}
