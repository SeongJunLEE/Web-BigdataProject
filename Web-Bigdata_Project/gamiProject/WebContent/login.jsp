<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login</title>
</head>
<style>
body {
	width: 980px;
	height: 400px;
	background-image: url('image/1234.png'); 
	background-size: 120%;
	background-repeat: no-repeat;
}
.button {
    background-color: #555555; /* Green */
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
.layer{
  width: 400px;
  height: 300px;
  position:absolute;
  top:30%;
  left:35%;
  color:black;
  background-color: #000000;
}
.layer2{
  width: 50px;
  height: 50px;
  position:absolute;
  top:30%;
  left:27%;
  color:black;
  background-color: #000000;
}
</style>
<script>
function call1() {
	 login.action="loginServlet";
	 login.method="post";
	 login.submit();
}
function call2() {
	login.action="customerInsert";
	login.method="get";
	login.submit();
}
</script>

<body>
	<div class="layer">
	<div>
	<form class="layer2" name="login" action="" >
		<font color="white"> ID </font><br>
		<input type="text" name="login_id"> <br>
		
		<font color="white"> PASSWORD </font> <br>
		<input type="password" name="login_password"> <br>
		<pre>
<input type="button" class="button" onclick="call1()" value="Login"> <input type="button" class="button" onclick="call2()" value="Sign">
		</pre>
	</form>
	</div>
	</div>
</body>
</html>