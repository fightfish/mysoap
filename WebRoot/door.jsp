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
	var menu=$("topTags").getElementsByTagName("ul")[0];//�����˵�����
	var tags=menu.getElementsByTagName("li");//�����˵�
	var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//���˵�
	var j;
	//������˵������±�ǩ
	for(i=0;i<ck.length;i++){
		ck[i].onclick=function(){
			$("welcome").style.display="none";//��ӭ��������
			clearMenu();
			this.style.background='url(images/tabbg02.gif)';
			//ѭ��ȡ�õ�ǰ����
			for(j=0;j<8;j++){
				if(this==ck[j]){
					if($("p"+j)==null){
						openNew(j,this.innerHTML);//���ñ�ǩ��ʾ����
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
	//���ӻ�ɾ����ǩ
	function openNew(id,name){
		var tagMenu=document.createElement("li");
		tagMenu.id="p"+id;
		tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";
		//��ǩ����¼�
		tagMenu.onclick=function(evt){
			clearMenu();
			ck[id].style.background='url(images/tabbg02.gif)';
			clearStyle();
			tagMenu.style.background='url(images/tabbg1.gif)';
			clearContent();
			$("c"+id).style.display="block";
		};
		//��ǩ�ڹر�ͼƬ����¼�
		tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
			evt=(evt)?evt:((window.event)?window.event:null);
			if(evt.stopPropagation){evt.stopPropagation();} //ȡ��opera��Safarið����Ϊ;
			this.parentNode.parentNode.removeChild(tagMenu);//ɾ����ǰ��ǩ
			var color=tagMenu.style.backgroundColor;
			//��������ر�һ����ǩʱ�������һ����ǩ�õ�����
			if(color=="#ffff00"||color=="yellow"){//�������������ɫ����
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
	//����˵���ʽ
	function clearMenu(){
		for(i=0;i<ck.length;i++){
			ck[i].style.background='url(images/tabbg01.gif)';
		}
	}
	//�����ǩ��ʽ
	function clearStyle(){
		for(i=0;i<tags.length;i++){
			menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
		}
	}
	//�������
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
<h2>�Żݲ˵�</h2>
<div class=jg></div>
<div id="topTags">
<ul>
</ul>
</div>
</div>
<div id="main"> 
<div id="leftMenu">
<ul>
<li>�Ż�һ</li>
<li>�Żݶ�</li>
<li>�Żݶ�</li>
<li>�Ż���</li>
<li>�Ż���</li>
<li>�Ż���</li>
<li>�Ż���</li>
</ul>
</div>
<div class=jg></div>
<div id="content">
<div id="welcome" class="content" style="display:block;">
  <div align="center">
    <p>&nbsp;</p>
    <p><strong>��ӭʹ��OTO������Ϣ��վ��</strong></p>
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
<div id="footer">copyright for ������ͼ by Tony</div>

  </body>
</html>
