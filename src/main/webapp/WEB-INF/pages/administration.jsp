<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">
        <meta charset="UTF-8">
        <title>Administracija korisnika</title>
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
            .navbar .navbar-brand {
                font-weight: 700;
                letter-spacing: 0.5px;
            }
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
            .btn-add {
                background-color: #f58220;
                color: white;
                font-weight: 600;
                padding: 10px 20px;
                border-radius: 10px;
                transition: all 0.2s;
            }
            .btn-add:hover {
                background-color: #d96f1a;
                transform: translateY(-2px);
            }

            .form-control:focus {
                border-color: #f58220 !important;
                box-shadow: 0 0 10px rgba(245,130,32,0.3);
            }

            .card:hover {
                transform: translateY(-3px);
                transition: transform 0.3s ease, box-shadow 0.3s ease;
                box-shadow: 0 12px 25px rgba(245,130,32,0.25);
            }

            .profile-card {
                border-radius: 15px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.19);
                border:2px solid #e0e0e0;
                background-color:white;
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
                    <div class="page-header d-flex justify-content-between align-items-center">
                        <h2 class="fw-bold">Administracija korisnika</h2>
                    </div>

                    <!-- Forma za dodavanje korisnika -->
                    <div class="card shadow-sm mb-5">
                        <div class="card-body">
                            <form action="<c:url value='/administration/save'/>" method="post">
                                <c:if test="${not empty idKorisnika}">
                                    <input type="hidden" name="id" value="${idKorisnika}">
                                </c:if> 

                                <div class="row g-3">
                                    <div class="col-md-4">
                                        <label for="korisnickoIme" class="form-label">Korisničko ime *</label>
                                        <input type="text" class="form-control" id="korisnickoIme" name="korisnickoIme" value="${korisnickoIme}" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="imePrezime" class="form-label">Ime i prezime *</label>
                                        <input type="text" class="form-control" id="imePrezime" name="imePrezime" value="${imePrezime}" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="lozinka" class="form-label">Lozinka *</label>
                                        <input type="password" class="form-control" id="lozinka" name="lozinka" value="${lozinka}" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="rola" class="form-label">Rola *</label>
                                        <select id="rola" name="idRola" class="form-select" required>
                                          <option value="" <c:if test="${idRola == null}">selected</c:if>>-izaberi-</option>
 
                                            <c:forEach var="r" items="${role}">
                                                <option value="${r.IDRole}"
                                                        <c:if test="${r.IDRole == idRola}">selected</c:if>>
                                                    ${r.naziv}
                                                </option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                    <div class="col-md-6">
                                        <label for="sajt" class="form-label">Sajt *</label>
                                        <select id="sajt" name="idSajt" class="form-select" required>
                                          <option value="" <c:if test="${idSajt == null}">selected</c:if>>-izaberi-</option>
  
                                            <c:forEach var="s" items="${sajtovi}">
                                                <option value="${s.IDSajt}"
                                                        <c:if test="${s.IDSajt == idSajt}">selected</c:if>>
                                                    ${s.ime}
                                                </option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>

                                <div class="mt-4 text-end">
                                    <c:choose>
                                        <c:when test="${not empty korisnickoIme}">
                                            <button type="submit" class="btn btn-warning btn-lg">
                                                <i class=" bi bi-pencil-fill me-1"></i>Izmeni korisnika
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="submit" class="btn btn-primary btn-lg">
                                                <i class="bi bi-plus-circle me-1"></i>Dodaj korisnika
                                            </button>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Tabela korisnika -->
                    <div class="card shadow-sm">
                        <div class="card-header bg-warning text-dark d-flex align-items-center">
                            <i class="bi bi-people-fill me-2"></i>
                            <h5 class="mb-0 fw-bold">Korisnici</h5>
                        </div>

                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table class="table table-hover mb-0 table-bordered align-middle">
                                    <thead class="table-light">
                                        <tr>
                                            <th>ID</th>
                                            <th>Korisničko ime</th>
                                            <th>Ime i prezime</th>
                                            <th>Rola</th>
                                            <th>Sajt</th>
                                            <th>Uneto</th>
                                            <th>Uneo</th>
                                            <th>Izmenjeno</th>
                                            <th>Izmenio</th>
                                            <th class="text-center">Akcije</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="kor" items="${korisnici}">
                                            <tr>
                                                <td>${kor.iDKorisnik}</td>
                                                <td>${kor.korisnickoIme}</td>
                                                <td>${kor.imePrezime}</td>
                                                <td>${kor.rola.naziv}</td>
                                                <td>${kor.sajt.ime}</td>
                                                <td><fmt:formatDate value="${kor.datumUnosa}" pattern="dd.MM.yyyy HH:mm"/></td>
                                                <td>${kor.korisnikUnos.korisnickoIme}</td>
                                                <td><fmt:formatDate value="${kor.datumIzmene}" pattern="dd.MM.yyyy HH:mm"/></td>
                                                <td>${kor.korisnikIzmena.korisnickoIme}</td>
                                                <td class="text-center">
                                                    <!-- Izmena -->
                                                    <form action="<c:url value='/administration/edit'/>" method="post" class="d-inline">
                                                        <input type="hidden" name="id" value="${kor.iDKorisnik}">
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
                                                                data-id="${kor.iDKorisnik}"
                                                                data-action="<c:url value='/administration/delete'/>"
                                                                data-title="Korisnika?"
                                                                data-name="|ID=${kor.iDKorisnik}|  |KORISNIČKO IME=${kor.korisnickoIme}|"
                                                                title="Obriši">
                                                            <i class="bi bi-trash-fill"></i>
                                                        </button>
                                                    </form>

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