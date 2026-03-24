<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="sr">
<head>
    <meta charset="UTF-8">
    <title>Stranica u izradi</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>">

    <style>
        body {
            background: #f8f9fa;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .uc-card {
            padding: 40px;
            background: white;
            border-radius: 20px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .uc-icon {
            font-size: 70px;
            color: #0d6efd;
        }
    </style>
</head>

<body>
    <div class="uc-card">
        <div class="uc-icon mb-3">
            <i class="bi bi-tools"></i>
        </div>
        <h2>Stranica je u izradi</h2>
        <p class="text-muted mb-3">
            Trenutno radimo na sadržaju. Molimo Vas da pokušate kasnije.
        </p>
        
        <form action="<c:url value='/app/home'/>" method="post">
            <button type="submit" class="btn btn-primary">
                <i class="bi bi-house-door"></i> Povratak na početnu
            </button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>