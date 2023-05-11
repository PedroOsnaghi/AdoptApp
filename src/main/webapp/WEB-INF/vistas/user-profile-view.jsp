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
                                    <img src="${pageContext.request.contextPath}/images/user/01.jpg" alt="profile-img" loading="lazy"
                                         class="avatar-130 img-fluid"/>
                                </div>
                                <div class="profile-detail">
                                    <h3 class="">Maria Gutierrez</h3>
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

            </div>
            <div class="col-sm-12">
                <!-- TAB ACTIVIDAD -->

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


                                    <h4>Información </h4>

                                    <hr>

                                    <div class="row mb-2">
                                        <div class="col-4">
                                            <h6>Se unió el:</h6>
                                        </div>
                                        <div class="col-8">
                                            <p class="mb-0">13 de Enero del 2023</p>
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <div class="col-4">
                                            <h6>Edad:</h6>
                                        </div>
                                        <div class="col-8">
                                            <p class="mb-0">36</p>
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <div class="col-4">
                                            <h6>Ciudad:</h6>
                                        </div>
                                        <div class="col-8">
                                            <p class="mb-0">Morón, Buenos Aires</p>
                                        </div>
                                    </div>


                                </div>

                            </div>

                        </div>
                        <div class="col-lg-8">

                            <div class="card">

                                <div class="card-body">
                                    <h5>Presentación</h5>
                                    <hr class="mt-0">
                                    <p>Amante de los animales y dedicando mi vida a rescatarlos de la calle y
                                        conseguirles familia.</p>

                                </div>
                            </div>

                            <!-- publicaciones -->
                            <div class="card">
                                <div class="card-body">
                                    <h5>Lo que publicó</h5>
                                    <hr class="mt-0">
                                    <div class="card card-block card-stretch card-height">
                                        <div class="card-body">
                                            <div class="user-post-data">
                                                <div class="d-flex justify-content-between">
                                                    <a href="">
                                                        <div class="me-3">
                                                            <img class="rounded-circle img-fluid"
                                                                 src="${pageContext.request.contextPath}/images/user/01.jpg"
                                                                 style="max-width: 40px;" alt="" loading="lazy">
                                                        </div>
                                                    </a>

                                                    <div class="w-100">
                                                        <div class="d-flex justify-content-between">
                                                            <a href="profile-view.html">
                                                                <div class="">
                                                                    <h6 class="mb-0 d-inline-block">Maria Gutierrez</h6>
                                                                    <small class="mb-0 text-primary ">hace 30
                                                                        minutos</small>
                                                                    <p class="text-muted mb-0"
                                                                       style="font-style: italic;"><small
                                                                            class="text-muted"><i
                                                                            class="material-symbols-outlined small"
                                                                            style="font-size: 12px;">location_on</i>
                                                                        Buenos Aires, Ramos
                                                                        Mejia</small></p>
                                                                </div>
                                                            </a>


                                                            <div class="card-post-toolbar">
                                                                <div class="dropdown">
                                                      <span class="dropdown-toggle material-symbols-outlined"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false" role="button">
                                                         more_horiz
                                                      </span>
                                                                    <div class="dropdown-menu m-0 p-0">
                                                                        <a class="dropdown-item p-3" href="#">
                                                                            <div class="d-flex align-items-top">
                                                               <span class="material-symbols-outlined">
                                                                  save
                                                               </span>
                                                                                <div class="data ms-2">
                                                                                    <h6>Save Post</h6>
                                                                                    <p class="mb-0">Add this to your
                                                                                        saved items</p>
                                                                                </div>
                                                                            </div>
                                                                        </a>
                                                                        <a class="dropdown-item p-3" href="#">
                                                                            <div class="d-flex align-items-top">
                                                               <span class="material-symbols-outlined">
                                                                  cancel
                                                               </span>
                                                                                <div class="data ms-2">
                                                                                    <h6>Hide Post</h6>
                                                                                    <p class="mb-0">See fewer posts like
                                                                                        this.</p>
                                                                                </div>
                                                                            </div>
                                                                        </a>
                                                                        <a class="dropdown-item p-3" href="#">
                                                                            <div class="d-flex align-items-top">
                                                               <span class="material-symbols-outlined">
                                                                  person_remove
                                                               </span>
                                                                                <div class="data ms-2">
                                                                                    <h6>Unfollow User</h6>
                                                                                    <p class="mb-0">Stop seeing posts
                                                                                        but stay friends.</p>
                                                                                </div>
                                                                            </div>
                                                                        </a>
                                                                        <a class="dropdown-item p-3" href="#">
                                                                            <div class="d-flex align-items-top">
                                                               <span class="material-symbols-outlined">
                                                                  notifications
                                                               </span>
                                                                                <div class="data ms-2">
                                                                                    <h6>Notifications</h6>
                                                                                    <p class="mb-0">Turn on
                                                                                        notifications for this post</p>
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
                                                    <h4><strong>Tobby</strong></h4>
                                                    <div class="text-muted">
                                                        <span class="mx-1"><i class="fa-solid fa-mars"></i></span>Macho
                                                        <span class="mx-1"><i class="fa-solid fa-clock"></i></span>45d
                                                        <span class="mx-1"><i
                                                                class="fa-solid fa-weight-scale"></i></span>0,500kg
                                                    </div>
                                                </div>

                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nulla
                                                    dolor,
                                                    ornare at
                                                    commodo non, feugiat non nisi. Phasellus faucibus mollis pharetra.
                                                    Proin blandit
                                                    ac
                                                    massa sed rhoncus</p>
                                            </div>
                                            <div class="user-post">
                                                <div id="carouselExampleIndicators" class="carousel slide"
                                                     data-bs-ride="carousel">
                                                    <div class="carousel-indicators">
                                                        <button type="button"
                                                                data-bs-target="#carouselExampleIndicators"
                                                                data-bs-slide-to="0" class="" aria-label="Slide 1"
                                                                control-id="ControlID-4"></button>
                                                        <button type="button"
                                                                data-bs-target="#carouselExampleIndicators"
                                                                data-bs-slide-to="1" aria-label="Slide 2"
                                                                control-id="ControlID-5"
                                                                class=""></button>
                                                        <button type="button"
                                                                data-bs-target="#carouselExampleIndicators"
                                                                data-bs-slide-to="2" aria-label="Slide 3"
                                                                control-id="ControlID-6"
                                                                class="active" aria-current="true"></button>
                                                    </div>
                                                    <div class="carousel-inner " style="height: 400px;">
                                                        <div class="carousel-item active">
                                                            <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg"
                                                                 class="img-fluid w-100 image-cover"
                                                                 height="100" loading="lazy" alt="image">
                                                        </div>
                                                        <div class="carousel-item">
                                                            <img src="${pageContext.request.contextPath}/images/posts/1/2.jpg"
                                                                 class="img-fluid w-100 image-cover"
                                                                 height="100" loading="lazy" alt="image">
                                                        </div>
                                                        <div class="carousel-item">
                                                            <img src="${pageContext.request.contextPath}/images/posts/1/3.jpg"
                                                                 class="img-fluid w-100 image-cover"
                                                                 height="100" loading="lazy" alt="image">
                                                        </div>
                                                    </div>
                                                    <button class="carousel-control-prev" type="button"
                                                            data-bs-target="#carouselExampleIndicators"
                                                            data-bs-slide="prev"
                                                            control-id="ControlID-7">
                                                        <span class="carousel-control-prev-icon"
                                                              aria-hidden="true"></span>
                                                        <span class="visually-hidden">Previous</span>
                                                    </button>
                                                    <button class="carousel-control-next" type="button"
                                                            data-bs-target="#carouselExampleIndicators"
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
                                                        <div class="d-flex justify-content-between w-100 align-items-center">

                                                            <button type="button"
                                                                    class="btn d-inline-flex btn-soft-link mb-3 me-1"
                                                                    control-id="ControlID-93"><i
                                                                    class="material-symbols-outlined me-1">favorite</i>Agregar
                                                                a
                                                                Favoritos
                                                            </button>

                                                            <button type="button"
                                                                    class="btn d-inline-flex mb-3 me-1 btn-primary visually-hidden"
                                                                    control-id="ControlID-52"><i
                                                                    class="material-symbols-outlined me-1">subject</i>Ver
                                                                mas..
                                                            </button>
                                                            <a href="post-details.html"
                                                               class="btn d-inline-flex mb-3 me-1 btn-primary">Ver
                                                                mas..</a>
                                                        </div>

                                                    </div>

                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- LOADER -->
                                    <div class="col-sm-12 text-center">
                                        <img src="${pageContext.request.contextPath}/images/page-img/page-load-loader.gif" alt="loader"
                                             style="height: 100px;"
                                             loading="lazy">
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


