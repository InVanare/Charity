let errorUsername = "Nazwa użytkownika musi zawierać: <br> - min. 3 znaków <br> - max. 20 znaków <br> - nie może zawierać snaków specjalnych";
let errorMail = "";
let errorPass = "Hasło musi zawierać: <br> - min. 5 znaków <br> - max. 20 znaków <br> - min. 1 wielką literę <br> - min. 1 cyfrę <br> - min. 1 znak specjalny @ $ ! % * ? &";
let errorPass2 = "";

document.addEventListener("DOMContentLoaded", function () {

    document.querySelector("[name='name']").addEventListener("change", checkUsername);
    document.querySelector("[name='mail']").addEventListener("change", checkMail);
    document.querySelector("[name='pass']").addEventListener("change", checkPass);
    document.querySelector("[name='pass2']").addEventListener("change", checkPass2);
});

function checkUsername() {
    let patternUsername = /(?=.*[A-Za-z])[A-Za-z\d]{3,20}/;
    let username = document.querySelector("[name='name']").value;

    if (patternUsername.test(username)) {
        removeError(errorUsername);
        console.log("remove");
    } else {
        displayError(errorUsername);
        console.log("display");
    }
}

function checkMail() {

}

function checkPass() {
    let patternPass = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,20}/;

    let pass = document.querySelector("[name='pass']").value;

    if (patternPass.test(pass)) {
        removeError(errorPass);
        console.log("remove");
    } else {
        displayError(errorPass);
        console.log("display");
    }
}

function checkPass2() {

}

function displayError(text) {
    const errorForm = document.querySelector("#error");
    if (!errorForm.innerHTML.includes(text)) {
        errorForm.innerHTML = errorForm.innerHTML + text + ".<br>";
        errorForm.classList.replace("error-inactive", "error-active");
    }
}

function removeError(text) {
    const errorForm = document.querySelector("#error");
    errorForm.innerHTML = errorForm.innerHTML.replace(text + ".<br>", "");
    console.log(errorForm.innerHTML);
    if (empty(errorForm.innerHTML)) {
        errorForm.classList.replace("error-active", "error-inactive");
        console.log("od remove");
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