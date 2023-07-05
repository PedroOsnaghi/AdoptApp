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

                <!-- TAB SOLICITUDES -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="solicitudes" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4>Tus Publicaciones</h4>
                                        <hr>
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <c:forEach items="${publicaciones}" var="publicacion">
                                                <li>
                                                    <a class="nav-link mb-2 <c:if test="${selected_pub eq publicacion.publicacion.id}">active</c:if> "
                                                       href="${pageContext.request.contextPath}/perfil/solicitud?pid=${publicacion.publicacion.id}">

                                                        <div class="d-flex align-items-center justify-content-between">
                                                            <div class="d-flex align-items-center">
                                                                <img class="img-fluid rounded-circle avatar-40"
                                                                     src="data:image/jpeg;base64,${publicacion.publicacion.mascota.foto}"
                                                                     alt=""
                                                                     loading="lazy">
                                                                <div class="media-body ms-3">
                                                                    <h6 class="text-dark">
                                                                        <strong>${publicacion.publicacion.mascota.nombre}</strong>
                                                                    </h6>
                                                                    <p class="mb-0"><span
                                                                            class="text-muted">Publicada </span>
                                                                        <span class="link-primary">
                                                                        <script>getTime("${publicacion.publicacion.create_at}")</script>
                                                                        </span>
                                                                    </p>
                                                                </div>

                                                            </div>

                                                                    <c:if test="${not empty publicacion.new_solicitud and publicacion.new_solicitud > 0}">
                                                                        <span class="badge badge-pill bg-light text-dark ml-2"><strong>${publicacion.new_solicitud}</strong></span>
                                                                    </c:if>




                                                        </div>

                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <c:if test="${empty publicaciones}">
                                                <p class="text-muted mt-4 mb-3 text-center">No has publicado nada todavia</p>
                                                <p class="text-center"><a href="${pageContext.request.contextPath}/publicacion/crear">Crear publicación</a></p>
                                            </c:if>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8 ps-4">
                                <div class="card">
                                    <div class="card-body">
                                        <c:if test="${empty selected_pub}">
                                            <div class="d-flex flex-column align-items-center"
                                                 style="margin-top: 40px;">
                                                <img src="${pageContext.request.contextPath}/images/page-img/request.png"
                                                     class="img-fluid w-100 text-center"
                                                     style="opacity: .1; max-width: 100px;" alt="">
                                                <h6 class="text-muted text-center mt-4">Aquí verás las Solicitudes de personas interesadas en tus Publicaciones.</h6>
                                                <h6 class="text-muted text-center mb-5">Selecciona una publicación para
                                                    verlas.</h6>
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty selected_pub}">
                                            <c:if test="${empty solicitud_aceptada && empty solicitud_cancelada}">
                                                <div>
                                                    <div class="">
                                                        <h4>Solicitudes de Adopción</h4>
                                                        <p class="font-size-12 text-primary">Elije al mejor candidato para tu
                                                            mascota. </p>

                                                    </div>

                                                    <hr>
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade show active" id="v-pills-solicitud-p1-tab"
                                                             role="tabpanel"
                                                             aria-labelledby="v-pills-solicitud-p1-tab">


                                                            <ul class="request-list list-inline m-0 p-0">
                                                                <c:forEach items="${solicitudes}" var="solicitud">

                                                                    <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                                                        <a href="" class="d-flex nav-link">
                                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                                <img src="data:image/jpg;base64,${solicitud.usuario.imagen}" alt="story-img"
                                                                                     class="rounded-circle avatar-40" loading="lazy">
                                                                            </div>
                                                                            <div class="flex-grow-1 ms-3">
                                                                                <h6>${solicitud.usuario.nombre}</h6>
                                                                            </div>
                                                                        </a>

                                                                        <c:if test="${solicitud.estado eq 'CERRADA' && solicitud.calP eq false}">
                                                                         <span class="badge badge-pill bg-soft-light h3 text-dark  me-3 ms-2">
                                                                            <i class="fa-solid fa-triangle-exclamation"></i>
                                                                                Sin calificar
                                                                             </span>
                                                                        </c:if>

                                                                        <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                            <a href="${pageContext.request.contextPath}/solicitud/publicador?code=${solicitud.codigo}&target=perfil-solicitud"
                                                                               class="me-3 btn btn-primary rounded confirm-btn">Ver</a>
                                                                            <c:if test="${solicitud.estado eq 'PENDIENTE'}">
                                                                                <div class="confirm-click-btn me-3">
                                                                                    <a class="btn btn-primary" onclick="confirmAceptar(this)" action="${pageContext.request.contextPath}/solicitud/aceptar?code=${solicitud.codigo}&target=perfil-solicitud" href="javascript:void(0);">
                                                                                        Aceptar
                                                                                    </a>

                                                                                </div>
                                                                                <a class="btn btn-secondary d-block w-100" onclick="confirmRechazar(this)" action="${pageContext.request.contextPath}/solicitud/cancelar?code=${solicitud.codigo}&target=perfil-solicitud" href="javascript:void(0);">
                                                                                    Rechazar
                                                                                </a>
                                                                            </c:if>
                                                                            <c:if test="${solicitud.estado eq 'CERRADA'}">
                                                                                 <span class="badge badge-pill bg-soft-danger h3 me-3 ms-3">
                                                                                    <i class="fa-solid fa-ban"></i>
                                                                                        Cancelada - Cerrada
                                                                                     </span>
                                                                            </c:if>

                                                                        </div>
                                                                    </li>

                                                                </c:forEach>

                                                                <c:if test="${empty solicitudes}">
                                                                    <p class="text-muted text-center">No tienes solicitudes para esta publicación.</p>
                                                                </c:if>

                                                            </ul>

                                                        </div>

                                                        <div class="tab-pane fade " id="v-pills-solicitud-p2-tab" role="tabpanel"
                                                             aria-labelledby="v-pills-solicitud-p2-tab">

                                                            <div class="d-flex w-100 justify-content-center">
                                                                <p class="text-muted">Aún no tenés Solicitudes para esta
                                                                    publicación</p>
                                                            </div>


                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty solicitud_aceptada}">
                                                <div>
                                                    <div class="">
                                                        <h4>Adoptante Aceptado</h4>
                                                        <p class="font-size-12 text-primary">El candidato que elegiste para tu mascota.</p>
                                                        <div class="item4 ms-1">
                                                            <div class="d-flex justify-content-between">

                                                                <div class="me-3">
                                                                    <img class="rounded-circle img-fluid"
                                                                         src="data:image/jpeg;base64,${solicitud_aceptada.usuario.imagen}" style="max-width: 40px;" alt="" loading="lazy">
                                                                </div>


                                                                <div class="w-100">
                                                                    <div class="d-flex justify-content-between align-items-center">
                                                                        <div class="">
                                                                            <h6 class="mb-0 d-inline-block">${solicitud_aceptada.usuario.nombre}</h6>
                                                                        </div>
                                                                        <button type="button" class="btn btn-primary"
                                                                                data-bs-toggle="modal"
                                                                                data-bs-target="#chat-solicitud">
                                                                            ver mensajes
                                                                        </button>


                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <hr>
                                                    <div class="mt-3">
                                                        <p>Puedes ver el estado del proceso de adopcion haciendo click en el siguiente boton</p>
                                                        <a href="${pageContext.request.contextPath}/solicitud/publicador?code=${solicitud_aceptada.codigo}&target=perfil-solicitud"
                                                           class="me-3 btn btn-primary rounded confirm-btn">Ver Estado de Solicitud</a>



                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty solicitud_cancelada}">
                                                <div>
                                                    <div class="">
                                                        <div class="bg-soft-danger p-2 border-danger rounded" style="border: 1px solid #ff00008f;">
                                                            <h4 class="text-danger" style="color:#db6262!important">El Adoptante Canceló el proceso</h4>
                                                            <p class="font-size-12 text-danger mb-0">El Adoptante informó que no continuará con el proceso de Adopción.</p>
                                                        </div>

                                                        <div class="item4 mt-3 ms-1">
                                                            <div class="d-flex justify-content-between">

                                                                <div class="me-3">
                                                                    <img class="rounded-circle img-fluid"
                                                                         src="data:image/jpeg;base64,${solicitud_cancelada.usuario.imagen}" style="max-width: 40px;" alt="" loading="lazy">
                                                                </div>


                                                                <div class="w-100">
                                                                    <div class="d-flex justify-content-between align-items-center">
                                                                        <div class="">
                                                                            <h6 class="mb-0 d-inline-block">${solicitud_cancelada.usuario.nombre}</h6>
                                                                        </div>
                                                                        <button type="button" class="btn btn-primary" disabled
                                                                                data-bs-toggle="modal"
                                                                                data-bs-target="#chat-solicitud">
                                                                            ver mensajes
                                                                        </button>


                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <hr>
                                                    <div class="mt-3">
                                                        <p>Para más información sobre lo que informó el Adoptante, haz Click en el Botón Ver Estado de Solicitud</p>
                                                        <a href="${pageContext.request.contextPath}/solicitud/publicador?code=${solicitud_cancelada.codigo}&target=perfil-solicitud"
                                                           class="me-3 btn btn-danger rounded confirm-btn">Ver Estado de Solicitud</a>



                                                    </div>
                                                </div>
                                            </c:if>



                                        </c:if>

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
