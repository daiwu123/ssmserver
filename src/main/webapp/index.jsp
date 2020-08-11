<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2019/12/4
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello Word
<form method="POST"  enctype="multipart/form-data" id="form1" action="up/yu">

    <label>上传文件: </label>
    <input type="file"  name="upFile"><br>
    <input type="text" name="description"><br>
    <input type="submit" value="表单提交">
    <input type="button" value="ajax提交" id="btn" name="btn" >

</form>
</body>
</html>
