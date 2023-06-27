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
                                            <div class="tab-content">

                                                <!-- POR ADOPTAR -->
                                                <div class="tab-pane fade show active" id="v-pills-poradoptar-tab"
                                                     role="tabpanel"
                                                     aria-labelledby="v-pills-poradoptar-tab">
                                                    <h4>Mis Solicitudes de Adopción</h4>
                                                    <hr>
                                                    <ul class="request-list list-inline m-0 p-0">

                                                        <c:forEach items="${solicitudes}" var="solicitud">
                                                            <li
                                                                    class="d-flex align-items-center  justify-content-between flex-wrap">
                                                                <div class="d-flex">
                                                                    <div class="user-img img-fluid flex-shrink-0">
                                                                        <img src="data:image/jpg;base64,${solicitud.publicacion.mascota.foto}" alt="story-img"
                                                                             class="rounded-circle avatar-40"
                                                                             loading="lazy">
                                                                    </div>
                                                                    <div class="flex-grow-1 ms-3">
                                                                        <h6><strong>${solicitud.publicacion.mascota.nombre}</strong> <small
                                                                                class="text-muted">de <a
                                                                                href="#">${solicitud.publicacion.mascota.usuario.nombre}</a></small></h6>
                                                                        <p class="mb-0">${solicitud.created_at}</p>
                                                                    </div>
                                                                </div>


                                                                <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                    <div class="d-flex align-items-center">
                                                         <span class="material-symbols-outlined text-warning">
                                                            timer
                                                         </span>
                                                                        <span
                                                                                class="badge badge-pill text-warning me-5">${solicitud.estado}</span>
                                                                    </div>
                                                                    <div class="confirm-click-btn">
                                                                        <a href="${pageContext.request.contextPath}/solicitud/adoptante?code=${solicitud.codigo}"
                                                                           class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                                    </div>
                                                                    <form:form action="${pageContext.request.contextPath}/solicitud/cancelar?target=perfil"  method="post" modelAttribute="ma_solicitud">
                                                                        <form:input path="usuario.id" value="${solicitud.usuario.id}" type="hidden"/>
                                                                        <form:input path="publicacionSolicitud.id" value="${solicitud.publicacion.id}" type="hidden"/>
                                                                        <form:input path="mensajeSolicitud" value="${solicitud.mensaje}"  type="hidden"/>
                                                                        <button type="submit" class="btn btn-secondary d-block w-100" >
                                                                            Cancelar Solicitud
                                                                        </button>
                                                                    </form:form>
                                                                </div>
                                                            </li>
                                                        </c:forEach>

                                                        <c:if test="${empty solicitudes}">
                                                            <p class="text-muted text-center">No se encontraron solicitudes.</p>
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
    </div>
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

