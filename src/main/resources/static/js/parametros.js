$(document).ready(function() {
    if(localStorage.token==null){
        cerrarSesion()
    }
    mostrarParametrosActuales(localStorage.idUser);
    $('#wallet').DataTable();
    actualizarEmailDelUsuario();

});
function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

function validarRespuesta(request){
    if(request.status==401){
        cerrarSesion()
    }
}

async function cerrarTodasSesiones(){
    const request = await fetch('logout', {
        method: 'GET',
        headers: getHeaders()
    });
    localStorage.clear()
    window.location.href = 'index.html'
}


async function mostrarParametrosActuales(idUser) {
    const request = await fetch('usuarios/'+idUser+'/parametros', {
        method: 'GET',
        headers: getHeaders()
    });
    validarRespuesta(request);
    const parametros = await request.json();
    document.getElementById('txt-ganPorOp-param').outerHTML = parseFloat(parametros.gan_por_op).toFixed(4);
    document.getElementById('txt-perPorOp-param').outerHTML = parseFloat(parametros.per_por_op).toFixed(4);
    document.getElementById('txt-varEntreCaidas-param').outerHTML = parseFloat(parametros.variacion_entr_caidas).toFixed(4);

}

async function modificarParametros() {
    const requestParam = await fetch('usuarios/'+localStorage.idUser+'/parametros', {
        method: 'GET',
        headers: getHeaders()
    });
    validarRespuesta(requestParam);
    const parametros2 = await requestParam.json();
    let datos = {};
    datos.id=parametros2.id;
    datos.usuario=parametros2.usuario;
    datos.gan_por_op = parseFloat(document.getElementById('margenGananciaPorOp').value).toFixed(4);
    datos.per_por_op = parseFloat(document.getElementById('margenPerdidaPorOp').value).toFixed(4);
    datos.variacion_entr_caidas = parseFloat(document.getElementById('variacionEstrCaidas').value).toFixed(4);
    console.log(datos)

    if (datos.gan_por_op==0||datos.per_por_op==0||datos.variacion_entr_caidas==0) {
        alert('Debe completar todos los campos, si no cambia el valor escriba nuevamente el mismo');
        return;
    }

    const request = await fetch('parametros', {
        method: 'PUT',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    validarRespuesta(request);
    console.log(request);
    alert("Los parametros se modificaron correctamente");
    window.location.href = 'parametros.html'

}

function cerrarSesion(){
    localStorage.clear()
    window.location.href = 'index.html'
}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };

}