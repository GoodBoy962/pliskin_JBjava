<#include "main-template.ftl"/>
<#macro m_body>



<#list users as user>

<a href="/friend/${user.username}"><p>${user.username}</p></a>
<hr>
</#list>


</#macro>
<@main title="Friends" customScripts=["resources/js/post.js"]/>