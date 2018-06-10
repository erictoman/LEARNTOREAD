var tam=0;
var Actual=0;
var Historia;
var txt;
$(document).ready(function () {
    var canvas = this.__canvas = new fabric.Canvas('canvas', {
        hoverCursor: 'pointer',
        selection: true
    });			
    canvas.on({	
        'object:moving': function(e) {
	e.target.opacity = 0.5;	
        },
        'object:modified': function(e) {
            e.target.opacity = 1;			}			
    });

    $("#R").on("click", function () {
        if(Actual>=0){
            Actual=Actual-1;
            if(Actual==0){
                $("#R").attr('disabled', 'disabled');
            }else{
                $("#A").removeAttr('disabled');
                $("#R").removeAttr('disabled');
                canvas.loadFromJSON(Historia.Libro[Actual].Contenido);
                $('#Pagina').text("Pagina: "+Historia.Libro[Actual].NumPagina);
            }
            canvas.loadFromJSON(Historia.Libro[Actual].Contenido);
            $('#Pagina').text("Pagina: "+Historia.Libro[Actual].NumPagina);
        }
    });
    
    $("#A").on("click", function () {
        if(Actual<tam){
            Actual=Actual+1;
            if(Actual==tam-1){
                $("#R").show();
                $("#A").attr('disabled', 'disabled');
            }else{
                $("#A").removeAttr('disabled');
                $("#R").removeAttr('disabled');
                canvas.loadFromJSON(Historia.Libro[Actual].Contenido);
                $('#Pagina').text("Pagina: "+Historia.Libro[Actual].NumPagina);
            }
            canvas.loadFromJSON(Historia.Libro[Actual].Contenido);
            $('#Pagina').text("Pagina: "+Historia.Libro[Actual].NumPagina);
        }
    });
    function Cargar(){
        $.ajax({
            url: 'VistaHistoria',
            type: 'GET',
            data: {'nom':$('#DATA').val()},
            success: function (data) {
                Historia=JSON.parse(data);
                console.log(Historia);
                tam=Historia.Libro.length;
                canvas.loadFromJSON(Historia.Libro[0].Contenido);
                $('#Pagina').text("Pagina: "+Historia.Libro[0].NumPagina);
                console.log((Historia.Libro[0].Contenido));
                $("#TITULO").text("Lectura: "+Historia.Nombre);
                if(tam===1){
                    $("#R").hide();
                    $("#A").hide();
                }
            },
            error: function () {
                alert("ERROR");
            }
        });
    }
    Cargar();
});