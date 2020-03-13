import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class UsersList {

    private static final UsersList usersList =  new UsersList();

    private final Gson gson;
    private final List<Auth> authList = new ArrayList<>();
    public static UsersList getInstance(){ return usersList;}

    private UsersList(){
        gson = new GsonBuilder().create();
    }

    public synchronized void add(Auth auth){
        if (!containsAuth(auth)) authList.add(auth);
        if (!auth.getStatus().isStatus()) changeStatus(auth);
    }

    public boolean containsAuth(Auth auth){
        for (Auth user : authList) {
            if (user.getLogin().equals(auth.getLogin())) return true;
            auth.setStatus(new UserStatus(true));
        }
            return false;
    }
    public Auth getByLogin(String login){
        for (Auth user : authList){
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }
    public synchronized boolean changeStatus(Auth auth){
        if (getInstance().containsAuth(auth)){
            for (Auth user : authList)
                if (user.getLogin().equals(auth.getLogin())) {
                    user.setStatus(new UserStatus(!user.getStatus().isStatus()));
                    return true;}
        }
        return false;
    }
    public synchronized String toJSON(){
        List<Auth> loginList = new ArrayList<>();
        for (Auth auth : authList){
            if (auth != null)
                if (auth.getStatus().isStatus())
                    loginList.add(new Auth(auth.getLogin(), auth.getStatus()));
            }
        return gson.toJson(new Users(loginList));
    }
}
