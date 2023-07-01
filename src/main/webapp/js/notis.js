const notificationContainer = document.getElementById('notification-container');
let currentIndex = 0;

console.log(notificationContainer);

fetch(`http://localhost:8080/proyecto_limpio_spring_war/notificacion/?id=1`)
    .then((res) => res.json())
    .then((data) => {
        const notifications = data;

        const interval = setInterval(() => {
            if (currentIndex >= notifications.length || notificationContainer === null) {
                clearInterval(interval);
                return;
            }
            addNotification(notifications[currentIndex]);
            currentIndex++;
        }, 5000)
    });

function addNotification(notification) {
    const newAnchor = document.createElement('a');
    newAnchor.className = "iq-sub-card";
    newAnchor.href = notification.url;

    const newText = document.createElement('p');
    newText.innerText = notification.mensaje;

    const newSmall = document.createElement('small');
    newSmall.innerText = "Hace XXX minutos";

    newAnchor.appendChild(newText);
    newAnchor.appendChild(newSmall);

    notificationContainer.appendChild(newAnchor);
}

