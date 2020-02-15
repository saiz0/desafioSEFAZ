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
<link href="assets/css/css.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
</head>

<body>

	<a class="" href="UsuarioLogout">Sair</a>
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
									class="form-control" name="pnome" id="pnome" required>
							</div>
							<div class="form-group col-12">
								<label for="email" class="col-form-label">Email</label> <input
									type="email" class="form-control" name="pemail" id="pemail"
									required>
							</div>
							<div class="form-group col-12">
								<label class="col-form-label">Telefone</label> <input
									type="text" class="form-control" name="ptelefone" id="ptelefone"
									required>
							</div>
							<div class="form-group col-12">
								<label class="col-form-label">Celular</label> <input type="text"
									class="form-control" name="pcelular" id="pcelular" required>
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
								<th scope="col">#</th>
								<th scope="col">First</th>
								<th scope="col">Last</th>
								<th scope="col">Handle</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>

				</div>

			</div>

		</div>
	</div>

</body>

</html>