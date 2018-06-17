<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                            <form:form id="profesorForm" modelAttribute="profesorBean" action="${urlActual}" method="post" role="form">
                                <form:hidden path="id"/>
                                <div class="form-group">
                                    <form:label path="nombre">Nombre</form:label>
                                    <form:input path="nombre"  cssClass="form-control" autofocus="autofocus"/>
                                    <form:errors path="nombre" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="apellido">Apellido</form:label>
                                    <form:input path="apellido"  cssClass="form-control"/>
                                    <form:errors path="apellido" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                  <form:label path="fecha_de_nacimiento">Fecha de Nacimiento</form:label>
                                  <form:input type="date" path="fecha_de_nacimiento"  cssClass="form-control"/>
                                  <form:errors path="fecha_de_nacimiento" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="dni">DNI</form:label>
                                    <form:input path="dni" cssClass="form-control" autofocus="autofocus"/>
                                    <form:errors path="dni" cssClass="error"/>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <form:label path="telefono">Telefono</form:label>
                                    <form:input  path="telefono"  cssClass="form-control"/>
                                    <form:errors path="telefono" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                   <form:label path="direccion">Direccion</form:label>
                                   <form:input  path="direccion"  cssClass="form-control"/>
                                   <form:errors path="direccion" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="email">Email</form:label>
                                    <form:input  path="email" placeholder="opcional" cssClass="form-control"/>
                                    <form:errors path="email" cssClass="error"/>
                                <div style="padding-top:35px;float:right;">
                                    <form:button type="submit" class="btn btn-primary btn-lg"><tiles:getAsString name="titleSubmit"/></form:button>
                                </div>
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
</div>
