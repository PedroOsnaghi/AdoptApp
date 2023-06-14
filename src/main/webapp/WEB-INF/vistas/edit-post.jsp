<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->
<%@ include file="partials/sidebar.jsp" %>


<!-- AQUI VA EL CONTENIDO -->

<div id="content-page" class="content-page ">
    <div class="container">

        <div class="row">
            <div class="col-sm-12">
                <div class="card position-relative inner-page-bg bg-primary" style="height: 90px;">
                    <div class="inner-page-title">
                        <h3 class="text-white">Editar Publicacion</h3>
                        <p class="text-white">Modifica la información de tu publicación</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-lg-12">
                <div class="card">

                    <div class="card-body">

                        <!-- error -->
                        <c:if test="${not empty success}">
                            <div class="mb-2">
                                <div class="alert alert-solid alert-success alert-dismissible fade show d-flex align-items-center gap-2"
                                     role="alert">
                                    <span class="d-flex"><i class="material-symbols-outlined">done</i></span>
                                    <span>Los cambios se guardaron con correctamente.</span>
                                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                            aria-label="Close" control-id="ControlID-9"></button>
                                </div>
                            </div>
                        </c:if>

                        <!-- error -->
                        <c:if test="${not empty error}">
                            <div class="mb-2">
                                <div class="alert alert-solid alert-danger alert-dismissible fade show d-flex align-items-center gap-2"
                                     role="alert">
                                    <span class="d-flex"><i class="material-symbols-outlined">error</i></span>
                                    <span>${error}</span>
                                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                            aria-label="Close" control-id="ControlID-9"></button>
                                </div>
                            </div>
                        </c:if>

                        <form:form class="text-center mt-3" action="actualizar"  method="POST"
                                   modelAttribute="publicacionDto" enctype="multipart/form-data">

                           <div class="form-card text-start">
                              <div class="row mb-2">
                                 <div class="col-12">
                                    <h5 class="mb-1">Mascota publicada:</h5>
                                 </div>
                                  <div class="card card-mascota mx-auto" style="width: 90%">
                                      <div  class="card-body">
                                          <div class="row">
                                              <div class="col-lg-2">
                                                  <div class="item1 ms-1">
                                                      <img src="data:image/jpg;base64,${publicacionDto.mascota.foto}" class="img-fluid rounded profile-image"
                                                           alt="profile-image" loading="lazy">
                                                  </div>
                                              </div>
                                              <div class="col-lg-10">
                                                  <div class="d-flex align-items-baseline">

                                                      <h4 class="me-2"><strong>${publicacionDto.mascota.nombre}</strong></h4>
                                                      <span>6 Interesados</span>


                                                  </div>
                                                  <div class="row">
                                                      <div class="col-lg-5">
                                                          <div class="item5 mt-3">
                                                              <div class="d-flex align-items-center mb-1">
                                                         <span class="material-symbols-outlined  md-18">
                                                            location_on
                                                         </span>
                                                                  <a href="#" class="link-primary h6 ms-2">${publicacionDto.provincia}, ${publicacionDto.ciudad}</a>
                                                              </div>
                                                              <c:if test="${not empty publicacionDto.mascota.nacimiento}">
                                                                  <div class="d-flex align-items-center mb-1">
                                                             <span class="material-symbols-outlined md-18">
                                                                bookmark_border
                                                             </span>
                                                                      <span class="ms-2">Nació el <a href="#" class="link-primary h6">${publicacionDto.mascota.nacimiento}</a></span>
                                                                  </div>
                                                              </c:if>
                                                              <div class="d-flex align-items-center mb-1">
                                                         <span class="material-symbols-outlined md-18">
                                                            sell
                                                         </span>
                                                                  <span class="ms-2">Categoria: <a href="#"
                                                                                                   class="link-primary h6">${publicacionDto.mascota.tipo}</a></span>
                                                              </div>
                                                          </div>
                                                      </div>


                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>

                               <h5>Biografía</h5>
                               <hr class="mt-0">
                               <div class="row mb-3">
                                   <p class="text-muted mb-0">Escribe una breve bio acerca de tu mascota para que otros usuarios puedan saber un poco mas..</p>
                                   <form:textarea path="bio" rows="3" maxlength="255" class="form-control"></form:textarea>
                               </div>

                           </div>


                           <div class="form-card text-start">
                                <div class="row mb-2">
                                    <div class="col-12">
                                        <h5 class="mb-1">Cargar Imagenes:</h5>
                                        <hr class="mt-0">
                                        <p class="text-muted">Agrega Imagenes a tu publicacion para que las personas
                                            puedan conocer mejor a tu mascota.</p>
                                    </div>
                                    <div class="col-12">
                                        <div class="upload__box">
                                            <div class="d-flex align-items-baseline">
                                                <div class="btn btn-primary">
                                                    <label class="upload__btn">
                                                        <p class="mb-0">Cargar Imagenes</p>
                                                        <form:input path="files" type="file" id="input_file" multiple="true" img-loaded="${publicacionDto.imagenes.size()}"
                                                                    data-max_length="${max_upload}" class="upload__inputfile"/>
                                                    </label>
                                                </div>
                                                <p class="ms-2">Imagenes cargadas: <span id="img-loaded" class="text-primary ms-1">${publicacionDto.imagenes.size()}</span><span>/${max_upload}</span></p>
                                            </div>

                                            <div class="upload__img-wrap" id="img_wrap">
                                                <c:forEach items="${publicacionDto.imagenes}" var="imagen"
                                                           varStatus="index">
                                                    <div class='upload__img-box uploaded'>
                                                        <div style="background-image: url('data:image/jpeg;base64,${imagen.base64Content}')"
                                                             file-id="${imagen.id}" class='img-bg'>
                                                            <a class='uploaded__img-close' onclick="confirm(this)" action="${pageContext.request.contextPath}/archivo/eliminar?id=${imagen.id}&pid=${publicacionDto.id}&target=p_edit" href="javascript:void(0);">

                                                            </a>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="form-card text-start">

                                <div class="row">
                                    <div class="col-12">
                                        <h5 class="mb-1">Lugar de entrega:</h5>
                                        <hr class="mt-0">
                                        <p class="text-muted">Especifica un domicilio real donde se realizará la entrega
                                            de la
                                            mascota, pero no te
                                            preocupes que esta información no sera visible hasta que tu no aceptes
                                            la solicitud de
                                            adopción.</p>
                                    </div>
                                    <div class="row">

                                        <div class=" col-6">
                                            <div class="card">
                                                <div class="card-header d-flex justify-content-between align-items-center">
                                                    <p class="card-title mb-0">
                                                        <strong>Dónde se realizará la
                                                            entrega?</strong>
                                                    </p>
                                                    <button type="button" class="btn btn-primary"
                                                            data-bs-toggle="modal" data-bs-target="#agregar-direccion"
                                                            control-id="ControlID-4">
                                                        Agregar Dirección
                                                    </button>
                                                </div>
                                                <div class="card-body">

                                                    <div class="form-group">
                                                        <label class="form-label" for="dir">Dirección localizada</label>
                                                        <form:input path="direccion" class="form-control" type="text"
                                                                    readonly="true" id="dir"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="form-label" for="ciudad">Ciudad</label>
                                                        <form:input path="ciudad" class="form-control" type="text"
                                                                    readonly="true" id="ciudad"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="form-label" for="prov">Provincia</label>
                                                        <form:input path="provincia" class="form-control" type="text"
                                                                    readonly="true" id="prov"/>
                                                    </div>
                                                    <form:input path="latitud" type="hidden" id="lat"/>
                                                    <form:input path="longitud" type="hidden" id="lng"/>
                                                </div>

                                            </div>
                                        </div>
                                        <div class=" col-6">
                                            <div class="card">
                                                <div class="card-header">
                                                    <p class="card-title mb-0">
                                                        <strong>Qué dias y horarios te encontrarás para realizar la
                                                            entrega?</strong>
                                                    </p>
                                                </div>
                                                <div class="card-body">

                                                    <form:textarea path="disponibilidad"
                                                                   class="form-control"
                                                                   rows="5"
                                                                   maxlength="255"
                                                                   placeholder="Escribe aqui los dias y horarios para que el Adoptante pueda encontrarse contigo y retirar la mascota"></form:textarea>

                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <button type="submit" name="submit" class="btn btn-primary float-end"
                                    value="Submit">Guardar Cambios
                            </button>


                        <!-- INPUTS OCULTOS -->
                            <form:input path="id" type="hidden" value="${publicacionDto.id}"/>

                        </form:form>


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
                <h4 class="modal-title" id="exampleModalScrollableTitle">Agrega una dirección</h4>
                <p>Escribe la dirección que deseas agregar.</p>

            </div>
            <div class="modal-body">
                <input type="text" class="form-control" id="pac-input"
                       placeholder="Escribe tu dirección..."/>

                <div class="w-100 d-block mt-2" style="height: 200px;" id="map">

                </div>
                <div class="d-flex justify-content-end mt-2">
                    <button type="button" class="btn btn-secondary me-2" id="close_modal" data-bs-dismiss="modal">
                        Cancelar
                    </button>
                    <button type="button" class="btn btn-primary" disabled id="add_dir">Agregar</button>
                </div>


            </div>


        </div>
    </div>
</div>

<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>


<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeluO_jCvIS_iT6Y3Thw8A6YJW5gyzh0M&callback=initAutocomplete&libraries=places&v=weekly"
        defer>
</script>
<script src="${pageContext.request.contextPath}/js/multifile.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/google.maps.js" type="text/javascript"></script>
<!--- Internal Sweet-Alert js -->
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/sweet-alert/jquery.sweet-alert.js"></script>



