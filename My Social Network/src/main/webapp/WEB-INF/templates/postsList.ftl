<#list posts as post>
<p>${post.text}</p>
<p>${post.date} by ${post.user.username}</p>
<hr>
</#list>