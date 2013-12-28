package be.kokotchy.api.tinytinyrss.query;

import be.kokotchy.api.tinytinyrss.response.ResponseContent;
import com.fasterxml.jackson.core.JsonParser;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetVersionQuery extends DefaultTinyTinyRSSQuery {
    public GetVersionQuery(int apiLevel) {
        super(apiLevel, "getVersion");
    }

    @Override
    public ResponseContent readContent(JsonParser jsonParser) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
