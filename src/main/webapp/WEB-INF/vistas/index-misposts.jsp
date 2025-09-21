<!-- head -->

<%@ include file="partials/head.jsp" %>




<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="partials/sidebar.jsp" %>


<div id="content-page" class="content-page">

    <!-- contenido -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 row m-0 p-0">
                <div class="col-sm-12">
                    <div id="post-modal-data" class="card card-block card-stretch card-height">

                        <%@include file="partials/nav-home.jsp" %>

                    </div>
                </div>


                <div class="col-sm-12">


                    <div class="tab-content">

                        <!-- MIS PUBLICACIONES TAB -->
                        <div class="tab-pane fade show active" id="misposts" role="tabpanel">

                            <c:forEach items="${publicaciones}" var="publicacion">
                                <!-- PUBLICACION -->
                                <div class="card card-block card-stretch card-height">
                                    <div class="card-body">
                                        <div class="user-post-data">
                                            <div class="d-flex justify-content-between">
                                                <a href="">
                                                    <div class="me-3">
                                                        <img class="rounded-circle img-fluid avatar-40"
                                                             src="data:image/jpeg;base64,${publicacion.mascota.usuario.imagen}"
                                                             style="max-width: 40px;" alt="" loading="lazy">
                                                    </div>
                                                </a>

                                                <div class="w-100">
                                                    <div class="d-flex justify-content-between">
                                                        <div class="">
                                                            <h6 class="mb-0 d-inline-block"><strong>Tú</strong></h6>
                                                            <small class="mb-0 text-primary ">
                                                                <script>getTime("${publicacion.create_at}");</script>
                                                            </small>
                                                            <p class="text-muted mb-0" style="font-style: italic;">
                                                                <small
                                                                        class="text-muted"><i
                                                                        class="material-symbols-outlined small"
                                                                        style="font-size: 12px;">location_on</i> ${publicacion.provincia}, ${publicacion.ciudad}
                                                                </small></p>
                                                        </div>

                                                        <!-- MENU EMERGENTE DE PUBLICACION -->
                                                        <div class="card-post-toolbar">
                                                            <div class="dropdown">
                                                               <span class="dropdown-toggle material-symbols-outlined"
                                                                     data-bs-toggle="dropdown" aria-haspopup="true"
                                                                     aria-expanded="false" role="button">
                                                                  more_horiz
                                                               </span>
                                                                <div class="dropdown-menu m-0 p-0">
                                                                    <a class="dropdown-item p-3" href="${pageContext.request.contextPath}/publicacion/editar?pid=${publicacion.id}">
                                                                        <div class="d-flex align-items-top">
                                                                            <span class="material-symbols-outlined">
                                                                               edit
                                                                            </span>
                                                                            <div class="data ms-2">
                                                                                <h6>Editar Publicación</h6>
                                                                                <p class="mb-0">Modifica la información
                                                                                    publicada</p>
                                                                            </div>
                                                                        </div>
                                                                    </a>


                                                                    <c:choose>
                                                                        <c:when test="${publicacion.estado.toString() eq 'DISPONIBLE'}">
                                                                            <a class="dropdown-item p-3"
                                                                               href="${pageContext.request.contextPath}/publicacion/pausar?pid=${publicacion.id}">
                                                                                <div class="d-flex align-items-top">
                                                                                        <span class="material-symbols-outlined">
                                                                                     pause
                                                                                    </span>
                                                                                    <div class="data ms-2">
                                                                                        <h6>Pausar Publicación</h6>
                                                                                        <p class="mb-0">Cambia el estado
                                                                                            de tu
                                                                                            publicación</p>
                                                                                    </div>
                                                                                </div>
                                                                            </a>
                                                                        </c:when>
                                                                        <c:when test="${publicacion.estado.toString() eq 'PAUSADA'}">
                                                                            <a class="dropdown-item p-3"
                                                                               href="${pageContext.request.contextPath}/publicacion/reanudar?pid=${publicacion.id}">
                                                                                <div class="d-flex align-items-top">

                                                                                     <span class="material-symbols-outlined">
                                                                                     play_arrow
                                                                                     </span>
                                                                                    <div class="data ms-2">
                                                                                        <h6>Reanudar Publicación</h6>
                                                                                        <p class="mb-0">Cambia el estado
                                                                                            de tu
                                                                                            publicación</p>
                                                                                    </div>
                                                                                </div>
                                                                            </a>
                                                                        </c:when>
                                                                    </c:choose>


                                                                    <a class="dropdown-item p-3" onclick="confirm(this)" action="${pageContext.request.contextPath}/publicacion/eliminar?pid=${publicacion.id}" href="javascript:void(0);">
                                                                        <div class="d-flex align-items-top">
                                                                            <span class="material-symbols-outlined">
                                                                               delete
                                                                            </span>
                                                                            <div class="data ms-2">
                                                                                <h6>Eliminar Publicación</h6>
                                                                                <p class="mb-0">Elimina de forma permanente</p>
                                                                            </div>
                                                                        </div>
                                                                    </a>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr class="mt-0">
                                        <div class="mt-3">
                                            <div class="d-flex justify-content-between align-items-center mb-2">
                                                <div class="d-flex align-items-center">
                                                    <h4><strong>${publicacion.mascota.nombre}</strong></h4>
                                                    <c:choose>
                                                        <c:when test="${publicacion.estado.toString() eq 'DISPONIBLE'}">
                                                            <span class="badge badge-pill bg-soft-success  ms-2">
                                                            <i class="fa-solid fa-earth-americas"></i>
                                                            ${publicacion.estado.toString()}
                                                             </span>
                                                        </c:when>
                                                        <c:when test="${publicacion.estado.toString() eq 'PAUSADA'}">
                                                            <span class="badge badge-pill bg-soft-warning  ms-2">
                                                            <i class="fa-solid fa-pause"></i>
                                                            ${publicacion.estado.toString()}
                                                             </span>
                                                        </c:when>
                                                        <c:when test="${publicacion.estado.toString() eq 'RESERVADA'}">
                                                            <span class="badge badge-pill bg-soft-info  ms-2">
                                                            <i class="fa-solid fa-bookmark"></i>
                                                            ${publicacion.estado.toString()}
                                                             </span>
                                                        </c:when>
                                                    </c:choose>

                                                </div>

                                                <div class="text-muted">
                                                    <span class="mx-1"><i
                                                            class="fa-solid fa-mars"></i></span>${publicacion.mascota.genero}

                                                    <c:if test="${not empty publicacion.mascota.nacimiento}">
                                                        <span class="mx-1"><i class="fa-solid fa-clock"></i></span>
                                                        <script>getBorn("${publicacion.mascota.nacimiento}");</script>
                                                    </c:if>

                                                    <span class="mx-1"><i
                                                            class="fa-solid fa-weight-scale"></i></span>${publicacion.mascota.peso}kg
                                                </div>
                                            </div>

                                            <p>${publicacion.bio}</p>
                                        </div>
                                        <div class="user-post">
                                            <div id="carousel-${publicacion.id}" class="carousel slide"
                                                 data-bs-ride="carousel">
                                                <div class="carousel-indicators">
                                                    <c:forEach items="${publicacion.imagenes}" begin="0"
                                                               end="${publicacion.imagenes.size() - 1}"
                                                               varStatus="index">
                                                        <button type="button"
                                                                data-bs-target="#carousel-${publicacion.id}"
                                                                data-bs-slide-to="${index.count - 1}"
                                                                class="<c:if test="${index.count - 1 eq 0}">active</c:if>"
                                                                aria-current="<c:if test="${index.count - 1 eq 0}">true</c:if>"></button>
                                                    </c:forEach>

                                                </div>
                                                <div class="carousel-inner " style="height: 400px;">
                                                    <c:forEach items="${publicacion.imagenes}" begin="0"
                                                               end="${publicacion.imagenes.size() - 1}"
                                                               varStatus="index"
                                                               var="imagen">
                                                        <div class="carousel-item <c:if test="${index.count - 1 eq 0}">active</c:if>">
                                                            <img src="data:image/jpeg;base64,${imagen.base64Content}"
                                                                 class="w-100 image-cover"
                                                                 height="100%" loading="lazy" alt="image">
                                                        </div>
                                                    </c:forEach>

                                                </div>
                                                <button class="carousel-control-prev" type="button"
                                                        data-bs-target="#carousel-${publicacion.id}"
                                                        data-bs-slide="prev"
                                                        control-id="ControlID-7">
                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                    <span class="visually-hidden">Previous</span>
                                                </button>
                                                <button class="carousel-control-next" type="button"
                                                        data-bs-target="#carousel-${publicacion.id}"
                                                        data-bs-slide="next"
                                                        control-id="ControlID-8">
                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                    <span class="visually-hidden">Next</span>
                                                </button>
                                            </div>


                                        </div>
                                        <div class="comment-area mt-3">
                                            <div class="d-flex justify-content-between align-items-center flex-wrap">
                                                <div class="like-block position-relative d-flex align-items-center w-100">
                                                    <div class="d-flex justify-content-end w-100 align-items-center">

                                                        <a href="${pageContext.request.contextPath}/publicacion/ver?pid=${publicacion.id}"
                                                           class="btn d-inline-flex mb-3 me-1 btn-primary">Ver perfil
                                                            público</a>
                                                    </div>

                                                </div>

                                            </div>

                                        </div>
                                    </div>

                                    <c:if test="${loader eq publicacion.id}">
                                        <div id="loader_container" class="loader-wrapper grid">
                                            <div class="loader-pub">
                                                <div id="pb"
                                                     class="progress progress-bar progress-bar-striped progress-bar-animated bg-success"
                                                     role="progressbar" aria-valuenow="0" aria-valuemin="0"
                                                     aria-valuemax="100" style="width: 100%"></div>
                                            </div>
                                            <div class="col-sm-12 text-center align-self-center mt-5 opacity-1">
                                                <h5 class="text-white mb-0">Espera, ya casi esta lista..</h5>

                                            </div>
                                        </div>
                                    </c:if>

                                </div>

                            </c:forEach>

                            <c:if test="${empty publicaciones}">
                                <p class="text-muted text-center">Aún no publicaste</p>
                            </c:if>
                        </div>

                    </div>


                </div>


            </div>


            <!--ACCESOS RAPIDOS -->
            <%@include file="partials/tools-home.jsp" %>

        </div>


    </div>


</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>


<c:if test="${not empty loader}">
    <script src="${pageContext.request.contextPath}/js/progress.js" type="text/javascript"></script>
</c:if>

<!--- Internal Sweet-Alert js -->
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/jquery.sweet-alert.js"></script>