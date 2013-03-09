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
			// 5ft circle of hell: Making dom elements by hand (FUTURE: Use a templating engine, eg. mustache)
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
		if(searchForm.children.name.value) { // Must use children because name is a dom property
			search.name = searchForm.children.name.value
		}
		if($j("select[name=region]").val() != 0) {
			search.region = $j("select[name=region]").val();
		}
		if($j("select[name=region]").val() != 0) {
			search.party = $j("select[name=party]").val();
		}
		// Milestone 3 only: Route to the right file
		var ajaxroute;
		// Name is ignored for now
		if(search.region && search.party) {
			ajaxroute = "/data/findCandidatesByPartyAndRegion.json"
		} else if(search.region) {
			ajaxroute = "/data/findCandidatesByRegion.json"
		} else if(search.party) {
			ajaxroute = "/data/findCandidatesByParty.json"
		} else {
			ajaxroute = "/data/candidate.json" // Only due to lack of findAllCandidates
		}
		// console.log(search, ajaxroute);
		$j.getJSON(ajaxroute, function (response) {
			// Add missing stuff
			if(!response.candidates)
				var response = {candidates: [response]}
			for (var i = response.candidates.length - 1; i >= 0; i--) {
				candidate = response.candidates[i]
				if(!candidate.party)
					candidate.party = {id: search.party, name: $j("select[name=party]").get(0).options[$j("select[name=party]").get(0).options.selectedIndex].text}
				if(!candidate.region)
					candidate.region = {id: search.region, name: $j("select[name=region]").get(0).options[$j("select[name=region]").get(0).options.selectedIndex].text}
			};
			// Render results
			renderTable(response.candidates)
			console.log(response);
		});
		
		return false;
	});
	
});
