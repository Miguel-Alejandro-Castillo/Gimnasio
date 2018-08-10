<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>

<div class="col-lg-9">
	<c:if test="${not empty success_pago}">
		<div id="alert-pago"
			class="alert alert-success alert-dismissible fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${success_pago}</strong>
		</div>

		<script>
			$(document).ready(function() {
				window.setTimeout(function() {
					$("#alert-pago").fadeTo(1500, 0).slideUp(500, function() {
						$(this).hide();
					});
				}, 2500);
			});
		</script>

	</c:if>

	<div class="well">
		<div class="row">
			<div class="col-lg-10">
				<h1 class="page-header">
					<tiles:getAsString name="title" />
				</h1>
			</div>
			<div class="col-lg-2">
				<spring:url value="/clientes/crear" var="crearCliente" />
				<a href="${crearCliente}">
					<button class="upperButton btn-lg"><i class="fa fa-user-plus"></i> Nuevo Cliente</button>
				</a>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr
							style="font-family: Lucida Sans Unicode, Lucida Grande, sans-serif">
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Dni</th>
							<th>Accion</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td><c:out value="${cliente.nombre}"></c:out></td>
								<td><c:out value="${cliente.apellido}"></c:out></td>
								<td><c:out value="${cliente.dni}"></c:out></td>
								<td style="text-align: center;"><spring:url
										value="/clientes/${cliente.id}/clienteDetalle"
										var="urlClienteDetalle" /> <a href="${urlClienteDetalle}"
									data-toggle="tooltip" title="Detalle"><i
										class="fa fa-info-circle"
										style="font-size: 24px; color: blue; padding-right: 10px; padding-left: 10px;"></i></a>
									<spring:url value="/clientes/${cliente.id}/pagar"
										var="urlPagar" /> <a href="${urlPagar}" data-toggle="tooltip"
									title="Pagar"><i class="fa fa-dollar"
										style="font-size: 24px; color: green; padding-right: 10px; padding-left: 10px;"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>

<script>
   	$(document).ready(function(){
   		cargarGraficoResumen('${urlResumen}');
   		
	   $('#dataTables-example').DataTable(
	      		{
	      				responsive: true,
	      		});
   	});
</script>

