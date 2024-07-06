// const url = "https://fakestoreapi.com/products";
const url = "http://localhost:8080";

// Listar Productos

if (document.contains(document.querySelector("#carrusel"))) {
  document.addEventListener("DOMContentLoaded", () => {
    fetchData();
  });
}

const fetchData = async () => {
  try {
    const res = await fetch(url + "/listarProduct");
    const data = await res.json();

    pintarCard(data);
  } catch (error) {
    console.log(error);
  }
};

const pintarCard = (data) => {
  const contenedor = document.querySelector("#contenedor");
  const template = document.querySelector("#template-card").content;
  const fragment = document.createDocumentFragment();

  for (let i = 0; i < data.length; i++) {
    const clone = template.cloneNode(true);
    clone.querySelector("img").setAttribute("src", data[i].url);
    clone.querySelector("h5").textContent = data[i].title;
    clone.querySelector(".description").textContent = data[i].description;
    clone.querySelector(".precio").textContent = "$ " + data[i].price;

    if (document.body.contains(document.querySelector("#addProduct"))) {
      clone.querySelector(".id").textContent = "ID: " + data[i].id;
      clone.querySelector(".category").textContent =
        "Categoría: " + data[i].category_id.title;
      let delButton = document.createElement("button");
      delButton.setAttribute("class", "btn");

      let icon = document.createElement("i");
      icon.setAttribute("class", "fa-solid fa-box-archive");
      delButton.appendChild(icon);
      const onClickHandler = `delProduct(${data[i].id})`;
      delButton.setAttribute("onclick", onClickHandler);

      clone.querySelector(".price").appendChild(delButton);
    }

    fragment.appendChild(clone);
  }

  contenedor.innerHTML = "";

  contenedor.appendChild(fragment);
};

// Borrar un Producto

function delProduct(id) {
  const respuesta = fetch(url + `/delProduct/${id}`, {
    method: "DELETE",
  });

  respuesta
    .then((response) => okDel(response))
    .catch((error) => dibujarError(error));
}

function okDel(response) {
  alert("Se eliminó exitosamente");
}

function dibujarError(error) {
  alert(error);
}

// Obtener Categorias

const select = document.querySelector("#category");

function mostrarCategorias(data) {
  for (let i = 0; i < data.length; i++) {
    const option = document.createElement("option");
    option.value = data[i].id;
    option.textContent = data[i].id + ": " + data[i].title;
    select.appendChild(option);
  }
}

const loadCategories = async () => {
  try {
    const res = await fetch(url + "/listarCategory");
    const data = await res.json();
    mostrarCategorias(data);
  } catch (error) {
    console.log(error);
  }
};

document.addEventListener("DOMContentLoaded", loadCategories);

// Añadir un Producto
function addProduct(event) {
  event.preventDefault();
  // Toma los Datos del formulario
  let form = new FormData(document.querySelector("#addProduct"));
  // Crea un objeto a partir de los datos de cada campo del formulario
  let category = {
    id: select.options[select.selectedIndex].value,
    title: select.options[select.selectedIndex].textContent 
  };
  let product = {
    category_id: category,
    title: form.get("title"),
    description: form.get("description"),
    price: parseFloat(form.get("price")),
    url: form.get("url"),
  };

  const res = fetch(url + "/addProduct", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    // Convierte los datos del formulario a .json
    body: JSON.stringify(product),
  })
    .then((response) => response.json())
    .then((response) => okAdd(response))
    .catch((error) => dibujarError(error));
}

function okAdd(response) {
  alert("Se agregó exitosamente");
}

document.querySelector("#addProduct").addEventListener("submit", addProduct);
