package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleResponseAttachment {
	private String id;
	@JsonProperty("content_url")
	private String contentUrl;
	@JsonProperty("content_type")
	private String contentType;
	@JsonProperty("post_id")
	private String postId;
	private String title;
	private String duration;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
