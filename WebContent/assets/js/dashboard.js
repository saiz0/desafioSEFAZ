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

		$.ajax({
			type: 'POST',
			dataType: 'json',
			url: "UsuarioList",
		
			cache: false,
			success: function (data) {
				var texto;
				data.forEach(function(item){
					texto += '<tr><td>'+item.nome+'</td><td>'+item.email+'</td>';				
					item.telefones.forEach(function(item2){
						texto += '<td>'+item2.numero+'</td>'});					
				  });					 
				  $('#pessoas').append('</tr>'+texto);		
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
		},
		
	});
	top.location.href = "index.jsp";

}

