<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
<link href="${jqueryConfirmCss}" rel="stylesheet"/>


<div class="well">
    <div class="row">
        <h1 class="page-header">
            ${actividad.nombre}
        </h1>

        <spring:url value="/actividades" var="atras"/>
        <a href="${atras}">
            <button class="btn backButton"><i class="fas fa-arrow-left"></i> Atras</button>
        </a>

<!--
        <spring:url value="/actividades/${actividad.id}/editar" var="urlEditActividad"/>
        <a href="${urlEditActividad}">
            <i class="fas fa-edit" style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
        </a>
        <spring:url value="/actividades/${actividad.id}/editar/agregarLeccion" var="urlAgregarLeccion"/>
        <a href="${urlAgregarLeccion}">
            <i class="fas fa-user-plus" style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
        </a>

            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#agregarLeccion" onclick="loadPopupAddLeccion(${actividad.id})">
--!>
            <!-- Trigger the modal with a button -->
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#editarActividad">
                editar
            </button>
            <button  type="button" class="btn btn-info btn-lg" data-toggle="modal" data-backdrop="static" data-keyboard="false" data-target="#modalAgregarLeccion">

                agregar leccion
            </button>


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


            <div id="modalAgregarLeccion" class="modal face" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button id="buttonClosePopupAgregarLeccion" onclick="resetForm('#addLeccionForm')"
                                    type="button" class="close" data-dismiss="modal">
                                &times;
                            </button>
                            <h3>Agregar Leccion</h3>
                        </div>
                        <div class="modal-body">
                            <form id="addLeccionForm" name="addLeccionForm"  data-parsley-validate=""  method="post">
                                <div class="form-group">
                                      <label for="dia">Dia:</label>
                                     <select id="dia" name="dia" class="form-control" required
                                             data-parsley-required-message="Seleccione un dia">
                                        <option value="" selected>Seleccione un dia</option>
                                        <c:forEach items="${dias}" var="dia">
                                            <option value="${dia}"><c:out value="${dia}"/></option>
                                        </c:forEach>
                                     </select>
                                </div>
                                <div class="form-group">
                                    <label for="horaInicio">Hora Inicio:</label>
                                    <input id="horaInicio" class="form-control" name="horaInicio" type="time" required
                                           data-parsley-required-message="Ingrese un horario de inicio"
                                           data-parsley-hora-inicio=""/>
                                </div>
                                <div class="form-group">
                                    <label for="horaFin">Hora Fin:</label>
                                    <input id="horaFin" class="form-control" name="horaFin" type="time" required
                                           data-parsley-required-message="Ingrese un horario de fin"
                                           data-parsley-hora-fin="" />
                                </div>
                                <button type="submit" class="form-control btn btn-info btn-lg"  onclick="addLeccionPopup(${actividad.id});">
                                    Agregar leccion
                                </button>
                            </form>
                           <script>
                               $(function() {
                                   function validateHoraInicioHoraFin(){
                                       var horaInicio = $('#horaInicio').val();
                                       var horaFin = $('#horaFin').val();
                                       if(horaInicio && horaFin){
                                           return Date.parse('01/01/2011 ' + horaInicio + ':00') <= Date.parse('01/01/2011 ' + horaFin + ':00');
                                       }
                                       else{
                                           return true;
                                       }
                                   }
                                   window.Parsley.addValidator('horaInicio', {
                                       validateString: function (value) {
                                         return validateHoraInicioHoraFin();
                                       },
                                       messages: {
                                           en: 'La hora de inicio debe ser menor o igual a la hora de fin'
                                       }
                                   });
                                   window.Parsley.addValidator('horaFin', {
                                       validateString: function (value) {
                                           return validateHoraInicioHoraFin();
                                       },
                                       messages: {
                                           en: 'La hora de fin debe ser mayor o igual a la hora de inicio'
                                       }
                                   });
                               });
                            </script>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

    <div class="col-lg-6">
        <table id="tableLecciones" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>Dia</th>
                <th>Hora Inicio</th>
                <th>Hora Fin</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${actividad.lecciones}" var="leccion">
                <tr>
                    <td><c:out value="${leccion.dia}"></c:out></td>
                    <td><c:out value="${leccion.horaInicio}"></c:out></td>
                    <td><c:out value="${leccion.horaFin}"></c:out></td>
                    <td>
                        <a onclick="deleteLeccion(${actividad.id}, ${leccion.id}, $(this).parent().parent())">
                            <i class="fas fa-trash-alt"
                               style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    $(document).ready(function(){
        $('#tableLecciones').DataTable(
                {
                    responsive: true,
                    destroy: true
                });
    });
</script>

