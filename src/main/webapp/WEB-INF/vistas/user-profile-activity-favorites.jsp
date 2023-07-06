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

                                                <!-- MIS FAVORITOS -->
                                                <div class="tab-pane fade active show" id="v-pills-misfavoritos-tab"
                                                     role="tabpanel"
                                                     aria-labelledby="v-pills-misfavoritos-tab">
                                                    <h4>Mis Favoritos</h4>
                                                    <hr>
                                                    <ul class="request-list list-inline m-0 p-0">

                                                        <c:forEach items="${publicaciones}" var="favorito">
                                                            <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                                                <div class="user-img img-fluid flex-shrink-0">
                                                                    <img src="data:image/jpg;base64,${favorito.publicacion.mascota.foto}" alt="story-img"
                                                                         class="rounded-circle avatar-40" loading="lazy">
                                                                </div>
                                                                <div class="flex-grow-1 ms-3">
                                                                    <h6><strong>${favorito.publicacion.mascota.nombre}</strong> <small class="text-muted">de
                                                                        <a
                                                                                href="${pageContext.request.contextPath}/perfil/usuario?uid=${favorito.publicacion.mascota.usuario.id}">${favorito.publicacion.mascota.usuario.nombre}</a></small></h6>
                                                                    <p class="mb-0">0 Interesados</p>
                                                                </div>
                                                                <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                    <div class="confirm-click-btn">
                                                                        <a href="${pageContext.request.contextPath}/publicacion/ver?pid=${favorito.publicacion.id}"
                                                                           class="me-3 btn btn-primary rounded confirm-btn">Ver</a>
                                                                    </div>
                                                                    <a href="${pageContext.request.contextPath}/home/favoritos/eliminar?pid=${favorito.publicacion.id}" class="btn btn-secondary rounded"><i
                                                                            class="fa-solid fa-trash-can"></i></a>
                                                                </div>
                                                            </li>
                                                        </c:forEach>

                                                        <c:if test="${empty publicaciones}">
                                                            <p class="text-muted text-center">Aún no añadiste Favoritos a tu
                                                                lista.</p>
                                                        </c:if>



                                                    </ul>

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

