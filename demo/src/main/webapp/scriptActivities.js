var prod2;
var subjId;

/**
 * Método para traer la informacion de actividades de la base de datos
 */
function bringData() {
    const xhr2 = new XMLHttpRequest();
    xhr2.open('get', 'servlet-actividad?op=1', true);
    xhr2.onreadystatechange = () => {
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            prod2 = JSON.parse(xhr2.responseText);
            console.log(prod2);
        }
    }
    xhr2.send(null);
}

/**
 * Método para actualizar las actividades en el HTML
 */
function putActivities() {
    const xhrPuts = new XMLHttpRequest();
    xhrPuts.open('get', 'servlet-actividad?op=1', true);
    xhrPuts.onreadystatechange = () => {
        if (xhrPuts.readyState === 4 && xhrPuts.status === 200) {
            prodAct = JSON.parse(xhrPuts.responseText);
            prodAct.forEach((activ) => document.getElementById('actividades')
                .add(new Option(activ.nombreAct)))
        }
    }
    xhrPuts.send(null);
}

/**
 * Método para actualizar las materias en el HTML
 */
function putSubjects() {
    var prodAct;
    const xhrPuts = new XMLHttpRequest();
    xhrPuts.open('get', 'servlet-materia?op=1', true);
    xhrPuts.onreadystatechange = () => {
        if (xhrPuts.readyState === 4 && xhrPuts.status === 200) {
            prodAct = JSON.parse(xhrPuts.responseText);
            prodAct.forEach((prod) => document.getElementById('materia')
                .add(new Option(prod.nameSubj)))
        }
    }
    xhrPuts.send(null);
}

/**
 * Método para traer el ID de la materia según el nombre de la materia
 * @returns {*}
 */
function bringIdSubject() {
    var dataId;
    const xhrDataSub = new XMLHttpRequest();
    xhrDataSub.open('GET', 'servlet-materia?op=1', true);
    xhrDataSub.onreadystatechange = () => {
        if (xhrDataSub.readyState === 4 && xhrDataSub.status === 200) {
            dataId = JSON.parse(xhrDataSub.responseText);
        }
    };
    xhrDataSub.send(null)
    document.getElementById('btnGuardar').addEventListener('click', function () {
        const sel = document.getElementById('materia')
        var selectedOption = sel.options[sel.selectedIndex];
        var envio = selectedOption.text
        dataId.forEach((subjects) => {
            if (subjects.nameSubj === envio) {
                subjId = subjects.subjId
            }
        })
    })
    return subjId;
}
/**
 * Método para crear la tabla donde se mostrará la información al HTML
 * @param actId Id de la actividad
 * @param tipoAct Tipo de la actividad
 * @param nombreAct Nombre de la actividad
 * @param descripAct Descripción de la activdad
 * @param ponderadoAct Ponderado de la actividad
 * @param fechaAct Fecha de la actividad
 * @param calificacionAct Calificacion de la actividad
 * @param materiaId Id de la materia (F.K)
 */
function putInfo(actId, tipoAct, nombreAct, descripAct, ponderadoAct, fechaAct,
                 calificacionAct,materiaId) {
    let row = document.createElement('tr')
    let colId = document.createElement('td')
    colId.append(document.createTextNode(`${actId}`))
    row.append(colId)
    let colTipo = document.createElement('td')
    colTipo.append(document.createTextNode(`${tipoAct}`))
    row.append(colTipo)
    let colNombre = document.createElement('td')
    colNombre.append(document.createTextNode(`${nombreAct}`))
    row.append(colNombre)
    let colDescrip = document.createElement('td')
    colDescrip.append(document.createTextNode(`${descripAct}`))
    row.append(colDescrip)
    let colPonde = document.createElement('td')
    colPonde.append(document.createTextNode(`${ponderadoAct}`))
    row.append(colPonde)
    let colFecha = document.createElement('td')
    colFecha.append(document.createTextNode(`${fechaAct}`))
    row.append(colFecha)
    let colCalif = document.createElement('td')
    colCalif.append(document.createTextNode(`${calificacionAct}`))
    row.append(colCalif)
    let colMateriaId = document.createElement('td')
    colMateriaId.append(document.createTextNode(`${materiaId}`))
    row.append(colMateriaId)
    document.getElementById('tBody').append(row)
}
/**
 * Método para añadir la información al HTML
 */
function addToHtml() {
    document.getElementById('visualizar').addEventListener('click', () => {
        console.log("en el boton")
        prod2.forEach(prods => putInfo(prods.actId,prods.tipoAct,prods.nombreAct
            ,prods.descripcionAct,prods.ponderadoAct,prods.fechaAct,prods.calificacionAct,prods.idMateria));
    })
}

/**
 * Método para guardar en la base de datos la información del HTML
 */
function saveData() {
    const xhrDos = new XMLHttpRequest();
    xhrDos.open('post', 'servlet-actividad?op=1', true)
    xhrDos.onreadystatechange = () => {
        if (xhrDos.readyState === 4 && xhrDos.status === 200) {
            console.log(xhrDos.responseText);
        }
    }
    bringIdSubject()
    document.getElementById('btnGuardar').addEventListener('click', function () {
        var actId = document.getElementById('actId').value;
        var tipoAct = document.getElementById('tipoAct').value;
        var nombreAct = document.getElementById('nameAct').value;
        var descripcionAct = document.getElementById('descripcion').value;
        var ponderadoAct = document.getElementById('ponderado').value;
        var fechaAct = document.getElementById('fecha').value;
        var calificacionAct = document.getElementById('calificacion').value;

        const data = `actId=${actId}&tipoAct=${tipoAct}&nombreAct=${nombreAct}&descripcionAct=${descripcionAct}
        &ponderadoAct=${ponderadoAct}&fechaAct=${fechaAct}&calificacionAct=${calificacionAct}
        &idMateria=${subjId}`;

        alert(data)

        xhrDos.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhrDos.send(data)
        alert("Elemento Agregado")
    })
}

/**
 * Método para eliminar una fila de la base de datos según el nombre de la actividdd
 */
function deleteAct() {
    var dataDelete;
    var actId;
    const xhrDelete = new XMLHttpRequest();
    xhrDelete.open('GET', 'servlet-actividad?op=1', true);
    xhrDelete.onreadystatechange = () => {
        if (xhrDelete.readyState === 4 && xhrDelete.status === 200) {
            dataDelete = JSON.parse(xhrDelete.responseText);
        }
    };
    xhrDelete.send(null)
    document.getElementById('eliminar').addEventListener('click', function () {
        alert("DENTRO DEL BOTON")
        const sel = document.getElementById('actividades')
        var selectedOption = sel.options[sel.selectedIndex];
        var envio = selectedOption.text
        dataDelete.forEach((activity) => {
            if (activity.nombreAct === envio) {
                actId = activity.actId
                alert(actId)
            }
        })
        var send = "actId=" + actId;
        $.ajax({
            url: 'servlet-actividad?op=2',
            type: 'POST',
            data: send
        })
        alert("ACTIVIDAD ELIMINADA")
        document.getElementById('actividades').innerHTML = " "
        putActivities()

    })
}

document.getElementById("btnGuardar").disabled=true;
function habilitarFormulario(){

    let actId = document.getElementById("actId").value;
    let tipoAct = document.getElementById("tipoAct").value;
    let nameAct = document.getElementById("nameAct").value;
    let ponderado = document.getElementById("ponderado").value;
    let fecha = document.getElementById("fecha").value;
    let materia = document.getElementById("materia").value;
    let calificacion = document.getElementById("calificacion").value;
    let descripcion = document.getElementById("descripcion").value;

    let val = 0;

    if(actId == ""){
        val++;
    }if(tipoAct == ""){
        val++;
    }if(nameAct == ""){
        val++;
    }if(ponderado == ""){
        val++;
    }if(fecha == ""){
        val++;
    }if(materia == ""){
        val++;
    }if(calificacion == ""){
        val++;
    }if(descripcion == ""){
        val++;
    }
    if(val == 0){
        document.getElementById("btnGuardar").disabled=false;
        document.getElementById("btnGuardar").addEventListener("click",()=>{
        });
    }else{
        document.getElementById("btnGuardar").disabled=true;
    }

}

document.getElementById("actId").addEventListener("keyup",habilitarFormulario);
document.getElementById("tipoAct").addEventListener("change",habilitarFormulario);
document.getElementById("nameAct").addEventListener("keyup",habilitarFormulario);
document.getElementById("ponderado").addEventListener("keyup",habilitarFormulario);
document.getElementById("fecha").addEventListener("keyup",habilitarFormulario);
document.getElementById("materia").addEventListener("change",habilitarFormulario);
document.getElementById("calificacion").addEventListener("keyup",habilitarFormulario);
document.getElementById("descripcion").addEventListener("keyup",habilitarFormulario);

function bringDataTime(){
    var arrayActivities
    let arrayData=[]
    const xhr2 = new XMLHttpRequest();
    xhr2.open('get', 'servlet-actividad?op=1', true);
    xhr2.onreadystatechange = () => {
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            arrayActivities = JSON.parse(xhr2.responseText);
            arrayActivities.forEach((auxData=>{
                arrayData.push(auxData.fechaAct)
            }))
            console.log(arrayData)
        }
    }
    xhr2.send(null);
    //return arrayData;

    let dateInicial = new Date();
    let milisegundosDia = 24*60*60*1000;

    for (let i = 0; i<= arrayData.length ; i++){

        let datee = arrayData;
        const fixCadena = datee.slice(0, -9);
        console.log(fixCadena);

        //let dataActivity = new Date(arrayData);
        //console.log(dataActivity);
        //let milisegundosTranscurridos = Math.abs(dateInicial.getTime()-dateActivity.getTime());
        //let diasTranscurridos = Math.round(milisegundosTranscurridos/milisegundosDia);
    }

}


putActivities();
bringData();
putSubjects();
addToHtml();
saveData();
deleteAct();
bringDataTime();

