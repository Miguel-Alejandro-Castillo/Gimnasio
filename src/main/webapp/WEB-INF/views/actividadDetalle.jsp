<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="well">
    <div class="row">
        <h1 class="page-header">
            ${actividad.nombre}
        </h1>

        <spring:url value="/actividades" var="atras"/>
        <a href="${atras}">
            <button class="btn backButton"><i class="fas fa-arrow-left"></i> Atras</button>
        </a>

        <spring:url value="/actividades/${actividad.id}/editar" var="urlEditActividad"/>
        <a href="${urlEditActividad}">
            <i class="fas fa-edit" style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
        </a>
        <spring:url value="/actividades/${actividad.id}/editar/agregarLeccion" var="urlAgregarLeccion"/>
        <a href="${urlAgregarLeccion}">
            <i class="fas fa-user-plus" style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
        </a>


        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#editarActividad">
            editar
        </button>

        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#agregarLeccion">
            agregarleccion
        </button>

        <!-- Modal -->
        <div id="editarActividad" class="modal fade" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3>Editar Detalle</h3>
                    </div>
                    <div class="modal-body">
                        <form id="actividadForm" modelAttribute="actividad" action="" method="post" role="form">
                            <label>Nombre</label>
                            <input path="nombre" cssClass="form-control" autofocus="autofocus"/>
                            <label>Costo</label>
                            <input path="costo" type="number" step="0.01" min="1" cssClass="form-control"/>
                            <input type="submit" value="Finalizar">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div id="agregarLeccion" class="modal face" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3>Agregar Leccion</h3>
                    </div>
                    <div class="modal-body">
                        <form id="leccionForm" modelAttribute="leccion" action="" method="post" role="form" novalidate="novalidate" accept-charset="UTF-8">
                            <select id="dia" name="dia">
                                <c:forEach items="${dias}" var="dia">
                                    <option value="${dia.nombre}"><c:out value="dia.nombre"/></option>
                                </c:forEach>
                            </select>
                            <label>Hora Inicio</label>
                            <input path="leccion.horaInicio" type="time"/>
                            <label>Hora Fin</label>
                            <input path="leccion.horaFin" type="time"/>
                            <input type="submit" value="Finalizar">
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="col-lg-5">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <td>Dia</td>
            <td>Hora Inicio</td>
            <td>Hora Fin</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lecciones}" var="lecciones">
            <tr>
                <td><c:out value="${lecciones.dia}"></c:out></td>
                <td><c:out value="${lecciones.horaInicio}"></c:out></td>
                <td><c:out value="${lecciones.horaFin}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

