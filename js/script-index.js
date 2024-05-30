const email = document.querySelector("#email");
const password = document.querySelector("#password");
const errorEmail = document.querySelector("#error-email");
const errorPassword = document.querySelector("#error-password");

const emailRegister = document.querySelector("#email-register");
const passwordRegister = document.querySelector("#password-register");
const passwordRepeat = document.querySelector("#password-repeat");
const errorRegisterEmail = document.querySelector("#error-register-email");
const errorRegisterPassword = document.querySelector("#error-register-password");
const errorPasswordRepeat = document.querySelector("#error-password-repeat");

const formLogin = document.querySelector("#form-login");
const formRegister = document.querySelector("#form-register");

const clearValidations = () => {
  if (errorEmail) errorEmail.textContent = "";
  if (errorPassword) errorPassword.textContent = "";
  if (errorRegisterEmail) errorRegisterEmail.textContent = "";
  if (errorRegisterPassword) errorRegisterPassword.textContent = "";
  if (errorPasswordRepeat) errorPasswordRepeat.textContent = "";
};

const validateLogin = () => {
  let validation = true;
  if (!email.value.trim()) {
    errorEmail.textContent = "Necesitas colocar un correo electrónico";
    validation = false;
  }
  if (!password.value.trim()) {
    errorPassword.textContent = "Necesitas colocar una contraseña";
    validation = false;
  }
  return validation;
};

const validateRegister = () => {
  let validation = true;
  if (!emailRegister.value.trim()) {
    errorRegisterEmail.textContent = "Necesitas colocar un correo electrónico";
    validation = false;
  }
  if (!passwordRegister.value.trim()) {
    errorRegisterPassword.textContent = "Necesitas colocar una contraseña";
    validation = false;
  }
  if (password.value.length < 8 || password.value.length > 16) {
    errorRegisterPassword.textContent =
      "La contraseña debe contener entre 8 y 16 caracteres";
    validation = false;
  }
  if (!passwordRepeat.value.trim()) {
    errorPasswordRepeat.textContent = "Necesitas repetir la contraseña";
    validation = false;
  }
  return validation;
};

document
  .querySelector("#form-login")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    clearValidations();

    if (validateLogin()) {
      formLogin.submit();
    }
  });

document
  .querySelector("#form-register")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    clearValidations();

    if (validateRegister()) {
      formRegister.submit();
    }
  });
