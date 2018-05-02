<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="page-wrapper">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">Resumen de Cuentas</h1>
	    </div>
	    <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
       
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Resumen del A&ntilde;o
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div id="morris-bar-chart" ></div>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->

    </div>
    <!-- /.row -->
    
    <div class="row">
    	<div class ="col-lg-12">
    	<table class="table table-condensed table-bordered">
    		<thead>
    			<tr>
					<th>Fecha Pago</th>
					<th>Cliente</th>
    				<th>Actividad</th>
    				<th>Monto</th>
					<th>Fecha desde</th>
					<th>Fecha hasta</th>
    			</tr>
    		</thead>
    		<tbody>

			<c:forEach items="${clientes}" var="cliente">
				<c:forEach items="${cliente.pagos}" var="pago">
					<tr class="odd gradeX">
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${pago.momento_pago}"/></td>
					<td><c:out value="${cliente.nombre} ${cliente.apellido}"></c:out></td>
					<td><c:out value="${pago.actividad.nombre}"></c:out></td>
					<td><fmt:formatNumber value="${pago.monto}" type="currency" currencySymbol=""/></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pago.fecha_desde}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pago.fecha_hasta}" /></td>
					</tr>
			   </c:forEach>
			</c:forEach>

    		</tbody>
    	</table>
    	</div>
    </div>



    <script>
		$(document).ready(function() {
			cargarGraficoResumenAnual();
		});
    </script>
   
</div>
<!-- /#page-wrapper -->





