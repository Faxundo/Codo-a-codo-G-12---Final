document.addEventListener("DOMContentLoaded", function() {
    includeHTML();
  });
  
  function includeHTML() {
    const elements = document.querySelectorAll("[data-include-html]");
    elements.forEach(el => {
      const file = el.getAttribute("data-include-html");
      if (file) {
        fetch(file)
          .then(response => response.text())
          .then(data => {
            el.innerHTML = data;
            el.removeAttribute("data-include-html");
            includeHTML(); 
          })
          .catch(err => console.error(`Error incluyendo HTML: ${err}`));
      }
    });
  }