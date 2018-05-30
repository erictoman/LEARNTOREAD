$(document).ready(function(){
			$("#botonguardar").click(function() {
				
				$.ajax({
					url: "Save",
					type: "get", //send it through get method
					data: {
						canvas:sv,
						nom:$('#nom').val()
					},
					success: function(response) {
						alert("¡GUARDADO!");
                                                window.parent.location='Diagramas'
					},
					error: function(xhr) {
						alert("Error!");
					}
				});
			});
			
			
			
	  	});