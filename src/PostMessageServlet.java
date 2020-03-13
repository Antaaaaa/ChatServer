import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "MessageServlet", urlPatterns = "/message")
public class PostMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = Util.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Message fromJson = Message.fromJSON(bufStr);
        JsonMessages.getInstance().getList().add(fromJson);
        System.out.println(fromJson.toString());
    }
}
