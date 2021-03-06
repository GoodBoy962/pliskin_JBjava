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
        url: "post/add",
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
        url: "post/getAll",
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

function deletePost(postid) {
    $button = $("#delete-post");
    $.ajax({
        url: "/profile/post/delete",
        type: "POST",
        data: {
            id: postid
        },
        success: function () {
            updatePosts();
        }
    })
}
