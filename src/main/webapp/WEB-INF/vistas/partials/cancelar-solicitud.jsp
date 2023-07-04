<div class="modal fade" id="cancelar-solicitud" tabindex="-1" role="dialog" aria-labelledby="cancelar-solicitud"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">

                </button>
                <h4 class="modal-title" id="exampleModalScrollableTitle">Informar Motivo de Cancelación</h4>
                <p>Cuentanos cuál es el motivo por el que deseas cancelar la solicitud.</p>

            </div>
            <div class="modal-body">
                <form:form action="${pageContext.request.contextPath}/solicitud/cancelacion-adoptante?target=${target}" method="post" id="form-cancel-adoptante"
                           modelAttribute="solicitudDto">
                    <form:input path="codigo" type="hidden" value="${solicitud.codigo}"/>

                    <div>
                        <div class="form-check d-block">
                            <form:radiobutton path="motivo_cancelacion" class="form-check-input"   id="motivo-1" value="Que tuvo un problema y no podrá adoptar" checked="true" />
                            <label class="form-check-label" for="motivo-1">
                                Tengo un problema y no podré adoptar.
                            </label>
                        </div>
                        <div class="form-check d-block mt-3">
                            <form:radiobutton path="motivo_cancelacion" class="form-check-input"  id="motivo-2" value="Que se arrepintió y ya no desea adoptar" />
                            <label class="form-check-label" for="motivo-2">
                                Me arrepentí y ya no deseo Adoptar.
                            </label>
                        </div>


                    </div>




                    <div class="form-group mt-3">
                        <div class="form-check d-block">
                            <input class="form-check-input" type="checkbox" value="" id="check-other" >
                            <label class="form-check-label" for="check-other">
                                Informar otro motivo..
                            </label>
                        </div>
                        <form:textarea path="motivo_cancelacion" class="form-control"  rows="4" maxlength="255"
                                       placeholder="Describe el motivo.." id="txt-motivo" disabled="true"
                        ></form:textarea>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="button" class="btn btn-secondary me-2" data-bs-dismiss="modal">Cerrar</button>
                        <button type="button" id="btn-submit" class="btn btn-primary">Continuar con la Cancelacón</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
