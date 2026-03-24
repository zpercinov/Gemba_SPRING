
<%@ page import="com.hemofarm.Gemba_SPRING.util.EnumGembaStatus" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    // Uzimanje trenutnog koraka
    Integer currentStep = (Integer) request.getAttribute("currentStep");
    if(currentStep == null) {
        currentStep = (Integer) request.getSession().getAttribute("currentStep");
    }
    if(currentStep == null) currentStep = 0;

    // Enum sa statusima
    EnumGembaStatus[] statuses = EnumGembaStatus.values();
%>

<div class="card mb-2 shadow-sm">
    <div class="card-body p-2">

        <div class="d-flex justify-content-between align-items-center flex-wrap">
            <% for(int i=0; i<statuses.length; i++) {
                boolean active = i <= currentStep;
                boolean current = i == currentStep;
            %>
                <div class="d-flex flex-column align-items-center mb-2" style="min-width:90px;">
                    <div class="rounded-circle d-flex justify-content-center align-items-center mb-1
                        <%= current ? "current-step" : "" %>"
                        style="width:35px; height:35px; 
                               <%= active ? "background-color:#f58220; color:white;" 
                                         : "border:2px solid #ced4da; color:#6c757d;" %>">
                        <i class="bi <%= statuses[i].getIcon() %> fs-5"></i>
                    </div>
                    <small style="<%= active ? "color:#f58220; font-weight:600;" : "color:#6c757d;" %> text-center;">
                        <%= statuses[i].getLabel() %>
                    </small>
                </div>
            <% } %>
        </div>

        <div class="progress mt-3" style="height:6px;">
            <div class="progress-bar" style="background-color:#f58220; width:<%= ((currentStep+1) * 100 / statuses.length) %>%;" role="progressbar"></div>
        </div>
    </div>
</div>

<!-- CSS za trenutni korak -->
<style>
    .current-step {
        box-shadow: 0 0 8px 2px rgba(245, 130, 32, 0.7);
        animation: pulse 1.2s infinite;
    }

    @keyframes pulse {
        0% { transform: scale(1); box-shadow: 0 0 8px 2px rgba(245, 130, 32, 0.7); }
        50% { transform: scale(1.1); box-shadow: 0 0 12px 4px rgba(245, 130, 32, 0.9); }
        100% { transform: scale(1); box-shadow: 0 0 8px 2px rgba(245, 130, 32, 0.7); }
    }
</style>
