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
                                    <h6 class="fw-bolder mb-1">Solicitud Recibida</h6>
                                    <small><script>getLongTime("${solicitud.created_at}")</script></small>
                                </div>
                                <div class="d-inline-block w-100">
                                    <p><strong>${solicitud.usuario.nombre}</strong> te envió una solicitud para tu publicación</p>
                                </div>
                            </li>
                            <li>
                                <div class="timeline-dots border-success"></div>
                                <c:if test="${solicitud.estado eq 'PENDIENTE'}">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Pendiente de Aceptación</h6>
                                        <a class="btn btn-primary" onclick="confirmAceptar(this)" action="${pageContext.request.contextPath}/solicitud/aceptar?code=${solicitud.codigo}&target=solicitud" href="javascript:void(0);">
                                            Aceptar Solicitud
                                        </a>
                                    </div>
                                    <div class="d-inline-block w-100">
                                        <p>Al aceptar la Solicitud iniciará el proceso de Adopción</p>
                                    </div>
                                </c:if>
                                <c:if test="${solicitud.estado eq 'ACEPTADA'}">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h6 class="fw-bolder mb-1">Aceptaste la Solicitud</h6>
                                        <small><script>getLongTime("${solicitud.update_at}")</script></small>
                                    </div>
                                    <div class="d-inline-block w-100">
                                        <p>Le informaremos al Adoptante para que retire la mascota</p>
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
                                    <p>Cuando el Adoptante Retire la mascota deberas informar la entrega.</p>
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
                                <h5 style="color: #3e3e3e;">Ya podes retirar a <strong>Olimpia</strong></h5>
                            </div>
                            <div class="card-body">
                                <h5 class="mt-2">Lugar de Entrega</h5>
                                <hr>
                                <div class="row mx-2">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label class="form-label" for="dir"><strong>Dirección de Entrega</strong></label>
                                            <input path="direccion" class="form-control" type="text" readonly="true" id="dir"/>
                                        </div>
                                        <p><strong>Horarios de Entrega</strong></p>
                                        <p>De Lunes a Viernes de 10hs a 18hs</p>

                                        <input path="latitud" type="hidden" id="lat"/>
                                        <input path="longitud" type="hidden" id="lng"/>
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
                                                 src="data:image/jpeg;base64,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"
                                                 style="max-width: 40px;" alt="" loading="lazy">
                                        </div>


                                        <div class="w-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="">
                                                    <h6 class="mb-0 d-inline-block">Usuario Publicador</h6>
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
