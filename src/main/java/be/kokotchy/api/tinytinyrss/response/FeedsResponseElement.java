package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/27/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class FeedsResponseElement {

	@JsonProperty("feed_url")
	private String feedUrl;

	private String title;

	private long id;

	private long unread;

	@JsonProperty("has_icon")
	private boolean hasIcon;

	@JsonProperty("cat_id")
	private long catId;

	@JsonProperty("last_updated")
	private long lastUpdated;

	@JsonProperty("order_id")
	private int orderId;

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

	public boolean isHasIcon() {
		return hasIcon;
	}

	public void setHasIcon(boolean hasIcon) {
		this.hasIcon = hasIcon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	@Override
	public String toString() {
		return "FeedsResponseElement{" +
				"catId=" + catId +
				", feedUrl='" + feedUrl + '\'' +
				", title='" + title + '\'' +
				", id=" + id +
				", unread=" + unread +
				", hasIcon=" + hasIcon +
				", lastUpdated=" + lastUpdated +
				", orderId=" + orderId +
				'}';
	}
}
