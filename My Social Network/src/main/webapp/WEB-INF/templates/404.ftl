<#include "main-template.ftl"/>
<#macro m_body>

<div class="container">

    <div class="jumbotron">
        <h1>404</h1>
    </div>

    <h2>
        <div>Такой страницы не существует</div>
    </h2>
    <#if !principal??>
        <h2><a href="/registration">Зарегестрируйся!=)</a></h2>
    <#else>
        <h2><a href="/profile">${principal.username}</a></h2>
    </#if>
</#macro>
<@main title="404"/>