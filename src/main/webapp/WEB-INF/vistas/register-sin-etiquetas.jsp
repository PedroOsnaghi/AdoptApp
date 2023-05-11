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
                        <p>Es muy simple y rapido! complet� estos pocos datos y forma parte de nuestra comunidad.
                        </p>
                        <form class="mt-4" action="registrarHandler" id="form" method="POST"
                              enctype="application/x-www-form-urlencoded">
                            <div class="form-group">
                                <label class="form-label" for="exampleInputEmail1">�C�mo te llamas?</label>
                                <input name="nombre" type="text" class="form-control mb-0" id="exampleInputEmail1"
                                            placeholder="Tu nombre completo"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="exampleInputEmail2">Correo electr�nico</label>
                                <input name="email" type="email" class="form-control mb-0" id="exampleInputEmail2"
                                            placeholder="Correo electr�nico"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="exampleInputPassword1">Contrase�a</label>
                                <input name="password" type="password" class="form-control mb-0" id="exampleInputPassword1"
                                            placeholder="Contrase�a"/>
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="exampleInputPassword1">Rep�te la contrase�a</label>
                                <input name="password2" type="password" class="form-control mb-0" id="exampleInputPassword2"
                                            placeholder="Rep�te la contrase�a"/>
                            </div>
                            <div class="d-inline-block w-100 mb-1">
<%--                                <div class="form-check d-inline-block mt-2 pt-1">--%>
<%--                                    <input name="terminosAceptados" type="checkbox" class="form-check-input"--%>
<%--                                           id="customCheck1">--%>
<%--                                    <label class="form-check-label" for="customCheck1">Acepto los <a--%>
<%--                                            href="#">Terminos y condiciones</a></label>--%>
<%--                                </div>--%>

                                <button type="submit"
                                        class="btn btn-primary float-end ">Registrarme
                                </button>

                            </div>
                            </form>

                            <!-- mensaje de error -->
                            <c:if test="${not empty error}">
                            <div class="mb-4">
                                <div class="alert alert-solid alert-danger alert-dismissible fade show d-flex align-items-center gap-2"
                                     role="alert">
                                    <span class="d-flex"><i class="material-symbols-outlined">error</i></span>
                                    <span> ${error}</span>
                                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                            aria-label="Close" control-id="ControlID-9"></button>
                                </div>
                            </div>
                            </c:if>
                            <hr>
                            <span class="dark-color d-inline-block line-height-2">Ya tenes una cuenta ? <a
                                    href="/login">Inicia sesi�n</a></span>


                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- scripts -->

<%@ include file="partials/script.jsp" %>