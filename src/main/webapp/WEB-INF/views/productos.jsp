<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
<link href="${jqueryConfirmCss}" rel="stylesheet"/>


<c:if test="${not empty success_venta}">
  <script>
    $(document).ready(function() {
      $.alert({
        title: '',
        content: '<strong style="font-size: 20px;">La venta se registró con Éxito!</strong>',
        type: 'green'
      });
    });
  </script>
</c:if>

<div class="well">
  <div class="row">
    <div class="col-lg-6">
      <h1 class="page-header">
        <tiles:getAsString name="title" />
      </h1>
    </div>
    <div class="col-lg-3">
      <spring:url value="/productos/crear" var="crearProducto" />
      <a href="${crearProducto}">
        <button class="btn upperButton"><i class="fas fa-spray-can"></i>Nuevo Producto</button>
      </a>
    </div>
    <div class="col-lg-3">
      <spring:url value="/productos/productosVentas" var="productosVentas" />
      <a href="${productosVentas}">
        <button class="btn upperButton"><i class="fas fa-arrow-right"></i> Ventas Realizadas</button>
      </a>
    </div>
  </div>

  <div class="panel panel-default">
    <div class="panel-body">
      <table class="table table-striped table-bordered table-hover"
             id="dataTables-example">
        <thead>
        <tr
                style="font-family: Lucida Sans Unicode, Lucida Grande, sans-serif">
          <th>Nombre</th>
          <th>Costo</th>
          <th>Stock Actual</th>
          <th>Accion</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${productos}" var="producto">
          <tr id="row_${producto.id}">
            <td><c:out value="${producto.nombre}"></c:out></td>
            <td><c:out value="${producto.costo}"></c:out></td>
            <td><c:out value="${producto.stockActual}"></c:out></td>
            <td style="text-align: center;">
              <spring:url value="/productos/${producto.id}/editar" var="urlProductoEditar" />
              <a href="${urlProductoEditar}">
                <button class="btn editButton"><i class="fa fa-user-plus"></i> Editar Producto</button>
              </a>
              <a onclick="venderProducto(${producto.id})">
                <i class="fas fa-money-bill-wave menuIcon green"></i>
              </a>
              <a onclick="deleteProducto(${producto.id})">
                <i class="fas fa-trash-alt menuIcon"></i>
              </a>
              <spring:url value="/productos/${producto.id}/registrarStock" var="urlRegistrarStock" />
              <a href="${urlRegistrarStock}">
                <button class="btn editButton"><i class="fa fa-user-plus"></i> registrar stock</button>
              </a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>

<script>
  $(document).ready(function(){
    $('#dataTables-example').DataTable(
            {
              responsive: true
            });
  });
</script>