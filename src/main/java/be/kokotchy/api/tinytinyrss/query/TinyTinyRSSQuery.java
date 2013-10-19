package be.kokotchy.api.tinytinyrss.query;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TinyTinyRSSQuery {

    /**
     * Name of the operation
     * @return Return the name of the operation
     */
    public String getOperation();

    /**
     * Return the parameters of the query
     * @return Parameters of the query
     */
    public Map<String, String> getParameters();
}
