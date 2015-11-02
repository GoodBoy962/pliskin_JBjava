<#include "main-template.ftl"/>
<#macro m_body>



    <#list users as user>
        <#if user.username != principal.username>
        <a href="/friend/${user.username}"><p>${user.username}</p></a>
        <hr>
        </#if>
    </#list>


</#macro>
<@main title="Friends"/>