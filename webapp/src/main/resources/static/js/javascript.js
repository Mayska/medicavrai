function player(frequences){
	for (const frequence of frequences) {
		playSound('square', frequence, 2.5, 220, 0.8)
    }
    changeCss()
}

function changeCss(){
	var titre = document.getElementById("cardTitre");
	var element = document.getElementById("card")
	element.classList.remove('bg-success');
	element.classList.add('bg-warning');
}

function changeCssInv(){
	var titre = document.getElementById("cardTitre");
	var element = document.getElementById("card")
	titre.style.color = "red";
	element.classList.remove('bg-warning');
	element.classList.add('bg-success');
}

