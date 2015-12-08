<#include "main-template.ftl"/>
<#macro m_body>

<div class="container">
    <form action="/profile/post/change/save" method="get">
        <h2><input value="${post.text}" name="postText" id="postText"/></h2>
        <input value="${post.id}" name="postId" id="postId" style="display:none"/>

        <p>Date: ${post.date}</p>

        <p>Time: ${post.time}</p>
        <input type="submit" value="Изменить">
    </form>
</div>

</#macro>
<@main title="Changing"/>