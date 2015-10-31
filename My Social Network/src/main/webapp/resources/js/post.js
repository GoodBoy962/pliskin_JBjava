$(document).ready(function () {
    updateTweets();

    $("#js-sendpost").on("click", function () {
        sendTweet()
    });
});

function sendTweet() {
    $input = $("#js-post-text");
    var text = $input.val();
    if (text.length == 0) {
        return;
    }
    $.ajax({
        url: "profile/post/add",
        type: "POST",
        data: {
            text: text
        },
        success: function () {
            updateTweets();
        }
    })
}

function updateTweets() {
    $.ajax({
        url: "profile/post/getAll",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-posts").html(data);
        }
    })
}
