const notificationContainer = document.getElementById('notification-container');
const notificationCounter = document.getElementById('notification-counter');
const news_span = document.getElementById('new-notifications');

document.getElementById('notification-drop').addEventListener('click', function (){
    setNotifications();
    setRead();
    news_span.classList.add('d-none');
});

function addNotification(notification) {
    var read_style = (notification.leido === false) ? 'style= "background-color:#d4ebff"': '';
    notificationContainer.insertAdjacentHTML( "afterbegin",  '<a class="iq-sub-card notification-anchor notification-item" ' + read_style + ' href="javascript:void(0);" data-notification-id="' + notification.id + '"><p class="fw-bold mb-1">' + notification.titulo + '</p><p class="mb-0">' + notification.mensaje + '</p><small class="text-muted">' + getTimeNotification(notification.fechaCreacion) + '</small></a>');

}

function getTimeNotification(fecha_desde)
{

    console.log(fecha_desde);

    var fecha1 = moment(new Date(fecha_desde), "YYYY-MM-DD HH:mm:ss");
    var fecha2 = moment(new Date(), "YYYY-MM-DD HH:mm:ss");

    var diff = fecha2.diff(fecha1, 'm');

    console.log(fecha1);
    console.log(fecha2);
    console.log(diff);


    if(diff < 1){
        return "Justo ahora";
    }else if(diff >= 1 && diff < 60){
       return "hace " + diff + " minutos";
    }else if(diff >= 60 && diff < 1440){
        diff = fecha2.diff(fecha1, 'h'); // Diff in hours
        return "hace " + diff + " horas";
    }else{
        diff = fecha2.diff(fecha1, 'd'); // Diff in hours
        return "hace " + diff + " dias";
    }





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

            console.log(res)

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

function setRead() {
    $.ajax({
        url: 'http://localhost:8080/proyecto_limpio_spring_war/notificacion/read',
        type: 'GET',
        success: function (res){

            console.log(res)


        }
    });

}

function scan() {
    $.ajax({
        url: 'http://localhost:8080/proyecto_limpio_spring_war/notificacion/scan',
        type: 'GET',
        success: function (res){

            console.log(res)
            news_span.innerHTML = res;
            if(res > 0) news_span.classList.remove('d-none');

        }
    });

}

scan();
setInterval(scan, 5000);


