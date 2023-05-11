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
                                    <a class="nav-link active" href="#pills-informacion-tab" data-bs-toggle="pill"
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
                <!-- TAB INFO PERSONAL -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="informacion" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <li>
                                                <a class="nav-link active" href="#v-pills-basicinfo-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-basicinfo-tab" role="button">Información
                                                    Personal
                                                </a>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8 ps-4">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="tab-content">
                                            <div class="tab-pane fade show active" id="v-pills-basicinfo-tab"
                                                 role="tabpanel"
                                                 aria-labelledby="v-pills-basicinfo-tab">
                                                <div class="d-flex align-items-center justify-content-between">
                                                    <h4>Información Personal</h4>
                                                    <a href="edit-profile.html"
                                                       class="material-symbols-outlined btn btn-primary">
                                                        edit
                                                    </a>
                                                </div>

                                                <hr>
                                                <div class="alert alert-warning d-flex align-items-center" role="alert">
                                                    <i class="fa-solid fa-triangle-exclamation font-size-14 me-2"></i>
                                                    <div>
                                                        Actualiza tu Información Personal. Te dará mejor reputación para
                                                        Adoptar.
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Presentación:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0"></p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Nombre y apellido:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0">Juan Daniel</p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Email:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0">juandaniel@gmail.com</p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>F. Nac:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0"></p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Domicilio:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0"></p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Ciudad:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0"></p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Provincia:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0">(011) --</p>
                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Teléfono:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0">(011) --</p>
                                                    </div>
                                                </div>

                                                <div class="row mb-2">
                                                    <div class="col-3">
                                                        <h6>Unido el:</h6>
                                                    </div>
                                                    <div class="col-9">
                                                        <p class="mb-0">13 de Enero del 2023</p>
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
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

