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
                                <form:form id="pagoForm" modelAttribute="pagoBean" action="${urlActual}" method="post" role="form">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="fecha_hasta">Fecha Hasta</form:label>
                                            <form:input type="date" path="fecha_hasta"  cssClass="form-control"/>
                                            <form:errors path="fecha_hasta" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="fecha_hasta">Fecha Hasta</form:label>
                                            <form:input type="date" path="fecha_hasta"  cssClass="form-control"/>
                                            <form:errors path="fecha_hasta" cssClass="error"/>
                                        </div>
	                                    <div class="form-group">
	                                    	<select id="actividad" name="actividad" required>
	                                        <option>Seleccione el ID de la actividad</option>
	                                        <c:forEach items="${actividades}" var="idActividad">
	                                        	<option value="${actividad}">${actividad}</option>
	                                        </c:forEach>
	                                        </select>                                  	          	                                                                      
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
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
