<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actCom" value="${ForwardConst.ACT_COM.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commCrt" value="${ForwardConst.CMD_CREATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>コメント　登録ページ</h2>
        <p>（コメント対象の日報情報）</p>

         <table id="report_info">
            <tbody>
                <tr>
                    <th class="report_name">日報作成者</th>
                    <td class="report_name"><c:out value="${report.employee.name}" /></td>
                </tr>
                <tr>
                    <th class="report_title">日報タイトル</th>
                    <td class="report_title"><c:out value="${report.title}" /></td>
            </tbody>
        </table>
        <br /><br />

        <form method="POST" action="<c:url value='?action=${actCom}&command=${commCrt}&id=${report.id}' />">
            <c:if test="${errors != null}">
                <div id="flush_error">
                    入力内容にエラーがあります。<br />
                    <c:forEach var="error" items="${errors}">
                        ・<c:out value="${error}" /><br />
                    </c:forEach>
                </div>
            </c:if>
            <br /><br />

            <label for="name">コメント者　氏名</label><br />
            <c:out value="${sessionScope.login_employee.name}" />
            <br /><br />

            <label for="${AttributeConst.COM_CONTENT.getValue()}">コメント</label><br />
            <textarea name="${AttributeConst.COM_CONTENT.getValue()}" rows="10" cols="50">${comment.comment}</textarea>
            <br /><br />
            <input type="hidden" name="${AttributeConst.COM_ID.getValue()}" value="${comment.id}" />
            <input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
            <button type="submit">投稿</button>
        </form>

        <p><a href="<c:url value='?action=${actCom}&command=${commIdx}&id=${report.id}' />">コメント一覧ページに戻る</a></p>
        <p><a href="<c:url value='?action=${actRep}&command=${commShow}&id=${report.id}' />">日報詳細ページに戻る</a></p>
    </c:param>
</c:import>