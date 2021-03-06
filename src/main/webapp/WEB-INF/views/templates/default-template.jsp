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
    
    <!-- Custom CSS -->
    <spring:url value="/resources/css/template.css" var="templateCss"/>
    <link href="${templateCss}" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <spring:url value="/resources/css/fontawesome.min.css" var="fontAwesomeMin"/>
    <link href="${fontAwesomeMin}" rel="stylesheet"/>

    <!-- DataTables CSS -->
    <spring:url value="/resources/css/dataTables.bootstrap.css" var="dataTablesBootstrapCss"/>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>

    <!-- DataTables Responsive CSS -->
    <spring:url value="/resources/css/dataTables.responsive.css" var="dataTablesResponsiveCss"/>
    <link href="${dataTablesResponsiveCss}" rel="stylesheet"/>

    <!-- Jquery Confirm CSS  -->
    <spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
    <link href="${jqueryConfirmCss}" rel="stylesheet"/>

</head>

<body>
		<div class= "row">
            <div class="col-lg-2" style="margin-left: 10px;">
                <tiles:insertAttribute name="menu" />
            </div>

            <div class="col-lg-9">
                <tiles:insertAttribute name="main" />
            </div>
        </div>
         <!-- jQuery -->
         <spring:url value="/resources/js/jquery.min.js" var="jqueryMin"/>	
         <script src="${jqueryMin}"></script>

         <!-- Bootstrap Core JavaScript -->
         <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs" />
         <script src="${bootstrapMinJs}"></script>

         <!-- Custom Theme JavaScript -->
         

         <!-- DataTables JavaScript -->
         <spring:url value="/resources/js/jquery.dataTables.min.js" var="jqueryDataTablesMinJs" />
         <script src="${jqueryDataTablesMinJs}"></script>
         <spring:url value="/resources/js/dataTables.bootstrap.min.js" var="dataTablesBootstrapMinJs" />
         <script src="${dataTablesBootstrapMinJs}"></script>
         <spring:url value="/resources/js/dataTables.responsive.js" var="dataTablesResponsiveJs" />
         <script src="${dataTablesResponsiveJs}"></script>
         <spring:url value="/resources/js/funciones.js" var="funciones" />
         <script src="${funciones}" charset="utf-8"></script>

         <spring:url value="/resources/js/zingchart.min.js" var="zingchartMin" />
         <script src="${zingchartMin}"></script>

         <spring:url value="/resources/js/jquery-confirm.min.js" var="jqueryConfirmJs" />
         <script src="${jqueryConfirmJs}"></script>

         <spring:url value="/resources/js/date-euro.js" var="dateEuro" />
         <script src="${dateEuro}"></script>

         <spring:url value="/resources/js/parsley.min.js" var="parsleyMin" />
         <script src="${parsleyMin}"></script>

         <!-- Page-Level Demo Scripts - Tables - Use for reference -->
         <script>
             $(document).ready(function() {
             	$('[data-toggle="tooltip"]').tooltip();                	
	         });
         </script>

</body>
</html>