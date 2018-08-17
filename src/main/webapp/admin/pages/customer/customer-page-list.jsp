<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%><!DOCTYPE html>
<!--[if IE 6]><html class="ie6 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if IE 8]><html class="ie8 lte9 lte8" lang="zh-CN"><![endif]-->
<!--[if IE 9]><html class="ie9 lte9" lang="zh-CN"><![endif]-->
<!--[if IE 7]><html class="ie7 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9) ]><!--><html lang="zh-CN"><!--<![endif]-->
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>会员管理添加</title>
    <link rel="stylesheet" type="text/css" href="admin/assets/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css"/>
    <script src="admin/assets/js/common.js" type="text/javascript"></script>
    <script type="text/javascript">
        //删除一个数据
        function optDelete(id) {

            if (!confirm("您确定删除吗？")) {
                return;
            }
            window.location = "<%=basePath%>customer/delete?customerId=" + id;
        }
        //批量删除数据
        function optDeleteIn() {
            if (Pony.checkedCount("ck") <= 0) {
                alert("请选择您要操作的数据!");
                return;
            }
            if (!confirm("您确定删除吗？")) {
                return;
            }

            var ids = Pony.checkIn("ck");
            console.log(ids);
            window.location = "<%=basePath%>customer/deleteIn?ids=" + ids;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="toolbar">
        <div class="crumbs">
            <a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
            <a style="text-align:right">欢迎您，${sessionScope.user.username}</a>
        </div>
        <div class="action">
            <form action="/customer/salesSelect" method="post">
                <select id="ec_user_id" name="ecUserId" class="btn">
                    <option value="">=请选择销售查询=</option>
                    <c:forEach items="${userList}" var="user">
                        <option value="${user.id}">${user.username}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn" name="button1" id="button1">查询</button>
            </form>
            <a href="customer/beforeEdit?id=${pg.customerId}" class="btn" target="_self">添加</a>
            <a href="javascript:;" class="btn" onclick="optDeleteIn();">批量删除</a>
        </div>
    </div>

    <div class="mod">
        <div class="bd">
            <table class="ui-table">
                <thead>
                <tr>
                    <th width="30">
                        <input type="checkbox" name="ck_all" id="ck_all"
                               onclick="Pony.checkboxSlt('ck',this.checked);"/>
                    </th>
                    <th>负责销售</th>
                    <th>客户姓名</th>
                    <th>客户地址</th>
                    <th>客户邮箱</th>
                    <th>客户手机</th>
                    <th width="140">操作选项</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="pg" items="${customerPager.pageList}" varStatus="status">
                    <c:choose>
                        <c:when test="${status.index % 2 ==0 }">
                            <tr>
                        </c:when>
                        <c:otherwise>
                            <tr class="even">
                        </c:otherwise>
                    </c:choose>
                    <td class="tc"><input type='checkbox' name='ck' value='${pg.customerId}'/></td>
                    <td>${pg.username}</td>
                    <td>${pg.customerName}</td>
                    <td>${pg.customerAddress}</td>
                    <td>${pg.customerEmail}</td>
                    <td>${pg.customerTel}</td>
                    <td>
                        <a class="btn" href="customer/beforeEdit?id=${pg.customerId}">修改</a>
                        <a href="javascript:;" class="btn" onclick="optDelete(${pg.customerId});">删除</a>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /.mod-bd -->

        <!-- /.mod-ft -->
    </div>
    <!-- /.mod -->
</div>

<div class="page">

    <div>记录总数<span class="">${customerPager.total}</span> | 页数<span class="">${customerPager.totalPage}</span></div>
    <a class="btn" href="customer/list?pages=${customerPager.page-1}">上一页</a>
    <c:forEach var="s"  begin="1" end="${customerPager.totalPage}">
        <c:choose>
        <c:when test="${customerPager.page eq s}">
            <a class="btn" style="color: #C9282D">${s}</a>
        </c:when>
        <c:otherwise>
            <a href="customer/list?page=${s}" class="btn">${s}</a>
        </c:otherwise>
        </c:choose>
    </c:forEach>
    <div>当前页数：<span >${customerPager.page}</span></div>
    <a class="btn" href="customer/list?pages=${customerPager.page+1}">下一页</a>
</div>
<!-- /.container  -->
</body>
</html>
