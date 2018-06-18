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
                                <form:form id="pagoForm" modelAttribute="pago" action="${urlActual}" method="post" role="form" novalidate="novalidate">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="fechaDesde">Fecha Desde(*)</form:label>
                                            <form:input type="date" path="fechaDesde"  cssClass="form-control"/>
                                            <form:errors path="fechaDesde" cssClass="errorMessage"/>
                                        </div>
                                        <div class="form-group">
                                           <form:label path="fechaHasta">Fecha Hasta(*)</form:label>
                                           <form:input type="date" path="fechaHasta"  cssClass="form-control"/>
                                           <form:errors path="fechaHasta" cssClass="errorMessage"/>
                                         </div>
	                                    <div class="form-group">
                                            <form:label path="actividad">Actividad(*)</form:label>
                                            <form:select path="actividad" cssClass="form-control">
                                                <form:option value="-1" label="Seleccione una actividad"/>
                                                <form:options items="${actividades}" itemValue="id" itemLabel="nombre" />
                                            </form:select>
                                            <form:errors path="actividad" cssClass="errorMessage"/>
	                                    </div>                                                               
                                        <div class="form-group">
                                            <form:label path="monto">Monto(*)</form:label>
                                            <form:input type="number" path="monto" cssClass="form-control" min="0" step="0.01"/>
                                            <form:errors path="monto" cssClass="errorMessage"/>
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
