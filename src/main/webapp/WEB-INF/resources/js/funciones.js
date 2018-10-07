/**
 * Created by Alejandro on 2/4/2018.
 */

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

function submitAddLeccionPopup(idActividad){
    /*  Submit form using Ajax */
    $('button[type=submit]').click(function(e) {

        //Prevent default submission of form
        e.preventDefault();

        //Remove all errors
        $('input').next().remove();

        $.post({
            url : getUrlContextPath() + '/actividades/' + 1 + '/editar/agregarLeccionPopup',
            data : $('form[name=leccionForm]').serialize(),
            success : function(response) {

                if(response.errores == {}){
                    //Set response
                    $('#resultContainer pre code').text(JSON.stringify(res.employee));
                    $('#resultContainer').show();

                }else{
                    //Set error messages
                    $.each(response.errores,function(key,value){
                        $('#leccionForm #' +key+']').after('<span class="error">'+value+'</span>');
                    });
                }
            }
        })
    });
}
