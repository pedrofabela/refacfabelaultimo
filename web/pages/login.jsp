<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">


<script type="text/javascript">

    function guarda(accion) {
         var usr = document.getElementById("pasusuario").value;
          var pas = document.getElementById("pasusuario").value;
          
          if(usr="" || pas ==""){
              
              alert("Campos obligatorios, favor de introducirlos")
              
          }
          
          else {
               document.forma.action = accion;
        document.forma.submit();
          }

       
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








<link href="css/style.css" rel="stylesheet" type="text/css" />



    <head>
        <title>Refacciones Fabela</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body >

        <s:form name="forma" action="Acceso">
            
            <header id="main-header">

            <h1  class="logo">Refacciones Fabela</h1>

              
               
            </header><!-- / #main-header -->
            
            <hr class="hr-inicio">


            
            
            <section id="main-content-principal" >
                   
                     
                     	
            <div class="div-contenido_gral" >  

                    <article class="articulo1" >





                        <div class="div_sec1">
                            
                              <img src="img/maquina-busqueda.jpg" alt="Maquina" style="width: 90%; margin-top: 20px; margin-bottom: 20px;" ></img>



                        </div>

                    </article> 

                    <article class="articulo2">





                        <div class="div_sec1">
                            <div class="div_titulos_sec"> <h2 class="text-tit-sec">Ingreso al sistema</h2></div>
 
 <div class="div_form_cliente">
                            
                                            <s:actionmessage cssStyle="text-align:center;font-size: 8pt" />

                                        <s:textfield cssClass="campoFormlogin" name="cveusuario" id="cveusuario"  required="true" placeholder="Usuario"  />
                                        
                                        <s:password cssClass="campoFormlogin" name="pasusuario" id="pasusuario" required="true" placeholder="Contraseña" />
                                        
                                      
                                        <a href="Javascript:guarda('verAcceso')"><div class="boton">  Ingresar   </div> </a>
                                        
                                        <div style="margin: auto; margin-top: 15px; width: 100%; text-align: center;">  <s:fielderror fieldName="NO" cssStyle="text-aling:center; font-size:14px ; color: red; margin:auto;" /></div> 
                                            
                        </div>

                    </div>


                    

                        </div>


                         
                            
                            </div>

                           
                        </div>

                           


                    </article><!-- /article -->
</div>
                </section>
            
            
            
            
            
            

            <footer id="main-footer">
                <p>&copy; 2017 <a href="refaccionesfabela.com">Refacciones Fabela</a></p>
            </footer> <!-- / #main-footer -->
        </s:form>


    </body

</html>


























