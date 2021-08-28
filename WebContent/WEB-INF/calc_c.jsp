<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>三平方の定理による斜辺長さの算出</title>
    </head>
    <body>
        <p>直角をはさむ2辺の長さが<%= (double)request.getAttribute("a") %>と<%= (double)request.getAttribute("b") %>のとき、斜辺の長さは<%= (double)request.getAttribute("c") %>になります。</p>
    </body>
</html>