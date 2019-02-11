<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="well">
    <div class="headerWrapper">
        <h1 class="page-header">
                Detalle de ${producto.nombre}
        </h1>
        <spring:url value="/productos" var="atras"/>
        <a href="${atras}">
            <button class="btn backButton"><i class="fas fa-arrow-left"></i> Atras</button>
        </a>
    </div>

    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#Detalle">Detalle</a></li>
        <li><a data-toggle="tab" href="#Ventas">Ventas</a></li>
        <li><a data-toggle="tab" href="#Stocks">Stocks</a></li>
    </ul>

    <div class="panel panel-default">
        <div class="panel-body">

            <div class="tab-content">
                <div id="Detalle" class="tab-pane active">

                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>${producto.nombre}</th>
                                </tr>
                            </tbody>
                        </table>

                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Costo</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>${producto.costo}</th>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div id="Ventas" class="tab-pane">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Fecha de la Venta</th>
                                <th>Total</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ventas}" var="venta">
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
                                                    value="${venta.fecha}" /></td>
                                <td><c:out value="${venta.total}"></c:out></td>
                                <td><a onclick="deleteVenta(${venta.id})">
                                    <i class="fas fa-trash-alt menuIcon"></i>
                                </a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>

                <div id="Stocks" class="tab-pane">
                    <table class="table table-striped table-bordered table-hover"
                           id="dataTables-example" style="width: 100%">
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
            </div>
        </div>
    </div>
</div>

<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive : true
        });

    });
</script>
<!-- para que ande la tabla  -->