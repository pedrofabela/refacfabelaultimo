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

<script type="text/javascript">
	//EVENTOS EN javascript

	
        function hacer_click() { 
             location.href="#popup";
         
        
       
            
           
        } 
	
       
       


	function hacer_hover()
	{
		alert("Estas sobre mi!");
	}

	function salir_del_hover()
	{
		alert("Adios!");
	}

	function cargar_pagina()
	{alert("Ya se ha cargado el sitio web");}
	</script>


<script>
  function validarSiNumero(numero){
    if (!/^([0-9])*$/.test(numero))
     
     document.forma.INCREMENTO.value = "";
     
     
     
  }
</script>






<html xmlns="http://www.w3.org/1999/xhtml">


    <link href="css/menu.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
      function guardaValida(accion) {
            
        var stock=<s:property value="camp.TOTAL_PRODUCTO_BODEGAS"></s:property>;
     var vendidos =document.getElementById("CANTIDAD_VENTA").value;
     
      
      if(stock<vendidos){
      var mensaje =confirm("¡No se cuenta con la catidad de productos solicitada!, ¿Deseas agregar el producto a la cotización?"); 
        
        if (mensaje) {
 document.forma.action = accion;
           document.forma.submit();


}
//Detectamos si el usuario denegó el mensaje
else {

}
        
    } 
    else {
        
        document.forma.action = accion;
           document.forma.submit();
        
    }
        
          
       
        }
    </script>
    
    <script type="text/javascript">

        function guarda(accion) {
            
            
          
            document.forma.action = accion;
            document.forma.submit();
       
        }
        function incremento(accion) {
            
            numero=document.getElementById("INCREMENTO").value;
            
            if (!/^([0-9])*$/.test(numero)){
     
     document.forma.INCREMENTO.value = "";
 }
 else{
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
                            
                             <s:if test="camp.AUX_RFC_CLIENTE!=null">

                            <div class="div_sec1" id="flotante-busqueda">
                                <div class="div-busqueda" >
                               
                                    <div class="div_titulos_sec"> <h2 class="text-tit-sec">Busqueda</h2></div>
                                <s:textfield name="camp.CONSULTA_PARTE" id="CONSULTA_PARTE" placeholder="Número de Parte" required="true"  cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();"/>
                               
                                <a href="Javascript:guarda('buscarProductosVenta')"><div class="boton">  Buscar  </div> </a>
                                
                           
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
                                                <td id="centrar-dato" <s:if test="CATIDAD==0"> style="background: red; color: white;" </s:if>><s:property value="CATIDAD" /></td>
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
                                </s:if>  
                                
                            <!-- BUSQUEDA DE CLIENTE PARA LA VENTA O NOTA -->    
                                
                                 <s:if test="camp.AUX_RFC_CLIENTE==null"> 
                                <div class="div_sec1" id="flotante-busqueda">
                            <div class="div-busqueda">
                                 <div class="div_titulos_sec"> <h2 class="text-tit-sec">Busqueda</h2></div>
                            <s:textfield name="camp.BUSCARCLIENTE" id="camp.BUSCARCLIENTE" placeholder="RFC ó Nombre ó Empresa" required="true"  cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();"/>
                            
                              <a href="Javascript:guarda('clientesBuscarVenta')"><div class="boton">  Buscar  </div> </a>
                              
                              <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>
                            </div>



                        </div>
                            </s:if> 

                        </article> 
                        <article class="articulo2">
                            
                        <s:if test="actprod2">
                            
                            
                            <s:if test="ListaPedidosBuscar.size()<1 && camp.CONSULTA_PARTE.length()>0">
                                      <div class="div_sec1">
                                     <div class="div_titulos_sec"> <h2 class="text-tit-sec">Productos relacionados a la busqueda</h2></div>
                         
                         <div id="scroltabla-cliente" style="overflow: scroll; height: 350px;">
                                        <table id="customers">
                                            <thead>
                                                <th>No. Parte</th>
                                                <th>Producto</th>
                                                <th>Categoria</th>
                                                <th>Descripción</th>
                                                <th>Marca</th>
                                                <th>Total Bodegas</th>

                                                
                                            </thead>

                                            <s:iterator value="ListaBuscarProductoLike" id="ListaBuscarProductoLike" status="stat" >
                                                <tr>
                                                    <td><a href="Javascript:consulta('buscarProductosVenta','<s:property value="NO_PARTE" />')"><s:property value="NO_PARTE" /></a></td>
                                                    <td><s:property value="PRODUCTO" /></td>
                                                    <td><s:property value="CATEGORIA" /></td>
                                                    <td><s:property value="DESCRIPCION" /></td>
                                                    <td><s:property value="MARCA" /></td>
                                                    <td><s:property value="TOTAL_BODEGAS" /></td>

                                                </tr>

                                            </s:iterator>
                                        </table>
                         
                         
                                        </div>
                          </div>
                                </s:if>
                            
                        </s:if>
                            
                            <s:if test="ListaClientes.size()>0"> 
                                
                                 <s:if test="camp.AUX_RFC_CLIENTE!=null"> 
                            
                                     
                                     <div class="div_sec1">

                                <div class="div_titulos_sec"> <h2 class="text-tit-sec">Clientes</h2></div>
                                <div class="div_form_cliente">
                                    <div id="scroltabla-cliente">
                                        <table id="customers">
                                            <thead>
                                                <th>NP</th>
                                                <th>RFC</th>
                                                <th>Nombre del Cliente</th>
                                                <th>Empresa</th>

                                                
                                            </thead>

                                            <s:iterator value="ListaClientes" id="ListaClientes" status="stat" >
                                                <tr>
                                                    <td id="centrar-dato"><s:property value="#stat.count" /></td> 
                                                    <td ><a href="Javascript:consultaCliente('asignarCliente','<s:property value="RFC_CLIENT" />','<s:property value="NOMBRE_CLIENT" />')"><s:property value="RFC_CLIENT" /></a></td>
                                                    <td><s:property value="NOMBRE_CLIENT" /></td>
                                                    <td><s:property value="EMPRESA" /></td>

                                                  

                                                </tr>

                                            </s:iterator>
                                            <s:textfield type="text" name="camp.RFCAUX" id="RFCAUX" style='visibility:hidden'  ></s:textfield> 



                                        </table>

                                    </div>

                                </div>




                            </div>
                                            
                                </s:if>              
                                    </s:if>               
                                            
                   
                            
                        <s:if test="camp.NO_PARTE.length()>0">
                           <div class="div_sec1">
                               
                               
                           
                               <div class="div_titulos_sec"> <h2 class="text-tit-sec" style="font-size: 14px;">Cliente: <s:property value="camp.AUX_RFC_CLIENTE"/>-<s:property value="camp.RFCCLIENTE"/></h2></div>
                                 <s:if test="actprod">
                                <table id="customers" style="width: 85%; margin: auto;">
                                        
                                        
                                   
                                    <thead>
                                            <th>Parte</th>
                                            <th>Producto</th>
                                            <th>Descripción</th>
                                            <th>Marca</th>
                                           
                                            <th>Precio Unitario</th>
                                           
                                          
                                            
                                            
                                        </thead>

                                      
                                              <tr style="background: #333; color: white;">
                                                  <td style="text-align: center;"> <s:property value="camp.NO_PARTE" /> </td>
                                                <td><s:property value="camp.PRODUCTO" /></td>
                                                 <td><s:property value="camp.DESCRIPCION" /></td>
                                                <td id="centrar-dato"><s:property value="camp.MARCA" /></td>
                                                
                                                <td id="centrar-dato" style="background: #333; color: white;"><s:property value="camp.PRECIO_PESO" /></td>
                                               
                                            

                                            </tr>
                                          
                                                <tr>
                                                    <td style="background: #F0B823; color: black; text-align: center;">Cantidad: </td>
                                                <td><s:select style="width:70%;"  cssClass="campoFormSelect" name="camp.CANTIDAD_VENTA" id="CANTIDAD_VENTA" list="{'1','2'
,'3'
,'4'
,'5'
,'6'
,'7'
,'8'
,'9'
,'10'
,'11'
,'12'
,'13'
,'14'
,'15'
,'16'
,'17'
,'18'
,'19'
,'20'
,'21'
,'22'
,'23'
,'24'
,'25'
,'26'
,'27'
,'28'
,'29'
,'30'
,'31'
,'32'
,'33'
,'34'
,'35'
,'36'
,'37'
,'38'
,'39'
,'40'
,'41'
,'42'
,'43'
,'44'
,'45'
,'46'
,'47'
,'48'
,'49'
,'50'
,'51'
,'52'
,'53'
,'54'
,'55'
,'56'
,'57'
,'58'
,'59'
,'60'
,'61'
,'62'
,'63'
,'64'
,'65'
,'66'
,'67'
,'68'
,'69'
,'70'
,'71'
,'72'
,'73'
,'74'
,'75'
,'76'
,'77'
,'78'
,'79'
,'80'
,'81'
,'82'
,'83'
,'84'
,'85'
,'86'
,'87'
,'88'
,'89'
,'90'
,'91'
,'92'
,'93'
,'94'
,'95'
,'96'
,'97'
,'98'
,'99'
,'100'
,'101'
,'102'
,'103'
,'104'
,'105'
,'106'
,'107'
,'108'
,'109'
,'110'
,'111'
,'112'
,'113'
,'114'
,'115'
,'116'
,'117'
,'118'
,'119'
,'120'
,'121'
,'122'
,'123'
,'124'
,'125'
,'126'
,'127'
,'128'
,'129'
,'130'
,'131'
,'132'
,'133'
,'134'
,'135'
,'136'
,'137'
,'138'
,'139'
,'140'
,'141'
,'142'
,'143'
,'144'
,'145'
,'146'
,'147'
,'148'
,'149'
,'150'
,'151'
,'152'
,'153'
,'154'
,'155'
,'156'
,'157'
,'158'
,'159'
,'160'
,'161'
,'162'
,'163'
,'164'
,'165'
,'166'
,'167'
,'168'
,'169'
,'170'
,'171'
,'172'
,'173'
,'174'
,'175'
,'176'
,'177'
,'178'
,'179'
,'180'
,'181'
,'182'
,'183'
,'184'
,'185'
,'186'
,'187'
,'188'
,'189'
,'190'
,'191'
,'192'
,'193'
,'194'
,'195'
,'196'
,'197'
,'198'
,'199'
,'200'
,'201'
,'202'
,'203'
,'204'
,'205'
,'206'
,'207'
,'208'
,'209'
,'210'
,'211'
,'212'
,'213'
,'214'
,'215'
,'216'
,'217'
,'218'
,'219'
,'220'
,'221'
,'222'
,'223'
,'224'
,'225'
,'226'
,'227'
,'228'
,'229'
,'230'
,'231'
,'232'
,'233'
,'234'
,'235'
,'236'
,'237'
,'238'
,'239'
,'240'
,'241'
,'242'
,'243'
,'244'
,'245'
,'246'
,'247'
,'248'
,'249'
,'250'
,'251'
,'252'
,'253'
,'254'
,'255'
,'256'
,'257'
,'258'
,'259'
,'260'
,'261'
,'262'
,'263'
,'264'
,'265'
,'266'
,'267'
,'268'
,'269'
,'270'
,'271'
,'272'
,'273'
,'274'
,'275'
,'276'
,'277'
,'278'
,'279'
,'280'
,'281'
,'282'
,'283'
,'284'
,'285'
,'286'
,'287'
,'288'
,'289'
,'290'
,'291'
,'292'
,'293'
,'294'
,'295'
,'296'
,'297'
,'298'
,'299'
,'300'
,'301'
,'302'
,'303'
,'304'
,'305'
,'306'
,'307'
,'308'
,'309'
,'310'
,'311'
,'312'
,'313'
,'314'
,'315'
,'316'
,'317'
,'318'
,'319'
,'320'
,'321'
,'322'
,'323'
,'324'
,'325'
,'326'
,'327'
,'328'
,'329'
,'330'
,'331'
,'332'
,'333'
,'334'
,'335'
,'336'
,'337'
,'338'
,'339'
,'340'
,'341'
,'342'
,'343'
,'344'
,'345'
,'346'
,'347'
,'348'
,'349'
,'350'
,'351'
,'352'
,'353'
,'354'
,'355'
,'356'
,'357'
,'358'
,'359'
,'360'
,'361'
,'362'
,'363'
,'364'
,'365'
,'366'
,'367'
,'368'
,'369'
,'370'
,'371'
,'372'
,'373'
,'374'
,'375'
,'376'
,'377'
,'378'
,'379'
,'380'
,'381'
,'382'
,'383'
,'384'
,'385'
,'386'
,'387'
,'388'
,'389'
,'390'
,'391'
,'392'
,'393'
,'394'
,'395'
,'396'
,'397'
,'398'
,'399'
,'400'
,'401'
,'402'
,'403'
,'404'
,'405'
,'406'
,'407'
,'408'
,'409'
,'410'
,'411'
,'412'
,'413'
,'414'
,'415'
,'416'
,'417'
,'418'
,'419'
,'420'
,'421'
,'422'
,'423'
,'424'
,'425'
,'426'
,'427'
,'428'
,'429'
,'430'
,'431'
,'432'
,'433'
,'434'
,'435'
,'436'
,'437'
,'438'
,'439'
,'440'
,'441'
,'442'
,'443'
,'444'
,'445'
,'446'
,'447'
,'448'
,'449'
,'450'
,'451'
,'452'
,'453'
,'454'
,'455'
,'456'
,'457'
,'458'
,'459'
,'460'
,'461'
,'462'
,'463'
,'464'
,'465'
,'466'
,'467'
,'468'
,'469'
,'470'
,'471'
,'472'
,'473'
,'474'
,'475'
,'476'
,'477'
,'478'
,'479'
,'480'
,'481'
,'482'
,'483'
,'484'
,'485'
,'486'
,'487'
,'488'
,'489'
,'490'
,'491'
,'492'
,'493'
,'494'
,'495'
,'496'
,'497'
,'498'
,'499'
,'500'}" headerValue="Cantidad" onchange="Javascript:guarda('buscarProductosVenta')" /></td>
                                                <td style="background: #F0B823; color: black; text-align: center;"><s:textfield name="camp.INCREMENTO" id="INCREMENTO" cssClass="campoFormBusqueda" placeholder="Incremento" cssStyle="width: 30%;" onchange="Javascript:incremento('buscarProductosVenta')" ></s:textfield></td>
                                                
                                                    <td id="centrar-dato" style="background: green; color: white;"><div style="width: 100%; line-height: 1;">Total Producto</div><s:property value="camp.TOTAL_PRODUCTO_VENTA" /></td>
                                                <td id="centrar-dato"><s:if test="camp.NO_VENTA<1"><div onclick="hacer_click()"><a href="#popup"><img src="img/emitido.png"/></a></div></s:if></td>
                                            

                                            </tr>
                                     


                                        </table>
                                
                           
                               
                            
                                 </s:if>
                                
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
                              
                       
                            <s:if test="ListaCarroCotizacion.size()>0">
                            <div class="div_sec1">

                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Carrito de compras </h2></div>
                            
                            <s:if test="camp.NO_COTIZACION>0">
                                <s:if test="camp.NO_VENTA<1">
                                <div style="width: 130px; height: 25px; color: white; font-size: 12px; background: #333; text-align: center; float: right; margin-right: 50px; margin-bottom: 10px; border-radius: 10px;"> No. Cotización: <s:property value="camp.NO_COTIZACION"/></div>
                            </s:if>
                            <s:else>
                                  <div style="width: 130px; height: 25px; color: white; font-size: 12px; background: green; text-align: center; float: right; margin-right: 50px; margin-bottom: 10px; border-radius: 10px;"> No. Venta: <s:property value="camp.NO_VENTA"/></div>
                            </s:else>
                            </s:if>
                                  <div style="float: right; margin-right: 40px; background: green; border-radius: 50%; width: 25px; height: 25px; margin-bottom: 10px; text-align: center; color:white; font-size: 12px;  "><img src="img/carro.png" style="width: 30px; position: absolute; margin-left: -40px; margin-top: -5px;"></img> <s:property value="ListaCarroCotizacion.size()"></s:property></div>
                                       
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
                                            <th>NP</th>
                                            <th>No de Productos</th>
                                            <th>Parte</th>
                                            <th>Precio Unitario</th>
                                            
                                            <th>Total de la partida</th>
                                             <th>Eliminar</th>
                                            
                                            
                                        </thead>

                                            <s:iterator value="ListaCarroCotizacion" id="  ListaCarroCotizacion" status="stat" >
                                               
                                               
                                                
                                                <tr <s:if test="camp.CONSULTA_PARTE==NO_PARTE">style="background: #c79ac5; color: #333;"</s:if>>
                                                 
                                                    <td id="centrar-dato"><s:property value="#stat.count" /></td>    
                                                        <td id="centrar-dato"><s:property value="NO_PRODUCTOCOTIZA" /></td>
                                                        <td id="centrar-dato"> <s:property value="NO_PARTE" /> </td>
                                                <td id="centrar-dato"><s:property value="PRECIO_UNITARIO" /></td>
                                                
                                                <td id="centrar-dato" style="background: green; color:white;"><s:property value="PRECIO_FINAL" /></td>
                                                <td  id="centrar-dato">  <div class="img-pos-eliact" ><s:if test="camp.NO_VENTA<1"><a href="Javascript:borrarProducto('borrarProducto','<s:property value="ID_COTIZAPRODUCTO" />')" style="margin: auto;"><img src="img/iconEliminar.png" alt="Eliminar"></img></a></s:if></div></td>


                                            </tr>
                                          

                                        </s:iterator>

                                         <tr>
                                                  <td id="centrar-dato"> </td>
                                                <td id="centrar-dato"></td>
                                                <td id="centrar-dato"></td>
                                                  <td id="centrar-dato"></td>
                                                <td id="centrar-dato" style="background: purple; color:white; "><s:property value="camp.TOTAL_COTIZACION"  /></td>
                                                <td  id="centrar-dato"> </td>


                                            </tr>

                                        </table>
                                                
                                        </div>
                                 
                                                <div style="width: 200px; height: 25px; background: purple; color: white; float: right; margin-right: 120px; text-align: center; margin-top: 10px; font-size: 14px;">Total: <s:property value="camp.TOTAL_COTIZACION" /> MXN</div>
                                              
                                                <table  style="border-collapse: collapse; border: 1px solid white; width: 90%; margin: auto;">
                                                    <tr style="border-collapse: collapse; border: 1px solid white;">
                                                        <td id="centrar-dato">  <a href="#popup2"><div class="boton">  Guardar Cotización  </div> </a></td>
                                                        <td id="centrar-dato">   <s:if test="camp.NO_COTIZACION>0"> <s:if test="camp.NO_VENTA==''"><a href="#popup3"><div class="boton">  Generar Venta  </div> </a></s:if><s:else><div class="boton">  Generar Venta  </div>     </s:else> </s:if> </td>
                                                        <td id="centrar-dato">  <s:if test="camp.NO_COTIZACION>0"> <a href="Javascript:guarda('clientesBuscarVenta')"><div class="boton">  Generar Factura  </div> </a></s:if> </td>



                                                    </tr>
                                                    
                                                    <tr style="border-collapse: collapse; border: 1px solid white;">
                                                        <s:if test="camp.NO_COTIZACION>0">
                                                            
                                                        <td id="centrar-dato"> <s:if test="camp.NO_VENTA<1"> <a href="<s:property value="#myUrl" />" target="_blank"><img src="img/descarga.png" style="width: 50px; margin-top: 5px;"></img> </a></s:if></td>
                                                         </s:if>
                                                    <s:if test="camp.NO_VENTA>=1">
                                                        <td id="centrar-dato">  <a href="<s:property value="#myUrl2" />" target="_blank"><img src="img/descarga.png" style="width: 50px; margin-top: 5px;"></img> </a></td>
                                                         </s:if>
                                                        <td id="centrar-dato">   <a href="Javascript:guarda('clientesBuscarVenta')"></a></td>

                                                      </tr>
                                                   
                                                </table>
                                               

                                    </div>

                                </div>




                            </div>

                            </s:if>
                               <s:if test="ListaCotizaHist.size()>0">     
                                
                                   <div class="div_sec1" style="height: 200px;">

                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Historia de Cotización del Cliente/Producto </h2></div>
                            
                            
                            <div class="div_form_cliente">
                                <div id="scroltabla-cliente" style="height:50px;">
                                    <div class="contenedor-tab-hist-prog"  style="height:110px;">
                                        

                                    <table id="customers">
                                        <thead>
                                            <th>NP</th>
                                               
                                            <th>Cotización</th>
                                            <th>Parte</th>
                                            <th>Producto</th>
                                            <th>Precio Unitario</th>
                                            <th>No Productos</th>
                                             <th>Precio Final</th>
                                              <th>Responsable</th>
                                              <th>Fecha Cotiza</th>
                                            
                                        </thead>

                                            <s:iterator value="ListaCotizaHist" id="  ListaCotizaHist" status="stat" >
                                              <tr>
                                                   <td id="centrar-dato"><s:property value="#stat.count" /></td>    
                                                <td id="centrar-dato"><s:property value="NO_COTIZA" /></td>
                                                 <td id="centrar-dato"><s:property value="NO_PARTE" /></td>
                                                <td id="centrar-dato"><s:property value="PRODUCTO" /></td>
                                                <td id="centrar-dato"><s:property value="PRECIO_UNITARIO" /></td>
                                                <td id="centrar-dato"><s:property value="NO_PRODUCTOCOTIZA" /></td>
                                                <td  id="centrar-dato"> <s:property value="PRECIO_FINAL" /> </td>
                                                <td  id="centrar-dato" > <s:property value="RESPONSABLE" /> </td>
                                                 <td  id="centrar-dato" > <s:property value="FECHA_COTIZA" /> </td>
                                                


                                            </tr>
                                          

                                        </s:iterator>

                                        

                                        </table>
                                                
                                        </div>
                                 
                                                

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
                                
                   <div class="modal-wrapper" id="popup">
                    <div class="popup-contenedor">


                        <div style="width: 100; text-align: center;"> <h2 style="font-size: 18px; margin-top: 40px; margin-bottom: 30px;" >¿Desea agregar el producto a la venta?</h2></div>
                        
                        

                        <div style="width: 100%;"> <a href="Javascript:guardaValida('guardaProductoVenta')"><div style="width: 120px; height: 30px; background: green; color: white; text-align: center; font-size: 16px; margin: auto; border-radius: 8px;">OK</div></a></div>
                            
                        

                      
                        <a class="popup-cerrar" href="#">X</a>
                    </div>
                </div>   
                                
                                
                         <!--Mensaje guardar cotización -->       
                                
                        <div class="modal-wrapper" id="popup2">
                    <div class="popup2-contenedor">


                        <div style="width: 100; text-align: center;"> <h2 style="font-size: 18px; margin-top: 40px; margin-bottom: 30px;" >¿Desea guardar la cotización?</h2></div>
                        
                        

                        <div style="width: 100%;"> <a href="Javascript:guarda('generaCotizacion')"><div style="width: 120px; height: 30px; background: green; color: white; text-align: center; font-size: 16px; margin: auto; border-radius: 8px;">OK</div></a></div>
                            
                        

                      
                        <a class="popup2-cerrar" href="#">X</a>
                    </div>
                </div>            
                                
                        <!--Mensaje guardar venta -->       
                                
                        <div class="modal-wrapper" id="popup3">
                    <div class="popup3-contenedor">


                        <div style="width: 100; text-align: center;"> <h2 style="font-size: 18px; margin-top: 40px; margin-bottom: 30px;" >¿Desea generar la venta?</h2></div>
                        
                        

                        <div style="width: 100%;"> <a href="Javascript:guarda('generarVenta')" onclick="this.onclick=function(){return false}"><div style="width: 120px; height: 30px; background: green; color: white; text-align: center; font-size: 16px; margin: auto; border-radius: 8px;">OK</div></a></div>
                            
                        

                      
                        <a class="popup3-cerrar" href="#">X</a>
                    </div>
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
<s:textfield type="text" name="camp.AUX_RFC_CLIENTE" id="AUX_RFC_CLIENTE" style='visibility:hidden'   ></s:textfield>
<s:textfield type="text" name="camp.PRECIO_PESO" id="PRECIO_PESO" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.TOTAL_PRODUCTO_VENTA" id="TOTAL_PRODUCTO_VENTA" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.RFCCLIENTE" id="RFCCLIENTE" style='visibility:hidden'  ></s:textfield>
<s:textfield type="text" name="camp.AUXCOTIZA" id="AUXCOTIZA"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.NO_COTIZACION" id="NO_COTIZACION"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.BORRARPRODUCTO" id="BORRARPRODUCTO"  style='visibility:hidden' ></s:textfield>
<s:textfield type="text" name="camp.NO_VENTA" id="NO_VENTA" style='visibility:hidden'  ></s:textfield>
        </s:form>
                
                
                



    </body    














    <!-- menu principal -->

    <!--fin mp  -->	


    <!-- inicio de pagina -->




    <!-- INICIO------------------------------------------------------>








    <!--------------------------------------------->



</html>

