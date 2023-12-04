const updateDataForm = document.querySelector('#updateData');

const hcUserPic = document.querySelector('#hcUserPic');
const hcUserPicInput = document.querySelector('#hcUserPicInput');
const addHcUserPicBtn = document.querySelector('#addHcUserPicBtn');
const removeHcUserPicBtn = document.querySelector('#removeHcUserPicBtn');

const previewDiv = document.querySelector('#cropCanva');
const prev = document.querySelectorAll('#previewCrop');
const removeCropBtn = document.querySelector('#removeCropBtn');
const modal = document.querySelector('#modal');
const addCropBtn = document.querySelector('#addCropBtn');
let cropper;
let updatedImage = null;
let updatedUserPic = false;

const passwordForm = document.querySelector('#passwordForm');

const crop = image => {
  return new Cropper(image, {
    dragMode: 'move',
    aspectRatio: 1,
    viewMode: 1,
    preview: prev,
  });
};

const updatePreviewImage = url => {
  hcUserPic.src = url;
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
  if (updatedImage) {
    formData.append('hcUserPic',updatedImage, "image" + hcUserPicture.name.slice(-4))
  };
  formData.append('lastName', lastName);
  formData.append('updatedUserPic', updatedUserPic);
  formData.append('address', address);
  formData.append('email', email);
  formData.append('phone', phone);

  const currentUrl = window.location.href;
  const separator = currentUrl.includes('?');
  let urlWithParam = separator
    ? currentUrl.split('?')[0] + '?updatedData='
    : currentUrl + '?updatedData=';

  fetch('/api/etuser', {
    method: 'PATCH',
    body: formData,
  })
    .then(response => {
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

  const response = await fetch('/api/etuser/password', fetchMode);
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
  const preview = document.querySelector('#preview-image');
  const previewImage = document.createElement('img');

  if (preview) {
    preview.remove();
  }

  const reader = new FileReader();

  reader.onload = event => {
    previewImage.id = 'preview-image';
    previewImage.width = '100%';
    previewImage.src = event.target.result;
    previewDiv.appendChild(previewImage);
    cropper = crop(previewImage);
    modal.classList.remove('visually-hidden');
  };

  reader.readAsDataURL(e.target.files[0]);

  updatedUserPic = true;
});

removeCropBtn.addEventListener('click', event => {
  cropper.destroy();
  modal.classList.add('visually-hidden');
});

addCropBtn.addEventListener('click', event => {
  if (cropper.cropped) {
    cropper.getCroppedCanvas().toBlob(async blob => {
      const objectURL = URL.createObjectURL(blob);
      updatedImage = blob
      updatePreviewImage(objectURL);
      cropper.destroy();
      modal.classList.add('visually-hidden');
    });
  }
});

addHcUserPicBtn.addEventListener('click', () => {
  hcUserPicInput.click();
});

removeHcUserPicBtn.addEventListener('click', () => {
  hcUserPic.src = '/static/imagens/profile/default-user-profile.jpg';
  updatedUserPic = true;
  updatedImage = null;
});

passwordForm.addEventListener('submit', async e => {
  e.preventDefault();
  await sendPasswordUpdate();
});
