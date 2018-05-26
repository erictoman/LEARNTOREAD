/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcus
 */
public class Lectura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        out.println("<html>\n" +
"  <head>\n" +
"	  	<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/fabric.js/2.2.4/fabric.min.js\"></script>\n" +
"	  	<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min.js\"></script>\n" +
"	  	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"	  	<script type=\"text/javascript\">\n" +
"	  	$(document).ready(function(){\n" +
"	  		var canvas = this.__canvas = new fabric.Canvas('canvas', {\n" +
"			    hoverCursor: 'pointer',\n" +
"				selection: true\n" +
"			});\n" +
"\n" +
"			canvas.on({\n" +
"				'object:moving': function(e) {\n" +
"					e.target.opacity = 0.5;\n" +
"			  	},\n" +
"			  		'object:modified': function(e) {\n" +
"			    	e.target.opacity = 1;\n" +
"				}\n" +
"			});\n" +
"\n" +
"			function retrieveImageFromClipboardAsBlob(pasteEvent, callback){\n" +
"				if(pasteEvent.clipboardData == false){\n" +
"			        if(typeof(callback) == \"function\"){\n" +
"			            callback(undefined);\n" +
"			        }\n" +
"			    };\n" +
"\n" +
"			    var items = pasteEvent.clipboardData.items;\n" +
"\n" +
"			    if(items == undefined){\n" +
"			        if(typeof(callback) == \"function\"){\n" +
"			            callback(undefined);\n" +
"			        }\n" +
"			    };\n" +
"\n" +
"			    for (var i = 0; i < items.length; i++) {\n" +
"			        if (items[i].type.indexOf(\"image\") == -1) continue;\n" +
"			        var blob = items[i].getAsFile();\n" +
"			        if(typeof(callback) == \"function\"){\n" +
"			            callback(blob);\n" +
"			        }\n" +
"			    }\n" +
"			}\n" +
"\n" +
"			window.addEventListener(\"paste\", function(e){\n" +
"			    retrieveImageFromClipboardAsBlob(e, function(imageBlob){\n" +
"			        if(imageBlob){\n" +
"			        	var img = new Image();\n" +
"			            img.onload = function(){\n" +
"			               	var image1 = new fabric.Image(img);\n" +
"						      	image1.set({\n" +
"						            originX: \"center\", \n" +
"		        					originY: \"center\"\n" +
"						      	});\n" +
"						      	canvas.centerObject(image1);\n" +
"						      	canvas.add(image1);\n" +
"						      	canvas.renderAll();\n" +
"			           		};\n" +
"			            var URLObj = window.URL || window.webkitURL;\n" +
"			            img.src = URLObj.createObjectURL(imageBlob);\n" +
"			        }\n" +
"			    });\n" +
"			}, false);\n" +
"\n" +
"			$( \"#botontexto\" ).click(function() {\n" +
"				var txt=new fabric.IText('Escribir texto', { \n" +
"								  fontFamily: 'Roboto',});\n" +
"				canvas.add(txt);\n" +
"				canvas.centerObject(txt);\n" +
"			});\n" +
"\n" +
"			$( \"html\" ).keypress(function(e) {\n" +
"		  		if(e.which==127){\n" +
"		  			canvas.remove(canvas.getActiveObject());\n" +
"		  		}\n" +
"			});\n" +
"\n" +
"			$(\"canvas\").on('dragover', function(e) {e.preventDefault();return false;});\n" +
"				$(\"canvas\").on('drop', function(e) {\n" +
"			    	e.preventDefault();\n" +
"			    		var src=e.originalEvent.dataTransfer.files[0];\n" +
"			    	if(src!=null){\n" +
"			    		if(src.type.match(/image.*/)){\n" +
"							var reader = new FileReader();\n" +
"							reader.onload = function(e){\n" +
"								var image = new Image();\n" +
"								image.src=e.target.result;\n" +
"								image.onload=function(){\n" +
"									add(image);\n" +
"								}\n" +
"							};\n" +
"							reader.readAsDataURL(src);	\n" +
"						}\n" +
"					}else{\n" +
"			    	e.originalEvent.dataTransfer.items[0].getAsString(function(url){\n" +
"			        	var img1 = new Image();\n" +
"		    			img1.src = url;\n" +
"		    				img1.onload = function(){\n" +
"		    					add(img1);\n" +
"		    				}\n" +
"						});\n" +
"			    	}\n" +
"					});\n" +
"\n" +
"			$(\"#botonguardar\").click(function() {\n" +
"				var sv=JSON.stringify(canvas);\n" +
"				console.log(sv);\n" +
"			});\n" +
"\n" +
"			function add(img1){\n" +
"				var image1 = new fabric.Image(img1);\n" +
"				image1.set({\n" +
"					originX: \"center\",\n" +
"		        	originY: \"center\"\n" +
"				});\n" +
"				canvas.centerObject(image1);\n" +
"				canvas.add(image1);\n" +
"				canvas.renderAll();\n" +
"			}\n" +
"			$(\"canvas\").click(function(e){\n" +
"			  var txt = canvas.getActiveObject().text;\n" +
"			  Decir(txt);\n" +
"			});\n" +
"\n" +
"			function Decir(say){\n" +
"				document.getElementsByTagName(\"audio\")[0].setAttribute(\"src\", \"https://translate.google.com/translate_tts?tl=es-MX&q=\" + say + \"&client=tw-ob\");\n" +
"			}\n" +
"	  	});\n" +
"	  	</script>\n" +
"  </head>\n" +
"  <body>\n" +
"    <canvas id=\"canvas\" width=\"600\" height=\"600\" style=\"border: 1px solid #222\"></canvas>\n" +
"	<br>\n" +
"    <button id=\"botontexto\">Añadir texto</button> <button id=\"botonguardar\">Guardar</button>\n" +
"    <audio autoplay src=\"\" class=\"A\"></audio>\n" +
"	<a href=\"MisImagenes\" target=\"_blank\"><input type='button' value='Imagenes de mi biblioteca'/></a>\n" +
"  </body>\n" +
"</html>");
    }



}
