# 게시판 주요기능

1. 글쓰기 (/board/save)
2. 글목록 (/board/)
3. 글조회 (/board/{id})
4. 글수정 (/board/update/{id})
   - 상세화면에서 수정 버튼 클릭
   - 서버에서 해당 게시글의 정보를 가지고 수정 화면 출력
   - 제목, 내용 수정 입력 받아서 서버로 요청
   - 수정 처리
5. 글삭제 (/board/delete/{id})
6. 페이징처리 (/board/paging)

8. 댓글처리하기
   - 글 상세 페이지에서 댓글 입력 (ajax)
     - ajax 다뤄보기 재생목록
   - 상세조회할 때 기존에 작성된 댓글목록이 보임
   - 댓글을 입력하면 기존 댓글 목록에 새로 작성한 댓글 추가
   - 댓글용 테이블 필요