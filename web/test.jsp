<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form action="/ProjectX_war/upload/upload.do" method="post" enctype="multipart/form-data">
    文件1: <input type="file" name="myfiles"/><br/>
    文件2: <input type="file" name="myfiles"/><br/>
    文件3: <input type="file" name="myfiles"/><br/>
    <input type="submit" value="上传">
</form>
<form action="/ProjectX_war/fileDownload/download">
    <input TYPE="text" name="fileName">
    <input type="submit" value="下载">
</form>
</body>
</html>