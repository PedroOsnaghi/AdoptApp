function confirm(e){
	e.preventDefault();
	console.log("entro");
	const link = e.target;
	//Warning Message

		swal({
				title: "Estas seguro?",
				text: "Los datos se eliminarán de forma permanente",
				type: "warning",
				showCancelButton: true,
				cancelButtonText: "Cancelar",
				confirmButtonText: "Si, quiero eliminar!",
				closeOnConfirm: true,
				customClass: {
					confirmButton: 'btn btn-primary',
					cancelButton: 'btn btn-secondary',
				},
				buttonsStyling: false
			},
			function(){

				window.location.href(link.getAttribute('action'));

			});





}







