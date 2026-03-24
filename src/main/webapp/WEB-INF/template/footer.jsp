<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer class="bg-light border-top shadow-sm mt-auto">
    <div class="container py-3 d-flex justify-content-center align-items-center gap-3 flex-wrap">
        <!-- Tekst -->
        <span class="text-muted fw-medium small">
            &copy; Student: Zoran Perčinov, br. indeksa: 2024/4151
        </span>

        <!-- Logo sa c:url -->
        <img src="<c:url value='/img/hf_grb.png'/>" 
             alt="Hemofarm Logo" 
             class="align-middle footer-logo">

        <!-- Kontakt sa c:url (ako treba, mali je mejl) -->
        <a href="mailto:zp20244151@student.fon.bg.ac.rs" 
           class="text-primary fw-semibold d-flex align-items-center text-decoration-none contact-link">
            <i class="bi bi-envelope-at-fill me-1"></i> Kontakt
        </a>
    </div>
</footer>

<style>
    footer {
        font-family: 'Segoe UI', sans-serif;
        font-size: 0.9rem;
    }

    /* Logo sa hover efektom */
    .footer-logo {
        height: 28px;
        transition: transform 0.3s;
    }
    .footer-logo:hover {
        transform: scale(1.2);
    }

    /* Kontakt link hover */
    .contact-link:hover {
        color: #f58220 !important;
        text-decoration: underline;
    }

    /* Malo elegantniji tekst */
    footer span {
        font-weight: 500;
        color: #4d4d4f;
    }

    /* Responsive spacing za flex-wrap */
    @media (max-width: 576px) {
        footer .container {
            flex-direction: column;
            gap: 8px;
        }
    }
</style>