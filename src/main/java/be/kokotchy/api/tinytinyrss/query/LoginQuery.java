package be.kokotchy.api.tinytinyrss.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginQuery extends DefaultTinyTinyRSSQuery {

    private String user;
    private String password;

    public LoginQuery(String user, String password) {
        super("login");
        this.user = user;
        this.password = password;
    }

    @Override
    public Map<String, String> getParameters() {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("user", user);
        parameters.put("password", password);
        return parameters;
    }

}
