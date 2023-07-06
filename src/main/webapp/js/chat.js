const btn_refresh = document.getElementById("btn-refresh");
const input_message = document.getElementById("input-message");
const btn_submit = document.getElementById("btn-submit-chat");
const chat_container = document.getElementById("chat-container");

var status_id;


btn_refresh.addEventListener("click", function (){
    actualizarMensajes(btn_submit.getAttribute("path"), btn_submit.getAttribute("solicitud-code"));
    input_message.value = "";

    btn_submit.setAttribute("disabled", "true");

    input_message.focus();
});

btn_submit.addEventListener("click", function (){
    status_id = new Date().getMilliseconds();

    chat_container.insertAdjacentHTML( "beforeend",'<div class="iq-message-body iq-current-user">\n' +
        '                                    <div class="iq-chat-text">\n' +
        '                                        <div class="d-flex align-items-center justify-content-end">\n' +
        '                                            <div class="iq-chating-content d-flex align-items-center ">\n' +
        '                                                <p class="mr-2 mb-0"> ' + input_message.value + ' </p>\n' +
        '                                            </div>\n' +
        '                                        </div>\n' +
        '                                        <small class="iq-chating p-0 mb-0 chat-time" id="'+ status_id +'" style="\n' +
        '    display: flex;">enviando..</small>\n' +
        '                                    </div>\n' +
        '                                </div>');


    enviarMensaje(this.getAttribute("path"), this.getAttribute("solicitud-code"), input_message.value, status_id);

    input_message.value = "";

    btn_submit.setAttribute("disabled", "true");

    input_message.focus();
});

input_message.addEventListener("keyup", function (){
    if (input_message.value === ""){
        btn_submit.setAttribute("disabled", "true");
    }else{
        btn_submit.removeAttribute("disabled");
    }

});




function enviarMensaje(path, codigo, mensaje, statusId){

    $.ajax({
        url: path + "/chat/enviarmensaje?code=" + codigo + "&message=" + mensaje,
        type: "GET",
        success: function (response){
            console.log(response);

            document.getElementById(statusId).innerHTML = getChatTime(response);

        }

    });

}

function actualizarMensajes(path, codigo){

    $.ajax({
        url: path + "/chat/refresh?code=" + codigo,
        type: "GET",
        dataType: "html",
        success: function (response){
            console.log(response);

            chat_container.innerHTML = response;

            formatearFechas();

        },
        error: function (error){
            console.log(error);
        }

    });

}

function formatearFechas(){
    document.querySelectorAll(".chat-time").forEach(function (element){
        element.innerHTML = getChatTime(element.getAttribute("time"));
    });

}