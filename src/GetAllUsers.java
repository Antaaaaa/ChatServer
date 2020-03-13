import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/get")
public class GetAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String list = UsersList.getInstance().toJSON();
        if (list != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = list.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }
}
