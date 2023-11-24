function login() {
  const loginForm = document.getElementById('loginForm');
  const loginButton = document.getElementById('loginButton');

  loginButton.addEventListener('click', function() {
    const email = loginForm.email.value;
    const password = loginForm.pswd.value;
    const url = 'http://localhost:8080/api/users/login';

    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ email: email, password: password })
    })
      .then(response => {
        if (response.ok) {
          console.log(response);
          window.location.href = 'home';
        } else if (response.status === 401) {
          alert('Login não autorizado!');
        } else {
          throw new Error('Erro desconhecido!');
        }
      })
      .catch(error => {
        console.error('Erro:', error);
        alert(error.message);
      });
  });
}

login();