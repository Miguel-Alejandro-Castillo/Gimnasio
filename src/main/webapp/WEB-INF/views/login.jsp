<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinCss"/>
    <link href="${bootstrapMinCss}" rel="stylesheet"/>

    <!-- MetisMenu CSS -->
    <spring:url value="/resources/css/metisMenu.min.css" var="metisMenuMinCss"/>
    <link href="${metisMenuMinCss}" rel="stylesheet"/>

    <!-- Custom CSS -->
    <spring:url value="/resources/css/sb-admin-2.css" var="sbAdmin2Css"/>
    <link href="${sbAdmin2Css}" rel="stylesheet"/>


    <!-- Custom Fonts -->
    <spring:url value="/resources/css/font-awesome.min.css" var="fontAwesomeMin"/>
    <link href="${fontAwesomeMin}" rel="stylesheet"/>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

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


<!-- jQuery -->
<spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>
<script src="${jqueryMin}"></script>

<!-- Bootstrap Core JavaScript -->
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs" />
<script src="${bootstrapMinJs}"></script>

<!-- Metis Menu Plugin JavaScript -->
<spring:url value="/resources/js/metisMenu.min.js" var="metisMenuMinJs"/>
<script src="${metisMenuMinJs}"></script>

<!-- Custom Theme JavaScript -->
<spring:url value="/resources/js/sb-admin-2.js" var="sbAdmin2Js" />
<script src="${sbAdmin2Js}"></script>

</body>

</html>
