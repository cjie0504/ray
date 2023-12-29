<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header Section Begin -->
<jsp:include page="../layout/header.jsp"></jsp:include>
<!-- Header End -->
<!-- Breadcrumb Begin -->
<div class="breadcrumb-option spad set-bg" data-setbg="/resources/img/headerImg.jpg">
    <div class="container" id="subTitle">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Contact Us</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->
<div class="set-bg" data-setbg="/resources/img/company/subHeaderImg.jpg" style="height: 18%;">
    <div class="container">
        <div class="row">
            <div class="menuSubTitle col-lg-12">
                <div>
                    <h2 style="color: white;">Inquiry Board</h2>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Breadcrumb Begin -->

    <!-- Breadcrumb End -->

    <!-- Contact Widget Section Begin -->

<section class="spad" style="width: 75%;margin: auto;">

    <div class="panel" style="margin-left:1px;min-height: 500px;">
        <div id="contAreaBox">
            <div class="panel">
                <div class="panel-body">
                        <div class="table-responsive" style="text-align:center;">
                            <table id="datatable-scroller"
                                   class="table table-bordered tbl_Form">
                                <caption></caption>
                                <colgroup>
                                    <col width="250px" />
                                    <col />
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th class="active" >작성자 이름</th>
                                    <td class="form-inline">${INQUIRY.name}</td>
                                </tr>
                                <tr>
                                    <th class="active" >소속</th>
                                    <td class="form-inline">${INQUIRY.company}</td>
                                </tr>
                                <tr>
                                    <th class="active" >이메일</th>
                                    <td class="form-inline">${INQUIRY.email}</td>
                                </tr>
                                <tr>
                                    <th class="active" >핸드폰번호</th>
                                    <td class="form-inline">${INQUIRY.phone}</td>
                                </tr>

                                <tr>
                                    <th class="active">제목</th>
                                    <td class="form-inline">${INQUIRY.title}</td>
                                </tr>
                                <tr>
                                    <th class="active">작성일</th>
                                    <td class="form-inline">${INQUIRY.regDt}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    <div>
                            ${INQUIRY.contents}
                    </div>

                </div>
            </div>
        </div>

        <div style="margin-top: 5em;">
            <div class="input-group">
                <input type="text" id="reply" name="reply" cols="100" rows="1" class="form-control" placeholder="댓글을 입력해주세요."></input>
                <div class="input-group-append">
                    <button type="button" onclick="submitReply();" class="btn btn-primary">댓글 등록</button>
                </div>
            </div>


            <c:if test="${not empty INQUIRY.replies}">

                <!-- replyList에 댓글 데이터가 담겨있다고 가정 -->
                <c:forEach var="inquiryReply" items="${INQUIRY.replies}" varStatus="vs">
                    <div style="margin-top: 2em; position: relative;">
                        <b>${inquiryReply.writer}</b> | ${inquiryReply.regDt} <br>
                        <div style="display: flex; justify-content: space-between;">
                            <span>${inquiryReply.contents}</span>
                            <c:if test="${inquiryReply.writer eq INQUIRY.name}">
                                <button type="button" onclick="deleteReply(${inquiryReply.replyNo}, ${INQUIRY.inquiryNo});" class="btn btn-danger btn-sm">삭제</button>
                            </c:if>
                        </div>
                        <hr>
                    </div>
                </c:forEach>
            </c:if>
        </div>


    </div>
    </div>

    <form id="form" name="form" action="/inquiry/reply" method="post">
        <input type="hidden" id="writer" name="writer" value="${INQUIRY.name}">
        <input type="hidden" id="inquiryNo" name="inquiryNo" value="${INQUIRY.inquiryNo}">
        <input type="hidden" id="contents" name="contents">
        <input type="hidden" id="token" name="token" value="${token}">
    </form>


    </div>
    <div style="margin-right:50px; margin-top:100px;float: right">
        <a href="/inquiry" class="btn btn-secondary">목록으로</a>
    </div>
</section>
<!--    footer start-->
<jsp:include page="../layout/footer.jsp"></jsp:include>
<!-- Js Plugins -->
<script type="text/javascript" src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/mixitup.min.js"></script>
<script src="/resources/js/masonry.pkgd.min.js"></script>
<script src="/resources/js/jquery.slicknav.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/main.js"></script>
<script type="text/javascript">

    function submitReply() {
        try {
            if($("#reply").val()=="" || !$("#reply").val()){
                alert("댓글 내용을 입력해주세요.")
                return;
            }

            $("#contents").val($("#reply").val());
            var form = document.getElementById("form");
            form.submit();

        } catch (e) {}
    }

    function deleteInquiry(inquiryNo) {
        if (confirm("게시글을 삭제하시겠습니까?")) {
            $.ajax({
                type: "DELETE",
                url: "/inquiry/delete/" + inquiryNo, // 삭제를 처리하는 서버 엔드포인트 URL
                success: function(response) {
                    if (response.success) {
                        // 삭제 성공 시 처리
                        alert("게시글이 삭제되었습니다.");
                        // /inquiry/list 페이지로 이동
                        window.location.href = "/inquiry/list";
                    } else {
                        // 삭제 실패 시 처리
                        alert("게시글 삭제에 실패했습니다.");
                    }
                },
                error: function() {
                    // 서버 요청 실패 시 처리
                    alert("서버 요청에 실패했습니다.");
                }
            });
        }else{
            return false;
        }
    }

    function deleteReply(replyNo, inquiryNo) {
        if (confirm("댓글을 삭제하시겠습니까?")) {
            $.ajax({
                type: "DELETE",
                url: "/inquiry/delete/reply", // 댓글 삭제를 처리하는 서버 엔드포인트 URL
                data: { replyNo: replyNo, inquiryNo: inquiryNo },
                success: function(response) {
                    if (response.success) {
                        // 삭제 성공 시 처리
                        alert("댓글이 삭제되었습니다.");
                        location.reload();
                        // 페이지 리로드 또는 댓글을 화면에서 제거하는 등의 처리를 수행할 수 있습니다.
                    } else {
                        // 삭제 실패 시 처리
                        alert("댓글 삭제에 실패했습니다.");
                    }
                },
                error: function() {
                    // 서버 요청 실패 시 처리
                    alert("서버 요청에 실패했습니다.");
                }
            });
        }else{
            return false;
        }
    }


</script>
