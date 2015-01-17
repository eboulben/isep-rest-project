function callUpdate() {
    $.ajax({
        url:"/home/update",
        beforeSend: function() {
            $("#update_button").children().fadeOut("slow", function() {
                $(this).html("Updating database").fadeIn("slow");
            });
        }
    })
        .done(function( data ) {
            if(data == "1") {
                fadeMessage("Success");
            } else {
                $("#update_button").children().html("Update database");
                alert("Database update failed");
            }
        });
}

$("#update_button").click(function() {
    callUpdate();
});

function fadeMessage(message) {
    $("#update_button").children().fadeOut("slow", function() {
        $(this).html(message).fadeIn("slow", function() {
            $(this).fadeOut("slow", function() {
                $(this).html("Update Database").fadeIn("slow");
            });
        });
    });
}