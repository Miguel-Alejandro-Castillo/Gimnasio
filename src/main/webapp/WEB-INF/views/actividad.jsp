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


    <input id="tab1" type="radio" name="tabs" checked >
    <label  id="label1" class="label_tab" for="tab1">Datos basicos</label>
    <input id="tab2" type="radio" name="tabs" >
    <label   id="label2"   class="label_tab" for="tab2">Planificacion semanal</label>


    <div class="content">
            <div id="content1" class="row" >
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <spring:url value="" var="urlActual"/>
                                    <form:form id="actividadForm" modelAttribute="actividadBean" action="${urlActual}" method="post" role="form">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="nombre">Nombre*</form:label>
                                            <form:input path="nombre" cssClass="form-control" autofocus="autofocus"/>
                                            <form:errors path="nombre" cssClass="error"/>
                                        </div>

                                        <div class="form-group">
                                            <label for="costo">Costo*</label>
                                            <input type="number" id="costo" name="costo" step="0.01" min="1" class="form-control" value="${actividadBean.costo}"/>
                                            <form:errors path="costo" cssClass="error"/>
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


        <div id="content2" class="row">
            <p>
                London is the capital city of England and the United Kingdom. It is the most populous city in the United
                Kingdom, with a metropolitan area of over 13 million inhabitants. Standing on the River Thames, London
                has been a major settlement for two millennia, its history going back to its founding by the Romans, who
                named it Londinium.
            </p>

            <p>
                London's ancient core, the City of London, largely retains its 1.12-square-mile (2.9 km2) mediaeval
                boundaries and in 2011 had a resident population of 7,375, making it the smallest city in England. Since
                at least the 19th century, the term London has also referred to the metropolis developed around this
                core.
            </p>
        </div>

    </div>

</div>
<!-- /#page-wrapper -->



