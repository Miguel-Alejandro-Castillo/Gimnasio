<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-9">
	<div class="well">
		
		<h1 class="page-header">
			<tiles:getAsString name="title" />
			<span style="font-weight:bold;font-size:medium">
				Cliente: ${cliente.nombre} ${cliente.apellido}
			</span>
		</h1>
		
		<div class="panel panel-default">
			<div class="panel-body">
				
						<div class="col-lg-6">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Nombre de la actividad abonada</th>
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
										<th>Profesor a cargo</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${pago.profesor.nombre} ${pago.profesor.apellido}</th>
									</tr>
								</tbody>
							</table>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Fecha y hora del pago</th>
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
										<th>Monto cobrado al cliente</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>$${pago.monto}</th>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="col-lg-6">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Periodo de la actividad pagada</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>Desde:</th><th> <fmt:formatDate value="${pago.fechaDesde}"
												type="date" pattern="dd/MM/yyyy" /></th>
									</tr>
									<tr>
										<th>Hasta:</th><th><fmt:formatDate value="${pago.fechaHasta}"
												type="date" pattern="dd/MM/yyyy" /></th>
									</tr>
								</tbody>
							</table>
						
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Detalle del pago</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th id="comentario" style="height:25px"></th>
									</tr>
								</tbody>
							</table>
							
						</div>

					</div>

				</div>
			</div>
		</div>
	<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>
<script>
	$(document).ready( function(){
		if(${pago.comentario != null}){
			var co = "${pago.comentario}";
			document.getElementById('comentario').innerHTML = co;
		}else{
			document.getElementById('comentario').innerHTML = ' - No hay detalle de pago - ';	
		}
				
 		
 	});
</script>
<!-- para que se setee fechaDesde en hoy por default-->