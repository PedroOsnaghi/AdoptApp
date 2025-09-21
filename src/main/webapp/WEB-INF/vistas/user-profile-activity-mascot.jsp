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
                                            <div class="tab-content">
                                                <!-- MIS MASCOTAS -->
                                                <div class="tab-pane fade show active" id="v-pills-mascotas-tab"
                                                     role="tabpanel"
                                                     aria-labelledby="v-pills-mascotas-tab">
                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <h4>Mis Mascotas</h4>
                                                        <div>
                                                            <a href="${pageContext.request.contextPath}/mascota/crear?target=perfil" class="btn btn-primary">Agregar
                                                                nueva..</a>
                                                        </div>
                                                    </div>

                                                    <hr>
                                                    <div class="row ">
                                                        <c:forEach items="${mascotas}" var="mascota">
                                                            <div class="col-6 mt-5">
                                                                <div class="card bg-soft-dark">
                                                                    <div class="card-body" style="height: 135px;">
                                                                        <div class="iq-badges text-left">
                                                                            <div class="d-flex align-items-start justify-content-between">
                                                                                <div class="badges-icon">
                                                                                    <img class="avatar-80 rounded border border-light"
                                                                                         src="data:image/jpg;base64,${mascota.foto}" style="object-fit: cover;" alt=""
                                                                                         loading="lazy">
                                                                                </div>
                                                                                <c:choose>
                                                                                    <c:when test="${not empty mascota.publicacion}">
                                                                                        <span class="badge badge-pill bg-success  ms-2">
                                                                                        <i class="fa-solid fa-earth-americas"></i>
                                                                                        PUBLICADA
                                                                                         </span>
                                                                                    </c:when>
                                                                                    <c:when test="${empty mascota.publicacion}">
                                                                                        <span class="badge badge-pill bg-light text-dark  ms-2">
                                                                                        <i class="fa-solid fa-folder"></i>
                                                                                        SIN PUBLICAR
                                                                                         </span>
                                                                                    </c:when>

                                                                                </c:choose>
                                                                            </div>

                                                                            <h5 class="mb-2"><strong>${mascota.nombre}</strong></h5>

                                                                            <span class="text-uppercase">${mascota.nacimiento}</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:forEach>


                                                    </div>
                                                    <%--
                                                    <h4>Adoptados</h4>
                                                    <hr>
                                                    <div class="row ">
                                                        <div class="col-6 mt-5">
                                                            <div class="card bg-soft-dark">
                                                                <div class="card-body">
                                                                    <div class="iq-badges text-left">
                                                                        <div class="badges-icon">
                                                                            <img class="avatar-80 rounded border border-light"
                                                                                 src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt=""
                                                                                 loading="lazy">
                                                                        </div>
                                                                        <h5 class="mb-2"><strong>Tiny</strong></h5>

                                                                        <span class="text-uppercase">23 de Abril del 2023</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    --%>
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
    </div>
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

