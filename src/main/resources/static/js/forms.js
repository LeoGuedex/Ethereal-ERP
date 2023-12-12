const createSelector = (select, tbody, arrayLink) => {
  const errorMessages = {
    invalidOption: "Choose a valid option.",
    duplicateItem: "The item already exists in the list.",
    invalidValue: "Choose...",
  };
  const selectElement = document.getElementById(select);
  const tbodyElement = document.getElementById(tbody);
  const arrayItems = [];

  const updateArray = () => {
    const arrayResult = arrayItems.map(item => item.name);
    document.getElementById(arrayLink).value = arrayResult;
  }

  const listTable = () => {
    tbodyElement.innerHTML = '';

    arrayItems.forEach((item, i) => {
      const tr = tbodyElement.insertRow();
      const trItem = tr.insertCell();
      const trButton = tr.insertCell();

      trItem.innerText = item.name;

      const iconElement = document.createElement("i");
      iconElement.classList.add("bi", "bi-x-circle-fill");

      trButton.classList.add("text-center")
      trButton.appendChild(iconElement);

      iconElement.addEventListener("click", () => deleteItem(i));

      iconElement.addEventListener("mouseover", () => toggleIconClass(iconElement, "bi-x-circle", "bi-x-circle-fill"));

      iconElement.addEventListener("mouseout", () => toggleIconClass(iconElement, "bi-x-circle-fill", "bi-x-circle"));
    });
  };

  const toggleIconClass = (element, addClass, removeClass) => {
    element.classList.remove(removeClass);
    element.classList.add(addClass);
  };

  const deleteItem = (i) => {
    arrayItems.splice(i, 1);
    listTable();
    updateArray();
  };

  const add = () => {
    const itemName = selectElement.value;

    if (itemName === errorMessages.invalidValue || arrayItems.some(item => item.name === itemName)) {
      alert(itemName === errorMessages.invalidValue ? errorMessages.invalidOption : errorMessages.duplicateItem);
      return null;
    }

    arrayItems.push({ name: itemName });
    listTable();
    updateArray();

  };

  return add;
};


const createFoodsSelector = () => {
  const errorMessages = {
    invalidOption: "Choose a valid option.",
    duplicateItem: "The item already exists in the list.",
    invalidValue: "Choose...",
  };

  const selectElement = document.getElementById("foodsSelect");
  const selectFrequencyElement = document.getElementById("frequencySelect");
  const tbodyElement = document.getElementById("foodsTbody");
  const arrayItems = [];

  const updateFoodsArray = () => {
    const arrayResult = arrayItems.map(item => ({ name: item.name, frequencyName: item.frequencyName }));
    document.getElementById('foodFrequencyArray').value = JSON.stringify(arrayResult);
  };

  const listTable = () => {
    tbodyElement.innerHTML = '';

    arrayItems.forEach((item, i) => {
      const tr = tbodyElement.insertRow();
      const trId = tr.insertCell();
      const trItem = tr.insertCell();
      const trFrequencyName = tr.insertCell();
      const trButton = tr.insertCell();

      trId.innerText = i + 1;
      trItem.innerText = item.name;
      trFrequencyName.innerText = item.frequencyName;
      trId.classList.add("center");

      const iconElement = createIconElement();
      trButton.appendChild(iconElement);

      iconElement.addEventListener("click", () => deleteItem(i));
      addIconEventListeners(iconElement);
      updateFoodsArray();
    });

    
    
  };

  const createIconElement = () => {
    const iconElement = document.createElement("i");
    iconElement.classList.add("bi", "bi-x-circle-fill");
    return iconElement;
  };

  const addIconEventListeners = (iconElement) => {
    iconElement.addEventListener("mouseover", () => {
      iconElement.classList.remove("bi-x-circle-fill");
      iconElement.classList.add("bi-x-circle");
    });

    iconElement.addEventListener("mouseout", () => {
      iconElement.classList.remove("bi-x-circle");
      iconElement.classList.add("bi-x-circle-fill");
    });
  };

  const deleteItem = (i) => {
    arrayItems.splice(i, 1);
    listTable();
    updateFoodsArray();
  };

  const add = () => {
    const itemName = selectElement.value;
    const itemFrequencyName = selectFrequencyElement.value;

    // Verificar se os valores são inválidos ou duplicados
    if (itemName === "Choose..." || itemFrequencyName === "Choose..." || arrayItems.some(item => item.name === itemName)) {
      // Exiba a mensagem de erro na interface, em vez de usar um alerta
      alert(errorMessages.invalidOption);
      return;
    }

    arrayItems.push({ name: itemName, frequencyName: itemFrequencyName });
    listTable();
    updateFoodsArray();
  };

  return add;
};


let diseases = createSelector("diseaseSelect", "diseasesTbody", 'diseasesArray');
let goals = createSelector("goalsSelect", "goalsTbody", 'goalsArray');
let foods = createFoodsSelector();

const handlePhone = (event) => {
  let input = event.target
  input.value = phoneMask(input.value)
}

const phoneMask = (value) => {
  if (!value) return ""
  value = value.replace(/\D/g,'')
  value = value.replace(/(\d{2})(\d)/,"($1) $2")
  value = value.replace(/(\d)(\d{4})$/,"$1-$2")
  return value
}

function openSmallModal() {
  bootstrap.Modal('smallModal').show();
}