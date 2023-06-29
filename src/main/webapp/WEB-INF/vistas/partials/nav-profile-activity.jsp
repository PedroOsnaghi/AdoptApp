<div class="card">
    <div class="card-body">
        <ul class="nav nav-pills basic-info-items list-inline d-block p-0 m-0">
            <li>
                <a class="nav-link <c:if test="${seccion eq 'posts'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/actividad/posts">Mis Publicaciones</a>
            </li>
            <li>
                <a class="nav-link <c:if test="${seccion eq 'favoritos'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/actividad/favoritos">Favoritos</a>
            </li>
            <li>
                <a class="nav-link <c:if test="${seccion eq 'solicitudes'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/actividad/solicitudes">Solicitudes Enviadas</a>
            </li>
            <li>
                <a class="nav-link <c:if test="${seccion eq 'mascotas'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/actividad/mismascotas">Mis mascotas</a>
            </li>

        </ul>
    </div>
</div>