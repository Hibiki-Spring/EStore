<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath %>"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-详情页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<style>
	.container3{
		border:1px solid #ccc;
		height:400px;
		padding: 10px
	}
	.container3 div{
		width: 60%;
		margin:10px 0 20px 300px;
		background-color: #C5131E;

	}
	.container3 div span{
		margin-left: 70px;
		font-size: 14px;
		color:#fff;
	}
	.container3 h1{
		font-size: 18px;
		text-align: center
	}
	.container3  pre{
		width: 100%;
		 white-space: pre-wrap;
		 font-size: 14px;
		 line-height: 30px
	}
</style>
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
    		<ul class="top_lr">
            	<li><a href="login.html" style="color: red;">亲,请登入</a></li>
                <li><a href="register.html">免费注册</a></li>
            </ul>
            <ul class="top_bars">
                <li><a href="confirmList.html">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="index.html"><img src="images/logo.png"></a>
    	<div class="h3_center">
        	<div class="search_box">
            	<input type="text"/>
                <span>搜索</span>
            </div>
           <p>
            	<c:forEach items="${applicationScope.categorys}" var="category">
            		<a href="CateSer?cate_id=${category.id}">${category.name}</a>
            	</c:forEach>
            </p>
        </div>
        <div class="h3_right">
        	<div class="myyy">
            	<a href="userinfo.html">个人信息</a>
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
           	  <a href="emptyCar.html">去购物车结算</a>
              <span class="sj_right"> </span>
            </div>
        </div>
    </div>
    <div class="container3">
    	<h1>${requestScope.report.name}</h1>
    	<div>
    		<span>更新时间：${requestScope.report.publish_date}</span>
    		<span>发布单位：${requestScope.report.department}</span>
    		<span>发布人：${requestScope.report.publish_writer}</span>
    	</div>
    	<pre>
    		${requestScope.report.content}
    	</pre>
    </div>
   
    <div class="c20"></div>
    <jsp:include page="foot.jsp"></jsp:include>

</body>
</html>
