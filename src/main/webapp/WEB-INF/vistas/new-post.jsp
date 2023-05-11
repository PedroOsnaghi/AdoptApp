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

                        <form  class="text-center mt-3" action="" id="form"  method="POST" modelAttribute="" enctype="multipart/form-data">
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
                           <fieldset control-id="ControlID-2" >
                              <div class="form-card text-start">
                                 <div class="row">
                                    <div class="col-12">
                                       <h5 class="mb-1">Selecciona la mascota a publicar:</h5>

                                    </div>
                                    </div>
                                    <div class="card-body">
                                       <h6 class="">Tus mascotas</h6>
                                       <hr class="mt-0">
                                       <div class="row">
                                          <div class="col-8">
                                             <input path="" type="radio" class="btn-check" name="mascota" id="m-1" checked/>
                                             <label for="m-1" class="btn-radio-mascota mb-1 p-1 ps-2">
                                                <div class="d-flex align-items-center  justify-content-between flex-wrap">
                                                   <div class="user-img img-fluid flex-shrink-0">
                                                      <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt="story-img" class="rounded-circle avatar-40" loading="lazy">
                                                   </div>
                                                   <div class="flex-grow-1 ms-3">
                                                      <h6><strong>Tobby </strong></h6>
                                                      <p class="mb-0">PERRO</p>
                                                   </div>
                                                   <div>
                                                      <i class="material-symbols-outlined shadow">
                                                         check_circle
                                                      </i>
                                                   </div>

                                                </div>
                                             </label>
                                             <input path="" type="radio" class="btn-check" name="mascota" id="m-2"/>
                                             <label for="m-2" class="btn-radio-mascota mb-1 p-1 ps-2">
                                                <div class="d-flex align-items-center  justify-content-between flex-wrap">
                                                   <div class="user-img img-fluid flex-shrink-0">
                                                      <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt="story-img" class="rounded-circle avatar-40" loading="lazy">
                                                   </div>
                                                   <div class="flex-grow-1 ms-3">
                                                      <h6><strong>Tobby </strong></h6>
                                                      <p class="mb-0">PERRO</p>
                                                   </div>
                                                   <div>
                                                      <i class="material-symbols-outlined shadow">
                                                         check_circle
                                                      </i>
                                                   </div>

                                                </div>
                                             </label>
                                          </div>
                                          <div class="col-4">
                                             <a href="${pageContext.request.contextPath}/mascota/crear" class="btn btn-primary">Agregar nueva..</a>
                                          </div>
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


                                       <div class="dropzone mb-3">
                                          <div class="fallback">
                                             <input path="" name="file" type="file" multiple="multiple"/>
                                          </div>
                                          <div class=" dz-message needsclick">
                                             <div class="mb-3">
                                                <i class="fa-solid fa-cloud-arrow-up display-4 text-muted"></i>
                                             </div>

                                             <h4 class="text-muted">Arrastra las imagenes o haz Click aqui para
                                                subirlas
                                             </h4>
                                          </div>
                                       </div>

                                       <ul class="list-unstyled mb-0" id="dropzone-preview">
                                          <li class="mt-2" id="dropzone-preview-list">
                                             <!-- This is used as the file preview template -->
                                             <div class="border rounded">
                                                <div class="d-flex p-2">
                                                   <div class="flex-shrink-0 me-3">
                                                      <div class="avatar-sm bg-light rounded">
                                                         <img data-dz-thumbnail class="img-fluid rounded d-block"
                                                            src="${pageContext.request.contextPath}/images/new-document.png"
                                                            alt="Dropzone-Image" />
                                                      </div>
                                                   </div>
                                                   <div class="flex-grow-1">
                                                      <div class="pt-1">
                                                         <h5 class="fs-14 mb-1" data-dz-name>&nbsp;</h5>
                                                         <p class="fs-13 text-muted mb-0" data-dz-size></p>
                                                         <strong class="error text-danger"
                                                            data-dz-errormessage></strong>
                                                      </div>
                                                   </div>
                                                   <div class="flex-shrink-0 ms-3">
                                                      <button data-dz-remove
                                                         class="btn btn-sm btn-danger">Eliminar</button>
                                                   </div>
                                                </div>
                                             </div>
                                          </li>
                                       </ul>
                                       <!-- end dropzon-preview -->
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
                                             <div class="card-header">
                                                <p class="card-title mb-0">
                                                   <strong>Dónde se realizará la
                                                      entrega?</strong>
                                                </p>
                                             </div>
                                             <div class="card-body">
                                                <input path="" type="text" class="form-control" id="exampleInputText1"
                                                   placeholder="Escribe tu dirección..." control-id="ControlID-9"/>

                                                <div>
                                                   <img src="${pageContext.request.contextPath}/images/page-img/mapa.avif"
                                                      class="w-100 d-block img-fluid mt-2" alt="">
                                                </div>
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

                                                <textarea path=""
                                                               class="form-control"
                                                               name=""
                                                               rows="5"
                                                               placeholder="Escribe aqui los dias y horarios para que el Adoptante pueda encontrarse contigo y retirar la mascota"></textarea>

                                             </div>

                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>

                              <button type="submit" name="next" class="btn btn-primary next action-button float-end"
                                 value="Submit" control-id="ControlID-8">Publicar</button>
                              <button type="button" name="previous"
                                 class="btn btn-dark previous action-button-previous float-end me-3" value="Previous"
                                 control-id="ControlID-9">Atrás</button>
                           </fieldset>

                        </form>





                     </div>
                  </div>
               </div>
            </div>


         </div>

</div>


<script src="${pageContext.request.contextPath}/vendor/dropzone/dropzone-min.js"></script>

  
<script src="${pageContext.request.contextPath}/js/form-file-upload.init.js"></script>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>


