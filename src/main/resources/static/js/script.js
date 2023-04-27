function fazerLogin() {
   const email = document.getElementsByName('email')[0].value;
   const password = document.getElementsByName('pswd')[0].value;
   const url = `http://localhost:8080/clients?email=${email}&password=${password}`;

   fetch(url, { method: 'GET' })
       .then(response => response.json())
       .then(data => {
           if (data.authorized) {
               alert('Login autorizado!');
           } else {
               alert('Login não autorizado!');
           }
       })
       .catch(error => {
           console.error('Erro ao fazer login', error);
       });
}

const btnLogin = document.getElementById('btn-login');
btnLogin.addEventListener('click', fazerLogin);
