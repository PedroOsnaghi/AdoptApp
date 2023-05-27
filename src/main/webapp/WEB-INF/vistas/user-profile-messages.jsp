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

                <%@include file="partials/profile-header.jsp" %>

                <%@include file="partials/nav-profile.jsp" %>
            </div>
            <div class="col-sm-12">

                <!-- TAB PREGUNTAS -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="preguntas" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                            <h4 >Tus Publicaciones</h4>
                                        <hr>
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <c:forEach items="${publicaciones}" var="publicacion">
                                                <li>
                                                    <a class="nav-link mb-2 <c:if test="${selected_pub eq publicacion.publicacion.id}">active</c:if> "
                                                       href="${pageContext.request.contextPath}/perfil/mensajes?pid=${publicacion.publicacion.id}">

                                                        <div class="d-flex align-items-center justify-content-between">
                                                            <div class="d-flex align-items-center">
                                                                <img class="img-fluid rounded-circle avatar-40"
                                                                     src="${pageContext.request.contextPath}/images/mascota/${publicacion.publicacion.mascota.foto}"
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
                                                            <c:if test="${not empty publicacion.new_messages and publicacion.new_messages > 0}">
                                                                <span class="badge badge-pill bg-light text-dark ml-2"><strong>${publicacion.new_messages}</strong></span>
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
                                                <img src="${pageContext.request.contextPath}/images/page-img/message.png"
                                                     class="img-fluid w-100 text-center"
                                                     style="opacity: .1; max-width: 100px;" alt="">
                                                <h6 class="text-muted text-center mt-4">Aquí verás todos los mensajes
                                                    que te han enviado en tus publicaciones.</h6>
                                                <h6 class="text-muted text-center mb-5">Selecciona una publicación para
                                                    verlos.</h6>
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty selected_pub}">
                                            <!-- sin responder -->

                                            <div class="mb-2">
                                                <div class="card-header d-flex justify-content-between px-0">
                                                    <div class="header-title col-12">
                                                        <div class="row align-items-center">
                                                            <h6 class="card-title col-5">Preguntas sin responder
                                                                (${mensajes_nuevos.size()})</h6>
                                                            <c:if test="${response eq 'success'}">
                                                                <div class="alert alert-solid alert-success d-flex align-items-center  py-1 col-6 mb-0 " role="alert">
                                                                    <div>
                                                                        Enviamos tu respuesta.
                                                                    </div>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${response eq 'error'}">
                                                                <div class="alert alert-solid alert-danger d-flex align-items-center py-1 col-6 mb-0 " role="alert">
                                                                    <div>
                                                                        No se pudo realizar la operación.
                                                                    </div>
                                                                </div>
                                                            </c:if>
                                                            <c:if test="${response eq 'deleted'}">
                                                                <div class="alert alert-solid alert-success d-flex align-items-center  py-1 col-6 mb-0 " role="alert">
                                                                    <div>
                                                                        Se eliminó tu respuesta.
                                                                    </div>
                                                                </div>
                                                            </c:if>
                                                        </div>

                                                    </div>
                                                </div>
                                                <c:forEach items="${mensajes_nuevos}" var="mensaje">
                                                    <div class="card-body p-0 pt-3">

                                                        <!--una pregunta -->
                                                        <div class="accordion-item post-comments p-2 m-0 card rounded bg-light mb-2">
                                                            <p class="mb-0">${mensaje.emisor.nombre} <small
                                                                    class="mb-0 link-primary">${mensaje.fechaEmision}</small>
                                                            </p>
                                                            <div class="iq-message-body iq-other-user">
                                                                <div class="chat-profile">
                                                                    <img src="${pageContext.request.contextPath}/images/user/${mensaje.emisor.imagen}"
                                                                         alt="chat-user" class="avatar-40 rounded"
                                                                         loading="lazy">

                                                                </div>
                                                                <div class="iq-chat-text">

                                                                    <div class="d-flex align-items-center justify-content-start">
                                                                        <div class="iq-chating-content d-flex align-items-center ">
                                                                            <button class="accordion-button collapsed"
                                                                                    type="button"
                                                                                    data-bs-toggle="collapse"
                                                                                    data-bs-target="#form-${mensaje.id}"
                                                                                    aria-expanded="false"
                                                                                    aria-controls="form-${mensaje.id}">
                                                                                <p class="mr-2 mb-0">${mensaje.pregunta}</p>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div id="form-${mensaje.id}"
                                                                 class="accordion-collapse collapse" style="">
                                                                <div class="accordion-body">
                                                                    <div class="card-footer px-2 py-2 mt-2 border-top rounded-0">
                                                                        <form:form class="d-flex align-items-center"
                                                                              action="${pageContext.request.contextPath}/mensaje/responder?idm=${mensaje.id}&pid=${mensaje.publicacion.id}" modelAttribute="mensajeDto">

                                                                            <form:input path="respuesta" type="text" class="form-control me-3"
                                                                                   placeholder="Escribe tu respuesta" required="true"/>
                                                                            <button type="submit"
                                                                                    class="btn btn-primary d-flex align-items-center"
                                                                                    control-id="ControlID-2">
                                                                                <i class="fa-regular fa-paper-plane"
                                                                                   style="font-size: 22px;"></i>
                                                                            </button>
                                                                        </form:form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                                <c:if test="${empty mensajes_nuevos}">
                                                    <p class="text-muted mt-4 text-center">No tenés mensajes nuevos</p>
                                                </c:if>
                                            </div>


                                            <hr>
                                            <!-- respondidas -->

                                                <div class="">
                                                    <div class="card-header d-flex justify-content-between px-0">
                                                        <div class="header-title">
                                                            <h6 class="card-title">Preguntas que respondiste</h6>
                                                        </div>
                                                    </div>
                                            <c:forEach items="${mensajes_respondidos}" var="mensaje">
                                                    <div class="card-body p-0 pt-3">
                                                        <!--una pregunta -->
                                                        <div class="accordion-item post-comments p-2 m-0 card rounded bg-light mb-2">
                                                            <p class="mb-0">${mensaje.emisor.nombre} <small
                                                                    class="mb-0 link-primary iq-chating">${mensaje.fechaEmision}</small></p>
                                                            <div class="iq-message-body iq-other-user">
                                                                <div class="chat-profile">
                                                                    <img src="${pageContext.request.contextPath}/images/user/${mensaje.emisor.imagen}"
                                                                         alt="chat-user" class="avatar-40 rounded"
                                                                         loading="lazy">

                                                                </div>
                                                                <div class="iq-chat-text">

                                                                    <div class="d-flex align-items-center justify-content-start">
                                                                        <div class="iq-chating-content d-flex align-items-center ">
                                                                            <button class="accordion-button collapsed"
                                                                                    type="button"
                                                                                    data-bs-toggle="collapse"
                                                                                    data-bs-target="#response-${mensaje.id}"
                                                                                    aria-expanded="false">
                                                                                <p class="mr-2 mb-0">${mensaje.pregunta}</p>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div id="response-${mensaje.id}" class="accordion-collapse collapse" style="">
                                                                <div class="accordion-body">

                                                                    <div class="iq-message-body iq-current-user">
                                                                        <div class="chat-profile mt-5">
                                                                            <img src="${pageContext.request.contextPath}/images/user/${mensaje.publicacion.mascota.usuario.imagen}"
                                                                                 alt="chat-user"
                                                                                 class="avatar-40 rounded"
                                                                                 loading="lazy">

                                                                        </div>
                                                                        <div class="iq-chat-text mt-2">

                                                                            <p class="mb-0 justify-content-start">Tu -
                                                                                <small class=" p-0 mb-0"> ${mensaje.fechaRespuesta}</small></p>


                                                                            <div class="d-flex align-items-center justify-content-end">

                                                                                <div class="iq-chating-content d-flex align-items-center ">
                                                                                    <p class="mr-2 mb-0 text-left" style="text-align: start;">${mensaje.respuesta}</p>
                                                                                </div>
                                                                            </div>
                                                                            <a href="${pageContext.request.contextPath}/mensaje/eliminar?idm=${mensaje.id}&pid=${selected_pub}">Eliminar respuesta</a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                            </c:forEach>
                                                    <c:if test="${empty mensajes_respondidos}">
                                                        <p class="text-muted mt-4 text-center">Aún no has respondido mensajes</p>
                                                    </c:if>
                                                </div>


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

