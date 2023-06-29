<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card">
  <div class="card-body p-0">
    <div class="user-tabing">
      <ul
              class="nav nav-pills d-flex align-items-center justify-content-center profile-feed-items p-0 m-0 rounded">
        <li class="nav-item col-12 col-sm-3 p-0">
          <a class="nav-link <c:if test="${target eq 'actividad'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/actividad/posts" >Actividad</a>
        </li>
        <li class="nav-item col-12 col-sm-3 p-0">
          <a class="nav-link <c:if test="${target eq 'info'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/info">Informacion</a>
        </li>
        <li class="nav-item col-12 col-sm-3 p-0">
          <a class="nav-link <c:if test="${target eq 'solicitud'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/solicitud">Solicitudes recibidas</a>
        </li>
        <li class="nav-item col-12 col-sm-3 p-0">
          <a class="nav-link <c:if test="${target eq 'mensajes'}">active</c:if>" href="${pageContext.request.contextPath}/perfil/mensajes">Preguntas</a>
        </li>
      </ul>
    </div>
  </div>
</div>


