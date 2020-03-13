import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Auth {
    private String login;
    private String password;
    private UserStatus status;


    public Auth(String login, UserStatus stat){
        this.login = login;
        status = stat;
    }

    public static Auth fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Auth.class);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("login=").append(login)
                .append("||password=").append(password).toString();
    }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public UserStatus getStatus() { return status; }

    public void setStatus(UserStatus status) { this.status = status; }
}
