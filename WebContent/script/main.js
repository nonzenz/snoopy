function simulate(){
	document.body.style.cursor  = 'wait';
	setTimeout('stopCursor()',1000);
};

function stopCursor(){
	document.body.style.cursor  = 'default';
};

function validate(){
	var status = true;
	var x = document.getElementById("era").value;
	var y = document.getElementById("piir").value;
	if (y == 0) {
		document.getElementById("message").innerHTML="     Piirkond valimata!     "; status = false;
	}
	if (x == 0) {
		document.getElementById("message2").innerHTML="     Erakond valimata!     "; status = false;
	} 
	return status;
};

$.noConflict();
jQuery(document).ready(function () {
    /*
	jQuery("#home").click(function(){
		jQuery("#cont").load("WebHome.html .content");
	});
	jQuery("#statistika").click(function(){
		jQuery("#cont").load("WebStatistika.html .content");
	});
	jQuery("#valijale").click(function(){
		jQuery("#cont").load("WebValijale.html .content");
	});
	jQuery("#kandi").click(function(){
		jQuery("#cont").load("WebKandidaadid.html .content");
	});
	jQuery("#logi").click(function(){
		jQuery("#cont").load("WebLogi.html .content");
	});
	jQuery("#rega").click(function(){
		jQuery("#cont").load("WebKandidaadiReg.html .content");
	}); 
    */
	function renderTable (candidates) {
		var tableBody = jQuery("#candidate-list tbody");
		tableBody.empty();
		for (var i = candidates.length - 1; i >= 0; i--) {
			var candidateRow = jQuery("<tr>").data("id", candidates[i].id);
			jQuery("<td>").text(candidates[i].id).appendTo(candidateRow);
			jQuery("<td>").text(candidates[i].person.name).appendTo(candidateRow);
			jQuery("<td>").text(candidates[i].region.name).appendTo(candidateRow);
			jQuery("<td>").text(candidates[i].party.name).appendTo(candidateRow);
			tableBody.append(candidateRow);
		};
	};

	jQuery(".Otsi").click(function () {

		var searchForm = jQuery("#search-form");
		var search = {};
		//Children- property of an Element
		if(searchForm.children.name.value) {
			search.name = searchForm.children.name.value;
		}
		if(jQuery("select[name=region]").val() != 0) {
			search.region = jQuery("select[name=region]").val();
		}
		if(jQuery("select[name=region]").val() != 0) {
			search.party = jQuery("select[name=party]").val();
		}
		var ajaxroute;
		if(search.region && search.party) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByPartyAndRegion.json";
		} else if(search.region) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByRegion.json";
		} else if(search.party) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByParty.json";
		} else {
			ajaxroute = "http://meievalimised.appspot.com/data/candidate.json";
		}
		// console.log(search, ajaxroute);
		jQuery.getJSON(ajaxroute, function (response) {
			if(!response.candidates)
				var response = {candidates: [response]};
			for (var i = response.candidates.length - 1; i >= 0; i--) {
				candidate = response.candidates[i];
				if(!candidate.party)
					candidate.party = {id: search.party, name: jQuery("select[name=party]").get(0).options[jQuery("select[name=party]").get(0).options.selectedIndex].text};
				if(!candidate.region)
					candidate.region = {id: search.region, name: jQuery("select[name=region]").get(0).options[jQuery("select[name=region]").get(0).options.selectedIndex].text};
			};
			//Result
			renderTable(response.candidates);
			console.log(response);
		});

		return false;
	});
});

