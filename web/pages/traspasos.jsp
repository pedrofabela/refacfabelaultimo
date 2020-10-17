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
        
        
         function ubicacion(accion) {
             
             var x = document.getElementById("NAME_BODEGA").value;
              var ubicacion = x.split("+");
              
              var anaquel=ubicacion[0];
              var nivel=ubicacion[1];
               var BODEGA=ubicacion[2];
             
             
             document.getElementById("ANAQUEL").value=anaquel;
             
               document.getElementById("NIVEL").value=nivel;
               
               document.getElementById("NAME_BODEGA").value=x;
               
                document.getElementById("BODEGA_AUXILIAR").value=BODEGA;
            //document.forma.action = accion;
            //document.forma.submit();
        }
        
         function validaTraspaso(accion) {
            
          var cantidad = document.getElementById('CANTIDAD_LLEGADA2').value;
                
    var name_bodega = document.getElementById('BODEGA_AUXILIAR').value;
    var anaquel = document.getElementById('ANAQUEL').value;
    var nivel = document.getElementById('NIVEL').value;
     var bodega = document.getElementById('BODEGA').value;
           
             
           if(cantidad.length<=0 || name_bodega.length<=0 || anaquel.length<=0 || nivel.length<=0 || name_bodega==bodega  ){
            
          if(name_bodega==bodega){
                
                 alert("No se pueden hacer traspasos entre las mismas bodegas"); 
                
            }
            else{
            
            alert("Todos los datos son requeridos");
             }
            
               
           }  
           else {
                document.forma.action = accion;
          document.forma.submit();
           }
             
             
           
        }
        
        function actualiza(accion, valor) {

            document.forma.RFCAUX.value = valor;
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
        
        function traspaso(accion, valor, valor2, valor3) {

 
            document.forma.NO_PARTE.value = valor;
             document.forma.BODEGA.value = valor2;
              document.forma.CANTIDAD.value = valor3;
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
        
        
           window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
                                    var pos = window.name || 0;
                                    window.scrollTo(0, pos);

            window.location.hash = "no";
            window.location.hash = "Again-No-back-button" //chrome
            window.onhashchange = function () {
                window.location.hash = "no";
            }
            
            

        }

        window.onunload = function () {
            window.name = self.pageYOffset
                    || (document.documentElement.scrollTop + document.body.scrollTop);


        }
        
        
        
        
        
        
    </script>
    
    
    <script language="javascript" type="text/javascript">

    //*** Este Codigo permite Validar que sea un campo Numerico
    function Solo_Numerico(variable){
        Numer=parseInt(variable);
        stok=<s:property value="camp.CANTIDAD"/>;
        stokint=parseInt(stok);
        
        valida=stokint-Numer;
        
       
        if (isNaN(Numer) || valida<0){
            return "";
        }
        return Numer;
    }
    function ValNumero(Control){
        Control.value=Solo_Numerico(Control.value);
    }
    //*** Fin del Codigo para Validar que sea un campo Numerico

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

                                <a href="Javascript:guarda('buscarProductosTraspasos')"><div class="boton">  Buscar  </div> </a>


                                <!--TABLA DE UBICACIONES -->

                                <div id="scroltabla-ubicaciones2" style="margin-top: 20px; height: 200px;">
                                    <s:if test="ListaBuscarProducto.size()>0">
                                    <table id="customers">
                                        <thead>
                                            
                                            <th>Bodega</th>
                                            <th>Cantidad</th>
                                            <th>Ubicación</th>
                                        </thead>

                                        <s:iterator value="ListaBuscarProducto" id="ListaBuscarProducto" status="stat" >
                                            <tr>
                                                
                                                <td><a href="Javascript:traspaso('nuevoTraspasos','<s:property value="NO_PARTE" />','<s:property value="NAME_BODEGA" />','<s:property value="CATIDAD" />')" ><s:property value="NAME_BODEGA" /></a></td>
                                                <td id="centrar-dato"><s:property value="CATIDAD" /></td>
                                                <td id="centrar-dato"><s:property value="ANAQUEL" /><s:property value="NIVEL" /></td>
                                            </tr>
                                        </s:iterator>
                                        <s:textfield type="text" name="camp.RFCAUX" id="RFCAUX" style='visibility:hidden'  ></s:textfield> 
                                        </table>
                                   
                                    </s:if> 
                                </div>
                                
                                 
                                
                                
                                    <!--TABLA DE ALTERNATIVOS -->

                              <div id="scroltabla-ubicaciones">
                               <s:if test="ListaBuscarProducto.size()>0">
                                        <table id="customers" >
                                            <thead  >
                                                <th width="130">Alternativo</th>
                                                <th>Cantidad   </th>
                                                 <th>Precio   </th>
                                            </thead>

                                            <s:iterator value="ListaProductoAlt" id="ListaProductoAlt" status="stat" >
                                                <tr width="130" <s:if test='NO_PARTE=="NO"'>style="background: #FB6E6E; color:white;"</s:if>>
                                                    <td><a href="Javascript:consulta('buscarProductosVenta','<s:property value="NO_PARTE_ALTERNATIVO" />')"><s:property value="NO_PARTE_ALTERNATIVO" /></a></td>
                                                <td id="centrar-dato" <s:if test="TOTAL_BODEGAS==0"> style="background: red; color: white;" </s:if>><s:property value="TOTAL_BODEGAS" /></td>
                                                <td id="centrar-dato"><s:property value="PRECIO" /></td>
                                            </tr>
                                        </s:iterator>
 
                                        </table>
                               
                                   
                                    </s:if>
                                         </div>
                                   

                                    <!-- <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>-->


                                </div>
                            </div>

                        </article> 
                        <article class="articulo2">
                    <s:if test="traspaso">
                           <div class="div_sec1">
                               
                               
                               <div style="width: 100%; text-align: center; color: #333; margin-top: 20px; margin-bottom: 20px;"> 
                                   
                                   El Producto: <s:property value="camp.NO_PARTE" /> que se encuentra en la bodega: <s:property value="camp.BODEGA" /> con un total de: <s:property value="camp.CANTIDAD" />  se moverá a:
                               </div>
                                   
                               
                            <div id="scroltabla-cliente">
                           
                                <table id="customers" style="width: 95%; margin: auto; border-radius: 20px;">
                                       
                                    
                                    
                                    <tr  >
                                            
                                            <th id="centrar-dato" style="max-width: 120px;">Cantidad </th>
                                            <th id="centrar-dato">Bodega</th>
                                             <th id="centrar-dato" style="max-width: 40px; min-width: 40px;">Anaquel</th>
                                              <th id="centrar-dato" style="max-width: 40px; min-width: 40px;">Nivel</th>
                                            
                                             <th id="centrar-dato">Mover </th>
                                        </tr>

                                   
                                       
                                        
                                        <tr>
                                           
                                            <td id="centrar-dato" style="max-width: 120px;"><s:textfield  name="camp.CANTIDAD_LLEGADA" id="CANTIDAD_LLEGADA2" placeholder="Número de Productos" required="true" cssClass="campoFormProducto"  onchange="return ValNumero(this);" /> </td>
                                            <td id="centrar-dato"><s:select  cssClass="campoFormSelect" cssStyle="width: 100%;" name="camp.NAME_BODEGA" id="NAME_BODEGA" list="ListaBuscarProducto" listKey="ANAQUEL+'+'+NIVEL+'+'+NAME_BODEGA" listValue="NAME_BODEGA" headerKey="" headerValue="Seleccione una Bodega"  onchange="Javascript:ubicacion('selectCategoria')" />  </td>
                                            <td id="centrar-dato"  style="max-width: 40px; min-width: 40px;"><s:select style="width:70%;  text-align: center;" cssClass="campoFormSelect" id="ANAQUEL" name="camp.ANAQUEL" list="ListaAnaquel" listKey="ANAQUEL" listValue="ANAQUEL" headerKey="" headerValue="SELECCIONE" /> </td>
                                            <td id="centrar-dato" style="max-width: 40px; min-width: 40px;"><s:select style="width:70%;  text-align: center;" cssClass="campoFormSelect" id="NIVEL" name="camp.NIVEL" list="ListaNivel" listKey="NIVEL" listValue="NIVEL" headerKey="" headerValue="SELECCIONE" /></td>
                                            
                                            <td id="centrar-dato"><a href="Javascript:validaTraspaso('traspasar')" onclick="this.onclick=function(){return false}" ><img src="img/emitido.png"/></a></td>
                                        </tr>
                                        
                                        


                                   

                                </table>
                               
                                
                           </div>
                              
                               
                               
                              

                           </div>  

                       
                        </s:if>
                           
                            
                            
                            
                             <s:if test="regprod">
                           <div class="div_sec1">
                               
                               
                           
                                <div class="div_titulos_sec"> <h2 class="text-tit-sec">Registro de Producto</h2></div>
                           
                                <div style="margin-bottom: 40px;">
                                    <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  >Número de Parte</h5></div>  <div class="div-cont-campos"><div > <s:textfield  name="camp.NO_PARTE" id="camp.NO_PARTE" placeholder="Número de Parte" required="true"  cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();" readonly="true"/></div></div></div>
                                    <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5 <s:if test="pea1">id="errorCampo"</s:if> >Producto</h5></div>  <div class="div-cont-campos"><div ><s:textfield  name="camp.PRODUCTO" id="camp.PRODUCTO" placeholder="PRODUCTO" required="true" cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();" />    </div></div></div>
                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  <s:if test="pea2">id="errorCampo"</s:if> >Categoria General</h5></div>  <div class="div-cont-campos"><div >  <s:select style="width:70%;" cssClass="campoFormSelect" name="camp.CATEGORIA_GENERAL" list="ListaCategoriaGral" listKey="CATEGORIA_GENERAL" listValue="CATEGORIA_GENERAL" headerKey="" headerValue="--SELECCIONE--"   onchange="Javascript:guarda('selectCategoria')"/></div></div></div>
                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5 <s:if test="pea3">id="errorCampo"</s:if> >Categoria</h5></div>  <div class="div-cont-campos"><div >  <s:select style="width:70%;" cssClass="campoFormSelect" name="camp.CATEGORIA" list="ListaCategoria" listKey="CATEGORIA" listValue="CATEGORIA" headerKey="" headerValue="--SELECCIONE--"/></div></div></div>

                                <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  >Descripción</h5></div>  <div class="div-cont-campos"><div >  <s:textfield name="camp.DESCRIPCION" id="camp.DESCRIPCION" placeholder="DESCRIPCION" required="true" cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();"/></div></div></div>
                                 <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  >Marca</h5></div>  <div class="div-cont-campos"><div ><s:textfield name="camp.MARCA" id="camp.MARCA" placeholder="MARCA" required="true" cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();"/> </div></div></div>
                                 <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  >Unidad de Medida</h5></div>  <div class="div-cont-campos"><div ><s:textfield name="camp.UNIDADMEDIDA" id="camp.UNIDADMEDIDA" placeholder="UNIDAD DE MEDIDA" required="true" cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();"/> </div></div></div>

                                 <div class="div-dos-campos"><div class="div-cont-campos" id="color-etiqueta"> <h5  >Proveedor</h5></div>  <div class="div-cont-campos"><div >  <s:select style="width:70%;" cssClass="campoFormSelect" name="camp.PROVEEDOR" list="ListaSelectProvee" listKey="RASON_PROVEE" listValue="RASON_PROVEE" headerKey="" headerValue="--SELECCIONE--"/></div></div></div>
                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-verde"> <h5 <s:if test="pea6">id="errorCampo"</s:if> style="color:white;"  >Precio</h5></div>  <div class="div-cont-campos"><div >  <s:textfield name="camp.PRECIO" id="camp.PRECIO" placeholder="PRECIO" required="true" cssClass="campoFormProducto" onKeyUp="this.value=this.value.toUpperCase();" onchange="Javascript:guarda('simuladorPrecio')" /></div></div></div>

                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-verde"> <h5 style="color:white;"  >Moneda</h5></div>  <div class="div-cont-campos"><div > <s:select style="width:70%;"  cssClass="campoFormSelect" name="camp.MONEDA" id="camp.MONEDA" list="{'PESO','USD'}" headerValue="Seleccione una Moneda" onchange="Javascript:guarda('simuladorPrecio')" /> </div></div></div>
                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-verde"> <h5 style="color:white;"  >Ganancia</h5></div>  <div class="div-cont-campos"><div ><s:select style="width:70%;  text-align: center;" cssClass="campoFormSelect" name="camp.GANANCIA" list="ListaGanancia" listKey="GANANCIA" listValue="ID_GANANCIA+'%'" headerKey="" headerValue="--SELECCIONE--" onchange="Javascript:guarda('simuladorPrecio')"/>  </div></div></div>
                               <div class="div-dos-campos"><div class="div-cont-campos" id="color-verde" style="background: white; box-shadow: none;"><a href="Javascript:guarda('guardaProducto')"> <div class="div-marea" style="margin: auto; margin-top: 20px;"><div class="div-marea-texto"><s:property value="camp.SIMULADOR_PRECIO"/></div> <div class="preloader"></div></a>  </div>
                            </div>  <div class="div-cont-campos"><div > </div></div></div>

                                
                                </div>
                              
                               
                               
                              

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

                       
                            
                    </div>




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
                
                
                
                
                
                
<s:textfield type="text" name="camp.PARTEAUX" id="PARTEAUX" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.PRECIO_CAL" id="PRECIO_CAL" value="NO" style='visibility:hidden' ></s:textfield>

<s:textfield type="text" name="camp.NO_PARTE" id="NO_PARTE" style='visibility:hidden'   ></s:textfield>
<s:textfield type="text" name="camp.BODEGA" id="BODEGA"  style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.CANTIDAD" id="CANTIDAD" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.BODEGA_AUXILIAR" id="BODEGA_AUXILIAR" style='visibility:hidden' ></s:textfield>

        </s:form>


    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>

