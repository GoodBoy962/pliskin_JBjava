<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.username" var="username"/>
</@security.authorize>

<header>
    <div class="col-lg-3 col-lg-offset-7 userside">
    <#if username?? && principal??>
        <a href="/profile"><p>${username}</a> <a href="/profile/all_users">   Другие юзеры   </a><a href="/logout">Выйти</a> </p>
    <#else>
        <p><a href="/registration">Зарегистрироваться</a> или <a href="/login">Войти</a></p>
    </#if>
    </div>
</header>