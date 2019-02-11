<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<fmt:setLocale value = "es_AR" scope="session"/>


<div class="well">
	<div class="row">
		<div class="col-lg-9">
			<h1 class="page-header">
				<tiles:getAsString name="title" />
			</h1>
		</div>

	</div>

	<table class="table table-striped table-bordered table-hover"
		id="dataTables-example">
		<thead>
			<tr>
				<th>Fecha Ingresada</th>
				<th>Cantidad Recibida</th>
				<th>Producto</th>
				<th>Accion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stocks}" var="stock">
				<tr id="row_${stock.id}">
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
							value="${stock.fechaIngreso}" /></td>
					<td><c:out value="${stock.cantidadRecibida}"></c:out></td>
					<td><c:out value="${stock.producto.nombre}"></c:out></td>
					<td><a onclick="deleteStock(${stock.id})">
						<i class="fas fa-trash-alt menuIcon"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>

<script>
  $(document).ready(function(){
    $('#dataTables-example').DataTable(
  		{
  				responsive: true,
  			    "info":     false
  			    
  		});
	  });
</script>
<!-- para que ande la tabla  -->
