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
                                <form:form id="actividadForm" modelAttribute="actividadBean" action="${urlActual}" method="post" role="form">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="nombreActividad">Nombre Actividad*</form:label>
                                            <form:input path="nombreActividad"  cssClass="form-control" autofocus="autofocus"/>
                                            <form:errors path="nombreActividad" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="profesor">Profesor*</form:label>
                                            <form:input path="profesor"  cssClass="form-control"/>
                                            <form:errors path="profesor" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                          <form:label path="costo">Costo*</form:label>
                                          <form:input path="costo"  cssClass="form-control"/>
                                          <form:errors path="costo" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="dia">Dia*</form:label>
                                            <form:input  path="dia"  cssClass="form-control"/>
                                            <form:errors path="dia" cssClass="error"/>
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
