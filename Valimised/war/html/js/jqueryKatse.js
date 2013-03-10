function validate(){
		var y = document.getElementById("Erakond").value;
		var x = document.getElementById("Piirkond").value;
		if (y == 0) {
			$('div.message').html("Erakond valimata!");
			//document.getElementById("message").innerHTML="Erakond valimata!";
		}
		if (x == 0) {
			//document.getElementById("message2").innerHTML="Piirkond valimata!";
			$('div.message2').html("Piirkond valimata!");
		} 
};
