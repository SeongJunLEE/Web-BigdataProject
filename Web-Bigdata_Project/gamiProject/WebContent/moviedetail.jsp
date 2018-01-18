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
	background-image: url('image/1234567.jpg'); 
	background-size: 120%;
	background-repeat: no-repeat;
}
.layer{
  position:absolute;
  top:20%;
  left:30%;
  background-color:#000000;
}
.layer2{
  position:absolute;
  top:20%;
  left:50%;
  background-color:#000000;
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
<title>Movie Detail</title>
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
		<tr>
			<th>영화 이름</th>
			<td align="center">${movie.m_name }</td>
		</tr>
		<tr>
			<th>상영 시간</th>
			<td align="center">${movie.m_time }분</td>
		</tr>
		<tr>
			<th>예산</th>
			<td align="center">$${movie.m_budget }</td>
		</tr>
		<tr>
			<th>개봉 일자</th>
			<td align="center">${movie.m_date }년</td>
		</tr>
		<tr>
			<th>좋아요 수</th>
			<td align="center">${movie.m_like }</td>
		</tr>
		<tr>	
			<th>평점</th>
			<td align="center">${movie.m_ratings }점</td>
		</tr>
		<tr>	
			<th>예측 평점</th>
			<td align="center">${movie.m_pred_ratings }점</td>
		</tr>
		<tr>	
			<th>평점 개수</th>
			<td align="center">${movie.m_ratecount }</td>
		</tr>
		<tr>	
			<th>감독</th>
			<td align="center">${director.d_name }</td>
		</tr>
		<tr>	
			<th>감독 좋아요 수</th>
			<td align="center">${director.d_like }</td>
		</tr>
		<c:forEach items="${actorlist }" var="actor" varStatus="status">
			<tr>
				<th>배우${status.count }</th>
				<td align="center">${actor.a_name }</td>
			</tr>
			<tr>
				<th>배우${status.count } 좋아요 수</th>
				<td align="center">${actor.a_like }</td>
			</tr>
			<tr>
				<th>배우${status.count } 순위</th>
				<td align="center">${actor.a_rank }위</td>	
			</tr>
		</c:forEach>
			
		<tr>	
			<th>장르</th>
			<td align="center">${genre }</td>
		</tr>
	</table>	
	</div>
	<div class="layer2">
	<font color="white">
	<c:forEach items="${recommMovielist }" var="recommMovie" varStatus="status">
			추천 ${status.count } : <br>
			영화이름 : <a href="movieDetailServlet?m_id=${recommMovie.m_id }" style="color:white">${recommMovie.m_name }</a> <br>
			감독 : ${recommMovieDirectorlist[status.index].d_name } <br>
			배우 : ${recommMovieActorlist[status.index].a_name } <br>
			장르 : ${recommMovieGenrelist[status.index] } <br>
			평점 : ${recommMovie.m_ratings }점 <br>
			예측 평점 : ${recommMovie.m_pred_ratings }점 <br> <br>
	</c:forEach>		
	</font>
	</div>
</body>
</html>