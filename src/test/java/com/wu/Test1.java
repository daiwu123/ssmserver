package com.wu;

import com.wu.aop.*;
import com.wu.m.SelfStatus;
import com.wu.service.RoleService;
import com.wu.sql.model.Role;
import com.wu.util.ExcelUtil;
import com.wu.util.po.FunctionConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test1 {
    @Autowired
    RoleService roleService;
    @Autowired
    ExcelUtil excelUtil;
    @Autowired
    Book book;
    @Autowired
    Transervice transervice;
    @Autowired
    TranserviceImpl1 transerviceImpl1;
    @Autowired
    TransactionAop transactionAop;
    @Autowired
    TransactionAop1 transactionAop1;
    @Test
    public void test() {
        List<Role> roles = roleService.queryInfo();
        System.out.println(roles.toArray().length);
    }

    @Test
    public void test1() {
        String a = "1233.zip";
        String v = "1233.s";
        System.out.println(a.matches(".*\\.zip"));
        System.out.println(v.matches(".*\\.zip"));


    }

    @Test
    public void test2() {
        System.out.println(excelUtil.sttus(SelfStatus.node1));
       /* bm b = new bm("1",null);
        bm b1 = new bm("2",null);
        bm b2 = new bm();
        bm b3= new bm();
        bm b4 = new bm();
        bm b5 = new bm();
        bm b6 = new bm();
        String a = "1233.zip";
        String v = "1233.s";
        System.out.println(a.matches(".*\\.zip"));
        System.out.println(v.matches(".*\\.zip"));*/


    }

    @Test
    public void test3() {
        DecimalFormat text = new DecimalFormat("0000");
        int o = 1;
        String format = text.format(o);
        System.out.println(format);
       /* bm b = new bm("1",null);
        bm b1 = new bm("2",null);
        bm b2 = new bm();
        bm b3= new bm();
        bm b4 = new bm();
        bm b5 = new bm();
        bm b6 = new bm();
        String a = "1233.zip";
        String v = "1233.s";
        System.out.println(a.matches(".*\\.zip"));
        System.out.println(v.matches(".*\\.zip"));*/


    }

    @Test
    public void test4() {
        FunctionConfig config = new FunctionConfig("1", "1");
        FunctionConfig config1 = new FunctionConfig("2", "2");
        FunctionConfig config2 = new FunctionConfig("3", "3");
        FunctionConfig config3 = new FunctionConfig("4", "4");
        FunctionConfig config4 = new FunctionConfig("5", "5");
        FunctionConfig config5 = new FunctionConfig("5", "56");
        List<FunctionConfig> configs = new ArrayList<>();
        configs.add(config);
        configs.add(config1);
        configs.add(config2);
        configs.add(config3);
        configs.add(config4);
        configs.add(config5);
        Map<String, String> collect = configs.stream().collect(Collectors.toMap(FunctionConfig::getBasicName, FunctionConfig::getFunction));
        System.out.println(collect.toString());
    }

    @Test
    public void test5() {
        Map<String, String> m = new HashMap<>();
        m.put(null, "q");
        System.out.println(m.size());

    }

    @Test
    public void test6() throws InterruptedException {
        long strat = System.currentTimeMillis();
        Thread.sleep(1000 * 30);
        System.out.println("-----------------");
        long end = System.currentTimeMillis();
        long timedifference = end - strat;
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(timedifference));
        int i = instance.get(Calendar.MINUTE);
        System.out.println(i);
    }


    @Test
    public void test7() throws InterruptedException {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        a.add("6");
        a.add("7");
        a.add("8");
        List<String> target = null;
        for (int i = 0; i < a.size(); i++) {
            target = new ArrayList<>();
            String s = a.get(i);
            List<String> strings = a.subList(0, i);
            List<String> strings1 = a.subList(i+1, a.size());
            target.addAll(strings);
            target.addAll(strings1);
            System.out.println(target.toString());
        }


    }

    @Test
    public void test8(){
        StringBuffer s = new StringBuffer();
        s.append(",,,,,,,");
        s.deleteCharAt(0);
        System.out.println(s.toString());
    }

    @Test
    public void test9(){
        String list = "\"[sadadadadadadada]]\"";
        String s = list.replaceAll("\"|\\[|\\]", "");

        System.out.println(s.toString());
    }

    @Test
    public void test10(){
        book.addAop();
    }

    @Test
    public void test11(){
        Integer u = OrderUtils.getOrder(TransactionAop.class);
        Integer n = OrderUtils.getOrder(TransactionAop1.class);
        System.out.println(u +"::"+n);
        System.out.println( transerviceImpl1.addData("张三","123"));
    }





}


