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

                <!-- TAB SOLICITUDES -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="solicitudes" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4>Publicación</h4>
                                        <hr>
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <li>
                                                <a class="nav-link mb-2 active" href="#v-pills-solicitud-p1-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-solicitud-p1-tab" role="button">

                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="${pageContext.request.contextPath}/images/posts/4/1.jpg" alt=""
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
                                                <a class="nav-link mb-2" href="#v-pills-solicitud-p2-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-solicitud-p2-tab" role="button">
                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt=""
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
                                            <h4>Solicitudes de Adopción</h4>
                                            <p class="font-size-12 text-primary">Elije al mejor candidato para tu
                                                mascota. </p>

                                        </div>

                                        <hr>
                                        <div class="tab-content">
                                            <div class="tab-pane fade show active" id="v-pills-solicitud-p1-tab"
                                                 role="tabpanel"
                                                 aria-labelledby="v-pills-solicitud-p1-tab">


                                                <ul class="request-list list-inline m-0 p-0">
                                                    <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                                        <a href="" class="d-flex nav-link">
                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                <img src="${pageContext.request.contextPath}/images/user/05.jpg" alt="story-img"
                                                                     class="rounded-circle avatar-40" loading="lazy">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h6>Jaques Amole</h6>
                                                                <div class="d-flex">
                                                                    <div class="shadow-none progress  w-100 mt-2 me-2"
                                                                         style="height: 6px">
                                                                        <div class="progress-bar bg-success "
                                                                             data-toggle="progress-bar"
                                                                             role="progressbar" aria-valuenow="90"
                                                                             aria-valuemin="0"
                                                                             aria-valuemax="100"
                                                                             style="width: 34%; transition: width 2s ease 0s;">
                                                                        </div>

                                                                    </div>
                                                                    <small class="text-warning">4.5</small>
                                                                </div>

                                                            </div>
                                                        </a>

                                                        <div class="d-flex align-items-center mt-2 mt-md-0">
                                                            <div class="confirm-click-btn">
                                                                <a href="#"
                                                                   class="me-3 btn btn-primary rounded confirm-btn">Confirmar</a>

                                                            </div>
                                                            <a href="#" class="btn btn-secondary rounded"
                                                               data-extra-toggle="delete" data-closest-elem=".item">Rechazar</a>
                                                        </div>
                                                    </li>
                                                    <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                                        <a href="" class="d-flex nav-link">
                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                <img src="${pageContext.request.contextPath}/images/user/06.jpg" alt="story-img"
                                                                     class="rounded-circle avatar-40" loading="lazy">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h6>Mariel Godoy</h6>
                                                                <div class="d-flex">
                                                                    <div class="shadow-none progress  w-100 mt-2 me-2"
                                                                         style="height: 6px">
                                                                        <div class="progress-bar bg-success "
                                                                             data-toggle="progress-bar"
                                                                             role="progressbar" aria-valuenow="55"
                                                                             aria-valuemin="0"
                                                                             aria-valuemax="100"
                                                                             style="width: 34%; transition: width 2s ease 0s;">
                                                                        </div>

                                                                    </div>
                                                                    <small class="text-warning">3.5</small>
                                                                </div>

                                                            </div>
                                                        </a>

                                                        <div class="d-flex align-items-center mt-2 mt-md-0">
                                                            <div class="confirm-click-btn">
                                                                <a href="#"
                                                                   class="me-3 btn btn-primary rounded confirm-btn">Confirmar</a>

                                                            </div>
                                                            <a href="#" class="btn btn-secondary rounded"
                                                               data-extra-toggle="delete" data-closest-elem=".item">Rechazar</a>
                                                        </div>
                                                    </li>


                                                </ul>

                                            </div>

                                            <div class="tab-pane fade " id="v-pills-solicitud-p2-tab" role="tabpanel"
                                                 aria-labelledby="v-pills-solicitud-p2-tab">

                                                <div class="d-flex w-100 justify-content-center">
                                                    <p class="text-muted">Aún no tenés Solicitudes para esta
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

