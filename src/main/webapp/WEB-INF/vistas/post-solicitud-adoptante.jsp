<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->
<%@ include file="partials/sidebar.jsp" %>


<!-- AQUI VA EL CONTENIDO -->

<div id="content-page" class="content-page ">
    <div class="container">

        <div class="row">
            <div class="col-sm-12">
                <div class="card bg-primary">
                    <div class="card-body">
                        <div class="">
                            <div class="d-flex align-items-center justify-content-between">
                                <h3 class="text-white">Solicitud de Adopción</h3>

                                <c:choose>
                                    <c:when test="${target eq 'publicacion'}">
                                        <c:set var="redirect" value="${pageContext.request.contextPath}/publicacion/ver?pid=${solicitud.publicacion.id}"/>
                                    </c:when>
                                    <c:when test="${target eq 'perfil'}">
                                        <c:set var="redirect" value="${pageContext.request.contextPath}/perfil/actividad/solicitudes"/>
                                    </c:when>
                                </c:choose>
                                <a class="btn btn-secondary" href="${redirect}">Cerrar</a>
                            </div>

                            <p class="text-white">Aquí gestionarás todo el proceso de Adopción</p>
                        </div>
                        <div class="card col-lg-5">
                            <div class="card-body">
                                <div class="d-flex align-items-center">
                                    <img class="img-fluid rounded-circle avatar-40"
                                         src="data:image/jpg;base64,${solicitud.publicacion.mascota.foto}" alt="" loading="lazy">
                                    <div class="media-body ms-3">
                                        <h6 class="text-dark"><strong>${solicitud.publicacion.mascota.nombre}</strong>
                                        </h6>
                                        <p class="mb-0">
                                            <span class="link-primary"><script>getTime("${solicitud.publicacion.create_at}")</script></span>
                                        </p>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>

                </div>
            </div>
            <div class="col-sm-12 col-lg-12">
                <div class="card">


                    <div class="card-header">
                        <h5>Estado de solicitud</h5>
                    </div>
                    <div class="card-body">
                        <ul class="iq-timeline mx-auto" style="width: 80%">
                            <li>
                                <div class="timeline-dots border-success"></div>
                                <div class="d-flex align-items-center justify-content-between">
                                    <h6 class="fw-bolder mb-1">Solicitud Enviada</h6>

                                    <small><script>getLongTime("${solicitud.created_at}")</script></small>
                                </div>
                            </li>
                            <li>

                                <c:if test="${solicitud.estado eq 'PENDIENTE'}">

                                        <c:if test="${solicitud.publicacion.estado eq 'DISPONIBLE'}">
                                            <div class="timeline-dots border-success"></div>
                                            <div class="d-flex align-items-center justify-content-between">
                                                <h6 class="fw-bolder mb-1">Pendiente de Aceptación</h6>
                                                <a class="btn btn-secondary" onclick="confirmCancel(this)" action="${pageContext.request.contextPath}/solicitud/cancelar?code=${solicitud.codigo}&target=${target}" href="javascript:void(0);">
                                                    Cancelar Solicitud
                                                </a>
                                            </div>
                                            <div class="d-inline-block w-100">
                                                <p>Te informaremos si el publicador acepta tu solicitud</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${solicitud.publicacion.estado eq 'RESERVADO'}">
                                            <div class="timeline-dots border-warning"></div>
                                                <div class="d-flex align-items-center justify-content-between">
                                                    <h6 class="fw-bolder mb-1">Tu solicitud se encuentra en Lista de Espera</h6>
                                                    <a class="btn btn-secondary" onclick="confirmCancel(this)" action="${pageContext.request.contextPath}/solicitud/cancelar?code=${solicitud.codigo}&target=${target}" href="javascript:void(0);">
                                                        Cancelar Solicitud
                                                    </a>
                                                </div>
                                            <div class="d-inline-block w-100">
                                                <p>No te preocupes, aún tienes chances. Te informaremos si se reanuda la publicación</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${solicitud.publicacion.estado eq 'CERRADA'}">
                                        <div class="timeline-dots border-danger"></div>
                                        <div class="d-flex align-items-center justify-content-between">
                                            <h6 class="fw-bolder mb-1">Publicación Finalizada</h6>
                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/solicitud/cancelar?code=${solicitud.codigo}&target=${target}" >
                                                Cerrar Solicitud
                                            </a>
                                        </div>
                                        <div class="d-inline-block w-100">
                                            <p>La mascota ya fué adoptada por otro usuario pero no te desanimes, aún hay otras mascotas que te esperan.</p>
                                        </div>
                                    </c:if>
                                </c:if>

                                <c:if test="${solicitud.estado eq 'ACEPTADA'}">
                                    <div class="timeline-dots border-success"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Solicitud Aceptada</h6>
                                        <c:if test="${solicitud.publicacion.estado eq 'RESERVADO'}">
                                            <small><script>getLongTime("${solicitud.update_at}")</script></small>
                                        </c:if>
                                    </div>
                                    <div class="d-inline-block w-100">
                                        <p>El publicador Aceptó tu solicitud, ya puedes retirar tu mascota.</p>
                                    </div>
                                </c:if>

                                <c:if test="${(solicitud.estado eq 'CANCELADA') || (solicitud.estado eq 'CERRADA')}">
                                    <div class="timeline-dots border-success"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Solicitud Aceptada</h6>
                                    </div>
                                    <div class="d-inline-block w-100">
                                        <p>El publicador Aceptó tu solicitud, ya puedes retirar tu mascota.</p>
                                    </div>
                                </c:if>



                            </li>
                            <li>
                                <c:if test="${solicitud.estado eq 'PENDIENTE'}">
                                    <div class="timeline-dots border-light"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="text-muted mb-1">Pendiente de Adopción</h6>

                                    </div>
                                </c:if>
                                <c:if test="${solicitud.estado eq 'ACEPTADA'}">
                                    <div class="timeline-dots border-success"></div>
                                    <c:if test="${solicitud.publicacion.estado eq 'RESERVADO'}">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <h6 class="fw-bolder mb-1">Pendiente de Adopción</h6>
                                        </div>
                                        <p>Ya puedes retirar tu mascota.</p>
                                    </c:if>
                                    <c:if test="${solicitud.publicacion.estado eq 'CERRADA'}">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <h6 class="fw-bolder mb-1">Entregada</h6>
                                        </div>
                                        <p>Ya tenés tu mascota.</p>
                                    </c:if>
                                </c:if>
                                <c:if test="${solicitud.estado eq 'CANCELADA'}">
                                    <div class="timeline-dots border-danger"></div>

                                        <div class="d-flex align-items-center justify-content-between">
                                            <h6 class="fw-bolder text-danger mb-1">Cancelaste el proceso</h6>
                                            <small><script>getLongTime("${solicitud.update_at}")</script></small>

                                        </div>
                                        <p>Le informaremos al Publicador sobre tu motivo de cancelación.</p>

                                </c:if>
                                <c:if test="${solicitud.estado eq 'CERRADA'}">
                                    <div class="timeline-dots border-danger"></div>
                                        <div class="d-flex align-items-center justify-content-between">
                                            <h6 class="fw-bolder text-danger mb-1">Cancelaste el proceso</h6>
                                            <small><script>getLongTime("${solicitud.update_at}")</script></small>
                                        </div>
                                        <p>El proceso fué Cerrado por el Publicador.</p>

                                </c:if>


                            </li>
                            <li>
                                <div class="timeline-dots border-light"></div>
                                <c:if test="${(solicitud.estado eq 'PENDIENTE') || ((solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'RESERVADO'))}">
                                    <div class="timeline-dots border-light"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="text-muted mb-1">Mascota adoptada</h6>

                                    </div>
                                </c:if>
                                <c:if test="${(solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'CERRADA')}">
                                    <div class="timeline-dots border-success"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Mascota adoptada</h6>
                                        <small><script>getLongTime("${solicitud.update_at}")</script></small>
                                    </div>

                                </c:if>
                                <c:if test="${(solicitud.estado eq 'CANCELADA') || (solicitud.estado eq 'CERRADA')}">
                                    <div class="timeline-dots border-light"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="text-muted mb-1">Mascota adoptada</h6>
                                    </div>
                                </c:if>

                            </li>

                        </ul>
                    </div>


                </div>


                    <c:if test="${(solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'RESERVADO')}">
                        <div class="card">

                            <div class="card-header bg-soft-warning">
                                <h5 style="color: #3e3e3e;">Ya podes retirar a <strong>${solicitud.publicacion.mascota.nombre}</strong></h5>
                            </div>
                            <div class="card-body">
                                <h5 class="mt-2">Lugar de Entrega</h5>
                                <hr>
                                <div class="row mx-2">
                                    <div class="col-6">

                                        <p><strong>Dirección de Entrega</strong></p>
                                        <p>${solicitud.publicacion.direccion}"</p>

                                        <p><strong>Horarios de Entrega</strong></p>
                                        <p>${solicitud.publicacion.disponibilidad}</p>

                                        <input value="${solicitud.publicacion.latitud}" type="hidden" id="lat"/>
                                        <input value="${solicitud.publicacion.longitud}" type="hidden" id="lng"/>
                                    </div>

                                    <div class="col-6">
                                        <div class="d-flex justify-content-between">
                                            <p class="card-title mb-0">
                                                <strong>Cómo llegar</strong>
                                            </p>
                                            <a class="btn-link" href="">Abrir en google Maps</a>
                                        </div>

                                        <div class="w-100 d-block mt-2" style="height: 200px;" id="map">

                                        </div>
                                    </div>


                                </div>


                            </div>
                            <div class="card-footer">
                                <h5>Contacta al Publicador</h5>
                                <hr>
                                <div class="item4 ms-1">
                                    <div class="d-flex justify-content-between">

                                        <div class="me-3">
                                            <img class="rounded-circle img-fluid"
                                                 src="data:image/jpeg;base64,${solicitud.publicacion.mascota.usuario.imagen}" style="max-width: 40px;" alt="" loading="lazy">
                                        </div>


                                        <div class="w-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="">
                                                    <h6 class="mb-0 d-inline-block">${solicitud.publicacion.mascota.usuario.nombre}</h6>
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
                        </div>
                    </c:if>
                    <c:if test="${(solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'CERRADA') && (solicitud.calA eq false)}">
                        <div class="card">

                            <div class="card-header bg-soft-success">
                                <h5 style="color: #3e3e3e;"><strong>${solicitud.publicacion.mascota.usuario.nombre}</strong> nos informó que ya te entregó a <strong>${solicitud.publicacion.mascota.nombre}</strong>
                                </h5>
                            </div>
                            <div class="card-body">
                                <h6>Contanos tu experiencia con <strong>${solicitud.publicacion.mascota.usuario.nombre}</strong></h6>
                                <div class="mt-3">
                                    <form:form action="${pageContext.request.contextPath}/solicitud/calificarPublicador?id=${solicitud.publicacion.mascota.usuario.id}&code=${solicitud.codigo}&target=${target}" method="post" modelAttribute="calificacion">
                                        <p class="ms-4"><strong>Que calificación le das?</strong><span class="text-muted"> (de 0 a 5 estrellas)</span>
                                        </p>
                                        <div class="rating-stars block" id="rating-1" data-stars="0" style="cursor: pointer;">
                                        </div>
                                        <p class="ms-4 mt-3"><strong>Opiná sobre el Publicador</strong><span class="text-muted"> (máximo 255 caracteres)</span>
                                        </p>
                                        <div class="px-4 d-flex flex-column justify-content-center">
                                            <form:textarea path="commentario" class="form-control" maxlength="255" rows="3" required="true"></form:textarea>
                                            <div class="d-flex justify-content-between align-items-center px-5">
                                                <a  class="btn btn-secondary mt-3 mx-5" href="${redirect}" style="width: 50%">Calificar mas tarde..
                                                </a>
                                                <button type="submit" class="btn btn-primary mt-3 mx-5" style="width: 50%">Enviar
                                                    Calificación
                                                </button>
                                            </div>

                                        </div>
                                        <form:input path="calificacion" id="cal" type="hidden"/>
                                    </form:form>


                                </div>
                            </div>
                        </div>
                    </c:if>
                <c:if test="${(solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'CERRADA') && (solicitud.calA eq true)}">
                    <div class="card">
                        <div class="card-body">
                            <p class="text-center mt-3">La publicación se Cerró con fecha <strong><script>getLongTime('${solicitud.update_at}')</script></strong></p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${(solicitud.estado eq 'CERRADA')}">
                    <div class="card bg-soft-danger">
                        <div class="card-body">
                            <p class="text-center mt-3">El Publicador cerró la Solicitud con fecha <strong><script>getLongTime('${solicitud.update_at}')</script></strong></p>
                        </div>
                    </div>
                </c:if>







                <div class="card">

                    <div class="card-header">
                        <h5>Necesitas ayuda?</h5>
                    </div>
                    <div class="card-body">
                        <ul>
                            <c:if test="${solicitud.publicacion.estado eq 'RESERVADO' && solicitud.estado eq 'ACEPTADA'}">
                                <li>
                                    <a class="btn btn-action text-dark" data-bs-toggle="modal"
                                       data-bs-target="#cancelar-solicitud">Deseo Cancelar el proceso de Adopción</a>
                                </li>
                            </c:if>
                            <li>
                                <a class="btn btn-action text-dark" href="#">Preguntas frecuentes</a>
                            </li>
                        </ul>

                    </div>
                </div>

            </div>


        </div>

    </div>

</div>




    <!-- footer -->

    <%@ include file="partials/footer.jsp" %>

    <!-- chat-->

    <%@ include file="partials/chat-solicitud.jsp" %>




    <!-- cancelacion -->

    <%@ include file="partials/cancelar-solicitud.jsp" %>


    <!-- scripts -->

    <%@ include file="partials/script.jsp" %>


    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeluO_jCvIS_iT6Y3Thw8A6YJW5gyzh0M&callback=initInverseAutocomplete&libraries=places&v=weekly"
            defer>
    </script>

    <script src="${pageContext.request.contextPath}/js/google.maps.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/rating/jquery-rate-picker.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/rating/rating-picker.js" type="text/javascript"></script>

    <!--- Internal Sweet-Alert js -->
    <script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/sweetalert.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/jquery.sweet-alert.js"></script>
    <script src="${pageContext.request.contextPath}/js/form-cancel-adopt.js"></script>
    <script src="${pageContext.request.contextPath}/js/chat.js"></script>