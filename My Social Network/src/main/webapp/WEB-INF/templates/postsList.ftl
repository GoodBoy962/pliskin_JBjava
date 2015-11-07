<#list posts as post>
<h2><p>${post.text}</p></h2>
    <#if !(post.user.username == principal.username)>
    <p>by <a href="/friend/${post.user.username}">${post.user.username}</a></p>
    <#else>
    <p>by <a href="/profile">${post.user.username}</a></p>
    </#if>
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
    <#if post.userPage.username == principal.username>
    <form action="/profile/post/delete" method="get">
        <button type="button" onclick="deletePost(${post.id})" class="btn btn-default btn-sm"><i
                class="fa fa-trash-o" style="color:red;"></i>
            Удалить пост
        </button>
    <form>
    <#else>
        <#if post.user.username == principal.username>
            <button type="button" onclick="deletePost(${post.id})" class="btn btn-default btn-sm"><i
                    class="fa fa-trash-o" style="color:red;"></i>
                Удалить пост
            </button>
        </#if>
    </#if>
    <hr>
<#--${post.user.username} ${principal.username}-->
</#list>

