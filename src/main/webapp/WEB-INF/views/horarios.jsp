<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>hora inicio</th>
                                <th>hora fin</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${horarios}" var="horario">
                               <tr class="odd gradeX">
                                   <td><c:out value="${horario.id}"></c:out></td>
                                   <td><c:out value="${horario.hora_inicio}"></c:out></td>
                                   <td><c:out value="${horario.hora_fin}"></c:out></td>
                                   <spring:url value="/horarios/${horario.id}/editar" var="urlEditHorario"/>
                                   <td><a href="${urlEditHorario}" >Editar Horario</a></td>
                               </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- /.table-responsive -->

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
