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

                                                    <h4>Mis Publicaciones</h4>
                                                    <hr>

                                            <c:if test="${not empty publicaciones}">
                                                <table class="table forum-table mb-0 rounded">
                                                    <thead class="bg-primary text-white">
                                                    <tr>
                                                        <th>Publicación</th>
                                                        <th>Solicitudes</th>
                                                        <th>Preguntas</th>
                                                        <th>Estado</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>

                                                    <c:forEach items="${publicaciones}" var="publicacion">
                                                        <tr>
                                                            <td class="col-lg-5">
                                                                <a href="#">
                                                                    <div class="d-flex align-items-center">
                                                                        <img class="img-fluid rounded-circle avatar-40"
                                                                             src="data:image/jpg;base64,${publicacion.publicacion.mascota.foto}" alt=""
                                                                             loading="lazy">
                                                                        <div class="media-body ms-3">
                                                                            <h6 class="text-dark"><strong>${publicacion.publicacion.mascota.nombre}</strong>
                                                                            </h6>
                                                                            <p class="mb-0">
                                                                                <span class="link-primary"><script>getTime("${publicacion.publicacion.create_at}")</script></span>
                                                                            </p>
                                                                        </div>
                                                                    </div>
                                                                </a>

                                                            </td>
                                                            <td class="col-lg-2 h6 text-center align-items-center">0
                                                            </td>
                                                            <td class="col-lg-2 h6 text-center align-items-center">${publicacion.cantMensajes}
                                                            </td>
                                                            <td class="col-lg-3 ">

                                                                <c:choose>
                                                                    <c:when test="${publicacion.publicacion.estado.toString() eq 'DISPONIBLE'}">
                                                                            <span class="badge badge-pill bg-success  ms-2">
                                                                            <i class="fa-solid fa-earth-americas"></i>
                                                                            ${publicacion.publicacion.estado.toString()}
                                                                             </span>
                                                                    </c:when>
                                                                    <c:when test="${publicacion.publicacion.estado.toString() eq 'PAUSADA'}">
                                                                            <span class="badge badge-pill bg-warning  ms-2">
                                                                            <i class="fa-solid fa-pause"></i>
                                                                            ${publicacion.publicacion.estado.toString()}
                                                                             </span>
                                                                    </c:when>
                                                                    <c:when test="${publicacion.publicacion.estado.toString() eq 'RESERVADO'}">
                                                                            <span class="badge badge-pill bg-info  ms-2">
                                                                            <i class="fa-solid fa-bookmark"></i>
                                                                            ${publicacion.publicacion.estado.toString()}
                                                                             </span>
                                                                    </c:when>
                                                                    <c:when test="${publicacion.publicacion.estado.toString() eq 'CERRADA'}">
                                                                            <span class="badge badge-pill bg-soft-secondary  ms-2">
                                                                            <i class="fa-solid fa-lock"></i>
                                                                            ${publicacion.publicacion.estado.toString()}
                                                                             </span>
                                                                    </c:when>
                                                                </c:choose>


                                                            </td>
                                                        </tr>
                                                    </c:forEach>


                                                    </tbody>
                                                </table>
                                            </c:if>

                                            <c:if test="${empty publicaciones}">
                                                <p class="text-muted text-center">Aún no has publicado</p>
                                            </c:if>



                                        </div>
                                    </div>

                                    <div class="card mt-3">

                                        <div class="card-body">

                                                    <h4>Publicaciones Cerradas</h4>
                                                    <hr>

                                                    <c:if test="${not empty publicaciones_cerradas}">
                                                        <table class="table forum-table mb-0 rounded">
                                                            <thead class="bg-primary text-white">
                                                            <tr>
                                                                <th>Publicación</th>
                                                                <th class="text-center">Detalle</th>
                                                                <th>Calificación</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>

                                                            <c:forEach items="${publicaciones_cerradas}" var="publicacion_cerrada">
                                                                <tr>
                                                                    <td class="col-lg-6">
                                                                        <a href="#">
                                                                            <div class="d-flex align-items-center">
                                                                                <img class="img-fluid rounded-circle avatar-40"
                                                                                     src="data:image/jpg;base64,${publicacion_cerrada.publicacion.mascota.foto}" alt=""
                                                                                     loading="lazy">
                                                                                <div class="media-body ms-3">
                                                                                    <h6 class="text-dark"><strong>${publicacion_cerrada.publicacion.mascota.nombre}</strong>
                                                                                    </h6>
                                                                                    <p class="mb-0">
                                                                                        <span class="link-primary"><script>getTime("${publicacion_cerrada.publicacion.create_at}")</script></span>
                                                                                    </p>
                                                                                </div>
                                                                            </div>
                                                                        </a>

                                                                    </td>
                                                                    <td class="col-lg-3 h6 text-center align-items-center">
                                                                        <a href="${pageContext.request.contextPath}/solicitud/publicador?code=${publicacion_cerrada.codigo}&target=perfil-post"
                                                                           class="me-3 btn btn-primary rounded confirm-btn">Ver</a>
                                                                    </td>
                                                                    <td class="col-lg-3 h4 text-center align-items-center">
                                                                        <c:if test="${publicacion_cerrada.calP eq true}">
                                                                         <span class="badge badge-pill bg-soft-success mt-1 me-3 ms-2">
                                                                            <i class="fa-solid fa-check"></i>
                                                                                Calificada
                                                                             </span>
                                                                        </c:if>
                                                                        <c:if test="${publicacion_cerrada.calP eq false}">
                                                                         <span class="badge badge-pill bg-soft-light mt-1 me-3 ms-2">
                                                                            <i class="fa-solid fa-triangle-exclamation"></i>
                                                                                Sin calificar
                                                                             </span>
                                                                        </c:if>
                                                                    </td>

                                                                </tr>
                                                            </c:forEach>







                                                            </tbody>
                                                        </table>
                                                    </c:if>

                                                    <c:if test="${empty publicaciones_cerradas}">

                                                            <p class="text-muted text-center">No tienes publicaciones Cerradas</p>

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
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

