<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="">
  <c:if test="${not empty result}">
    <h4 class="px-3 py-2 border-bottom">Resultados</h4>
    <c:forEach items="${result}" var="res">
      <a href="<c:if test="${res.tipo eq 'USUARIO'}">
                  ${pageContext.request.contextPath}/perfil/usuario?uid=${res.idResultado}
                </c:if>
                <c:if test="${res.tipo eq 'PUBLICACION'}">
                  ${pageContext.request.contextPath}/publicacion/ver?pid=${res.idResultado}
                </c:if>">
        <div class="d-flex align-items-center border-bottom search-hover py-2 px-3">

          <div class="flex-shrink-0">
            <img src="data:image/jpg;base64,${res.imagen}"
                 class="align-self-center img-fluid avatar-50 rounded-pill" alt="#">
          </div>
          <div class="d-flex flex-column ms-3 w-100">
            <h5>${res.nombre}</h5>
            <span>${res.descripcion}</span>
          </div>
          <div class="d-flex align-items-center ms-auto">
        <span class="me-3 d-flex align-items-center">
          <small>${res.tipo.toString()}</small>
        </span>

          </div>
        </div>
      </a>
    </c:forEach>


  </c:if>

  <c:if test="${empty result}">
    <h4 class="px-3 py-2 border-bottom">Resultados</h4>

    <div class="text-center mt-3">
      <c:if test="${search_text.length() eq 0 || empty search_text}">
        <h5 class="text-center text-muted">Encuentra Mascotas y Personas</h5>
      </c:if>
      <c:if test="${search_text.length() > 0}">
        <p class="text-center text-muted">No hay resultados para "${search_text}"</p>
      </c:if>

      <img class="mb-3" src="${pageContext.request.contextPath}/images/page-img/search-icon.png" style="
    max-width: 100px;
    margin: 0px auto;
    opacity: .2;">
    </div>

  </c:if>


</div>