package be.kokotchy.api.tinytinyrss.model;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 10/13/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TinyTinyRSSResponse {

    private int sequence;
    private TinyTinyRSSStatus status;
    private Map<String, String> content;
    private TinyTinyRSSError error;

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }

    public TinyTinyRSSError getError() {
        return error;
    }

    public void setError(TinyTinyRSSError error) {
        this.error = error;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public TinyTinyRSSStatus getStatus() {
        return status;
    }

    public void setStatus(TinyTinyRSSStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TinyTinyRSSResponse{" +
                "content='" + content + '\'' +
                ", sequence='" + sequence + '\'' +
                ", status='" + status + '\'' +
                ", error=" + error +
                '}';
    }
}
