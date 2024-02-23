<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>今日のおみくじ</title>
    </head>
    <body>
        <h1>今日のおみくじ</h1>
            <form method="POST" action="/first_webapp/OmikujiServlet">
                <p>氏名<br><input type="text" name="name"></p>
                <button type="submit">占う！</button>
            </form>
    </body>
</html>