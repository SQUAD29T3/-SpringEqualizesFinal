
//REALIZA O SCROLL
function subirTela() {

    window.scrollTo({
        top: 0,
        left: 0,
        behavior: 'smooth'
    });

}


// CONDIÇÃO PARA MOSTRAR OU NÃO O BOTÃO

function btnScroll() {

    if (window.scrollY < 200) {
        document.getElementById("icon-top").style.display = "none";

    } else {
        document.getElementById("icon-top").style.display = "block";
    }
};

// Monitora o scroll. 
window.addEventListener('scroll', btnScroll);



// MENU - ADMIN
function menuToggle() {

    let menuArea = document.getElementById("menu-area");
    
    if (menuArea.classList.contains('menu-aberto') == true) {
        
        menuArea.classList.remove('menu-aberto');

    } else {
        menuArea.classList.add('menu-aberto');
    }

}

