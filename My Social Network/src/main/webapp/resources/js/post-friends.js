$(document).ready(function () {
    updatePosts();

    $("#js-sendpost").on("click", function () {
        sendPost()
    });
});

function sendPost() {
    $friend = $("#friend").first();
    var friend = $friend.text();
    $input = $("#js-post-text");
    var text = $input.val();
    console.log(text + "   " + friend);
    if (text.length == 0) {
        return;
    }
    $.ajax({
        url: "friend/post/add",
        type: "POST",
        data: {
            text: text,
            friend: friend
        },
        success: function () {
            updatePosts();
        }
    })
}

function updatePosts() {
    $friend = $("#friend").first();
    var friend = $friend.text();
    $.ajax({
        url: "friend/post/getAll",
        type: "GET",
        dataType: "html",
        data: {
            friend: friend
        },
        success: function (data) {
            $("#js-posts").html(data);
        }
    })
}

function deletePost() {
    var post = $("#post").val();
    $.ajax({
        url: "friend/post/delete",
        type: "GET",
        data: {
            post: post
        },
        success: function () {
            updatePosts();
        }
    })
}
