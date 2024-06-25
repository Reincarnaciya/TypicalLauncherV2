package space.typro.typicallauncher.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@AllArgsConstructor
public class Account {

    public static Account defaultAccount = new Account("Игрок", false, false, null);

    public static final String donate_prefix = "[";
    public static final String donate_suffix = "]";
    public static final String defaultUserRang = donate_prefix + "Игрок" + donate_suffix;

    public String userRang;
    public boolean isModer;
    public boolean isAuthorized;
    public User user;


     @Data
     @AllArgsConstructor
     public static class User {
        String password;
        String username;
    }
}
