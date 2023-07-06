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

                <%@include file="partials/other-profile-header.jsp" %>


                <!-- nav -->

                <ul class="nav nav-pills d-flex align-items-center justify-content-start profile-feed-items p-0 m-0 rounded"
                    role="tablist">
                    <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
                        <a class="nav-link active show" href="#actividad" data-bs-toggle="pill"
                           data-bs-target="#actividad" role="button" aria-selected="true">Actividad</a>
                    </li>
                    <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
                        <a class="nav-link" href="#reputacion" data-bs-toggle="pill" data-bs-target="#reputacion"
                           role="button" aria-selected="false" tabindex="-1">Reputación</a>
                    </li>

                </ul>
            </div>
            <div class="col-sm-12 mt-3">
                <!-- TAB ACTIVIDAD -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="actividad" role="tabpanel">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card">
                                        <div class="card-header d-flex justify-content-between">
                                            <div class="header-title">
                                                <h4 class="card-title">Información</h4>
                                            </div>
                                        </div>
                                        <div class="card-body">
                                            <div class="d-flex flex-column justify-content-between">
                                                <c:if test="${not empty usuario_seleccionado.presentacion}">
                                                    <h6 class="mb-1">${usuario_seleccionado.presentacion}</h6>
                                                </c:if>
                                                <c:if test="${empty usuario_seleccionado.presentacion}">
                                                    <h6 class="mb-1 text-muted">Sin presentación</h6>
                                                </c:if>

                                            </div>
                                            <hr>
                                            <div class="d-flex flex-column justify-content-between">
                                                <c:if test="${not empty usuario_seleccionado.domicilio}">
                                                    <div class="d-flex align-items-center mb-1">
                                                     <span class="material-symbols-outlined  md-18 me-2">
                                                          location_on
                                                     </span>
                                                        <span>${usuario_seleccionado.provincia}, ${usuario_seleccionado.ciudad}</span>
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty usuario_seleccionado.f_nac}">
                                                    <div class="d-flex align-items-center mb-1">
                                                     <span class="material-symbols-outlined md-18 me-2">
                                                     bookmark_border
                                                     </span>
                                                        <span>Nació el <script>getLongTime('${usuario_seleccionado.f_nac}')</script></span>
                                                    </div>
                                                </c:if>

                                                <div class="d-flex align-items-center mb-1">
                                                     <span class="material-symbols-outlined md-18 me-2">
                                                     bookmark_border
                                                     </span>
                                                    <span>Se unió el <script>getLongTime('${usuario_seleccionado.created_at}')</script></span>
                                                </div>


                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-8">
                                    <c:forEach items="${publicaciones}" var="publicacion">

                                        <div class="card card-block card-stretch">
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
                                                                            <h6 class="mb-0 d-inline-block">
                                                                                <strong>${publicacion.mascota.usuario.nombre}</strong>
                                                                            </h6>
                                                                            <small class="mb-0 text-primary ">
                                                                                <script>getTime("${publicacion.create_at}");</script>
                                                                            </small>
                                                                            <p class="text-muted mb-0"
                                                                               style="font-style: italic;">
                                                                                <small
                                                                                        class="text-muted"><i
                                                                                        class="material-symbols-outlined small"
                                                                                        style="font-size: 12px;">location_on</i> ${publicacion.provincia}, ${publicacion.ciudad}
                                                                                </small></p>
                                                                        </div>


                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <hr class="mt-0">
                                                        <div class="mt-3">
                                                            <div class="d-flex justify-content-between align-items-center mb-2">
                                                                <h4><strong>${publicacion.mascota.nombre}</strong></h4>
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
                                                                    <c:forEach items="${publicacion.imagenes}"
                                                                               varStatus="index"
                                                                               var="imagen">
                                                                        <div class="carousel-item <c:if test="${index.count - 1 eq 0}">active</c:if>">
                                                                            <img src="data:image/jpg;base64,${imagen.base64Content}"
                                                                                 class=" w-100 image-cover"
                                                                                 height="100%" loading="lazy" alt="image">
                                                                        </div>
                                                                    </c:forEach>

                                                                </div>
                                                                <button class="carousel-control-prev" type="button"
                                                                        data-bs-target="#carousel-${publicacion.id}"
                                                                        data-bs-slide="prev"
                                                                        control-id="ControlID-7">
                                                                <span class="carousel-control-prev-icon"
                                                                      aria-hidden="true"></span>
                                                                    <span class="visually-hidden">Previous</span>
                                                                </button>
                                                                <button class="carousel-control-next" type="button"
                                                                        data-bs-target="#carousel-${publicacion.id}"
                                                                        data-bs-slide="next"
                                                                        control-id="ControlID-8">
                                                                <span class="carousel-control-next-icon"
                                                                      aria-hidden="true"></span>
                                                                    <span class="visually-hidden">Next</span>
                                                                </button>
                                                            </div>


                                                        </div>
                                                        <div class="comment-area mt-3">
                                                            <div class="d-flex justify-content-between align-items-center flex-wrap">
                                                                <div class="like-block position-relative d-flex align-items-center w-100">

                                                                    <!-- BOTONES DE ACCION -->
                                                                    <div class="d-flex justify-content-between w-100 align-items-center">

                                                                        <a class="btn d-inline-flex mb-3 me-1 btn-light"
                                                                           href="${pageContext.request.contextPath}/home/favoritos/agregar?pid=${publicacion.id}"><i
                                                                                class="material-symbols-outlined me-1">star</i>Añadir
                                                                            en
                                                                            Favoritos</a>


                                                                        <a href="${pageContext.request.contextPath}/publicacion/ver?pid=${publicacion.id}"
                                                                           class="btn d-inline-flex mb-3 me-1 btn-primary">Ver
                                                                            mas..</a>
                                                                    </div>

                                                                </div>

                                                            </div>

                                                        </div>
                                                    </div>


                                        </div>

                                    </c:forEach>

                                </div>


                            </div>
                        </div>
                    </div>
                </div>

                <!-- TAB REPUTACION -->
                <div class="tab-content">
                    <div class="tab-pane fade" id="reputacion" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <%@include file="partials/calificacion.jsp"%>
                            </div>
                            <div class="col-md-8 ps-4">
                                <div class="card">
                                    <div class="card-header">
                                        <h5>Comentarios</h5>
                                    </div>
                                    <nav class="tab-bottom-bordered">
                                        <div class="mb-0 nav nav-tabs rounded-top border-0" id="nav-tab1" role="tablist">
                                            <button class="nav-link active" id="nav-comments-pub-tab" data-bs-toggle="tab" data-bs-target="#nav-comments-pub" type="button" role="tab" aria-controls="nav-comments-pub" aria-selected="true" control-id="ControlID-2" tabindex="-1">Publicador</button>
                                            <button class="nav-link" id="nav-comments-adopt-tab" data-bs-toggle="tab" data-bs-target="#nav-comments-adopt" type="button" role="tab" aria-controls="nav-comments-adopt" aria-selected="false" control-id="ControlID-3" tabindex="-1">Adoptante</button>

                                        </div>
                                    </nav>
                                    <div class="tab-content iq-tab-fade-up card-body" id="nav-tabContent">
                                        <div class="tab-pane fade active show" id="nav-comments-pub" role="tabpanel" aria-labelledby="nav-comments-pub-tab">
                                            <c:if test="${empty comments_pub}">
                                                <p class="text-muted">No ha recibido comentarios como Publicador</p>
                                            </c:if>
                                            <c:forEach items="${comments_pub}" var="comment_p">
                                                <div>
                                                    <div class="d-flex">
                                                        <div class="rating-stars block rating-comment" data-rating="${comment_p.calificacion}"></div>
                                                        <h4>${comment_p.calificacion}</h4>
                                                    </div>

                                                    <p class="ms-3 fst-italic">${comment_p.comentario}</p>
                                                </div>

                                            </c:forEach>
                                        </div>

                                        <div class="tab-pane fade" id="nav-comments-adopt" role="tabpanel" aria-labelledby="nav-comments-adopt-tab">
                                            <c:if test="${empty comments_adopt}">
                                                <p class="text-muted">No ha recibido comentarios como Adoptante</p>
                                            </c:if>
                                            <c:forEach items="${comments_adopt}" var="comment_a">
                                                <div>
                                                    <div class="d-flex">
                                                        <div class="rating-stars block rating-comment" data-rating="${comments_a.calificacion}"></div>
                                                        <h4>${comment_a.calificacion}</h4>
                                                    </div>

                                                    <p class="ms-3 fst-italic">${comment_a.comentario}</p>
                                                </div>

                                            </c:forEach>
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

<script src="${pageContext.request.contextPath}/js/plugins/rating/jquery.star-rating.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/plugins/rating/star-rating.js" type="text/javascript"></script>

