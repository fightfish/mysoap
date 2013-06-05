<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>会员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="images/skin.css" rel="stylesheet" type="text/css"/>
	
	<style type="text/css">
<!--
.style1 {color: #0000CC;font-size: 16px;font-weight: bold;}
-->
    </style>

</head>



<body>
<center>
<table width="1100" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="middle">
	<table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top">
	<table width="1100" height="532" border="0" cellpadding="0" cellspacing="0" background="images/background1.jpg">
      <tr>
        <td width="59%" align="right">
		<table width="100%" height="532" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="138" valign="top">
			<table width="100%" height="427" border="0" cellpadding="0" cellspacing="0">
                
                <tr>
                  <td height="198" align="right" valign="bottom">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt">
						<p>1. &nbsp;&nbsp;说明一。</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt">
						<p>2. &nbsp;&nbsp;说明二。</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt">
						<p>3. &nbsp;&nbsp;说明三。</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      	<td width="30%" height="40">
						<img src="images/icon-demo.gif" width="16" height="16">
							<a href="readme.txt" target="_blank" class="left_txt3"> 使用说明</a>
						</td>

                      	<td width="35%">
							<img src="images/icon-login-seaver.gif" width="16" height="16">
							<a href="contact.txt" class="left_txt3"> 在线咨询</a>
						</td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table>
		</td>



        <td width="1%" >&nbsp;</td>
        <td width="40%" valign="middle" background="images/background2.png">
		<table width="100%" height="328" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38">
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21">
				<table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="center">
				<form id="form1" name="form1" method="post" action="loginidentify">
    				<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0"
						bordercolor="#CCCCCC" height="126">
      				<caption>
      				<span class="style1">      登 录      </span><br>
     				 </caption>
      				<tr align="left">
       				<th width="40%" height="35" align="center" scope="row">用户名:</th>
       				<td width="60%"><input name="username" type="text" maxlength="20"></td>
      				</tr>
      				<tr align="left">
        				<th height="35" align="center" scope="row">密&nbsp;&nbsp;码:</th>
        				<td><input name="password" type="password" maxlength="30"></td>
      					</tr>
      					<tr align="center">
        				<th height="35" colspan="2" scope="row">
						<input type="submit" name="Submit" value="登录">
        				<input type="button" name="Submit2" value="注册" onclick="javascript:window.location='register.jsp'">
						</th>
      					</tr>
    				</table>
    			</form>	
					</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td height="20">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center">
			<span class="login-buttom-txt">
				<font color=“#000000” >Write by Tonie Team.  ALL Rights Reserved.  Tel: 15216405637</font>
			</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</center>
</body>
</html>
