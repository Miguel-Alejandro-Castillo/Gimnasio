<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><tiles:getAsString name="title"/></h1>
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
							<thead><tr><th>Nombre</th></tr></thead>
							<tbody><tr><th>${cliente.nombre}</th></tr></tbody>
	                    </table>
	                    <table class="table table-striped">
							<thead><tr><th>Apellido</th></tr></thead>
							<tbody><tr><th>${cliente.apellido}</th></tr></tbody>
	                    </table>
						<table class="table table-striped">
							<thead><tr><th>Sexo</th></tr></thead>
							<tbody><tr><th>${cliente.sexo}</th></tr></tbody>
						</table>
	                    <table class="table table-striped">
							<thead><tr><th>DNI</th></tr></thead>
							<tbody><tr><th>${cliente.dni}</th></tr></tbody>
	                    </table>
	                    <table class="table table-striped">
							<thead><tr><th>Fecha de Nacimiento</th></tr></thead>
							<tbody><tr><th><fmt:formatDate value="${cliente.fechaNacimiento}" type="date" pattern="dd/MM/yyyy" /></th></tr></tbody>
	                    </table>
					</div>

					<div class="col-lg-6">   
						<table class="table table-striped">
							<thead><tr><th>Direccion</th></tr></thead>
							<tbody><tr><th>${cliente.direccion}</th></tr></tbody>
						</table>
	                    <table class="table table-striped">
							<thead><tr><th>Telefono</th></tr></thead>
							<tbody><tr><th>${cliente.telefono}</th></tr></tbody>
	                    </table>
	                    <table class="table table-striped">
							<thead><tr><th>Email</th></tr></thead>
							<tbody><tr><th>${cliente.email}</th></tr></tbody>
	                    </table>                        

		            	<div style="padding-top:35px;float:right;">
		            		<spring:url value="/clientes/${cliente.id}/clienteEditar" var="urlClienteEditar"/>
							<a href="${urlClienteEditar}" class="btn btn-primary btn-lg">Editar cliente</a>
						</div>
					</div>						

				</div>
			
				<div id="Pagos" class="tab-pane">
					<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
							<td>Momento Pago</td>
							<td>Actividad</td>
							<td>Fecha Desde</td>
							<td>Fecha Hasta</td>
						    <td>Monto</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cliente.pagos}" var="pago">
								<tr class="odd gradeX">
									<td><fmt:formatDate value="${pago.momentoPago}" type="both" dateStyle="short" timeStyle="short" /></td>
									<td><c:out value="${pago.actividad.nombre}"></c:out></td>
									<td><fmt:formatDate value="${pago.fechaDesde}" type="date" pattern="dd/MM/yyyy" /></td>
									<td><fmt:formatDate value="${pago.fechaHasta}" type="date" pattern="dd/MM/yyyy" /></td>
									<td>
										<fmt:formatNumber value="${pago.monto}" type="currency" minFractionDigits="2" currencySymbol="$"/>
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