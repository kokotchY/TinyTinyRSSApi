package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeadlinesResponseContent extends ResponseContentElement {
	private long id;
	private boolean unread;
	private boolean marked;
	private boolean published;
	@JsonProperty("updated")
	private long updatedTime;

	@JsonProperty("is_updated")
	private boolean updated;
	private String title;
	private String link;

	@JsonProperty("feed_id")
	private String feedId;

	private List<String> tags;
	private String excerpt;
	private List<String> labels;

	@JsonProperty("feed_title")
	private String feedTitle;

	@JsonProperty("comments_count")
	private int commentsCount;

	@JsonProperty("comments_link")
	private String commentsLink;

	@JsonProperty("always_display_attachments")
	private boolean alwaysDisplayAttachments;
	private String author;
	private int score;

	public boolean isAlwaysDisplayAttachments() {
		return alwaysDisplayAttachments;
	}

	public void setAlwaysDisplayAttachments(boolean alwaysDisplayAttachments) {
		this.alwaysDisplayAttachments = alwaysDisplayAttachments;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getCommentsLink() {
		return commentsLink;
	}

	public void setCommentsLink(String commentsLink) {
		this.commentsLink = commentsLink;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getFeedId() {
		return feedId;
	}

	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public long getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(long updatedTime) {
		this.updatedTime = updatedTime;
	}
}
