<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>セッションスコープのテスト</title>
    </head>
    <body>
        <h1>こんにちは、 <c:out value="${sessionScope.username}" /> さん！</h1>
        <p><a href="session_c.jsp">次のページへ</a></p>
    </body>
</html>