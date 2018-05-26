<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="es-AR">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="App gimnasio">
    <meta name="author" content="Miguel Castillo, Javier">
    <title><tiles:getAsString name="title"/></title>

    <!-- Bootstrap Core CSS -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinCss"/>
    <link href="${bootstrapMinCss}" rel="stylesheet"/>

    <!-- MetisMenu CSS -->
    <spring:url value="/resources/css/metisMenu.min.css" var="metisMenuMinCss"/>
    <link href="${metisMenuMinCss}" rel="stylesheet"/>

    <!-- Custom CSS -->
    <spring:url value="/resources/css/sb-admin-2.css" var="sbAdmin2Css"/>
    <link href="${sbAdmin2Css}" rel="stylesheet"/>

    <spring:url value="resources/css/demo.css" var="demoCss"/>
    <link href="${demoCss}" rel="stylesheet"/>

    <!-- Morris Charts CSS -->
    <spring:url value="/resources/css/morris.css" var="morris"/>
    <link href="${morris}" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <spring:url value="/resources/css/font-awesome.min.css" var="fontAwesomeMin"/>
    <link href="${fontAwesomeMin}" rel="stylesheet"/>


    <!-- DataTables CSS -->
    <spring:url value="/resources/css/dataTables.bootstrap.css" var="dataTablesBootstrapCss"/>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>

    <!-- DataTables Responsive CSS -->
    <spring:url value="/resources/css/dataTables.responsive.css" var="dataTablesResponsiveCss"/>
    <link href="${dataTablesResponsiveCss}" rel="stylesheet"/>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>
<body id="wrapper">

            <header>
            <tiles:insertAttribute name="header" />
            </header>

            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <tiles:insertAttribute name="menu" />
            </nav>

            <main>
                <tiles:insertAttribute name="main" />
            </main>

            <footer>
            <tiles:insertAttribute name="footer" />
            </footer>




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

            <!-- DataTables JavaScript -->
            <spring:url value="/resources/js/jquery.dataTables.min.js" var="jqueryDataTablesMinJs" />
            <script src="${jqueryDataTablesMinJs}"></script>
            <spring:url value="/resources/js/dataTables.bootstrap.min.js" var="dataTablesBootstrapMinJs" />
            <script src="${dataTablesBootstrapMinJs}"></script>
            <spring:url value="/resources/js/dataTables.responsive.js" var="dataTablesResponsiveJs" />
            <script src="${dataTablesResponsiveJs}"></script>
            <spring:url value="/resources/js/funciones.js" var="funciones" />
            <script src="${funciones}"></script>

			<spring:url value="/resources/js/raphael.min.js" var="raphaelMin" />
			<script src="${raphaelMin}"></script>
			<spring:url value="/resources/js/morris.min.js" var="morrisMin" />
			<script src="${morrisMin}"></script>
            <spring:url value="/resources/js/zingchart.min.js" var="zingchartMin" />
            <script src="${zingchartMin}"></script>

            <!-- Page-Level Demo Scripts - Tables - Use for reference -->
            <script>
                $(document).ready(function() {
                    
                	$('#dataTables-example').DataTable(
                	{
                        responsive: true
                    });         
                    
                    $('table tr.child').hide();
                	
                    $('.parent').click(function()
					{
						$(this).nextUntil('tr.parent').slideToggle(300);
                    });
				});
                
                
                
                
                
                
                
            </script>
</body>
</html>