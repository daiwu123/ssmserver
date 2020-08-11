package com.wu.sql.mapper;

import com.wu.po.Pop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PopMapper {
    Pop queryAllPop(@Param("account") String account, @Param("password") String password);

    Pop queryById(@Param("id") Integer id);

    Pop queryNumberById(@Param("id") Integer id);

    int updateById(Pop pop);
   /* @Select("select  * from Pop where account=#{account} and password=#{password}")
   Pop queryAllPop(@Param("account") String account, @Param("password") String password);*/
    int insertRow(Pop pop);

    int insertRow2(Pop pop);



}
