<div class="card">
    <div class="card-header">
        <div class="header-title">
            <h4 class="card-title">Calificaciones</h4>
        </div>
    </div>
    <div class="card-body">

        <div class="mb-3">
            <c:if test="${not empty cal_publicador.calificacion}">
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <h6>Publicador</h6>
                    <small>${cal_publicador.calificacion}</small>
                </div>
                <div class="shadow-none progress w-100 mt-2" style="height: 6px; opacity: 1!important;">
                    <div class="progress-bar bg-primary" data-toggle="progress-bar"
                         role="progressbar" aria-valuenow="${cal_publicador.calToPercent}" aria-valuemin="0"
                         aria-valuemax="100"
                         style="width: 0%; transition: width 2s ease 0s;">
                    </div>
                </div>
            </c:if>
            <c:if test="${empty cal_publicador.calificacion}">
                <div class="d-flex flex-column mt-2 text-dark">
                    <h6>Publicador</h6>
                    <p class="text-center text-muted w-100">No tenes calificaciones como Publicador</p>
                </div>
            </c:if>

        </div>
        <c:if test="${not empty cal_adoptante.calificacion}">
            <div class="mb-3">
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <h6>Adoptante</h6>
                    <small>${cal_adoptante.calificacion}</small>
                </div>
                <div class="shadow-none progress  w-100 mt-2" style="height: 6px;opacity: 1!important;">
                    <div class="progress-bar bg-success" data-toggle="progress-bar"
                         role="progressbar" aria-valuenow="${cal_adoptante.calToPercent}" aria-valuemin="0"
                         aria-valuemax="100"
                         style="width: 0%; transition: width 2s ease 0s;">
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${empty cal_adoptante.calificacion}">
            <div class="d-flex flex-column mt-2 text-dark">
                <h6>Adoptante</h6>
                <p class="text-center text-muted w-100">No tenes calificaciones como Adoptante</p>
            </div>
        </c:if>

    </div>
</div>