//Hasta que el documento que este listo se añaden las funciones. Es callback.
$(document).ready(function(){
			//Obtener canvas y convertirlo en tipo fabric
	  		var canvas = this.__canvas = new fabric.Canvas('canvas', {
			    hoverCursor: 'pointer',
				selection: true
			});
			//Cuando un elemento en el canvas se mueva opacidad cambia
			canvas.on({
				'object:moving': function(e) {
					e.target.opacity = 0.5;
			  	},
			  		'object:modified': function(e) {
			    	e.target.opacity = 1;
				}
			});
			//Obtiene imagen del portapapeles
			function retrieveImageFromClipboardAsBlob(pasteEvent, callback){
				if(pasteEvent.clipboardData == false){
			        if(typeof(callback) == "function"){
			            callback(undefined);
			        }
			    };

			    var items = pasteEvent.clipboardData.items;

			    if(items == undefined){
			        if(typeof(callback) == "function"){
			            callback(undefined);
			        }
			    };

			    for (var i = 0; i < items.length; i++) {
			        if (items[i].type.indexOf("image") == -1) continue;
			        var blob = items[i].getAsFile();
			        if(typeof(callback) == "function"){
			            callback(blob);
			        }
			    }
			}
			//Captura el evento en la ventana del navegador "pegar" y recupera la imagen del portapapeles
			window.addEventListener("paste", function(e){
			    retrieveImageFromClipboardAsBlob(e, function(imageBlob){
			        if(imageBlob){
			        	var img = new Image();
			            img.onload = function(){
			               	var image1 = new fabric.Image(img);
						      	image1.set({
						            originX: "center", 
		        					originY: "center"
						      	});
						      	canvas.centerObject(image1);
						      	canvas.add(image1);
						      	canvas.renderAll();
			           		};
			            var URLObj = window.URL || window.webkitURL;
			            img.src = URLObj.createObjectURL(imageBlob);
			        }
			    });
			}, false);
			//Al dar click en el boton texto se añade un elemento de tipo texto
			$( "#botontexto" ).click(function() {
				var txt=new fabric.IText('Escribir texto', { 
								  fontFamily: 'Roboto',});
				canvas.add(txt);
				canvas.centerObject(txt);
			});
			//Cuando se deja caer una imagen en el canvas esta se convierte en un blob y se añade al canvas
			$("canvas").on('dragover', function(e) {e.preventDefault();return false;});
				$("canvas").on('drop', function(e) {
			    	e.preventDefault();
			    		var src=e.originalEvent.dataTransfer.files[0];
			    	if(src!=null){
			    		if(src.type.match(/image.*/)){
							var reader = new FileReader();
							reader.onload = function(e){
								var image = new Image();
								image.src=e.target.result;
								image.onload=function(){
									add(image);
								}
							};
							reader.readAsDataURL(src);	
						}
					}else{
			    	e.originalEvent.dataTransfer.items[0].getAsString(function(url){
			        	var img1 = new Image();
		    			img1.src = url;
		    				img1.onload = function(){
		    					add(img1);
		    				}
						});
			    	}
					});
//Al dar clic al boton guardar se convierte el canvas de fabric en su definicion de objeto JSON y se envia a el servidor
			$("#botonguardar").click(function() {
				var sv=JSON.stringify(canvas);
				console.log(sv);
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
//Al dar clic en el boton eliminar se toma el elemento que esta activo y es removido del canvas
			$("#botoneliminar").click(function() {
				canvas.remove(canvas.getActiveObject());
			});

			function add(img1){
				var image1 = new fabric.Image(img1);
				image1.set({
					originX: "center",
		        	originY: "center"
				});
				canvas.centerObject(image1);
				canvas.add(image1);
				canvas.renderAll();
			}
//Al dar clic en el cambas se obtiene el objeto y en caso de contener texto este se envia a una api TTS.
			$("canvas").click(function(e){
			  var txt = canvas.getActiveObject().text;
			  Decir(txt);
			});
                        var nsn = $('#cVV').val();
                        if(nsn!==""){
                            canvas.loadFromJSON(nsn);
                        }
//Se consume una variable de tipo texto y con el api de TTS se envia el recurso a un elemento de audio que se autoreproduce
			function Decir(say){
				var voicelist = responsiveVoice.getVoices();
				responsiveVoice.speak(say,"Spanish Latin American Female");
			}
	  	});