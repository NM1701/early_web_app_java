<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actCom" value="${ForwardConst.ACT_COM.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>コメント　一覧</h2>
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
        <br/>

        <div id="comments_list">
            <c:forEach var="comment" items="${comments}" varStatus="status">
                <fmt:parseDate value="${comment.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="commentTime" type="date" />

                    <h3>${comments_count - status.count - (10 * page) + 11}番目のコメント</h3>


                        <table id="comment_info" style="border:none;">
                            <tr style="border:none;">
                                <th class="comment_date" style="border:none;">日時　　　　　：</th>
                                <td class="comment_date" style="border:none;"><fmt:formatDate value="${commentTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
                            </tr>
                            <tr style="border:none;">
                                <th class="commentator" style="border:none;">氏名　　　　　：</th>
                                <td class="commentator" style="border:none;"><c:out value="${comment.commentator.name}" /></td>
                            </tr>
                            <tr style="border:none;">
                                <th class="comment_content" style="border:none;">コメント　　　：</th>
                                <td class="comment_content" style="border:none;"><c:out value="${comment.comment}" /></td>
                            </tr>
                        </table>
            </c:forEach>
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

        <p><a href="<c:url value='?action=${actCom}&command=${commNew}&id=${report.id}' />">コメントを書く</a></p>
        <p><a href="<c:url value='?action=${actRep}&command=${commShow}&id=${report.id}' />">日報詳細ページに戻る</a></p>

    </c:param>
</c:import>