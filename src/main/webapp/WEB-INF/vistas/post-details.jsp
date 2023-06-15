<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="partials/sidebar.jsp" %>


<div>
    <!-- AQUI VA EL CONTENIDO -->


    <div class="mascota-profile-bg-img">

    </div>


    <div id="content-page" class="content-page superponer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-2">
                                    <div class="item1 ms-1">
                                        <img src="data:image/jpeg;base64,${publicacion.mascota.foto}"
                                             class="img-fluid rounded profile-image"
                                             alt="profile-image" loading="lazy">
                                    </div>
                                </div>
                                <div class="col-lg-10">
                                    <div class="d-flex justify-content-between">
                                        <div class="item2 ">
                                            <h4 class=""><strong>${publicacion.mascota.nombre}</strong></h4>
                                            <span>6 Interesados</span>
                                        </div>
                                        <div class="item4 ms-1">
                                            <div class="d-flex justify-content-between">
                                                <a href="">
                                                    <div class="me-3">
                                                        <img class="rounded-circle img-fluid"
                                                             src="data:image/jpeg;base64,${publicacion.mascota.usuario.imagen}"
                                                             style="max-width: 40px;" alt="" loading="lazy">
                                                    </div>
                                                </a>

                                                <div class="w-100">
                                                    <div class="d-flex justify-content-between">
                                                        <div class="">
                                                            <h6 class="mb-0 d-inline-block">${publicacion.mascota.usuario.nombre}</h6>
                                                            <p class="mb-0 text-primary ">
                                                                <script>getTime("${publicacion.create_at}")</script>
                                                            </p>

                                                        </div>


                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-5">
                                            <div class="item5 mt-3">
                                                <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined  md-18">
                                          location_on
                                       </span>
                                                    <a href="#"
                                                       class="link-primary h6 ms-2">${publicacion.provincia}, ${publicacion.ciudad}</a>
                                                </div>
                                                <c:if test="${not empty publicacion.mascota.nacimiento}">
                                                    <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined md-18">
                                          bookmark_border
                                       </span>
                                                        <span class="ms-2">Nació el <a href="#"
                                                                                       class="link-primary h6">${publicacion.mascota.nacimiento}</a></span>
                                                    </div>
                                                </c:if>
                                                <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined md-18">
                                          sell
                                       </span>
                                                    <span class="ms-2">Categoria: <a href="#"
                                                                                     class="link-primary h6">${publicacion.mascota.tipo}</a></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-7">
                                            <div class="item6 border-light border-start">

                                            <c:choose>
                                                <c:when test="${usuario.id eq publicacion.mascota.usuario.id}">
                                                    <div class="d-grid ms-2">
                                                        <h6>Herramientas de publicador</h6>
                                                        <hr>
                                                        
                                                    </div>
                                                </c:when>
                                                <c:otherwise>

                                                    <div class="d-grid ms-2">

                                                    <h6 class="mb-4">No lo dudes!,
                                                        <strong>${publicacion.mascota.nombre}</strong> te necesita</h6>
                                                    <div class="d-grid">
                                                        <c:choose>
                                                            <c:when test="${empty solicitud}">
                                                                <button type="button" class="btn btn-primary d-block mt-3"
                                                                        data-bs-toggle="modal"
                                                                        data-bs-target="#confirma-adopcion">
                                                                    Quiero Adoptarlo!
                                                                </button>

                                                            </c:when>
                                                            <c:when test="${not empty solicitud}">
                                                                <c:if test="${sol_response eq 'success'}">
                                                                    <div class="alert alert-solid alert-success d-flex align-items-center mb-2 py-1 "
                                                                         role="alert">
                                                                        <div>
                                                                            Enviamos tu solicitud a ${publicacion.mascota.usuario.nombre}.
                                                                        </div>
                                                                    </div>
                                                                </c:if>
                                                                <form:form action="${pageContext.request.contextPath}/solicitud/cancelar"  method="post" modelAttribute="solicitud">
                                                                    <form:input path="usuario.id" type="hidden"/>
                                                                    <form:input path="publicacionSolicitud.id" type="hidden"/>
                                                                    <form:input path="mensajeSolicitud" type="hidden"/>
                                                                    <button type="submit" class="btn btn-secondary d-block w-100" >
                                                                        Cancelar Solicitud
                                                                    </button>
                                                                </form:form>

                                                            </c:when>
                                                        </c:choose>

                                                    </div>
                                                </div>

                                                </c:otherwise>
                                            </c:choose>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="header-title">
                                <h4 class="card-title">Bio</h4>
                            </div>

                        </div>
                        <div class="card-body">
                            <div class="d-flex flex-column justify-content-between">
                                <p>${publicacion.bio}</p>
                            </div>


                            <!-- informacion de mascota -->
                            <div class="row">
                                <h4 class="mt-3">Información Básica</h4>
                                <hr>
                                <div class="col-4">
                                    <h6>Género</h6>
                                </div>
                                <div class="col-8">
                                    <p class="mb-0">${publicacion.mascota.genero}</p>
                                </div>
                                <div class="col-4">
                                    <h6>Raza</h6>
                                </div>
                                <div class="col-8">
                                    <p class="mb-0">
                                        <c:if test="${empty publicacion.mascota.raza}">No apota</c:if>
                                        <c:if test="${not empty publicacion.mascota.raza}">${publicacion.mascota.raza}</c:if>
                                    </p>
                                </div>
                                <div class="col-4">
                                    <h6>Peso</h6>
                                </div>
                                <div class="col-8">
                                    <p class="mb-0">${publicacion.mascota.peso} Kg</p>
                                </div>
                                <div class="col-4">
                                    <h6>Salud</h6>
                                </div>
                                <div class="col-8">
                                    <p class="mb-0">
                                        <c:if test="${empty publicacion.mascota.salud}">No apota</c:if>
                                        <c:if test="${not empty publicacion.mascota.salud}">${publicacion.mascota.salud}</c:if>
                                    </p>
                                </div>
                                <div class="col-4">
                                    <h6>Edad</h6>
                                </div>
                                <div class="col-8">
                                    <p class="mb-0">
                                        <script>getBorn("${publicacion.mascota.nacimiento}")</script>
                                    </p>
                                </div>
                            </div>


                            <div class="d-flex flex-column  mt-4">
                                <h5>Personalidad</h5>
                                <div class="d-flex flex-wrap me-3">
                           <span class="badge badge-pill bg-light text-dark mt-2 me-2">
                              <i class="fa-solid fa-circle"></i>
                              ${publicacion.mascota.personalidad}
                           </span>

                                </div>


                            </div>

                        </div>
                    </div>
                </div>

                <div class="col-lg-8">
                    <div id="post-modal-data" class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="header-title">
                                <h4 class="card-title">Fotos</h4>
                            </div>
                        </div>
                        <div class="card-body">

                            <div class="d-grid gap-2 grid-cols-3">
                                <c:forEach items="${publicacion.imagenes}" var="imagen" varStatus="index">
                                    <a data-fslightbox="gallery" href="data:image/jpeg;base64,${imagen.base64Content}">
                                        <img src="data:image/jpeg;base64,${imagen.base64Content}"
                                             class="img-fluid bg-soft-info img-size fit-cover"
                                             alt="photo-profile" loading="lazy">
                                    </a>
                                </c:forEach>


                            </div>
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${usuario.id eq publicacion.mascota.usuario.id}">
                            <div class="card">
                                <div class="card-header">
                                    <div class="header-title">
                                        <h5 class="card-title">Administrar Mensajes de Publicación</h5>
                                        <hr>
                                    </div>
                                    <div class="d-flex justify-content-center align-items-center">
                                        <p class="my-2 text-black-50 col-7 ps-1 pe-2">Adimnistá y responde los mensajes de esta Publicación en el siguinte enlace</p>
                                        <a href="${pageContext.request.contextPath}/perfil/mensajes?pid=${publicacion.id}" class="btn btn-soft-info col-5 ">Ir a Panel de Mensajeria</a>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="card">
                                <div class="card-header">
                                    <div class="header-title">
                                        <h5 class="card-title">Preguntale a
                                            <strong>${publicacion.mascota.usuario.nombre}</strong> por mi</h5>
                                    </div>
                                    <div>
                                        <form:form action="${pageContext.request.contextPath}/mensaje/enviar"
                                                   modelAttribute="mensajeDto">
                                            <form:textarea path="pregunta" class="form-control mt-2" rows="3"
                                                           placeholder="Escribí tu pregunta..." required="true"/>
                                            <form:input path="publicacion.id" value="${publicacion.id}" type="hidden"/>
                                            <div class="d-flex justify-content-end">
                                                <button type="submit" class="btn btn-primary mt-2"><i
                                                        class="fa-regular fa-paper-plane" style="font-size: 18px;"></i>
                                                    Enviar
                                                </button>

                                            </div>
                                        </form:form>
                                        <c:if test="${msj_response eq 'error'}">
                                            <div class="alert alert-solid alert-danger d-flex align-items-center mt-2 py-1 "
                                                 role="alert">
                                                <div>
                                                    No pudimos enviar tu mensaje debido a un error.
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${msj_response eq 'success'}">
                                            <div class="alert alert-solid alert-success d-flex align-items-center mt-2 py-1 "
                                                 role="alert">
                                                <div>
                                                    Enviamos tu mensaje a ${publicacion.mascota.usuario.nombre}.
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>

                                </div>

                            </div>

                        </c:otherwise>
                    </c:choose>




                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="header-title">
                                <h4 class="card-title">Últimas realizadas</h4>
                            </div>
                        </div>
                        <div class="card-body">

                            <c:forEach items="${mensajes}" var="mensaje">
                                <div class="post-comments p-2 m-0 card rounded bg-light mb-2">

                                    <!-- PREGUNTA -->
                                    <p class="mb-0">
                                        <c:if test="${mensaje.emisor.id eq usuario.id}">
                                            <strong>Tu pregunta -</strong>
                                        </c:if>

                                            ${mensaje.pregunta}

                                        <small class="link-primary"> - ${mensaje.fechaEmision}</small>

                                    </p>
                                    <!--RESPUESTA OCULTA-->
                                    <c:if test="${not empty mensaje.respuesta}">
                                        <details>
                                            <summary class="comments-view  link-primary">Ver respuesta</summary>
                                            <p class="text-muted comments-response">
                                                    ${mensaje.respuesta}
                                                <small class="link-primary"> - ${mensaje.fechaRespuesta}</small></p>
                                        </details>
                                    </c:if>


                                </div>
                            </c:forEach>

                            <c:if test="${empty mensajes}">
                                <p class="text-muted mt-3">Aún nadie ha realizado preguntas.</p>
                            </c:if>


                        </div>
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>


<!-- Modal -->
<div class="modal fade" id="confirma-adopcion" tabindex="-1" role="dialog" aria-labelledby="confirma-adopcion"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">

                </button>
                <h4 class="modal-title" id="exampleModalScrollableTitle">Que grán desición!</h4>
                <p>Enviaremos tu solicitud al publicante y te avisaremos si acepta tu solicitud.</p>

            </div>
            <div class="modal-body">
                <p class="text-muted" style="font-style: italic;"><strong>Lee atentamente -</strong> Si estás pensando
                    sumar
                    un amigo peludo
                    tenés que saber el compromiso que esto implica. No sólo será tu compañía sino un integrante más de
                    la
                    familia. Por lo que te recomendamos planifiques bien su llegada, asegúrate que todos estén de
                    acuerdo
                    y que en tu edificio o casa se permitan mascotas. Tené en cuenta los gastos mensuales relacionados,
                    cuidados generales que necesitará para que se encuentre saludable y cómodo y con quién dejarlo en
                    caso
                    de salir de vacaciones.</p>
                <hr>
                <form:form action="${pageContext.request.contextPath}/solicitud/enviar" method="post" modelAttribute="solicitudDto">
                    <form:input path="publicacionSol.id" type="hidden" value="${publicacion.id}"/>
                    <form:input path="usuarioSol.id" type="hidden" value="${usuario.id}"/>
                    <div class="form-group">
                        <label class="form-label" for="exampleFormControlTextarea1">Mensaje a María Guttierrez</label>
                        <form:textarea path="mensaje" class="form-control" id="exampleFormControlTextarea1" rows="4"
                                  placeholder="Dile por qué debería aceptarte como Adoptante de Tobby" required="true"></form:textarea>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="button" class="btn btn-secondary me-2" data-bs-dismiss="modal">Lo pensaré</button>
                        <button type="submit" class="btn btn-primary">Estoy seguro</button>
                    </div>

                </form:form>
            </div>


        </div>
    </div>
</div>

<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

<!-- fslightbox Script -->
<script src="${pageContext.request.contextPath}/js/fslightbox.js" defer></script>
