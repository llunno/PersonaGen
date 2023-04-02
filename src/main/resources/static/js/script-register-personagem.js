const isHumanElement = document.querySelector('#isHuman');
const especieElement = document.querySelector('#especie');

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