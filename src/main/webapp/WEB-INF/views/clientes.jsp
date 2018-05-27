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
                        <table  class="table table-striped table-bordered table-hover">
                        
                            <thead>
                            	<tr>
	                                <th>nombre</th>
	                                <th>apellido</th>
	                                <th>dni</th>
                                    <th>accion</th>
                            	</tr>
                            </thead>
                        
                            <tbody>
							<c:forEach items="${clientes}" var="cliente">
									<tr>
										<td><c:out value="${cliente.nombre}"></c:out></td>
										<td><c:out value="${cliente.apellido}"></c:out></td>
										<td><c:out value="${cliente.dni}"></c:out></td>
										<td>
											<spring:url value="/clientes/${cliente.id}/clienteDetalle" var="urlClienteDetalle"/>
                                            <a href="${urlClienteDetalle}"data-toggle="tooltip" title="Detalle" ><i class="fa fa-info-circle" style="font-size:24px;color:blue"></i></a>
                                            <spring:url value="/pagar/${cliente.id}/pagar" var="urlPagar"/>
                                            <a href="${urlPagar}" data-toggle="tooltip" title="Pagar"><i class="fa fa-dollar" style="font-size:24px;color:green"></i></a>                        
                                        </td>
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

