<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>


<div class="well">

    <h1 class="page-header">
        <tiles:getAsString name="title" />
    </h1>

    <div class="panel panel-default">
        <div class="panel-body">
            <spring:url value="" var="urlActual" />
            <form:form id="productoForm" modelAttribute="producto"
                       action="${urlActual}" method="post" role="form">
                <div class="row">
                    <div class="col-lg-6">
                        <form:hidden path="id" />
                        <div class="form-group">
                            <form:label path="nombre">Nombre*</form:label>
                            <form:input path="nombre" cssClass="form-control"
                                        autofocus="autofocus" />
                            <form:errors path="nombre" cssClass="error" />
                        </div>
                        <div class="form-group">
                            <form:label path="costo">Costo*</form:label>
                            <form:input path="costo" cssClass="form-control" />
                            <form:errors path="costo" cssClass="error" />
                        </div>

                        <form:button type="submit" class="btn panelButton" >
                            <tiles:getAsString name="titleSubmit" />
                        </form:button>
                    </div>
                    <!-- boton -->
                </div>
                <!-- segunda columna -->
            </form:form>
        </div>
    </div>
</div></div>

