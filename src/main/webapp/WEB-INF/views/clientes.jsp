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
                    <div class="panel-heading">
                        DataTables Advanced Tables
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>nombre</th>
                                <th>apellido</th>
                                <th>fecha de nacimiento</th>
                                <th>telefono</th>
                                <th>direccion</th>
                                <th>email</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${clientes}" var="cliente">
                               <tr class="odd gradeX">
                                   <td><c:out value="${cliente.id}"></c:out></td>
                                   <td><c:out value="${cliente.nombre}"></c:out></td>
                                   <td><c:out value="${cliente.apellido}"></c:out></td>
                                   <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.fecha_de_nacimiento}" /></td>
                                   <td><c:out value="${cliente.telefono}"></c:out></td>
                                   <td><c:out value="${cliente.direccion}"></c:out></td>
                                   <td><c:out value="${cliente.email}"></c:out></td>
                                   <spring:url value="/clientes/${cliente.id}/editar" var="urlEditCliente"/>
                                   <td><a href="${urlEditCliente}" >Editar cliente</a></td>
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
