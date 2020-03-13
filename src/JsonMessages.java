import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private static final JsonMessages jsonMessages = new JsonMessages();

    private List<Message> list = new ArrayList<>();

    static JsonMessages getInstance() {
        return jsonMessages;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
    public synchronized List<Message> getList() {
        return list;
    }
}
