<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="partials/sidebar.jsp" %>


<!-- AQUI VA EL CONTENIDO -->
<div id="content-page" class="content-page">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">


                <%@include file="partials/profile-header.jsp"%>


                <%@include file="partials/nav-profile.jsp"%>
            </div>
            <div class="col-sm-12">
                <!-- TAB ACTIVIDAD -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="timeline" role="tabpanel">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-4">

                                    <%@include file="partials/calificacion.jsp"%>

                                    <%@include file="partials/nav-profile-activity.jsp"%>

                                </div>
                                <div class="col-lg-8">

                                    <div class="card">

                                        <div class="card-body">

                                                    <h4>Mis Solicitudes de Adopción</h4>
                                                    <hr>
                                                    <ul class="request-list list-inline m-0 p-0">

                                                        <c:forEach items="${solicitudes}" var="solicitud">
                                                            <li
                                                                    class="d-flex flex-nowrap align-items-center  justify-content-between flex-wrap">
                                                                <div class="d-flex flex-nowrap w-50">
                                                                    <div class="user-img img-fluid flex-shrink-0">
                                                                        <img src="data:image/jpg;base64,${solicitud.publicacion.mascota.foto}" alt="story-img"
                                                                             class="rounded-circle avatar-40"
                                                                             loading="lazy">
                                                                    </div>
                                                                    <div class="flex-grow-1 ms-3">
                                                                        <h6><strong>${solicitud.publicacion.mascota.nombre}</strong> <small
                                                                                class="text-muted">de <a
                                                                                href="#">${solicitud.publicacion.mascota.usuario.nombre}</a></small></h6>
                                                                        <p class="mb-0"><small><script>getLongTime("${solicitud.created_at}")</script></small></p>
                                                                    </div>
                                                                </div>


                                                                <div class="d-flex flex-nowrap align-items-center justify-content-between w-100 mt-2 mt-md-0">
                                                                    <div class="d-flex align-items-center">

                                                                        <c:if test="${solicitud.estado.toString() eq 'PENDIENTE'}">
                                                                            <span class="badge badge-pill bg-soft-warning me-3 ms-2">
                                                                            <i class="fa-solid fa-clock"></i>
                                                                            ${solicitud.estado}
                                                                             </span>
                                                                        </c:if>
                                                                        <c:if test="${solicitud.estado.toString() eq 'ACEPTADA'}">
                                                                            <span class="badge badge-pill bg-soft-success me-3 ms-2">
                                                                            <i class="fa-solid fa-circle-check"></i>
                                                                            ${solicitud.estado}
                                                                             </span>
                                                                        </c:if>
                                                                    </div>
                                                                    <div class="confirm-click-btn">
                                                                        <a href="${pageContext.request.contextPath}/solicitud/adoptante?code=${solicitud.codigo}&target=perfil"
                                                                           class="me-3 btn btn-primary rounded confirm-btn">Ver Estado</a>

                                                                    </div>
                                                                    <c:if test="${solicitud.estado.toString() eq 'PENDIENTE'}">
                                                                        <a class="btn btn-secondary" onclick="confirmCancel(this)" action="${pageContext.request.contextPath}/solicitud/cancelar?code=${solicitud.codigo}&target=perfil" href="javascript:void(0);">
                                                                            Cancelar Solicitud
                                                                        </a>
                                                                    </c:if>

                                                                </div>
                                                            </li>
                                                        </c:forEach>

                                                        <c:if test="${empty solicitudes}">
                                                            <p class="text-muted text-center">No se encontraron solicitudes.</p>
                                                        </c:if>


                                                    </ul>


                                        </div>
                                    </div>

                                    <div class="card">

                                        <div class="card-body">

                                            <h4>Solicitudes Cerradas</h4>
                                            <hr>
                                            <ul class="request-list list-inline m-0 p-0">

                                                <c:forEach items="${solicitudes_cerradas}" var="solicitud_cerrada">
                                                    <li
                                                            class="d-flex flex-nowrap align-items-center  justify-content-between flex-wrap">
                                                        <div class="d-flex flex-nowrap w-100">
                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                <img src="data:image/jpg;base64,${solicitud_cerrada.publicacion.mascota.foto}" alt="story-img"
                                                                     class="rounded-circle avatar-40"
                                                                     loading="lazy">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h6><strong>${solicitud_cerrada.publicacion.mascota.nombre}</strong> <small
                                                                        class="text-muted">de <a
                                                                        href="#">${solicitud_cerrada.publicacion.mascota.usuario.nombre}</a></small></h6>
                                                                <p class="mb-0"><small><script>getLongTime("${solicitud_cerrada.update_at}")</script></small></p>
                                                            </div>
                                                        </div>


                                                        <div class="d-flex flex-nowrap align-items-center justify-content-end w-100 mt-2 mt-md-0">

                                                            <div class="confirm-click-btn">
                                                                <a href="${pageContext.request.contextPath}/solicitud/adoptante?code=${solicitud_cerrada.codigo}&target=perfil"
                                                                   class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                            </div>

                                                            <div class="d-flex align-items-center h4">

                                                                <c:if test="${solicitud_cerrada.calA eq true}">
                                                                         <span class="badge badge-pill bg-soft-success  me-3 ms-2">
                                                                            <i class="fa-solid fa-check"></i>
                                                                                Calificada
                                                                             </span>
                                                                </c:if>
                                                                <c:if test="${solicitud_cerrada.calA eq false}">
                                                                         <span class="badge badge-pill bg-soft-light  me-3 ms-2">
                                                                            <i class="fa-solid fa-triangle-exclamation"></i>
                                                                                Sin calificar
                                                                             </span>
                                                                </c:if>
                                                            </div>


                                                        </div>
                                                    </li>
                                                </c:forEach>

                                                <c:if test="${empty solicitudes_cerradas}">
                                                    <p class="text-muted text-center">No tenés Solicitudes Cerradas.</p>
                                                </c:if>


                                            </ul>


                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

<!--- Internal Sweet-Alert js -->
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/jquery.sweet-alert.js"></script>
