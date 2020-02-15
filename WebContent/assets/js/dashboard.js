$(document).ready(function () {
		$.ajax({
			type: 'POST',
			dataType: 'json',
			url: "UsuarioDashboard",
		
			cache: false,
			success: function (data) {
				$("#pnome").val(data.nome);
				$("#pemail").val(data.email);
				data.telefones.forEach(function(item){
				if(item.tipo == "Numero"){
					$("#ptelefone").val(item.ddd + item.numero);
				}
				if(item.tipo == "Celular"){
					$("#pcelular").val(item.ddd + item.numero);
				}
				  });
				  
			},
			error: function () {
		
	
			}
		});

});


function usuarioDelete() {
	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: "UsuarioDelete",	
		success: function (data) {			
			top.location.href = "index.jsp";
		},
		
	});
}

