
function getTime(fecha_desde){
    var fecha1 = moment(new Date(fecha_desde), "YYYY-MM-DD HH:mm:ss");
    var fecha2 = moment(new Date(), "YYYY-MM-DD HH:mm:ss");

    var diff = fecha2.diff(fecha1, 'm');

    console.log(diff);

    if(diff < 1){
        document.write("Justo ahora");
    }else if(diff >= 1 && diff < 60){
        document.write("hace " + diff + " minutos");
    }else if(diff >= 60 && diff < 1440){
        diff = fecha2.diff(fecha1, 'h'); // Diff in hours
        document.write("hace " + diff + " horas");
    }else{
        diff = fecha2.diff(fecha1, 'd'); // Diff in hours
        document.write("hace " + diff + " dias");
    }





}



function getBorn(fecha_nac){
    var fecha1 = moment(new Date(fecha_nac), "YYYY-MM-DD HH:mm:ss");
    var fecha2 = moment(new Date(), "YYYY-MM-DD HH:mm:ss");

    var diff = fecha2.diff(fecha1, 'd');

    console.log(diff);

    if(diff < 60){
        document.write(diff + "d");
    }else if(diff >= 60 && diff < 365){
        diff = fecha2.diff(fecha1, 'M');
        document.write(diff + "m");
    }else if(diff > 365){
        diff = fecha2.diff(fecha1, 'y'); // Diff in hours
        document.write(diff + "a");
    }





}