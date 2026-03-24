<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">
        <meta charset="UTF-8">
        <title>Zamerka</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                background: linear-gradient(to bottom, #ffffff, #f4f4f4);
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }
            main {
                flex-grow: 1;
            }

            .navbar {
                background-color: #f58220 !important;
            }
            .page-header {
                padding: 25px;
                background: white;
                border-radius: 15px;
                box-shadow: 0 5px 20px rgba(0,0,0,0.08);
                margin-bottom: 30px;
                border-left: 6px solid #f58220;
            }
            .card:hover {
                transform: translateY(-3px);
                transition: transform 0.3s ease, box-shadow 0.3s ease;
                box-shadow: 0 12px 25px rgba(245,130,32,0.25);
            }
        </style>
    </head>

    <body>

        <!-- HEADER -->
        <jsp:include page="/WEB-INF/template/header.jsp"/>

        <!-- PORUKE -->
        <jsp:include page="/WEB-INF/template/messages.jsp"/>
        <jsp:include page="/WEB-INF/template/confirmDeleteModal.jsp"/>

        <main class="container-fluid mt-5 pt-4">

            <div class="row">

                <!-- LEFT NAV -->
                <div class="col-md-2 p-3">
                    <jsp:include page="/WEB-INF/template/leftNavigator.jsp"/>
                </div>

                <div class="col-md-10 p-4">

                    <!-- Header -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2 class="fw-bold">Aktivnost: <c:out value="${headerAktivnost}" /></h2>
                        <c:if test="${not viewMode}">
                            <form action="<c:url value='/gemba/edit'/>" method="post">
                                <input type="hidden" name="gembaId" value="${gemba.iDLisProvere}">
                                <button type="submit" class="btn btn-secondary btn-lg">
                                    <i class="bi bi-arrow-left-circle me-1"></i>
                                    Nazad
                                </button>
                            </form>
                        </c:if> 

                        <c:if test="${viewMode == true}">
                            <button type="button"
                                    class="btn btn-danger btn-lg"
                                    onclick="window.close();">
                                <i class="bi bi-x-circle me-1"></i>
                                Zatvori
                            </button>
                        </c:if>

                    </div>

                    <!-- Forma za dodavanje zamerke -->
                    <div class="card shadow-sm mb-5">
                        <div class="card-body">

                            <form action="<c:url value='/gemba/zamerka/save'/>" method="post">
                                <input type="hidden" name="idLisProvereAktZamerka" value="${idLisProvereAktZamerka}">
                                <input type="hidden" name="idListaAktivnosti" value="${idLisProvereAkt}">  
                                <input type="hidden" name="idAktivnosti" value="${idAktivnosti}">         
                                <input type="hidden" name="headerAktivnost" value="${headerAktivnost}" />

                                <div class="row g-3">

                                    <!-- Šifarnik zamerki -->
                                    <div class="col-md-6">
                                        <c:if test="${not viewMode}">
                                            <label for="zamerka" class="form-label">Zamerka *</label>
                                            <select id="zamerke" name="idZamerke" class="form-select" required>
                                                <option value="" selected disabled hidden>-izaberi-</option>
                                                <c:forEach var="sif" items="${zamerke}">
                                                    <option value="${sif.IDZamerka}" ${sif.IDZamerka == idZamerka ? 'selected' : ''}>
                                                        ${sif.naziv}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </c:if>
                                    </div>

                                    <!-- Napomena -->
                                    <div class="col-md-6">
                                        <c:if test="${not viewMode}">
                                            <label for="napomena" class="form-label">Napomena</label>
                                            <input type="text" class="form-control" id="napomena" 
                                                   name="napomena" value="${napomena}">
                                        </c:if>
                                    </div>
                                </div>

                                <div class="mt-4 text-end">
                                    <c:if test="${not viewMode}">
                                        <c:choose>
                                            <c:when test="${not empty idLisProvereAktZamerka}">
                                                <button type="submit" class="btn btn-warning btn-lg">
                                                    <i class="bi bi-pencil-fill me-1"></i>
                                                    Izmeni zamerku
                                                </button>
                                            </c:when>
                                            <c:otherwise>
                                                <button type="submit" class="btn btn-primary btn-lg">
                                                    <i class="bi bi-plus-circle me-1"></i>
                                                    Dodaj zamerku
                                                </button>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </div>

                            </form>

                        </div>

                    </div>

                    <!-- Tabela zamerki -->
                    <div class="card shadow-sm">
                        <div class="card-header bg-warning text-dark d-flex align-items-center">
                            <i class="bi bi-exclamation-triangle-fill me-2"></i>
                            <h5 class="mb-0 fw-bold">Zamerke</h5>
                        </div>

                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table class="table table-hover mb-0 table-bordered align-middle">
                                    <thead class="table-light">
                                        <tr>
                                            <th>Zamerka</th>
                                            <th>Napomena</th>
                                            <th>Uneto</th>
                                            <th>Uneo</th>
                                            <th>Izmenjeno</th>
                                            <th>Izmenio</th>
                                            <th class="text-center">Akcije</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="zam" items="${vezaneZamerke}">
                                            <tr>
                                                <td>${zam.zamerka.naziv}</td>
                                                <td>${zam.napomena}</td>
                                                <td><fmt:formatDate value="${zam.datumUnos}" pattern="dd.MM.yyyy HH:mm"/></td>
                                                <td>${zam.userUnos}</td>
                                                <td><fmt:formatDate value="${zam.datumIzmena}" pattern="dd.MM.yyyy HH:mm"/></td>
                                                <td>${zam.userIzmena}</td>

                                                <td class="text-center">
                                                    <c:if test="${not viewMode}">
                                                        <!-- Izmena -->
                                                        <form action="<c:url value='/gemba/zamerka/edit'/>" 
                                                              method="post" class="d-inline">
                                                            <input type="hidden" name="headerAktivnost" value="${headerAktivnost}" />
                                                            <input type="hidden" name="lastLisProvereAktZamerka" value="${zam.IDLisProvereAktZamerka}">
                                                            <input type="hidden" name="idAktivnosti" value="${idAktivnosti}" />
                                                            <button class="btn btn-sm btn-outline-primary me-1" title="Izmena">
                                                                <i class="bi bi-pencil-square"></i>
                                                            </button>
                                                        </form>

                                                        <!-- Brisanje -->
                                                        <form class="d-inline">
                                                            <button type="button"
                                                                    class="btn btn-sm btn-outline-danger"
                                                                    data-bs-toggle="modal"
                                                                    data-bs-target="#confirmDeleteModal"
                                                                    data-id="${zam.IDLisProvereAktZamerka}"
                                                                    data-id-aktivnosti="${idAktivnosti}"
                                                                    data-header-aktivnost="${headerAktivnost}"
                                                                    data-action="<c:url value='/gemba/zamerka/delete'/>"
                                                                    data-title="ZAMERKU?"
                                                                    data-name="|ZAMERKA=${zam.zamerka.naziv}|"
                                                                    title="Obriši">
                                                                <i class="bi bi-trash-fill"></i>
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </main>

        <!-- FOOTER -->
        <footer>
            <jsp:include page="/WEB-INF/template/footer.jsp"/>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>