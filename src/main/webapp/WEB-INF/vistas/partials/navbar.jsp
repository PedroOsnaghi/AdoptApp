<!-- navbar superior -->
<div class="iq-top-navbar">
    <nav class="nav navbar navbar-expand-lg navbar-light iq-navbar p-lg-0">
        <div class="container-fluid navbar-inner">
            <div class="d-flex align-items-center flex-lg-row-reverse gap-3 pb-2 pb-lg-0">
                <a class="sidebar-toggle" data-toggle="sidebar" data-active="true" href="javascript:void(0);">
                    <div class="icon material-symbols-outlined iq-burger-menu">
                        menu
                    </div>
                </a>

                <!-- aqui el logo -->
                <a href="${pageContext.request.contextPath}/home/"
                   class="d-flex align-items-center gap-2 iq-header-logo">
                    <div class="brand img-fluid"></div>

                </a>

            </div>
            <!-- busqueda -->
            <div class="iq-search-bar device-search  position-relative">
                <form action="#" class="searchbox" data-bs-toggle="modal" data-bs-target="#searchmodal">
                    <a class="search-link d-none d-lg-block" href="javascript:void(0);">
                        <span class="material-symbols-outlined">search</span>
                    </a>
                    <input type="text" class="text search-input form-control bg-soft-primary  d-none d-lg-block"
                           placeholder="Qu? estas buscando?">
                    <a class="d-lg-none d-flex d-none d-lg-block" href="javascript:void(0);" data-bs-toggle="modal"
                       data-bs-target="#searchmodal">
                        <span class="material-symbols-outlined">search</span>
                    </a>
                </form>
                <!-- SUGERENCIAS DE BUSQUEDA -->
                <div class="modal fade search-modal" id="searchmodal" aria-labelledby="searchmodalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-fullscreen-lg-down">
                        <div class="modal-content">
                            <div class="modal-header py-2">
                                <div class="d-flex align-items-center justify-content-between d-lg-none w-100">
                                    <form action="#" class="searchbox w-50" data-bs-toggle="modal"
                                          data-bs-target="#searchmodal">
                                        <a class="search-link" href="javascript:void(0);">
                                            <span class="material-symbols-outlined">search</span>
                                        </a>
                                        <input type="text" class="text search-input form-control bg-soft-primary"
                                               placeholder="Qu? estas buscando?">
                                    </form>
                                    <a href="javascript:void(0);" class="material-symbols-outlined text-dark"
                                       data-bs-dismiss="modal">close</a>
                                </div>
                                <div class="d-none d-lg-flex align-items-center justify-content-between w-100">
                                    <h4 class="modal-title" id="exampleModalFullscreenLabel">Busquedas recientes</h4>
                                    <a class="text-dark" href="javascript:void(0);">Limpiar</a>
                                </div>
                            </div>
                            <div class="modal-body p-0">
                                <div class="d-flex d-lg-none align-items-center justify-content-between w-100 p-3 pb-0">
                                    <h5 class="modal-title h4" id="exampleModalFullscreenLabel">Busquedas recientes</h5>
                                    <a href="javascript:void(0);" class="text-dark">Limpiar</a>
                                </div>

                                <div class="d-flex align-items-center border-bottom search-hover py-2 px-3">
                                    <div class="flex-shrink-0">
                                        <img src="${pageContext.request.contextPath}/images/user/19.jpg"
                                             class="align-self-center img-fluid avatar-50 rounded-pill" alt="#">
                                    </div>
                                    <div class="d-flex flex-column ms-3 w-100">
                                        <a href="javascript:void(0);" class="h5">Paige Turner</a>
                                        <span>Paige001</span>
                                    </div>
                                    <div class="d-flex align-items-center ms-auto">
                                        <a href="javascript:void(0);"
                                           class="me-3 d-flex align-items-center"><small>Publicaci?n</small>
                                        </a>
                                        <a href="javascript:void(0);"
                                           class="material-symbols-outlined text-dark">close</a>
                                    </div>
                                </div>

                                <!-- SUGERENCIAS -->
                                <div class="">
                                    <h4 class="px-3 py-2">Resultados</h4>

                                    <div class="d-flex align-items-center border-bottom search-hover py-2 px-3">
                                        <div class="flex-shrink-0">
                                            <img src="${pageContext.request.contextPath}/images/user/19.jpg"
                                                 class="align-self-center img-fluid avatar-50 rounded-pill" alt="#">
                                        </div>
                                        <div class="d-flex flex-column ms-3 w-100">
                                            <a href="javascript:void(0);" class="h5">Paige Turner</a>
                                            <span>Paige001</span>
                                        </div>
                                        <div class="d-flex align-items-center ms-auto">
                                            <a href="javascript:void(0);"
                                               class="me-3 d-flex align-items-center"><small>Publicaci?n</small>
                                            </a>
                                            <a href="javascript:void(0);" class="material-symbols-outlined text-dark">close</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <ul class="navbar-nav navbar-list">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/home/" class="d-flex align-items-center">
                        <i class="material-symbols-outlined">home</i>
                    </a>
                </li>

                <!-- notificaciones -->
                <li class="nav-item dropdown">
                    <a href="javascript:void(0);" class="search-toggle dropdown-toggle d-flex align-items-center"
                       id="notification-drop" data-bs-toggle="dropdown">
                        <i class="material-symbols-outlined">notifications</i>
                        <span class="d-none" id="new-notifications">0</span>
                    </a>
                    <div class="sub-drop dropdown-menu" aria-labelledby="notification-drop">
                        <div class="card shadow-none m-0">
                            <div class="card-header d-flex justify-content-between bg-primary">
                                <div class="header-title bg-primary">
                                    <h5 class="mb-0 text-white">Notificaciones</h5>
                                </div>
                                <small class="badge  bg-light text-dark" id="notification-counter">0</small>
                            </div>

                            <div class="card-body p-0" id="notification-container">
<%--                                <a href="javascript:void(0);" class="iq-sub-card">--%>
<%--                                    <p>Notificacion random 1234</p>--%>
<%--                                    <small>hace xxx minutos</small>--%>
<%--                                </a>--%>
<%--                                <a href="javascript:void(0);" class="iq-sub-card">--%>
<%--                                    <p>Notificacion mas random random</p>--%>
<%--                                    <small>hace YYY minutos</small>--%>
<%--                                </a>--%>
<%--                                <a href="javascript:void(0);" class="iq-sub-card">--%>
<%--                                    <p>Notificacion random asew 1234</p>--%>
<%--                                    <small>hace zzz horas</small>--%>
<%--                                </a>--%>
                            </div>
                        </div>
                    </div>
                </li>


                <li class="nav-item dropdown user-dropdown">
                    <a href="javascript:void(0);" class="d-flex align-items-center dropdown-toggle" id="drop-down-arrow"
                       data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="data:image/jpeg;base64,${usuario.imagen}" class="img-fluid rounded-circle me-3"
                             alt="user" loading="lazy">
                        <div class="caption d-none d-lg-block">
                            <h6 class="mb-0 line-height text-light">${usuario.nombre}</h6>
                        </div>
                    </a>
                    <!-- menu usuario -->
                    <div class="sub-drop dropdown-menu caption-menu" aria-labelledby="drop-down-arrow">
                        <div class="card shadow-none m-0">
                            <div class="card-header ">
                                <div class="header-title">
                                    <h5 class="mb-0 ">Hola ${usuario.nombre}</h5>
                                </div>
                            </div>
                            <div class="card-body p-0 ">
                                <div class="d-flex align-items-center iq-sub-card border-0">
                              <span class="material-symbols-outlined">
                                 line_style
                              </span>
                                    <div class="ms-3">
                                        <a href="${pageContext.request.contextPath}/perfil/actividad/posts"
                                           class="mb-0 h6">
                                            Mi Perfil
                                        </a>
                                    </div>
                                </div>

                                <div class="d-flex align-items-center iq-sub-card border-0">
                              <span class="material-symbols-outlined">
                                 manage_accounts
                              </span>
                                    <div class="ms-3">
                                        <a href="#"
                                           class="mb-0 h6">
                                            Configuración de cuenta
                                        </a>
                                    </div>
                                </div>

                                <div class="d-flex align-items-center iq-sub-card">
                              <span class="material-symbols-outlined">
                                 login
                              </span>
                                    <div class="ms-3">
                                        <form action="${pageContext.request.contextPath}/cerrarSesion" method="POST">
                                            <button class="btn border-0 mb-0 h6">
                                                Cerrar Sesión
                                            </button>
                                        </form>
                                    </div>
                                </div>
                                <div class=" iq-sub-card">
                                    <h5>Configuración</h5>
                                </div>
                                <div class=" mb-3 iq-sub-card border-0" data-setting="radio">
                                    <div class="form-check mb-0 w-100">
                                        <input class="form-check-input custum-redio-btn" type="radio" value="light"
                                               name="theme_scheme" id="color-mode-light">
                                        <label class="form-check-label h6 d-flex align-items-center justify-content-between"
                                               for="color-mode-light">
                                            <span>Modo Claro</span>
                                            <div class="text-primary ">
                                                <svg width="60" height="27" viewBox="0 0 60 27" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <rect x="0.375" y="0.375" width="59.25" height="26.25" rx="4.125"
                                                          fill="white"/>
                                                    <circle cx="9.75" cy="9.75" r="3.75" fill="#80868B"/>
                                                    <rect x="16.5" y="8.25" width="37.5" height="3" rx="1.5"
                                                          fill="#DADCE0"/>
                                                    <rect x="6" y="18" width="48" height="3" rx="1.5"
                                                          fill="currentColor"/>
                                                    <rect x="0.375" y="0.375" width="59.25" height="26.25" rx="4.125"
                                                          stroke="#DADCE0" stroke-width="0.75"/>
                                                </svg>
                                            </div>
                                        </label>
                                    </div>
                                </div>
                                <div class=" mb-3 iq-sub-card border-0" data-setting="radio">
                                    <div class="form-check mb-0 w-100 ">
                                        <input class="form-check-input custum-redio-btn" type="radio" value="dark"
                                               name="theme_scheme" id="color-mode-dark" checked>
                                        <label class="form-check-label h6 d-flex align-items-center justify-content-between"
                                               for="color-mode-dark">
                                            <span>Modo Oscuro</span>
                                            <div class="text-primary ">
                                                <svg width="60" height="27" viewBox="0 0 60 27" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <rect x="0.375" y="0.375" width="59.25" height="26.25" rx="4.125"
                                                          fill="#1E2745"/>
                                                    <circle cx="9.75" cy="9.75" r="3.75" fill="#80868B"/>
                                                    <rect x="16.5" y="8.25" width="37.5" height="3" rx="1.5"
                                                          fill="#DADCE0"/>
                                                    <rect x="6" y="18" width="48" height="3" rx="1.5"
                                                          fill="currentColor"/>
                                                    <rect x="0.375" y="0.375" width="59.25" height="26.25" rx="4.125"
                                                          stroke="currentColor" stroke-width="0.75"/>
                                                </svg>
                                            </div>
                                        </label>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>



