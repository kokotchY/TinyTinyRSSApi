package be.kokotchy.api.tinytinyrss;

import be.kokotchy.api.tinytinyrss.query.QueryUtil;
import be.kokotchy.api.tinytinyrss.response.CategoriesResponse;
import be.kokotchy.api.tinytinyrss.response.CategoriesResponseElement;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/26/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleQuery {
	public static void main(String[] args) {
		new SimpleQuery();
	}

	private Logger logger = LogManager.getLogger(SimpleQuery.class);


	public SimpleQuery() {
		TinyTinyRSSApi api = new TinyTinyRSSApi("kokotchy.synology.me", 12346, "TinyTinyRSS");
		boolean login = api.login("test", "test");
		if (login) {
			String query = "{ \"op\":\"getLabels\", \"sid\":\""+api.getSid()+"\" }";
			HttpClient httpClient = new HttpClient();
			String pattern = "http://%s:%d/%s";
			PostMethod method = new PostMethod(String.format(pattern, "kokotchy.synology.me", 12346, "TinyTinyRSS/api/"));
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				outputStream.write(query.getBytes());
				logger.debug("Sending \"{}\"", outputStream.toString());
				method.setRequestEntity(new ByteArrayRequestEntity(outputStream.toByteArray()));
				int code = httpClient.executeMethod(method);
				logger.debug("Code="+code);
				StringWriter output = new StringWriter();
				IOUtils.copy(method.getResponseBodyAsStream(), output, "utf8");
				logger.info(output.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
