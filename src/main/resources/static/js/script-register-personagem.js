const isHumanElement = document.querySelector('#isHuman');
const especieElement = document.querySelector('#especie');

document.querySelector("#btn-submit-personagem").disabled = true;


isHumanElement.addEventListener('change', function () {
    if (isHumanElement.value === 'true') {
        especieElement.value = 'Humano';
        especieElement.readOnly = true;
    } else {
        especieElement.value = '';
        especieElement.readOnly = false;
    }
});

const checkboxesPersonalidade = document.querySelectorAll(".checkbox-radiotype-personalidade");
checkboxesPersonalidade.forEach(checkbox => {
    checkbox.addEventListener("change", function() {
        checkboxesPersonalidade.forEach(checkbox => {
            checkbox.checked = false;
        });
        this.checked = true;
    });
});

const checkboxAparencia = document.querySelectorAll(".checkbox-radiotype-aparencia");
checkboxAparencia.forEach(checkbox => {
    checkbox.addEventListener("change", function() {
        checkboxAparencia.forEach(checkbox => {
            checkbox.checked = false;
        });
        this.checked = true;
    });
});

let allcheckboxes = document.querySelectorAll(".checkbox-radiotype-personalidade, .checkbox-radiotype-aparencia, .checkbox-radiotype-habilidade");

allcheckboxes.forEach(checkbox => {
    checkbox.addEventListener("change", function() {
        let isCheckedPersonalidade = Array.prototype.slice.call(checkboxesPersonalidade).some(checkbox => checkbox.checked);
        let isCheckedAparencia = Array.prototype.slice.call(checkboxAparencia).some(checkbox => checkbox.checked);
        let checkboxHabilidade = document.querySelectorAll(".checkbox-radiotype-habilidade");
        let isCheckedHabilidade = Array.prototype.slice.call(checkboxHabilidade).some(checkbox => checkbox.checked);

        if (isCheckedPersonalidade && isCheckedAparencia && isCheckedHabilidade) {
            document.querySelector("#btn-submit-personagem").disabled = false;
        } else {
            document.querySelector("#btn-submit-personagem").disabled = true;
        }
    });
});