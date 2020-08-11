package com.wu.test;

import java.io.*;

public class SqlTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\sql-data\\000512.sql");
        if (!file.isFile()) {
            System.out.println("error arg[0] not a file");
            return;
        }

        System.out.println(file.getName() + "BEGIN!");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File("D:\\sql-data\\0005128.sql")), "utf-8"));

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), "utf-8"/* 指定源文件的字符集编码 */));

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            bw.append(line + ";\n"/* 追加分号和换行 */);
            line = br.readLine();
        }
        br.close();
        bw.close();
        System.out.println(file.getName() + "OK!");

    }
}
