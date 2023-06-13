function confirm(link){

		Swal.fire({
				title: "Estas seguro/a?",
				html: '<p>Los Datos se eliminaán de forma permanente y no podrás recuperarlos.</p>',
				icon: "warning",
				showCancelButton: true,
				cancelButtonText: "Cancelar",
				confirmButtonText: "Si, quiero eliminar!",
				customClass: {
					title: 'h4',
					confirmButton: 'btn btn-primary me-2',
					cancelButton: 'btn btn-secondary',
				},
				buttonsStyling: false
			}).then((result) => {
			if (result.isConfirmed) {
				window.location.href = link.getAttribute('action');
			}
		});





}







