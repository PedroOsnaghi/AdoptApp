const m1 = document.getElementById("motivo-1");
const m2 = document.getElementById("motivo-2");
const ckm = document.getElementById("check-other");
const txtm = document.getElementById("txt-motivo");
const btn = document.getElementById("btn-submit");

$( "#btn-submit" ).on( "click", function( event ) {
    Swal.fire({
        title: "Confirmar",
        html: '<p>Se cancelará el proceso de Adopcíon. ¿Deseas continuar?</p>',
        icon: "warning",
        showCancelButton: true,
        cancelButtonText: "Cancelar",
        confirmButtonText: "Si, Deseo cancelar la Adopción!",
        customClass: {
            title: 'h4',
            confirmButton: 'btn btn-primary me-2',
            cancelButton: 'btn btn-secondary',
        },
        buttonsStyling: false
    }).then((result) => {
        if (result.isConfirmed) {
            $("#form-cancel-adoptante").submit();
        }
    });
});


ckm.addEventListener("change", function (){
    if(this.checked === true){
        m1.checked = false;
        m1.setAttribute("disabled", "true");
        m2.checked = false;
        m2.setAttribute("disabled", "true");
        txtm.removeAttribute("disabled");
        txtm.setAttribute("required","true");
        btn.setAttribute("disabled", "true");
    }else{
        m1.checked = true;
        m1.removeAttribute("disabled");
        m2.removeAttribute("disabled");
        txtm.value = "";
        txtm.setAttribute("disabled", "true");
        txtm.removeAttribute("required");
        btn.removeAttribute("disabled");
    }
});

txtm.addEventListener("keyup",function (){
    if(txtm.value===""){
        btn.setAttribute("disabled", "true");
    }else{
        btn.removeAttribute("disabled");
    }
});