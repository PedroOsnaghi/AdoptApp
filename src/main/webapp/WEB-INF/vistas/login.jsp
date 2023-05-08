<!-- head -->

<%@ include file="partials/head.jsp" %>
<!-- loader inicial -->
<c:if test="${empty error}">
    <div id="firstload">
        <div id="loading-center">
        </div>
    </div>
</c:if>

    <div class="wrapper">
        <section class="sign-in-page">
            <div id="container-inside">
                <div id="circle-small"></div>
                <div id="circle-medium"></div>
                <div id="circle-large"></div>
                <div id="circle-xlarge"></div>
                <div id="circle-xxlarge"></div>
            </div>
            <div class="container p-0">
                <div class="row no-gutters">
                    <div class="col-md-6 text-center pt-5">
                        <div class="sign-in-detail text-white px-0">
                            <a class="sign-in-logo mb-5" href="#"><img src="images/brand/logo-full.png"
                                    class="img-fluid" alt="logo" loading="lazy"></a>
                            <div class="sign-slider overflow-hidden ">
                                <h3 class="text-white">Conectando personas con mascotas</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 bg-white pt-5 pt-5 pb-lg-0 pb-5">
                        <div class="sign-in-from">
                            <h1 class="mb-0">Iniciar Sesión</h1>
                            <p>Ingres&aacute; tu correo y contraseña para acceder a tu cuenta.</p>
                            <form:form class="mt-4" action="validar-login" method="POST" modelAttribute="datosLogin">
                                <div class="form-group">
                                    <label class="form-label" for="email">Correo electrónico</label>
                                    <form:input path="email" id="email" class="form-control mb-0"  placeholder="Correo electrónico"/>
                                </div>
                                <div class="form-group">
                                    <label class="form-label" for="password">Contraseña</label>
                                    <a href="#" class="float-end">Olvidaste tu contraseña?</a>
                                    <form:input path="password" type="password" class="form-control mb-0" id="password"
                                                placeholder="Contraseña"/>
                                </div>
                                <div class="d-inline-block w-100">
                                    <div class="form-check d-inline-block mt-2 pt-1">
                                        <input type="checkbox" class="form-check-input" id="customCheck11">
                                        <label class="form-check-label" for="customCheck11">Recordarme</label>
                                    </div>
                                    <button type="submit"
                                        class="btn btn-primary float-end ">Ingresar</button>

                                </div>
                                <div class="sign-info">
                                    <span class="dark-color d-inline-block line-height-2">Aún no tenes cuenta en
                                        AdoptApp? <a href="register.html">Registrarme</a></span>

                                </div>

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
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>


  <!-- scripts -->
  
  <%@ include file="partials/script.jsp" %>