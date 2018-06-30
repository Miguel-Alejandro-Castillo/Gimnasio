
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resumen/" var="urlResumen"/>
<div id="page-wrapper">

	    <div class="col-lg-12">
	        <h1 class="page-header">Resumen de Cuentas</h1>
	    </div>

    	    <div class="col-lg-12">
    <ul class="nav nav-tabs">
    	<li class="active"><a data-toggle="tab" href="#Grafico">Grafico</a></li>   	
    	<li><a data-toggle="tab" href="#Lista">Lista</a></li>    
    </ul>
    
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="tab-content">
				<div id="Grafico" class="tab-pane active">
					<div class="panel-heading">
						<select id="mes" name="mes" onchange="cargarGraficoResumen('${urlResumen}');">
							<option value="" selected>Todos los meses</option>
							<option value="1">Enero</option>
							<option value="2">Febrero</option>
							<option value="3">Marzo</option>
							<option value="4">Abril</option>
							<option value="5">Mayo</option>
							<option value="6">Junio</option>
							<option value="7">Julio</option>
							<option value="8">Agosto</option>
							<option value="9">Septiembre</option>
							<option value="10">Octubre</option>
							<option value="11">Noviembre</option>
							<option value="12">Diciembre</option>
						</select>
						<select  id="anio" name="anio" onchange="cargarGraficoResumen('${urlResumen}');">
							<option value="2017" selected>2017</option>
							<c:forEach var = "i" begin = "2018" end = "2050">
								<option value="${i}"> <c:out value = "${i}"/></option>
							</c:forEach>
						</select>

						<select  id="idActividad" name="idActividad" onchange="cargarGraficoResumen('${urlResumen}');">
							<option value="" selected>Todas las actividades</option>
							<c:forEach items="${actividades}" var="actividad">
								<option value="${actividad.id}"> <c:out value = "${actividad.nombre}"/></option>
							</c:forEach>
						</select>
					</div>
					<!-- /.panel-heading -->
					<div id="totalRecaudado"></div>
	                <div class="panel-body">
	                    <div id="graficoBarras" ></div>
	                </div>  
				</div>

			    <div id="Lista" class="tab-pane">
					<div class="col-lg-12">
						<table  width="100%" class="table table-condensed table-bordered" id="dataTables-example">
				    		<thead>
				    			<tr>
									<th>Fecha Pago</th>
									<th>Cliente</th>
				    				<th>Actividad</th>
				    				<th>Monto</th>
									<th>Fecha desde</th>
									<th>Fecha hasta</th>
				    			</tr>
				    		</thead>
				    		<tbody>
								<c:forEach items="${clientes}" var="cliente">
								<c:forEach items="${cliente.pagos}" var="pago">
									<tr class="odd gradeX">
									<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${pago.momentoPago}"/></td>
									<td><c:out value="${cliente.nombre} ${cliente.apellido}"></c:out></td>
									<td><c:out value="${pago.actividad.nombre}"></c:out></td>
									<td><fmt:formatNumber value="${pago.monto}" type="currency" currencySymbol=""/></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pago.fechaDesde}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pago.fechaHasta}" /></td>
									</tr>
							   	</c:forEach>
								</c:forEach>
				    		</tbody>
					    </table>
					</div>
				</div>
					    
			</div>			    	    
		</div>
	</div>
</div>
</div>
<spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>    
<script src="${jqueryMin}"></script>

<script>
	$(document).ready(function() {
		cargarGraficoResumen('${urlResumen}');
		
		$('#dataTables-example').DataTable(
		   		{
		   				responsive: true,
		   		});
	});
	
</script>    