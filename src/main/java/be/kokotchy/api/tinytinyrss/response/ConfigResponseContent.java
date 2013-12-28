package be.kokotchy.api.tinytinyrss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigResponseContent extends ResponseContentElement {
	@JsonProperty("icons_dir")
	private String iconsDir;
	@JsonProperty("icons_url")
	private String iconsUrl;
	@JsonProperty("daemon_is_running")
	private boolean daemonIsRunning;
	@JsonProperty("num_feeds")
	private int numFeeds;

	public boolean isDaemonIsRunning() {
		return daemonIsRunning;
	}

	public void setDaemonIsRunning(boolean daemonIsRunning) {
		this.daemonIsRunning = daemonIsRunning;
	}

	public String getIconsDir() {
		return iconsDir;
	}

	public void setIconsDir(String iconsDir) {
		this.iconsDir = iconsDir;
	}

	public String getIconsUrl() {
		return iconsUrl;
	}

	public void setIconsUrl(String iconsUrl) {
		this.iconsUrl = iconsUrl;
	}

	public int getNumFeeds() {
		return numFeeds;
	}

	public void setNumFeeds(int numFeeds) {
		this.numFeeds = numFeeds;
	}
}
