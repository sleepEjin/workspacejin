<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시글 상세보기</title>

	<style>

		.board-container {
			max-width: 1000px;
			margin: 50px auto;
			padding: 2rem;
		}

		.board-card {
			background: white;
			border-radius: 8px;
			box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
			padding: 2rem;
			margin-bottom: 2rem;
		}

		.board-card h2 {
			text-align: center;
			color: #333;
			margin-bottom: 2rem;
			padding-bottom: 1rem;
			border-bottom: 2px solid #4b89fc;
		}

		.detail-table {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 2rem;
		}

		.detail-table th,
		.detail-table td {
			padding: 1rem;
			border: 1px solid #e0e0e0;
		}

		.detail-table th {
			background-color: #f8f9fa;
			font-weight: 500;
			color: #555;
			width: 120px;
			text-align: center;
		}

		.detail-table td {
			background-color: white;
		}

		.content-area {
			min-height: 200px;
			padding: 1rem;
			line-height: 1.6;
		}

		.button-group {
			display: flex;
			justify-content: center;
			gap: 0.5rem;
			margin-top: 2rem;
		}

		.reply-section {
			background: white;
			border-radius: 8px;
			box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
			padding: 2rem;
		}

		.reply-table {
			width: 100%;
			border-collapse: collapse;
		}

		.reply-table th,
		.reply-table td {
			padding: 1rem;
			border: 1px solid #e0e0e0;
		}

		.reply-table thead {
			background-color: #f8f9fa;
		}

		.reply-table thead th {
			font-weight: 500;
			color: #555;
			text-align: center;
		}

		.reply-table textarea {
			width: 100%;
			padding: 0.5rem;
			border: 1px solid #ddd;
			border-radius: 4px;
			font-size: 0.95rem;
			font-family: "Noto Sans KR", sans-serif;
			resize: none;
		}

		.reply-table tbody td {
			text-align: center;
		}

		.reply-table tbody tr:hover {
			background-color: #f8f9fa;
		}

		.reply-btn {
			width: 100%;
			height: 100%;
			min-height: 80px;
		}
	</style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />

	<div class="board-container">
		<div class="board-card">
			<h2>일반게시글 상세보기</h2>

			<table class="detail-table">
				<tr>
					<th>카테고리</th>
					<td>${board.categoryName}</td>
					<th>제목</th>
					<td colspan="3">${board.boardTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${board.memberId}</td>
					<th>작성일</th>
					<td>${board.createDate}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<div class="content-area">
							${board.boardContent}
						</div>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<c:choose>
							<c:when test="${empty at}">
								첨부파일이 없습니다.
							</c:when>
							<c:otherwise>
								<a download="${at.originName}"
									href="${pageContext.request.contextPath}/${at.filePath}${at.changeName}">
									${at.originName}
								</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>

			<div class="button-group">
				<a class="btn btn-primary">목록가기</a>
				<c:if test="${loginMember != null && loginMember.memberId == board.memberId}">
					<a class="btn btn-warning" href="${pageContext.request.contextPath}/updateForm.bo?bno=${board.boardNo}">수정하기</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/delete.bo?bno=${board.boardNo}">삭제하기</a>
				</c:if>
			</div>
		</div>

		<div class="reply-section">
			<table class="reply-table">
				<thead>
					<tr>
						<th width="120">댓글작성</th>
						<c:choose>
							<c:when test="${loginMember != null}">
								<td>
									<textarea id="reply-content" cols="50" rows="3"></textarea>
								</td>
								<td width="100">
									<button class="btn btn-primary reply-btn" onclick="insertReply(${board.boardNo})">댓글등록</button>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<textarea cols="50" rows="3" readonly>댓글등록은 로그인이 필요합니다.</textarea>
								</td>
								<td width="100">
									<button class="btn btn-primary reply-btn" disabled>댓글등록</button>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</thead>
				<tbody>
					<!-- 댓글 목록이 여기에 동적으로 추가됩니다 -->
				</tbody>
			</table>
		</div>
	</div>
	
	<script>
	 function insertReply(bno){
		const contentInput = document.querySelector("#reply-content");

		 $.ajax({
			 url: "rinsert.bo",
			 type: "post",
			 data: {
				boardNo : bno,
				content: contentInput.value
			 },
			 success: function(res){
				console.log("응답 : ", res);
			 },
			 error: function(err){
				console.log("댓글 작성 ajax 실패");
			 }
		 })
	 }
	</script>
</body>
</html>