import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/getmessage")
public class GetMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        if (JsonMessages.getInstance().getList() != null){
            String msg = JsonMessages.getInstance().toJSON();
            OutputStream os = resp.getOutputStream();
            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
            os.write(buffer);
            }
        }
    }
