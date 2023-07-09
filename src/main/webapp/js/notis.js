const notificationContainer = document.getElementById('notification-container');
const notificationCounter = document.getElementById('notification-counter');

function addNotification(notification) {
    const newAnchor = document.createElement('a');
    newAnchor.className = "iq-sub-card notification-anchor";
    newAnchor.href = `${notification.url}?notiId=${notification.id}`;

    const newText = document.createElement('p');
    newText.innerText = notification.mensaje;

    const newSmall = document.createElement('small');
    newSmall.innerText = "Hace XXX minutos";

    newAnchor.dataset.notificationId = notification.id;

    newAnchor.appendChild(newText);
    newAnchor.appendChild(newSmall);

    notificationContainer.appendChild(newAnchor);
}


function setNotifications() {
    fetch(`http://localhost:8080/proyecto_limpio_spring_war/notificacion/`)
        .then((res) => res.json())
        .then((data) => {
            const notifications = data;
            const currentNotifications = Array.from(document.querySelectorAll('.notification-anchor'));

            console.log(notifications);

            notifications.forEach((notification) => {
                if (!currentNotifications.some((currentNotification) => {
                    console.log(currentNotification)
                    return currentNotification.dataset.notificationId == notification.id;
                })) {
                    addNotification(notification);
                }
            })

            notificationCounter.innerText = notifications.length;
        });
}

setNotifications();
setInterval(setNotifications, 5000);