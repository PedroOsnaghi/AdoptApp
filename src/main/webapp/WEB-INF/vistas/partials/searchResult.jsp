<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="">
  <c:if test="${not empty result}">
    <h4 class="px-3 py-2">Resultados</h4>
    <c:forEach items="${result}" var="res">
      <a href="">
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
    <p class="text-center text-muted">No se encontraron resultados.</p>
  </c:if>


</div>