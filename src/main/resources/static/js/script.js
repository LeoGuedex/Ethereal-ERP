document.addEventListener('DOMContentLoaded', function() {
  document.getElementById('loginButton').addEventListener('click', function(e) {
    e.preventDefault();

    const email = document.getElementsByName('email')[0].value;
    const password = document.getElementsByName('pswd')[0].value;
    const url = 'http://localhost:8080/api/users/login';

    const xhr = new XMLHttpRequest();
    xhr.open('POST', url);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
      if (xhr.status === 200) {
        window.location.href = 'index';
      } else if (xhr.status === 401) {
        alert('Login não autorizado!');
      } else {
        alert('Erro desconhecido!');
      }
    };
    xhr.send(JSON.stringify({ email: email, password: password }));
  });
});