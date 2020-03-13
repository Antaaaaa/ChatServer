import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Message {
    private String message;
    private String from;
    private String to;

    public Message(String message, String from, String to) {
        this.message = message;
        this.from = from;
        this.to = to;
    }

    public static Message fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Message.class);
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
