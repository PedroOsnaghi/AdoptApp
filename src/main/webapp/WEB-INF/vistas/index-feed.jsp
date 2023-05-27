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
                        <!--FEED TAB -->
                        <div class="tab-pane fade show active" id="feed" role="tabpanel">


                            <c:forEach items="${publicaciones}" var="publicacion">
                                <!-- PUBLICACION -->
                                <div class="card card-block card-stretch card-height">
                                    <div class="card-body">
                                        <div class="user-post-data">
                                            <div class="d-flex justify-content-between">
                                                <a href="">
                                                    <div class="me-3">
                                                        <img class="rounded-circle img-fluid"
                                                             src="${pageContext.request.contextPath}/images/user/${publicacion.mascota.usuario.imagen}"
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
                                                            <p class="text-muted mb-0" style="font-style: italic;">
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
                                            <div id="carousel" class="carousel slide"
                                                 data-bs-ride="carousel">
                                                <div class="carousel-indicators">
                                                    <c:forEach items="${publicacion.imagenes}" begin="0"
                                                               end="${publicacion.imagenes.size() - 1}"
                                                               varStatus="index">
                                                        <button type="button" data-bs-target="#carousel"
                                                                data-bs-slide-to="${index.count - 1}" class="active"
                                                                aria-current="true"></button>
                                                    </c:forEach>

                                                </div>
                                                <div class="carousel-inner " style="height: 400px;">
                                                    <c:forEach items="${publicacion.imagenes}" varStatus="index"
                                                               var="imagen">
                                                        <div class="carousel-item <c:if test="${index.count - 1 eq 0}">active</c:if>">
                                                            <img src="${pageContext.request.contextPath}/images/posts/${imagen.nombre}"
                                                                 class=" w-100 image-cover"
                                                                 height="100%" loading="lazy" alt="image">
                                                        </div>
                                                    </c:forEach>

                                                </div>
                                                <button class="carousel-control-prev" type="button"
                                                        data-bs-target="#carousel" data-bs-slide="prev"
                                                        control-id="ControlID-7">
                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                    <span class="visually-hidden">Previous</span>
                                                </button>
                                                <button class="carousel-control-next" type="button"
                                                        data-bs-target="#carousel" data-bs-slide="next"
                                                        control-id="ControlID-8">
                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
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
                                                                class="material-symbols-outlined me-1">star</i>Añadir en
                                                            Favoritos</a>


                                                        <a href="${pageContext.request.contextPath}/publicacion/ver?pid=${publicacion.id}"
                                                           class="btn d-inline-flex mb-3 me-1 btn-primary">Ver mas..</a>
                                                    </div>

                                                </div>

                                            </div>

                                        </div>
                                    </div>


                                </div>

                            </c:forEach>

                            <c:if test="${empty publicaciones}">
                                <p class="text-muted text-center">Aún nadie ha publicado</p>
                            </c:if>


                        </div>


                    </div>


                </div>


            </div>

            <!-- ACCESOS RAPIDOS -->
            <%@include file="partials/tools-home.jsp" %>

        </div>


    </div>


</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<c:if test="${not empty response_f}">

    <c:if test="${response_f eq 'exist'}">
        <script>showNotification("La publicación ya se encuentra en tu lista de Favoritos", "error");</script>
    </c:if>
    <c:if test="${response_f eq 'success'}">
        <script>showNotification("Se agregó a tu lista de Favoritos", "success");</script>
    </c:if>

</c:if>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

