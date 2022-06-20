<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Moje zbiórki</title>

    <!-- Custom fonts for this template -->
    <link rel="stylesheet" href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css"/>" type="text/css" />
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="<c:url value="/resources/css/sb-admin-2.min.css"/>" />

    <!-- Custom styles for this page -->
    <link rel="stylesheet" href="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css"/>" />

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                <sec:authorize access="isAuthenticated()"><sec:authentication property="principal.username"/></sec:authorize></span>
                            <img class="img-profile rounded-circle"
                                 src="<c:url value="/resources/images/undraw_profile.svg"/> ">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="<c:url value="/profile"/>">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profil
                            </a>
                            <a class="dropdown-item" href="<c:url value="/my_donations"/>">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Moje zbiórki
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<c:url value="/logout"/>">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Wyloguj
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Moje zbiórki</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <td>L.p.</td>
                                    <td>Adres</td>
                                    <td>Data odbioru</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageList}" var="page" varStatus="pageStatus">
                                    <tr>
                                        <td>${pageStatus.index+1+(presentPage*5)}</td>
                                        <td>${page.city} ${page.zipCode}<br>${page.street}</td>
                                        <td>${page.pickUpDate} : ${page.pickUpTime}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div id="dataTable_paginate" class="dataTables_paginate paging_simple_numbers">
                            <ul class="pagination">
                                <c:set value="${Math.ceil(maxResult/5)-1}" var="ceil"/>
                                <c:choose>
                                    <c:when test="${ceil < 0}">
                                        <c:set value="0" var="page"/>
                                    </c:when>
                                    <c:otherwise>
                                        <c:set value="${ceil}" var="page"/>
                                    </c:otherwise>
                                </c:choose>
                                
                                <c:if test="${ceil < 0}">
                                    
                                </c:if>
                                <c:forEach begin="0" end="${page}" varStatus="stat">
                                    <li class="paginate_button page-item <c:if test="${stat.index == presentPage}">active</c:if>">
                                        <a class="page-link" href="<c:url value="/my_donations/?page=${stat.index}"/>">${stat.index+1}</a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>

                        <a href="<c:url value="/donation"/> " class="btn btn-primary btn-lg">Przekaż dary</a>

                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; InVanare 2022</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>
<%--
<!-- Page level plugins -->
<script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"></script>--%>

</body>

</html>