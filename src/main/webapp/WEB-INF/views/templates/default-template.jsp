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
    
    <link href="css/navbar-fixed-side.css" rel="stylesheet" />

    <!-- MetisMenu CSS -->
    <spring:url value="/resources/css/metisMenu.min.css" var="metisMenuMinCss"/>
    <link href="${metisMenuMinCss}" rel="stylesheet"/>

    <!-- Custom CSS -->
    <spring:url value="/resources/css/sb-admin-2.css" var="sbAdmin2Css"/>
    <link href="${sbAdmin2Css}" rel="stylesheet"/>

    <spring:url value="resources/css/demo.css" var="demoCss"/>
    <link href="${demoCss}" rel="stylesheet"/>

    <!-- Custom Fonts -->
    <spring:url value="/resources/css/font-awesome.min.css" var="fontAwesomeMin"/>
    <link href="${fontAwesomeMin}" rel="stylesheet"/>

    <!-- DataTables CSS -->
    <spring:url value="/resources/css/dataTables.bootstrap.css" var="dataTablesBootstrapCss"/>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>

    <!-- DataTables Responsive CSS -->
    <spring:url value="/resources/css/dataTables.responsive.css" var="dataTablesResponsiveCss"/>
    <link href="${dataTablesResponsiveCss}" rel="stylesheet"/>

</head>



		<div class= "row">
		
         <tiles:insertAttribute name="menu" />
		
		
        
             <tiles:insertAttribute name="main" />
             	
             
             
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
         <script src="${funciones}"></script>

         <spring:url value="/resources/js/zingchart.min.js" var="zingchartMin" />
         <script src="${zingchartMin}"></script>

         <!-- Page-Level Demo Scripts - Tables - Use for reference -->
         <script>
             $(document).ready(function() {
             	$('[data-toggle="tooltip"]').tooltip();                	
	});
         
         </script>

</html>