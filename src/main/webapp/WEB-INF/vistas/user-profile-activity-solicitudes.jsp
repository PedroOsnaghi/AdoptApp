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

                                                <!-- POR ADOPTAR -->
                                                <div class="tab-pane fade show active" id="v-pills-poradoptar-tab"
                                                     role="tabpanel"
                                                     aria-labelledby="v-pills-poradoptar-tab">
                                                    <h4>Mis Solicitudes de Adopción</h4>
                                                    <hr>
                                                    <ul class="request-list list-inline m-0 p-0">
                                                        <li
                                                                class="d-flex align-items-center  justify-content-between flex-wrap">
                                                            <div class="d-flex">
                                                                <div class="user-img img-fluid flex-shrink-0">
                                                                    <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt="story-img"
                                                                         class="rounded-circle avatar-40"
                                                                         loading="lazy">
                                                                </div>
                                                                <div class="flex-grow-1 ms-3">
                                                                    <h6><strong>Tobby </strong> <small
                                                                            class="text-muted">de <a
                                                                            href="#">Maria
                                                                        Gutierrez</a></small></h6>
                                                                    <p class="mb-0">6 Interesados</p>
                                                                </div>
                                                            </div>


                                                            <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                <div class="d-flex align-items-center">
                                                         <span class="material-symbols-outlined text-warning">
                                                            timer
                                                         </span>
                                                                    <span
                                                                            class="badge badge-pill text-warning me-5">Pendiente</span>
                                                                </div>
                                                                <div class="confirm-click-btn">
                                                                    <a href="#"
                                                                       class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                                </div>
                                                                <a href="#" class="btn btn-secondary rounded">Cancelar
                                                                    Solicitud</a>
                                                            </div>
                                                        </li>
                                                        <li
                                                                class="d-flex align-items-center  justify-content-between flex-wrap">
                                                            <div class="d-flex">
                                                                <div class="user-img img-fluid flex-shrink-0">
                                                                    <img src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt="story-img"
                                                                         class="rounded-circle avatar-40"
                                                                         loading="lazy">
                                                                </div>
                                                                <div class="flex-grow-1 ms-3">
                                                                    <h6><strong>Tor </strong> <small class="text-muted">de
                                                                        <a
                                                                                href="#">Jorge Gallur</a></small></h6>
                                                                    <p class="mb-0">12 Interesados</p>
                                                                </div>
                                                            </div>


                                                            <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                <div class="d-flex align-items-center">
                                                         <span class="material-symbols-outlined text-warning">
                                                            timer
                                                         </span>
                                                                    <span class="badge badge-pill text-warning me-5">

                                                            Pendiente</span>
                                                                </div>

                                                                <div class="confirm-click-btn">
                                                                    <a href="#"
                                                                       class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                                </div>
                                                                <a href="#" class="btn btn-secondary rounded">Cancelar
                                                                    Solicitud</a>
                                                            </div>
                                                        </li>

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

