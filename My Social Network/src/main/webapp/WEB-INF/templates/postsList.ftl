<#list posts as post>
<h2><p>${post.text}</p></h2>
<#--<#if post.user??>-->
<#--<p>by ${post.user?username}</p>-->
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
<#--</#if>-->
<a><p>Удалить пост</p></a>
<hr>
</#list>