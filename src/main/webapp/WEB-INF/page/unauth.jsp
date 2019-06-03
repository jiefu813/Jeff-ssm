<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>权限不足</title>
    <link rel="icon" type="image/x-icon" href="${path}/static/images/jie.png" />
</head>
<body>
    <div>
        <img src="${path}/static/images/unauth.jpg">
    </div>
</body>
</html>
