<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
<link href="${jqueryConfirmCss}" rel="stylesheet"/>


	<c:if test="${not empty success_pago}">
		<script>
			$(document).ready(function() {
                $.alert({
                    title: '',
					content: '<strong style="font-size: 20px;">El pago se registró con Éxito!</strong>',
                    type: 'green',
                });
			});
		</script>
	</c:if>

	<div class="well">
		<div class="row">
			<div class="col-lg-9">
				<h1 class="page-header">
					<tiles:getAsString name="title" />
				</h1>
			</div>
			<div class="col-lg-3">
				<spring:url value="/clientes/crear" var="crearCliente" />
				<a href="${crearCliente}">
					<button class="btn upperButton"><i class="fas fa-user-plus"></i>Nuevo Cliente</button>
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
							<tr id="row_${cliente.id}">
								<td><c:out value="${cliente.nombre}"></c:out></td>
								<td><c:out value="${cliente.apellido}"></c:out></td>
								<td><c:out value="${cliente.dni}"></c:out></td>
								<td style="text-align: center;"><spring:url
										value="/clientes/${cliente.id}/clienteDetalle"
										var="urlClienteDetalle" /> <a href="${urlClienteDetalle}"
									data-toggle="tooltip" title="Detalle">
									<i class="fas fa-info-circle menuIcon blue"></i></a>
									<spring:url value="/clientes/${cliente.id}/pagar" var="urlPagar" />
									<a href="${urlPagar}" data-toggle="tooltip" title="Pagar">
										<i class="fas fa-money-bill-wave menuIcon green"></i>
									</a>
								     <a onclick="deleteCliente(${cliente.id})"><i
										class="fas fa-trash-alt menuIcon"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
   	$(document).ready(function(){
	   $('#dataTables-example').DataTable(
			{
					responsive: true
			});
   	});
</script>

