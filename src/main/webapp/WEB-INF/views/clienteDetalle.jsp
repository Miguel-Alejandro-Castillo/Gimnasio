<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
<link href="${jqueryConfirmCss}" rel="stylesheet"/>

<div class="col-lg-9">
	<div class="well">
		<div class="row">
			<div class="col-lg-10">
				<h1 class="page-header">
					${cliente.nombre} ${cliente.apellido}
				</h1>
			</div>
			<div class="col-lg-2">
				<spring:url value="/clientes/${cliente.id}/clienteEditar"
						var="urlClienteEditar" />
					<a href="${urlClienteEditar}">
						<button class="upperButton btn-lg"><i class="fa fa-user-plus"></i> Editar Cliente</button>
					</a>
				</div>
			</div>

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
										<th>Sexo</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${cliente.sexo}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>DNI</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${cliente.dni}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Fecha de Nacimiento</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th><fmt:formatDate value="${cliente.fechaNacimiento}"
												type="date" pattern="dd/MM/yyyy" /></th>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="col-lg-6">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Telefono</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${cliente.telefono}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Direccion</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${cliente.direccion}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Email</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${cliente.email}</th>
									</tr>
								</tbody>
							</table>
						</div>

					</div>

					<div id="Pagos" class="tab-pane">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<td>Momento Pago</td>
									<td>Actividad</td>
									<td>Fecha Desde</td>
									<td>Fecha Hasta</td>
									<td>Monto a pagar</td>
									<td>Monto restante</td>
									<td>Accion</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cliente.pagos}" var="pago">
									<tr class="odd gradeX" id="row_${pago.id}">
										<td><fmt:formatDate value="${pago.momentoPago}"
												type="both" dateStyle="short" timeStyle="short" /></td>
										<td><c:out value="${pago.actividad.nombre}"></c:out></td>
										<td><fmt:formatDate value="${pago.fechaDesde}"
												type="date" pattern="dd/MM/yyyy" /></td>
										<td><fmt:formatDate value="${pago.fechaHasta}"
												type="date" pattern="dd/MM/yyyy" /></td>
										<td><fmt:formatNumber value="${pago.montoAPagar}"
												type="currency" minFractionDigits="2" currencySymbol="$" />
										</td>
										<td id="montoRestante_${pago.id}"><fmt:formatNumber value="${pago.montoRestante}"
															  type="currency" minFractionDigits="2" currencySymbol="$" />
										</td>
										<td style="text-align: center;">
											<spring:url value="/clientes/${cliente.id}/clienteDetalle/${pago.id}" var="urlPagoDetalle" />
											<c:if test="${pago.montoRestante gt 0.00}">
												<a id="completarPago_${pago.id}" onclick="completarPago(${cliente.id}, ${pago.id})" data-toggle="tooltip" title="Completar pago">
													<i class="fas fa-check-double" style="font-size: 24px; color: blue; padding-right: 10px; padding-left: 10px;"></i></a>
											</c:if>
											<a href="${urlPagoDetalle}" data-toggle="tooltip" title="Detalle" >
												<i class="fa fa-info-circle" style="font-size: 24px; color: blue; padding-right: 10px; padding-left: 10px;"></i></a>
											<a onclick="deletePagoCliente(${cliente.id}, ${pago.id})"><i class="fas fa-trash-alt"
													style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>