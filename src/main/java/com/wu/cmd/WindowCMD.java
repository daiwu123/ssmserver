package com.wu.cmd;

import java.io.*;
import java.nio.charset.Charset;

public class WindowCMD {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime =  Runtime.getRuntime();
        Process process =  runtime.exec("cmd /k D: & cd feiwu & dir");
        InputStream in = process.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(in, Charset.forName("GBK"));
        BufferedReader red  = new BufferedReader(inputStreamReader);
        String line = null;
        while ((line = red.readLine())!=null){

            System.out.println(line);
        }
        int status = process.waitFor();
        System.out.println(status);
    }
}
