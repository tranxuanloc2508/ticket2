<%-- 
    Document   : header
    Created on : Oct 21, 2021, 6:01:10 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/" />">Lập trình Java<span>Trường đại học Mở</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item "><a href="<c:url value="/" />" class="nav-link">Trang chủ</a></li>
                <li class="nav-item"><a href="destination.html" class="nav-link">Các tuyến</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item"><a href="<c:url value="/signup" />" class="nav-link">Đăng ký</a></li>
                    <li class="nav-item"><a href="<c:url value="/signin" />" class="nav-link">Đăng nhập</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                        <c:if test="${currentUser.avatar != null}">
                            <img src="${currentUser.avatar}" class="avatar"/>
                        </c:if>
                        <c:if test="${currentUser.avatar == null}">                        
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </c:if>                                        
               
                    </li>
                    <li class="nav-item"><a href="<c:url value="/user/edit-users/${pageContext.request.userPrincipal.name}" />" class="nav-link">${pageContext.request.userPrincipal.name}</a></li>
                    <li class="nav-item"><a href="<c:url value="/logout" />" class="nav-link">Đăng xuất</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
</nav>

<!-- END nav -->
