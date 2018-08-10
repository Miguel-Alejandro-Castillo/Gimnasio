<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Page Content -->


<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header" style="margin-top: 10px">Inicio - Ultimos Deudores</h1>

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr
							style="font-family: Lucida Sans Unicode, Lucida Grande, sans-serif">
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Ultimo Pago</th>
							<th>Actividad</th>
							<th>Accion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="entrada" items="${tabla}">
							<tr>
								<td><c:out value="${entrada.value.nombre}"></c:out></td>
								<td><c:out value="${entrada.value.apellido}"></c:out></td>
								<td><c:out value="${entrada.key.fechaHasta}" /></td>
								<td><c:out value="${entrada.key.actividad.nombre}" /></td>
	
								<td style="text-align: center;"><spring:url
										value="/clientes/${entrada.value.id}/pagar" var="urlPagar" />
									<a href="${urlPagar}" data-toggle="tooltip" title="Pagar"><i
										class="fa fa-money-bill-wave"
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
	   $('#dataTables-example').DataTable(
	      		{
	      				responsive: true,
	      				"order": [[ 2  , "desc" ]]
	      		});
   	});
</script>


