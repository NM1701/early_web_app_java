<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actCom" value="${ForwardConst.ACT_COM.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>コメント　一覧</h2>
        <table id="comment_list">
            <tbody>
                <tr>
                    <th class="report_name">日報作成者</th>
                    <th class="report_title">日報タイトル</th>
                </tr>
                <c:forEach var="comment" items="${comments}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="report_name"><c:out value="${report.employee.name}" /></td>
                        <td class="report_title">${report.title}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="comments">
            <h3>番目のコメント</h3>

        </div>

        <div id="pagination">
            （全 ${comments_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((comments_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actCom}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='?action=${actCom}&command=${commNew}' />">コメントを書く</a></p>
        <p><a href="<c:url value='?action=${actRep}&command=${commIdx}' />">日報詳細ページに戻る</a></p>

    </c:param>
</c:import>