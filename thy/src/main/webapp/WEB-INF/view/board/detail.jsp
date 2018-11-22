<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<section id="about">
    <div class="container">
    <c:if test="${sessionScope.login.userid == boardVO.user.userid}">
        <a href="/board/updateForm?boardid=${boardVO.boardid}" class="btn btn-primary">수정</a>
        <a href="/board/delete?boardid=${boardVO.boardid}" class="btn btn-danger">삭제</a><br><br>
    </c:if>
    <div class="row">
        <div class="col-lg-8 mx-auto">
            <h2 class="text-center"><b>${boardVO.title}</b></h2>
            <hr>
            <p class="lead">${boardVO.content}</p>
            <hr>
        </div>

        <!-- Comments Form -->
        <div class="col-lg-8 mx-auto">
            <div class="card">
                <h5 class="card-header">댓글 </h5>
                <div class="card-body">
                    <div class="form-group">
                    <textarea class="form-control" id="content_textarea"  rows="3"></textarea>
                    </div>
                    <input type="button" class="btn btn-primary float-right" onclick="sendReply()" value="작성완료" />
                </div>
            </div>
            <hr>    
        </div>
        <div id="reply" class="col-lg-8 mx-auto">
            <c:forEach var="item" items="${replyList}">
                <div>
                    <span><b>${item.user.name}</b></span><br>
                    <span>${item.content}</span>
                    <a href='/reply/delete?replyid=${item.replyid}&boardid=${item.board.boardid}'>
                        <i class='material-icons'>cancel</i>
                    </a>
                    <hr>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
</section>

<script>

    function addDiv(lastReplyid, boardid, name, content){
       var newDiv = document.createElement("Div");
       newDiv.innerHTML = "<span><b>"+name+"</b></span><br><span>"+content+"</span><a href='/reply/delete?replyid="+lastReplyid+"&boardid="+boardid+"'><i class='material-icons'>cancel</i></a><hr>";
       document.querySelector('#reply').prepend(newDiv);
    }

    function sendReply(){
        var content_textarea = document.querySelector('#content_textarea');
        var content = content_textarea.value;
        if(content == ''){
            alert('글을 입력하세요');
            return false;
        }
        // var rJson = {
        //     "content":content,
        //     "userid":${sessionScope.login.userid},
        //     "boardid":${boardVO.boardid}
        // };

        var board = '${gson.toJson(boardVO)}';
        var user = '${gson.toJson(sessionScope.login)}';
        var rJson = {
            "content":content,
            "board":board,
            "user":user
        };

        console.log(rJson);
        console.log(rJson);
        rJson = JSON.stringify(rJson);
        console.log(rJson);
        content_textarea.value = '';

        fetch('/reply/write', { 
        method : "POST", 
        headers: { 'Content-Type': 'application/json','Accept':'application/json' },
        body : rJson
        }).then(res => res.json())
          .then(data => addDiv(data.lastReplyid, '${boardVO.boardid}' ,'${sessionScope.login.name}', content));
    }

</script>

<%@ include file="../footer.jsp" %>