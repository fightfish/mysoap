<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>ע�����</title>
		<script language="javascript">
	function tell() {
		alert("�װ����û�����ϲ������Ϣ�Ѿ�ע��ɹ�����");
	}
	function checkname() {
		var div = document.getElementById("div1");
		div.innerHTML = "";
		var name1 = document.form1.text1.value;
		if (name1 == "") {
			div.innerHTML = "��������Ϊ�գ�";
			document.form1.username.focus();
			return false;
		}
		if (name1.length < 4 || name1.length > 16) {
			div.innerHTML = "��������ĳ���4-16���ַ���";
			document.form1.username.select();
			return false;
		}
		var charname1 = name1.toLowerCase();
		for ( var i = 0; i < name1.length; i++) {
			var charname = charname1.charAt(i);
			if (!(charname >= 0 && charname <= 9)
					&& (!(charname >= 'a' && charname <= 'z'))
					&& (charname != '_')) {
				div.innerHTML = "���������Ƿ���ĸ��ֻ�ܰ�����ĸ�����֣����»���";
				document.form1.username.select();
				return false;
			}
		}
		return true;

	}

	function checkpassword() {
		var div = document.getElementById("div2");
		div.innerHTML = "";
		var password = document.form1.text2.value;
		if (password == "") {
			div.innerHTML = "���벻��Ϊ�գ�";
			document.form1.password.focus();
			return false;
		}
		if (password.length < 4 || password.length > 12) {
			div.innerHTML = "���볤��4-12λ";
			document.form1.password.select();
			return false;
		}
		return true;
	}

	function checkrepassword() {
		var div = document.getElementById("div3");
		div.innerHTML = "";
		var password = document.form1.password.value;
		var repass = document.form1.confirmingpassword.value;
		if (repass == "") {
			div.innerHTML = "���벻��Ϊ�գ�";
			document.form1.confirmingpassword.focus();
			return false;
		}
		if (password != repass) {
			div.innerHTML = "���������ȷ�����벻һ��";
			document.form1.text3.select();
			return false;
		}
		return true;
	}

	function check() {
		if (checkname() && checkpassword() && checkrepassword()) {
			return true;
		} else {
			return false;
		}
	}
</script>
	</head>
	<body>
		<div class="top" style="height: 100px;"></div>

		<div class="middle" style="height: 400px;" align="center">
			<form name="form1" method="post" action="register"
				onsubmit="return check()">
				<table>
					<tr>
						<td>
							�û�����
						</td>
						<td>
							<input id="text1" type="text" name="username" onblur="check()">
							<div id="div1" style="display: inline">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							���룺
						</td>
						<td>
							<input id="text2" type="password" name="password"
								onblur="check()">
						</td>
						<td>
							<div id="div2" style="display: inline">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							ȷ�����룺
						</td>
						<td>
							<input id="text3" type="password" name="confirmingpassword"
								onblur="check()">
							<div id="div3" style="display: inline">
							</div>
						</td>
					</tr>

					<tr align="center">
						<td align="center">
							<input type="submit" value="�ύ" name="text6">
							<input type="reset" value="����" name="text7">
						</td>
					</tr>
				</table>
			</form>
			<p align="center">
				<a href="welcome.jsp">���ص�½����</a>
			</p>
		</div>
		<div class="bottom" align="center">
			<p>
				Write by Tony. 2012/4/24.  ALL Rights Reserved.
			</p>
			<p>
				��Ȩ����. ��ѯ���ߣ�15216405637
			</p>
		</div>

	</body>
</html>
