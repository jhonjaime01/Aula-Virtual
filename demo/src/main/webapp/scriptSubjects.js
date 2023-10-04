/**
 * Variable prodSub para guardar los datos de la base de datos en una lista
 */
var prodAct;
/**
 * Console para indicar que el script está funcionando
 */
console.log("dentro")

/**
 * Método para guardar en prodSub (variable local) los datos de la base de datos
 */
function bringData() {
    const xhr = new XMLHttpRequest();
    xhr.open('get', 'servlet-materia?op=1', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            prodAct = JSON.parse(xhr.responseText);
            console.log(prodAct);
        }
    }
    xhr.send(null);
}

/**
 * Método para llevar los datos al SELECT del HTML, actualizado de manera automática
 */
function putSubjects() {
    const xhrPuts = new XMLHttpRequest();
    xhrPuts.open('get', 'servlet-materia?op=1', true);
    xhrPuts.onreadystatechange = () => {
        if (xhrPuts.readyState === 4 && xhrPuts.status === 200) {
            prodAct = JSON.parse(xhrPuts.responseText);
            prodAct.forEach((prod) => document.getElementById('materias')
                .add(new Option(prod.nameSubj)))
        }
    }
    xhrPuts.send(null);
}

/**
 * Método que crear los ELEMENTOS DEL HTML ( filas, columnas ) y los agrega al
 * cuerpo de la tabla
 * @param idMateria Id de la materia
 * @param nombreMateria Nombre de la materia
 * @param notaFinal Nota final de la materia
 */
function putInfo(idMateria, nombreMateria, notaFinal) {
    let row = document.createElement('tr')
    let colIdMateria = document.createElement('td')
    colIdMateria.append(document.createTextNode(`${idMateria}`))
    row.append(colIdMateria)
    let colNombreMateria = document.createElement('td')
    colNombreMateria.append(document.createTextNode(`${nombreMateria}`))
    row.append(colNombreMateria)
    let colNotaFinal = document.createElement('td')
    colNotaFinal.append(document.createTextNode(`${notaFinal}`))
    row.append(colNotaFinal)
    document.getElementById('tBody').append(row)
}

/**
 * Método para ejecutar el método putInfo y llevarlo al HTML
 */
function addInfoToHtml() {
    document.getElementById('visualizar').addEventListener('click', () => {
        console.log("en el boton")
        prodAct.forEach(prods => putInfo(prods.subjId, prods.nameSubj, prods.notaFinalSubj));
    })
}

/**
 * Método que TRAE los elementos del HTML y los GUARDA en la base de datos
 */
function saveData() {
    const xhrDos = new XMLHttpRequest();
    xhrDos.open('post', 'servlet-materia?op=1', true)
    xhrDos.onreadystatechange = () => {
        if (xhrDos.readyState === 4 && xhrDos.status === 200) {
            console.log(xhrDos.responseText);
        }
    }
    document.getElementById('guardar').addEventListener('click', function () {
        var id = document.getElementById('idMateria').value;
        var nombre = document.getElementById('nombreMateria').value;
        var apellido = document.getElementById('notaFinal').value;

        const data = `subjId=${id}&nameSubj=${nombre}&notaFinalSubj=${apellido}`;
        console.log(data)
        xhrDos.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhrDos.send(data)
        alert("Elemento Agregado")
    })
}


/**
 * Método para ELIMINAR de la base de datos
 */
function deleteSubjects() {
    var dataDelete;
    var subjId;
    const xhrDelete = new XMLHttpRequest();
    xhrDelete.open('GET', 'servlet-materia?op=1', true);
    xhrDelete.onreadystatechange = () => {
        if (xhrDelete.readyState === 4 && xhrDelete.status === 200) {
            dataDelete = JSON.parse(xhrDelete.responseText);
        }
    };
    xhrDelete.send(null)
    document.getElementById('eliminar').addEventListener('click', function () {
        const sel = document.getElementById('materias')
        var selectedOption = sel.options[sel.selectedIndex];
        var envio = selectedOption.text
        dataDelete.forEach((subjects) => {
            if (subjects.nameSubj === envio) {
                subjId = subjects.subjId
                alert(subjects.subjId)
            }
        })
        var send = "subjId=" + subjId;
        $.ajax({
            url: 'servlet-materia?op=2',
            type: 'POST',
            data: send
        })
        alert("MATERIA ELIMINADA")
        document.getElementById('materias').innerHTML = " "
        putSubjects();

    })
}

document.getElementById("guardar").disabled=true;
function habilitarFormulario(){

    let idMateria = document.getElementById("idMateria").value;
    let nombreMateria = document.getElementById("nombreMateria").value;
    let notaFinal = document.getElementById("notaFinal").value;

    let val = 0;

    console.log(idMateria);
    console.log(nombreMateria);
    console.log(notaFinal);

    if(idMateria == ""){
        val++;
    }if(nombreMateria == ""){
        val++;
    }if(notaFinal == ""){
        val++;
    }
    if(val == 0){
        document.getElementById("guardar").disabled=false;
        document.getElementById("guardar").addEventListener("click",()=>{
            alert("Haz llenado todo");
        });
    }else{
        document.getElementById("guardar").disabled=true;
    }

}

document.getElementById("idMateria").addEventListener("keyup",habilitarFormulario);
document.getElementById("nombreMateria").addEventListener("keyup",habilitarFormulario);
document.getElementById("notaFinal").addEventListener("keyup",habilitarFormulario);

bringData()
putSubjects()
addInfoToHtml()
saveData()
deleteSubjects()