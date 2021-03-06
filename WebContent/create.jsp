<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Sing UP</title>

<!-- JAVASCRIPTS -->
<script src="assets/js/jquery-3.3.1.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/js.js"></script>


<!-- CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
</head>

<body>
	<a class="nav-link" href="index.jsp">Entrar</a>

	<div class="card">
		<div class="card-header">
			<h4>Sing Up</h4>
		</div>
		<div class="card-body">
			<form id="form-singup">
				<div class="row">
					<div class="form-group col-12">
						<label class="col-form-label">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome" required>
					</div>
					<div class="form-group col-12">
						<label for="email" class="col-form-label">Email</label> <input
							type="email" class="form-control" name="email" id="email"
							required>
					</div>
					<div class="form-group col-12">
						<input type="hidden" id="idTelefone" name="idTelefone"> <label
							class="col-form-label">Telefone</label>
						<div class="row form-group">
							<input type="text" class="form-control col-2" name="dddTelefone"
								id="dddTelefone"  onkeyup="numero(this)" required> <input type="text"
								class="form-control col-10" name="telefone" id="telefone"  onkeyup="numero(this)"
								required>
						</div>
					</div>
					<div class="form-group col-12">
						<input type="hidden" id="idCelular" name="idCelular"> <label
							class="col-form-label">Celular</label>
						<div class=" form-group row">
							<input type="text" class="form-control col-2" name="dddCelular"
								id="dddCelular" onkeyup="numero(this)" required> <input type="text"
								class="form-control col-10" name="celular" id="celular" onkeyup="numero(this)" required>
						</div>
					</div>

					<div class="form-group col-12">
						<label for="senha" class="col-form-label">Senha</label> <input
							type="password" class="form-control" name="senha" id="senha"
							required>
					</div>

				</div>
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-lg btn-block"
						onclick="singup()">Registrar</button>
				</div>
			</form>
		</div>
	</div>

</body>

</html>