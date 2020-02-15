function singup() {
	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: "UsuarioCreate",
		data: {
			nome: $('#nome').val(),
			email: $('#email').val(),
			telefone: $('#telefone').val(),
			celular: $('#celular').val(),
			senha: $('#senha').val(),
		},
		cache: false,
		success: function (data) {

		},
	});
}

function login() {
	$.ajax({
		type: 'POST',
		dataType: 'json',
		url: "UsuarioLogin",
		data: {
			email: $('#email').val(),
			senha: $('#senha').val(),
		},
		cache: false,
		success: function (data) {
			if (data == 1) {
				top.location.href = "dashboard.jsp";

			} else {
				alert("Erro ao logar");
			}

		},
		error: function () {
			alert("Erro ao logar");

		}
	});
}

function logout() {
	$.ajax({
		type: 'POST',
		url: "UsuarioLogout"
	});
}

