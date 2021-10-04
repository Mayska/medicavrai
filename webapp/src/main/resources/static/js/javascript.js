function player(frequence){
var notes = ["A","B","C","D","E","F","G"]
for (var note in notes) {
   //playTone(note)
}

	// frequence.forEach(
	//	element =>
	//	playSound('square', element, 2.5, 220, 0.8)
//	)	    	 
	//changeCss()
	
}

function changeCss(){
	var titre = document.getElementById("cardTitre");
	var element = document.getElementById("card")
	titre.style.color = "red";
	element.classList.remove('bg-success');
	element.classList.add('bg-warning');
}
