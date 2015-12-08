<#include "main-template.ftl"/>
<#macro m_body>

<div class="container">

    <div class="jumbotron">
        <h1 id="friend">${friend}</h1>
    </div>
    <#if principal??>
        <div class="col-lg-6 col-lg-offset-3">
            <textarea id="js-post-text" class="form-control" rows="3" title="post"></textarea>
            <input type="submit" id="js-sendpost">
        </div>

        <div id="js-posts" class="col-lg-6 col-lg-offset-3">

        </div>
    </#if>

</#macro>
<#if principal??>
    <@main title="Friend" customScripts=["/resources/js/post-friends.js"]/>
<#else>
    <@main title="Friend"/>
</#if>