document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();

                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();

                });
            });

            // Form submit
            //this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {

            switch (this.currentStep - 1) {
                case 1:
                    validationStep1();
                    break;
                case 2:
                    validationStep2();
                    break;
                case 3:
                    validationStep3();
                    break;
                case 4:
                    validationStep4();
                    const errorForm = document.querySelector(".error-inactive");
                    if (empty(errorForm)) {
                        this.currentStep--;
                    }
                    break;
            }
            this.$step.innerText = this.currentStep;

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            insertSummary();
        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }

    function validationStep1() {
        let isPresent = false;
        document.querySelectorAll("[name='categories']").forEach(checkbox => {
            if (checkbox.checked) {
                isPresent = true;
            }
        });
        if (isPresent == false) {
            displayError("Musisz wybrać przynajmniej jedną kategorię");
        } else {
            removeError("Musisz wybrać przynajmniej jedną kategorię");
        }
    }

    function validationStep2() {
        if (document.querySelector("[name='quantity']").value > 0) {
            removeError("Musisz zapełnić chociaż jeden worek");
        } else {
            displayError("Musisz zapełnić chociaż jeden worek");
        }
    }

    function validationStep3() {
        let isPresent = false;
        document.querySelectorAll("[name=institution]").forEach(radio => {
            if (radio.checked) {
                isPresent = true;
            }
        });
        if (isPresent) {
            removeError("Musisz wybrać fundację, której chcesz przekazać dary");
        } else {
            displayError("Musisz wybrać fundację, której chcesz przekazać dary")
        }
    }

    function validationStep4() {
        let street = document.querySelector("[name=street]");
        let city = document.querySelector("[name=city]");
        let zipCode = document.querySelector("[name=zipCode]");
        let phone = document.querySelector("[name=phone]");
        let pickUpDate = document.querySelector("[name=pickUpDate]");
        let pickUpTime = document.querySelector("[name=pickUpTime]");
        let patterZipCode = /^[0-9]{2}-[0-9]{3}$/;
        let patterPhone = /(?<!\w)(\(?(\+|00)?48\)?)?[ -]?\d{3}[ -]?\d{3}[ -]?\d{3}(?!\w)/;

        if (empty(street.value) || empty(city.value) || empty(zipCode.value) || empty(phone.value)) {
            displayError("Musisz podać prawidłowe dane do odbioru");
        } else {
            if (patterZipCode.test(zipCode.value) && patterPhone.test(phone.value)) {
                removeError("Musisz podać prawidłowe dane do odbioru");
            } else {
                displayError("Musisz podać prawidłowe dane do odbioru");
            }
        }

        if (empty(pickUpDate.value) || empty(pickUpTime.value)) {
            displayError("Musisz podać prawidłowy czas odbioru");
        } else {
            removeError("Musisz podać prawidłowy czas odbioru");
        }
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

    function insertSummary() {
        let quantity = document.querySelector("[name='quantity']").value;
        let street = document.querySelector("[name=street]").value;
        let city = document.querySelector("[name=city]").value;
        let zipCode = document.querySelector("[name=zipCode]").value;
        let phone = document.querySelector("[name=phone]").value;
        let pickUpDate = document.querySelector("[name=pickUpDate]").value;
        let pickUpTime = document.querySelector("[name=pickUpTime]").value;
        let pickUpComment = document.querySelector("[name=pickUpComment]").value;

        document.querySelector("#summary_bags").innerHTML = quantity;
        document.querySelectorAll("[name=institution]").forEach(radio => {
            if (radio.checked) {
                document.querySelector("#summary_institution").innerHTML = radio.title;
            }
        });
        document.querySelector("#summary_street").innerHTML = street;
        document.querySelector("#summary_city").innerHTML = city;
        document.querySelector("#summary_zipCode").innerHTML = zipCode;
        document.querySelector("#summary_phone").innerHTML = phone;
        document.querySelector("#summary_pickUpDate").innerHTML = pickUpDate;
        document.querySelector("#summary_pickUpTime").innerHTML = pickUpTime;
        document.querySelector("#summary_pickUpComment").innerHTML = pickUpComment;
    }
});
