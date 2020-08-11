package com.wu.sql.model;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;

//@ApiModel
public class Role implements Serializable {
   // @ApiModelProperty(value="编号",required = true,dataType = "int")
    private String id;
   // @ApiModelProperty(value="name",required = false,dataType = "String")
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
