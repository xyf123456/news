<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑新闻--管理后台</title>
<link href="<%=basePath%>/css/admin.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
</head>
<%
	String login = (String) session.getAttribute("login");
	if (login == null) {
		response.sendRedirect("../index.jsp");
	}
%>
<body>
	<div id="main">
	   <div>
	    <%--<iframe src="<%=basePath%>/newspages/console_element/top.jsp" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>--%>
		   <%@include file="console_element/top.jsp"%>
	  </div> 
	  <div id="opt_list">
	 	<iframe src="<%=basePath%>/newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>
	  </div>
	  <div id="opt_area"> 
	    <ul class="classlist">
	      <%--<li> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 <span> 作者：
	        sport                                             
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 省政府500万悬赏建业登顶 球员:遗憾主场放跑国安 <span> 作者：
	        sport                                             
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 洪元硕：北京人的脸就看你们了 最后一哆嗦看着办 <span> 作者：
	        sport                                             
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 临界冠军京城夺票总动员 球迷:夺冠!让所有人闭嘴 <span> 作者：
	        sport                                             
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 一纸传真暗含申花处理态度 国足征调杜威突生悬疑 <span> 作者：
	        sport                                             
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li class='space'></li>
	      <li> 气候变化导致海平面上升 <span> 作者：news
	        
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 商贸联委会在杭州开会 中美对贸易争端态度低调 <span> 作者：news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 迟福林：“十二五”改革应向消费大国转型 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 伊朗称放弃美元作为外储地位 人民币或上位 <span> 作者：
	        out                                               
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> “持械抢劫，当场击毙” 浙江永康现超雷人标语 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li class='space'></li>
	      <li> 国内成品油价格上调几成定局 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 俄数百所幼儿园和学校因流感停课 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 喀布尔市中心传出爆炸和枪声 目前原因不明 <span> 作者：
	        out                                               
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 国台办介绍大陆高校加大对台招生力度情况 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li> 国台办将授权福建等六省市部分赴台管理审批权 <span> 作者：
	        news                                              
	        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li>
	      <li class='space'></li>--%>
	    <%--  <p align="right"> 当前页数:[1/3]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p>--%>
	    </ul>
	  </div>
	
	  <iframe src="<%=basePath%>/newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>
    </div>
<script>
	$(document).ready(function () {
        $.ajax({
            "url":"<%=basePath%>/news",//URL.String类型
            "type":"GET",//AJAX请求的方式，String类型
//            "data":"username="+username,//AJAX请求传递的数据，String类型，Array类型，PlainObject
            "dataType":"JSON",//预期服务器返回的数据类型
            "success":callBack,//成功后的回调函数
            "error":function () {
                alert("获取新闻失败");
            }
		});
    });
	//请求成功后执行的函数，包含加载新闻标题，新闻的作者，id
	function callBack(data) {
	    console.log(data);
	    for(var i=0;i<data.length;){
//            crtTimeFtt(data[i].ncreatedate);
            $(".classlist").append("<li> "+data[i].ntitle+data[i].ncreatedate+" <span> 作者："+data[i].nauthor+""+
            "&#160;&#160;&#160;&#160; <a href='news_modify.html?nid="+data[i].nid+"'>修改</a> &#160;&#160;&#160;&#160; <a href='news_delete.html?nid="+data[i].nid+"' >删除</a> </span> </li>");

            if((++i)%5===0){//每隔5行，空格
                $(".classlist").append("<li class='space'></li>");
			}
		}

    }

    /**************************************时间格式化处理************************************/
    function dateFtt(fmt,date)
    { //author: meizz
        var o = {
            "M+" : date.getMonth()+1,                 //月份
            "d+" : date.getDate(),                    //日
            "h+" : date.getHours(),                   //小时
            "m+" : date.getMinutes(),                 //分
            "s+" : date.getSeconds(),                 //秒
            "q+" : Math.floor((date.getMonth()+3)/3), //季度
            "S"  : date.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }

    //创建时间格式化显示
    function crtTimeFtt(value,row,index){
        var crtTime = new Date(value);
        return dateFtt("yyyy-MM-dd hh:mm:ss",crtTime);//直接调用公共JS里面的时间类处理的办法
    }

</script>
</body>
</html>
