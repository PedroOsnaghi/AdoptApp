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
                                                   data-bs-target="#v-pills-basicinfo-tab" role="button">Informaci?n
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
                                                    <h4>Informaci?n Personal</h4>

                                                </div>

                                                <hr>

                                                <form:form action="${pageContext.request.contextPath}/perfil/info/actualizar"  method="POST" modelAttribute="usuarioDto"
                                                           enctype="multipart/form-data">

                                                    <div class="row">
                                                        <div class="col-4 col-sm-5">
                                                            <div class="profile-img ms-2">


                                                                <img class="avatar-130 img-fluid"
                                                                     src="${pageContext.request.contextPath}/images/user/${usuarioDto.imagen}"
                                                                     id="preview" alt="">
                                                                <div class="material-symbols-outlined btn btn-primary btn-profile">
                                                                    photo_camera
                                                                    <form:input path="avatar"
                                                                           id="file"
                                                                           type="file"
                                                                           class="form-control opacity-0"/>

                                                                </div>
                                                            </div>

                                                        </div>

                                                        <div class="form-group col-8 col-sm-7">
                                                            <label class="form-label" for="fname">Tu
                                                                presentac?on</label>

                                                            <form:textarea class="form-control " path="presentacion" value="${usuarioDto.presentacion}"
                                                                      placeholder="Escribí un texto de presentaci?n que ser? visible en tu perfil por otros usuarios"
                                                                      id="" rows="3"></form:textarea>
                                                        </div>

                                                    </div>


                                                    <div class="row">
                                                        <div class="form-group col-6">
                                                            <label class="form-label" for="fname">Nombre y Apellido
                                                                *</label>
                                                            <form:input path="nombre" type="text" class="form-control" id="fname"
                                                                   placeholder="Escrib? tu nombre completo"
                                                                   value="${usuarioDto.nombre}"
                                                                   required="required" control-id="ControlID-3"/>
                                                        </div>
                                                        <div class="form-group col-6">
                                                            <label class="form-label" for="dob">Fecha de nacimiento:
                                                                *</label>
                                                            <form:input path="f_nac" type="date" class="form-control" id="dob"
                                                                   value="${usuarioDto.f_nac}" />
                                                        </div>
                                                        <div class="col-12">
                                                            <h5>Domicilio</h5>
                                                            <hr class="mt-0">
                                                        </div>


                                                        <div class="col-6">
                                                            <label class="form-label" for="fname">Dirección</label>
                                                            <form:input path="domicilio" type="text" class="form-control" id="dir"
                                                                    value="${usuarioDto.domicilio}"
                                                                   placeholder="Direccion.." readonly="true"
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <label class="form-label" for="fname">Ciudad</label>
                                                            <form:input path="ciudad" type="text" class="form-control" id="ciudad"
                                                                        value="${usuarioDto.ciudad}"
                                                                   placeholder="Ciudad.." readonly="true"
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <label class="form-label" for="fname">Provincia</label>
                                                            <form:input path="provincia" type="text" class="form-control" id="prov"
                                                                        value="${usuarioDto.provincia}"
                                                                   placeholder="Provincia.." readonly="true"
                                                                   required="required"
                                                                   control-id="ControlID-3"/>
                                                            <form:input path="lat" type="hidden" id="lat"/>
                                                            <form:input path="lng" type="hidden" id="lng"/>

                                                        </div>

                                                        <div class="col-6 px-4 py-5">
                                                            <button type="button" class="btn btn-primary"
                                                                    data-bs-toggle="modal" data-bs-target="#agregar-direccion"
                                                                    control-id="ControlID-4">
                                                                Agregar Direcci?n
                                                            </button>
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

<!-- Modal GOOGLE MAPS-->
<div class="modal fade" id="agregar-direccion" tabindex="-1" role="dialog" aria-labelledby="Agregar-direccion"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">

                </button>
                <h4 class="modal-title" id="exampleModalScrollableTitle">Agrega una direcci?n</h4>
                <p>Escribe la dirección que deseas agregar.</p>

            </div>
            <div class="modal-body">
                <input  type="text" class="form-control"  id="pac-input"
                        placeholder="Escribe tu direcci?n..." />

                <div class="w-100 d-block mt-2" style="height: 200px;" id="map">

                </div>
                <div class="d-flex justify-content-end mt-2">
                    <button type="button" class="btn btn-secondary me-2" id="close_modal"  data-bs-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" disabled id="add_dir">Agregar</button>
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


<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeluO_jCvIS_iT6Y3Thw8A6YJW5gyzh0M&callback=initAutocomplete&libraries=places&v=weekly"
        defer>
</script>

<script src="${pageContext.request.contextPath}/js/google.maps.js" type="text/javascript"></script>