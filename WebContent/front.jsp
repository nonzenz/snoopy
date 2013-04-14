<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>E-valimised - sinu tuleviku algus!</title>
	
	<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>

<body>
	<script>
  // Additional JS functions here
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '386869324759549', // App ID
      channelUrl : '//localhost:8080/ValimisedSnoopy/channel.html', // Channel File
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });

    // Additional init code here
    FB.getLoginStatus(function(response) {
    	  if (response.status === 'connected') {
    	    // connected
    	  } else if (response.status === 'not_authorized') {
    	    // not_authorized
    		  login();
    	  } else {
    	    // not_logged_in
    		  login();
    	  }
    	 });
  };
  function login() {
	    FB.login(function(response) {
	        if (response.authResponse) {
	            // connected
	        	testAPI();
	        } else {
	            // cancelled
	        }
	    });
	}
  function testAPI() {
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	        console.log('Good to see you, ' + response.name + '.');
	    });
	}
  // Load the SDK Asynchronously
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
</script>
	<div class="hoiatus">Antud rakendus ei ole mõeldud kasutamiseks reaalsetel valimistel!</div>
	
	<div id="loginPageContainer">
		<form name="fm" action="FBauth" method="get"></form>
		<a onClick="FB.login();" class="button big blue">Logi Sisse</a>
		<a href="WebHome.html" class="button big orange">Sisene külalisena</a>
	</div>
	
	<p class="note">Soovitame kasutada Chrome'i või Safari brauserit.</p>
	
	<div id="footer">
		<div class="tri"></div>
		<h1>Rakenduses realiseeritud e-valimiste näide on realiseeritud tehnoloogiate praktiseerimise eesmärgil 
		ning ei ole mõeldud reaalsete e-valimiste korraldamiseks. Kokkulangevused reaalse e-valimiste protsessiga on juhuslikud.
		</h1>
	</div>
	

</body>
