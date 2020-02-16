<%@page import="models.Pessoa"%>
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
<script src="assets/js/dashboard.js"></script>


<!-- CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
</head>

<body>
	<a class="nav-link" href="UsuarioLogout">Sair</a>
	<div class="card">
		<div class="card-header">
			<h4>Dashboard</h4>
		</div>
		<div class="card-body">
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="perfil-tab"
					data-toggle="pill" href="#perfil" role="tab" aria-controls="perfil"
					aria-selected="true">Perfiil</a></li>
				<li class="nav-item"><a class="nav-link" id="usuarios-tab"
					data-toggle="pill" href="#usuarios" role="tab"
					aria-controls="usuarios" aria-selected="false">Usuarios</a></li>

			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="perfil" role="tabpanel"
					aria-labelledby="perfil-tab">

					<form id="form-perfil">
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
								<input type="hidden" id="idTelefone" name="idTelefone">
								<label class="col-form-label">Telefone</label>
								<div class="row form-group">
									<input type="text" class="form-control col-2"
										name="dddTelefone" id="dddTelefone" required> <input
										type="text" class="form-control col-10" name="telefone"
										id="telefone" required>
								</div>
							</div>
							<div class="form-group col-12">
								<input type="hidden" id="idCelular" name="idCelular"> <label
									class="col-form-label">Celular</label>
								<div class=" form-group row">
									<input type="text" class="form-control col-2" name="dddCelular"
										id="dddCelular" required> <input type="text"
										class="form-control col-10" name="celular" id="celular"
										required>
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
								onclick="salvar()">Salvar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block"
								onclick="usuarioDelete()">Deletar Conta</button>
						</div>
					</form>

				</div>
				<div class="tab-pane fade" id="usuarios" role="tabpanel"
					aria-labelledby="usuarios-tab">

					<table class="table">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Email</th>
								<th scope="col">Telefone</th>
								<th scope="col">Celular</th>
							</tr>
						</thead>
						<tbody id="pessoas">

						</tbody>
					</table>

				</div>

			</div>

		</div>
	</div>

</body>

</html>