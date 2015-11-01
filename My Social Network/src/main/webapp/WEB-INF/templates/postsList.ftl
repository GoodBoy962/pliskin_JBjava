<#list posts as post>
<h2><p>${post.text}</p></h2>
<#--<#if post.user.username??>-->
<#--<p>by ${post.user.username}</p>-->
<p>Date: ${post.date}</p>
<p>Time: ${post.time}</p>
<#--</#if>-->
<hr>
</#list>