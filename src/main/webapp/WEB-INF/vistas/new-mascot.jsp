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
            <div class="col-lg-12">

                <div class="card card-block card-stretch card-height">
                    <div class="card-header d-flex justify-content-start">
                        <div class="header-title">
                            <h4 class="card-title">Nueva Mascota</h4>
                            <p class="link-primary mb-3">Aquí puedes registrar una nueva Mascota en tu lista.</p>
                        </div>
                    </div>
                    <div class="card-body">
                        <form:form class="row" action="guardar" method="POST"
                                   modelAttribute="mascotaDto" enctype="multipart/form-data">

                            <div class="row align-items-center mb-3">
                                <div class="col-3 ">
                                    <div class="profile-img ms-2">


                                        <img class="avatar-130 img-fluid"
                                             src="data:image/jpg;base64,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AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wD/AP8A/wCP+P8A/wD/AP8A/wD/AP8A9z9Y/wD/AP8A/wD/AP8A/n//AP8A/wD/AP8A/wD/AP8A9/uf/wD/AP8A/wD/AP8A/wD/AP8A/v8A/wD/AP8A/wD/APv+7/f/AP8A/wD/AP8A/wD/AP7/AL//AP8A/wD/AP8A/v8A9/3/AP8A/wD/AP8A/wD3/v8A7/8A/wD/AP8A/wD/AP8A/f8Af/8A/wD/AP8A/wD+/wB/++//AP8A/wD/AMb3+z/cz/8A/wD/AP75/wD9/wCfv/8A/wD/AO/+fe/7/wD/AP8A/wD/AP8Aua/5/wD/AP8A/wD/AP8A/vP+/f8A/wD/AP8A/wDf+/8A/wD/APn/AP8A/wD+/wD/AP8A/wD/AN//AP8A/wD3/wD8l/8A/v8A/wD/AP8Av/fP8/8A/wD/AP8A/wD/AP8Au/8A7v8A/wD/AP8A/wDz/d//AP8A+/8A/wD/AP8A7/v/AP2/v/8A/wD/AP8A/d//AO3z/wD/AP8A/wD87Pgn1j//AP8A/wD/AP8A33Pf/wD/AP8A/wD/AP8A/wD/AP77/wD/AP8A/wD/AP8A5/8A/wDf/wD/AP8A/wD/AP5+/wD/AH//AP8A/wD/AP8A5/f9/f8A/wD/AP8A/wD/AP8A/wC/7/8A/wD/AP8A/wDz/n3/AJ//AP8A/wD/AP8A/wD6/wD+/wD/AP8A/wD/AP3/APn/AP8A/wD/AP8A/wD/AN//AP8A/wC//wD/AP8A/wD/AH//AP8A/wD/AP8A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"
                                             id="preview" alt="">
                                        <div class="material-symbols-outlined btn btn-primary btn-profile">
                                            photo_camera
                                            <form:input path="imagen" name="archivoImagen" id="file" type="file"
                                                   class="form-control opacity-0"/>

                                        </div>
                                    </div>

                                </div>

                                <div class="col-9 position-relative">
                                    <label for="nombre" class="form-label"><strong>Cómo se llama la mascota
                                        ?</strong></label>
                                    <form:input path="nombre" type="text" class="form-control" id="nombre" required=""
                                                placeholder="Escribe el nombre..." control-id="ControlID-24"/>
                                    <div class="invalid-tooltip">
                                        Debes poner un nombre.
                                    </div>
                                </div>

                            </div>

                            <h5>Ficha de Mascota</h5>
                            <hr class="mt-0">

                            <div class="row ">
                                <div class="col-md-6 position-relative">
                                    <label for="tipo" class="form-label"><strong>Qué tipo de mascota
                                        es?</strong></label>
                                    <form:select path="tipo" class="form-select" id="tipo" required="true">
                                        <option selected="" disabled="" value="null">Selecciona un Tipo</option>
                                        <option value="perro">PERRO</option>
                                        <option value="gato">GATO</option>
                                    </form:select>
                                </div>

                                <div class="col-md-6 position-relative">
                                    <label for="genero" class="form-label"><strong>Género</strong></label>
                                    <form:select path="genero" class="form-select" id="genero">
                                        <option selected="" disabled="" value="">Selecciona un Género</option>
                                        <option value="hembra">HEMBRA</option>
                                        <option value="macho">MACHO</option>
                                    </form:select>

                                </div>

                                <div class="col-md-6 position-relative">
                                    <label for="raza" class="form-label"><strong>Raza</strong></label>
                                    <form:input path="raza" type="text" class="form-control" id="raza" required=""
                                                placeholder="Escribe la raza" control-id="ControlID-24"/>
                                    <div class="invalid-tooltip">
                                        Escribe una Raza.
                                    </div>
                                </div>

                                <div class="col-md-6 position-relative">
                                    <label class="form-label" for="peso"><strong>Cuánto pesa en
                                        Kg?</strong>
                                        (aporx.)</label>
                                    <form:input path="peso" type="number" class="form-control" id="peso"
                                                value="0.5"
                                                step="0.500" control-id="ControlID-13"/>
                                </div>

                                <div class="col-md-6 position-relative">
                                    <label class="form-label" for="nacimiento"><strong>Cuándo nació?</strong> (si
                                        no sabes dejalo
                                        vacio)</label>
                                <form:input path="nacimiento" type="date" class="form-control" id="nacimiento"
                                           />
                                </div>
                                <div class="col-md-6 position-relative">
                                    <label for="pers" class="form-label"><strong>Describe su
                                        personalidad</strong></label>
                                    <form:select path="personalidad" class="form-select" id="pers">
                                        <option selected="" disabled="" value="">Selecciona una</option>
                                        <option value="Cariñoso/a">Cariñoso/a</option>
                                        <option value="Amoroso/a">Amoroso/a</option>
                                        <option value="Travieso/a">Travieso/a</option>
                                        <option value="Dormilon/a">Dormilon/a</option>
                                        <option value="Jugueton/a">Jugueton/a</option>
                                        <option value="Momoso/a">Momoso/a</option>
                                    </form:select>

                                </div>
                                <div class="col-md-12 position-relative">
                                    <label for="obs" class="form-label"><strong>Cuál es su estado de
                                        salud?</strong> (50 caracteres)</label>
                                    <form:input path="salud" type="text" class="form-control" id="obs" required=""
                                                maxlength="50" control-id="ControlID-27"/>
                                    <div class="invalid-tooltip">
                                        Debes completar su estado de salud.
                                    </div>
                                </div>
                            </div>

                            <c:if test="${not empty error}">

                                <div class=" col-md-12 position-relative mt-2 mb-2">
                                    <div class="alert alert-solid alert-danger alert-dismissible fade show d-flex align-items-center gap-2"
                                         role="alert">
                                        <span class="d-flex"><i class="material-symbols-outlined">error</i></span>
                                        <span>${error}</span>
                                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert"
                                                aria-label="Close" ></button>
                                    </div>
                                </div>
                             
                            </c:if>


                            <div class="col-12 text-center mt-3">
                                <c:if test="${target eq 'publicacion'}">
                                    <a href="${pageContext.request.contextPath}/publicacion/crear" class="btn btn-secondary">Cancelar</a>
                                </c:if>
                                <c:if test="${target eq 'perfil'}">
                                    <a href="${pageContext.request.contextPath}/perfil/actividad/mismascotas" class="btn btn-secondary">Cancelar</a>
                                </c:if>

                                <button class="btn btn-primary" type="submit" >Guardar</button>
                            </div>
                        </form:form>

                    </div>


                </div>

            </div>

        </div>
    </div>
</div>



<!-- footer -->

<%@ include file="partials/footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/preview.js" type="text/javascript"></script>
<%@ include file="partials/script.jsp" %>

