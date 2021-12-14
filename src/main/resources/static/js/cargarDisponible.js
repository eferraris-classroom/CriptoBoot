$(document).ready(function() {
    if(localStorage.token==null){
        cerrarSesion()
    }
    mostrarDisponibleDivisiones();
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


async function mostrarDisponibleDivisiones() {
    const request = await fetch('usuarios/'+localStorage.idUser+'/wallet', {
        method: 'GET',
        headers: getHeaders()
    });
    validarRespuesta(request);
    const wallet = await request.json();
    document.getElementById('txt-disponible-cargarDisponible').outerHTML = wallet.disponible;
    document.getElementById('txt-cantDivisiones-cargarDisponible').outerHTML = wallet.divisiones_disponible;

}

async function cargarDisponible() {
    const requestCD = await fetch('usuarios/'+localStorage.idUser+'/wallet', {
        method: 'GET',
        headers: getHeaders()
    });
    validarRespuesta(requestCD);
    const walletCD = await requestCD.json();
    let datos = {};
    datos.id=walletCD.id;
    datos.usuario=walletCD.usuario
    datos.disponible = parseFloat(document.getElementById('cantDinero').value)+walletCD.disponible;
    datos.divisiones_disponible = document.getElementById('cantDivisiones').value;
    datos.balance=parseFloat(document.getElementById('cantDinero').value)+walletCD.balance;
    console.log(datos)

    if (datos.disponible==null||datos.divisiones_disponible==null) {
        alert('Debe completar todos los campos, si no va a cargar nada escriba cero');
        return;
    }

    const request = await fetch('wallet', {
        method: 'PUT',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    validarRespuesta(request);
    alert("El dinero se cargó correctamente");
    window.location.href = 'cargarDisponible.html'

}
function cerrarSesion(){
    localStorage.clear()
    window.location.href = 'index.html'
}

async function cerrarTodasSesiones(){
    const request = await fetch('logout', {
        method: 'GET',
        headers: getHeaders()
    });
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