<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#Detalle">Detalle</a></li>
			<li><a data-toggle="tab" href="#Pagos">Pagos</a></li>
		</ul>

		<div class="panel panel-default">
			<div class="panel-body">
				<div class="tab-content">
					<div id="Detalle" class="tab-pane active">
						<div class="col-lg-6">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Nombre Actividad</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.actividad.nombre}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Profesor</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.actividad.profesor.nombre}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Monto</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.monto}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>momento pago</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.momentoPago}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Periodo</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th><fmt:formatDate value="${pago.fechaDesde}"
												type="date" pattern="dd/MM/yyyy" /></th>
									</tr>
									<tr>
										<th><fmt:formatDate value="${pago.fechaHasta}"
												type="date" pattern="dd/MM/yyyy" /></th>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="col-lg-6">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Comentario</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.comentario}</th>
									</tr>
								</tbody>
							</table>
							
							<div style="padding-top: 35px; float: right;">
								<spring:url value="/clientes/${cliente.id}/clienteEditar"
									var="urlClienteEditar" />
								<a href="${urlClienteEditar}" class="btn btn-primary btn-lg">Editar
									cliente</a>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
</div>