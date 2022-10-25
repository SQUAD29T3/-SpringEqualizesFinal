// IMAGENS
const imgPadrao = document.querySelector('.imgPadrao');
const imgEscola = document.querySelector('.escola');
const imgEmpresa = document.querySelector('.empresa');


// OPTION
const escolas = document.getElementById('escolas');
const empresas = document.getElementById('empresas');


escolas.addEventListener("change", escolha);
empresas.addEventListener("change", escolha);

function escolha() {

	if (escolas.checked == true) {

		imgEscola.style.display = "block";
		imgEmpresa.style.display = "none";
		imgPadrao.style.display = "none";
        
	} else if (empresas.checked == true) {
		
		imgEscola.style.display = "none";
		imgPadrao.style.display = "none";
		imgEmpresa.style.display = "block";

	}
}

