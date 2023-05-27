<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="partials/sidebar.jsp" %>



<div>
   <!-- AQUI VA EL CONTENIDO -->


   <div class="mascota-profile-bg-img">

   </div>


   <div id="content-page" class="content-page superponer">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="card">
                  <div class="card-body">
                     <div class="row">
                        <div class="col-lg-2">
                           <div class="item1 ms-1">
                              <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" class="img-fluid rounded profile-image"
                                 alt="profile-image" loading="lazy">
                           </div>
                        </div>
                        <div class="col-lg-10">
                           <div class="d-flex justify-content-between">
                              <div class="item2 ">
                                 <h4 class=""><strong>Tobby</strong></h4>
                                 <span>6 Interesados</span>
                              </div>
                              <div class="item4 ms-1">
                                 <div class="d-flex justify-content-between">
                                    <a href="">
                                       <div class="me-3">
                                          <img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/images/user/01.jpg"
                                             style="max-width: 40px;" alt="" loading="lazy">
                                       </div>
                                    </a>

                                    <div class="w-100">
                                       <div class="d-flex justify-content-between">
                                          <div class="">
                                             <h6 class="mb-0 d-inline-block">Maria Gutierrez</h6>
                                             <p class="mb-0 text-primary ">hace 30 minutos</p>

                                          </div>


                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-lg-5">
                                 <div class="item5 mt-3">
                                    <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined  md-18">
                                          location_on
                                       </span>
                                       <a href="#" class="link-primary h6 ms-2">Buenos Aires, Ramos mejia</a>
                                    </div>

                                    <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined md-18">
                                          bookmark_border
                                       </span>
                                       <span class="ms-2">Nació el <a href="#" class="link-primary h6">3 de Abril del
                                             2023</a></span>
                                    </div>
                                    <div class="d-flex align-items-center mb-1">
                                       <span class="material-symbols-outlined md-18">
                                          sell
                                       </span>
                                       <span class="ms-2">Categoria: <a href="#"
                                             class="link-primary h6">PERROS</a></span>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-lg-7">
                                 <div class="item6 border-light border-start">
                                    <div class="d-grid ms-2">

                                       <h6 class="mb-4">No lo dudes!, <strong>Tobby</strong> te necesita</h6>
                                       <div class="d-grid">
                                          <button type="button" class="btn btn-primary d-block mt-3"
                                             data-bs-toggle="modal" data-bs-target="#confirma-adopcion"
                                             control-id="ControlID-4">
                                             Quiero Adoptarlo!
                                          </button>
                                          <button type="button" class="btn btn-secondary d-block mt-3"
                                             data-bs-toggle="modal" data-bs-target="#confirma-adopcion"
                                             control-id="ControlID-4">
                                             Cancelar Solicitud
                                          </button>

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
         <div class="row">
            <div class="col-lg-4">
               <div class="card">
                  <div class="card-header d-flex justify-content-between">
                     <div class="header-title">
                        <h4 class="card-title">Bio</h4>
                     </div>

                  </div>
                  <div class="card-body">
                     <div class="d-flex flex-column justify-content-between">
                        <p>Tobby, es un cachorrito muy tierno y juguetón que esta buscando una familia que le de
                           mucho amor. Necesita un hogar con patio ya que le gusta correr por todos lados.</p>
                     </div>


                     <!-- informacion de mascota -->
                     <div class="row">
                        <h4 class="mt-3">Información Básica</h4>
                        <hr>
                        <div class="col-4">
                           <h6>Género</h6>
                        </div>
                        <div class="col-8">
                           <p class="mb-0">Macho</p>
                        </div>
                        <div class="col-4">
                           <h6>Raza</h6>
                        </div>
                        <div class="col-8">
                           <p class="mb-0">No aporta</p>
                        </div>
                        <div class="col-4">
                           <h6>Peso</h6>
                        </div>
                        <div class="col-8">
                           <p class="mb-0">0,500 Kg</p>
                        </div>
                        <div class="col-4">
                           <h6>Salud</h6>
                        </div>
                        <div class="col-8">
                           <p class="mb-0">Todas las vacúnas</p>
                        </div>
                        <div class="col-4">
                           <h6>Edad</h6>
                        </div>
                        <div class="col-8">
                           <p class="mb-0">45 días</p>
                        </div>
                     </div>



                     <div class="d-flex flex-column  mt-4">
                        <h5>Personalidad</h5>
                        <div class="d-flex flex-wrap me-3">
                           <span class="badge badge-pill bg-light text-dark mt-2 me-2">
                              <i class="fa-solid fa-circle"></i>
                              Juguetón</span>
                           <span class="badge badge-pill bg-light text-dark mt-2 me-2">
                              <i class="fa-solid fa-circle"></i>
                              Amoroso</span>
                        </div>



                     </div>

                  </div>
               </div>
            </div>

            <div class="col-lg-8">
               <div id="post-modal-data" class="card">
                  <div class="card-header d-flex justify-content-between">
                     <div class="header-title">
                        <h4 class="card-title">Fotos</h4>
                     </div>
                  </div>
                  <div class="card-body">
                     <div class="d-grid gap-2 grid-cols-3">
                        <a data-fslightbox="gallery" href="images/posts/1/1.jpg">
                           <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" class="img-fluid bg-soft-info img-size fit-cover"
                              alt="photo-profile" loading="lazy">
                        </a>
                        <a data-fslightbox="gallery" href="images/posts/1/2.jpg">
                           <img src="${pageContext.request.contextPath}/images/posts/1/2.jpg" class="img-fluid bg-soft-info img-size fit-cover"
                              alt="photo-profile" loading="lazy">
                        </a>
                        <a data-fslightbox="gallery" href="images/posts/1/3.jpg">
                           <img src="${pageContext.request.contextPath}/images/posts/1/3.jpg" class="img-fluid bg-soft-info img-size fit-cover"
                              alt="photo-profile" loading="lazy">
                        </a>

                     </div>
                  </div>
               </div>

               <!-- PREGUNTAS -->

               <div class="card">
                  <div class="card-header">
                     <div class="header-title">
                        <h5 class="card-tit">Preguntale a <strong>Maria Gutierrez</strong> por mi</h5>
                     </div>
                     <div>
                        <form:form action="${pageContext.request.contextPath}/mensaje/enviar" modelAttribute="mensajeDto">
                           <form:textarea path="pregunta" class="form-control mt-2"  rows="3" placeholder="Escribí tu pregunta..." required="true"></form:textarea>
                           <form:input path="publicacion.id" value="${publicacion.id}" type="hidden"/>
                           <div class="d-flex justify-content-end">
                              <button type="submit" class="btn btn-primary mt-2"> <i class="fa-regular fa-paper-plane" style="font-size: 18px;"></i> Enviar</button>

                           </div>
                        </form:form>
                        <c:if test="${msj_response eq 'error'}" >
                           <div class="alert alert-solid alert-danger d-flex align-items-center mt-2 py-1 " role="alert">
                              <div>
                                 No pudimos enviar tu mensaje debido a un error.
                              </div>
                           </div>
                        </c:if>
                        <c:if test="${msj_response eq 'success'}" >
                           <div class="alert alert-solid alert-success d-flex align-items-center mt-2 py-1 " role="alert">
                              <div>
                                 Enviamos tu mensaje a ${publicacion.mascota.usuario.nombre}.
                              </div>
                           </div>
                        </c:if>
                     </div>

                  </div>

               </div>

               <div class="card">
                  <div class="card-header d-flex justify-content-between">
                     <div class="header-title">
                        <h4 class="card-title">Últimas realizadas</h4>
                     </div>
                  </div>
                  <div class="card-body">

                     <c:forEach items="${mensajes}" var="mensaje">
                        <div class="post-comments p-2 m-0 card rounded bg-light mb-2">

                           <!-- PREGUNTA -->
                           <p class="mb-0">
                              <c:if test="${mensaje.emisor.id eq usuario.id}">
                                 <strong>Tu pregunta -</strong>
                              </c:if>

                              ${mensaje.pregunta}

                              <small class="link-primary"> - ${mensaje.fechaEmision}</small>

                           </p>
                           <!--RESPUESTA OCULTA-->
                           <c:if test="${not empty mensaje.respuesta}">
                              <details>
                                 <summary class="comments-view  link-primary">Ver respuesta</summary>
                                 <p class="text-muted comments-response">
                                    ${mensaje.respuesta}
                                    <small class="link-primary"> - ${mensaje.fechaRespuesta}</small></p>
                              </details>
                           </c:if>



                        </div>
                     </c:forEach>

                     <c:if test="${empty mensajes}">
                        <p class="text-muted mt-3">Aún nadie ha realizado preguntas.</p>
                     </c:if>









                  </div>
               </div>

            </div>
         </div>
      </div>





   </div>

</div>



<!-- Modal -->
<div class="modal fade" id="confirma-adopcion" tabindex="-1" role="dialog" aria-labelledby="confirma-adopcion"
   aria-hidden="true">
   <div class="modal-dialog modal-dialog-scrollable" role="document">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">

            </button>
            <h4 class="modal-title" id="exampleModalScrollableTitle">Que grán desición!</h4>
            <p>Enviaremos tu solicitud al publicante y te avisaremos si acepta tu solicitud.</p>

         </div>
         <div class="modal-body">
            <p class="text-muted" style="font-style: italic;"><strong>Lee atentamente -</strong> Si estás pensando sumar
               un amigo peludo
               tenés que saber el compromiso que esto implica. No sólo será tu compañía sino un integrante más de la
               familia. Por lo que te recomendamos planifiques bien su llegada, asegúrate que todos estén de acuerdo
               y que en tu edificio o casa se permitan mascotas. Tené en cuenta los gastos mensuales relacionados,
               cuidados generales que necesitará para que se encuentre saludable y cómodo y con quién dejarlo en caso
               de salir de vacaciones.</p>
            <hr>
            <form action="">

               <div class="form-group">
                  <label class="form-label" for="exampleFormControlTextarea1">Mensaje a María Guttierrez</label>
                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" control-id="ControlID-20"
                     placeholder="Dile por qué debería aceptarte como Adoptante de Tobby"></textarea>
               </div>
               <div class="d-flex justify-content-end">
                  <button type="button" class="btn btn-secondary me-2" data-bs-dismiss="modal">Lo pensaré</button>
                  <button type="button" class="btn btn-primary">Estoy seguro</button>
               </div>

            </form>
         </div>





      </div>
   </div>
</div>

<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>


