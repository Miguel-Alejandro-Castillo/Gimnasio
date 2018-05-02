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
        success: function (response) {
            new Morris.Bar({
                element: 'morris-bar-chart',
                data: [

                    { y: 'Enero', a: response[0].total},
                    { y: 'Febrero', a: response[1].total },
                    { y: 'Marzo', a: response[2].total},
                    { y: 'Abril', a: response[3].total },
                    { y: 'Mayo', a: response[4].total },
                    { y: 'Junio', a: response[5].total },
                    { y: 'Julio', a: response[6].total },
                    { y: 'Agosto', a: response[7].total},
                    { y: 'Septiembre', a: response[8].total },
                    { y: 'Octubre', a: response[9].total },
                    { y: 'Noviembre', a: response[10].total },
                    { y: 'Diciembre', a: response[11].total }
                ],
                xkey: 'y',
                ykeys: ['a'],
                labels: ['Entrada:']


            });


        },
        error: function (e) {
        }
    });

}
