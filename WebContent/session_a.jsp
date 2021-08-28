<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% request.getSession().setAttribute("username", "田中"); %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>セッションスコープのテスト</title>
    </head>
    <body>
        <h1>ログインしました</h1>
        <p><a href="session_b.jsp">次のページへ</a></p>
    </body>
</html>