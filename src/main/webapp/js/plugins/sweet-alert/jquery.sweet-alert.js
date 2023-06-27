function confirmDelete(link){

		Swal.fire({
				title: "Confirmar",
				html: '<p>Los Datos se eliminán de forma permanente y no podrás recuperarlos.</p>',
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

function confirmCancel(link){

	Swal.fire({
		title: "Confirmar",
		html: '<p>¿Deseas Cancelar la Solicitud?</p>',
		icon: "warning",
		showCancelButton: true,
		cancelButtonText: "Cancelar",
		confirmButtonText: "Si, Deseo cancelarla!",
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


function confirmRechazar(link){

	Swal.fire({
		title: "Confirmar",
		html: '<p>¿Deseas Rechazar la Solicitud?</p>',
		icon: "warning",
		showCancelButton: true,
		cancelButtonText: "Cancelar",
		confirmButtonText: "Si, Deseo rechazarla!",
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

function confirmAceptar(link){

	Swal.fire({
		title: "Confirmar",
		html: '<p>¿Deseas Aceptar la Solicitud?</p>',
		icon: "question",
		showCancelButton: true,
		cancelButtonText: "Cancelar",
		confirmButtonText: "Si, la Acepto!",
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




