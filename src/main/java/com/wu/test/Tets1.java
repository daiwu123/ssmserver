package com.wu.test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tets1 {
    public static void main(String[] args) throws ParseException, IOException {
     /* String startTime = "2020-04-21 14:34:00";
      String endTime = "2020-04-22 17:37:00";
        SimpleDateFormat sww = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date s =sww.parse(startTime);
        Date e =sww.parse(endTime);
        Calendar instance1 = Calendar.getInstance();
        instance1.setTime(s);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(e);
        int i11 = instance1.get(Calendar.HOUR_OF_DAY);
        int i22 = instance2.get(Calendar.HOUR_OF_DAY);
        System.out.println(i22 - i11);*/
    /* File f = new File("D:\\FlatfileHistory_0.csv");
      Workbook workbook = new HSSFWorkbook(new FileInputStream(f));
      System.out.println(workbook);*/
      /*  String v = "";
        for (int i = 0; i < 55; i++) {
            v+="?,";
        }
        System.out.println(v);*/
       // t2();
       // t1();
      /*  String []strings = {"diff_P0064811_ZM_P0064811_ZN.tar.gz",
                "diff_P0064811_ZM_P0064811_ZN.tar.gz_md5sum.txt",
                "diff_P0064811_ZM_P000123_AK_P0064811_ZN.tar.gz",
                "diff_P0064811_ZM_P000123_AK_P0064811_ZN.tar.gz_md5sum.txt","hash.txt","P0064811_ZN.tar.gz","P0064811_ZN.tar.gz_md5sum.txt"};
        String target ="P0064811_ZN";
        //String regex = "^diff\\S\\s$";
        Pattern pattern = Pattern.compile("^diff.*P0064811_ZN.tar.gz$|^diff.*P0064811_ZN.tar.gz_md5sum.txt$|^hash.txt$|^P0064811_ZN.tar.gz$|^P0064811_ZN.tar.gz_md5sum.txt$");
        for (int i = 0; i < strings.length; i++) {
           String singin =  strings[i];
            Matcher matcher = pattern.matcher(singin);
            if(matcher.find()){
                System.out.println(singin);
                //System.out.println(matcher.group());
            }
        }*/
      Map<String,Object> map = new HashMap<>();
        map.put("a","b");
      String a = (String)map.get("b");
        System.out.println(a);

        // String str = "Hello,World! in Java.";
        //Pattern pattern = Pattern.compile(".*href=\"(.*ad)(.*yg)\"");
        //Pattern pattern = Pattern.compile("World!");
       // Matcher matcher = pattern.matcher(str);
        //System.out.println(matcher.find());
       // System.out.println( matcher.group(1));

       // System.out.println(matcher.groupCount());
    }


    public static void t1(){
        JFrame frame = new JFrame("JLable Test") ;
        Container container=frame.getContentPane();  //取得当前窗体的容器
        JLabel lab = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
        container.add(lab) ;                // 将组件件入到窗体的容器中

        Dimension dim = new Dimension() ;
        dim.setSize(400,200) ;              //窗体的大小
        frame.setSize(dim) ;                //设置窗体大小
        Point point = new Point(500,100) ;  // 设置坐标
        frame.setLocation(point) ;          //设置窗体坐标
        frame.setVisible(true) ;            //设置窗体可见
    }

    public static void t2(){
        JFrame frame = new JFrame("JLable Test") ;
        JLabel lab = new JLabel("我是一个标签",JLabel.CENTER) ;   // 实例化标签对象
        frame.add(lab) ;    // 将组件件入到面板之中
        frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色

        Dimension dim = new Dimension() ;
        dim.setSize(400,200) ;              //窗体的大小
        frame.setSize(dim) ;                //设置窗体大小
        Point point = new Point(500,100) ;  // 设置坐标
        frame.setLocation(point) ;          //设置窗体坐标
        frame.setVisible(true) ;            //设置窗体可见
    }





}
