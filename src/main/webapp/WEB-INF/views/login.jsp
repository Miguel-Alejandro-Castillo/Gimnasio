<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <!--<form role="form"> -->
                   <form:form id="loginForm" modelAttribute="loginBean" action="login" method="post" role="form">
                        <fieldset>
                            <div class="form-group">
                                <form:input path="username"  cssClass="form-control" autofocus="autofocus" placeholder="Username"/>
                                    <form:errors path="username" cssClass="error"/>
                                <!--<input class="form-control" placeholder="E-mail" name="email" type="email" autofocus> -->
                            </div>
                            <div class="form-group">
                                <form:password path="password" cssClass="form-control" placeholder="Password"/>
                                <form:errors path="password" cssClass="error"/>
                                <!--<input class="form-control" placeholder="Password" name="password" type="password" value="">-->
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <form:button  class="btn btn-lg btn-success btn-block">Login</form:button>
                            <!--<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>-->
                            <span class="error">${loginError}</div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>