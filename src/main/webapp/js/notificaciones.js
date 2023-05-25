function showNotification(message, type){
    let bg_color;


    if(type == "success"){
        bg_color = '#2dcdb2';
    }else{
        bg_color = '#d03352';
    }

    console.log("notificacion");

    Toastify({
        text: message,
        duration: 3000,
        destination: "",
        newWindow: true,
        close: false,
        gravity: "top", // `top` or `bottom`
        position: "center", // `left`, `center` or `right`
        stopOnFocus: true, // Prevents dismissing of toast on hover
        offset: {
            y: '60px' // vertical axis - can be a number or a string indicating unity. eg: '2em'
        },
        style: {
            background: bg_color

        },


        onClick: function(){} // Callback after click
    }).showToast();
}
