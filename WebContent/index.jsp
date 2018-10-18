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
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<script type="text/javascript">
	var msg="${requestScope.msg}";
	if(msg.trim().length!=0){
		alert(msg);
	}
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
    		<ul class="top_lr">
            	<li><a href="login.jsp" style="color: red;">亲,请登入</a></li>
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
    	<a href="index.jsp"><img src="images/logo.png"></a>
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
            	<a href="user/userinfo.jsp">个人信息</a>
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
           	  <a href="emptyCar.html">去购物车结算</a>
              <span class="sj_right"> </span>
            </div>
        </div>
    </div>
    <!--头部导航-->
    <div class="nav_top">
    	<div class="nav_top_center">
            <div>
                全部图书分类
            </div>
            <ul>
            	<c:forEach items="${applicationScope.categorys}" var="category">
            		<li><a href="CateSer?cate_id=${category.id}">${category.name}</a></li>
            	</c:forEach>
            </ul>
        </div>
    </div>
    
	<div class="container3">
    	<div class="c3_b1">
        	<div class="c3_b1_left">
            	<c:forEach items="${applicationScope.categorys}" var="category">
            		<dl>
               			<dd>
            				<h1>${category.name}</h1>
            				<p>
            					<c:forEach items="${category.detail}" var="cate_detail">
                        			<a href="Cate_detailSer?cate_detail_id=${cate_detail.id}">${cate_detail.name}</a>
                      			</c:forEach>
                      		</p>
                  	 	 </dd>
              		 </dl>
            	</c:forEach>
            </div>
            <div class="c3_b1_center">
            	<div>
                	<a href="viewBook.html"><img src="images/ad1.png"></a>
                </div>
                <div class="c3_b1_c_bottom">
                    <ul>
                        <li>
                           <a href="viewBook.html"><img src="images/p01.png"/></a>
                           <a href="viewBook.html">Java从入门到精通</a>  
                        </li>
                       <li>
                           <a href="viewBook.html"><img src="images/p01.png"/></a> 
                           <a href="viewBook.html">Java从入门到精通</a> 
                        </li>
                        <li>
                           <a href="viewBook.html"><img src="images/p01.png"/></a> 
                           <a href="viewBook.html">Java从入门到精通</a> 
                        </li>
                    </ul>
            	</div>
            </div>
            <div class="c3_b1_right">
            	<h1>杰普快报</h1>
            	<ul>
            		<c:forEach items="${applicationScope.reports}" var="report">
                		<li><a href="ListResportDetail?report_id=${report.id}">${report.name}</a></li>
                	</c:forEach>
                </ul>
            </div>
            <div style="clear:both"></div>
        </div>
     </div>
    <div class="c20"></div>
    <jsp:include page="foot.jsp"></jsp:include>

</body>
</html>
