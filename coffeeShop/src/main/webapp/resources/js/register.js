$(document).ready(function() {
	$("#email").focusout(checkUser);
});

var checkemail;
function checkUser(event){

	 var username = $('#email').val();
		$.ajax("rest/register/check", {
			"type" : "post",
			"data" : {
				"username" : username
			}
		}).done(function(response) {
			if(response == -1) {
				$("#user_name_check").text("User name already exist.");
				checkemail=-1;
			} else {
				$("#user_name_check").text("User name is ok!!");
				checkemail=1;
			}
		}).fail(function() {
			console.log("Server wrong");
		})
	 
}

