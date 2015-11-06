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
        url: "profile/post/add",
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
        url: "profile/post/getAll",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-posts").html(data);
        }
    })
}

function deletePost() {
    var post = $("#post").val();
    $.ajax({
        url: "profile/post/delete",
        type: "GET",
        data: {
            post: post
        },
        success: function () {
            updatePosts();
        }
    })
}
