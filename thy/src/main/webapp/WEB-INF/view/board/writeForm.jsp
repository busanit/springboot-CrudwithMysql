<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

<div class="container">
  <form action="/board/insert" method="POST" name="w_form">
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Enter Title" name="title">
    </div>
    <div class="form-group">
      <textarea name="content" id="textAreaContent" style="width: 100%" rows="12" cols="80"></textarea>
    </div>
    <button class="form-control" type="button" onclick="submitContents(this)">글쓰기</button>
  </form>
</div>
<br>

<!-- Naver Smart Editor 2 -->
<script>
  var form = document.w_form;
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors,
      elPlaceHolder: "textAreaContent",
      sSkinURI: "/editor/SmartEditor2Skin.html",
      fCreator: "createSEditor2"
  });
   
  // submit
  function submitContents(elClickedObj) {
      // 에디터의 내용이 textarea에 적용된다.
      oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
      var con = document.w_form.content;
      con.value = document.getElementById("textAreaContent").value;
      try {
          elClickedObj.form.submit();
      } catch(e) {
       
      }
  }
   
  // textArea에 이미지 첨부
  function pasteHTML(filepath){
      var sHTML = '<img src="/editor/upload/'+ filepath + '">';
	  oEditors.getById["textAreaContent"].exec("PASTE_HTML", [ sHTML ]);
  }
</script>
<!-- Naver Smart Editor 2 END-->

<%@ include file="../footer.jsp" %>