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
                    <spring:url value="" var="urlActual"/>
                    <form:form id="clienteForm" modelAttribute="clienteBean" action="${urlActual}" method="post" role="form">
                    <div class="col-lg-6">
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
                                <form:label path="email">Email</form:label>
                                <form:input  path="email"  cssClass="form-control"/>
                                <form:errors path="email" cssClass="error"/>
                            </div> 
                    </div>
                    <!-- primera columna -->
                    <div class="col-lg-6">
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
                        <div style="padding-top:16px;float:right;">
                    		<form:button type="submit" class="btn btn-primary btn-lg"><tiles:getAsString name="titleSubmit"/></form:button>
                        </div> 
                    </div>
                    <!-- segunda columna -->
				    </form:form>	
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