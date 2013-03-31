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
		<p> Olete võtmas osa 2013. aasta hääletusest. </p><br/>
		<p> Olete oma hääle andnud kandidaadile: Nimi/Häält pole veel antud. </p><br/><br/>
		<div id="mainMenu"><a href="WebLogiValik.html"><button> Hääleta </button></a></div> 
		<div id="mainMenu"><a href="WebLogiEsitaKandidatuur.html"><button> Esita </button></a></div>
		<div id="mainMenu"><a href="WebLogiH22leTyhistus.html"><button> Tühista hääl </button></a></div>
	</div>
	
	<div id="footer">
		<div class="tri"></div>
		<h1>Rakenduses realiseeritud e-valimiste näide on realiseeritud tehnoloogiate praktiseerimise eesmärgil 
		ning ei ole mõeldud reaalsete e-valimiste korraldamiseks. Kokkulangevused reaalse e-valimiste protsessiga on juhuslikud.
		</h1>
	</div>

</body>