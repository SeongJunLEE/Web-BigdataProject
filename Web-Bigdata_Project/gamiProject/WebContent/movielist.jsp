<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  top:20%;
  left:25%;
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

th, td {
    border-bottom: 1px solid #ddd;
}

button {
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
	background-color: #000000;
    color: white;
    border: 2px solid #000000;
}

.button1:hover {
    background-color: white;
    color: black;
}

</style>

<title>MovieList</title>
</head>

<script>
function call(){
	 back_home.action="homeServlet";
	 
	 back_home.submit();
}

</script>
<body>
	<div align="left">
	 	<form name="back_home" action="" method="get">
	 		<input type="button" class="button button1" onclick="call()" value="Home">
	 	</form>
	</div>
	<div class="layer">
	<table border="1px" style="color:white">
		
		<thead>
		<tr>
			<th>영화이름</th>
			<th>감독</th>
			<th>배우</th>
			<th>장르</th>
			<th>평점</th>
			<th>예측 평점</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${movielist }" var="movie" varStatus="status">
			<tr>
				<td><a href="movieDetailServlet?m_id=${movie.m_id }" style="color:white">${movie.m_name }</a></td>
				<td>${directorlist[status.index].d_name }</td>
				<td>${actorlist[status.index].a_name }</td>
				<td>${genrelist[status.index] }</td>
				<td>${movie.m_ratings }</td>
				<td>${movie.m_pred_ratings }</td>
			</tr>	
		</c:forEach>
		</tbody>
		
	</table>
	</div>
</body>
</html>