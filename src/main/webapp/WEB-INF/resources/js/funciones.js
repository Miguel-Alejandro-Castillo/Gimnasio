/**
 * Created by Alejandro on 2/4/2018.
 */

function submitAjax() {
    var data = {};
    data["newDia"] = $("#newDia").val();
    data["newHorario"] = $("#newHorario").val();
    data["newProfesor"] = $("#newProfesor").val();
    if(data.newDia.length > 0 && data.newHorario.length > 0 && data.newProfesor.length > 0){
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "addDiaHorarioProfesor",
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            success: function (diaHorarioProfesor) {
                $('#tablaDiasHorariosDias').append("<tr><td>"+diaHorarioProfesor.dia+"</td>"+
                "<td>"+diaHorarioProfesor.horario.hora_inicio+" hs a "+diaHorarioProfesor.horario.hora_fin+" hs</td>"+
                "<td>"+diaHorarioProfesor.profesor.nombre+" "+diaHorarioProfesor.profesor.apellido+"</td></tr>");
            },
            error: function (e) {

            }
        });
    }



}