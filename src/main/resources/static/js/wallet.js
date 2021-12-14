$(document).ready(function() {
  if(localStorage.token==null){
    cerrarSesion()
  }
  actualizarEmailDelUsuario(localStorage.idUser);
  actualizarBalance(localStorage.idUser);
  cargarOperaciones(localStorage.idUser);
  $('#wallet').DataTable();

});
function actualizarEmailDelUsuario(idUser) {
  document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
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


function validarRespuesta(request){
  if(request.status==401){
    cerrarSesion()
  }
}

async function actualizarBalance(idUser) {
  const request = await fetch('/usuarios/'+idUser+'/wallet', {
    method: 'GET',
    headers: getHeaders()
  });
  validarRespuesta(request);
  const wallet = await request.json();
  document.getElementById('txt-balance-wallet').outerHTML = parseFloat(wallet.balance).toFixed(2);
  document.getElementById('txt-disponible-wallet').outerHTML = parseFloat(wallet.disponible).toFixed(2);

}

async function cargarOperaciones(idUser) {
  const request = await fetch('usuarios/'+idUser+'/OpEnCursoActivas', {
    method: 'GET',
    headers: getHeaders()
  });
  validarRespuesta(request);
  const operaciones = await request.json();

  let sumaBalances = 0.0;
  let listadoHtml = '';
  for (let operacion of operaciones) {

    let opHtml = '<tr><td>'+operacion.id_cripto_hist+'</td><td>' + operacion.cant_criptomoneda + '</td><td>' + operacion.balance_op + '</td><td>'
     +operacion.balance_porcentual +'</td><td>' + operacion.fecha_hora_inicio+'</td></tr>';
    listadoHtml += opHtml;
    sumaBalances = sumaBalances + operacion.balance_porcentual;

  }

  document.querySelector('#criptomonedas tbody').outerHTML = listadoHtml;
  document.getElementById('txt-cantOp-wallet').outerHTML = Object.keys(operaciones).length;
  document.getElementById('txt-balPorcOpAc-wallet').outerHTML = (sumaBalances/Object.keys(operaciones).length).toFixed(4);


}

function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}
