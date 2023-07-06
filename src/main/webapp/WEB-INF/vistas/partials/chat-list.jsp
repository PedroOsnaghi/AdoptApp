<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${mensajes_chat}" var="mensaje">

  <c:choose>
    <c:when test="${mensaje.usuario.id eq usuario.id}">
      <div class="iq-message-body iq-current-user">
        <div class="iq-chat-text">
          <div class="d-flex align-items-center justify-content-end">
            <div class="iq-chating-content d-flex align-items-center ">
              <p class="mr-2 mb-0">${mensaje.contenido}</p>
            </div>
          </div>
          <small class="iq-chating p-0 mb-0 chat-time" style="display: flex;" time="${mensaje.create_at}"><script>getChatTimeDom('${mensaje.create_at}')</script></small>
        </div>
      </div>
    </c:when>
    <c:otherwise>
      <div class="iq-message-body iq-other-user" style="color: #5a5a5a;">
        <div class="iq-chat-text">
          <div class="d-flex align-items-center justify-content-start">
            <div class="iq-chating-content d-flex align-items-center ">
              <p class="mr-2 mb-0">${mensaje.contenido}</p>
            </div>
          </div>
          <small class="iq-chating p-0 mb-0 d-block chat-time " style="display: flex;" time="${mensaje.create_at}" ><script>getChatTimeDom('${mensaje.create_at}')</script></small>
        </div>
      </div>
    </c:otherwise>
  </c:choose>






</c:forEach>