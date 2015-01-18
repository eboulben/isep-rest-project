function callUpdate() {
    $.ajax({
        url:window.location.href+"/update",
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
                fadeMessage("Error updating database");
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
                $(this).html("Update Database").fadeIn("slow", function() {
                    if(message == "Success") {
                        location.reload();
                    };
                });
            });
        });
    });
}