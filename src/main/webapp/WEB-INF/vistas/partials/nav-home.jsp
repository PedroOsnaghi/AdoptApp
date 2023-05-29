<div class="card-header d-flex justify-content-start">
    <div class="user-img me-3">
        <img src="${pageContext.request.contextPath}/images/user/${usuario.imagen}" alt="userimg" class="avatar-60 rounded-circle"
             loading="lazy">
    </div>
    <div class="header-title">
        <h4 class="card-title">Hola ${usuario.nombre}</h4>
    </div>
</div>

<div class="card-body">
    <ul class="nav nav-pills d-flex align-items-center justify-content-center profile-feed-items p-0 m-0 rounded"
        role="tablist">
        <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
            <a class="nav-link <c:if test="${target eq 'feed'}">active</c:if>" href="${pageContext.request.contextPath}/home/feed" >Feed</a>
        </li>
        <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
            <a class="nav-link <c:if test="${target eq 'favoritos'}">active</c:if>" href="${pageContext.request.contextPath}/home/favoritos" >Favoritos</a>
        </li>
        <li class="nav-item col-12 col-sm-3 p-0" role="presentation">
            <a class="nav-link <c:if test="${target eq 'mispublicaciones'}">active</c:if>" href="${pageContext.request.contextPath}/home/mispublicaciones" >Mis
                Publicaciones</a>
        </li>

    </ul>

</div>