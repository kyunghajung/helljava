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
        <h2>글쓰기</h2>
        <div class="form-group">
            <form action="/board/write" method="POST">
                <table class="table">
                    <tr>
                        <td>
                            <label for="title">제목</label>
                            <input type="text" id="title" name="title" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="writer">글쓴이</label>
                            <input type="text" id="writer" name="writer" class="form-control" value="${writer}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="content">내용</label>
                            <textarea class="form-control" rows="5"  id="content" name="content"></textarea>
                        </td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-default">글쓰기</button>
            </form>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>