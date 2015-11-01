$(document).ready(function () {
    updatePosts();

    $("#js-sendpost").on("click", function () {
        sendPost()
    });
});

function sendPost() {
    $input = $("#js-post-text");
    var text = $input.val();
    if (text.length == 0) {
        return;
    }
    $.ajax({
        url: "friend/post/add",
        type: "POST",
        data: {
            text: text
        },
        success: function () {
            updatePosts();
        }
    })
}

function updatePosts() {
    $.ajax({
        url: "friend/post/getAll",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-posts").html(data);
        }
    })
}