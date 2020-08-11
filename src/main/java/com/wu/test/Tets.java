package com.wu.test;

import com.wu.asy.EmailTaskHandler;
import com.wu.config.TaskConfig;
import org.apache.commons.collections4.Get;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Tets {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      /*  ApplicationContext xml = new AnnotationConfigApplicationContext(TaskConfig.class);
        EmailTaskHandler bean = xml.getBean(EmailTaskHandler.class);
        bean.sendEmail();
        System.out.println(bean.s());
        //Future<String> callback = bean.callback();
        System.out.println(bean.restustring());


        System.out.println("测试调用异步");*/
       // System.out.println(callback.get());
       /* System.out.println(isVersionLatested("B.1","C.1"));
        System.out.println(isVersionLatested("B.1","B.1"));*/
       // AtomicInteger in = new AtomicInteger(5);
        //Yuclose cl = new Yuclose();
       /*a(in);
        System.out.println(in.get());
        Scanner a = new Scanner(System.in);
        String a1 = a.next();*/
        List<Yuclose> data =new ArrayList<>();
        Yuclose y1 = new Yuclose("y1",null);
        Yuclose y2 = new Yuclose("y1","y1-child1");
        Yuclose y3 = new Yuclose("y1","y1-child2");
        Yuclose y4 = new Yuclose("y2",null);
        Yuclose y5 = new Yuclose("y3",null);
        Yuclose y6 = new Yuclose("y3","y3-child2");
        Yuclose y7 = new Yuclose("y3","y3-child3");
        Yuclose y8 = new Yuclose("y3","y3-child4");
        Yuclose y9 = new Yuclose("y4",null);
        Yuclose y10 =new Yuclose("y4","y4-child1");
        Yuclose y11= new Yuclose("y4","y4-child2");
        Yuclose y12= new Yuclose("y4","y4-child3");
        Yuclose y13= new Yuclose("y5",null);
        data.add(y1);
        data.add(y2);
        data.add(y3);
        data.add(y4);
        data.add(y5);
        data.add(y6);
        data.add(y7);
        data.add(y8);
        data.add(y9);
        data.add(y10);
        data.add(y11);
        data.add(y12);
        data.add(y13);
        List<List<Yuclose>> listData =new ArrayList<>();
        Yuclose parent = null;
        List<Yuclose> childList = null;
        Yuclose next =  data.get(0);
        for (int i = 1; i < data.size()+1; i++) {
            String child =  next.getChild();;
            if(child==null || child.isEmpty()){
                //说明是父件
                parent = next;
                childList = new ArrayList<>();

            }else{
                //子件，记录
                childList.add(next);
            }
            if(i<data.size()) {
                next = data.get(i);
            }
            String nextChild = next.getChild();
            if(nextChild==null || nextChild.isEmpty() || i==data.size()){
                //下一个是父件，把之前那个先加上
                List<Yuclose> ui = new ArrayList<>();
                ui.add(parent);
                ui.addAll(childList);
                listData.add(ui);
            }

        }
        System.out.println(listData.toString());
        for (int i = 0; i < listData.size(); i++) {
            List<Yuclose> yucloses = listData.get(i);
            Yuclose parent1 = yucloses.get(0);
            List<Yuclose> child = new ArrayList<>();
            if(yucloses.size()>1){
                child = yucloses.subList(1,yucloses.size());
            }
            System.out.println(parent1.getParent() +">>>>"+ parent1.getChild());
            for (int j = 0; j < child.size(); j++) {
                System.out.println(parent1.getParent() +">>>>"+ child.get(j).getChild());
            }
        }

    }

    private static void a(AtomicInteger t){
        t.set(t.get()+1);
    }
    private static int isVersionLatested(String lcfcVersion, String lnvVersion) {

        char[] lcfcArr = lcfcVersion.toCharArray();
        char[] lnvArr = lnvVersion.toCharArray();
        int lcfcV = Integer.parseInt(String.valueOf((int)lcfcArr[0]));
        int lnvV = Integer.parseInt(String.valueOf((int)lnvArr[0]));

        //第一位大版本比较:B > A
        //如果数据库中的版本比ECfile中的版本大
        if(lcfcV>lnvV){
            return -1; //""
        }else if (lnvV>lcfcV){//如果ECfile中的版本比数据库的版本大
            return 1; //""
        }
        //比较小版本
        String lcVersion = lcfcVersion.substring(lcfcVersion.indexOf(".")+1, lcfcVersion.length());
        String lnVersion = lnvVersion.substring(lnvVersion.indexOf(".")+1, lnvVersion.length());
        lcfcV = Integer.parseInt(lcVersion);
        lnvV = Integer.parseInt(lnVersion);
        if(lcfcV>lnvV){ //如果数据库中的版本比ECfile中的版本小
            return -1;
        }else if (lnvV>lcfcV){////如果ECfile中的版本比数据库的版本大
            return 1;  //
        }else if(lnvV == lcfcV) {
            return 0; //0
        }

        return 1;

    }
}
