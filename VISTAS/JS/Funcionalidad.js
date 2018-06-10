$(document).ready(function () {
    $("#foto").on("change", function () {
        alert('Cargando Archivo');
        $("#text2").text("Cargando Archivo");
        $("#foto").submit();
    });
    $('#foto').on('submit', (function (e) {
        e.preventDefault();
        var formData = new FormData();
        formData.append('foto', $('#foto')[0].files[0]);
        $.ajax({
            url: 'Subir',
            type: 'POST',
            data: formData,
            processData: false, // tell jQuery not to process the data
            contentType: false, // tell jQuery not to set contentType
            success: function (data) {
                alert(data);
                TraerImagenes();
            },
            error: function () {
                alert("Archivo invalido");
            }
        });
    }));
});