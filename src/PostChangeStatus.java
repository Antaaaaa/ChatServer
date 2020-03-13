import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ChangeStatus", urlPatterns = "/change_status")
public class PostChangeStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = Util.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Auth fromJson = Auth.fromJSON(bufStr);
        if (UsersList.getInstance().changeStatus(fromJson)) System.out.println("Status changed");
    }
}
