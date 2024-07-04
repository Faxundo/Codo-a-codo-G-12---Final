// const url = "https://fakestoreapi.com/products";
const url = "http://localhost:8080/listarProduct";

document.addEventListener("DOMContentLoaded", () => {
  fetchData();
});

const fetchData = async () => {
  try {
    const res = await fetch(url);
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
    clone.querySelector(".card-text").textContent = data[i].description;
    clone.querySelector(".precio").textContent = "$ " + data[i].price;

    fragment.appendChild(clone);
  }

  contenedor.appendChild(fragment);
};



function addProduct () {
  let newProduct = {
    category: document.querySelector("#category").value,
    title: document.querySelector("#title").value,
    description: document.querySelector("#description").value,
    price: document.querySelector("#price").value,
    url: document.querySelector("#url").value,
  };
}