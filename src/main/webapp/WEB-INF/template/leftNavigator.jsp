<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<div class="d-flex flex-column left-nav shadow-lg">

    <!-- Navigacija -->
    <div class="nav flex-column mb-auto flex-grow-1 gap-2">

        <div class="nav-item">
            <form action="<c:url value='/home'/>" method="post">
                <button type="submit" class="nav-link nav-btn d-flex align-items-center justify-content-start w-100">
                    <i class="bi bi-house-door-fill me-2"></i> Početna
                </button>
            </form>
        </div>

        <div class="nav-item">
            <form action="<c:url value='/gemba/new'/>" method="post">
                <button type="submit" class="nav-link nav-btn d-flex align-items-center justify-content-start w-100">
                    <i class="bi bi-pencil-fill me-2"></i> Unos
                </button>
            </form>
        </div>

        <div class="nav-item">
            <form action="<c:url value='/statistic'/>" method="post">
                <button type="submit" class="nav-link nav-btn d-flex align-items-center justify-content-start w-100">
                    <i class="bi bi-bar-chart-fill me-2"></i> Statistika
                </button>
            </form>
        </div>

        <div class="nav-item">
            <form action="<c:url value='/profile'/>" method="post">
                <button type="submit" class="nav-link nav-btn d-flex align-items-center justify-content-start w-100">
                    <i class="bi bi-person-square me-2"></i> Profil
                </button>
            </form>
        </div>

        <!-- Dugme Administracija vidljivo samo Administratoru -->
        <c:if test="${sessionScope.isAdmin}">
            <div class="nav-item">
                <form action="<c:url value='/administration'/>" method="post">
                    <button type="submit" class="nav-link nav-btn d-flex align-items-center justify-content-start w-100">
                        <i class="bi bi-gear-fill me-2"></i> Administracija
                    </button>
                </form>
            </div>
        </c:if>

    </div>

    <!-- Dno sa logoom / nazivom -->
    <a href="#" class="d-flex align-items-center mt-auto text-white text-decoration-none fs-5 fw-bold footer-label">
        <i class="bi bi-speedometer2 me-2"></i> Navigacija
    </a>

</div>

<style>
    /* Left navigation */
    .left-nav {
        width: 240px;
        height: calc(100vh - 56px); /* ispod navbar-a */
        position: fixed;
        left: 0;
        top: 56px;
        background: linear-gradient(180deg, #3a3f44, #5a6268);
        padding: 1rem;
        border-radius: 0 15px 15px 0;
        display: flex;
        flex-direction: column;
    }

    /* Dugmad */
    .nav-btn {
        background: transparent;
        color: #ffffff;
        font-weight: 600;
        border-radius: 10px;
        padding: 0.65rem 0.8rem;
        transition: all 0.3s ease;
        position: relative;
        overflow: hidden;
    }

    .nav-btn i {
        font-size: 1.2rem;
        transition: transform 0.3s;
    }

    /* Hover animacija dugmeta */
    .nav-btn::before {
        content: "";
        position: absolute;
        left: -100%;
        top: 0;
        width: 100%;
        height: 100%;
        background: rgba(245, 130, 32, 0.2);
        transition: left 0.3s;
        border-radius: 10px;
    }

    .nav-btn:hover::before {
        left: 0;
    }

    .nav-btn:hover {
        color: #f58220;
        transform: translateX(5px);
    }

    .nav-btn:hover i {
        transform: translateX(3px);
    }

    /* Aktivno dugme */
    .nav-link.active {
        background-color: #f58220 !important;
        color: #fff !important;
    }

    /* Dno sa logoom */
    .footer-label {
        padding: 0.5rem 0.8rem;
        border-top: 1px solid rgba(255,255,255,0.3);
        transition: color 0.3s;
    }

    .footer-label:hover {
        color: #f58220;
    }

    /* Responsive gap */
    .nav {
        gap: 0.5rem;
    }
</style>