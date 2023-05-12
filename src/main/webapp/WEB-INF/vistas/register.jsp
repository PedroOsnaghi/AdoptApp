<!-- head -->

<%@ include file="partials/head.jsp" %>

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
                        <a class="sign-in-logo mb-5" href="#"><img src="${pageContext.request.contextPath}/images/brand/logo-full.png"
                                                                   class="img-fluid" alt="logo" loading="lazy"></a>
                        <div class="sign-slider overflow-hidden ">
                            <h3 class="text-white">Conectando personas con mascotas</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 bg-white pt-5 pt-5 pb-lg-0 pb-5">
                    <div class="sign-in-from">
                        <h2 class="mb-3">Que gusto nos da!!!</h2>
                        <h4>Ahora vamos a crear tu cuenta..</h4>
                        <p>Es muy simple y rapido! completá estos pocos datos y forma parte de nuestra comunidad.
                        </p>
                        <form:form class="mt-4" action="registrarHandler" id="form" method="POST" modelAttribute="registrarDto"
                                   enctype="application/x-www-form-urlencoded">
                            <div class="form-group">
                                <label class="form-label" for="nombre">¿Cómo te llamas?</label>
                                <form:input path="nombre" type="text" class="form-control mb-0" id="nombre"
                                            placeholder="Tu nombre completo" required="true"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="correo">Correo electrónico</label>
                                <form:input path="email" type="email" class="form-control mb-0" id="correo"
                                            placeholder="Correo electrónico" required="true"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="pass">Contraseña</label>
                                <form:input path="password" type="password" class="form-control mb-0" id="pass"
                                            placeholder="Contraseña" required="true"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="pass-rpt">Repite la contraseña</label>
                                <form:input path="password2" type="password" class="form-control mb-0" id="pass-rpt"
                                            placeholder="Repite la contraseña" required="true"/>
                            </div>
                            <div class="d-inline-block w-100 mb-1">
                                <div class="form-check d-inline-block mt-2 pt-1">
                                    <input type="checkbox" class="form-check-input" id="customCheck1"/>
                                    <label class="form-check-label" for="customCheck1">Acepto los <a
                                            href="#">Terminos y condiciones</a></label>
                                </div>

                                <button type="submit"
                                        class="btn btn-primary float-end ">Registrarme
                                </button>

                            </div>
                        </form:form>

                        <!-- mensaje de error -->
                        <c:if test="${not empty error}">
                            <div class="mb-4">
                                <div class="alert alert-solid alert-danger alert-dismissible fade show d-flex align-items-center gap-2"
                                     role="alert">
                                    <span class="d-flex"><i class="material-symbols-outlined">error</i></span>
                                    <span>${error}</span>
                                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                            aria-label="Close" control-id="ControlID-9"></button>
                                </div>
                            </div>
                        </c:if>
                        <hr>
                        <span class="dark-color d-inline-block line-height-2">Ya tenes una cuenta ? <a
                                href="/login">Inicia sesión</a></span>


                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>