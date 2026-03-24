<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gemba | Prijava</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

        <style>
            .login-image {
                background-image: url('<c:url value="/img/img_gemba.png"/>');
                background-size: 70%;
                background-repeat: no-repeat;
                background-position: center;
                min-height: 100%;
            }

            .btn-login-custom {
                background-color: #f58220;
                color: white;
                font-weight: 600;
                transition: 0.3s ease;
            }

            .btn-login-custom:hover {
                background-color: #d96f1a;
                transform: translateY(-2px);
                box-shadow: 0 4px 10px rgba(0,0,0,0.2);
            }
        </style>
    </head>
    <body class="bg-light">
        <!-- Sistemske poruke -->
        <jsp:include page="/WEB-INF/template/messages.jsp"/>
        
        <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <div class="row bg-white shadow rounded overflow-hidden w-100" style="max-width: 850px;">

                <!-- Leva slika -->
                <div class="col-md-6 d-none d-md-block login-image"></div>

                <!-- Desna login kartica -->
                <div class="col-md-6 p-5 text-center">
                    <img src="<c:url value='/img/hf_grb.png'/>" class="mb-3" alt="Hemofarm Logo" style="width: 120px;">

                    <h2 class="fw-bold" style="color:#f58220;">Prijava</h2>

                    <form action="<c:url value='/login'/>" method="post" class="mt-4">
                        <input type="hidden" name="action" value="login"/>

                        <!-- Username -->
                        <div class="text-start mb-3">
                            <label for="username" class="form-label fw-semibold">Korisničko ime</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                                <input type="text" class="form-control" id="korisnickoIme" name="korisnickoIme"
                                       placeholder="Unesite korisničko ime" required>
                            </div>
                        </div>

                        <!-- Password -->
                        <div class="text-start mb-3">
                            <label for="password" class="form-label fw-semibold">Lozinka</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                                <input type="password" class="form-control" id="lozinka" name="lozinka"
                                       placeholder="Unesite lozinku" required>
                            </div>
                        </div>

                        <!-- Dugme -->
                        <button type="submit" class="btn btn-login-custom w-100 py-2">
                            <i class="bi bi-box-arrow-in-right me-2"></i> Prijavi se
                        </button>

                        <p class="text-muted mt-4 mb-0" style="font-size:0.85rem;">
                            © <a href="mailto:zoran.percinov@hemofarm.com" class="text-decoration-none">Zoran Perčinov</a>,
                            IT sistemi kvaliteta, Hemofarm, 2025
                        </p>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>