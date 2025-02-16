package json;

import java.util.*;

public class FileJsonContentUser {
    public static List<User> partsUsers(String content) {
        List<User> users = new ArrayList<>();
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {

            String[] parts = lines[i].split(" ");
            if (parts.length == 2) {
                User user = new User();
                user.setName(parts[0]);
                user.setAge(Integer.parseInt(parts[1]));
                users.add(user);
            }
        }
        return users;
    }
}
