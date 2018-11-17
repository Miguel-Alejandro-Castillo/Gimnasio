<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<fmt:setLocale value = "es_AR" scope="session"/>



	<div class="well">
		<h1 class="page-header">Resumen de Cuentas</h1>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#Grafico">Grafico</a></li>
			<li><a data-toggle="tab" href="#Lista">Lista</a></li>
		</ul>

		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-lg-4">
					<div class="form-group">
						<select class="form-control" id="mes" name="mes"
								onchange="cargarResumen();">
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
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<select class="form-control" id="anio" name="anio" onchange="cargarResumen();">
							<option value="" selected>Todas los a&ntilde;os</option>
							<c:forEach items="${anios}" var="anio">
								<option value="${anio}">
									<c:out value="${anio}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<select class="form-control" id="idActividad" name="idActividad" onchange="cargarResumen();">
							<option value="" selected>Todas las actividades</option>
							<c:forEach items="${actividades}" var="actividad">
								<option value="${actividad.id}">
									<c:out value="${actividad.nombre}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="tab-content">
					<div id="Grafico" class="tab-pane active">
						<div class="panel-heading">
							<div id="totalRecaudado"></div>
							<div id="graficoBarras"></div>
						</div>

					</div>

					<div id="Lista" class="tab-pane">
						<div class="col-lg-12">
							<table id="dataTables-resumen" width="100%" class="table table-condensed table-bordered">
								<thead>
								<tr>
									<th>Fecha Pago</th>
									<th>Cliente</th>
									<th>Actividad</th>
									<th>Monto a pagar</th>
									<th>Monto pagado</th>
									<th>Fecha desde</th>
									<th>Fecha hasta</th>
								</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>




	<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
	<script src="${jqueryMin}"></script>

	<script>
        $(function() {
            cargarResumen();
        });
	</script>
