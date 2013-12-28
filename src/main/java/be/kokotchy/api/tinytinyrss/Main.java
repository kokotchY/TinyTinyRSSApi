package be.kokotchy.api.tinytinyrss;

import be.kokotchy.api.tinytinyrss.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        boolean local = false;
        TinyTinyRSSApi api;
        if (local) {
            api = new TinyTinyRSSApi("192.168.1.42", 80, "TinyTinyRSS");
        } else {
            api = new TinyTinyRSSApi("kokotchy.synology.me",12346,"TinyTinyRSS");
        }

        if (api.login("test", "test")) {
            logger.debug("Sid = {}", api.getSid());
            if (api.isLoggedIn()) {
                logger.info("User logged");
                logger.info("Api level="+api.getApiLevel());
                logger.info("Version="+api.getVersion());
                logger.info("#Unread=" + api.getUnread());
	            PrefsResponse prefs = api.getPrefs();
	            Map<String, String> preferences = new HashMap<>();
	            for (String prefName : prefs.getContent()) {
		            preferences.put(prefName, api.getPref(prefName).getContent().getValue());
	            }

	            for (Map.Entry<String, String> entry : preferences.entrySet()) {
		            System.out.println("- " + entry.getKey() + "=" +entry.getValue());
	            }
            } else {
                logger.info("User not logged");
            }
        } else {
            logger.info("Error when trying to login");
        }
    }
}
