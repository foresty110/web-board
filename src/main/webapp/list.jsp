<%@ page contentType="text/html;charset=UTF-8"%>
<html>
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

<form action="/board/free/write" method="post" enctype="multipart/form-data">

  <label for="start_date">등록일</label>
  <input type="date" id="start_date" title="등록일 기간">
  <span>~</span>
  <input type="date" id="end_date" title="등록일 기간">

  <select id="category" title="카테고리 선택">
    <option value="">전체 카테고리</option>
    <option value="JAVA">JAVA</option>
    <option value="JAVASCRIPT">JAVASCRIPT</option>
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
</table>

  <button type="button">등록</button>

</body>
</html>
