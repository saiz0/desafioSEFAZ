function singup() {
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : "UsuarioCreate",
		data : {
			nome : $('#nome').val(),
			email : $('#email').val(),
			telefone : $('#telefone').val(),	
			celular : $('#celular').val(),		
			senha : $('#senha').val(),		
		},
		cache : false,
		success : function(data) {
		
		},
	});

}