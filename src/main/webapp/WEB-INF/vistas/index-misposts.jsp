<!-- head -->

<%@ include file="partials/head.jsp" %>

<!-- navbar -->

<%@ include file="partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="partials/sidebar.jsp" %>


<div id="content-page" class="content-page">

  <!-- contenido -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 row m-0 p-0">
        <div class="col-sm-12">
          <div id="post-modal-data" class="card card-block card-stretch card-height">
            <div class="card-header d-flex justify-content-start">
              <div class="user-img me-3">
                <img src="${pageContext.request.contextPath}/images/user/1.jpg" alt="userimg" class="avatar-60 rounded-circle"
                     loading="lazy">
              </div>
              <div class="header-title">
                <h4 class="card-title">Hola Juan Daniel</h4>
              </div>
            </div>
            <div class="card-body">
              <ul class="nav nav-pills d-flex align-items-center justify-content-center profile-feed-items p-0 m-0 rounded"
                  role="tablist">
                <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
                  <a class="nav-link" href="#pills-feed-tab" data-bs-toggle="pill"
                     data-bs-target="#feed" role="button" aria-selected="true">Feed</a>
                </li>
                <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
                  <a class="nav-link" href="#pills-favoritos-tab" data-bs-toggle="pill"
                     data-bs-target="#favoritos" role="button" aria-selected="false"
                     tabindex="-1">Favoritos</a>
                </li>
                <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
                  <a class="nav-link active" href="#pills-misposts-tab" data-bs-toggle="pill"
                     data-bs-target="#misposts" role="button" aria-selected="false" tabindex="-1">Mis
                    Publicaciones</a>
                </li>

              </ul>

            </div>

          </div>
        </div>


        <div class="col-sm-12">


          <div class="tab-content">

            <!-- MIS PUBLICACIONES TAB -->

            <div class="tab-pane fade show active" id="misposts" role="tabpanel">

              <div class="card card-block card-stretch card-height">
                <div class="card-body">
                  <div class="user-post-data">
                    <div class="d-flex justify-content-between">
                      <a href="">
                        <div class="me-3">
                          <img class="rounded-circle img-fluid" src="${pageContext.request.contextPath}/images/user/1.jpg"
                               style="max-width: 40px;" alt="" loading="lazy">
                        </div>
                      </a>

                      <div class="w-100">
                        <div class="d-flex justify-content-between">
                          <div class="">
                            <h6 class="mb-0 d-inline-block">Juan Daniel</h6>
                            <small class="mb-0 text-primary ">hace 3 días</small>
                            <p class="text-muted mb-0" style="font-style: italic;"><small
                                    class="text-muted"><i class="material-symbols-outlined small"
                                                          style="font-size: 12px;">location_on</i> Buenos Aires, Ramos
                              Mejia</small></p>
                          </div>

                          <div class="card-post-toolbar">
                            <div class="dropdown">
                                                   <span class="dropdown-toggle material-symbols-outlined"
                                                         data-bs-toggle="dropdown" aria-haspopup="true"
                                                         aria-expanded="false" role="button">
                                                      more_horiz
                                                   </span>
                              <div class="dropdown-menu m-0 p-0">
                                <a class="dropdown-item p-3" href="#">
                                  <div class="d-flex align-items-top">
                                                            <span class="material-symbols-outlined">
                                                               save
                                                            </span>
                                    <div class="data ms-2">
                                      <h6>Save Post</h6>
                                      <p class="mb-0">Add this to your saved items</p>
                                    </div>
                                  </div>
                                </a>
                                <a class="dropdown-item p-3" href="#">
                                  <div class="d-flex align-items-top">
                                                            <span class="material-symbols-outlined">
                                                               cancel
                                                            </span>
                                    <div class="data ms-2">
                                      <h6>Hide Post</h6>
                                      <p class="mb-0">See fewer posts like this.</p>
                                    </div>
                                  </div>
                                </a>
                                <a class="dropdown-item p-3" href="#">
                                  <div class="d-flex align-items-top">
                                                            <span class="material-symbols-outlined">
                                                               person_remove
                                                            </span>
                                    <div class="data ms-2">
                                      <h6>Unfollow User</h6>
                                      <p class="mb-0">Stop seeing posts but stay friends.</p>
                                    </div>
                                  </div>
                                </a>
                                <a class="dropdown-item p-3" href="#">
                                  <div class="d-flex align-items-top">
                                                            <span class="material-symbols-outlined">
                                                               notifications
                                                            </span>
                                    <div class="data ms-2">
                                      <h6>Notifications</h6>
                                      <p class="mb-0">Turn on notifications for this post</p>
                                    </div>
                                  </div>
                                </a>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <hr class="mt-0">
                  <div class="mt-3">
                    <div class="d-flex justify-content-between align-items-center mb-2">
                      <h4><strong>Tobby</strong></h4>
                      <div class="text-muted">
                        <span class="mx-1"><i class="fa-solid fa-mars"></i></span>Macho
                        <span class="mx-1"><i class="fa-solid fa-clock"></i></span>45d
                        <span class="mx-1"><i class="fa-solid fa-weight-scale"></i></span>0,500kg
                      </div>
                    </div>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nulla dolor,
                      ornare at
                      commodo non, feugiat non nisi. Phasellus faucibus mollis pharetra. Proin blandit
                      ac
                      massa sed rhoncus</p>
                  </div>
                  <div class="user-post">
                    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                      <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="0" class="" aria-label="Slide 1"
                                control-id="ControlID-4"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="1" aria-label="Slide 2" control-id="ControlID-5"
                                class=""></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="2" aria-label="Slide 3" control-id="ControlID-6"
                                class="active" aria-current="true"></button>
                      </div>
                      <div class="carousel-inner " style="height: 400px;">
                        <div class="carousel-item active">
                          <img src="${pageContext.request.contextPath}/images/posts/1/1.jpg" class="img-fluid w-100 image-cover"
                               height="100" loading="lazy" alt="image">
                        </div>
                        <div class="carousel-item">
                          <img src="${pageContext.request.contextPath}/images/posts/1/2.jpg" class="img-fluid w-100 image-cover"
                               height="100" loading="lazy" alt="image">
                        </div>
                        <div class="carousel-item">
                          <img src="${pageContext.request.contextPath}/images/posts/1/3.jpg" class="img-fluid w-100 image-cover"
                               height="100" loading="lazy" alt="image">
                        </div>
                      </div>
                      <button class="carousel-control-prev" type="button"
                              data-bs-target="#carouselExampleIndicators" data-bs-slide="prev"
                              control-id="ControlID-7">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                      </button>
                      <button class="carousel-control-next" type="button"
                              data-bs-target="#carouselExampleIndicators" data-bs-slide="next"
                              control-id="ControlID-8">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                      </button>
                    </div>


                  </div>
                  <div class="comment-area mt-3">
                    <div class="d-flex justify-content-between align-items-center flex-wrap">
                      <div class="like-block position-relative d-flex align-items-center w-100">
                        <div class="d-flex justify-content-between w-100 align-items-center">

                          <button type="button" class="btn d-inline-flex btn-soft-link mb-3 me-1"
                                  control-id="ControlID-93"><i
                                  class="material-symbols-outlined me-1">favorite</i>Agregar a
                            Favoritos</button>

                          <button type="button"
                                  class="btn d-inline-flex mb-3 me-1 btn-primary visually-hidden"
                                  control-id="ControlID-52"><i
                                  class="material-symbols-outlined me-1">subject</i>Ver mas..</button>
                          <a href="post-details.html"
                             class="btn d-inline-flex mb-3 me-1 btn-primary">Ver mas..</a>
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


      <!--ACCESOS RAPIDOS -->
      <div class="col-lg-4">
        <div class="card">
          <div class="card-header d-flex justify-content-between">
            <div class="header-title">
              <h4 class="card-title">Acceso Rápido</h4>
            </div>
          </div>
          <div class="card-body">
            <ul class="media-story list-inline m-0 p-0">
              <a href="new-post.html">
                <li class="d-flex mb-3 align-items-center">
                                 <span class="rounded-circle img-fluid bg-primary new-post font-size-12">
                                    <i class="material-symbols-outlined">
                                       add
                                    </i>
                                 </span>

                  <div class="stories-data ms-3">
                    <h5>Crea una publicación</h5>
                    <p class="mb-0">Publíca tu mascota</p>
                  </div>
                </li>
              </a>




            </ul>

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
