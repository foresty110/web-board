<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %><html>
<head>
  <meta charset="UTF-8">
  <title>자유게시판 - 목록</title>

  <style>
    table {
      table-layout: fixed;
      border-collapse: collapse; /* 선 겹침 방지 */
      margin-bottom: 10px; /* 테이블 아래 공간 추가 */
    }

    th, td {
      padding: 10px;
      border: 1px solid black; /* 칸 내부 구분선 */
    }

  </style>
</head>
<body>

<h1>자유게시판 - 목록</h1>

<form action="/board/free/list" method="get">

  <label for="start_date">등록일</label>
  <input type="date" id="start_date" title="등록일 기간">
  <span>~</span>
  <input type="date" id="end_date" title="등록일 기간">
  <select id="category" title="카테고리 선택">
    <option value="">전체 카테고리</option>
    <c:forEach var="category" items="${categoryList}">
      <option value="${category.name}">${category.name}</option>
    </c:forEach>
  </select>

  <input type="text" name="keyword" title="검색어 입력" placeholder="검색어를 입력해 주세요. (제목+작성자+내용)">
  <button type="button" class="btn-cancel">검색</button>

</form>

<p>총 ${totalCount}건</p>

<table>
  <thead>
  <tr>
    <th style="width: 100px;">카테고리</th>
    <th style="width: 500px;">제목</th>
    <th style="width: 100px;">작성자</th>
    <th style="width: 100px;">조회수</th>
    <th style="width: 100px;">등록 일시</th>
    <th style="width: 100px;">수정 일시</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach var="board" items="${boardList}">
      <tr>
        <td>${board.categoryName}</td>
        <td>${board.title}</td>
        <td>${board.author}</td>
        <td>${board.viewCount}</td>
        <td>${board.createdAt}</td>
        <td>${board.updatedAt}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

  <button type="button">등록</button>

</body>

<script>
  // 오늘 날짜를 YYYY-MM-DD 형식으로 만들기
  const today = new Date().toISOString().split('T')[0];
  // input 요소의 value에 대입
  document.getElementById('start_date').value = today;
  document.getElementById('end_date').value = today;
</script>
</html>
