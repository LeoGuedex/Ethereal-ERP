
class SelectConstructor {
  constructor(config) {
    this.errorMessages = config.errorMessages;
    this.selectElement = document.getElementById(config.selectElementId);
    this.tbodyElement = document.getElementById(config.tbodyElementId);
    this.arrayItems = [];
  }

  add() {
    let item = this.readData();
    if (this.validateData(item.name)) {
      alert(this.errorMessages.invalidOption);
      return;
    }

    if (this.isDuplicateItemName(item.name)) {
      alert(this.errorMessages.duplicateItem);
      return;
    }

    this.arrayItems.push(item);
    this.listTable();
  }

  listTable() {
    this.tbodyElement.innerHTML = '';

    this.arrayItems.forEach((item, i) => {
      let tr = this.tbodyElement.insertRow();
      let trItem = tr.insertCell();
      let trButton = tr.insertCell();

      trItem.innerText = item.name;

      let iconElement = document.createElement("i");
      iconElement.classList.add("bi", "bi-x-circle-fill");

      trButton.appendChild(iconElement);

      iconElement.addEventListener("click", () => this.deleteItem(i));

      iconElement.addEventListener("mouseover", () => {
        iconElement.classList.remove("bi-x-circle-fill");
        iconElement.classList.add("bi-x-circle");
      });

      iconElement.addEventListener("mouseout", () => {
        iconElement.classList.remove("bi-x-circle");
        iconElement.classList.add("bi-x-circle-fill");
      });
    });
  }

  readData() {
    let item = { name: this.selectElement.value };
    return item;
  }

  isDuplicateItemName(name) {
    return this.arrayItems.some(item => item.name === name);
  }

  deleteItem(i) {
    this.arrayItems.splice(i, 1);
    this.listTable();
  }

  validateData(value) {
    let invalidValues = this.errorMessages.invalidValues || [];
    return invalidValues.includes(value);
  }
}

class SelectConstructorD {
  constructor(config) {
    this.errorMessages = config.errorMessages;
    this.selectElement = document.getElementById(config.selectElementId);
    this.tbodyElement = document.getElementById(config.tbodyElementId);
    this.selectElementD = document.getElementById(config.selectElementIdD);
    this.arrayItems = [];
  }

  add() {
    let item = this.readData();
    if (this.validateData(item.name) || this.validateData(item.nameD)) {
      alert(this.errorMessages.invalidOption);
      return;
    }

    if (this.isDuplicateItemName(item.name)) {
      alert(this.errorMessages.duplicateItem);
      return;
    }

    this.arrayItems.push(item);
    this.listTable();

  }

  listTable() {
    this.tbodyElement.innerHTML = '';

    this.arrayItems.forEach((item, i) => {

      let tr = this.tbodyElement.insertRow();
      let trId = tr.insertCell();
      let trItem = tr.insertCell();
      let trItemD = tr.insertCell();
      let trButton = tr.insertCell();

      trId.innerText = i + 1;
      trItem.innerText = item.name;
      trItemD.innerText = item.nameD;
      trId.classList.add("center");

      let iconElement = document.createElement("i");
      iconElement.classList.add("bi", "bi-x-circle-fill");

      trButton.appendChild(iconElement);

      iconElement.addEventListener("click", () => this.deleteItem(i));

      iconElement.addEventListener("mouseover", () => {
        iconElement.classList.remove("bi-x-circle-fill");
        iconElement.classList.add("bi-x-circle");
      });

      iconElement.addEventListener("mouseout", () => {
        iconElement.classList.remove("bi-x-circle");
        iconElement.classList.add("bi-x-circle-fill");
      });
    });
  }

  readData() {
    let item = { name: this.selectElement.value, nameD: this.selectElementD.value };
    return item;
  }

  isDuplicateItemName(name) {
    return this.arrayItems.some(item => item.name === name);
  }

  deleteItem(i) {
    this.arrayItems.splice(i, 1);
    this.listTable();
  }

  validateData(value) {
    let invalidValues = this.errorMessages.invalidValues || [];
    return invalidValues.includes(value);
  }
}

const diseasesConfig = {
  errorMessages: {
    invalidOption: "Choose a valid option.",
    duplicateItem: "The item already exists in the list.",
    invalidValues: ["Choose..."],
  },
  selectElementId: "diseaseSelect",
  tbodyElementId: "diseasesTbody"
};

const foodsConfig = {
  errorMessages: {
    invalidOption: "Choose a valid option.",
    duplicateItem: "The item already exists in the list.",
    invalidValues: ["Choose..."],
  },
  selectElementId: "foodsSelect",
  selectElementIdD: "frequencySelect",
  tbodyElementId: "foodsTbody"

};
var diseases = new SelectConstructor(diseasesConfig);
var foods = new SelectConstructorD(foodsConfig);

function create() {
  const customerCreate = document.getElementById("customerCreate");
  const url = "http://127.0.0.1:8080/api/customer/create";

  document.getElementById("submit").addEventListener('click', e => {
    const customerName = customerCreate.name.value;
    const customerAge = customerCreate.age.value;
    const customerEmail = customerCreate.email.value;
    const customerReferredBy = customerCreate.referredBy.value;
    const customerAddress =   customerCreate.address.value;
    const customerBirthDate = customerCreate.birthDate.value;
    const customerPhoneNumber = customerCreate.phoneNumber.value;
    const customerWeight = customerCreate.weight.value;
    const customerHeight = customerCreate.height.value;
    const customerWorksOrStudies = customerCreate.worksOrStudies.value;

    e.preventDefault();

    fetch(url, {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
      body: JSON.stringify({
        "id": null,
        customerName: customerName,
        customerAge: customerAge,
        customerEmail: customerEmail,
        customerReferredBy: customerReferredBy,
        customerAddress: customerAddress,
        customerBirthDate: customerBirthDate,
        customerPhoneNumber: customerPhoneNumber,
        customerWeight: customerWeight,
        customerHeight: customerHeight,
        customerWorksOrStudies: customerWorksOrStudies
      })
    }).then(response => response.json())
      .then(data => console.log(data))

  });
}
create()
