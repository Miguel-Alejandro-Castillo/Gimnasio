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
            <spring:url value="/productos" var="listaProductos" />
            <a href="${listaProductos}">
                <button class="btn upperButton"><i class="fas fa-arrow-right"></i>Productos</button>
            </a>


        </div>
            <div class="col-lg-3">
                <spring:url value="/productos/egreso" var="egreso" />
            <a href="${egreso}">
                <button class="btn upperButton"><i class="fas fa-arrow-right"></i>Retiro</button>
            </a>

                <spring:url value="/productos/ingreso" var="ingreso" />
                <a href="${ingreso}">
                    <button class="btn upperButton"><i class="fas fa-arrow-right"></i>Ingreso</button>
                </a>

        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="col-lg-3">
                <div class="form-group">
                    <select class="form-control" id="mes" name="mes" onchange="cargarListadoVentasProductos()">
                        <option value="" ${ empty param["mes"] ? 'selected="selected"' : ''}>Todos los meses</option>
                        <option value="1" ${ param["mes"] == "1" ? 'selected="selected"' : ''}>Enero</option>
                        <option value="2" ${ param["mes"] == "2" ? 'selected="selected"' : ''}>Febrero</option>
                        <option value="3" ${ param["mes"] == "3" ? 'selected="selected"' : ''}>Marzo</option>
                        <option value="4" ${ param["mes"] == "4" ? 'selected="selected"' : ''}>Abril</option>
                        <option value="5" ${ param["mes"] == "5" ? 'selected="selected"' : ''}>Mayo</option>
                        <option value="6" ${ param["mes"] == "6" ? 'selected="selected"' : ''}>Junio</option>
                        <option value="7" ${ param["mes"] == "7" ? 'selected="selected"' : ''}>Julio</option>
                        <option value="8" ${ param["mes"] == "8" ? 'selected="selected"' : ''}>Agosto</option>
                        <option value="9" ${ param["mes"] == "9" ? 'selected="selected"' : ''}>Septiembre</option>
                        <option value="10" ${ param["mes"] == "10" ? 'selected="selected"' : ''}>Octubre</option>
                        <option value="11" ${ param["mes"] == "11" ? 'selected="selected"' : ''}>Noviembre</option>
                        <option value="12" ${ param["mes"] == "12" ? 'selected="selected"' : ''}>Diciembre</option>
                    </select>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="form-group">

                    <select class="form-control" id="anio" name="anio" onchange="cargarListadoVentasProductos()">
                        <option value="" ${ empty param["anio"] ? 'selected="selected"' : ''}>Todas los a&ntilde;os</option>
                        <c:forEach items="${anios}" var="anio">
                            <option value="${anio}" ${ anio.toString() == param["anio"] ? 'selected="selected"' : ''}>
                                <c:out value="${anio}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <table class="table table-striped table-bordered table-hover"
                   id="dataTables-example">
                <thead>
                <tr
                        style="font-family: Lucida Sans Unicode, Lucida Grande, sans-serif">
                    <th>Fecha</th>
                    <th>Nombre</th>
                    <th>Recaudado</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${ventas}" var="venta">
                    <tr id="row_${venta.id}">
                        <td><c:out value="${venta.fecha}"></c:out></td>
                        <td><c:out value="${venta.producto.nombre}"></c:out></td>
                        <td><c:out value="${venta.total}"></c:out></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h3>Total: ${total}</h3>
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

