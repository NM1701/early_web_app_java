<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>お問い合わせフォーム</title>
    </head>
    <body>
        <h1>お問い合わせフォーム</h1>
        <form method="POST" action="/first_webapp/InquiryServlet">
            <label for="username">氏名</label><br />
            <input type="text" name="username" />
            <br /><br />

            <label for="usermail">メールアドレス</label><br />
            <input type="text" name="usermail" />
            <br /><br />

            <label for="content">お問い合わせ内容</label><br />
            <textarea rows="5" cols="25" name="content"></textarea>
            <br /><br />

            <button type="submit">送信</button>
        </form>
    </body>
</html>