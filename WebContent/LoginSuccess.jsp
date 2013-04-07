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
		<c:choose>
			<c:when test="${user.isCandidate == true}">
				<p> Olete kandideerinud 2013. aasta hääletusel. </p><br/>
			</c:when>
			<c:otherwise>
				<p> Te ei ole veel kandideerinud! </p> <div id="mainMenu"><a href="WebKandidaadiReg.html"><button> Kandideeri </button></a></div><br/>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${user.hasVoted == true}">
				<p> Olete juba hääletanud. </p><br/>
				<div id="mainMenu"><a href="WebLogiH22leTyhistus.html"><button> Soovite häält tühistada? </button></a></div>
			</c:when>
			<c:otherwise>
				<p> Te ei ole veel hääletanud! </p><br/>
				<div id="mainMenu"><a href="WebH22leta.html"><button> Hääleta </button></a></div> 
			</c:otherwise>
		</c:choose>
	</div>
	
	<div id="footer">
		<div class="tri"></div>
		<h1>Rakenduses realiseeritud e-valimiste näide on realiseeritud tehnoloogiate praktiseerimise eesmärgil 
		ning ei ole mõeldud reaalsete e-valimiste korraldamiseks. Kokkulangevused reaalse e-valimiste protsessiga on juhuslikud.
		</h1>
	</div>

</body>