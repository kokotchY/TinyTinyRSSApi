package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleResponseContent extends ResponseContentElement {
	private String id;
	private String title;
	private String link;
	private List<String> labels;
	private boolean unread;
	private boolean marked;
	private boolean published;
	private String comments;
	private String author;
	private long updated;
	private String content;
	@JsonProperty("feed_id")
	private String feedId;
	private List<ArticleResponseAttachment> attachments = new ArrayList<>();
	private int score;
	@JsonProperty("feed_title")
	private String feedTitle;

	public List<ArticleResponseAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<ArticleResponseAttachment> attachments) {
		this.attachments = attachments;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public long getUpdated() {
		return updated;
	}

	public void setUpdated(long updated) {
		this.updated = updated;
	}
}
