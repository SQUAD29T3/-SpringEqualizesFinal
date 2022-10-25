// LINK API VIA CEP - https://viacep.com.br/

const campoCep = document.querySelector('[name="cep"]');
const estado = document.querySelector('[name="uf"]');
const cidade = document.querySelector('[name="cidade"]');
const bairro = document.querySelector('[name="bairro"]');
const rua = document.querySelector('[name="rua"]');

campoCep.addEventListener("blur", infoEvento => {
    const cep = infoEvento.target.value;
    fetch(`https://viacep.com.br/ws/${cep}/json`)
    .then(respostaServer => {
        return respostaServer.json();
    })
    .then(dadosCep => {
        console.log(dadosCep);
        estado.value = dadosCep.uf;
        cidade.value = dadosCep.localidade;
        bairro.value = dadosCep.bairro;
        rua.value = dadosCep.logradouro;
    })

})


// CONFIRMAÇÃO DA AUTENTICIDADE DOS DADOS - O BOTÃO DE ENVIAR SÓ É LIBERADO SE A OPÇÃO FOR MARCADA
let sim = document.getElementById('sim');
let btn = document.getElementById('botao');

btn.disabled = true;

sim.addEventListener("change", escolha);

function escolha() {
	if (document.querySelector("#sim").checked == true) {
		btn.disabled = false;
	} else {
		btn.disabled = true;
	}
}