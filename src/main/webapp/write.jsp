<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 작성</title>

  <style>
    table {
      border-collapse: collapse; /* 선 겹침 방지 */
      margin-bottom: 10px; /* 테이블 아래 공간 추가 */
    }

    th, td {
      padding: 10px;
      border: 1px solid black; /* 칸 내부 구분선 */
    }

    .uploadFile-group {
      display: flex;
      flex-direction: column; /* 자식들을 세로로 쌓음 */
      gap: 10px;              /* 자식들 사이의 간격 띄움 */
    }
    </style>
</head>
<body>



<h1>게시판 등록</h1>
<form action="/board/free/write" method="post" enctype="multipart/form-data">
  <input type="hidden" name="command" value="write">
  <table>
    <tr>
      <th><label for="category">카테고리</label></th>
      <td>
          <select id="category" required >
          <option value="">카테고리 선택</option>
          <option value="JAVA">JAVA</option>
          <option value="JAVASCRIPT">JAVASCRIPT</option>
        </select>
      </td>
    </tr>
    <tr>
      <th><label for="writer">작성자</label></th>
      <td><input type="text" id="writer" required minlength="3" maxlength="4"></td>
    </tr>
    <tr>
      <th><label for="password">비밀번호</label></th>
      <td>
        <div class="pw-group">
          <input type="password" id="password" placeholder="비밀번호"
                 required pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{4,15}$"
                 title="4글자 이상 16글자 미만, 영문/숫자/특수문자 포함">
          <input type="password" id="passwordConfirm" placeholder="비밀번호 확인"
                 required pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{4,15}$"
                 title="4글자 이상, 16글자 미만, 영문/숫자/특수문자를 포함">
        </div>
      </td>
    </tr>
    <tr>
      <th><label for="title">제목</label></th>
      <td><input type="text" id="title" required minlength="4" maxlength="100"></td>
    </tr>
    <tr>
      <th><label for="content">내용</label></th>
      <td>
        <textarea id="content" rows="10" required minlength="4" maxlength="1999"></textarea>
      </td>
    </tr>
    <tr>
      <th>파일 첨부</th>
      <td>
        <div class="uploadFile-group">
          <input type="file" name="file1">
          <input type="file" name="file2">
          <input type="file" name="file3">
        </div>
      </td>
    </tr>
  </table>

  <div class="btn-group">
    <button type="button" class="btn-cancel">취소</button>
    <button type="submit" class="btn-save">저장</button>
  </div>

</form>

<script>
  document.querySelector('form').onsubmit = function() {
    if (this.password.value !== this.passwordConfirm.value) {
      alert("비밀번호가 일치하지 않습니다.");
      return false; // 전송 중단
    }
  };
</script>

</body>
</html>