<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
  top:15%;
  left:15%;
  color:black;
  background-color: #000000;
}
.button {
    background-color: #555555; 
    border: none;
    color: white;
    padding: 3px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 12px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button2 {
    background-color: #555555; 
    border: none;
    color: white;
    padding: 3px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
</style>
<title>Signing</title>
</head>


<script>
function call1(a){
	myfrm.action = "checkId?c_id="+a;
	myfrm.method = "post";
	myfrm.submit();
}

function call2(){
	myfrm.action = "customerInsert";
	myfrm.method = "post";
	myfrm.submit();
}
</script>
<body>
<div class="layer">
	<div class="layer2">
		<form name="myfrm" action="" method="">
		<pre>
<font color="white">ID : </font><input type="text" name="c_id" value="${check_id}"><input type="button" class="button" onclick="call1(c_id.value)"  id="check" value="중복체크" />
     <input type="text" style="background-color: #555555; border:0px;" class="no-border" value="${check}" readonly>
<font color="white">PASSWORD : </font><input type="password" name="c_password"> 
<font color="white">NAME : </font><input type="text" name="c_name"> 
<font color="white">GENDER(M/W) : <label><input type="radio" name="gender" value="M" checked="checked"/>남자</label><label><input type="radio" name="gender" value="W" />여자</label></font> 
<font color="white">BIRTH : </font><input type="date" name="birth"> 
<font color="white">PHONE_NUMBER : </font><input type="text" name="c_phone">
				
	      <input type="button" class="button2" onclick="call2()" value="Sign In"> 
		</form>
		</pre>
	</div>
</div>
</body>
</html>