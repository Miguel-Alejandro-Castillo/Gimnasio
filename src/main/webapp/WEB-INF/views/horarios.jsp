<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="page-wrapper">
        
            <div class="col-lg-12">
                <h1 class="page-header"><tiles:getAsString name="title"/></h1>
            </div>
            <!-- /.col-lg-12 -->
        
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>hora inicio</th>
                                <th>hora fin</th>
                                <th>acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${horarios}" var="horario">
                               <tr class="odd gradeX">
                                   <td><c:out value="${horario.horaInicio}"></c:out></td>
                                   <td><c:out value="${horario.horaFin}"></c:out></td>
                                   <spring:url value="/horarios/${horario.id}/editar" var="urlEditHorario"/>
                                   <td><a href="${urlEditHorario}" >Editar Horario</a></td>
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
  
    <!-- /#page-wrapper -->
   
	<spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>    
    <script src="${jqueryMin}"></script>
    
   	<script>
   	$(document).ready(function(){
	   $('#dataTables-example').DataTable(
	      		{
	      				responsive: true,
	      				"paging":   false,
	      				"searching": false,
	      			    "info":     false
	      			    
	      		});
   	});
   	</script>
	<!-- para que ande la tabla  --> 
