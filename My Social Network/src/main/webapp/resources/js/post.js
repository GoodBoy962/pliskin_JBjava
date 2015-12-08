$(document).ready(function () {
    updatePosts();

    $("#js-sendpost").on("click", function () {
        sendPost();
    });

    //$("#js-deletepost").on("click", function() {
    //    deletePost();
    //})
});

function sendPost() {
    $input = $("#js-post-text");
    var text = $input.val();
    if (text.length == 0) {
        return;
    }
    $.ajax({
        url: "/profile/post/add",
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
        url: "/profile/post/getAll",
        type: "GET",
        dataType: "html",
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
