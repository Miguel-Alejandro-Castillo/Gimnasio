1 <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
2 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
3 <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
4 <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<div id="page-wrapper">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">Resumen de Cuentas</h1>
	    </div>
	    <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
       
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Resumen del Año
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div id="morris-bar-chart"></div>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->

    </div>
    <!-- /.row -->
    
    
    <script type="text/javascript">
    new Morris.Bar({
		  element: 'morris-bar-chart',
		  data: [
			  
		    { y: 'Enero', a: 100},
		    { y: 'Febrero', a: 75 },
		    { y: 'Marzo', a: 50 },
		    { y: 'Abril', a: 75 },
		    { y: 'Mayo', a: 50 },
		    { y: 'Junio', a: 75 },
		    { y: 'Julio', a: 100 },
		    { y: 'Agosto', a: 100},
		    { y: 'Septiebre', a: 75 },
		    { y: 'Octubre', a: 50 },
		    { y: 'Noviembre', a: 75 },
		    { y: 'Diciembre', a: 50 }
		  ],
		  xkey: 'y',
		  ykeys: ['a'],
		  labels: ['Entrada:']
    
    
});


    </script>
   
</div>
<!-- /#page-wrapper -->





