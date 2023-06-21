"use strict"

$("#login").click(function(){
	$("#form").prop("action","/login");
	$("#form").submit();	
});

