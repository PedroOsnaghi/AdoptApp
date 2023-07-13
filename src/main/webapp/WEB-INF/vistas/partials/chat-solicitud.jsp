



<div class="modal fade " id="chat-solicitud" tabindex="-1" role="dialog" aria-labelledby="chat-solicitud"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <div class="chat-head w-100">
                    <div class="d-flex justify-content-between align-items-center  ps-3 pe-3">
                        <c:choose>
                            <c:when test="${usuario.id eq solicitud.usuario.id}">
                                <div class="d-flex align-items-center">
                                    <div class="avatar chat-user-profile m-0 me-3">
                                        <img src="data:image/jpeg;base64,${solicitud.publicacion.mascota.usuario.imagen}"   class="avatar-40"   loading="lazy">
                                        <div class="iq-profile-badge  bg-danger"></div>
                                    </div>
                                    <h5 class="mb-0">${solicitud.publicacion.mascota.usuario.nombre}</h5>
                                    <small class="text-capitalize"></small>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="d-flex align-items-center">
                                    <div class="avatar chat-user-profile m-0 me-3">
                                        <img src="data:image/jpeg;base64,${solicitud.usuario.imagen}"   class="avatar-40"   loading="lazy">
                                        <div class="iq-profile-badge  bg-danger"></div>
                                    </div>
                                    <h5 class="mb-0">${solicitud.usuario.nombre}</h5>
                                    <small class="text-capitalize"></small>
                                </div>
                            </c:otherwise>
                        </c:choose>






                        <div class="chat-header-icons d-inline-flex align-items-center ms-auto">
                            <button type="button" class="btn bg-white me-3" id="btn-refresh">
                                <i class="fa-solid fa-arrows-rotate"></i>
                            </button>
                            <button type="button" class="btn-close bg-white" data-bs-dismiss="modal" aria-label="Close">

                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-body bg-body">

                <div id="chat-container" style="min-height: 500px">

                    <%@ include file="chat-list.jsp" %>


                </div>




            </div>
            <div class="modal-footer">
                <div class="d-flex w-100">


                        <input type="text" id="input-message" class="form-control me-3" placeholder="Escribe un mensaje" autofocus
                               >
                        <button type="button" id="btn-submit-chat" class="btn btn-primary d-flex align-items-center" disabled solicitud-code="${solicitud.codigo}" path="${pageContext.request.contextPath}"
                                >
                            <svg class="icon-20" width="18" viewBox="0 0 20 21" fill="none"
                                 xmlns="http://www.w3.org/2000/svg">
                                <path d="M13.8325 6.67463L8.10904 12.4592L1.59944 8.38767C0.66675 7.80414 0.860765 6.38744 1.91572 6.07893L17.3712 1.55277C18.3373 1.26963 19.2326 2.17283 18.9456 3.142L14.3731 18.5868C14.0598 19.6432 12.6512 19.832 12.0732 18.8953L8.10601 12.4602"
                                      stroke="currentcolor" stroke-width="2" stroke-linecap="round"
                                      stroke-linejoin="round"></path>
                            </svg>
                            <span class="d-none d-lg-block ms-1">Enviar</span>
                        </button>

                </div>

            </div>
        </div>
    </div>
</div>