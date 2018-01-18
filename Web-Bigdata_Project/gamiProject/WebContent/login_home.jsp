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
.layer{
  position:absolute;
  top:80%;
  left:40%;
}

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 3px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}


.button1 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.button1:hover {
    background-color: #555555;
    color: white;
}

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

.button2:hover {
    background-color: #f44336;
    color: white;
}

</style>
<title>Home</title>
</head>
<script>
function call(){
	 search.action="homeServlet";
	 search.submit();
}
function call2() {
	logout.action="logoutServlet";
	logout.submit();
}
</script>
<body>
	 <div align="right">
	 	<form name="logout" action="" method="get">
	 		<input class="button button2" type="button" onclick="call2()" value="${id }님">
	 	</form>
	</div>
	
	
	<div class="layer" >
	 	<form name="search" action="" method="post">
	 		<input type="text" name="search_contents" > <input class="button button1" type="button"  onclick="call()" value="검색">
		</form>
	</div>
</body>
</html>