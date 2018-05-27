<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>
<script src="${jqueryMin}"></script>
<div id="page-wrapper">
	        <div class="row">
                <c:if test="${not empty success_pago}">
                    <div id="alert-pago" class="alert alert-success alert-dismissible fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>${success_pago}</strong>
                    </div>
                    <script>
                        $(document).ready (function(){
                            window.setTimeout(function() {
                                $("#alert-pago").fadeTo(1500, 0).slideUp(500, function(){
                                    $(this).hide();
                                });
                            }, 2500);
                        });
                    </script>
                </c:if>
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
                            	</tr>
                            </thead>
                        
                            <tbody>
							<c:forEach items="${clientes}" var="cliente">
									<tr class="parent">
										<td><c:out value="${cliente.nombre}"></c:out></td>
										<td><c:out value="${cliente.apellido}"></c:out></td>
										<td><c:out value="${cliente.dni}"></c:out></td>
									</tr>
									<tr class="child"> 
										<td>	    
											<spring:url value="/clientes/${cliente.id}/clienteDetalle" var="urlClienteDetalle"/>
											<a href="${urlClienteDetalle}" >Detalle cliente</a>
										</td>
										<td>
											<spring:url value="/clientes/${cliente.id}/pagar" var="urlPagar"/>
											<a href="${urlPagar}">Realizar pago</a>
										</td>
										<td>
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

