function otsi() {
		var firstname = $("#name").val();
		var partyCode = $("#party").val();
		var areaCode = $("#area").val();
		var partyName = $("#party option:selected").text();
		var regionName = $("#area option:selected").text();
		$('*').css('cursor','wait');

		$.ajax({
			type : 'GET',
			url: '/ValimisedSnoopy/candSearch',
			 data: { 
    		 'firstname': firstname, 
    		 'lastname': '',
    		 'party': partyCode,
    		 'area': areaCode
				},
			dataType : 'json',
			success : function(data) {
				var candidates = data;
				createTable(candidates, partyName, regionName);
				$('*').css('cursor','default');
			},
			error : function(xhr, ajaxOptions, thrownError) {
				$('*').css('cursor','default');
				alert(thrownError);
			}
		});
}

function createTable(candidates, givenParty, givenRegion) {
	//clear previous table
	$('#tabel tbody tr').remove();

	var name, region, party;

	for (i in candidates) {
		//get values from json data
		name = candidates[i]['firstname'] + ' ' + candidates[i]['lastname'];
		if (givenParty == '')
			party = candidates[i]['party'];
		else
			party = givenParty;
		if (givenRegion == '')
			region = candidates[i]['area'];
		else
			region = givenRegion;

		//create new row with data
		var cols = new Array();

//		kandidaadinimi="klikinime('"+name+"')";
//		kandidaadilinn="klikinime('"+region+"')";
//		kandidaadipartei="klikinime('"+party+"')";
		
		//kandidaadiInfo="klikinime('"+name+"','"+region+"','"+party+"')";
		
		//asi="klikinime('"+name+"')";
		kandidaadiInfo="tere";

		cols[0] = $("<td></td>").text(name).attr("onClick",kandidaadiInfo);
		cols[1] = $("<td></td>").text(region).attr("onClick",kandidaadiInfo);
		cols[2] = $("<td></td>").text(party).attr("onClick",kandidaadiInfo);
		var row = $("<tr></tr>");//.attr("onClick",kandidaadiInfo);
		//$("td").click(function(){klikinime(kandidaadinimi,kandidaadilinn,kandidaadipartei);});


		for (j in cols)
			row.append(cols[j]);
		//append data to table
		row.addClass("candidateClickable");
		$("#tabel tbody").append(row);
		//$(".candidateClickable").click(klikinime(name,region,party));
		//row.attr("onClick", klikinime(name,region,party));
	}
	//display table and apply tablesorter
	if ($("#tabel tbody tr").size() > 0) {
		$('#tabel').show();
		$("#tabel").trigger("clearCache");
		// let the plugin know that we made a update 
		$("#table").trigger("update");
		// set sorting column and direction, this will sort on the first column 
		//var sorting = [[0,0]]; 
		// sort on the first column 
		//$("table").trigger("sorton",[sorting]);
	} else {
		$('#tabel').hide();
	}
}

function getCandidateInfo(candidate) {
	$('#partyInfo').text(candidate.party.name);
	$('#regionInfo').text(candidate.region.name);
	$('#personInfo').text(candidate.person.name);
}