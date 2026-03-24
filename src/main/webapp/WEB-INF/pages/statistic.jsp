<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <meta charset="UTF-8">
        <title>Statistika mojih Gemba</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">

        <!-- Bootstrap + Icons -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

        <style>
            body {
                background-color: #f5f7fa;
                font-family: 'Segoe UI', sans-serif;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                padding-top: 70px;
            }
            .flex-grow-1 {
                flex: 1;
            }
            .navbar {
                background-color: #f58220 !important;
                box-shadow: 0 2px 4px rgba(0,0,0,0.2);
            }
            .page-header {
            padding: 25px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.08);
            margin-bottom: 30px;
            border-left: 6px solid #f58220;
        }
        .page-header h2 { font-weight: 700; color: #4d4d4f; }
            .section-card {
                border-radius: 12px;
                border: none;
                box-shadow: 0 3px 10px rgba(0,0,0,0.08);
            }
            .section-header {
                background-color: #ffffff !important;
                border-bottom: 2px solid #f58220;
                border-radius: 12px 12px 0 0;
                padding: 14px 20px;
            }
            .section-header h5 {
                margin: 0;
                font-weight: 700;
                color: #444;
            }
            .ishod-ok_boja      {
                background-color: #d4edda !important;
                color:#155724 !important;
                font-weight:600;
            }
            .ishod-nije_ok_boja {
                background-color: #f8d7da !important;
                color:#721c24 !important;
                font-weight:600;
            }
            .ishod-nije_provereno_boja {
                background-color: #fff3cd !important;
                color:#856404 !important;
                font-weight:600;
            }
            .status-completed {
                color: #155724;
                font-weight: 600;
            }
            .status-pending {
                color: #856404;
                font-weight: 600;
            }
            .status-failed {
                color: #721c24;
                font-weight: 600;
            }
        </style>
    </head>
    <body class="d-flex flex-column min-vh-100">

        <!-- Navbar -->
        <jsp:include page="/WEB-INF/template/header.jsp"/>

        <!-- Sistemske poruke -->
        <jsp:include page="/WEB-INF/template/messages.jsp"/>

        <!-- Main content -->
        <div class="container-fluid flex-grow-1">
            <div class="row">

                <!-- Left Menu -->
                <div class="col-md-2 p-3">
                    <jsp:include page="/WEB-INF/template/leftNavigator.jsp"/>
                </div>

                <!-- Main Area -->
                <div class="col-md-10">

                    <!-- Naslov -->
                     <div class="page-header d-flex justify-content-between align-items-center">
                        <h2>Statistika mojih Gemba</h2>
                    </div>

                    <!-- Osnovna statistika -->
                    <div class="row mb-4">

                        <!-- Ukupno lista -->
                        <div class="col-md-3">
                            <form method="post" action="<c:url value='/statistic'/>">
                                <input type="hidden" name="statusFilter" value="all"/>
                                <button type="submit"
                                        class="card section-card text-center p-4 w-100 btn btn-link text-decoration-none text-dark
                                        <c:if test='${param.statusFilter == null || param.statusFilter == "all"}'> border-primary fw-bold</c:if>">
                                            <h6>Ukupno lista</h6>
                                            <span class="fs-3 fw-bold">${total}</span>
                                </button>
                            </form>
                        </div>

                        <!-- U toku -->
                        <div class="col-md-3">
                            <form method="post" action="<c:url value='/statistic'/>">
                                <input type="hidden" name="statusFilter" value="pending"/>
                                <button type="submit"
                                        class="card section-card text-center p-4 w-100 btn btn-link text-decoration-none text-dark
                                        <c:if test='${param.statusFilter == "pending"}'> border-primary fw-bold</c:if>">
                                            <h6>U toku</h6>
                                            <span class="status-pending fs-3">${pending}</span>
                                </button>
                            </form>
                        </div>

                        <!-- Završene -->
                        <div class="col-md-3">
                            <form method="post" action="<c:url value='/statistic'/>">
                                <input type="hidden" name="statusFilter" value="completed"/>
                                <button type="submit"
                                        class="card section-card text-center p-4 w-100 btn btn-link text-decoration-none text-dark
                                        <c:if test='${param.statusFilter == "completed"}'> border-primary fw-bold</c:if>">
                                            <h6>Završene</h6>
                                            <span class="status-completed fs-3">${completed}</span>
                                </button>
                            </form>
                        </div>

                        <!-- Arhivirane -->
                        <div class="col-md-3">
                            <form method="post" action="<c:url value='/statistic'/>">
                                <input type="hidden" name="statusFilter" value="archive"/>
                                <button type="submit"
                                        class="card section-card text-center p-4 w-100 btn btn-link text-decoration-none text-dark
                                        <c:if test='${param.statusFilter == "archive"}'> border-primary fw-bold</c:if>">
                                            <h6>Arhivirane</h6>
                                            <span class="status-failed fs-3">${archive}</span>
                                </button>
                            </form>
                        </div>

                    </div>

                    <style>
                        /* Hover efekat za kartice */
                        .section-card.btn:hover {
                            transform: scale(1.05);
                            transition: transform 0.2s ease-in-out;
                            box-shadow: 0 6px 15px rgba(0,0,0,0.15);
                        }
                    </style>

                    <div class="mb-3 d-flex justify-content-end">
                        <form method="post" action="<c:url value='/statistic/export'/>">
                            <input type="hidden" name="statusFilter" value="${param.statusFilter != null ? param.statusFilter : 'all'}"/>
                            <button type="submit" class="btn btn-success">
                                <i class="bi bi-file-earmark-excel me-1"></i> Export u Excel
                            </button>
                        </form>
                    </div>

                    <!-- Tabela lista provera -->
                    <div class="card section-card mb-4">
                        <div class="section-header">
                            <h5><i class="bi bi-list-ul me-2"></i> Lista provera</h5>
                        </div>
                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table class="table table-hover mb-0">
                                    <thead class="table-light">
                                        <tr>
                                            <th>ID</th>
                                            <th>Datum</th>
                                            <th>Klaster</th>
                                            <th>Sajt</th>
                                            <th>Odeljenje</th>
                                            <th>Vrsta gembe</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lp" items="${listaProveraUser}">
                                            <tr>
                                                <td>${lp.iDLisProvere}</td>
                                                <td><fmt:formatDate value="${lp.datum}" pattern="dd.MM.yyyy"/></td>
                                                <td>${lp.klaster.naziv}</td>
                                                <td>${lp.sajt.ime}</td>
                                                <td>${lp.odeljenje.ime}</td>
                                                <td>${lp.vrstaGembe.naziv}</td>
                                                <td>
                                                    <c:set var="statusEnum" value="${lp.statusEnum}" />
                                                    <c:if test="${statusEnum != null}">
                                                        <span class="badge ${statusEnum.badgeClass}">
                                                            <i class="bi ${statusEnum.icon} me-1"></i> ${statusEnum.label}
                                                        </span>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <c:if test="${empty listaProveraUser}">
                                            <tr>
                                                <td colspan="6" class="text-center">Nema podataka za prikaz.</td>
                                            </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer>
            <jsp:include page="/WEB-INF/template/footer.jsp"/>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>