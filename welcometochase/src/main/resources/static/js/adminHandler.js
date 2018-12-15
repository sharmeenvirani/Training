$(document).ready(function(){

    var url = window.location;

    $('#submit-new').click(function() {
        var access = $('#toolName').val();
        console.log("was clicked with " + access + " at " + url);
        ajaxGet();
    });

    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : url,
            success: function(){
                console.log("was success");
            },
            error : function(e) {
                console.log("was bad");
            }
        });
    }
});