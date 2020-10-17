<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
         ['Mes', 'ventas1', 'ventas2', 'ventas3', 'ventas4',  'minimos-venta'],
         ['Enero',  165,      938,         522,             998,                 614.6],
         ['Febrero',  135,      1120,        599,             1268,                682],
         ['Marzo',  157,      1167,        587,             807,                 623]
        
      ]);

    var options = {
      title : 'No de ventas por vendedor',
      vAxis: {title: 'Ventas'},
      hAxis: {title: 'Ventas por vendedor'},
      seriesType: 'bars',
      series: {5: {type: 'line'}},
       animation: {
          duration: 3000,
          easing: 'out',
          startup: true
      }
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>

    <link href="css/menu.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">

        function guarda(accion) {

            document.forma.action = accion;
            document.forma.submit();
        }


        //PARA REGRESAR EN DONDE SE QUEDO...........
        window.onload = function () {
            var pos = window.name || 0;
            window.scrollTo(0, pos);
        }
        window.onunload = function () {
            window.name = self.pageYOffset
                    || (document.documentElement.scrollTop + document.body.scrollTop);
        }
    </script>


    <head>
        <title>Refacciones Fabela</title>

    </head>
    <body>

       
           <header id="main-header">



               <h1  class="logo">Refacciones Fabela</h1>

            </header><!-- / #main-header -->
 <jsp:include page="/pages/menu.jsp"></jsp:include>
        <s:form name="forma" >
                 <section id="main-content">
                   
                   
                     	
            <div class="div-contenido_gral">  
                 <h1 class="user-sesion" align="right">USUARIO:  <s:property value="usuariocons.NAMEUSUARIO" ></s:property></h1>
                       <s:hidden name="usuariocons.NAMEUSUARIO" id="%{usuariocons.NAMEUSUARIO}"></s:hidden> 

                   
                      <article class="art-prin">
                           <div id="chart_div" style="width: 100%; height: 500px; "></div>
                      </article>
                      
                     
                 </section>
 


                <footer id="main-footer">
                    <p>&copy; 2017 <a href="refaccionesfabela.com">Refacciones Fabela</a></p>
                </footer> <!-- / #main-footer -->
            </s:form>


    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>
