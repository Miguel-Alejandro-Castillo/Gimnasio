
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<td>Dia</td>
					<td>Hora Inicio</td>
					<td>Hora Fin</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${lecciones}" var="lecciones">
				<tr>
					<td><c:out value="${lecciones.dia}"></c:out></td>
					<td><c:out value="${lecciones.horaInicio}"></c:out></td>
					<td><c:out value="${lecciones.horaFin}"></c:out></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>