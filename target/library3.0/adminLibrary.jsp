<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            <a>
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
                    <a><span class="glyphicon glyphicon-search">&nbsp;图书索引号搜索</span></a>
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
                        <span class="menu-text">当前用户——${sessionScope.adminName}</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/login.jsp">
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
                <li>
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
                    <h1><small>新增操作</small></h1>
                </div>
            </div>

            <div class="container">
                <div class="col-md-12 column">
                    <div class="page-header">
                        <h2><small>当前管理员--${sessionScope.adminName}</small></h2>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="col-md-8 column">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/book/addBook">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">书名</label>
                            <div class="col-sm-10">
                                <input type="text" name="bookName" class="form-control" id="inputEmail3">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="id" class="col-sm-2 control-label">作者</label>
                            <div class="col-sm-10">
                                <input type="text" name="author" class="form-control" id="id">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ISBN" class="col-sm-2 control-label">索引号</label>
                            <div class="col-sm-10">
                                <input type="text" name="ISBN" class="form-control" id="ISBN">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Email" class="col-sm-2 control-label">摘要</label>
                            <div class="col-sm-10">
                                <input name="summary" type="text" class="form-control" id="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="language" class="col-sm-2 control-label">语种</label>
                            <div class="col-sm-10">
                                <input name="language" type="text" class="form-control" id="language">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="status" class="col-sm-2 control-label">状态</label>
                            <div class="col-sm-10">
                                <input name="a" type="text" class="form-control" id="status">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bookNum" class="col-sm-2 control-label">数量</label>
                            <div class="col-sm-10">
                                <input name="bookNum" type="text" class="form-control" id="bookNum">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">添加</button>
                                <span style="color: green; font-family: 'Droid Sans';font-weight: bold">${msg}</span>
                            </div>
                        </div>
                    </form>
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

