package com.wu.mybatis;


import com.wu.po.Money1;
import com.wu.po.Pop;
import com.wu.sql.mapper.Money1Mapper;
import com.wu.sql.mapper.PopMapper;
import com.wu.sql.mapper.UserMapper;
import com.wu.sql.model.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

public class MyBatisSessionFactory {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //test2();
        test3();
    }


    public static void test3() throws IOException {
        //（1）配置文件位置
        String mybatisConfigPath = "mybatis/spring-mybaties1.xml";
        //（2）加载配置文件
        InputStream configInput = Resources.getResourceAsStream(mybatisConfigPath);
        //（3）根据配置文件获取sqlSessionFactory
        SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(configInput);
        //(4)获取sqlSession
        SqlSession sqlsession = sessionFactory.openSession();

        SqlSession sqlsession2= sessionFactory.openSession();

        PopMapper popMapper = sqlsession.getMapper(PopMapper.class);
        Pop pop = popMapper.queryNumberById(1);

        System.out.printf("第一次查询-->%s\n",pop.getNumber());
        sqlsession.commit();
        Money1Mapper money1Mapper = sqlsession2.getMapper(Money1Mapper.class);
        Money1 money1 = new Money1();
        money1.setId(1);
        money1.setNumber(16000);
        money1Mapper.updateById(money1);
        sqlsession2.commit();

        System.out.printf("修改之后-->%s\n",money1.getNumber());

        PopMapper  popMapper2= sqlsession2.getMapper(PopMapper.class);
        Pop pop2 = popMapper2.queryNumberById(1);

        System.out.printf("查询-->%s\n",pop2.getNumber());

    }


    public static void test2() throws IOException {
        //（1）配置文件位置
        String mybatisConfigPath = "mybatis/spring-mybaties1.xml";
        //（2）加载配置文件
        InputStream configInput = Resources.getResourceAsStream(mybatisConfigPath);
        //（3）根据配置文件获取sqlSessionFactory
        SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(configInput);
        //(4)获取sqlSession
        SqlSession sqlsession = sessionFactory.openSession();

        SqlSession sqlsession2 = sessionFactory.openSession();

        SqlSession sqlsession3 = sessionFactory.openSession();

        PopMapper popMapper = sqlsession.getMapper(PopMapper.class);

        PopMapper popMapper2= sqlsession2.getMapper(PopMapper.class);

        PopMapper popMapper3= sqlsession3.getMapper(PopMapper.class);

        Pop role =  popMapper.queryById(4);
        System.out.println("==============cha====================="+role.getPassword());
        //sqlsession.commit();

       /* Pop pop = new Pop();
        pop.setPassword("daiwu111222");
        pop.setId(4);
        popMapper2.updateById(pop);
        System.out.println("============Update=======");
        sqlsession2.commit();*/

        Pop role2 =  popMapper.queryById(4);
        System.out.println("==============cha====================="+role2.getPassword());
        System.out.printf("%s,%s\n",role.getId(),role2.getId());

        /*UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        Role role =  userMapper.queryInfoById(1);
        System.out.printf("==============cha=====================");
        Role role2 =  userMapper.queryInfoById(1);
        System.out.printf("%s,%s\n",role.getRoleName(),role2.getRoleName());*/
    }



    public static void test1() throws IOException {
        //（1）配置文件位置
        String mybatisConfigPath = "mybatis/spring-mybaties1.xml";
        //（2）加载配置文件
        InputStream configInput = Resources.getResourceAsStream(mybatisConfigPath);
        //（3）根据配置文件获取sqlSessionFactory
        SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(configInput);
        //(4)获取sqlSession
        SqlSession sqlsession = sessionFactory.openSession();


        //(5)获取映射接口
        // UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        //（6）执行mapper.xml中的方法
        //List<Role>  result = userMapper.queryInfoAll();

        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);


        Role role =null;
               /* userMapper.queryInfoById();*/
        System.out.println("==============================");

        PopMapper popMapper =  sqlsession.getMapper(PopMapper.class);
        Pop pop = new Pop();
        pop.setName("肖航");
        pop.setAccount("xiaohang1234");
        pop.setPassword("123456789");
        pop.setIDCard("19981122");
        int id = popMapper.insertRow2(pop);
        sqlsession.commit();
        System.out.printf("新增得到的对象id:: %s,\n",pop.getId());
        System.out.println("==============================");
        Role role2 = null;
                /*userMapper.queryInfoById(1);*/
        System.out.printf("%s,%s\n",role.getRoleName(),role2.getRoleName());
        /*result.forEach(x->{
            System.out.println(x.getRoleName());
        });*/
        configInput.close();
        sqlsession.close();
    }
}
