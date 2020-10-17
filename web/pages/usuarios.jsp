<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
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
                            <div class="div-busqueda">
                                
                              <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>
                            </div>



                        </div>

                    </article> 

                    <article class="articulo2">





                        <div class="div_sec1">
 <s:if test="banCliente">
                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Registro de Usuarios</h2></div>
                            </s:if>
                             <s:if test="banClienteActualiza">
                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Actualización de Usuarios</h2></div>
                            </s:if>
                            <div class="div_form_cliente">
                            <s:textfield name="camp.USUARIO" id="camp.USUARIO" placeholder="Nombre de Usuario" required="true"  cssClass="campoForm" onKeyUp="this.value=this.value.toUpperCase();"/>
                            <s:fielderror fieldName="CampRequierers" cssClass="error" />  
                            <s:textfield name="camp.PASSWORD" id="camp.PASSWORD" placeholder="Contraseña" required="true" cssClass="campoForm" onKeyUp="this.value=this.value.toUpperCase();" />
                            <s:fielderror fieldName="CampRequiererfc" cssClass="error" />  
                            
                            <s:select  cssClass="campoFormSelect" name="camp.NAMEPERFIL" id="camp.NAMEPERFIL" list="{'Administrador','Ventas','Almacen','Compras','Cajas'}" headerValue="Seleccione un Perfil" />
                            <s:fielderror fieldName="CampRequierenom" cssClass="error" />
                            
                           
                            <s:if test="banCliente">
                            <a href="Javascript:guarda('usuariosGuardar')"><div class="boton">  Ingresar   </div> </a>
                            </s:if>
                             <s:if test="banClienteActualiza">
                            <a href="Javascript:guarda('actualizacliente')"><div class="boton">  Actualizar   </div> </a>
                            </s:if>

                        </div>




                    </div>


                    <div class="div_sec1">


                        <div class="div_form_cliente">
                            <div id="scroltabla-cliente">
                            <table id="customers">
                                <thead>
                                    <th>NP</th>
                                    <th>Usuario</th>
                                    <th>Contraseña</th>
                                    <th>Perfil</th>
                                    
                                     <th>Eliminar</th>
                                </thead>
                                
                                <s:iterator value="Listausuarios" id="Listausuarios" status="stat" >
                                <tr>
                                    <td id="centrar-dato"><s:property value="#stat.count" /></td>
                                    <td><s:property value="USUARIO" /></td>
                                    <td><s:property value="PASSWORD" /></td>
                                    <td><s:property value="NAMEPERFIL" /></td>
                                   
                                    <td style="min-width: 50px; max-width: 50px;">  <div class="img-pos-eliact" ><a href="Javascript:actualiza('usuariosBorrar','<s:property value="USUARIO" />')"><img src="img/iconEliminar.png" alt="Eliminar"></img></a></div></td>
                                    
                                    
                                </tr>

                                </s:iterator>
            <s:textfield type="text" name="camp.RFCAUX" id="RFCAUX" style='visibility:hidden'  ></s:textfield> 
           
           

                            </table>

</div>

                        </div>


                         
                            
                            </div>

                           
                        </div>

                           


                    </article><!-- /article -->
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
                 <s:iterator value="ListaClientes" id="ListaClientes" status="stat">                        
                <s:hidden  name = "ListaClientes[%{#stat.index}].RFC_CLIENT" id="RFC_CLIENT"></s:hidden>
                <s:hidden  name = "ListaClientes[%{#stat.index}].NOMBRE_CLIENT" id="NOMBRE_CLIENT"></s:hidden>
                <s:hidden  name = "ListaClientes[%{#stat.index}].EMPRESA" id="EMPRESA"></s:hidden>
               
            </s:iterator>
                
                
            </s:form>


    </body    

</html>

