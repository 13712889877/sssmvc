<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
    <title>会员修改</title>
    <link rel="stylesheet" type="text/css" href="admin/assets/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css"/>
</head>
<body>
<div class="container">
    <div class="toolbar">
        <div class="crumbs">
            <a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
            <a style="text-align:right">欢迎您，${sessionScope.user.username}</a>
        </div>
        <div class="action">
            <a href="<%=basePath%>customer/list" class="btn" target="_self">返回列表</a>
        </div>
    </div>
    <div class="mod">
        <div class="bd">
            <form action="/customer/edit" method="post">
                <table class="ui-table">
                    <tbody>
                    <tr>
                        <input hidden id="customer_id" name="customerId" value="${customer.customerId}"/>
                        <th width="120"><label >客户名称:</label></th>
                        <td>
                            <input type="text" id="customer_name" name="customerName" value="${customer.customerName}"  maxlength="100"/>
                            <span class="required">*</span>
                        </td>
                        <th width="120"><label>电子邮箱:</label></th>
                        <td>
                            <input type="text" size="30" id="customer_email" name="customerEmail" value="${customer.customerEmail}">
                        </td>
                        <td>
                            <select id="ec_user_id" name="ecUserId">
                                <option value="">=请选择销售=</option>
                                <c:forEach items="${userList}" var="user">
                                   <c:choose>
                                    <c:when test="${customer.ecUserId eq user.id}">
                                        <option value="${user.id}" selected="selected">${user.username}</option>
                                    </c:when>
                                       <c:otherwise >
                                           <option value="${user.id}">${user.username}</option>
                                       </c:otherwise>
                                   </c:choose>

                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <th width="120"><label>客户住址:</label></th>
                    <td>
                        <input type="text" size="30" id="customer_address" name="customerAddress"  value="${customer.customerAddress}"/>
                    </td>
                    </tr>
                    <tr>
                        <th><label>客户类型:</label></th>
                        <td><input type="text" id="customer_type" name="customerType" maxlength="100" value="${customer.customerType}"/></td>
                    </tr>
                    <tr>
                        <th><label>客户手机:</label></th>
                        <td><input type="text" id="customer_tel" name="customerTel" maxlength="50" value="${customer.customerTel}"/></td>
                    </tr>
                    <tr>
                        <td colspan="4" class="tc">
                            <button type="submit" class="btn" name="button1" id="button1">提交</button>
                            <button type="reset" class="btn" name="button2" id="button2">重置</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <!-- /.mod-bd -->
        <div class="ft"></div>
        <!-- /.mod-ft -->
    </div>
    <!-- /.mod -->
</div>
<!-- /.container  -->
</body>
</html>
