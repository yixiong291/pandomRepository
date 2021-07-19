<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书名搜索</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/library_nav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <style>
        #content1{
            position: absolute;
            border: 1px solid red;
            right: 0px;
            width: 85.3%;
            height:100%;
        }
        .input-group-addon{
            width: 100px;
        }
    </style>
</head>
<body>
<div class="page-sidebar">
    <ul class="nav panel-group sidebar-menu" id="nav_parent">
        <li class="panel">
            <a >
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text"> library---菜单导航 </span>
            </a>
        </li>
        <li class="panel">
            <a class="panel-heading collapsed" href="#collapse1" data-toggle="collapse" data-parent="#nav_parent">
                <i class="menu-icon glyphicon glyphicon-fire"></i>
                <span class="menu-text">library---图书搜索</span>
                <i class="glyphicon glyphicon-chevron-right menu-expand"></i>
            </a>
            <ul class="nav submenu collapse" id="collapse1">
                <li>
                    <a href="${pageContext.request.contextPath}/readerLibrary.jsp"><span class="glyphicon glyphicon-search">&nbsp;&nbsp;图书索引号搜索</span></a>
                </li>
                <li>
                    <a class="panel-heading collapsed" href="#collapse2" data-toggle="collapse">
                        <span class="menu-text">library---其他搜索</span>
                        <i class="glyphicon glyphicon-chevron-right menu-expand"></i>
                    </a>
                    <ul class="nav submenu collapse" id="collapse2">
                        <li>
                            <a href="${pageContext.request.contextPath}/searchByNa.jsp">
                                <i class="menu-icon glyphicon glyphicon-stats"></i>
                                <span class="menu-text">书名搜索</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/serByAuthor.jsp">
                                <i class="menu-icon glyphicon glyphicon-stats"></i>
                                <span class="menu-text">作者搜索</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/book/allBook">
                        <span class="menu-text">展示全部书籍</span>
                    </a>
                </li>
                <li>
                    <a>
                        <span class="menu-text">当前用户——${sessionScope.username}</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/readerLibrary.jsp">
                        <span class="menu-text">退出---exist</span>
                    </a>
                </li>
            </ul>
        </li>
        <li class="panel">
            <a class="panel-heading collapsed" href="#collapse5" data-toggle="collapse" data-parent="#nav_parent">
                <i class="menu-icon glyphicon glyphicon-link"></i>
                <span class="menu-text">library--读者操作</span>
                <i class="glyphicon glyphicon-chevron-right menu-expand"></i>
            </a>
            <ul class="nav submenu collapse" id="collapse5">
                <li>
                    <a href="${pageContext.request.contextPath}/reader/showByName?name=${sessionScope.username}"><span class="menu-text">library--个人资料</span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/borrow/show?name=${sessionScope.username}"><span class="menu-text"> library--借阅的书籍</span></a>
                </li>
                    <a class="panel-heading collapsed" href="#collapse6" data-toggle="collapse">
                        <span class="menu-text">Multi Level Menu</span>
                        <i class="glyphicon glyphicon-chevron-right menu-expand"></i>
                    </a>
                    <ul class="nav submenu collapse" id="collapse6">
                        <li>
                            <a href="#">
                                <i class="menu-icon glyphicon glyphicon-stats"></i>
                                <span class="menu-text">Level 3</span>
                            </a>
                        </li>
                        <li>
                            <a class="panel-heading collapsed" href="#collapse7" data-toggle="collapse">
                                <i class="menu-icon glyphicon glyphicon-stats"></i>
                                <span class="menu-text">Level 4</span>
                                <i class="glyphicon glyphicon-chevron-right menu-expand"></i>
                            </a>
                            <ul class="nav submenu collapse" id="collapse7">
                                <li>
                                    <a href="#">
                                        <i class="menu-icon glyphicon glyphicon-stats"></i>
                                        <span class="menu-text">Some Item</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="menu-icon glyphicon glyphicon-stats"></i>
                                        <span class="menu-text">Another Item</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>
</div>
<div id="content1" >
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1><small>图书搜索</small></h1>
                </div>
            </div>

            <div class="container">
                <form action="${pageContext.request.contextPath}/book/showByName" method="post">
                    <div class="col-md-10 column from-group">
                        <div class="col-sm-10">
                            <span style="color: red; font-weight: bold">${err}</span>
                            <label for=" ">图书书名</label>
                            <div class="input-group col-sm-10">
                                <input type="text" class="form-control" name="bookName" onkeydown="onKeyDown(event)"/>
                            </div >
                            <br/>
                            <button><span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span></button>
                        </div>
                    </div>
                </form>
                <div class="container">
                    <div class="col-md-12 column">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>书名</th>
                                <th>作者</th>
                                <th>索引</th>
                                <th>语种</th>
                                <th>图书摘要</th>
                                <th>图书状态</th>
                                <th>图书数量</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="book1" items="${book}">
                                <tr>
                                    <td>${book1.bookName}</td>
                                    <td>${book1.author}</td>
                                    <td>${book1.ISBN}</td>
                                    <td>${book1.language}</td>
                                    <td>${book1.summary}</td>
                                    <td>${book1.status}</td>
                                    <td>${book1.bookNum}</td>
                                    <td><a href="${pageContext.request.contextPath}/borrow/borrowBook/?bookName=${book1.bookName}&ISBN=${book1.ISBN}&name=${sessionScope.username}"><button type="button" class="btn btn-info btn-default btn-sm"><span>图书借阅</span></button></a> <span style="color: green;font-family: 'Book Antiqua'">${succeed}</span></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function onKeyDown(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==27){ // 按 Esc
            //要做的事情
        }
        if(e && e.keyCode==113){ // 按 F2
            //要做的事情
        }
        if(e && e.keyCode==13){ // enter 键
            alert("此处回车触发搜索事件");
        }
    }

    $(function(){
        //点击菜单箭头变化
        $(".page-sidebar .sidebar-menu a").each(function(){
            $(this).click(function(){
                var Oele = $(this).children('.menu-expand');
                if($(Oele)){
                    if($(Oele).hasClass('glyphicon-chevron-right')){
                        $(Oele).removeClass('glyphicon-chevron-right').addClass('glyphicon-chevron-down');
                    }else{
                        $(Oele).removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-right');
                    }
                }
                //选中增加active
                if(! $(this).hasClass('panel-heading')){
                    $(".page-sidebar .sidebar-menu a").removeClass('active');
                    $(this).addClass('active');
                }
            });
        });
    })
</script>
</body>
</html>
