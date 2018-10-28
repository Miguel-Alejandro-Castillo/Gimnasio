<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8"%>

<div class="col-lg-9">
    <div class="well">
        <div class="row">
            <h1 class="page-header">
                ${actividad.nombre}
            </h1>
        </div>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#Detalle">Detalle</a></li>
            <li><a data-toggle="tab" href="#Lecciones">Lecciones</a></li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-body">
               <div class="tab-content">
                    <div id="Detalle" class="tab-pane active">
                        <div class="row">
                            <div class="col-lg-7">
                                <label>Nombre:</label>
                                 <p class="form-control"><c:out value='${actividad.nombre}'/></p>
                                <label>Costo:</label>
                                <p class="form-control"><c:out value='${actividad.costo}'/></p>
                                <label>Profesor:</label>
                                <p  class="form-control"><c:out value='${actividad.profesor.apellido}, ${actividad.profesor.nombre}'/></p>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-backdrop="static" data-keyboard="false"  data-target="#editarActividad"
                                        onclick="loadFormEditActividad(${actividad.id});">
                                    editar
                                </button>
                                <div id="editarActividad" class="modal fade" role="dialog">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" onclick="resetForm('form[name=editActividadForm]');">&times;</button>
                                                <h3>Editar Actividad</h3>
                                            </div>
                                            <div class="modal-body">
                                                <form id="editActividadForm" name="editActividadForm"  data-parsley-validate="" method="post">
                                                        <input id="id" name="id" type="hidden">
                                                        <div class="form-group">
                                                            <label for="nombre">Nombre:</label>
                                                            <input id="nombre" name="nombre" class="form-control"
                                                                   required data-parsley-required-message="Este campo es obligatorio"/>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="costo">Costo:</label>
                                                            <input id="costo" name="costo" type="number" step="0.01" min="0.00" class="form-control"
                                                                   required data-parsley-required-message="Este campo es obligatorio"
                                                                   min="0.00" data-parsley-min-message="No se permiten numeros negativos"/>
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="profesor">Profesor:</label>
                                                            <select id="profesor" name="profesor" class="form-control"
                                                                    required data-parsley-required-message="Este campo es obligatorio"/>
                                                            </select>
                                                        </div>
                                                    <button type="submit" class="btn btn-success btn-block" onclick="editActividadModal(${actividad.id})">
                                                        Editar actividad
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  id="Lecciones" class="tab-pane">
                        <div class="row">
                            <div class="col-lg-7">
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
                                                       style="font-size: 24px; padding-right: 5px; padding-left: 5px;"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                    $(document).ready(function(){
                                        $('#tableLecciones').DataTable( { responsive: true, destroy: true});
                                    });
                                </script>
                            </div>
                            <div class="col-lg-2">
                                <button  type="button" class="btn btn-info btn-lg" data-toggle="modal" data-backdrop="static" data-keyboard="false" data-target="#modalAgregarLeccion">
                                    Agregar lección
                                </button>
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
                                                    <button type="submit" class="btn btn-success btn-block" onclick="addLeccionPopup(${actividad.id});">
                                                        Agregar lección
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
               </div>
            </div>
        </div>
    </div>
</div>
