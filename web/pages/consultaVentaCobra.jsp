<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Fecha', 'Precio al Púbico', 'Precio de provedor'],
    <s:iterator value="ListaProductoHist" id="  ListaProductoHist" status="stat" >
                ['<s:property value="FECHAINGRESO"/>',  <s:property value="PRECIO" />,    <s:property value="PRECIO_PESO"/>],
    </s:iterator>
         
        ]);

        var options = {
          title: 'Historial de ingreso de los productos',
          hAxis: {title: 'Fecha de ingreso del Producto',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      
      
        function muestra_oculta(accion, id) {// ejecuta el loader
        alert("entre");
                                                        if (document.getElementById) {
                                                            
                                                            alert("id"+ id);
            //se obtiene el id
                                                            var GM = document.getElementById(id); //se define la variable "el" igual a nuestro div
                                                            GM.style.display = (GM.style.display == 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
                                                        }
                                                        alert("voy mandar el formulario");
                                                        document.forma.action = accion;
                                                        document.forma.submit();
                                                    }


                                                 
                window.onload = function() {
             var pos = window.name || 0;
                 
             window.scrollTo(0, pos);
                 
                  if (document.getElementById) {
                     /* variables para ocultar load de ARCHIVO*/
                    var GrdCar = document.getElementById('idfondo'); //se define la variable "el" igual a nuestro div
                     GrdCar.style.display = (GrdCar.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                 
                 
                 
                 
                 
            }                                    
                                                    
                                                    

    </script>

<script type="text/javascript">
                                                    $(document).ready(function () {

                                                        (function ($) {

                                                            $('#filtrar').keyup(function () {

                                                                var rex = new RegExp($(this).val(), 'i');
                                                                $('.buscar tr').hide();
                                                                $('.buscar tr').filter(function () {
                                                                    return rex.test($(this).text());
                                                                }).show();

                                                            })

                                                        }(jQuery));

                                                    });
                                                </script>








<html xmlns="http://www.w3.org/1999/xhtml">

    <link href="css/loader-1.css" rel="stylesheet" type="text/css" />
    <link href="css/menu.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">

        function guarda(accion) {

            document.forma.action = accion;
            document.forma.submit();
        }
        
         function guarda2(accion,id){
           
               
                   if (document.getElementById) {
                     /* variables para ocultar load de ARCHIVO*/
                    var GrdCar = document.getElementById(id); //se define la variable "el" igual a nuestro div
                     GrdCar.style.display = (GrdCar.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
               
               
                document.forma.action = accion;
                document.forma.submit();
            }
        
        
        
        
        function actualiza(accion, valor) {

            document.forma.RFCAUX.value = valor;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }
         function borrarProducto(accion, valor) {

            document.forma.BORRARPRODUCTO.value = valor;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }
        function consulta(accion, valor) {

            document.forma.CONSULTA_PARTE.value = valor;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }
        function consultaCotiza(accion, valor) {

            document.forma.AUXCOTIZA.value = valor;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }
     function consultaCliente(accion, valor, valor2) {

            document.forma.AUX_RFC_CLIENTE.value = valor;
             document.forma.RFCCLIENTE.value = valor2;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }

        //PARA REGRESAR EN DONDE SE QUEDO...........
       
    </script>


    <head>
        <title>Refacciones Fabela</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

                        <article class="articulo1" >
                            
                              
                                
                            <!-- BUSQUEDA DE CLIENTE PARA LA VENTA O NOTA -->    
                                
                               
                                <div class="div_sec1" id="flotante-busqueda">
                            <div class="div-busqueda">
                                 <div class="div_titulos_sec"> <h2 class="text-tit-sec">Busqueda</h2></div>
                            <s:textfield name="camp.NO_VENTA" id="camp.NO_VENTA" placeholder="Número de Venta" required="true"  cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();"/>
                            
                              <a href="Javascript:guarda('consultaVentaCobra')"><div class="boton">  Buscar  </div> </a>
                              
                              <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>
                            </div>



                        </div>
                            
                        </article> 
                        <article class="articulo2">
                            
                            
                                   
                                            
                   
                         
                              


                       
                           
                            
                            
                            
                             
                           
                            
                            
                            
                             <s:iterator value="ListaGanancia" id="ListaGanancia" status="stat">
                                <s:hidden  name = "ListaGanancia[%{#stat.index}].ID_GANANCIA"  id="ID_GANANCIA"></s:hidden>                                    
                                <s:hidden  name = "ListaGanancia[%{#stat.index}].GANANCIA"  id="GANANCIA"></s:hidden> 
                                 </s:iterator> 
                               
                               
                                <s:iterator value="ListaCategoriaGral" id="ListaCategoriaGral" status="stat">
                                <s:hidden  name = "ListaCategoriaGral[%{#stat.index}].CATEGORIA_GENERAL"  id="CATEGORIA_GENERAL"></s:hidden>                                    
                               
                                 </s:iterator> 
 
                                  <s:iterator value="ListaCategoria" id="ListaCategoria" status="stat">
                                <s:hidden  name = "ListaCategoria[%{#stat.index}].CATEGORIA"  id="CATEGORIA"></s:hidden>                                    
                               
                                 </s:iterator> 
 
 
                               
                               <s:iterator value="ListaSelectProvee" id="ListaSelectProvee" status="stat">
                                <s:hidden  name = "ListaSelectProvee[%{#stat.index}].RFC_PROVEE"  id="RFC_PROVEE"></s:hidden>   
                                 <s:hidden  name = "ListaSelectProvee[%{#stat.index}].RASON_PROVEE"  id="RASON_PROVEE"></s:hidden>   
                               
                                 </s:iterator> 
                                
                            <s:hidden  name = "regprod"  id="regprod"></s:hidden>  
                            <s:hidden  name = "actprod"  id="actprod"></s:hidden>  
                            
                             <s:hidden  name = "camp.NO_PARTE"  id="NO_PARTE"></s:hidden>  
                               <s:hidden  name = "camp.PRODUCTO"  id="PRODUCTO"></s:hidden> 
                              <s:hidden  name = "camp.DESCRIPCION"  id="DESCRIPCION"></s:hidden> 
                               <s:hidden  name = "camp.MARCA"  id="NO_MARCA"></s:hidden> 
                                <s:hidden  name = "camp.TOTAL_COTIZACION"  id="TOTAL_COTIZACION"></s:hidden> 
                              
                        <div style="position: absolute; width: 30%; margin: auto; font-size: 20px; margin-top: 30px; color: green; text-shadow: 5px 5px 10px #666; " >
                        <s:actionerror />
                            </div>
                                <s:if test="ListaCarroCotizacion.size()>0">
                                    
                            <div class="div_sec1">

                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Productos Vendidos </h2></div>
                            
                           
                                  
                            <div class="div_form_cliente">
                                <div id="scroltabla-cliente">
                                    <div class="contenedor-tab-hist-prog">
                                         <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                                    <s:param name="TipoReporte" value="'VENTANBUENA.jasper'"/>
                                                    <s:param name="NO_VENTA" value="camp.NO_VENTA"/>
                                                    
                                                    <s:param name="esExcel" value="'false'"/>
                                                    <s:param name="esPDF" value="'true'"/>            

                                           </s:url> 
                                          <s:url action="GeneraPdf" id="myUrl2" escapeAmp="false">

                                                    <s:param name="TipoReporte" value="'VENTANBUENA.jasper'"/>
                                                    <s:param name="NO_VENTA" value="camp.NO_VENTA"/>
                                                    
                                                    <s:param name="esExcel" value="'false'"/>
                                                    <s:param name="esPDF" value="'true'"/>            

                                           </s:url> 
                                    <table id="customers">
                                        <thead>
                                            <th>Parte</th>
                                            <th>Producto</th>
                                            <th>Precio Unitario</th>
                                            <th>Vendidos</th>
                                             <th>Total Partida</th>
                                            
                                            
                                        </thead>

                                            <s:iterator value="ListaCarroCotizacion" id="  ListaCarroCotizacion" status="stat" >
                                              <tr>
                                                  <td id="centrar-dato"><s:property value="NO_PARTE" /> </td>
                                                <td id="centrar-dato"><s:property value="PRODUCTO" /></td>
                                                <td id="centrar-dato"><s:property value="PRECIO_UNITARIO" /></td>
                                                 <td id="centrar-dato"><s:property value="NO_PRODUCTOVENTA" /></td>
                                                <td id="centrar-dato" style="background: green; color:white;"><s:property value="PRECIO_FINAL" /></td>


                                            </tr>
                                          

                                        </s:iterator>

                                          <tr>
                                                  <td id="centrar-dato"> </td>
                                                <td id="centrar-dato"></td>
                                                <td id="centrar-dato"></td>
                                                <td id="centrar-dato" style="background: purple; color:white; "><s:property value="camp.TOTAL_COTIZACION"  /></td>
                                                <td  id="centrar-dato"> </td>


                                            </tr>

                                        </table>
                                                
                                        </div>
                                                                                 <div style="width: 200px; height: 25px; background: purple; color: white; float: right; margin-right: 120px; text-align: center; margin-top: 10px; font-size: 14px;">Total: <s:property value="camp.TOTAL_COTIZACION" /> MXN</div>

                                              <s:if test='camp.STATUS_VENTA=="2"'>
                     <div style="position: relative; width: 90%; margin-top: 50px; margin-left: 30px; font-size: 14px; color:green; text-align: center;"><h4>¡La venta ya fue cobrada!</h4></div>

                               
                            </s:if>
                            
                                                                                 <s:else>
                                                                                  <table  style="border-collapse: collapse; border: 1px solid white; width: 90%; margin: auto;">
                                                    <tr style="border-collapse: collapse; border: 1px solid white;">
                                                        <td id="centrar-dato">  <a href="<s:property value="#myUrl" />" target="_blank"><img src="img/descarga.png" style="width: 50px; margin-top: 5px;"></img> </a></td>
                                                       
                                                       
                                                         <td id="centrar-dato">  <a href="Javascript:guarda('cobraNotaActualiza')" ><div class="boton">  Cobrar  </div> </a></td>

 <td id="centrar-dato">  <a href="Javascript:guarda2('cobraNotaActualizaFactura','idfondo')" ><div class="boton">  Cobrar y Facturar  </div> </a></td>


                                                    </tr>
                                                    
                                                   
                                                   
                                                </table>    
                                                                                 </s:else>
                                                                                     

                                    </div>

                                </div>




                            </div>

                            
                               </s:if> 
                  
                                <s:if test="ListaTraerProducto.size()>0">     
                                
                       <div class="div_sec1">

                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Productos por traer o comprar </h2></div>
                            
                            
                            <div class="div_form_cliente">
                                <div id="scroltabla-cliente">
                                    <div class="contenedor-tab-hist-prog">
                                        

                                    <table id="customers">
                                        <thead>
                                            <th>Parte</th>
                                            <th>Producto</th>
                                            <th>Bodega</th>
                                            <th>Ubicación</th>
                                             <th>Fecha de Compra</th>
                                              <th>Fecha de Compra</th>
                                            
                                        </thead>

                                            <s:iterator value="ListaTraerProducto" id="  ListaTraerProducto" status="stat" >
                                              <tr>
                                                  <td id="centrar-dato"><s:property value="NO_PARTE" /></td>
                                                 <td id="centrar-dato"><s:property value="PRODUCTO" /></td>
                                                  <td id="centrar-dato"><s:property value="NAME_BODEGA" /></td>
                                                <td id="centrar-dato"><s:property value="UBICACION" /></td>
                                                <td  id="centrar-dato"> <s:property value="FECHA_VENTA" /> </td>
                                                <td  id="centrar-dato" style="background: green; color:white;"> <s:property value="NO_PRODUCTOVENTA" /> </td>
                                                


                                            </tr>
                                          

                                        </s:iterator>

                                        

                                        </table>
                                                
                                        </div>
                                 
                                                

                                </div>

                            </div>
                                
                    </div>

               </s:if>

                    </article>
                    <!-- /article -->
                    </div>
                </section> <!-- / #main-content -->
                
             
 <div id='idfondo'>

               

                <div class="loader1" style="background: #2B2C2B;">

 <div style="color:white; z-index: 1; font-size: 20px;  height: 50px; position: fixed; margin-top: 30px; margin-left: 43%; margin-top: 45%; ">Generando Factura...</div>


                    <div class="loader-wrapper " id="loader-1" style="background: red;" >
                       

                        <div  id="loader" style="">
                       
                       
                       
                        </div>
                       
                       
                         
                       
                    </div>



                </div>
            </div>



                <footer id="main-footer">
                    <p>&copy; 2017 <a href="refaccionesfabela.com">Refacciones Fabela</a></p>
                </footer> <!-- / #main-footer -->

             

            <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                <s:hidden  name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                <s:hidden  name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
            </s:iterator>
            <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
            </s:iterator>
           <s:iterator value="ListaBuscarProducto" id="ListaBuscarProducto" status="stat">
              <s:hidden  name = "ListaBuscarProducto[%{#stat.index}].NAME_BODEGA"  id="NAME_BODEGA"></s:hidden>   
              <s:hidden  name = "ListaBuscarProducto[%{#stat.index}].CATIDAD"  id="CATIDAD"></s:hidden>   
                   <s:hidden  name = "ListaBuscarProducto[%{#stat.index}].ANANQUEL"  id="ANAQUEL"></s:hidden>   
                    <s:hidden  name = "ListaBuscarProducto[%{#stat.index}].NIVEL"  id="NIVEL"></s:hidden>
            </s:iterator> 
                
                
              <s:iterator value="ListaProductoAlt" id="ListaProductoAlt" status="stat">
              <s:hidden  name = "ListaProductoAlt[%{#stat.index}].NO_PARTE"  id="NO_PARTE"></s:hidden>   
              <s:hidden  name = "ListaProductoAlt[%{#stat.index}].NO_PARTE_ALTERNATIVO"  id="NO_PARTE_ALTERNATIVO"></s:hidden>   
                   <s:hidden  name = "ListaProductoAlt[%{#stat.index}].TOTAL_BODEGAS"  id="TOTAL_BODEGAS"></s:hidden>   
                    <s:hidden  name = "ListaProductoAlt[%{#stat.index}].PRECIO"  id="PRECIO"></s:hidden>
            </s:iterator>    
                
         <s:iterator value="ListaProductosGral" id="ListaProductosGral" status="stat">
              <s:hidden  name = "ListaProductosGral[%{#stat.index}].NO_PARTE"  id="NO_PARTE"></s:hidden>   
              <s:hidden  name = "ListaProductosGral[%{#stat.index}].ALTERNATIVO"  id="ALTERNATIVO"></s:hidden>   
                   <s:hidden  name = "ListaProductosGral[%{#stat.index}].TOTAL_BODEGAS"  id="TOTAL_BODEGAS"></s:hidden>   
                    <s:hidden  name = "ListaProductosGral[%{#stat.index}].PRECIO"  id="PRECIO"></s:hidden>
                    <s:hidden  name = "ListaProductosGral[%{#stat.index}].PRODUCTO"  id="PRODUCTO"></s:hidden>
            </s:iterator>     
                
                <s:iterator value="ListaProductoHist" id="ListaProductoHist" status="stat">
              <s:hidden  name = "ListaProductoHist[%{#stat.index}].NO_PARTE"  id="NO_PARTE"></s:hidden>   
              <s:hidden  name = "ListaProductoHist[%{#stat.index}].PRODUCTO"  id="PRODUCTO"></s:hidden>   
                 
                    <s:hidden  name = "ListaProductoHist[%{#stat.index}].PRECIO"  id="PRECIO"></s:hidden>
                    <s:hidden  name = "ListaProductoHist[%{#stat.index}].PRECIO_PESO"  id="PRECIO_PESO"></s:hidden>
                    <s:hidden  name = "ListaProductoHist[%{#stat.index}].MONEDA"  id="MONEDA"></s:hidden>
                    <s:hidden  name = "ListaProductoHist[%{#stat.index}].PROVEEDOR"  id="PROVEEDOR"></s:hidden>
                    <s:hidden  name = "ListaProductoHist[%{#stat.index}].FECHAINGRESO"  id="FECHAINGRESO"></s:hidden>
            </s:iterator>  
                 <s:iterator value="ListaClientes" id="ListaClientes" status="stat">                        
                <s:hidden  name = "ListaClientes[%{#stat.index}].RFC_CLIENT" id="RFC_CLIENT"></s:hidden>
                <s:hidden  name = "ListaClientes[%{#stat.index}].NOMBRE_CLIENT" id="NOMBRE_CLIENT"></s:hidden>
                <s:hidden  name = "ListaClientes[%{#stat.index}].EMPRESA" id="EMPRESA"></s:hidden>
               
            </s:iterator>
                
                
                
                
                
                
<s:textfield type="text" name="camp.PARTEAUX" id="PARTEAUX" style='visibility:hidden'  ></s:textfield>
    
<s:textfield type="text" name="camp.PRECIO_CAL" id="PRECIO_CAL" value="NO"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.AUX_RFC_CLIENTE" id="AUX_RFC_CLIENTE"  style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.PRECIO_PESO" id="PRECIO_PESO"  style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.TOTAL_PRODUCTO_VENTA" id="TOTAL_PRODUCTO_VENTA"  style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.RFCCLIENTE" id="RFCCLIENTE"  style='visibility:hidden' ></s:textfield>

<s:textfield type="text" name="camp.NO_COTIZACION" id="NO_COTIZACION" style='visibility:hidden'   ></s:textfield>
<s:textfield type="text" name="camp.BORRARPRODUCTO" id="BORRARPRODUCTO" style='visibility:hidden'   ></s:textfield>

        </s:form>


    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>

