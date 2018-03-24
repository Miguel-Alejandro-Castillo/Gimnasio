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
            <spring:url value="" var="urlActual"/>
            <form:form id="actividadForm" modelAttribute="actividadBean" action="${urlActual}" method="post" role="form">
            <div  class="row" >
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
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

            <div class="row">

                <form:select path="newDia">
                    <form:option value="" label="Seleccione un dia"/>
                    <form:options items="${dias}"  />
                </form:select>

                    <form:select path="newHorario">
                        <form:option value="${null}" label="Seleccione un horario"/>
                        <form:options items="${horarios}" itemValue="id" />
                    </form:select>


                    <form:select path="newProfesor">
                        <form:option value="${null}" label="Seleccione un profesor"/>
                        <form:options items="${profesores}" itemValue="id" />
                    </form:select>

                    <button onclick="alert('Elemento agregado')">Agregar</button>
            <table id="tablaDiasHorariosDias">
                <thead>
                <tr>
                    <th>dia</th>
                    <th>horario</th>
                    <th>profesor</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${actividadBean.diasHorariosProfesores}" var="diaHorarioProfesor">
                    <tr class="odd gradeX">
                        <td><c:out value="${diaHorarioProfesor.dia}"></c:out></td>
                        <td><c:out value="${diaHorarioProfesor.horario.hora_inicio} hs a ${diaHorarioProfesor.horario.hora_fin} hs"></c:out></td>
                        <td><c:out value="${diaHorarioProfesor.profesor.nombre} ${diaHorarioProfesor.profesor.apellido}"></c:out></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <!-- /.row -->
            <form:button type="submit" class="btn btn-default"><tiles:getAsString name="titleSubmit"/></form:button>
            </form:form>

    </div>

</div>
<!-- /#page-wrapper -->


