$(document).ready(function(){
	
	$(".js-deleteBtn").click(function(){
		$(".js-delete").css("display", "block");
        myAnimation(".js-delete", "zoomIn", "zoomOut");
	});
	
	$(".js-no").click(function(){ 
        setTimeout(function(){
            $(".js-delete").css("display", "none");
        }, 1000);
        myAnimation(".js-delete", "zoomOut", "zoomIn");
    });
	
	/*=== Functions ===*/
	function myAnimation(element, newAnimation, oldAnimation) {
		if(oldAnimation) { 
	        $(element).removeClass("animated " + oldAnimation);   
	        $(element).addClass("animated " + newAnimation); 
	    } 
	}
	
});