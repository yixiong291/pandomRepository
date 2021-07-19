<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" >
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1><small>用户列表</small></h1>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>密码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${pageInfo.list}">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.pwd}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <div class="box-tools pull-right">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/users/allUser?page=1&size=5" aria-label="Previous" aria-label="Previous">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/allUser?page=${pageInfo.pageNum-1}&size=5">上一页</a></li>
                    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
                        <li><a href="${pageContext.request.contextPath}/users/allUser?page=${pageNum}&size=5">${pageNum}</a></li>
                    </c:forEach>
                    <li><a href="${pageContext.request.contextPath}/users/allUser?page=${pageInfo.pageNum+1}&size=5">下一页</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/allUser?page=${pageInfo.pages}&size=5" aria-label="Next">尾页</a></li>
                </ul>
            </div>
            </table>

        </div>
        </div>
    </div>
</div>
</body>
</html>
