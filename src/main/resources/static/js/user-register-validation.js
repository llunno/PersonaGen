function consultarCEP() {
    limparFormulario();
    const cep = document.querySelector("#cep").value;
    if (cep !== "") {
        const url = "/api/endereco/" + cep;
        fetch(url)
            .then(response => response.json())
            .then(data => {
                if (data === undefined || data == null) {
                    document.querySelector("#logradouro").value = "CEP não encontrado";
                    document.querySelector("#bairro").value = "CEP não encontrado";
                    document.querySelector("#cidade").value = "CEP não encontrado";
                    document.querySelector("#estado").value = "CEP não encontrado";
                } else {
                    document.querySelector("#logradouro").value = data.logradouro;
                    document.querySelector("#bairro").value = data.bairro;
                    document.querySelector("#cidade").value = data.localidade;
                    document.querySelector("#estado").value = data.uf;
                }
            })
    }
}

function limparFormulario() {
    document.querySelector("#logradouro").value = "";
    document.querySelector("#bairro").value = "";
    document.querySelector("#cidade").value = "";
    document.querySelector("#estado").value = "";
}

function checkPassword() {
    const password = document.querySelector("#senhaInput");
    const repeatPassword = document.querySelector("#senhaRepeat");
    const btnSubmit = document.querySelector("#btnSubmit");
    if (password.value !== repeatPassword.value) {
        repeatPassword.setCustomValidity("As senhas não coincidem!");
    }
    else {
        repeatPassword.setCustomValidity("");
        if (btnSubmit.disabled === true) {
            btnSubmit.disabled = false;
        }
    }
}