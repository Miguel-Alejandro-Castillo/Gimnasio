<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>

<div class="row">
    <div class="col-lg-9">
        <h1 class="page-header">
            <tiles:getAsString name="title" />
        </h1>
    </div>
    <div class="col-lg-3">
        <a href="/productos">
            <button class="btn upperButton"><i class="fas fa-arrow-right"></i> Lista de Productos</button>
        </a>
    </div>

</div>
    <div class="well">
        stock.jsp

    <div class="panel panel-default">
        <div class="panel-body">
            <spring:url value="/productos/registrarStock" var="urlActual" />
            <form:form id="stockForm" modelAttribute="stock"
                       action="${urlActual}" method="post" role="form">
                <div class="row">
                    <div class="col-lg-6">
                        <form:hidden path="id" />
                        <form:hidden path="producto.id" />
                        <div class="form-group">
                            <form:label path="cantidadRecibida">cantidadRecibida*</form:label>
                            <form:input path="cantidadRecibida" cssClass="form-control"
                                        autofocus="autofocus" />
                            <form:errors path="cantidadRecibida" cssClass="error" />
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <form:button type="submit" class="btn panelButton" >
                                    <tiles:getAsString name="titleSubmit" />
                                </form:button>
                            </div>
                        </div>

                    </div>
                    <!-- boton -->
                </div>
                <!-- segunda columna -->
            </form:form>
        </div>
    </div>
    </div>
</div>

