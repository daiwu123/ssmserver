package com.wu.sql.mapper;

import com.wu.sql.model.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/*@CacheNamespace(blocking = true,flushInterval = 1000*60*3,size = 512)*/
public interface UserMapper {
    List<Role> queryInfoAll();

    @Select("select * from role where id = #{id}")
    @Options(flushCache = Options.FlushCachePolicy.DEFAULT)
    @ResultType(Role.class)
    Role queryInfoById(@Param("id") Integer id);
}
