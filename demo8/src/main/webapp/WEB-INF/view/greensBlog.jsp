<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	width: 1000px;
}

.all-wrap {
	display: flex;
	padding: 20px;
	margin: 20px;
	align-items: flex-start;
}

h1 {
	margin: 20px;
	border-top: 1px solid lightGray;
	border-bottom: 1px solid lightGray;
	background-color: #fff;
	padding: 20px;
	border-top: 1px solid lightGray;
}

table th {
	margin-bottom: 10px;
}

.category-wrap {
	display: flex;
	flex-direction: column;
	width: 170px;
	height: 300px;
	border: 1px solid lightGray;
	border-radius: 20px;
	padding: 8px;
	margin-left: 20px;
	margin-right: 20px;
	margin-top: 20px;
	border: 1px solid lightGray;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	font-weight: bolder;
}

.content-wrap {
	display: flex;
	width: 730px;
	flex-direction: row;
}

.article-title{
	display: flex;
	justify-content: space-between;
}

img {
	height: 160px;
	margin: 10px;
	width: 160px;
}
</style>
</head>
<body>
	<h1>Green's Blog</h1>
	<div class="all-wrap">
		<div class="category-wrap">
			<table>
				<tr>
					<th><a href="#">전체보기</a></th>
				</tr>
				<tr>
					<td><a href="#">Python(12)</a></td>
				</tr>
				<tr>
					<td><a href="#">Java(2)</a></td>
				</tr>
				<tr>
					<td><a href="#">ios(8)</a></td>
				</tr>
				<tr>
					<td><a href="#">소프트웨어 자료(26)</a></td>
				</tr>
				<tr>
					<td><a href="#">자료구조 (8)</a></td>
				</tr>
				<tr>
					<td><a href="#">리눅스 (8)</a></td>
				</tr>
				<tr>
					<td><a href="#">Git (4)</a></td>
				</tr>
				<tr>
					<td><a href="#">자기계발 (3)</a></td>
				</tr>
				<tr>
					<td><a href="#">경영전략 (20)</a></td>
				</tr>
				<tr>
					<td><a href="#">리더쉽 (7)</a></td>
				</tr>
			</table>

		</div>
		<div class="hi">
			<div class="article-title">
				<span class="left">경영전략 20</span> <span
					class="material-symbols-outlined">edit_square</span>
			</div>
			<div class="image-wrap">
				<table>
					<tr>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
					</tr>
					<tr>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
					</tr>
					<tr>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
					</tr>
					<tr>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
						<td><img src="/image/image.png"></td>
					</tr>
					<tr>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
						<td>asfdfsdafasd</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div class="page-wrap">
		<!-- 나중에 a태그로 감싸야 되는데 flex 줘서 row해야 될 듯 -->
		<span class="">1 2 3 4 5 6 7 8 9 10 다음 ></span>
	</div>
</body>
</html>