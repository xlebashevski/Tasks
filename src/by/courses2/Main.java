package by.courses2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        String str = "asd,a  sd..adq 1w - q,q2 - weqsw5e!!";
        Pattern p = Pattern.compile("[ ]");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
            System.out.println(m.start() + " " + m.end());
        }
        System.out.println("количество символов " + count);
    }
}
