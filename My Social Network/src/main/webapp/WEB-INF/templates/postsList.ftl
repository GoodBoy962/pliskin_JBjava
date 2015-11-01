<#list posts as post>
<p>${post.text}</p>
<p>by ${post.user.username}</p>
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
<a><p>Удалить пост</p></a>
<hr>
</#list>