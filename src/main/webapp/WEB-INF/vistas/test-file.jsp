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

                <!-- formulario -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="informacion" role="tabpanel">
                        <div class="row">

                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="tab-content">
                                            <div class="tab-pane fade show active" id="v-pills-basicinfo-tab"
                                                 role="tabpanel"
                                                 aria-labelledby="v-pills-basicinfo-tab">
                                                <div class="d-flex align-items-center justify-content-between">
                                                    <h4>Información Personal</h4>

                                                </div>

                                                <hr>

                                                <form:form action="upload" id="form" method="POST" modelAttribute="testArchivo" enctype="multipart/form-data">

                                                    <div class="row">
                                                        <div class="col-4">
                                                            <div class="profile-img ms-2">


                                                                <img class="avatar-130 img-fluid"
                                                                     src="${pageContext.request.contextPath}/images/user/default.jpg"
                                                                     id="preview" alt="">
                                                                <div class="material-symbols-outlined btn btn-primary btn-profile">
                                                                    photo_camera
                                                                    <form:input path="imagen" name="archivoimagen" id="file" type="file" class="form-control opacity-0"/>

                                                                </div>
                                                            </div>

                                                        </div>



                                                    </div>


                                                    <div class="row">

                                                        <div class="d-flex align-items-center justify-content-end w-100 col-12">
                                                            <button type="submit" class="btn btn-primary">subir</button>
                                                        </div>

                                                    </div>

                                                </form:form>


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


<script src="${pageContext.request.contextPath}/js/preview.js" type="text/javascript"></script>

<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>


