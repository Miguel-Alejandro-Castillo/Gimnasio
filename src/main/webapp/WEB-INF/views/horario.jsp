<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
            
                <div class="col-lg-12">
                    <h1 class="page-header"><tiles:getAsString name="title"/></h1>
                </div>
                <!-- /.col-lg-12 -->
            
           
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                <spring:url value="" var="urlActual"/>
                                <form:form id="horarioForm" modelAttribute="horario" action="${urlActual}" method="post" role="form" novalidate="true">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="horaInicio">hora inicio</form:label>
                                            <form:input  path="horaInicio" type="time" cssClass="form-control" autofocus="autofocus"/>
                                            <form:errors path="horaInicio" cssClass="errorMessage"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="horaFin">hora fin</form:label>
                                            <form:input path="horaFin"  type="time" cssClass="form-control"/>
                                            <form:errors path="horaFin" cssClass="errorMessage"/>
                                        </div>
                                    <div class="form-group">
                                         <form:button  type="submit" class="btn btn-default"><tiles:getAsString name="titleSubmit"/></form:button>
                                         <spring:hasBindErrors name="horario">
                                              <c:forEach items="${errors.globalErrors}" var="error">
                                                 <br/><span class="errorMessage"> <spring:message code="${error.code}"/></span>
                                               </c:forEach>
                                         </spring:hasBindErrors>
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
        
        <!-- /#page-wrapper -->
