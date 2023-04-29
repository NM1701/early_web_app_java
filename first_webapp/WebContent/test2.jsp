<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>JSPのテスト</title>
    </head>
    <body>
        <%-- 変数の表示 --%>
        <%
        int a = 3;
        int b = 2;
        int c = a + b;
        %>
        <p>c = <%= c %></p>

        <%-- 条件分岐 --%>
        <% int d = 40; %>
        <% if(d >= 60){ %>
            <p>合格です！</p>
        <% } else{ %>
            <p>赤点です...補講を行います</p>
        <% } %>

        <%-- 繰り返し --%>
        <% for(int i = 0; i < 10; i++){ %>
            <p>i = <%= i %></p>
        <% } %>
    </body>
</html>