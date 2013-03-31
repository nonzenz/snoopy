<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>E-valimised - sinu tuleviku algus!</title>
	
	<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>

<body>

	<div id="loginPageContainer">
		<form action="login" method="POST">
			<table>
				<tr>
					<td width="22%">&nbsp;</td>
					<td width="78%">&nbsp;</td>
				</tr>
				<tr>
					<td><label>Kasutajanimi: </label></td>
				    <td><input type="text" name="uname" /></td>
			  	</tr>
			    <tr>
			    	<td><label>Parool: </label></td>
			    	<td><input type="password" name="password" /></td>
			    </tr>
			  	<tr>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
			    </tr>
			</table>
			<input class="button blue" type="submit" value="Logi Sisse">
		</form>
	    
	</div>
	
	<p class="note">Soovitame kasutada Chrome'i või Safari brauserit.</p>
	
	<div id="footer">
		<div class="tri"></div>
		<h1>Rakenduses realiseeritud e-valimiste näide on realiseeritud tehnoloogiate praktiseerimise eesmärgil 
		ning ei ole mõeldud reaalsete e-valimiste korraldamiseks. Kokkulangevused reaalse e-valimiste protsessiga on juhuslikud.
		</h1>
	</div>

</body>