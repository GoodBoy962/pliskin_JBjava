<#include "main-template.ftl"/>
<#macro m_body>
    <#list posts as post>
    <h2><p>${post.text}</p></h2>
        <#if principal??>
            <#if !(post.user.username == principal.username)>
            <p>by <a href="/friend/${post.user.username}">${post.user.username}</a></p>
            <#else>
            <p>by <a href="/profile">${post.user.username}</a></p>

            </#if>
        </#if>
    <p>Date: ${post.date}</p>
    <p>Time: ${post.time}</p>
        <#if principal??>
            <#if post.userPage.username == principal.username>
            <button type="button" onclick="deletePost(${post.id})" class="btn btn-default btn-sm"><i
                    class="fa fa-trash-o" style="color:red;"></i>
                Удалить пост
            </button>
                <#if post.user.username == principal.username>
                <a href="/profile/post/change/${post.id}" class="btn btn-default btn-sm">Изменить пост</a>
                </#if>
            <#else>
                <#if post.user.username == principal.username>
                <button type="button" onclick="deletePost(${post.id})" class="btn btn-default btn-sm"><i
                        class="fa fa-trash-o" style="color:red;"></i>
                    Удалить пост
                </button>
                </#if>
            </#if>
        </#if>
    <hr>
    </#list>
</#macro>
<@main title="Lenta"/>