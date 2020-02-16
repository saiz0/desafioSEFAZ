$(document).ready(
		function() {
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : "UsuarioDashboard",

				cache : false,
				success : function(data) {
					$("#nome").val(data.nome);
					$("#email").val(data.email);
					data.telefones.forEach(function(item) {
						if (item.tipo == "Numero") {
							$("#telefone").val(item.numero);
							$("#dddTelefone").val(item.ddd);
							$("#idTelefone").val(item.id);

						}
						if (item.tipo == "Celular") {
							$("#celular").val(item.numero);
							$("#dddCelular").val(item.ddd);
							$("#idCelular").val(item.id);
						}
					});

				},
				error : function() {

				}
			});

			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : "UsuarioList",

				cache : false,
				success : function(data) {
					var texto;

					// preenchendo da tabela com os dados das pessoas
					data.forEach(function(item) {
						texto += '<tr><td>' + item.nome + '</td><td>'
								+ item.email + '</td>';
						item.telefones.forEach(function(item2) {
							texto += '<td>' + item2.numero + '</td>'
						});
					});
					$('#pessoas').append('</tr>' + texto);
				},
				error : function() {

				}
			});

		});

function usuarioDelete() {
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : "UsuarioDelete",
		success : function(data) {
		},

	});
	top.location.href = "index.jsp";

}

function salvar() {
	var nome = $('#nome').val();
	var email = $('#email').val();
	var telefone = $('#telefone').val();
	var dddTelefone = $('#dddTelefone').val();
	var idTelefone = $('#idTelefone').val();
	var celular = $('#celular').val();
	var dddCelular = $('#dddCelular').val();
	var idCelular = $('#idCelular').val();
	var senha = $('#senha').val();

	// verificação de campos
	if (nome == '' || email == '' || telefone == '' || celular == ''
			|| senha == '' || dddTelefone == '' || dddCelular == '') {
		alert("Preencha todos os dados");

	} else {
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : "UsuarioUpdate",
			data : {
				nome : nome,
				email : email,
				telefone : telefone,
				dddTelefone : dddTelefone,
				idTelefone : idTelefone,
				celular : celular,
				dddCelular : dddCelular,
				idCelular : idCelular,
				senha : senha,
			},
			cache : false,
		});
		top.location.href = "dashboard.jsp";

	}
}