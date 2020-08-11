package com.wu.util;

import com.wu.util.canno.SelfEnum;
import com.wu.util.po.BasicConfigBean;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        /*Set<SelfEnum> ad = new HashSet<>();
        ad.add(SelfEnum.ERROR_CODE_0007);
        ad.add(SelfEnum.ERROR_CODE_0007);
        System.out.println(ad.size());
        SelfEnum.ERROR_CODE_0007.setMessage();
        System.out.println(SelfEnum.ERROR_CODE_0007.setMessage());
        System.out.println(SelfEnum.ERROR_CODE_0007.setMessage("add"));
        System.out.println(SelfEnum.ERROR_CODE_0007.setMessage("delete"));*/

        /*List<String> b= new ArrayList<>();
        b.add("1");
        List<String> c= new ArrayList<>();
        c.add("2");
        c.add("3");
        b.addAll(c);
        for (int i = 0; i < b.size(); i++) {
            System.out.println( b.get(i));
        }*/
        /*String str = "00.101";

        Pattern pattern = Pattern.compile("^[\\d]*|[\\d]{1}\\.[\\d]*$");
        System.out.println( pattern.matcher(str).matches());
        double a = Double.parseDouble(str);
        System.out.println(a);*/
       /* BasicConfigBean bean = new BasicConfigBean();
       // System.out.println(getStr1);
        List<String> list = new ArrayList<>();
       // list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Collectors.toMap(a->a,b->b);
*/
       /* Set<Map.Entry<String, String>> entries1 = list.stream().collect(objectMapCollector).entrySet();*/
     /*   Set<Map.Entry<String, String>> entries = list.stream().collect(Collectors.toMap(a -> a, b -> b)).entrySet();
        System.out.println(entries.toString());*/
        //list.stream().collect()
        File f = new File("D:\\test\\Basic_Name_Type_Template.xlsx");
        FileOutputStream outputStream = new FileOutputStream("D:\\test1\\a.xlsx");
        FileInputStream fileInputStream = new FileInputStream(f);
        byte [] size = new byte[1024];
        int read = fileInputStream.read(size);
        while(read>0){
            outputStream.write(size,0,read);
            outputStream.flush();
            read = fileInputStream.read(size);
        }
        fileInputStream.close();
        outputStream.close();
        FileInputStream fileInputStream1 = new FileInputStream(new File("D:\\test1\\a.xlsx"));
    }
}
