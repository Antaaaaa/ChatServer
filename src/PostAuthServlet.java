import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "GetLoginServlet", urlPatterns = "/auth")
public class PostAuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        byte[] buf = Util.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Auth auth = Auth.fromJSON(bufStr);
        if (auth != null) {
            if (UsersList.getInstance().containsAuth(auth) &&
                !UsersList.getInstance().getByLogin(auth.getLogin()).getPassword().equals(auth.getPassword())) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            else {
                UsersList.getInstance().add(auth);
                System.out.println(auth.toString());
            }
        }
        else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
    }
}