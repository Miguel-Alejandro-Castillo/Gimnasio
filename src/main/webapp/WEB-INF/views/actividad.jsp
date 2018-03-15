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

             <select id="dia" name="dia" required>
                 <option>Seleccione un dia</option>
                 <c:forEach items="${dias}" var="dia">
                     <option value="${dia}">${dia}</option>
                 </c:forEach>
             </select>
             <select id="horario" name="horario" >
                 <option>Seleccione un horario</option>
                 <c:forEach items="${horarios}" var="horario">
                     <option value="${horario.id}">${horario.hora_inicio} hs a ${horario.hora_fin} hs</option>
                 </c:forEach>
             </select>
            <select id="profesor" name="profesor" >
                <option>Seleccione un profesor</option>
                <c:forEach items="${profesores}" var="profesor">
                    <option value="${profesor.id}">${profesor.nombre} ${profesor.apellido}</option>
                </c:forEach>
            </select>
            <button type="submit" value="Agregar" >Agregar</button>
            <table id="tablaDiasHorariosDias">
                <thead>
                <tr>
                    <th>dia</th>
                    <th>horario</th>
                    <th>profesor</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${diasHorariosProfesores}" var="diaHorarioProfesor">
                    <tr class="odd gradeX">
                        <td><c:out value="${diaHorarioProfesor.dia}"></c:out></td>
                        <td><c:out value="${diaHorarioProfesor.horario.hora_inicio} hs a ${diaHorarioProfesor.horario.hora_fin} hs"></c:out></td>
                        <td><c:out value="${diaHorarioProfesor.profesor.nombre} ${diaHorarioProfesor.profesor.apellido}"></c:out></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</div>
<!-- /#page-wrapper -->



