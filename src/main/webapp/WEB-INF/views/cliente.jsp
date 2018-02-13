<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

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

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     <spring:url value="/templates/nav.html" var="nav"/>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <div id="nav-placeholder">

            <script>
                var nav = "${nav}"
                $(function(){
                  $("#nav-placeholder").load(nav);
                });
            </script>
        </div>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Alta de Cliente</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                <form:form id="clienteForm" modelAttribute="clienteBean" action="crear" method="post" role="form">
                                        <form:hidden path="id"/>
                                        <div class="form-group">
                                            <form:label path="nombre">Nombre</form:label>
                                            <form:input path="nombre"  cssClass="form-control" autofocus="autofocus"/>
                                            <form:errors path="nombre" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="apellido">Apellido</form:label>
                                            <form:input path="apellido"  cssClass="form-control"/>
                                            <form:errors path="apellido" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="dni">DNI</form:label>
                                            <form:input path="dni" type="number" cssClass="form-control"/>
                                            <form:errors path="dni" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="edad">Edad</form:label>
                                            <form:input type="number" path="edad"  cssClass="form-control"/>
                                            <form:errors path="edad" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="telefono">Numero de telefono</form:label>
                                            <form:input type="number" path="telefono"  cssClass="form-control"/>
                                            <form:errors path="telefono" cssClass="error"/>
                                        </div>
                                        <form:button type="submit" class="btn btn-default">Submit Button</form:button>
                                        <form:button type="reset" class="btn btn-default">Reset Button</form:button>
                                    </form:form>
                                </div>
                                
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>