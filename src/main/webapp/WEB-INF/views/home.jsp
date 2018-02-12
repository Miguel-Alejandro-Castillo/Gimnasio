<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <div id="nav-placeholder">
            <script>
                var nav = "${nav}"
                $(function(){
                  $("#nav-placeholder").load(nav);
                });
            </script>
        </div>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Home</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

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
