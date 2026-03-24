<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <meta charset="UTF-8">
        <title>Unos gembe</title>
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
            label {
                font-weight: 600;
            }
            .btn-large {
                padding: 10px 18px;
                font-size: 17px;
                border-radius: 8px;
            }
            table thead {
                background-color: #fafafa;
            }
            table th {
                font-weight: 600;
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
        </style>
    </head>
    <body class="d-flex flex-column min-vh-100">

        <!-- Navbar -->
        <jsp:include page="/WEB-INF/template/header.jsp"/>


        <!-- Sistemske poruke -->
        <jsp:include page="/WEB-INF/template/messages.jsp"/>
        <jsp:include page="/WEB-INF/template/confirmDeleteModal.jsp"/>
        <jsp:include page="/WEB-INF/template/confirmArchiveModal.jsp"/>

        <!-- Main content -->
        <div class="container-fluid flex-grow-1">
            <div class="row">

                <!-- Left Menu -->
                <div class="col-md-2 p-3">
                    <jsp:include page="/WEB-INF/template/leftNavigator.jsp"/>
                </div>

                <!-- Main Area -->
                <div class="col-md-10">

                    <!-- ACTION BUTTONS -->
                    <div class="d-flex flex-wrap gap-2 mb-4">
                        <form action="<c:url value='/gemba/new'/>" method="post">
                            <button class="btn btn-primary btn-large ${zakljucano ? 'd-none' : ''}" style="min-width: 220px;">
                                <i class="bi bi-plus-circle"></i> Novi unos
                            </button>
                        </form>

                        <c:if test="${not empty gemba.IDLisProvere}">
                            <button type="button"
                                    class="btn btn-danger btn-large ${zakljucano ? 'd-none' : ''}"
                                    data-bs-toggle="modal"
                                    data-bs-target="#confirmDeleteModal"
                                    data-id="${gemba.IDLisProvere}"
                                    data-action="<c:url value='/gemba/delete'/>"
                                    data-title="Gembu?"
                                    data-name="|ID=${gemba.IDLisProvere}|"
                                    style="min-width: 220px;">
                                <i class="bi bi-trash"></i> Obriši gembu
                            </button>
                        </c:if>
                    </div>

                    <!-- AUDIT TRAIL -->
                    <c:if test="${not empty gemba}">
                        <div class="card mb-4 border-secondary bg-light">
                            <div class="card-header d-flex justify-content-between align-items-center bg-white border-bottom border-secondary">
                                <h5 class="mb-0"><i class="bi bi-clock-history me-2"></i> Audit Trail</h5>
                                <span class="badge bg-secondary">Read-only</span>
                            </div>
                            <div class="card-body row g-3">
                                <div class="col-md-2">
                                    <label class="form-label">ID</label>
                                    <input class="form-control" readonly value="${gemba.IDLisProvere}">
                                </div>
                                <div class="col-md-3">
                                    <label class="form-label">Uneo</label>
                                    <input class="form-control" readonly value="${gemba.userUnos}">
                                </div>
                                <div class="col-md-3">
                                    <label class="form-label">Uneto</label>
                                    <input class="form-control" readonly value="<fmt:formatDate value='${gemba.datumUnos}' pattern='dd.MM.yyyy HH:mm:ss'/>">
                                </div>
                                <div class="col-md-2">
                                    <label class="form-label">Izmenio</label>
                                    <input class="form-control" readonly value="${gemba.userIzmena}">
                                </div>
                                <div class="col-md-2">
                                    <label class="form-label">Izmenjeno</label>
                                    <input class="form-control" readonly value="<fmt:formatDate value='${gemba.datumIzmena}' pattern='dd.MM.yyyy HH:mm:ss'/>">
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <!-- FORM -->
                    <form action="<c:url value='/gemba/save'/>" method="post">

                        <c:if test="${not empty gemba.IDLisProvere}">
                            <input type="hidden" name="id" value="${gemba.IDLisProvere}">
                        </c:if>

                        <!-- VRSTA GEMBE -->
                        <div class="card section-card mb-4 border-warning" style="border-width: 3px;">
                            <div class="section-header d-flex justify-content-between align-items-center">
                                <h5><i class="bi-ui-radios-grid me-2 text-warning"></i> Vrsta Gembe</h5>
                                <c:if test="${zakljucano || zakljucano_vrsta_gemba}">
                                    <span class="badge bg-secondary">Read-only</span>
                                </c:if>

                            </div>
                            <div class="card-body row g-3">
                                <div class="col-md-4">
                                    <label class="form-label" style="font-size: 1.1rem; font-weight: 700; color:#d35400;">
                                        Gemba *
                                    </label>
                                    <select name="gembaVrsta"
                                            class="form-select form-select-lg"
                                            required
                                            ${zakljucano || zakljucano_vrsta_gemba ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.vrstaGembe == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="gv" items="${gembaVrste}">
                                            <option value="${gv.IDVrstaGem}"
                                                    ${gemba.vrstaGembe != null && gemba.vrstaGembe.IDVrstaGem == gv.IDVrstaGem ? 'selected' : ''}>
                                                ${gv.naziv}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano || zakljucano_vrsta_gemba}">
                                        <input type="hidden" name="gembaVrsta" value="${gemba.vrstaGembe.IDVrstaGem}">
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <!-- LOKACIJA -->

                        <div class="card section-card mb-4 border-warning" style="border-width: 3px;">
                            <div class="section-header d-flex justify-content-between align-items-center">
                                <h5><i class="bi bi-geo-alt me-2"></i> Lokacija gembe</h5>
                                <c:if test="${zakljucano}">
                                    <span class="badge bg-secondary">Read-only</span>
                                </c:if>
                            </div>
                            <div class="card-body row g-3">
                                <div class="col-md-3">
                                    <label>Klaster *</label>
                                    <select name="klaster" class="form-select" required ${zakljucano ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.klaster == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="k" items="${klasteri}">
                                            <option value="${k.IDCluster}" ${gemba.klaster != null && gemba.klaster.IDCluster == k.IDCluster ? 'selected' : ''}>${k.naziv}</option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="klaster" value="${gemba.klaster.IDCluster}">
                                    </c:if>
                                </div>
                                <div class="col-md-3">
                                    <label>Sajt *</label>
                                    <select name="sajt" class="form-select" required ${zakljucano ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.sajt == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="s" items="${sajtovi}">
                                            <option value="${s.IDSajt}" ${gemba.sajt != null && gemba.sajt.IDSajt == s.IDSajt ? 'selected' : ''}>${s.ime}</option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="sajt" value="${gemba.sajt.IDSajt}">
                                    </c:if>
                                </div>
                                <div class="col-md-3">
                                    <label>Funkcija *</label>
                                    <select name="funkcija" class="form-select" required ${zakljucano ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.funkcija  == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="f" items="${funkcije}">
                                            <option value="${f.IDFun}" ${gemba.funkcija  != null && gemba.funkcija .IDFun == f.IDFun ? 'selected' : ''}>${f.ime}</option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="funkcija" value="${gemba.funkcija.IDFun}">
                                    </c:if>
                                </div>
                                <div class="col-md-3">
                                    <label>Odeljenje *</label>
                                    <select name="odeljenje" class="form-select" required ${zakljucano ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.odeljenje  == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="o" items="${odeljenja}">
                                            <option value="${o.IDOdeljenje}" ${gemba.odeljenje  != null && gemba.odeljenje.IDOdeljenje == o.IDOdeljenje ? 'selected' : ''}>${o.ime}</option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="odeljenje" value="${gemba.odeljenje.IDOdeljenje}">
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <!-- OSNOVNI PODACI -->
                        <div class="card section-card mb-4">
                            <div class="section-header d-flex justify-content-between align-items-center">
                                <h5><i class="bi bi-info-circle me-2"></i> Osnovni podaci</h5>
                                <c:if test="${zakljucano}">
                                    <span class="badge bg-secondary">Read-only</span>
                                </c:if>
                            </div>
                            <div class="card-body row g-3">
                                <div class="col-md-3">
                                    <label>Datum *</label>
                                    <input type="date" name="datum" class="form-control"
                                           value="<fmt:formatDate value='${datum}' pattern='yyyy-MM-dd'/>"
                                           required ${zakljucano ? 'disabled' : ''}>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="datum" value="<fmt:formatDate value='${datum}' pattern='yyyy-MM-dd'/>">
                                    </c:if>
                                </div>
                                <div class="col-md-4">
                                    <label>Nosilac gembe *</label>
                                    <select name="nosilac" class="form-select" required ${zakljucano ? 'disabled' : ''}>
                                        <option value="" disabled ${gemba.nosilac == null ? 'selected' : ''}>- izaberi -</option>
                                        <c:forEach var="n" items="${nosioci}">
                                            <option value="${n.IDNos}" ${gemba.nosilac != null && gemba.nosilac.IDNos == n.IDNos ? 'selected' : ''}>${n.naziv}</option>
                                        </c:forEach>
                                    </select>
                                    <c:if test="${zakljucano}">
                                        <input type="hidden" name="nosilac" value="${gemba.nosilac.IDNos}">
                                    </c:if>
                                </div>
                            </div>
                        </div>


                        <!-- SAVE BUTTON -->

                        <c:if test="${gemba.status != 5}">
                            <div class="d-flex justify-content-end mb-4">
                                <button type="submit"
                                        class="btn btn-success btn-large ${zakljucano ? 'd-none' : ''}"
                                        style="min-width: 220px;">
                                    <i class="bi bi-floppy"></i> Sačuvaj gembu
                                </button>
                            </div>
                        </c:if>


                    </form>


                    <!-- INICIJALIZACIJA AKTIVNOSTI -->
                    <c:if test="${not empty gemba.IDLisProvere}">
                        <div class="d-flex justify-content-end mb-4">
                            <form action="<c:url value='/gemba/aktivnosti/init'/>" method="post">

                                <input type="hidden" name="gembaId" value="${gemba.IDLisProvere}">
                                <input type="hidden" name="idVrstaGem" value="${gemba.vrstaGembe.IDVrstaGem}">
                                <button type="submit" class="btn btn-primary btn-large ${zakljucano ? 'd-none' : ''}" style="min-width: 220px;">
                                    <i class="bi bi-play-circle"></i> Inicijalizuj aktivnosti
                                </button>
                            </form>
                        </div>
                    </c:if>

                    <!-- Arhiviraj -->
                    <c:if test="${gemba.status == 5 && not requestScope.zakljucano}">
                        <div class="d-flex justify-content-end mb-4">
                            <button type="button" 
                                    class="btn btn-warning btn-large"
                                    data-bs-toggle="modal"
                                    data-bs-target="#confirmArchiveModal"
                                    data-id="${gemba.IDLisProvere}"
                                    data-action="<c:url value='/gemba/archive'/>"
                                    style="min-width: 220px;">
                                <i class="bi-lock-fill"></i> Arhiviraj
                            </button>
                        </div>
                    </c:if>

                    <!-- TABELA AKTIVNOSTI -->
                    <c:if test="${not empty aktivnostiListaProvera}">
                        <div class="card mb-4 shadow-sm">
                            <div class="card-header bg-primary text-white">
                                <h5 class="mb-0"><i class="bi bi-check2-all me-2"></i> Aktivnosti</h5>
                            </div>
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-hover mb-0">
                                        <thead class="table-light">
                                            <tr>
                                                <th>Aktivnost</th>
                                                <th style="width:200px">Ishod</th>
                                                <th>Uneo</th>
                                                <th>Uneto</th>
                                                <th>Izmenio</th>
                                                <th>Izmenjeno</th>
                                                <th>Zamerka</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="a" items="${aktivnostiListaProvera}">
                                                <tr>
                                                    <td><c:out value="${a.aktivnost.naziv}"/></td>
                                                    <td>
                                                        <form action="<c:url value='/gemba/aktivnosti/ishod/update'/>"
                                                              method="post"
                                                              style="display:inline;">

                                                            <input type="hidden"
                                                                   name="LisProvereAktID"
                                                                   value="${a.IDLisProvereAkt}" />

                                                            <c:set var="disableIshod"
                                                                   value="${zakljucano || a.hasZamerka}" />

                                                            <select name="ishodId"
                                                                    class="form-select form-select-sm
                                                                    ${a.ishod.naziv == 'OK' ? 'ishod-ok_boja' :
                                                                      (a.ishod.naziv == 'NIJE OK' ? 'ishod-nije_ok_boja' : 'ishod-nije_provereno_boja')}"
                                                                    onchange="this.form.submit();"
                                                                    ${disableIshod ? 'disabled' : ''}
                                                                    title="${a.hasZamerka ? 'Ishod je zaključan jer postoji zamerka' : ''}">

                                                                <c:forEach var="i" items="${ishodi}">
                                                                    <option value="${i.IDIshod}"
                                                                            ${a.ishod.IDIshod == i.IDIshod ? 'selected' : ''}>
                                                                        ${i.naziv}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>


                                                            <c:if test="${disableIshod}">
                                                                <input type="hidden"
                                                                       name="ishodId"
                                                                       value="${a.ishod.IDIshod}" />
                                                            </c:if>

                                                        </form>
                                                    </td>

                                                    <td><c:out value="${a.userUnos}"/></td>
                                                    <td><fmt:formatDate value="${a.datumUnos}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
                                                    <td><c:out value="${a.userIzmena}"/></td>
                                                    <td><fmt:formatDate value="${a.datumIzmena}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
                                                    <td>
                                                        <c:choose>

                                                            <c:when test="${zakljucano && a.hasZamerka}">
                                                                <form action="<c:url value='/gemba/zamerka'/>"
                                                                      method="post"
                                                                      target="_blank"
                                                                      style="display:inline;">
                                                                    <input type="hidden" name="idListaAktivnosti" value="${a.IDLisProvereAkt}" />
                                                                    <input type="hidden" name="idAktivnosti" value="${a.aktivnost.IDAktivnosti}" />
                                                                    <input type="hidden" name="viewMode" value="true" />
                                                                    <button type="submit" class="btn btn-sm btn-secondary" title="Pogledaj zamerku">
                                                                        <i class="bi bi-eye-fill"></i>
                                                                    </button>
                                                                </form>
                                                            </c:when>


                                                            <c:when test="${not zakljucano && a.hasZamerka}">
                                                                <form action="<c:url value='/gemba/zamerka'/>"
                                                                      method="post"
                                                                      style="display:inline;">
                                                                    <input type="hidden" name="idListaAktivnosti" value="${a.IDLisProvereAkt}" />
                                                                    <input type="hidden" name="idAktivnosti" value="${a.aktivnost.IDAktivnosti}" />
                                                                    <button type="submit" class="btn btn-sm btn-warning" title="Izmeni zamerku">
                                                                        <i class="bi bi-pencil-square"></i>
                                                                    </button>
                                                                </form>
                                                            </c:when>


                                                            <c:when test="${not zakljucano && not a.hasZamerka}">
                                                                <form action="<c:url value='/gemba/zamerka'/>"
                                                                      method="post"
                                                                      style="display:inline;">
                                                                    <input type="hidden" name="idListaAktivnosti" value="${a.IDLisProvereAkt}" />
                                                                    <input type="hidden" name="idAktivnosti" value="${a.aktivnost.IDAktivnosti}" />
                                                                    <button type="submit" class="btn btn-sm btn-primary" title="Pokreni zamerku">
                                                                        <i class="bi bi-play-circle-fill"></i>
                                                                    </button>
                                                                </form>
                                                            </c:when>


                                                            <c:otherwise>

                                                            </c:otherwise>
                                                        </c:choose>


                                                        <button type="button"
                                                                class="btn btn-sm btn-danger ${zakljucano ? 'd-none' : ''}"
                                                                data-bs-toggle="modal"
                                                                data-bs-target="#confirmDeleteModal"
                                                                data-id="${a.IDLisProvereAkt}"
                                                                data-action="<c:url value='/gemba/aktivnosti/delete'/>"
                                                                data-title="Aktivnost?"
                                                                data-name="|AKTIVNOST=${a.aktivnost.naziv}| |ISHOD=${a.ishod.naziv}|"
                                                                title="Obriši">
                                                            <i class="bi bi-trash-fill"></i>
                                                        </button>
                                                    </td>






                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${empty aktivnostiListaProvera}">


                        <div class="alert alert-warning">
                            Nema aktivnosti za prikaz.
                        </div>
                    </c:if>

                    <jsp:include page="/WEB-INF/template/stepStatus.jsp"/>
                </div>





            </div>
        </div>



        <!-- Status panel ispod glavnog sadržaja -->





        <!-- Footer -->
        <footer>


            <jsp:include page="/WEB-INF/template/footer.jsp"/>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>