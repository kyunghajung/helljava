<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>자바지옥</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>로그인</h2>

    <div class="form-group">
        <form action="/login" method="POST">
            <table class="table">
                <tr>
                    <td>
                        <label for="id">아이디</label>
                        <input type="text" id="id" name="id" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="pwd">비밀번호</label>
                        <input type="password" id="pwd" name="pwd" class="form-control" />
                    </td>
                </tr>
            </table>
            <button type="submit" class="btn btn-default">로그인</button>
            <button type="button" class="btn btn-default" onclick="window.location='/join';">가입하기</button>
        </form>
    </div>


</div>


<!-- jQuery -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>

</html>