<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9)  ]><!--><html lang="zh-CN"><!--<![endif]-->
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会员管理添加</title>
    <link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
    <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
    <script src="admin/assets/js/common.js" type="text/javascript"></script>
    <script type="text/javascript">
        //删除一个数据
        function optDelete(id) {
            if(Pony.checkedCount("ck") <= 0) {
                alert("请选择您要操作的数据!");
                return;
            }
            if(!confirm("您确定删除吗？")) {
                return;
            }
            window.location = "<%=basePath%>member/o_delete.do?id="+id;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="toolbar">
        <div class="crumbs">
            <a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
        </div>
        <div class="action">
            <a href="member/v_add.do" class="btn" target="_self">添加</a>
        </div>
    </div>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">客户名称</label>
            <div class="layui-input-block">
                <input name="customerName" id="customerName" lay-verify="text"
                       autocomplete="off" placeholder="请输入昵称" class="layui-input"
                       type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-block">
                <input name="customerType" id="customerType" lay-verify="required" placeholder="请输入" autocomplete="off"
                       class="layui-input"
                       type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户电话</label>
                <div class="layui-input-inline">
                    <input name="customerTel" id="customerTel" lay-verify="required|phone" autocomplete="off"
                           class="layui-input" type="tel">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户邮箱</label>
                <div class="layui-input-inline">
                    <input name="customerEmail" id="customerEmail" lay-verify="email" autocomplete="off" class="layui-input"
                           type="text">
                </div>
            </div>
        </div>

        <div class="">
            <div class="">
                <label class="">客户地址</label>
                <div class="">
                    <input name="customerAddress" id="customerAddress" lay-verify="required|text" autocomplete="off"
                           class="layui-input" type="text">
                </div>
            </div>
        </div>
        <div class="">
            <div class="">
                <button class="" lay-submit="" lay-filter="demo1"><input class='customer '
                                                                         type="hidden" value=""/>完成
                </button>
                <button type="reset" class="">重置</button>
            </div>
        </div>
    </form>
    <!-- /.mod -->
</div>
<!-- /.container  -->
</body>
</html>
