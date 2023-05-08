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
                                <img src="images/page-img/user-bg.avif" alt="profile-bg"
                                     class="rounded img-fluid portrait-profile" loading="lazy">
                            </div>
                            <div class="user-detail text-center mb-3">
                                <div class="profile-img">
                                    <img src="images/user/11.png" alt="profile-img" loading="lazy"
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
                                    <a class="nav-link" href="#pills-timeline-tab" data-bs-toggle="pill"
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
                                    <a class="nav-link active" href="#pills-preguntas-tab" data-bs-toggle="pill"
                                       data-bs-target="#preguntas" role="button">Preguntas</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">

                <!-- TAB PREGUNTAS -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="preguntas" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4>Publicación</h4>
                                        <hr>
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <li>
                                                <a class="nav-link mb-2 active" href="#v-pills-preguntas-p1-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-preguntas-p1-tab" role="button">

                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="images/posts/4/1.jpg" alt=""
                                                                 loading="lazy">
                                                            <div class="media-body ms-3">
                                                                <h6 class="text-dark"><strong>Ninna</strong></h6>
                                                                <p class="mb-0"><span class="text-muted">Hace </span>
                                                                    <span class="link-primary"> 3
                                                    días</span>
                                                                </p>
                                                            </div>

                                                        </div>
                                                        <span class="badge bg-danger ml-2 text-white"><strong>2</strong></span>
                                                    </div>

                                                </a>
                                            </li>
                                            <li>
                                                <a class="nav-link mb-2" href="#v-pills-preguntas-p2-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-preguntas-p2-tab" role="button">
                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="images/posts/3/1.avif" alt=""
                                                                 loading="lazy">
                                                            <div class="media-body ms-3">
                                                                <h6 class="text-dark"><strong>Chonino</strong></h6>
                                                                <p class="mb-0"><span class="text-muted">Hace </span>
                                                                    <span class="link-primary"> 2
                                                 semanas</span>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8 ps-4">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="">
                                            <h4>Preguntas de Personas Interesadas</h4>


                                        </div>

                                        <hr>
                                        <div class="tab-content">
                                            <div class="tab-pane fade show active" id="v-pills-preguntas-p1-tab"
                                                 role="tabpanel"
                                                 aria-labelledby="v-pills-preguntas-p1-tab">
                                                <div class="d-flex w-100 justify-content-center">
                                                    <p class="text-muted">Aún no has recibido preguntas para esta
                                                        publicación</p>
                                                </div>


                                            </div>

                                            <div class="tab-pane fade " id="v-pills-preguntas-p2-tab" role="tabpanel"
                                                 aria-labelledby="v-pills-preguntas-p2-tab">

                                                <div class="d-flex w-100 justify-content-center">
                                                    <p class="text-muted">Aún no has recibido preguntas para esta
                                                        publicación</p>
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

