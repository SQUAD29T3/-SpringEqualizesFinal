// CÓDIGO PARA HABILITAR/DESABILITAR O BOTÃO DE EXCLUIR CONTA
let sim = document.getElementById('sim');
let nao = document.getElementById('nao');
let btn = document.getElementById('botao');

btn.disabled = true;

sim.addEventListener("change", escolha);
nao.addEventListener("change", escolha);

function escolha() {
    if (document.querySelector("#sim").checked == true) {
        btn.disabled = false;
    } else {
        btn.disabled = true;
    }
}