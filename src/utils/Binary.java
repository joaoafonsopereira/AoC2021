package utils;

import java.util.List;
import java.util.stream.Stream;

public class Binary {


    public static String negate(String binaryNr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < binaryNr.length(); i++) {
            char next = binaryNr.charAt(i) == '1' ? '0' : '1';
            res.append(next);
        }
        return res.toString();
    }


}
