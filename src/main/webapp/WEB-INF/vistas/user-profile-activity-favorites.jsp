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

                                                <!-- MIS FAVORITOS -->
                                                <div class="tab-pane fade active show" id="v-pills-misfavoritos-tab"
                                                     role="tabpanel"
                                                     aria-labelledby="v-pills-misfavoritos-tab">
                                                    <h4>Mis Favoritos</h4>
                                                    <hr>
                                                    <ul class="request-list list-inline m-0 p-0">
                                                        <li
                                                                class="d-flex align-items-center  justify-content-between flex-wrap">
                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt="story-img"
                                                                     class="rounded-circle avatar-40" loading="lazy">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h6><strong>Tobby </strong> <small class="text-muted">de
                                                                    <a
                                                                            href="#">Maria
                                                                        Gutierrez</a></small></h6>
                                                                <p class="mb-0">6 Interesados</p>
                                                            </div>
                                                            <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                <div class="confirm-click-btn">
                                                                    <a href="#"
                                                                       class="me-3 btn btn-primary rounded confirm-btn">Ver</a>
                                                                    <a href="../app/profile.html"
                                                                       class="me-3 btn btn-primary rounded request-btn"
                                                                       style="display: none;">View All</a>
                                                                </div>
                                                                <a href="#" class="btn btn-secondary rounded"><i
                                                                        class="fa-solid fa-trash-can"></i></a>
                                                            </div>
                                                        </li>
                                                        <li
                                                                class="d-flex align-items-center  justify-content-between flex-wrap">
                                                            <div class="user-img img-fluid flex-shrink-0">
                                                                <img src="${pageContext.request.contextPath}/images/posts/2/1.webp" alt="story-img"
                                                                     class="rounded-circle avatar-40" loading="lazy">
                                                            </div>
                                                            <div class="flex-grow-1 ms-3">
                                                                <h6><strong>Olimpia </strong> <small class="text-muted">de
                                                                    <a
                                                                            href="#">Gastón Barrientos</a></small></h6>
                                                                <p class="mb-0">35 Interesados</p>
                                                            </div>
                                                            <div class="d-flex align-items-center mt-2 mt-md-0">
                                                                <div class="confirm-click-btn">
                                                                    <a href="#"
                                                                       class="me-3 btn btn-primary rounded confirm-btn">Ver</a>
                                                                    <a href="../app/profile.html"
                                                                       class="me-3 btn btn-primary rounded request-btn"
                                                                       style="display: none;">View All</a>
                                                                </div>
                                                                <a href="#" class="btn btn-secondary rounded"><i
                                                                        class="fa-solid fa-trash-can"></i></a>
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

