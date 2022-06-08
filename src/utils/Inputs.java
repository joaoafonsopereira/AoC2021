package utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Inputs {

    static final String BASE_INPUT_URL = "https://adventofcode.com/2021/day/%d/input";
    static final String BASE_FILE_NAME = System.getProperty("user.dir") + "/AoC2021/inputs/%d.txt"; // TODO HACKY - PROJ/MODULE STRUCTURE KINDA SUCKS RN

    static final String MY_SESSION_COOKIE =
              "53616c7465645f5f6856ff6091ac8fb72da83ecf8080713cb7abb761a27d2bb25d6c04fd6aba98eb53842bc5b2681f52b9e999e19670a784d65537c0fc53ad50";
//            "53616c7465645f5f348b2da13e936657d579f093a1a3b16aa5e04de847b12218255aaa311bc6f50f273988c35c87409e";


    public static void downloadInput(URL url, File destFile) throws IOException {
        URLConnection request = url.openConnection();
        request.setRequestProperty("Cookie", "session=" + MY_SESSION_COOKIE);

        ReadableByteChannel src = Channels.newChannel(request.getInputStream());
        FileOutputStream fos = new FileOutputStream(destFile);
        FileChannel fileChannel = fos.getChannel();
        fileChannel.transferFrom(src, 0, Long.MAX_VALUE);
    }

    public static InputStream getInputForProblem(int day) throws IOException {
        URL url = new URL(String.format(BASE_INPUT_URL, day));
        File dest = new File(String.format(BASE_FILE_NAME, day));
        if (!dest.isFile()) {
            downloadInput(url, dest);
        }
        return new FileInputStream(dest);
    }

}
