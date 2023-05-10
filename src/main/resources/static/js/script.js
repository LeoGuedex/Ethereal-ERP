$(document).ready(function() {
  $('#loginForm').submit(function(e) {
    e.preventDefault();

    const email = $('input[name="email"]').val();
    const password = $('input[name="pswd"]').val();
    const url = 'http://localhost:8080/api/users/login';

    $.ajax({
      url: url,
      method: 'POST',
      data: JSON.stringify({ email: email, password: password }),
      dataType: 'json',
      contentType: 'application/json',
      success: function(response) {
        alert('Login realizado com sucesso!');
        window.location.replace('index');
      },
      error: function(xhr, status, error) {
        if (xhr.status == 401) {
          alert('Login não autorizado!');
        } else {
          alert('Erro desconhecido!');
        }
      }
    });
  });

  $('#loginButton').click(function() {
    $('#loginForm').submit();
  });
});
