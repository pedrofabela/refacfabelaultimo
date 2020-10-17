<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Fecha', 'Precio al Púbico', 'Precio de provedor'],
    <s:iterator value="ListaProductoHist" id="  ListaProductoHist" status="stat" >
            ['<s:property value="FECHAINGRESO"/>', <s:property value="PRECIO" />, <s:property value="PRECIO_PESO"/>],
    </s:iterator>

        ]);

        var options = {
            title: 'Historial de ingreso de los productos',
            hAxis: {title: 'Fecha de ingreso del Producto', titleTextStyle: {color: '#333'}},
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
        function consulta(accion, valor) {

            document.forma.CONSULTA_PEDIDO.value = valor;
            document.forma.action = accion;
            document.forma.target = "_self";
            document.forma.submit();
        }
        
        function ingresarP(accion, valor) {

            document.forma.PRODUCT.value = valor;
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
                              <!--      <div class="div_titulos_sec"> <h2 class="text-tit-sec">Busqueda</h2></div>
                                <s:textfield name="camp.CONSULTA_PEDIDO" id="CONSULTA_PEDIDO" placeholder="Número de Pedido" required="true"  cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();"/>

                                <a href="Javascript:guarda('comprasBuscar')"><div class="boton">  Buscar  </div> </a>
                                -->
                               <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>

                                <!--TABLA DE UBICACIONES -->

                                <div id="scroltabla-ubicaciones" style="height: 300px; max-height: 280px;">
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


                               

                                <!-- <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>-->


                            </div>
                        </div>

                    </article> 
                    <article class="articulo2">
                        <s:if test="ListaPedidosFaltantes.size()>0">
                        <div class="div_sec1">
                            <div id="scroltabla-cliente">
                             <div class="div_titulos_sec"> <h2 class="text-tit-sec">Faltantes de Pedidos</h2></div>
                                <table id="customers" style="width: 95%; margin: auto; border-radius: 20px;">
                                        <tr  >
                                           <th id="centrar-dato">Número de Pedido</th>
                                            <th id="centrar-dato">Número de Parte</th>
                                            <th id="centrar-dato">Cantidad Pedida </th>
                                            <th id="centrar-dato">Cantidad Llegada </th>
                                            <th id="centrar-dato">Proveedor </th>
                                             <th id="centrar-dato">Fecha de Pedido </th>
                                             <th id="centrar-dato">Fecha de llegada </th>
                                        </tr>

                                    <s:iterator value="ListaPedidosFaltantes" id="ListaPedidosFaltantes" status="stat" >
                                       
                                        
                                        <tr  >
                                             <td id="centrar-dato"><s:property value="ID_PEDIDO" /></td>
                                            <td id="centrar-dato"><s:property value="NO_PARTE" /></td>
                                            <td id="centrar-dato"><s:property value="CANTIDAD" /></td>
                                            <td id="centrar-dato" style="background: #e1173e; color:white;"><s:property value="CANTIDAD_LLEGADA" /></td>
                                            <td id="centrar-dato"><s:property value="PROVEEDOR" /></td>
                                            <td id="centrar-dato"><s:property value="FECHA_PEDIDO" /></td>
                                            <td id="centrar-dato"><s:property value="FECHA_LLEGADA" /></td>
                                        </tr>
                                       


                                    </s:iterator>

                                </table>
                                </div>
                            
                            
                        </div>
                        </s:if>
                        
                        
                        <div class="div_sec1">

                            
                            
                            
                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Productos del Pedido</h2></div>
                             <td id="centrar-dato"><s:select  cssClass="campoFormSelect" cssStyle="width: 70%;" name="camp.BODEGA" id="camp.BODEGA" list="{'LOCAL','CASA'}" headerValue="Seleccione una Bodega" /></td>
                            <td id="centrar-dato"  style="max-width: 40px; min-width: 40px;"><s:select style="width:70%;  text-align: center;" cssClass="campoFormSelect" id="ANAQUEL" name="camp.ANAQUEL" list="ListaAnaquel" listKey="ANAQUEL" listValue="ANAQUEL" headerKey="" headerValue="SELECCIONE" /> </td>
                                            <td id="centrar-dato" style="max-width: 40px; min-width: 40px;"><s:select style="width:70%;  text-align: center;" cssClass="campoFormSelect" id="NIVEL" name="camp.NIVEL" list="ListaNivel" listKey="NIVEL" listValue="NIVEL" headerKey="" headerValue="SELECCIONE" /></td>
                                            
 <a href="Javascript:guarda('inventarioLista')"><div class="boton"> Buscar estante  </div> </a>
   



                        </div>
                        
                        
                        
                      
                                            <s:if test="ListaInventario.size()>0">     
                        <div class="div_sec1">


                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Total de Productos del Estante <s:property value="camp.ANAQUEL"/><s:property value="camp.NIVEL"/>: <s:property value="ListaInventario.size()"/></h2></div>
                            <s:if test="foliopedido">
                            <div class="div_titulos_sec" style="background: #333; box-shadow: none; float: right; margin-right: 30px; width: 40%;"> <h2 class="text-tit-sec" style="color:white; text-shadow:none; font-size: 12px; margin-top: 0px;">El pedido fue guardao con folio: <s:property value="camp.ID_PEDIDO"/></h2></div>
                            </s:if>

                            <div id="scroltabla-cliente">
                           
                                <table id="customers" style="width: 95%; margin: auto; border-radius: 20px;">
                                       
                                    
                                    
                                    <tr  >
                                        <th id="centar-dato">NP</th>
                                            <th id="centrar-dato" style="max-width: 120px;">Número de Parte</th>
                                            <th id="centrar-dato" style="max-width: 120px;">Producto </th>
                                            <th id="centrar-dato">Ubicación</th>
                                             <th id="centrar-dato" style="max-width: 40px; min-width: 40px;">Bodega</th>
                                              <th id="centrar-dato" style="max-width: 40px; min-width: 40px;">Cantidad</th>
                                            
                                
                                        </tr>

                                    <s:iterator value="ListaInventario" id="ListaInventario" status="stat" >
                                       
                                      
                                        <tr  >
                                            <td id="centrar-dato"><s:property value="#stat.count" /></td>
                                            <td id="centrar-dato"  style="max-width: 120px;"><s:property value="NO_PARTE" /></td>
                                            <td id="centrar-dato" style="max-width: 120px;"><s:property value="PRODUCTO" /> </td>
                                            <td id="centrar-dato"><s:property value="ANAQUEL" /><s:property value="NIVEL" /></td>
                                            <td id="centrar-dato"  style="max-width: 40px; min-width: 40px;"><s:property value="NAME_BODEGA" /> </td>
                                            <td id="centrar-dato" style="max-width: 40px; min-width: 40px;"><s:property value="CATIDAD" /></td>
                                            
                                           
                                        </tr>
                                       


                                    </s:iterator>

                                </table>
                                
                                
                            
                                </div>
                         
                              <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">

                                <s:param name="TipoReporte" value="'inventario.jasper'"/>
                                <s:param name="ANAQUEL" value="camp.ANAQUEL"/>
                              <s:param name="NAME_BODEGA" value="camp.BODEGA"/>
                              <s:param name="NIVEL" value="camp.NIVEL"/>
                                <s:param name="esExcel" value="'false'"/>
                                <s:param name="esPDF" value="'true'"/>            

                            </s:url> 

                            <a href= "<s:property value="#myUrl" />" target="_blank"  ><div class="boton" style=" background: #333; color: white; margin-bottom: 20px;"> Imprimir Pedido  </div></a>
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
                                
                                 <s:iterator value="ListaAnaquel" id="ListaAnaquel" status="stat">
                            <s:hidden  name = "ListaAnaquel[%{#stat.index}].ANAQUEL"  id="ANAQUEL"></s:hidden>   
                            <s:hidden  name = "ListaAnaquel[%{#stat.index}].NAME_BODEGA"  id="NAME_BODEGA"></s:hidden>   

                        </s:iterator> 
                                 <s:iterator value="ListaNivel" id="ListaNivel" status="stat">
                            <s:hidden  name = "ListaNivel[%{#stat.index}].NIVEL"  id="NIVEL"></s:hidden>   
                            <s:hidden  name = "ListaNivel[%{#stat.index}].NAME_BODEGA"  id="NAME_BODEGA"></s:hidden>   

                        </s:iterator> 

                        <s:hidden  name = "regprod"  id="regprod"></s:hidden>  
                        <s:hidden  name = "actprod"  id="actprod"></s:hidden>  
                        

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
                
                 <s:iterator value="ListaCarritoPedidos" id="ListaCarritoPedidos" status="stat">
                <s:hidden  name = "ListaCarritoPedidos[%{#stat.index}].NO_PARTE"  id="NO_PARTE"></s:hidden>   
                <s:hidden  name = "ListaCarritoPedidos[%{#stat.index}].CANTIDAD"  id="CANTIDAD"></s:hidden>   
                <s:hidden  name = "ListaCarritoPedidos[%{#stat.index}].FECHA_PEDIDO"  id="FECHA_PEDIDO"></s:hidden>   
                <s:hidden  name = "ListaCarritoPedidos[%{#stat.index}].PROVEEDOR"  id="PROVEEDOR"></s:hidden>
               
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
                
                 <s:iterator value="ListaPedidosPendientes" id="ListaPedidosPendientes" status="stat">
                <s:hidden  name = "ListaPedidosPendientes[%{#stat.index}].ID_PEDIDO"  id="ID_PEDIDO"></s:hidden>   
                <s:hidden  name = "ListaPedidosPendientes[%{#stat.index}].TOTAL_PARTES"  id="TOTAL_PARTES"></s:hidden>   
                <s:hidden  name = "ListaPedidosPendientes[%{#stat.index}].TOTAL_PRODUCTOS"  id="TOTAL_PRODUCTOS"></s:hidden>   
              
               
            </s:iterator>  
                
                        <s:iterator value="ListaPedidosBuscar" id="ListaPedidosBuscar" status="stat" >
                              <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].ID_PRODUCT"  id="ID_PRODUCT"></s:hidden> 
                              <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].ID_PEDIDO"  id="ID_PEDIDO"></s:hidden>   
                             <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].NO_PARTE"  id="NO_PARTE"></s:hidden>  
                              <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].FECHA_PEDIDO"  id="FECHA_PEDIDO"></s:hidden> 
                               <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].PROVEEDOR"  id="PROVEEDOR"></s:hidden>
                               <s:hidden  name = "ListaPedidosBuscar[%{#stat.index}].ESTATUS_PEDIDO"  id="ESTATUS_PEDIDO"></s:hidden>
                        </s:iterator>

            <s:textfield type="text" name="camp.PARTEAUX" id="PARTEAUX" style='visibility:hidden'  ></s:textfield>
            <s:textfield type="text" name="camp.PRECIO_CAL" id="PRECIO_CAL" value="NO" style='visibility:hidden' ></s:textfield>
             <s:textfield type="text" name="camp.MAX_AUXPEDIDO" id="MAX_AUXPEDIDO" style='visibility:hidden'  ></s:textfield>
             <s:textfield type="text" name="camp.ID_PRODUCT" id="PRODUCT" style='visibility:hidden' ></s:textfield>
             
            
        </s:form>


    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>

