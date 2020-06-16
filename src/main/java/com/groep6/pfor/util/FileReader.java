package com.groep6.pfor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
    public String read(InputStream stream) {
        try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
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
