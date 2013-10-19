package be.kokotchy.api.tinytinyrss.query;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueryUtil {

    public static void writeQuery(OutputStream out, TinyTinyRSSQuery query, String sid) {
        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(out);
            jsonGenerator.useDefaultPrettyPrinter();
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("op", query.getOperation());
            if (sid != null) {
                jsonGenerator.writeStringField("sid", sid);
            }
            for (Map.Entry<String, String> entry : query.getParameters().entrySet()) {
                jsonGenerator.writeStringField(entry.getKey(), entry.getValue());
            }
            jsonGenerator.writeEndObject();
            jsonGenerator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
