function callUpdate() {
    $.ajax({
        url:"/home/update",
        beforeSend: function() {
            $("#update_button").children().html("Updating database");
        }
    })
        .done(function( data ) {
            console.log(data);
        });
}

$("#update_button").click(function() {
    callUpdate();
});