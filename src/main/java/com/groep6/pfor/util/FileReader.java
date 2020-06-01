package com.groep6.pfor.util;

import java.io.*;

public class FileReader {
    private static final String ROOT = "src/main/java/com/groep6/pfor/";

    public String read(String path) {
        path = ROOT + path;

        try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
             StringBuffer buffer = new StringBuffer();
             String str;
             while ((str = reader.readLine()) != null) {
                 buffer.append(str);
             }
             return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
