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
                                    <a class="nav-link " href="#pills-timeline-tab" data-bs-toggle="pill"
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

                <!-- formulario -->
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

                                                </div>

                                                <hr>

                                                <form:form action="" id="" method="POST" modelAttribute=""
                                                           enctype="multipart/form-data">

                                                    <div class="row">
                                                        <div class="col-4">
                                                            <div class="profile-img ms-2">


                                                                <img class="avatar-130 img-fluid"
                                                                     src="${pageContext.request.contextPath}/images/user/1.jpg"
                                                                     id="preview" alt="">
                                                                <div class="material-symbols-outlined btn btn-primary btn-profile">
                                                                    photo_camera
                                                                    <form:input path="imagen" name="archivoImagen"
                                                                           id="file"
                                                                           type="file"
                                                                           class="form-control opacity-0"/>

                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="form-group col-8">
                                                            <label class="form-label" for="fname">Tu
                                                                presentacíon</label>
                                                            <textarea class="form-control " name=""
                                                                      placeholder="Escribí un texto de presentación que será visible en tu perfil por otros usuarios"
                                                                      id="" rows="3"></textarea>
                                                        </div>

                                                    </div>


                                                    <div class="row">
                                                        <div class="form-group col-6">
                                                            <label class="form-label" for="fname">Nombre y Apellido
                                                                *</label>
                                                            <form:input path="--" type="text" class="form-control" id="fname"
                                                                   name="fname"
                                                                   placeholder="Escribí tu nombre completo"
                                                                   value="Juan Daniel"
                                                                   required="required" control-id="ControlID-3"/>
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label class="form-label" for="dob">Fecha de nacimiento:
                                                                *</label>
                                                            <form:input path="--" type="date" class="form-control" id="dob"
                                                                   name="dob"
                                                                   control-id="ControlID-7"/>
                                                        </div>
                                                        <div class="col-12">
                                                            <h5>Domicilio</h5>
                                                            <hr class="mt-0">
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label class="form-label" for="fname">Cuál es tu
                                                                dirección?</label>
                                                            <form:input path="--" type="text" class="form-control" id="fname"
                                                                   name="fname"
                                                                   placeholder="Buscá tu domicilio aquí.."
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <div>
                                                                <img src="${pageContext.request.contextPath}/images/page-img/mapa.avif"
                                                                     class="w-100 d-block img-fluid mt-2" alt="">
                                                            </div>
                                                        </div>

                                                        <div class="col-6">
                                                            <label class="form-label" for="fname">Dirección</label>
                                                            <form:input path="--" type="text" class="form-control" id="fname"
                                                                   name="fname"
                                                                   placeholder="Suipacha 110" readonly
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <label class="form-label" for="fname">Ciudad</label>
                                                            <form:input path="--" type="text" class="form-control" id="fname"
                                                                   name="fname"
                                                                   placeholder="Ramos Mejia" readonly
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <label class="form-label" for="fname">Provincia</label>
                                                            <form:input path="--" type="text" class="form-control" id="fname"
                                                                   name="fname"
                                                                   placeholder="Buenos Aires" readonly
                                                                   required="required"
                                                                   control-id="ControlID-3"/>

                                                        </div>
                                                        <div class="d-flex align-items-center justify-content-end w-100 col-12">
                                                            <button type="submit" class="btn btn-primary">Guardar
                                                                Cambios
                                                            </button>
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


