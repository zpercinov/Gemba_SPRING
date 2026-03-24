<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="system-messages position-fixed top-0 end-0 p-3" style="z-index: 1055;">

    <!-- Uspeh -->
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success alert-dismissible fade show rounded-3 shadow-sm d-flex align-items-center slide-in" role="alert">
            <i class="bi bi-check-circle-fill fs-5 me-2"></i>
            <div>${successMessage}</div>
            <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

    <!-- Informacija -->
    <c:if test="${not empty infoMessage}">
        <div class="alert alert-info alert-dismissible fade show rounded-3 shadow-sm d-flex align-items-center slide-in" role="alert">
            <i class="bi bi-info-circle-fill fs-5 me-2"></i>
            <div>${infoMessage}</div>
            <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    
    <!-- Sesija istekla -->
<c:if test="${not empty expiredMessage}">
    <div class="alert alert-warning alert-dismissible fade show rounded-3 shadow-sm d-flex align-items-center slide-in" role="alert">
        <i class="bi bi-hourglass-split fs-5 me-2"></i>
        <div>${expiredMessage}</div>
        <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>


    <!-- Upozorenje -->
    <c:if test="${not empty warningMessage}">
        <div class="alert alert-warning alert-dismissible fade show rounded-3 shadow-sm d-flex align-items-center slide-in" role="alert">
            <i class="bi bi-exclamation-triangle-fill fs-5 me-2"></i>
            <div>${warningMessage}</div>
            <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

    <!-- Greška -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger alert-dismissible fade show rounded-3 shadow-sm d-flex align-items-center slide-in" role="alert">
            <i class="bi bi-x-circle-fill fs-5 me-2"></i>
            <div>${errorMessage}</div>
            <button type="button" class="btn-close ms-auto" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

</div>

<style>
    /* Sistem poruke – moderne i fensi */
    .system-messages .alert {
        font-family: 'Segoe UI', sans-serif;
        font-size: 0.95rem;
        min-width: 300px;
        max-width: 350px;
        margin-bottom: 0.5rem;
        opacity: 0;
        transform: translateX(100%);
        transition: all 0.5s ease;
    }

    /* Slide-in animacija */
    .system-messages .slide-in {
        opacity: 1;
        transform: translateX(0);
    }

    /* Hover efekat */
    .system-messages .alert:hover {
        transform: translateX(0) scale(1.02);
        box-shadow: 0 12px 25px rgba(0,0,0,0.2);
    }

    .system-messages .btn-close {
        outline: none;
    }
</style>

<script>
    // Automatsko zatvaranje posle 5 sekundi
    document.addEventListener("DOMContentLoaded", function () {
        const alerts = document.querySelectorAll('.system-messages .alert');
        alerts.forEach(function(alert) {
            setTimeout(() => {
                // Bootstrap metoda za zatvaranje alert-a
                const bsAlert = bootstrap.Alert.getOrCreateInstance(alert);
                bsAlert.close();
            }, 5000);
        });
    });
</script>
