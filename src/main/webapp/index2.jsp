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
    <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
</head>
<body>
Hello Word
    <label>上传文件: </label>
    <input type="file"  name="upFile" id="fileu" multiple><br>
    <input type="text" name="description" id="description"><br>
    <input type="button" value="ajax提交" id="btn" name="btn" onclick="sub()" >


</body>
<script>
    //ajax提交方式
    function sub(){
        var files  = document.getElementById('fileu');
        var formData = new FormData();
        var description =  $('#description').val();
        var d = {"description":"sdada","aa":"bb"};
        formData.append("upFile",files.files[0]);
        //formData.append('map','av');
        $.ajax({
            type : 'POST',
            data:formData,
            url:'up/importZip',
            dataType:'json',
           // contentType:'application/json;charset=utf-8',
            processData:false,
             contentType:false,
            cache:false,
            //  async:false,
            success:function(data){

            },
            error:function(error){

            }

        })
    }

   /* function sub(){
        var files  = document.getElementById('fileu');
        var formData = new FormData();
        var description =  $('#description').val();
        var d = {"description":"sdada","aa":"bb"};
        formData.append("upFile",files.files[0]);
        formData.append('map',d);
        $.ajax({
            type : 'POST',
            data:JSON.stringify(d),
            url:'up/yu2',
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            //processData:false,
           // contentType:false,
            cache:false,
          //  async:false,
            success:function(data){

            },
            error:function(error){

            }

        })
    }*/
    /*function sub(){
        var files  = document.getElementById('fileu');
        var formData = new FormData();
        var description =  $('#description').val();
        var d = {"description":description,"aa":"bb"};
        formData.append("upFile",files.files[0]);
        formData.append('map',JSON.stringify(d));
        $.ajax({
            type : 'POST',
            data:formData,
            url:'up/yu1',
            dataType:'json',
            processData:false,
            contentType:false,
            cache:false,
            async:false,
            success:function(data){

            },
            error:function(error){

            }

        })
    }*/
</script>
</html>
