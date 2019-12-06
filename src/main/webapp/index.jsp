<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2019/11/29
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<body>
<h1>HI hi</h1>
<button id="btn1">ajax发送json数据</button>
<form method="post" enctype="multipart/form-data" action="/upload">
    文件1：<input type="file" name="uploadfile">
<input type="submit" value="上传">
</form>
<form enctype="multipart/form-data" method="post" action="/upload2">
    文件1：<input type="file" name="uploadfile">
    文件2：<input type="file" name="uploadfile">
    文件3：<input type="file" name="uploadfile">
    <input type="submit" value="上传">
</form>
<form method="post" enctype="multipart/form-data" id="form2">
    文件1：<input type="file" name="uploadfile" id="files1"><br>
    文件2：<input type="file" name="uploadfile"><br>
    文件3：<input type="file" name="uploadfile"><br>
    <input type="button" value="上传" id="btn">
</form>
<form method="post" action="sendmail" enctype="multipart/form-data">
选择文件：<input type="file" name="fujian">
    <input type="submit" value="发送邮件">
</form>
</body>
<script>
    $("#btn").click(function () {
       var fm= new FormData();
       fm.append("uploadfile",$("#files1")[0].files[0]);
       fm.append("name","掌握三");
       fm.append("age","15");
       console.log($("#files1")[0].files[0]);

        $.ajax({
            type:"post",
            url:"ajaxupload",
            data:fm,
            processData:false,
            contentType:false,
            success:function (data) {
                alert(data);
            }

        })
    });
</script>
<script>
    var user="name=装三&age=216&car.carname=奥迪&car.color=白色";
    var user1={name:"装三",age:216,car:{carname:"奥迪",color:"白色"}};
    $("#btn1").click(
        function () {
            // $.ajax({
            //     type:"post",
            //     url:"i6",
            //     contentType:"application/json",
            //     data:JSON.stringify(user),
            //     success:function (data) {
            //         console.log(data)
            //     }
            //
            // })
            $.ajax({
                type:"post",
                url:"i7",
                data:user,
                success:function (data) {
                    console.log(data)
                }

            })
        }
    )
</script>
</html>
