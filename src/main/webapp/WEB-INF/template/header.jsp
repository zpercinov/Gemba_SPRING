<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container-fluid">

        <!-- Dinamički actionMode -->
        <span class="navbar-brand fw-bold">
            <i class="bi ${actionMode.iconClass} me-2"></i>
            ${actionMode.displayText}
        </span>

        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav mb-2 mb-lg-0 align-items-center">

                <!-- Logged user info i logout -->
                <c:if test="${not empty sessionScope.loggedUser}">
                    <li class="nav-item me-3 d-flex align-items-center">
                        <span class="navbar-text text-white fw-semibold">
                            <i class="bi bi-person-circle me-1"></i>
                            ${sessionScope.loggedUser.korisnickoIme} 
                            <small class="text-light fst-italic">(${sessionScope.loggedUser.rola.naziv})</small>
                        </span>
                    </li>

                    <li class="nav-item">
                        <form action="<c:url value='/logout'/>" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-outline-light btn-sm d-flex align-items-center">
                                <i class="bi bi-box-arrow-right me-1"></i> Odjavi se
                            </button>
                        </form>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>