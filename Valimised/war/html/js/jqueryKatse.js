function validateThis(){
		var y = document.getElementById("Erakond").value;
		var x = document.getElementById("Piirkond").value;
		if (y == 0) {
			document.getElementById("message").innerHTML="Erakond valimata!";
		}
		if (x == 0) {
			document.getElementById("message2").innerHTML="Piirkond valimata!";
		} 
};
