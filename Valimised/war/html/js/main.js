function isMobile(){
	if (screen.width <= 800) {
		window.location = "MobHome.html";
	}
};

function myFunction(){
	document.body.style.cursor  = 'wait';
	setTimeout('stopCursor()',1000);
};

function stopCursor(){
	document.body.style.cursor  = 'default';
};

var $j = jQuery.noConflict();

$j(document).ready(function () {
	
	isMobile();
    
	$j("#home").click(function(){
		$j("#cont").load("WebHome.html .content");
	});
	$j("#statistika").click(function(){
		$j("#cont").load("WebStatistika.html .content");
	});
	$j("#valijale").click(function(){
		$j("#cont").load("WebValijale.html .content");
	});
	$j("#kandi").click(function(){
		$j("#cont").load("WebKandidaadid.html .content");
	});
	$j("#logi").click(function(){
		$j("#cont").load("WebLogi.html .content");
	}); 
	
    
	$j("a").click(function(){
    	$j.ajax({
    		url: $j(this).attr("href"),
    		success: function(response) {
    			$j("#content").html(response);
    		}
    	});
    });
    
	function renderTable (candidates) {
		var tableBody = $j("#candidate-list tbody");
		tableBody.empty();
		for (var i = candidates.length - 1; i >= 0; i--) {
			var candidateRow = $j("<tr>").data("id", candidates[i].id);
			$j("<td>").text(candidates[i].id).appendTo(candidateRow);
			$j("<td>").text(candidates[i].person.name).appendTo(candidateRow);
			$j("<td>").text(candidates[i].region.name).appendTo(candidateRow);
			$j("<td>").text(candidates[i].party.name).appendTo(candidateRow);
			tableBody.append(candidateRow);
		};
	};

	$j(".otsi").click(function () {

		var searchForm = $j("#search-form");
		var search = {};
		//Children- property of an Element
		if(searchForm.children.name.value) {
			search.name = searchForm.children.name.value
		}
		if($j("select[name=region]").val() != 0) {
			search.region = $j("select[name=region]").val();
		}
		if($j("select[name=region]").val() != 0) {
			search.party = $j("select[name=party]").val();
		}
		var ajaxroute;
		if(search.region && search.party) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByPartyAndRegion.json"
		} else if(search.region) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByRegion.json"
		} else if(search.party) {
			ajaxroute = "http://meievalimised.appspot.com/data/findCandidatesByParty.json"
		} else {
			ajaxroute = "http://meievalimised.appspot.com/data/candidate.json"
		}
		// console.log(search, ajaxroute);
		$j.getJSON(ajaxroute, function (response) {
			if(!response.candidates)
				var response = {candidates: [response]}
			for (var i = response.candidates.length - 1; i >= 0; i--) {
				candidate = response.candidates[i]
				if(!candidate.party)
					candidate.party = {id: search.party, name: $j("select[name=party]").get(0).options[$j("select[name=party]").get(0).options.selectedIndex].text}
				if(!candidate.region)
					candidate.region = {id: search.region, name: $j("select[name=region]").get(0).options[$j("select[name=region]").get(0).options.selectedIndex].text}
			};
			//Result
			renderTable(response.candidates)
			console.log(response);
		});

		return false;
	});
});
