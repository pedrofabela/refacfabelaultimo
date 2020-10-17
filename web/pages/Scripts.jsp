<%-- 
    Document   : Scripts
    Created on : 23/03/2017, 01:49:33 PM
    Author     : GIOVANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <script type="text/javascript">

            function guarda(accion) {

                document.altaPetiForm.action = accion;
                document.altaPetiForm.submit();
            }

            function guarda1(accion) {
                var respuesta = confirm("¿Esta seguro que desea guardar los datos?")
                if (respuesta == true) {
                    document.altaPetiForm.action = accion;
                    document.altaPetiForm.target = "_self";
                    document.altaPetiForm.submit();
                }

            }

            function Actualizar(accion) {
                var respuesta = confirm("¿Esta seguro que desea Actualizar los datos?")
                if (respuesta == true) {
                    document.altaPetiForm.action = accion;
                    document.altaPetiForm.target = "_self";
                    document.altaPetiForm.submit();
                }

            }

            function eliminaraccion(accion, valor) {
                var respuesta = confirm("¿Esta seguro que desea eliminar el registro?")
                if (respuesta == true) {
                    document.altaPetiForm.ESP.value = valor;
                    document.altaPetiForm.action = accion;
                    document.altaPetiForm.target = "_self";
                    document.altaPetiForm.submit();
                }

            }
            
            function Salir(accion) {
                var respuesta = confirm("No olvide guardar su contraseña y número de folio ¿Desea salir?")
                if (respuesta == true) {
                    document.altaPetiForm.action = accion;
                    document.altaPetiForm.target = "_self";
                    document.altaPetiForm.submit();
                }

            }

            //Función que permite solo Números
            function ValidaSoloNumeros() {
                if ((event.keyCode < 48) || (event.keyCode > 57))
                    event.returnValue = false;
            }
            
            function ValidasoloLetras(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toString();
                letras = " áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
                especiales = [8, 37, 39, 46,32,6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }

                if (letras.indexOf(tecla) == -1 && !tecla_especial) {
                    //alert('Tecla no aceptada');
                    return false;
                }
            }

            });

            
            
           
            
            

        </script>
