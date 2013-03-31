<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<link href="css/login.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/mainMenu.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/print.css" rel="stylesheet" type="text/css" media="print"/>
</head>

<body>

	<div id="loginPageContainer">
		<p> TERE TULEMAST!</p><br/>
		<p> Teie nimi: <c:out value="${user.firstName} ${user.lastName}" /></p>  
		<p> Teie piirkond: Harjumaa</p>
		<p> Olete v�tmas osa 2013. aasta h��letusest. </p><br/>
		<p> Olete oma h��le andnud kandidaadile: Nimi/H��lt pole veel antud. </p><br/><br/>
		<div id="mainMenu"><a href="WebLogiValik.html"><button> H��leta </button></a></div> 
		<div id="mainMenu"><a href="WebLogiEsitaKandidatuur.html"><button> Esita </button></a></div>
		<div id="mainMenu"><a href="WebLogiH22leTyhistus.html"><button> T�hista h��l </button></a></div>
	</div>
	
	<div id="footer">
		<div class="tri"></div>
		<h1>Rakenduses realiseeritud e-valimiste n�ide on realiseeritud tehnoloogiate praktiseerimise eesm�rgil 
		ning ei ole m�eldud reaalsete e-valimiste korraldamiseks. Kokkulangevused reaalse e-valimiste protsessiga on juhuslikud.
		</h1>
	</div>

</body>