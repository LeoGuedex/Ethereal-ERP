const updateDataForm = document.querySelector('#updateData');

const hcUserPic = document.querySelector('#hcUserPic');
const hcUserPicInput = document.querySelector('#hcUserPicInput');
const addHcUserPicBtn = document.querySelector('#addHcUserPicBtn');
const removeHcUserPicBtn = document.querySelector('#removeHcUserPicBtn');

const passwordForm = document.querySelector('#passwordForm');

function previewImage(input) {
  const file = input.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = function (e) {
      hcUserPic.src = e.target.result;
      hcUserPicInput.files[0] = null;
    };
    reader.readAsDataURL(file);
  }
}

const sendUpdateData = async () => {
  const firstName = document.querySelector('#firstName').value;
  const hcUserPicture = hcUserPicInput.files[0];
  const lastName = document.querySelector('#lastName').value;
  const address = document.querySelector('#address').value;
  const email = document.querySelector('#email').value;
  const phone = document.querySelector('#phone').value;

  let formData = new FormData();
  formData.append('firstName', firstName);
  if (hcUserPicture) formData.append('hcUserPic', hcUserPicture);
  formData.append('lastName', lastName);
  formData.append('address', address);
  formData.append('email', email);
  formData.append('phone', phone);

  const currentUrl = window.location.href;
  const separator = currentUrl.includes('?');
  let urlWithParam = separator
    ? currentUrl.split('?')[0] + '?updatedData='
    : currentUrl + '?updatedData=';

  fetch('/api/hcuser', {
    method: 'PATCH',
    body: formData,
  })
    .then(response => {
      console.log(1);
      if (response.ok) {
        window.location.assign(urlWithParam + 'true');
      } else {
        window.location.assign(urlWithParam + 'false');
      }
    })
    .catch(error => {
      window.location.assign(urlWithParam + 'false');
    });
};

const showAlert = (type, message) => {
  const alert = document.querySelector('#alert');
  alert.style.display = 'block';

  alert.classList.add(type);
  alert.innerText = message;
};

const sendPasswordUpdate = async () => {
  const currentPassword = document.querySelector('#currentPassword').value;
  const newPassword = document.querySelector('#newPassword').value;
  const renewPassword = document.querySelector('#renewPassword').value;

  const data = { currentPassword, newPassword };
  const fetchMode = {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  };
  if (newPassword !== renewPassword) return;

  const response = await fetch('/api/hcuser/password', fetchMode);
  const status = await response.status;

  if (status === 202) {
    showAlert('alert-success', 'Password updated.');
  } else {
    showAlert('alert-danger', 'Password not updated');
  }
};

updateDataForm.addEventListener('submit', async e => {
  e.preventDefault();
  await sendUpdateData();
});

hcUserPicInput.addEventListener('change', e => {
  input = e.target;
  previewImage(input);
});

addHcUserPicBtn.addEventListener('click', () => {
  hcUserPicInput.click();
});

removeHcUserPicBtn.addEventListener('click', () => {
  hcUserPic.src = '/static/imagens/profile/default-user-profile.jpg';
});

passwordForm.addEventListener('submit', async e => {
  e.preventDefault();
  await sendPasswordUpdate();
});
