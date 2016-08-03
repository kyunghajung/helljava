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
            <h2>자바지옥</h2>
            <p class="bg-warning">
                - <strike>리스트, 검색이 되어야, (제목, 내용, 작성자, all)</strike><br>
                - <strike>상세페이지</strike><br>
                - <strike>게시물 crud, 페이징은 필요없음</strike><br>
                - <strike>로그인을 해야 글을 쓸 수 있음</strike><br>
                - <strike>로그아웃</strike> <br>
                - <strike>로그인</strike> <br>
                - 쿠키(아이디 유지)<br>
                - <strike>각종 유효성체크</strike><br>
                - 커맨트패턴<br>
                - 서비스 단 추가<br>
                - <strike>h2 디비붙이기 우선 리스트만 디비 붙여놓고 나머지 작업해야지</strike><br>
                - <strike>기능부터 만들자. (로그인, 가입 등)</strike><br>
                -
            </p>
            <table class="table table-bordered">
                <colgroup>
                    <col width="80%"/>
                    <col width="20%"/>
                </colgroup>
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>글쓴이</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="boadsList" items="${boadsList}">
                        <tr>
                            <td><a href="/board/read?seq=${boadsList.seq}">${boadsList.title}</a></td>
                            <td>${boadsList.writer}</td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>
        </div>

        <div class="container">
        <form action="/board/main" method="get">
            <table style="margin: auto;">
                <colgroup>
                    <col width="20%"/>
                    <col width="60%"/>
                    <col width="20%"/>
                </colgroup>
                <tbody>
                <tr>
                    <td>
                        <select class="form-control" name="findPart" id="findPart">
                            <option value="title">제목</option>
                            <option value="writer">글쓴이</option>
                            <option value="content">내용</option>
                            <option value="all">전체</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" id="findCont" name="findCont" class="form-control" />
                    </td>
                    <td>
                        <button type="submit" class="btn btn-default">검색</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>

        <c:choose>

            <c:when test="${memberYn == 'Y'}">
                <button type="button" class="btn btn-default" onclick="window.location='/board/write';">글쓰기</button>
                <button type="button" class="btn btn-default" onclick="window.location='/logout';">로그아웃</button>
            </c:when>

            <c:when test="${memberYn != 'Y'}">
                <button type="button" class="btn btn-default" onclick="window.location='/join';">회원가입</button>
                <button type="button" class="btn btn-default" onclick="window.location='/login';">로그인</button>
            </c:when>

        </c:choose>
        </div>
        <!-- jQuery -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </body>
</html>