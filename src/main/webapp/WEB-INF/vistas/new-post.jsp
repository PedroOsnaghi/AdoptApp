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
                        <h3 class="text-white">Publicar</h3>
                        <p class="text-white">Crear una nueva publicación</p>
                     </div>
                  </div>
               </div>
               <div class="col-sm-12 col-lg-12">
                  <div class="card">

                     <div class="card-body">

                        <form:form  class="text-center mt-3" action="publicar" id="form-steep"  method="POST" modelAttribute="publicacionDto" enctype="multipart/form-data">
                           <ul id="top-tab-list" class="p-0 row list-inline mb-2">
                              <li class="col-lg-4 col-md-12 text-start mb-2 active" id="mascota">
                                 <a href="javascript:void(0);">
                                    <i class="material-symbols-outlined">
                                       pets
                                    </i><span>Mascota</span>
                                 </a>
                              </li>
                              <li  class="col-lg-4 col-md-12 mb-2 text-start" id="fotos">
                                 <a href="javascript:void(0);">
                                    <i class="material-symbols-outlined">
                                       photo_camera
                                    </i><span>Imagenes</span>
                                 </a>
                              </li>
                              <li class="col-lg-4 col-md-12 mb-2 text-start" id="entrega">
                                 <a href="javascript:void(0);">
                                    <i class="material-symbols-outlined">
                                       fmd_good
                                    </i><span>Entrega</span>
                                 </a>
                              </li>

                           </ul>
                           <!-- fieldsets -->
                           <fieldset  >
                              <div class="form-card text-start">
                                 <div class="row">
                                    <div class="col-12">
                                       <h5 class="mb-1">Selecciona la mascota a publicar:</h5>

                                    </div>
                                    </div>
                                    <div class="card-body">
                                       <h6 class="">Tus mascotas</h6>
                                       <hr class="mt-0">
                                       <div class="row mb-2">
                                          <div class="col-8">

                                             <c:forEach items="${mascotas}" var="mascota"  varStatus="i">

                                                   <form:radiobutton path="mascota_id"  class="btn-check"  id="m-${mascota.id}"  value="${mascota.id}" />
                                                   <label for="m-${mascota.id}" class="btn-radio-mascota mb-1 p-1 ps-2">
                                                      <div class="d-flex align-items-center  justify-content-between flex-wrap">
                                                         <div class="user-img img-fluid flex-shrink-0">
                                                            <img src="data:image/jpeg;base64,${mascota.foto}" alt="story-img" class="rounded-circle avatar-40" loading="lazy">
                                                         </div>
                                                         <div class="flex-grow-1 ms-3">
                                                            <h6><strong>${mascota.nombre}</strong></h6>
                                                            <p class="mb-0">${mascota.tipo}</p>
                                                         </div>
                                                         <div>
                                                            <i class="material-symbols-outlined shadow">
                                                               check_circle
                                                            </i>
                                                         </div>

                                                      </div>
                                                   </label>


                                             </c:forEach>
                                             <c:if test="${empty mascotas}">
                                                <p class="text-muted mt-2">No tienes mascotas registradas. Puedes crear una nueva.</p>
                                             </c:if>


                                          </div>
                                          <div class="col-4">
                                             <a href="${pageContext.request.contextPath}/mascota/crear?target=publicacion" class="btn btn-primary">Agregar nueva..</a>
                                          </div>
                                       </div>
                                       <h6 class="">Biografía</h6>
                                       <hr class="mt-0">
                                       <div class="row">
                                        <p class="text-muted">Escribe una breve bio acerca de tu mascota para que otros usuarios puedan saber un poco mas..</p>
                                        <form:textarea path="bio" rows="3" maxlength="255" class="form-control"></form:textarea>
                                       </div>
                                    </div>

                              </div>
                              <button type="button" name="next" class="btn btn-primary next action-button float-end"
                                 value="Next" control-id="ControlID-3">Continuar</button>
                           </fieldset>
                           <fieldset control-id="ControlID-4"  >
                              <div class="form-card text-start">
                                  <div class="row mb-2">
                                    <div class="col-12">
                                       <h5 class="mb-1">Cargar Imagenes:</h5>
                                       <p class="text-muted">Agrega Imagenes a tu publicacion para que las personas puedan conocer mejor a tu mascota.</p>
                                    </div>
                                    <div class="col-12">
                                       <div class="upload__box">
                                          <div class="btn btn-primary">
                                             <label class="upload__btn">
                                                <p class="mb-0">Cargar Imagenes</p>
                                                <form:input path="files"  type="file" multiple="true" data-max_length="3" class="upload__inputfile"/>
                                             </label>
                                          </div>
                                          <div class="upload__img-wrap"></div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <button type="button" name="next" class="btn btn-primary next action-button float-end"
                                 value="Next" control-id="ControlID-5">Continuar</button>
                              <button type="button" name="previous"
                                 class="btn btn-dark previous action-button-previous float-end me-3" value="Previous"
                                 control-id="ControlID-6">Atrás</button>
                           </fieldset>
                           <fieldset control-id="ControlID-7" >
                              <div class="form-card text-start">

                                 <div class="row">
                                    <div class="col-12">
                                       <h5 class="mb-1">Lugar de entrega:</h5>
                                       <p class="text-muted">Especifica un domicilio real donde se realizará la entrega de la
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
                                                <form:input path="direccion" class="form-control" type="text" readonly="true" id="dir"/>
                                                </div>
                                                <div class="form-group">
                                                   <label class="form-label" for="ciudad">Ciudad</label>
                                                <form:input path="ciudad"  class="form-control"  type="text" readonly="true" id="ciudad"/>
                                                </div>
                                                <div class="form-group">
                                                   <label class="form-label" for="prov">Provincia</label>
                                                <form:input path="provincia"  class="form-control"  type="text" readonly="true" id="prov"/>
                                                </div>
                                                <form:input path="latitud" type="hidden" id="lat"/>
                                                <form:input path="longitud" type="hidden" id="lng" />
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

                              <button type="submit" name="submit" class="btn btn-success float-end"
                                 value="Submit" >Publicar</button>
                              <button type="button" name="previous"
                                 class="btn btn-dark previous action-button-previous float-end me-3" value="Previous"
                                 >Atrás</button>
                           </fieldset>

                        </form:form>

                        <!-- error -->
                        <c:if test="${not empty error}">
                           <div class="mt-2">
                              <div class="alert alert-solid alert-danger alert-dismissible fade show d-flex align-items-center gap-2"
                                   role="alert">
                                 <span class="d-flex"><i class="material-symbols-outlined">error</i></span>
                                 <span>${error}</span>
                                 <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                         aria-label="Close" control-id="ControlID-9"></button>
                              </div>
                           </div>
                        </c:if>



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
            <input  type="text" class="form-control"  id="pac-input"
                    placeholder="Escribe tu dirección..." />

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



