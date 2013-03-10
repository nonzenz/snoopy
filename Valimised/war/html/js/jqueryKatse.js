function validate(){
		var status = true;
		var y = document.getElementById("era").value;
		var x = document.getElementById("piir").value;
		if (y == 0) {
			document.getElementById("message").innerHTML="Erakond valimata!"; status = false;
		}
		if (x == 0) {
			document.getElementById("message2").innerHTML="Piirkond valimata!"; status = false;
		} 
		return status;
};
