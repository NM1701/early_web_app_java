<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:import url="WEB-INF/app.jsp">
    <c:param name="title">インポートのテスト A</c:param>
    <c:param name="content">
        <h2>こんにちは！</h2>
        <p>今日はいい天気ですね。</p>
    </c:param>
</c:import>