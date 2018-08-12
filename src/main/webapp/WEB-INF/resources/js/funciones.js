/**
 * Created by Alejandro on 2/4/2018.
 */
function changeActividad(){
    var  idActividad = $("#actividad").val();
    if( idActividad ){
        $.ajax({
            type: "GET",
            url: window.location.origin + "/actividades/"+ idActividad +"/monto",
            timeout: 600000,
            success: function (monto) {
               $("#monto").val(monto);
            },
            error: function (e) {
            }
        });
    }
}

function deleteActividad(urlDelete){
    $.confirm({
        title: 'Confirmar borrado',
        content: 'Esta seguro que desea borrar esta actividad?',
        buttons: {
            confirm: function () {
                $.ajax({
                    type: "DELETE",
                    url: urlDelete,
                    data: {},
                    dataType: 'json',
                    success: function (response) {
                        if(response == "succes"){
                            $.alert('La actividad se ha eliminado correctamente.');
                        }
                        else{
                            $.alert('La actividad no se ha eliminado correctamente.');
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            },
            cancel: function () {
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

function cargarGraficoResumen(url){
    var mes = $("#mes").val();
    var anio = $("#anio").val();
    var idActividad = $("#idActividad").val();
    var urlCompleta =  url;
    if(mes == "") {
        urlCompleta = urlCompleta + "cargarGraficoResumenAnual?" + "anio=" + anio + "&idActividad=" + idActividad;
        $.ajax({
            type: "GET",
            url: urlCompleta,
            timeout: 600000,
            success: function (ganancias) {
               var  ganancias = ganancias.map(function (ganancia) {
                    return ganancia[1];
                });
                var totalRecaudado = ganancias.reduce(function(total, ganancia){
                  return total + ganancia
                }, 0);
                var myConfig = {
                    type: "bar",
                    scaleX: {
                        label: {
                            text: "Resumen anual"
                        },
                        labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
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

                $("#totalRecaudado").html("<span> Total recaudado: " + totalRecaudado.toLocaleString('es-ar', {
                    style: 'currency',
                    currency: 'ARS',
                    minimumFractionDigits: 2
                }) + "</span>");

            },
            error: function (e) {
            }
        });
    }
    else{
        urlCompleta = urlCompleta + "cargarGraficoResumenMensual?" + "anio=" + anio + "&mes=" + mes + "&idActividad=" + idActividad;
        $.ajax({
            type: "GET",
            url: urlCompleta,
            timeout: 600000,
            success: function (ganancias) {
                var labels = ganancias.map(function (ganancia) {
                    return ganancia[0];
                });
                var series = ganancias.map(function (ganancia) {
                    return ganancia[1];
                });

                var totalRecaudado = series.reduce(function(total, ganancia){
                    return total + ganancia
                }, 0);
                var myConfig = {
                    type: "bar3d",
                    scaleX: {
                        label: {
                            text: "Resumen Mensual"
                        },
                        labels: labels
                    },
                    series: [
                        {
                            values: series
                        }
                    ]
                };

                zingchart.render({
                    id: 'graficoBarras',
                    data: myConfig,
                    height: "70%",
                    width: "100%"
                });

                $("#totalRecaudado").html("<span> Total recaudado: " + totalRecaudado.toLocaleString('es-ar', {
                    style: 'currency',
                    currency: 'ARS',
                    minimumFractionDigits: 2
                }) + "</span>");

            },
            error: function (e) {
            }
        });
    }


}
