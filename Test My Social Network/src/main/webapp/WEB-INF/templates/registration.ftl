<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="col-md-4 col-md-offset-4">
    <@sf.form action="/registration" method="post" modelAttribute="userform">
        <div class="form-group">
            <label for="username">Логин</label>
            <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
            <@sf.errors path="username"/>
        </div>
        <div class="form-group">
            <label for="email">E-mail</label>
            <@sf.input path="email" id="email" cssClass="form-control" placeholder="Email"/>
            <@sf.errors path="email"/>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <@sf.input path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
            <@sf.errors path="password"/>
        </div>
        <div class="form-group">
            <label for="repassword">Ещё раз</label>
            <@sf.input path="repassword" id="repassword" cssClass="form-control" placeholder="Повторите пароль"/>
            <@sf.errors path="repassword"/>
        </div>
        <#if error_registration??>
        <div class="alert alert-danger" role="alert">${error_registration}</div>
        </#if>
        <button type="submit" class="btn btn-default">Submit</button>
    </@sf.form>
    <#if validatorError??><div class="alert alert-danger" role="alert">${validatorError}</div></#if>
</div>
</#macro>
<@main title="Регистрация"/>

