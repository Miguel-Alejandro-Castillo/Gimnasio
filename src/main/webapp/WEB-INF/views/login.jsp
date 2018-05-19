<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <spring:url value="/login" var="urlLogin"/>
                   <form id="loginForm"  action="${urlLogin}" method="post" role="form">
                        <fieldset>
                            <div class="form-group">
                                <input id="username" name="username" class="form-control" autofocus placeholder="Username"/>
                            </div>
                            <div class="form-group">
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                            </div>
                            <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                            <span class="errorMessage">${loginError}</span>
                        </fieldset>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>