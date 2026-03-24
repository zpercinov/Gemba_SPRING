<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">

        <meta charset="UTF-8">
        <title>Gemba Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
            /* Body full height da footer bude u dnu */
            body {
                font-family: 'Segoe UI', sans-serif;
                background: linear-gradient(to bottom, #ffffff, #f4f4f4);
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            /* Glavni sadržaj raste da popuni prostor */
            main {
                flex-grow: 1;
            }

            /* Navbar Hemofarm */
            .navbar {
                background-color: #f58220 !important;
            }
            .navbar .navbar-brand {
                font-weight: 700;
                letter-spacing: 0.5px;
            }

            /* Header */
            .page-header {
                padding: 25px;
                background: white;
                border-radius: 15px;
                box-shadow: 0 5px 20px rgba(0,0,0,0.08);
                margin-bottom: 30px;
                border-left: 6px solid #f58220;
            }
            .page-header h2 {
                font-weight: 700;
                color: #4d4d4f;
            }

            /* Buttons */
            .btn-gemba {
                background-color: #f58220;
                color: white;
                font-weight: 600;
                padding: 10px 20px;
                border-radius: 10px;
                transition: all 0.2s;
            }
            .btn-gemba:hover {
                background-color: #d96f1a;
                transform: translateY(-2px);
                box-shadow: 0 4px 10px rgba(217, 111, 26, 0.4);
            }
            .btn-gemba i {
                margin-right: 6px;
            }

            /* Search panel */
            .card:hover {
                transform: translateY(-3px);
                transition: transform 0.3s ease, box-shadow 0.3s ease;
                box-shadow: 0 12px 25px rgba(245,130,32,0.25);
            }

            /* Input fokus */
            .form-control:focus {
                border-color: #f58220 !important;
                box-shadow: 0 0 10px rgba(245,130,32,0.3);
            }

            /* Dugme hover */
            .btn:hover {
                background-color: #d96f1a !important;
                transform: translateY(-2px);
                box-shadow: 0 6px 15px rgba(217,111,26,0.3);
                transition: all 0.3s ease;
            }

            /* Gemba cards */
            .gemba-card {
                transition: all 0.3s ease;
                border-radius: 15px;
                border: 2px solid #e0e0e0;
                background-color: #ffffff;
                box-shadow: 0 4px 12px rgba(0,0,0,0.19);
            }

            .gemba-card:hover {
                transform: translateY(-6px);
                box-shadow: 0 10px 30px rgba(0,0,0,0.19);
                border-color: #f58220;
            }

            .card-title {
                font-size: 1.2rem;
                font-weight: 700;
                color: #4d4d4f;
            }
            .gemba-title {
                font-weight: 800;
                font-size: 2rem;
                background: linear-gradient(90deg, #f58220, #ff9f43);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                text-shadow: 2px 2px 4px rgba(0,0,0,0.15);
                margin-bottom: 25px;
            }
        </style>
    </head>
    <body>

        <!-- Navbar -->
        <jsp:include page="/WEB-INF/template/header.jsp"/>
        
        <!-- Sistemske poruke -->
        <jsp:include page="/WEB-INF/template/messages.jsp"/>

        <!-- Glavni sadržaj -->
        <main class="container-fluid mt-5 pt-4">
            <div class="row">
                <!-- Left navigation -->
                <div class="col-md-2 p-3">
                    <jsp:include page="/WEB-INF/template/leftNavigator.jsp"/>
                </div>

                <!-- Main content -->
                <div class="col-md-10">
                    <!-- Header -->
                    <div class="page-header d-flex justify-content-between align-items-center">
                        <h2>${sessionScope.loggedUser.imePrezime}</h2>
                        <div>
                            <form action="<c:url value='/dashboard/list/all'/>" method="post" style="display:inline;">
                                <button class="btn btn-gemba">
                                    <i class="bi bi-card-list"></i> Sve Gembe
                                </button>
                            </form>
                            <form action="<c:url value='/dashboard/list/my'/>" method="post" style="display:inline;">
                                <button class="btn btn-gemba">
                                    <i class="bi bi-person-lines-fill"></i> Moje Gembe
                                </button>
                            </form>
                        </div>
                    </div>

                    <!-- Search panel -->
                    <div class="card mb-4 shadow-lg rounded-4 border-0" style="background: #fff8f1;">
                        <div class="card-body p-3 p-md-4">
                            <form class="row g-2 g-md-3 align-items-center" action="<c:url value='/dashboard/list/search'/>" method="post">
                                <div class="col-md-10 position-relative">
                                    <input type="text" name="query" class="form-control form-control-lg rounded-pill ps-5 border border-warning" 
                                           placeholder="Pretraži po ključnim rečima koristiće znak * za AND i znak | za OR" style="border-color:#f58220;">
                                    <span class="position-absolute top-50 start-0 translate-middle-y ps-3" style="color:#f58220;">
                                        <i class="bi bi-search fs-5"></i>
                                    </span>
                                </div>
                                <div class="col-md-2 d-grid">
                                    <button type="submit" class="btn fw-bold btn-lg rounded-pill shadow" style="background-color:#f58220; color:white;">
                                        Pretraži
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Gemba list -->
                    <h3 class="gemba-title">${sessionScope.gembaTitle}</h3>
                    <div class="row">
                        <c:forEach var="gemba" items="${sessionScope.printGemba}">
                            <div class="col-md-4 mb-4">
                                <div class="card gemba-card p-3 shadow-sm border-0">
                                    <div class="d-flex justify-content-between align-items-start mb-2">
                                        <h5 class="card-title mb-0">
                                            <i class="bi bi-hash" style="color:#f58220;"></i>
                                            ${gemba.iDLisProvere} 
                                            <br>
                                            <i class="bi bi-calendar-date" style="color:#f58220;"></i>
                                            <fmt:formatDate value="${gemba.datum}" pattern="dd.MM.yyyy"/>
                                        </h5>
                                        <!-- Vrsta Gembe -->
                                        <span class="badge rounded-pill bg-warning text-dark fw-bold shadow-sm">
                                            <i class="bi bi-lightning-fill me-1"></i>
                                            ${gemba.vrstaGembe.naziv}
                                        </span>
                                    </div>

                                    <p class="card-text">
                                        <i class="bi bi-diagram-2" style="color:#f58220;"></i> <b>Klaster:</b> <c:out value="${gemba.klaster.naziv}"/><br>
                                        <i class="bi bi-geo-alt" style="color:#f58220;"></i> <b>Sajt:</b> <c:out value="${gemba.sajt.ime}"/><br>
                                        <i class="bi bi-briefcase" style="color:#f58220;"></i> <b>Funkcija:</b> <c:out value="${gemba.funkcija.ime}"/><br>
                                        <i class="bi bi-building" style="color:#f58220;"></i> <b>Odeljenje</b>  <c:out value="${gemba.odeljenje.ime}"/><br>
                                        <i class="bi bi-unity" style="color:#f58220;"></i> <b>Nosilac:</b> <c:out value="${gemba.nosilac.naziv}"/><br>
                                        <i class="bi bi-person" style="color:#f58220;"></i> <b>Uneo:</b> <c:out value="${gemba.userUnos}"/><br>
                                        <span class="badge rounded-pill fw-bold shadow-sm ${gemba.statusEnum.badgeClass}">
                                            <i class="bi ${gemba.statusEnum.icon} me-1"></i>
                                            ${gemba.statusDisplay}
                                        </span>
                                    </p>

                                    <c:choose>
                                        <c:when test="${gemba.userUnos eq sessionScope.loggedUser.korisnickoIme}">
                                            <form action="<c:url value='/gemba/view'/>" method="post" style="display:inline;">
                                                <input type="hidden" name="gembaId" value="${gemba.iDLisProvere}">
                                                <button type="submit" class="btn btn-gemba btn-sm">
                                                    <i class="bi bi-pencil-square"></i> Izmeni
                                                </button>
                                            </form>
                                        </c:when>
                                        <c:otherwise>
                                            <form action="<c:url value='/gemba/view'/>" method="post" style="display:inline;">
                                                <input type="hidden" name="gembaId" value="${gemba.iDLisProvere}">
                                                <button type="submit" class="btn btn-gemba btn-sm">
                                                    <i class="bi bi-eye"></i> Pogledaj
                                                </button>
                                            </form>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>

        <!-- Footer -->
        <footer>
            <jsp:include page="/WEB-INF/template/footer.jsp"/>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>