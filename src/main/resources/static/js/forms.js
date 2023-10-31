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

var diseases = new SelectConstructor(diseasesConfig);

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

var foods = new SelectConstructorD(foodsConfig);
