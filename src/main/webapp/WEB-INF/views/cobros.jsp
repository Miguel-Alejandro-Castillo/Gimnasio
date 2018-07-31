<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-9">
	<div class="well">
		<div class="row">
			<div class="col-lg-11">
				<h1 class="page-header">
					<tiles:getAsString name="title" />
				</h1>
			</div>
			<div class="col-lg-1">
				<spring:url value="/cobros/realizar" var="realizarCobro" />
				<a href="${realizarCobro}">
					<button class="btn-danger" style="margin-top: 30px;">Realizar Cobro</button>
				</a>
			</div>
		</div>

		<div id="Lista" class="tab-pane">
				<div class="col-lg-12">
					<table width="100%" class="table table-condensed table-bordered"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Fecha Pago</th>
								<th>Actividad</th>
								<th>Monto</th>
								<th>Fecha desde</th>
								<th>Fecha hasta</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cobros}" var="cobro">
								
									<tr class="odd gradeX">
										<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
												value="${cobro.momentoCobro}" /></td>
										<td><c:out value="${cobro.actividad.nombre}"></c:out></td>
										<td><fmt:formatNumber value="${cobro.monto}"
												type="currency" currencySymbol="" /></td>
										<td><fmt:formatDate pattern="dd/MM/yyyy"
												value="${cobro.fechaDesde}" /></td>
										<td><fmt:formatDate pattern="dd/MM/yyyy"
												value="${cobro.fechaHasta}" /></td>
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
  				"paging":   false,
  				"searching": false,
  			    "info":     false
  			    
  		});
	  });
</script>
<!-- para que ande la tabla  -->
