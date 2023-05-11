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
                              <ul class="header-nav list-inline d-flex flex-wrap justify-end p-0 m-0">
                                 <li><a href="#" class="material-symbols-outlined">
                                       edit
                                    </a>
                                 </li>
                                 <li><a href="#" class="material-symbols-outlined">
                                       settings
                                    </a>
                                 </li>
                              </ul>
                           </div>
                           <div class="user-detail text-center mb-3">
                              <div class="profile-img">
                                 <img src="${pageContext.request.contextPath}/images/user/11.png" alt="profile-img" loading="lazy"
                                    class="avatar-130 img-fluid" />
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
                                 <a class="nav-link active" href="#pills-timeline-tab" data-bs-toggle="pill"
                                    data-bs-target="#timeline" role="button">Actividad</a>
                              </li>
                              <li class="nav-item col-12 col-sm-3 p-0">
                                 <a class="nav-link" href="#pills-informacion-tab" data-bs-toggle="pill"
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
                  <!-- TAB ACTIVIDAD -->
                  <div class="tab-content">
                     <div class="tab-pane fade show active" id="timeline" role="tabpanel">
                        <div class="card-body p-0">
                           <div class="row">
                              <div class="col-lg-4">
                                 <div class="card">
                                    <div class="card-header">
                                       <div class="header-title">
                                          <h4 class="card-title">Calificaciones</h4>
                                       </div>
                                    </div>
                                    <div class="card-body">

                                       <div class="mb-3">
                                          <div class="d-flex justify-content-between mt-2 text-dark">
                                             <h6>Publicador</h6>
                                             <small>4.5</small>
                                          </div>
                                          <div class="shadow-none progress  w-100 mt-2" style="height: 6px">
                                             <div class="progress-bar bg-primary" data-toggle="progress-bar"
                                                role="progressbar" aria-valuenow="90" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 100%; transition: width 2s ease 0s;">
                                             </div>
                                          </div>
                                       </div>
                                       <div class="mb-3">
                                          <div class="d-flex justify-content-between mt-2 text-dark">
                                             <h6>Adoptante</h6>
                                             <small>3</small>
                                          </div>
                                          <div class="shadow-none progress  w-100 mt-2" style="height: 6px">
                                             <div class="progress-bar bg-success" data-toggle="progress-bar"
                                                role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 34%; transition: width 2s ease 0s;">
                                             </div>
                                          </div>
                                       </div>

                                    </div>
                                 </div>
                                 <div class="card">
                                    <div class="card-body">
                                       <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                          <li>
                                             <a class="nav-link active" href="#v-pills-misposts-tab"
                                                data-bs-toggle="pill" data-bs-target="#v-pills-misposts-tab"
                                                role="button">Mis Publicaciones</a>
                                          </li>
                                          <li>
                                             <a class="nav-link" href="#v-pills-misfavoritos-tab" data-bs-toggle="pill"
                                                data-bs-target="#v-pills-misfavoritos-tab" role="button">Favoritos</a>
                                          </li>
                                          <li>
                                             <a class="nav-link" href="#v-pills-poradoptar-tab" data-bs-toggle="pill"
                                                data-bs-target="#v-pills-poradoptar-tab" role="button">Por
                                                Adoptar</a>
                                          </li>
                                          <li>
                                             <a class="nav-link" href="#v-pills-mascotas-tab" data-bs-toggle="pill"
                                                data-bs-target="#v-pills-mascotas-tab" role="button">Mis mascotas</a>
                                          </li>

                                       </ul>
                                    </div>
                                 </div>

                              </div>
                              <div class="col-lg-8">

                                 <div class="card">

                                    <div class="card-body">
                                       <div class="tab-content">
                                          <!-- MIS PUBLICACIONES -->
                                          <div class="tab-pane fade active show" id="v-pills-misposts-tab"
                                             role="tabpanel" aria-labelledby="v-pills-misposts-tab">
                                             <h4>Mis Publicaciones</h4>
                                             <hr>

                                             <table class="table forum-table mb-0 rounded">
                                                <thead class="bg-primary text-white">
                                                   <tr>
                                                      <th>Publicacíon</th>
                                                      <th>Solicitudes</th>
                                                      <th>Preguntas</th>
                                                      <th>Estado</th>
                                                   </tr>
                                                </thead>
                                                <tbody>
                                                   <tr>
                                                      <td class="col-lg-5">
                                                         <a href="#">
                                                            <div class="d-flex align-items-center">
                                                               <img class="img-fluid rounded-circle avatar-40"
                                                                  src="${pageContext.request.contextPath}/images/posts/4/1.jpg" alt=""
                                                                  loading="lazy">
                                                               <div class="media-body ms-3">
                                                                  <h6 class="text-dark"><strong>Ninna</strong> </h6>
                                                                  <p class="mb-0"><span class="text-muted">Hace </span>
                                                                     <span class="link-primary"> 3
                                                                        días</span>
                                                                  </p>
                                                               </div>
                                                            </div>
                                                         </a>

                                                      </td>
                                                      <td class="col-lg-2 h6 text-center align-items-center">6</td>
                                                      <td class="col-lg-2 h6 text-center align-items-center">25</td>
                                                      <td class="col-lg-3 ">

                                                         <span
                                                            class="badge badge-pill bg-success mt-2">DISPONIBLE</span>



                                                      </td>
                                                   </tr>
                                                   <tr>
                                                      <td class="col-lg-5">
                                                         <a href="#">
                                                            <div class="d-flex align-items-center">
                                                               <img class="img-fluid rounded-circle avatar-40"
                                                                  src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt=""
                                                                  loading="lazy">
                                                               <div class="media-body ms-3">
                                                                  <h6 class="text-dark"><strong>Chonino</strong> </h6>
                                                                  <p class="mb-0"><span class="text-muted">Hace </span>
                                                                     <span class="link-primary"> 2
                                                                        semanas</span>
                                                                  </p>
                                                               </div>
                                                            </div>
                                                         </a>
                                                      </td>
                                                      <td class="col-lg-2 h6 text-center align-items-center">6</td>
                                                      <td class="col-lg-2 h6 text-center align-items-center">25</td>
                                                      <td class="col-lg-3 ">

                                                         <span class="badge badge-pill bg-warning mt-2">RESERVADO</span>



                                                      </td>
                                                   </tr>


                                                </tbody>
                                             </table>

                                          </div>
                                          <!-- MIS FAVORITOS -->
                                          <div class="tab-pane fade " id="v-pills-misfavoritos-tab" role="tabpanel"
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
                                                      <h6><strong>Tobby </strong> <small class="text-muted">de <a
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
                                                      <h6><strong>Olimpia </strong> <small class="text-muted">de <a
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
                                          <!-- POR ADOPTAR -->
                                          <div class="tab-pane fade " id="v-pills-poradoptar-tab" role="tabpanel"
                                             aria-labelledby="v-pills-poradoptar-tab">
                                             <h4>Mis Solicitudes de Adopción</h4>
                                             <hr>
                                             <ul class="request-list list-inline m-0 p-0">
                                                <li
                                                   class="d-flex align-items-center  justify-content-between flex-wrap">
                                                   <div class="d-flex">
                                                      <div class="user-img img-fluid flex-shrink-0">
                                                         <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" alt="story-img"
                                                            class="rounded-circle avatar-40" loading="lazy">
                                                      </div>
                                                      <div class="flex-grow-1 ms-3">
                                                         <h6><strong>Tobby </strong> <small class="text-muted">de <a
                                                                  href="#">Maria
                                                                  Gutierrez</a></small></h6>
                                                         <p class="mb-0">6 Interesados</p>
                                                      </div>
                                                   </div>



                                                   <div class="d-flex align-items-center mt-2 mt-md-0">
                                                      <div class="d-flex align-items-center">
                                                         <span class="material-symbols-outlined text-warning">
                                                            timer
                                                         </span>
                                                         <span
                                                            class="badge badge-pill text-warning me-5">Pendiente</span>
                                                      </div>
                                                      <div class="confirm-click-btn">
                                                         <a href="#"
                                                            class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                      </div>
                                                      <a href="#" class="btn btn-secondary rounded">Cancelar
                                                         Solicitud</a>
                                                   </div>
                                                </li>
                                                <li
                                                   class="d-flex align-items-center  justify-content-between flex-wrap">
                                                   <div class="d-flex">
                                                      <div class="user-img img-fluid flex-shrink-0">
                                                         <img src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt="story-img"
                                                            class="rounded-circle avatar-40" loading="lazy">
                                                      </div>
                                                      <div class="flex-grow-1 ms-3">
                                                         <h6><strong>Tor </strong> <small class="text-muted">de <a
                                                                  href="#">Jorge Gallur</a></small></h6>
                                                         <p class="mb-0">12 Interesados</p>
                                                      </div>
                                                   </div>



                                                   <div class="d-flex align-items-center mt-2 mt-md-0">
                                                      <div class="d-flex align-items-center">
                                                         <span class="material-symbols-outlined text-warning">
                                                            timer
                                                         </span>
                                                         <span class="badge badge-pill text-warning me-5">

                                                            Pendiente</span>
                                                      </div>

                                                      <div class="confirm-click-btn">
                                                         <a href="#"
                                                            class="me-3 btn btn-primary rounded confirm-btn">Ver</a>

                                                      </div>
                                                      <a href="#" class="btn btn-secondary rounded">Cancelar
                                                         Solicitud</a>
                                                   </div>
                                                </li>

                                             </ul>

                                          </div>

                                          <!-- MIS MASCOTAS -->
                                          <div class="tab-pane fade " id="v-pills-mascotas-tab" role="tabpanel"
                                             aria-labelledby="v-pills-mascotas-tab">
                                             <div class="d-flex align-items-center justify-content-between">
                                                <h4>Mis Mascotas</h4>
                                                <div >
                                                   <a href="new-mascot.html" class="btn btn-primary">Agregar nueva..</a>
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
                                                            <h5 class="mb-2"><strong>Chonino</strong> </h5>

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
                                                            <h5 class="mb-2"><strong>Isabella</strong> </h5>

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
                                                            <h5 class="mb-2"><strong>Tiny</strong> </h5>

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

                  <!-- TAB INFO PERSONAL -->
                  <div class="tab-content">
                      <div class="tab-pane fade" id="informacion" role="tabpanel">
                     <div class="row">
                        <div class="col-md-4">
                           <div class="card">
                              <div class="card-body">
                                 <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                    <li>
                                       <a class="nav-link active" href="#v-pills-basicinfo-tab" data-bs-toggle="pill"
                                          data-bs-target="#v-pills-basicinfo-tab" role="button">Información Personal
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
                                    <div class="tab-pane fade show active" id="v-pills-basicinfo-tab" role="tabpanel"
                                       aria-labelledby="v-pills-basicinfo-tab">
                                       <div class="d-flex align-items-center justify-content-between">
                                          <h4>Información Personal</h4>
                                          <a href="edit-profile.html" class="material-symbols-outlined btn btn-primary">
                                             edit
                                          </a>
                                       </div>

                                       <hr>
                                       <div class="alert alert-warning d-flex align-items-center" role="alert">
                                          <i class="fa-solid fa-triangle-exclamation font-size-14 me-2"></i>
                                          <div>
                                             Actualiza tu Información Personal. Te dará mejor reputación para Adoptar.
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Presentación:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0"></p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Nombre y apellido:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0">Juan Daniel</p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Email:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0">juandaniel@gmail.com</p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>F. Nac:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0"></p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Domicilio:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0"></p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Ciudad:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0"></p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Provincia:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0">(011) --</p>
                                          </div>
                                       </div>
                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Teléfono:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0">(011) --</p>
                                          </div>
                                       </div>

                                       <div class="row mb-2">
                                          <div class="col-3">
                                             <h6>Unido el:</h6>
                                          </div>
                                          <div class="col-9">
                                             <p class="mb-0">13 de Enero del 2023</p>
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
                 

                  <!-- TAB SOLICITUDES -->
                  <div class="tab-content">
                       <div class="tab-pane fade" id="solicitudes" role="tabpanel">
                     <div class="row">
                        <div class="col-md-4">
                           <div class="card">
                              <div class="card-body">
                                 <h4>Publicación</h4>
                                 <hr>
                                 <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                    <li>
                                       <a class="nav-link mb-2 active" href="#v-pills-solicitud-p1-tab" data-bs-toggle="pill"
                                       data-bs-target="#v-pills-solicitud-p1-tab" role="button">
                                    
                                       <div class="d-flex align-items-center justify-content-between">
                                          <div class="d-flex align-items-center">
                                             <img class="img-fluid rounded-circle avatar-40"
                                                src="${pageContext.request.contextPath}/images/posts/4/1.jpg" alt=""
                                                loading="lazy">
                                             <div class="media-body ms-3">
                                                <h6 class="text-dark"><strong>Ninna</strong> </h6>
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
                                       <a class="nav-link mb-2" href="#v-pills-solicitud-p2-tab" data-bs-toggle="pill"
                                       data-bs-target="#v-pills-solicitud-p2-tab" role="button">
                                       <div class="d-flex align-items-center justify-content-between">
                                       <div class="d-flex align-items-center">
                                          <img class="img-fluid rounded-circle avatar-40"
                                             src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt=""
                                             loading="lazy">
                                          <div class="media-body ms-3">
                                             <h6 class="text-dark"><strong>Chonino</strong> </h6>
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
                                    <p class="font-size-12 text-primary">Elije al mejor candidato para tu mascota. </p>
                                  
                                 </div>

                                 <hr>
                                 <div class="tab-content">
                                    <div class="tab-pane fade show active" id="v-pills-solicitud-p1-tab" role="tabpanel"
                                       aria-labelledby="v-pills-solicitud-p1-tab">
                                     

                                    
                                     
                                       <ul class="request-list list-inline m-0 p-0">
                                          <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                             <a href="" class="d-flex nav-link">
                                                  <div class="user-img img-fluid flex-shrink-0">
                                                <img src="${pageContext.request.contextPath}/images/user/05.jpg" alt="story-img" class="rounded-circle avatar-40" loading="lazy">
                                             </div>
                                             <div class="flex-grow-1 ms-3">
                                                <h6>Jaques Amole</h6>
                                                <div class="d-flex">
                                                     <div class="shadow-none progress  w-100 mt-2 me-2" style="height: 6px">
                                                   <div class="progress-bar bg-success " data-toggle="progress-bar"
                                                      role="progressbar" aria-valuenow="90" aria-valuemin="0"
                                                      aria-valuemax="100" style="width: 34%; transition: width 2s ease 0s;"> 
                                                   </div>
                                                   
                                                </div>
                                                <small class="text-warning">4.5</small>
                                                </div>
                                              
                                             </div>
                                             </a>
                                           
                                             <div class="d-flex align-items-center mt-2 mt-md-0">
                                                <div class="confirm-click-btn">
                                                   <a href="#" class="me-3 btn btn-primary rounded confirm-btn">Confirmar</a>
                                                 
                                                </div>
                                                <a href="#" class="btn btn-secondary rounded" data-extra-toggle="delete" data-closest-elem=".item">Rechazar</a>                                    
                                             </div>
                                          </li>
                                          <li class="d-flex align-items-center  justify-content-between flex-wrap">
                                             <a href="" class="d-flex nav-link">
                                                  <div class="user-img img-fluid flex-shrink-0">
                                                <img src="${pageContext.request.contextPath}/images/user/06.jpg" alt="story-img" class="rounded-circle avatar-40" loading="lazy">
                                             </div>
                                             <div class="flex-grow-1 ms-3">
                                                <h6>Mariel Godoy</h6>
                                                <div class="d-flex">
                                                     <div class="shadow-none progress  w-100 mt-2 me-2" style="height: 6px">
                                                   <div class="progress-bar bg-success " data-toggle="progress-bar"
                                                      role="progressbar" aria-valuenow="55" aria-valuemin="0"
                                                      aria-valuemax="100" style="width: 34%; transition: width 2s ease 0s;"> 
                                                   </div>
                                                   
                                                </div>
                                                <small class="text-warning">3.5</small>
                                                </div>
                                              
                                             </div>
                                             </a>
                                           
                                             <div class="d-flex align-items-center mt-2 mt-md-0">
                                                <div class="confirm-click-btn">
                                                   <a href="#" class="me-3 btn btn-primary rounded confirm-btn">Confirmar</a>
                                                 
                                                </div>
                                                <a href="#" class="btn btn-secondary rounded" data-extra-toggle="delete" data-closest-elem=".item">Rechazar</a>                                    
                                             </div>
                                          </li>
                                        
                                        
                                         
                                       </ul>

                                    </div>

                                    <div class="tab-pane fade " id="v-pills-solicitud-p2-tab" role="tabpanel"
                                    aria-labelledby="v-pills-solicitud-p2-tab">
                                  
                                  <div class="d-flex w-100 justify-content-center">
                                    <p class="text-muted">Aún no tenés Solicitudes para esta publicación</p>
                                  </div>
                                 

                                 </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  
                  </div>
                  </div>

                    <!-- TAB PREGUNTAS -->
                    <div class="tab-content">
                     <div class="tab-pane fade" id="preguntas" role="tabpanel">
                   <div class="row">
                      <div class="col-md-4">
                         <div class="card">
                            <div class="card-body">
                               <h4>Publicación</h4>
                               <hr>
                               <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                  <li>
                                     <a class="nav-link mb-2 active" href="#v-pills-preguntas-p1-tab" data-bs-toggle="pill"
                                     data-bs-target="#v-pills-preguntas-p1-tab" role="button">
                                  
                                     <div class="d-flex align-items-center justify-content-between">
                                        <div class="d-flex align-items-center">
                                           <img class="img-fluid rounded-circle avatar-40"
                                              src="${pageContext.request.contextPath}/images/posts/4/1.jpg" alt=""
                                              loading="lazy">
                                           <div class="media-body ms-3">
                                              <h6 class="text-dark"><strong>Ninna</strong> </h6>
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
                                     <a class="nav-link mb-2" href="#v-pills-preguntas-p2-tab" data-bs-toggle="pill"
                                     data-bs-target="#v-pills-preguntas-p2-tab" role="button">
                                     <div class="d-flex align-items-center justify-content-between">
                                     <div class="d-flex align-items-center">
                                        <img class="img-fluid rounded-circle avatar-40"
                                           src="${pageContext.request.contextPath}/images/posts/3/1.avif" alt=""
                                           loading="lazy">
                                        <div class="media-body ms-3">
                                           <h6 class="text-dark"><strong>Chonino</strong> </h6>
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
                                  <h4>Preguntas de Personas Interesadas</h4>
                                
                                
                               </div>

                               <hr>
                               <div class="tab-content">
                                  <div class="tab-pane fade show active" id="v-pills-preguntas-p1-tab" role="tabpanel"
                                     aria-labelledby="v-pills-preguntas-p1-tab">
                                     <div class="d-flex w-100 justify-content-center">
                                       <p class="text-muted">Aún no has recibido preguntas para esta publicación</p>
                                     </div>
                                    

                                  
                                   

                                  </div>

                                  <div class="tab-pane fade " id="v-pills-preguntas-p2-tab" role="tabpanel"
                                  aria-labelledby="v-pills-preguntas-p2-tab">
                                
                                <div class="d-flex w-100 justify-content-center">
                                  <p class="text-muted">Aún no has recibido preguntas para esta publicación</p>
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

