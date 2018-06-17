<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><tiles:getAsString name="title"/></h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Costo</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                            
                        <tbody>
                            <c:forEach items="${actividades}" var="actividad">
                                <tr class="odd gradeX">
                                    <td><c:out value="${actividad.nombre}"></c:out></td>
                                    <td><c:out value="${actividad.costo}"></c:out></td>
                                    <spring:url value="/actividades/${actividad.id}/editar" var="urlEditActividad"/>
                                    <td><a href="${urlEditActividad}"><i class="fa fa-gears" style="font-size:24px;padding-right:10px;padding-left:10px;"></i></a></td>
                                    
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->

	<spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>    
    <script src="${jqueryMin}"></script>
    
   	<script>
   	$(document).ready(function(){
	   $('#dataTables-example').DataTable(
	      		{
	      				responsive: true,
	      				"paging":   false,
	      			    "ordering": false,
	      			    "info":     false
	      		});
   	});
   	</script>
	<!-- para que ande la tabla  -->


