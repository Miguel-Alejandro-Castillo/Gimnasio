	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <div class="row">
                                <div class="col-lg-6">
                                <spring:url value="" var="urlActual"/>
                                <form:form id="clienteForm" modelAttribute="clienteBean" action="${urlActual}" method="post" role="form">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="nombre">Nombre*</form:label>
                                            <form:input path="nombre"  cssClass="form-control" autofocus="autofocus"/>
                                            <form:errors path="nombre" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="apellido">Apellido*</form:label>
                                            <form:input path="apellido"  cssClass="form-control"/>
                                            <form:errors path="apellido" cssClass="error"/>
                                        </div>

                                    <div class="form-group">
                                        <form:label path="dni">DNI*</form:label>
                                        <form:input type="number" path="dni"  cssClass="form-control"/>
                                        <form:errors path="dni" cssClass="error"/>
                                    </div>
                                        <div class="form-group">
                                          <form:label path="fecha_de_nacimiento">Fecha de nacimiento*</form:label>
                                          <form:input type="date" path="fecha_de_nacimiento"  cssClass="form-control"/>
                                          <form:errors path="fecha_de_nacimiento" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="telefono">Telefono*</form:label>
                                            <form:input  path="telefono"  cssClass="form-control"/>
                                            <form:errors path="telefono" cssClass="error"/>
                                        </div>
                                       <div class="form-group">
                                           <form:label path="direccion">Direccion*</form:label>
                                           <form:input  path="direccion"  cssClass="form-control"/>
                                           <form:errors path="direccion" cssClass="error"/>
                                        </div>
                                    <div class="form-group">
                                        <form:label path="email">Email</form:label>
                                        <form:input  path="email"  cssClass="form-control"/>
                                        <form:errors path="email" cssClass="error"/>
                                    </div>
                                        <form:button type="submit" class="btn btn-default"><tiles:getAsString name="titleSubmit"/></form:button>
                                    </form:form>
                                </div>
                                
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->                
	                <div class="panel-body">
	                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<td>Momento Pago</td>
									<td>Cliente</td>
									<td>Actividad</td>
									<td>Fecha Desde</td>
									<td>Fecha Hasta</td>
								</thead>
								<tbody>
									<c:forEach items="${clienteBean.pagos}" var="pago">
										<tr class="odd gradeX">
											<td><c:out value="${pago.momento_pago}"></c:out></td>
											<td><c:out value="${pago.actividad.nombre}"></c:out></td>
											<td><c:out value="${pago.fecha_desde}"></c:out></td>
											<td><c:out value="${pago.fecha_hasta}"></c:out></td>
											<td><c:out value="${pago.monto}"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
	                        </table>
	                </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
