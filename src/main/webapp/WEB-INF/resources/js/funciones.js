/**
 * Created by Alejandro on 2/4/2018.
 */
var vm = {};

function getUrlContextPath() {
    return window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function getMoneyString(number){
    return number.toLocaleString('es-ar', {
                                           style: 'currency',
                                           currency: 'ARS',
                                           minimumFractionDigits: 2});
}

function getLocalDateString(date){
    return (new Date(date)).toLocaleDateString('es-ar');
}

function getLocalDateTimeString(date){
    return (new Date(date)).toLocaleString('es-ar');
}

function GET(url, functionSuccess, functionError){
    $.ajax({
        type: "GET",
        url: getUrlContextPath() + url,
        data: {},
        contentType: "application/json",
        dataType: 'json',
        //timeout de 2 minutos
        timeout: 1000 * 120,
        success: functionSuccess,
        error: functionError
    });
}

function completarPago(idCliente, idPago){
    GET("/clientes/" + idCliente  + "/completarPago/" + idPago,
         function(isCompletePago){
             if(isCompletePago) {
                 GET("/clientes/" + idCliente + "/getMontoAPagar/" + idPago,
                     function (montoTotalAPagar) {
                         if(!isNaN(montoTotalAPagar)){
                             $("#montoPagado_" + idPago).html(getMoneyString(montoTotalAPagar));
                             $("#completarPago_" + idPago).hide();
                         }
                     });
             }
         });
}

function changeActividad(){
    var  idActividad = $("#actividad").val();
    if( idActividad ){
        $.ajax({
            type: "GET",
            url: getUrlContextPath() + "/actividades/" + idActividad +"/monto",
            timeout: 600000,
            success: function (monto) {
               $("#montoAPagar").val(monto);
            },
            error: function (e) {
            }
        });
    }
}

function deletePagoCliente(idCliente, idPago){
    $.confirm({
        title: 'Confirmar borrado',
        content: 'Esta seguro que desea borrar este Pago?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/clientes/' + idCliente + '/delete_pago/' + idPago ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'El Pago se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        $('#row_' + idPago).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Pago no se ha eliminado correctamente.'});
                        }
                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteProfesor(idProfesor){
    $.confirm({
        title: 'Confirmar borrado',
        content: 'Esta seguro que desea borrar este Profesor?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/profesores/' + idProfesor + '/delete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'El Profesor se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        $('#row_' + idProfesor).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Profesor no se ha eliminado correctamente.'});
                        }
                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteCliente(idCliente){
    $.confirm({
        title: 'Confirmar borrado',
        content: 'Esta seguro que desea borrar este Cliente?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/clientes/' + idCliente + '/delete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'El Cliente se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                       $('#row_'+idCliente).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Cliente no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}
function venderProducto(idProducto){
    $.confirm({
        title: 'Confirmar Venta',
        content: '¿Registrar la venta de una unidad del producto?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "POST",
                    url: getUrlContextPath() +  '/productos/' + idProducto + '/venta' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (success) {
                        if( success ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'La venta se registro correctamente'
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'la venta no se realizo'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}
function deleteProducto(idProducto){
    $.confirm({
        title: 'Confirmar borrado',
        content: '¿Esta seguro que desea borrar este Producto?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/productos/' + idProducto + '/delete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'El Producto se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        $('#row_'+idProducto).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Producto no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteVenta(idVenta){
    $.confirm({
        title: 'Confirmar borrado',
        content: '¿Esta seguro que desea borrar esta Venta?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/' + idVenta + '/deleteVenta' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'La Venta se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        $('#row_'+idVenta).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Venta no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteStock(idStock){
    $.confirm({
        title: 'Confirmar borrado',
        content: '¿Esta seguro que desea borrar este Stock?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() + '/' + idStock + '/stockDelete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'El Stock se ha eliminado correctamente.',
                                buttons: {

                                    ok: function(){
                                        $('#row_'+idStock).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'El Stock no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteLeccion(idActividad, idLeccion, row){
    $.confirm({
        title: 'Confirmar borrado',
        content: '¿Esta seguro que desea borrar esta Leccion?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/actividades/' + idActividad + '/leccion/' + idLeccion + '/delete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'La Leccion se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        var table = $('#tableLecciones').DataTable();
                                        table.row(row).remove().draw();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'La Leccion no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function deleteActividad(idActividad){
    $.confirm({
        title: 'Confirmar borrado',
        content: '¿Esta seguro que desea borrar esta Actividad?',
        buttons: {
            aceptar: function () {
                $.ajax({
                    type: "DELETE",
                    url: getUrlContextPath() +  '/actividades/' + idActividad + '/delete' ,
                    data: {},
                    contentType: "application/json",
                    dataType: 'json',
                    success: function (isDelete) {
                        if( isDelete ){
                            $.alert({
                                title: 'Operacion exitosa',
                                content: 'La Actividad se ha eliminado correctamente.',
                                buttons: {
                                    ok: function(){
                                        $('#row_' + idActividad).remove();
                                    }
                                }
                            });
                        }
                        else{
                            $.alert({ title: 'Operacion fallida', content: 'La Actividad no se ha eliminado correctamente.'});
                        }

                    },
                    error: function (e) {
                        $.alert('Ha ocurrido un error en el servidor.');
                    }
                });
            },
            cancelar: function () {
            }
        }
    });
}

function submitAjax(url) {
    var data = {};
    data["newDia"] = $("#newDia").val();
    data["newHorario"] = $("#newHorario").val();
    data["newProfesor"] = $("#newProfesor").val();
    if(data.newDia.length > 0 && data.newHorario.length > 0 && data.newProfesor.length > 0){
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            success: function (response) {
                switch(response.messageResponse) {
                    case 'success':
                        var diaHorarioProfesor = response.objectResponse;
                        $('#tabla-actividades').append("<tr><td>"+diaHorarioProfesor.dia+"</td>"+
                        "<td>"+diaHorarioProfesor.horario.hora_inicio+" hs a "+diaHorarioProfesor.horario.hora_fin+" hs</td>"+
                        "<td>"+diaHorarioProfesor.profesor.nombre+" "+diaHorarioProfesor.profesor.apellido+"</td></tr>");
                        break;
                    case "failure.diaHorarioProfesor.existente":
                        alert('El registro ya éxiste');
                        break;
                }

            },
            error: function (e) {
            }
        });
    }



}

function cargarListadoResumen(){
    var mes = $("#mes").val();
    var anio = $("#anio").val();
    var idActividad = $("#idActividad").val();
    var urlCompleta = getUrlContextPath() + "/resumen/cargarListadoResumen?" + "mes=" +  mes + "&anio=" + anio + "&idActividad=" + idActividad;
    $('#dataTables-resumen').DataTable( {
        "processing": true,
        destroy: true,
        "ajax": urlCompleta,
        columnDefs: [
            { type: 'date-euro', targets: [0, 5, 6] },
        ],
        "columns": [
            { "data": "momentoPago",
                "render": function ( data, type, row ) {
                        return getLocalDateTimeString(data);
                }
            },
            { "data": "cliente" },
            { "data": "actividad" },
            { "data": "montoAPagar",
               "render": function ( data, type, row ) {
                    return getMoneyString(data);
                }
            },
            { "data": "montoPagado",
                "render": function ( data, type, row ) {
                    return getMoneyString(data);
                }
            },
            { "data": "fechaDesde",
                "render": function ( data, type, row ) {
                        return getLocalDateString(data);
                }
            },
            { "data": "fechaHasta",
                "render": function ( data, type, row ) {
                        return getLocalDateString(data);
                }
            }
        ]
    } );

}

function cargarListadoVentasProductos(){
    var mes = $("#mes").val();
    var anio = $("#anio").val();
    var urlCompleta = getUrlContextPath() + "/productosVentas?" + "mes=" +  (mes ? mes : "") + "&anio=" + (anio ? anio : "");
    window.location = urlCompleta;
}

function cargarGraficoResumen(){
    var mes = $("#mes").val();
    var anio = $("#anio").val();
    var idActividad = $("#idActividad").val();
    var urlCompleta = "/resumen/cargarGraficoResumen?" + "mes=" +  mes + "&anio=" + anio + "&idActividad=" + idActividad;

    GET(urlCompleta, function (resultado) {
        var labels = resultado.map(function(elem){
            return elem[0];
        });

        var  ganancias = resultado.map(function (elem) {
            return elem[1];
        });

        var totalRecaudado = ganancias.reduce(function(total, ganancia){
            return total + ganancia;
        }, 0);

        var myConfig = {
            type: "bar",
            scaleX: {
                label: {
                    text: "Resumen"
                },
                labels: labels
            },
            series: [
                {
                    values: ganancias
                }
            ]
        };

        zingchart.render({
            id: 'graficoBarras',
            data: myConfig,
            height: "70%",
            width: "100%"
        });

        $("#totalRecaudado").html("<span> Total recaudado: " + getMoneyString(totalRecaudado) + "</span>");

    });

}

function cargarResumen(){
    cargarGraficoResumen();
    cargarListadoResumen();
}

function loadPopupAddLeccion(idActividad){
    $.ajax({
        type: "GET",
        url: getUrlContextPath() + "/actividades/" + idActividad + "/editar/agregarLeccionPopup",
        //timeout de 2 minutos
        timeout: 1000 * 120,
        success: function(page){
            $("#agregarLeccion").html(page);
        },
        error: undefined
    });
}

function resetForm(form){
    //Clear errores
    $(form).parsley().reset();
    //Clear inputs
    $(form).trigger('reset');
}

function submitAddLeccionPopup(idActividad){
    /*  Submit form using Ajax */
    $.post({
        url : getUrlContextPath() + '/actividades/' + idActividad + '/editar/agregarLeccionPopup',
        data : $('#addLeccionForm').serialize(),
        success : function(response) {

            if(jQuery.isEmptyObject( response.errores )){
                var leccionAgregada = response.data;
               //Ocultar modal
               $('#modalAgregarLeccion').modal('toggle');
                //Agregar row en la tabla
                var table = $('#tableLecciones').DataTable();
                table.row.add( [ leccionAgregada.dia, leccionAgregada.horaInicio, leccionAgregada.horaFin,
                                 "<a onclick=\"deleteLeccion(" + idActividad + ", " + leccionAgregada.id + ", $(this).parent().parent())\"><i class=\"fas fa-trash-alt\" style=\"font-size: 24px; padding-right: 5px; padding-left: 5px;\"></i> </a>"] ).draw();

                //Limpiar inputs del formulario de la ventana modal
                resetForm('#addLeccionForm');

            }else{
                //Remove all errors
                $('form[name=addLeccionPopup] :input').next().remove();
                //Set error messages
                $.each(response.errores,function(key,value){
                    $('#addLeccionForm #' +key+']').after('<span class="error">'+value+'</span>');
                });
            }
        }
    });

}
function addLeccionPopup(idActividad) {

        $('#addLeccionForm').parsley({
            trigger: 'change',
            successClass: 'has-success',
            errorClass: 'has-error',
            classHandler: function(el) {
                return el.$element.closest(".form-group");
            },
            errorsContainer: function(el) {
                return el.$element.closest('.form-group');
            },
            errorsWrapper: '<span class="help-block"></span>',
            errorTemplate: "<span></span>"
        }).on('form:submit', function () {
            submitAddLeccionPopup(idActividad);
            return false; // Don't submit form for this demo
        });
}

function editActividadModal(idActividad){
    $('#editActividadForm').parsley({
        trigger: 'change',
        successClass: 'has-success',
        errorClass: 'has-error',
        classHandler: function(el) {
            return el.$element.closest(".form-group");
        },
        errorsContainer: function(el) {
            return el.$element.closest('.form-group');
        },
        errorsWrapper: '<span class="help-block"></span>',
        errorTemplate: "<span></span>"
    }).on('form:submit', function () {
        submitEditActividadModal(idActividad);
        return false; // Don't submit form for this demo
    });
}

function submitEditActividadModal(idActividad){
    /*  Submit form using Ajax */
    vm.actividad.nombre = $('form[name=editActividadForm] input[name=nombre]').val();
    vm.actividad.costo = $('form[name=editActividadForm] input[name=costo]').val();
    var profesorId = parseFloat($('form[name=editActividadForm] select[name=profesor]').val());
    vm.actividad.profesor = vm.profesores.find(function(profesor){ return profesor.id = profesorId; });

    $.ajax({
        type: "POST",
        url: getUrlContextPath() + '/actividades/' + idActividad + '/edit',
        data: JSON.stringify(vm.actividad),
        contentType: "application/json",
        dataType: 'json',
        //timeout de 1 minutos
        timeout: 1000 * 60,
        success: function (response) {
                if(jQuery.isEmptyObject( response.errores )){
                    window.location.href =  getUrlContextPath() + '/actividades/' + idActividad + '/detalle';
                }
        }, error: function(error){
            alert(error);
        }
    });

}


function loadFormEditActividad(idActividad){
    $.getJSON(getUrlContextPath() + "/actividades/" + idActividad + "/get", function(actividad) {
        if(actividad) {
            vm.actividad = actividad;
            $("form[name=editActividadForm] :input").each(function () {
                input = $(this);
                input.val(actividad[input.attr('name')]);
            });

            var selectProfesor = $("form[name=editActividadForm] select[name=profesor]");
            selectProfesor.empty();
            selectProfesor.append("<option value=''> Seleccione un profesor </option>");

            $.getJSON(getUrlContextPath() + "/profesores/get", function (profesores) {
                vm.profesores = profesores;
                profesores.forEach(function (profesor) {
                    selectProfesor.append("<option value=" + profesor.id + " >" + profesor.apellido + ", " + profesor.nombre + "</option>");
                });
                selectProfesor.val(actividad.profesor.id);
            });
        }
    });
}