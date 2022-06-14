let errorUsername = "Nazwa użytkownika musi zawierać: <br> - min. 3 znaków <br> - max. 20 znaków <br> - nie może zawierać znaków specjalnych <br>";
let errorMail = "Należy podać prawidłowy email. <br>";
let errorPass = "Hasło musi zawierać: <br> - min. 5 znaków <br> - max. 20 znaków <br> - min. 1 wielką literę <br> - min. 1 cyfrę <br> - min. 1 znak specjalny @ $ ! % * ? &amp; <br>";
let errorPass2 = "Oba hasła muszą być takie same. <br>";

let patternUsername = /^(?=.*[A-Za-z])[A-Za-z\d]{3,20}$/;
let patternMail = /.+@.+\..+/;
let patternPass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,20}$/;

document.addEventListener("DOMContentLoaded", function () {

    document.querySelector("[name='name']").addEventListener("change", checkUsername);
    document.querySelector("[name='mail']").addEventListener("change", checkMail);
    document.querySelector("[name='pass']").addEventListener("change", checkPass);
    document.querySelector("[name='pass2']").addEventListener("change", checkPass2);
    document.querySelector("#registration").addEventListener("click", (event) => {
        checkUsername();
        checkMail();
        checkPass();
        checkPass2();
        const errorForm = document.querySelector(".error-inactive");
        if (!empty(errorForm)) {
            document.querySelector("#registration").type = "submit";
        }
    });
});

function checkUsername() {
    let username = document.querySelector("[name='name']").value;
    patternTest(patternUsername, username, errorUsername);
}

function checkMail() {
    let mail = document.querySelector("[name='mail']").value;
    patternTest(patternMail, mail, errorMail);
}

function checkPass() {
    let pass = document.querySelector("[name='pass']").value;
    patternTest(patternPass, pass, errorPass)
    checkPass2();
}

function checkPass2() {
    let pass = document.querySelector("[name='pass']").value;
    let pass2 = document.querySelector("[name='pass2']").value;

    if (pass === pass2) {
        removeError(errorPass2);
    } else {
        displayError(errorPass2);
    }
}

function patternTest(pattern, testVariable, text) {
    if (pattern.test(testVariable)) {
        removeError(text);
    } else {
        displayError(text);
    }
}

function displayError(text) {
    const errorForm = document.querySelector("#error");
    if (!errorForm.innerHTML.includes(text)) {
        errorForm.innerHTML = errorForm.innerHTML + text + "<br>";
        errorForm.classList.replace("error-inactive", "error-active");
    }
}

function removeError(text) {
    const errorForm = document.querySelector("#error");
    errorForm.innerHTML = errorForm.innerHTML.replace(text + "<br>", "");
    if (empty(errorForm.innerHTML)) {
        errorForm.classList.replace("error-active", "error-inactive");
    }
}

function empty(e) {
    switch (e) {
        case "":
        case 0:
        case "0":
        case null:
        case false:
        case undefined:
            return true;
        default:
            return false;
    }
}