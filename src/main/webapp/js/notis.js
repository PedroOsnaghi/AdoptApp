const notificationContainer = document.getElementById('notification-container');
const notificationCounter = document.getElementById('notification-counter');

function addNotification(notification) {
    notificationContainer.insertAdjacentHTML( "beforeend",  '<a class="iq-sub-card notification-anchor notification-item" href="javascript:void(0);" data-notification-id="' + notification.id + '"><p class="fw-bold mb-1">' + notification.titulo + '</p><p class="mb-0">' + notification.mensaje + '</p><small class="text-muted"><script>getTime("' + notification.fechaCreacion + '")</script></small></a>');

}

function addEvent(){
    document.querySelectorAll(".notification-item").forEach(function (element){
       element.addEventListener('click', function (){
          $.ajax({
              url: 'http://localhost:8080/proyecto_limpio_spring_war/notificacion/get?idn=' + element.getAttribute('data-notification-id') ,
              type: 'GET',
              success: function (resp){
                console.log(resp);
                  window.location.replace(resp);
              }
          });
       });
    });
}


function setNotifications() {
    $.ajax({
        url: 'http://localhost:8080/proyecto_limpio_spring_war/notificacion/list',
        type: 'GET',
        success: function (res){
            console.log(res);
            notificationContainer.innerHTML="";

            res.forEach((notification) => {

                addNotification(notification);

            })

            addEvent();

            notificationCounter.innerText = res.length;
        }
    });
    /*fetch(`http://localhost:8080/proyecto_limpio_spring_war/notificacion/list`)
        .then((res) => res.json())
        .then((data) => {

            const notifications = data;
            const currentNotifications = Array.from(document.querySelectorAll('.notification-anchor'));

            console.log(notifications);

            notificationContainer.innerHTML="";

            notifications.forEach((notification) => {

                    addNotification(notification);

            })

            addEvent();

            notificationCounter.innerText = notifications.length;


        });
*/
}

setNotifications();
