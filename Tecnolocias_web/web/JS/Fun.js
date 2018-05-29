$(document).ready(function(){
	  		var canvas = this.__canvas = new fabric.Canvas('canvas', {
			    hoverCursor: 'pointer',
				selection: true
			});

			canvas.on({
				'object:moving': function(e) {
					e.target.opacity = 0.5;
			  	},
			  		'object:modified': function(e) {
			    	e.target.opacity = 1;
				}
			});

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

			$( "#botontexto" ).click(function() {
				var txt=new fabric.IText('Escribir texto', { 
								  fontFamily: 'Roboto',});
				canvas.add(txt);
				canvas.centerObject(txt);
			});

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
					},
					error: function(xhr) {
						alert("Error!");
					}
				});
			});
			
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
			$("canvas").click(function(e){
			  var txt = canvas.getActiveObject().text;
			  Decir(txt);
			});

			function Decir(say){
				var voicelist = responsiveVoice.getVoices();
				responsiveVoice.speak(say,"Spanish Latin American Female");
			}
	  	});