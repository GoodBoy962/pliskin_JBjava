<#list posts as post>
<h2><p>${post.text}</p></h2>
<p>by ${post.user.username}</p>
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
    <#--<#if post.userPage.username == principal.username || post.user.username == principal.username>-->
    <#--<a href="/profile/post/delete">Удалить пост</a>-->
    <#--<input type="number" value="${post.id}" id="post${post.id}" readonly>-->
    <#--</#if>-->
<hr>
<#--${post.user.username} ${principal.username}-->
</#list>

