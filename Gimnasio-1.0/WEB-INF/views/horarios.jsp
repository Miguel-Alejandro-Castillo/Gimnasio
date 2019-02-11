<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<style>
    td{
        font-size: smaller;
    }
</style>


<div class="well">
	<h1 class="page-header">
		<tiles:getAsString name="title" />
	</h1>

	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">

				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Lunes</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesLunes}" var="lunes">
						<tr class="odd gradeX">
							<td>
								<c:out value="${lunes.key.horaInicio}"></c:out>
							-
								<c:out value="${lunes.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${lunes.value.nombre}"></c:out>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>

				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Martes</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesMartes}" var="martes">
						<tr class="odd gradeX">
							<td>
								<c:out value="${martes.key.horaInicio}"></c:out>
							-
								<c:out value="${martes.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${martes.value.nombre}"></c:out>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>


				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Miercoles</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesMiercoles}" var="miercoles">
						<tr class="odd gradeX">
							<td>
								<c:out value="${miercoles.key.horaInicio}"></c:out>
							-
								<c:out value="${miercoles.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${miercoles.value.nombre}"></c:out>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>

				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Jueves</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesJueves}" var="jueves">
						<tr class="odd gradeX">
							<td>
								<c:out value="${jueves.key.horaInicio}"></c:out>
							-
								<c:out value="${jueves.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${jueves.value.nombre}"></c:out>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>

				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Viernes</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesViernes}" var="viernes">
						<tr class="odd gradeX">
							<td>
								<c:out value="${viernes.key.horaInicio}"></c:out>
							-
								<c:out value="${viernes.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${viernes.value.nombre}"></c:out>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>

				<div class="col-lg-2">
				<table
					class="table table-striped table-bordered table-hover dataTables-example">
					<caption>Sabado</caption>
					<thead>
						<tr>
							<td>hora</td>
							<td>actividad</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${leccionesSabado}" var="sabado">
						<tr class="odd gradeX">
							<td>
								<c:out value="${sabado.key.horaInicio}"></c:out>
							-
								<c:out value="${sabado.key.horaFin}"></c:out>
							</td>
							<td>
								<c:out value="${sabado.value.nombre}"></c:out>
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


<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>

<script>
  $(document).ready(function() {
      var table = $('.dataTables-example').DataTable(
          {
              responsive: false,
              "paging": false,
              "searching": false,
              "info": false,
              "order": [0, 'asc'],
              "columnDefs": [
                  { "orderable": false, "targets": 1 }
              ]
          });
  })
</script>
<!-- para que ande la tabla  -->
