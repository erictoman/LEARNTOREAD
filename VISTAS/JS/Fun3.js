var tam=0;
var Actual=0;
var Historia;
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
            e.target.opacity = 1;
        }
    });

    $("#R").on("click", function () {
        if(Actual<=0){
            Actual=Actual-1;
            if(Actual==0){
                $("#R").hide();
            }
            canvas.loadFromJSON(JSON.stringify(Historia.Libro[Actual]));
        }
    });

    $("#A").on("click", function () {
        if(Actual<tam){
            Actual=Actual+1;
            if(Actual==tam-1){
                $("#A").hide();
            }
            canvas.loadFromJSON(JSON.stringify(Historia.Libro[Actual]));
        }
    });

    $("#R").hide();
    function Cargar(){
        e.preventDefault();
        var formData = new FormData();
        formData.append('nom', $('#DATA').val());
        $.ajax({
            url: 'VistaHistoria',
            type: 'GET',
            data: formData,
            processData: false, // tell jQuery not to process the data
            contentType: false, // tell jQuery not to set contentType
            success: function (data) {
                Historia=JSON.parse(data);
                tam=Historia.Libro.length;
                canvas.loadFromJSON(JSON.stringify(Historia.Libro[0]));
            },
            error: function () {
                alert("ERROR");
            }
        });
    }
    Cargar();
});