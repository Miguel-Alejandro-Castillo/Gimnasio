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
                                <th>nombre</th>
                                <th>costo</th>
                            </tr>
                        </thead>
                            
                        <tbody>
                            <c:forEach items="${actividades}" var="actividad">
                                <tr class="odd gradeX">
                                    <td><c:out value="${actividad.id}"></c:out></td>
                                    <td><c:out value="${actividad.nombre}"></c:out></td>
                                    <td><c:out value="${actividad.costo}"></c:out></td>
                                    <spring:url value="/actividades/${actividad.id}/editar" var="urlEditActividad"/>
                                    <td><a href="${urlEditActividad}">Editar actividad</a></td>
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
