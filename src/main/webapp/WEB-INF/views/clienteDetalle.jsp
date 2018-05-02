<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><tiles:getAsString name="title"/></h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-lg-6">
					<table class="table table-striped">
						<thead><tr><th>Nombre</th></tr></thead>
						<tbody><tr><th>${clienteBean.nombre}</th></tr></tbody>
                    </table>
                    <table class="table table-striped">
						<thead><tr><th>Apellido</th></tr></thead>
						<tbody><tr><th>${clienteBean.apellido}</th></tr></tbody>
                    </table>
                    <table class="table table-striped">
						<thead><tr><th>DNI</th></tr></thead>
						<tbody><tr><th>${clienteBean.dni}</th></tr></tbody>
                    </table>
                    <table class="table table-striped">
						<thead><tr><th>Fecha de Nacimiento</th></tr></thead>
						<tbody><tr><th>${clienteBean.fecha_de_nacimiento}</th></tr></tbody>
                    </table>
				</div>
				
				<div class="col-lg-6">   
					<table class="table table-striped">
						<thead><tr><th>Direccion</th></tr></thead>
						<tbody><tr><th>${clienteBean.direccion}</th></tr></tbody>
					</table>
                    <table class="table table-striped">
						<thead><tr><th>Telefono</th></tr></thead>
						<tbody><tr><th>${clienteBean.telefono}</th></tr></tbody>
                    </table>
                    <table class="table table-striped">
						<thead><tr><th>Email</th></tr></thead>
						<tbody><tr><th>${clienteBean.email}</th></tr></tbody>
                    </table>                        

	            	<div style="padding-top:35px;float:right;">
	            		<spring:url value="/clientes/${clienteBean.id}/clienteEditar" var="urlClienteEditar"/>
						<a href="${urlClienteEditar}" class="btn btn-primary btn-lg">Editar cliente</a>
					</div>
				</div>						
				<!-- /.col-lg-6 (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->                	
	</div>
	<!-- /.row -->		
	<!-- TABLA QUE MUESTRE SOLO LOS 10 ULTIMOS -->		
	<div class="row">
		<div class="col-lg-12">
			<div class="panel-body">
				<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
					<thead>
						<td>Momento Pago</td>
						<td>Cliente</td>
						<td>Actividad</td>
						<td>Fecha Desde</td>
						<td>Fecha Hasta</td>
					</thead>
					<tbody>
						<c:forEach items="${clienteBean.pagos}" var="pago">
							<tr class="odd gradeX">
								<td><c:out value="${pago.momento_pago}"></c:out></td>
								<td><c:out value="${pago.actividad.nombre}"></c:out></td>
								<td><c:out value="${pago.fecha_desde}"></c:out></td>
								<td><c:out value="${pago.fecha_hasta}"></c:out></td>
								<td><c:out value="${pago.monto}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>