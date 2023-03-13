package com.example.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Transfer {
    public static void main(String[] args) throws IOException {
        try(InputStream in = new URL("https://www.naver.com").openStream()) {
            in.transferTo(System.out);
        }
        }
    }
