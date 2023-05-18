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
                                                            <a href="new-mascot.html" class="btn btn-primary">Agregar
                                                                nueva..</a>
                                                        </div>
                                                    </div>

                                                    <hr>
                                                    <div class="row ">
                                                        <div class="col-6 mt-5">
                                                            <div class="card bg-soft-dark">
                                                                <div class="card-body">
                                                                    <div class="iq-badges text-left">
                                                                        <div class="badges-icon">
                                                                            <img class="avatar-80 rounded border border-light"
                                                                                 src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt=""
                                                                                 loading="lazy">
                                                                        </div>
                                                                        <h5 class="mb-2"><strong>Chonino</strong></h5>

                                                                        <span class="text-uppercase">23 de Abril del 2023</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-6 mt-5">
                                                            <div class="card bg-soft-dark">
                                                                <div class="card-body">
                                                                    <div class="iq-badges text-left">
                                                                        <div class="badges-icon">
                                                                            <img class="avatar-80 rounded border border-light"
                                                                                 src="${pageContext.request.contextPath}/images/posts/4/1.jpg" alt=""
                                                                                 loading="lazy">
                                                                        </div>
                                                                        <h5 class="mb-2"><strong>Isabella</strong></h5>

                                                                        <span class="text-uppercase">4 de Enero del 2023</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

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

