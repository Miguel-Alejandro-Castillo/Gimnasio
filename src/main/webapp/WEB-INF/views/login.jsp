<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="utf-8">
<style>
    .loginBtn{
        background-color:dimgray;
        color:whitesmoke
    }
    .loginBox{
        margin-top:200px;
        margin-left:150px
    }
    body{
        height: 100%;
        background-color: cornflowerblue;
    }


</style>
<div class="container">
    <div class="col-lg-5">
            <div class="login-panel panel panel-default loginBox">

                <div class="panel-body">
                    <spring:url value="/login" var="urlLogin"/>
                   <form id="loginForm"  action="${urlLogin}" method="post" role="form">
                        <fieldset>
                            <div class="form-group">
                                <label for="username">Usuario:</label>
                                <input id="username" name="username" class="form-control" autofocus placeholder="Username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                            </div>
                            <button type="submit" class="btn btn-lg btn-block loginBtn">Iniciar Sesion</button>
                            <span class="errorMessage">${loginError}</span>
                        </fieldset>
                    </form>
                </div>
            </div>
    </div>
</div>