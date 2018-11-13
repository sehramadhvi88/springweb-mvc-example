$(document).ready(function(){
	
	$("#request-link").click(function(e){
		
			e.preventDefault();
			console.log("ctx="+ctx);
			$.post(ctx+"/resource/request",
					$("form").serialize(),
					function(data){
				alert(data);
			})
			return false;
	});


});


