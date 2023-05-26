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

                <%@include file="partials/profile-header.jsp" %>

                <%@include file="partials/nav-profile.jsp" %>
            </div>
            <div class="col-sm-12">

                <!-- TAB PREGUNTAS -->
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="preguntas" role="tabpanel">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4>Publicación</h4>
                                        <hr>
                                        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
                                            <li>
                                                <a class="nav-link mb-2 active" href="#v-pills-preguntas-p1-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-preguntas-p1-tab" role="button">

                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="${pageContext.request.contextPath}/images/posts/4/1.jpg"
                                                                 alt=""
                                                                 loading="lazy">
                                                            <div class="media-body ms-3">
                                                                <h6 class="text-dark"><strong>Ninna</strong></h6>
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
                                                <a class="nav-link mb-2" href="#v-pills-preguntas-p2-tab"
                                                   data-bs-toggle="pill"
                                                   data-bs-target="#v-pills-preguntas-p2-tab" role="button">
                                                    <div class="d-flex align-items-center justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <img class="img-fluid rounded-circle avatar-40"
                                                                 src="${pageContext.request.contextPath}/images/posts/3/1.avif"
                                                                 alt=""
                                                                 loading="lazy">
                                                            <div class="media-body ms-3">
                                                                <h6 class="text-dark"><strong>Chonino</strong></h6>
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

                                        <ul class="nav tab-nav-pane nav-tabs grid justify-content-evenly mb-0" role="tablist">
                                            <li class="pb-0 mb-0 nav-item" role="presentation">
                                                <a data-bs-toggle="tab" class="font-weight-bold text-uppercase nav-link d-flex align-items-center active" href="#Listview" aria-selected="true" role="tab">
                                       <span class="material-symbols-outlined md-18 me-1">
                                          mark_unread_chat_alt
                                          </span>
                                                    Sin responder
                                                </a>
                                            </li>
                                            <li class="pb-0 mb-0 nav-item" role="presentation">
                                                <a data-bs-toggle="tab" class="font-weight-bold text-uppercase ms-3 nav-link d-flex align-items-center" href="#Gridview" aria-selected="false" role="tab" tabindex="-1">
                                       <span class="material-symbols-outlined md-18 me-1">
                                          mark_chat_read
                                          </span>
                                                    Respondidas
                                                </a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane fade active show" id="Listview" role="tabpanel">
                                                <div class="">
                                                    <div class="card-header d-flex justify-content-between px-0">
                                                        <div class="header-title">
                                                            <h5 class="card-title">Preguntas sin responder (1)</h5>
                                                        </div>
                                                    </div>
                                                    <div class="card-body p-0 pt-3">

                                                        <!--una pregunta -->
                                                        <div class="accordion-item post-comments p-2 m-0 card rounded bg-light mb-2">
                                                            <p class="mb-0">Jaques Amole<small class="mb-0 link-primary"> Hace 2 dias</small></p>
                                                            <div class="iq-message-body iq-other-user">
                                                                <div class="chat-profile">
                                                                    <img src="${pageContext.request.contextPath}/images/user/02.jpg" alt="chat-user" class="avatar-40 rounded" loading="lazy">

                                                                </div>
                                                                <div class="iq-chat-text">

                                                                    <div class="d-flex align-items-center justify-content-start">
                                                                        <div class="iq-chating-content d-flex align-items-center ">
                                                                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse4" control-id="ControlID-5">
                                                                                <p class="mr-2 mb-0">Hola queria hacerte una consulta por el gatito</p>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div id="collapse5" class="accordion-collapse collapse" aria-labelledby="heading4" data-bs-parent="#accordionExample" style="">
                                                                <div class="accordion-body">
                                                                    <div class="card-footer px-2 py-2 mt-2 border-top rounded-0">
                                                                        <form class="d-flex align-items-center" action="#">

                                                                            <input type="text" class="form-control me-3" placeholder="Escribe tu respuesta" control-id="ControlID-1">
                                                                            <button type="submit" class="btn btn-primary d-flex align-items-center" control-id="ControlID-2">
                                                                                <i class="fa-regular fa-paper-plane" style="font-size: 22px;"></i>
                                                                            </button>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>




                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="Gridview" role="tabpanel">
                                                <div class="">
                                                    <div class="card-header d-flex justify-content-between px-0">
                                                        <div class="header-title">
                                                            <h5 class="card-title">Preguntas que respondiste</h5>
                                                        </div>
                                                    </div>
                                                    <div class="card-body p-0 pt-3">
                                                        <!--una pregunta -->
                                                        <div class="accordion-item post-comments p-2 m-0 card rounded bg-light mb-2">
                                                            <p class="mb-0">Jaques Amole<small class="mb-0 link-primary iq-chating"> Hace 2 dias</small></p>
                                                            <div class="iq-message-body iq-other-user">
                                                                <div class="chat-profile">
                                                                    <img src="${pageContext.request.contextPath}/images/user/02.jpg" alt="chat-user" class="avatar-40 rounded" loading="lazy">

                                                                </div>
                                                                <div class="iq-chat-text">

                                                                    <div class="d-flex align-items-center justify-content-start">
                                                                        <div class="iq-chating-content d-flex align-items-center ">
                                                                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4" control-id="ControlID-5">
                                                                                <p class="mr-2 mb-0">Hola, queria consultar por tu publicacion</p>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div id="collapse4" class="accordion-collapse collapse" aria-labelledby="heading4" data-bs-parent="#accordionExample" style="">
                                                                <div class="accordion-body">

                                                                    <div class="iq-message-body iq-current-user">
                                                                        <div class="chat-profile mt-5">
                                                                            <img src="${pageContext.request.contextPath}/images/user/default.jpg" alt="chat-user" class="avatar-40 rounded" loading="lazy">

                                                                        </div>
                                                                        <div class="iq-chat-text mt-2">

                                                                            <p class="mb-0 justify-content-start">Tu - <small class=" p-0 mb-0"> Hace 1 dia</small></p>


                                                                            <div class="d-flex align-items-center justify-content-end">

                                                                                <div class="iq-chating-content d-flex align-items-center ">
                                                                                    <p class="mr-2 mb-0">Gracias por preguntar, saludos</p>
                                                                                </div>
                                                                            </div>
                                                                            <a href="me-2">Eliminar respuesta</a>
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
</div>


<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>

