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
                            <h3 class="text-white">Solicitud de Adopción</h3>
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
                                <div class="timeline-dots border-success"></div>
                                <c:if test="${solicitud.estado eq 'PENDIENTE'}">
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

                                <c:if test="${solicitud.estado eq 'ACEPTADA'}">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Solicitud Aceptada</h6>
                                        <small><script>getLongTime("${solicitud.update_at}")</script></small>
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
                                        <h6 class="text-muted mb-1">Pendiente de entrega</h6>

                                    </div>
                                </c:if>
                                <c:if test="${solicitud.estado eq 'ACEPTADA'}">
                                    <div class="timeline-dots border-success"></div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Pendiente de entrega</h6>

                                    </div>
                                </c:if>


                            </li>
                            <li>
                                <div class="timeline-dots border-light"></div>
                                <div class="d-flex align-items-center justify-content-between">
                                    <h6 class="text-muted mb-1">Mascota adoptada</h6>

                                </div>

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
                                        <div class="form-group">
                                            <label class="form-label" for="dir"><strong>Dirección de Entrega</strong></label>
                                            <input  class="form-control" type="text" value="${solicitud.publicacion.direccion}" readonly id="dir"/>
                                        </div>
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
                                            <a class="btn-link" href="">Abrir em google Maps</a>
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
                    <c:if test="${(solicitud.estado eq 'ACEPTADA') && (solicitud.publicacion.estado eq 'CERRADA')}">
                        <div class="card">

                            <div class="card-header bg-soft-success">
                                <h5 style="color: #3e3e3e;"><strong>User Test</strong> nos informó que ya te entregó a <strong>Olimpia</strong>
                                </h5>
                            </div>
                            <div class="card-body">
                                <h6>Contanos tu experiencia con <strong>User Test</strong></h6>
                                <div class="mt-3">
                                    <p class="ms-4"><strong>Que calificación le das?</strong><span class="text-muted"> (de 0 a 5 estrellas)</span>
                                    </p>
                                    <div class="rating-stars block" id="rating-1" data-stars="0" style="cursor: pointer;">
                                    </div>
                                    <p class="ms-4 mt-3"><strong>Opiná sobre el Publicador</strong><span class="text-muted"> (máximo 255 caracteres)</span>
                                    </p>
                                    <div class="px-4 d-flex flex-column justify-content-center">
                                        <textarea class="form-control" maxlength="255" rows="3"></textarea>
                                        <button type="submit" class="btn btn-primary mt-3" style="width: 50%">Enviar
                                            Calificación
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:if>







                <div class="card">

                    <div class="card-header">
                        <h5>Necesitas ayuda?</h5>
                    </div>
                    <div class="card-body">
                        <a class="btn btn-action text-dark" href="">Deseo Cancelar el proceso de Adopción</a>
                    </div>
                </div>

            </div>


        </div>

    </div>

    <!-- chat-->

    <%@ include file="partials/chat-solicitud.jsp" %>


    <!-- footer -->

    <%@ include file="partials/footer.jsp" %>

    <!-- scripts -->

    <%@ include file="partials/script.jsp" %>


    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeluO_jCvIS_iT6Y3Thw8A6YJW5gyzh0M&callback=initAutocomplete&libraries=places&v=weekly"
            defer>
    </script>
    <script src="${pageContext.request.contextPath}/js/multifile.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/google.maps.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/rating/jquery-rate-picker.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/rating/rating-picker.js" type="text/javascript"></script>

    <!-- fslightbox Script -->
    <script src="${pageContext.request.contextPath}/js/fslightbox.js" defer></script>

    <!--- Internal Sweet-Alert js -->
    <script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/sweetalert.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/jquery.sweet-alert.js"></script>
