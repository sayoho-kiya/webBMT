<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 図書管理プログラム ログイン画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>図書管理プログラム</title>
		<link href="./root.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="login_pane">
			
			<h1>新規図書登録画面</h1>
		
			<p>すべての項目を入力してください。</p>
			<form action="./BookRegisterServlet" method="post">
		
			
				<table class="table_form">
					<tbody>
						<tr>
							<th>タイトル</th>
							<td><input type="text" name="title"/></td>
						</tr>
						<tr>
							<th>出版社</th>
							<td><input type="text" name="publisher"/></td>
						</tr><tr>
							<th>著者</th>
							<td><input type="text" name="author"/></td>
						</tr><tr>
							<th>ジャンル</th>
							<td><input type="text" name="genre"/></td>
							<tr>
							<th>エリア</th>
							<td><input type="text" name="area"/></td>
							<tr>
							<th>定価</th>
							<td><input type="text" name="price"/></td>
						
					</tbody>
				</table>
						<input class="common_button" type="button" onclick="location.href='./login.jsp'" value="戻る">
				<input class="common_button" type="submit" name="submit"  value="登録"/>
				
			</form>
			
		</div>
		
			
		
	
		
	</body>
</html>