$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;
  console.log(datos);

  const request = await fetch('login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const respuesta = await request.text();
  if (request.status == 200) {
    localStorage.token = respuesta;
    const request = await fetch('usuarios/'+datos.email, {
      method: 'GET',
      headers: getHeaders()
    });
    const usuario = await request.json();
    localStorage.email = datos.email;
    localStorage.idUser = usuario.id;
    alert("Login Correcto")
    window.location.href = 'wallet.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}
function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}
