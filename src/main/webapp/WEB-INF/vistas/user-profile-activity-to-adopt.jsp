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
                <div class="card">
                    <div class="card-body profile-page p-0">
                        <div class="profile-header">
                            <div class="position-relative">
                                <img src="${pageContext.request.contextPath}/images/page-img/user-bg.avif" alt="profile-bg"
                                     class="rounded img-fluid portrait-profile" loading="lazy">

                            </div>
                            <div class="user-detail text-center mb-3">
                                <div class="profile-img">
                                    <img src="${pageContext.request.contextPath}/images/user/11.png" alt="profile-img" loading="lazy"
                                         class="avatar-130 img-fluid"/>
                                </div>
                                <div class="profile-detail">
                                    <h3 class="">Juan Daniel</h3>
                                </div>
                            </div>
                            <div
                                    class="profile-info p-3 d-flex align-items-center justify-content-end position-relative">

                                <div class="social-info">
                                    <ul
                                            class="social-data-block d-flex align-items-center justify-content-between list-inline p-0 m-0">
                                        <li class="text-center ps-3">
                                            <h6>Publicados</h6>
                                            <p class="mb-0">4</p>
                                        </li>
                                        <li class="text-center ps-3">
                                            <h6>Adoptados</h6>
                                            <p class="mb-0">2</p>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body p-0">
                        <div class="user-tabing">
                            <ul
                                    class="nav nav-pills d-flex align-items-center justify-content-center profile-feed-items p-0 m-0 rounded">
                                <li class="nav-item col-12 col-sm-3 p-0">
                                    <a class="nav-link active" href="#pills-timeline-tab" data-bs-toggle="pill"
                                       data-bs-target="#timeline" role="button">Actividad</a>
                                </li>
                                <li class="nav-item col-12 col-sm-3 p-0">
                                    <a class="nav-link" href="#pills-informacion-tab" data-bs-toggle="pill"
                                       data-bs-target="#informacion" role="button">Informacion</a>
                                </li>
                                <li class="nav-item col-12 col-sm-3 p-0">
                                    <a class="nav-link" href="#pills-solicitudes-tab" data-bs-toggle="pill"
                                       data-bs-target="#solicitudes" role="button">Solicitudes</a>
                                </li>
                                <li class="nav-item col-12 col-sm-3 p-0">
                                    <a class="nav-link" href="#pills-preguntas-tab" data-bs-toggle="pill"
                                       data-bs-target="#preguntas" role="button">Preguntas</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <!-- TAB ACTIVIDAD -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="timeline" role="tabpanel">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card">
                                        <div class="card-header">
                                            <div class="header-title">
                                                <h4 class="card-title">Calificaciones</h4>
                                            </div>
                                        </div>
                                        <div class="card-body">

                                            <div class="mb-3">
                                                <div class="d-flex justify-content-between mt-2 text-dark">
                                                    <h6>Publicador</h6>
                                                    <small>4.5</small>
                                                </div>
                                                <div class="shadow-none progress  w-100 mt-2" style="height: 6px">
                                                    <div class="progress-bar bg-primary" data-toggle="progress-bar"
                                                         role="progressbar" aria-valuenow="90" aria-valuemin="0"
                                                         aria-valuemax="100"
                                                         style="width: 100%; transition: width 2s ease 0s;">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <div class="d-flex justify-content-between mt-2 text-dark">
                                                    <h6>Adoptante</h6>
                                                    <small>3</small>
                                                </div>
                                                <div class="shadow-none progress  w-100 mt-2" style="height: 6px">
                                                    <div class="progress-bar bg-success" data-toggle="progress-bar"
                                                         role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                         aria-valuemax="100"
                                                         style="width: 34%; transition: width 2s ease 0s;">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                                <li>
                                                    <a class="nav-link" href="#v-pills-misposts-tab"
                                                       data-bs-toggle="pill" data-bs-target="#v-pills-misposts-tab"
                                                       role="button">Mis Publicaciones</a>
                                                </li>
                                                <li>
                                                    <a class="nav-link" href="#v-pills-misfavoritos-tab"
                                                       data-bs-toggle="pill"
                                                       data-bs-target="#v-pills-misfavoritos-tab" role="button">Favoritos</a>
                                                </li>
                                                <li>
                                                    <a class="nav-link active" href="#v-pills-poradoptar-tab"
                                                       data-bs-toggle="pill"
                                                       data-bs-target="#v-pills-poradoptar-tab" role="button">Por
                                                        Adoptar</a>
                                                </li>
                                                <li>
                                                    <a class="nav-link" href="#v-pills-mascotas-tab"
                                                       data-bs-toggle="pill"
                                                       data-bs-target="#v-pills-mascotas-tab" role="button">Mis
                                                        mascotas</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>

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

