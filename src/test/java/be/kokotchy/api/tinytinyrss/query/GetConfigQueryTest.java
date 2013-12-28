package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.ConfigResponse;
import be.kokotchy.api.tinytinyrss.response.ConfigResponseContent;
import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/28/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetConfigQueryTest {
	@Test
	public void testParsing() throws Exception {
		GetConfigQuery query = new GetConfigQuery(0);
		JsonFactory jsonFactory = new JsonFactory();
		String queryJson = "{\"seq\":0,\"status\":0,\"content\":{\"icons_dir\":\"feed-icons\",\"icons_url\":\"feed-icons\",\"daemon_is_running\":false,\"num_feeds\":3}}";
		ResponseContent responseContent = query.readContent(jsonFactory.createParser(queryJson));

		Assert.assertTrue(responseContent instanceof ConfigResponse);
		ConfigResponse configResponse = (ConfigResponse) responseContent;
		assertEquals(0, configResponse.getSeq());
		assertEquals(0, configResponse.getStatus());
		ConfigResponseContent content = configResponse.getContent();
		assertEquals("feed-icons", content.getIconsDir());
		assertEquals("feed-icons", content.getIconsUrl());
		assertEquals(3, content.getNumFeeds());
	}
}
