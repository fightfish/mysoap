<%@page import="data.CompanyId"%>
<%@page import="service.ProductService"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'door.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="face.css">
	
	
	<script type="text/javascript">
	
window.onload=function(){
	function $(id){return document.getElementById(id);}
	var menu=$("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
	var tags=menu.getElementsByTagName("li");//顶部菜单
	var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//左侧菜单
	var j;
	//点击左侧菜单增加新标签
	for(i=0;i<ck.length;i++){
		ck[i].onclick=function(){
			$("welcome").style.display="none";//欢迎内容隐藏
			clearMenu();
			this.style.background='url(images/tabbg02.gif)';
			//循环取得当前索引
			for(j=0;j<8;j++){
				if(this==ck[j]){
					if($("p"+j)==null){
						openNew(j,this.innerHTML);//设置标签显示文字
 					}
					clearStyle();
					$("p"+j).style.background='url(images/tabbg1.gif)';
					clearContent();
					$("c"+j).style.display="block";
   				}
 			}
			return false;
  		};
 	}
	//增加或删除标签
	function openNew(id,name){
		var tagMenu=document.createElement("li");
		tagMenu.id="p"+id;
		tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";
		//标签点击事件
		tagMenu.onclick=function(evt){
			clearMenu();
			ck[id].style.background='url(images/tabbg02.gif)';
			clearStyle();
			tagMenu.style.background='url(images/tabbg1.gif)';
			clearContent();
			$("c"+id).style.display="block";
		};
		//标签内关闭图片点击事件
		tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
			evt=(evt)?evt:((window.event)?window.event:null);
			if(evt.stopPropagation){evt.stopPropagation();} //取消opera和Safari冒泡行为;
			this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
			var color=tagMenu.style.backgroundColor;
			//设置如果关闭一个标签时，让最后一个标签得到焦点
			if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
				if(tags.length-1>=0){
					clearStyle();
					tags[tags.length-1].style.background='url(images/tabbg1.gif)';
					clearContent();
					var cc=tags[tags.length-1].id.split("p");
					$("c"+cc[1]).style.display="block";
					clearMenu();
					ck[cc[1]].style.background='url(images/tabbg1.gif)';
				} else{
					clearContent();
					clearMenu();
					$("welcome").style.display="block";
				}
			}
		};
		menu.appendChild(tagMenu);
	}
	//清除菜单样式
	function clearMenu(){
		for(i=0;i<ck.length;i++){
			ck[i].style.background='url(images/tabbg01.gif)';
		}
	}
	//清除标签样式
	function clearStyle(){
		for(i=0;i<tags.length;i++){
			menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
		}
	}
	//清除内容
	function clearContent(){
		for(i=0;i<7;i++){
			$("c"+i).style.display="none";
		}
	}
};
</script>
	
  </head>
  
  
  
  <body>
  
  
    <div id="top">
<h2>优惠菜单</h2>
<div class=jg></div>
<div id="topTags">
<ul>
</ul>
</div>
</div>
<div id="main"> 
<div id="leftMenu">
<ul>
<li>优惠一</li>
<li>优惠二</li>
<li>优惠二</li>
<li>优惠三</li>
<li>优惠四</li>
<li>优惠五</li>
<li>优惠六</li>
</ul>
</div>
<div class=jg></div>
<div id="content">
<div id="welcome" class="content" style="display:block;">
  <div align="center">
    <p>&nbsp;</p>
    <p><strong>欢迎使用OTO打折信息网站！</strong></p>
    <p>&nbsp;</p>
    </div>
</div>
<%
	ProductService productService = new ProductService();
	CompanyId companyId = new CompanyId("517A06ABE55A02E47A0CE8A9");
%>
<div id="c0" class="content"><%=productService.getProductByCompany(companyId).toString() %></div>
<div id="c1" class="content">2</div>
<div id="c2" class="content">3</div>
<div id="c3" class="content">4</div>
<div id="c4" class="content">5</div>
<div id="c5" class="content">6</div>
<div id="c6" class="content">7</div>
</div>
</div>
<div id="footer">copyright for 创想云图 by Tony</div>

  </body>
</html>
