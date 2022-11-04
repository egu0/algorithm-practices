package im.engure.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UseMapDemo {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("a", "b");
        m.get("a");
        m.containsKey("a");
        m.size();
        m.remove("key");
        m.keySet();// Set<String>
        m.clear();

        new Scanner(System.in).next();

    }
}
