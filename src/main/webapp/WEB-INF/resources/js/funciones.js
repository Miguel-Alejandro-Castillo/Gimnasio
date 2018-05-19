/**
 * Created by Alejandro on 2/4/2018.
 */

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

function cargarGraficoResumenAnual(){

    $.ajax({
        type: "GET",
        url: '/resumen/cargarGraficoResumenAnual',
        timeout: 600000,
        success: function (ganancias) {
            ganancias = ganancias.map(function(ganancia){
                return ganancia[1];
            });
            var myConfig = {
                type: "bar3d",
                scaleX: {
                    label:{
                        text:"Resumen anual"
                    },
                    labels:["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
                },
                series: [
                    {
                        values:ganancias
                    }
                ]
            };

            zingchart.render({
                id : 'morris-bar-chart',
                data : myConfig,
                height: "70%",
                width: "100%"
            });

        },
        error: function (e) {
        }
    });

}
