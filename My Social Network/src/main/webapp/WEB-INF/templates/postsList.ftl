<#list posts as post>
<h2><p>${post.text}</p></h2>
<p>by ${post.user.username}</p>
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
<hr>
</#list>