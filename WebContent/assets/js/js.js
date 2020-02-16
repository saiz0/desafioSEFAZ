function singup() {

	var nome = $('#nome').val();
	var email = $('#email').val();
	var telefone = $('#telefone').val();
	var dddTelefone = $('#dddTelefone').val();
	var celular = $('#celular').val();
	var dddCelular = $('#dddCelular').val();
	var senha = $('#senha').val();
	// verificação de campos
	if (nome == '' || email == '' || telefone == '' || celular == ''
			|| senha == '' || dddTelefone == '' || dddCelular == '') {
		alert("Preencha todos os dados");

	} else {
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : "UsuarioCreate",
			data : {
				nome : nome,
				email : email,
				telefone : telefone,
				dddTelefone : dddTelefone,
				celular : celular,
				dddCelular : dddCelular,
				senha : senha,
			},
			cache : false,
			success : function(data) {
				top.location.href = "index.jsp";

			},
			error : function() {
				alert("Erro ao criar conta");

			}
		});
	}

}

function login() {
	var email = $('#email').val();
	var senha = $('#senha').val();
	if (email == '' || senha == '') {
		alert("Preencha todos os dados");

	} else {
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : "UsuarioLogin",
			data : {
				email : email,
				senha : senha,
			},
			cache : false,
			success : function(data) {
				if (data == 1) {
					top.location.href = "dashboard.jsp";

				} else {
					alert("Erro ao logar");
				}

			},
			error : function() {
				alert("Erro ao logar");

			}
		});
	}

}

function logout() {
	$.ajax({
		type : 'POST',
		url : "UsuarioLogout"
	});
}


//validação do campos numero
function numero(txt) {
	txt.value = txt.value.replace(/[^0-9\n\r-]+/g, '');
	txt.value = txt.value.replace(/ /g, '');

}
