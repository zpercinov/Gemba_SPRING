<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
<head>
    <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">
    <meta charset="UTF-8">
    <title>Moj Profil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to bottom, #ffffff, #f4f4f4);
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        main { flex-grow: 1; }
        .navbar { background-color: #f58220 !important; }
        .navbar .navbar-brand { font-weight: 700; letter-spacing: 0.5px; }
        .page-header {
            padding: 25px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.08);
            margin-bottom: 30px;
            border-left: 6px solid #f58220;
        }
        .page-header h2 { font-weight: 700; color: #4d4d4f; }
        .btn-gemba {
            background-color: #f58220;
            color: white;
            font-weight: 600;
            padding: 10px 20px;
            border-radius: 10px;
            transition: all 0.2s;
        }
        .btn-gemba:hover { background-color: #d96f1a; transform: translateY(-2px); }
        .card:hover { transform: translateY(-3px); transition: transform 0.3s ease, box-shadow 0.3s ease; box-shadow: 0 12px 25px rgba(245,130,32,0.25);}
        .form-control:focus { border-color: #f58220 !important; box-shadow: 0 0 10px rgba(245,130,32,0.3); }
        .profile-card { border-radius: 15px; box-shadow: 0 4px 12px rgba(0,0,0,0.19); border:2px solid #e0e0e0; background-color:white; }
    </style>
</head>
<body>

<!-- Navbar -->
<jsp:include page="/WEB-INF/template/header.jsp"/>

<!-- Sistemske poruke -->
<jsp:include page="/WEB-INF/template/messages.jsp"/>

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
                <h2>Moj Profil</h2>
            </div>

            <!-- Profil kartica -->
            <div class="card profile-card p-4 mb-4">
                <form method="post" action="<c:url value='/profile/password/save'/>">
                    <c:set var="korisnik" value="${sessionScope.loggedUser}" />

                    <div class="mb-3">
                        <label class="form-label"><b>Korisničko ime</b></label>
                        <input type="text" class="form-control" value="${korisnik.korisnickoIme}" readonly>
                    </div>

                    <div class="mb-3">
                        <label class="form-label"><b>Ime i prezime</b></label>
                        <input type="text" class="form-control" value="${korisnik.imePrezime}" readonly>
                    </div>

                    <div class="mb-3">
                        <label class="form-label"><b>Rola</b></label>
                        <input type="text" class="form-control" value="${korisnik.rola.naziv}" readonly>
                    </div>

                    <div class="mb-3">
                        <label class="form-label"><b>Nova lozinka</b></label>
                        <input type="password" class="form-control" name="novaLozinka" placeholder="Unesite novu lozinku">
                    </div>

                    <div class="mb-3">
                        <label class="form-label"><b>Potvrda lozinke</b></label>
                        <input type="password" class="form-control" name="potvrdaLozinke" placeholder="Potvrdite novu lozinku">
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-gemba fw-bold">
                            <i class="bi bi-save me-2"></i> Sačuvaj promene
                        </button>
                    </div>
                </form>
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