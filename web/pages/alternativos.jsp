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
    </script>








<html xmlns="http://www.w3.org/1999/xhtml">


    <link href="css/menu.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">

        function guarda(accion) {

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
         function borrarAlternativo(accion, valor) {

            document.forma.AUX_ALTERNATIVO.value = valor;
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
     function consultaCliente(accion, valor, valor2) {

            document.forma.AUX_RFC_CLIENTE.value = valor;
             document.forma.RFCCLIENTE.value = valor2;
            document.forma.action = accion;
            document.forma.target = "_self";
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
                            
                            

                            <div class="div_sec1" id="flotante-busqueda">
                                <div class="div-busqueda" >
                               
                                    <div class="div_titulos_sec"> <h2 class="text-tit-sec">Busqueda</h2></div>
                                <s:textfield name="camp.CONSULTA_PARTE" id="CONSULTA_PARTE" placeholder="Número de Parte" required="true"  cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();"/>
                               
                                <a href="Javascript:guarda('buscarAlternativos')"><div class="boton">  Buscar  </div> </a>
                                
                           
                                <!--TABLA DE UBICACIONES -->

                                <div id="scroltabla-ubicaciones">
                                    <s:if test="ListaBuscarProducto.size()>0">
                                    <table id="customers">
                                        <thead>
                                            
                                            <th>Bodega</th>
                                            <th>Cantidad</th>
                                            <th>Ubicación</th>
                                        </thead>

                                        <s:iterator value="ListaBuscarProducto" id="ListaBuscarProducto" status="stat" >
                                            <tr>
                                                
                                                <td><s:property value="NAME_BODEGA" /></td>
                                                <td id="centrar-dato"><s:property value="CATIDAD" /></td>
                                                <td id="centrar-dato"><s:property value="ANAQUEL" /><s:property value="NIVEL" /></td>
                                            </tr>
                                        </s:iterator>
                                        <s:textfield type="text" name="camp.RFCAUX" id="RFCAUX" style='visibility:hidden'  ></s:textfield> 
                                        </table>
                                    </div>
                                    </s:if>
                                    <!--TABLA DE ALTERNATIVOS -->

                              
                                    <div id="scroltabla-ubicaciones">
                               <s:if test="ListaBuscarProducto.size()>0">
                                        <table id="customers" >
                                            <thead  >
                                                <th>Alternativo</th>
                                                <th>Cantidad   </th>
                                                 <th>Precio   </th>
                                            </thead>

                                            <s:iterator value="ListaProductoAlt" id="ListaProductoAlt" status="stat" >
                                                <tr <s:if test='NO_PARTE=="NO"'>style="background: #FB6E6E; color:white;"</s:if>>
                                                    <td><a href="Javascript:consulta('buscarAlternativos','<s:property value="NO_PARTE_ALTERNATIVO" />')"><s:property value="NO_PARTE_ALTERNATIVO" /></a></td>
                                                <td id="centrar-dato"><s:property value="TOTAL_BODEGAS" /></td>
                                                <td id="centrar-dato"><s:property value="PRECIO" /></td>
                                            </tr>
                                        </s:iterator>
 
                                        </table>
                                </s:if>
                                    </div>

                                    <!-- <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>-->


                                </div>
                            </div>
                     
                            <!-- BUSQUEDA DE CLIENTE PARA LA VENTA O NOTA -->    
                                
                                
                            

                        </article> 
                        <article class="articulo2">
                            
                        <s:if test="actprod2">
                            
                            
                           <s:if test="ListaPedidosBuscar.size()<1 && camp.CONSULTA_PARTE.length()>0">
                                      <div class="div_sec1">
                                    
                         <div style="width: 350px; height: 30px; color: white; font-size: 12px; background: green; text-align: center;  margin-right: 50px;  border-radius: 10px; margin-left: 50px;  margin: auto; margin-top: 80px; font-size: 14px; box-shadow: 5px 5px 10px #333; ">¡El número de parte consultada no fue encontrada!</div>
                                        </div>
                                </s:if>
                            
                        </s:if>
                            
                                         
                            <s:if test="ListaBuscarProductoFinal.size()>0">             
              
                           <div class="div_sec1">
                               
                               
                           
                               <div class="div_titulos_sec"> <h2 class="text-tit-sec" style="font-size: 14px;">Alternativos</h2></div>
                                
                                <table id="customers" style="width: 85%; margin: auto;">
                                        
                                        
                                   
                                    <thead>
                                            <th>Parte</th>
                                            <th>Producto</th>
                                            <th>Descripción</th>
                                            <th>Marca</th>
                                           
                                            <th>Precio Unitario</th>
                                           
                                          
                                            
                                            
                                        </thead>

                                      
                                              <tr style="background: #333; color: white;">
                                                  <td style="text-align: center;"><a href="Javascript:consulta('buscarProductos','<s:property value="camp.NO_PARTE" />')" style="background: #333 ; color: white; text-align: center;"> <s:property value="camp.NO_PARTE" /></a> </td>
                                                <td><s:property value="camp.PRODUCTO" /></td>
                                                 <td><s:property value="camp.DESCRIPCION" /></td>
                                                <td id="centrar-dato"><s:property value="camp.MARCA" /></td>
                                                
                                                <td id="centrar-dato" style="background: #333; color: white;"><s:property value="camp.PRECIO_PESO" /></td>
                                               
                                            

                                            </tr>
                                          
                                                <tr>
                                                    <td style="background: #F0B823; color: black; text-align: center;">Parte Alternativa</td>
                                                    <td> <s:textfield name="camp.NO_ALTERNATIVOS" id="NO_ALTERNATIVOS" placeholder="Parte Alternativa" required="true"  cssClass="campoFormBusqueda" /></td>
                                                <td ></td>
                                                
                                                <td id="centrar-dato" ></td>
                                                <td id="centrar-dato"><s:if test="camp.NO_VENTA<1"><a href="Javascript:guarda('guardarAlternativo')"><img src="img/emitido.png"/></a></s:if></td>
                                            

                                            </tr>
                                     


                                        </table>
                                
                           
                               
                            

                                
                                </div>
                              
                               
                               
                              </s:if>  


                       
                        
                           
                            
                            
                            
                             
                           
                            
                            
                            
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
                              
                     
                                
                                
                            <s:if test="ListaAlternativos.size()>0">
                            <div class="div_sec1">

                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Lista de Alternativos </h2></div>
                            
                           
                            <div class="div_form_cliente">
                                <div id="scroltabla-cliente">
                                    <div class="contenedor-tab-hist-prog">
                                         <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                                    <s:param name="TipoReporte" value="'COTIZACIONBUENA.jasper'"/>
                                                    <s:param name="NO_COTIZA" value="camp.NO_COTIZACION"/>
                                                    
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
                                            <th>Alternativo</th>
                                            <th>Producto</th>
                                            <th>Descripción</th>
                                            <th>Marca</th>
                                             <th>Eliminar</th>
                                            
                                            
                                        </thead>

                                            <s:iterator value="ListaAlternativos" id="  ListaAlternativos" status="stat" >
                                                <tr >
                                                  <td id="centrar-dato"><a href="Javascript:consulta('buscarAlternativos','<s:property value="NO_PARTE" />')"> <s:property value="ALTERNATIVO" /></a> </td>
                                                <td id="centrar-dato" <s:if test="PRODUCTO=='NO'"> style="background: red; color: white;"</s:if> ><s:property value="PRODUCTO" /></td>
                                                <td id="centrar-dato"><s:property value="DESCRIPCION" /></td>
                                                <td id="centrar-dato" ><s:property value="MARCA" /></td>
                                                <td  id="centrar-dato">  <div class="img-pos-eliact" ><a href="Javascript:borrarAlternativo('borrarAlternativo','<s:property value="ID_ALTERNATIVOS" />')" style="margin: auto;"><img src="img/iconEliminar.png" alt="Eliminar"></img></a></div></td>


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
    
<s:textfield type="text" name="camp.PRECIO_CAL" id="PRECIO_CAL" value="NO" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.AUX_RFC_CLIENTE" id="AUX_RFC_CLIENTE" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.PRECIO_PESO" id="PRECIO_PESO" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.TOTAL_PRODUCTO_VENTA" id="TOTAL_PRODUCTO_VENTA" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.RFCCLIENTE" id="RFCCLIENTE" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.AUXCOTIZA" id="AUXCOTIZA"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.NO_COTIZACION" id="NO_COTIZACION"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.BORRARPRODUCTO" id="BORRARPRODUCTO"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.NO_VENTA" id="NO_VENTA" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.AUX_ALTERNATIVO" id="AUX_ALTERNATIVO" style='visibility:hidden'  ></s:textfield>
        </s:form>


    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>

