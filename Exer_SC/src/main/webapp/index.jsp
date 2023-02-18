<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div style="text-align: right;float: right">
    <div style="float: left;font-size: 50px">${user.nickname}</div>
    <img src="${user.avatar}" width="50px" height="50px" style="border-radius: 25px"/></br>
    <a href="/" style="float: right">退出</a>
</div>
<div style="text-align: center">
    <h2>所有图书信息</h2>
</div>
<table width="90%" border="2" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td align="center"><img src="${book.cover}" style="width: 300px;height: 300px;"/></td>
            <td style="font-size: x-large;text-align: center">${book.name}</td>
            <td style="font-size: x-large;text-align: center">${book.author}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
