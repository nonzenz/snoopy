function isMobile(){
	if (screen.width <= 800) {
		window.location = "MobHome.html";
	}
}

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
    	return false;
});
