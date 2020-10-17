
<%@page import="beans.moduloBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <script type="text/javascript">

            function SeleccionMenu(accion){
                 if (accion == "accesoManual"){
                     document.formularioPrincipal.target="_blank";
                     document.formularioPrincipal.action = accion;
                     document.formularioPrincipal.submit();
                 }else {
                    document.formularioPrincipal.target="_self";
                    document.formularioPrincipal.action = accion;
                    document.formularioPrincipal.submit();
                 }
            }

        </script>
    </head>
    <body>
        <s:form name="formularioPrincipal" method="post" id="formularioPrincipal">
            <div id="menu" style="position: fixed; width: 100%; z-index: 1; margin-top: 60px;">
            <center>
                <ul class="menuTemplate1 decor1_1" >
                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                        <s:if test='CVE_MODPADRE=="S"'>
                            <li>
                                <a href="#Horizontal-Menus" class="arrow">
                                    <s:property value="DESC_MOD"/>
                                </a>
                                <div class="drop decor1_2" style="width: 400px;"> <%--380--%>
                                    <div class='left'>
                                        <div>
                                            <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">
                                                <s:if test='CVE_MODULO==MODPADRE'>
                                                    <a href="Javascript:SeleccionMenu('<s:property value="ACCION"/>')">
                                                        <s:property value="MOD"/>
                                                        <s:set var="myVar">
                                                            <s:property value="MOD.length()" />
                                                        </s:set>
                                                        <s:if test='MOD.length()<40'>
                                                            <c:forEach begin="${myVar}" end="40" varStatus="lp">
                                                                &nbsp;
                                                            </c:forEach>
                                                        </s:if>                                                        
                                                    </a>
                                                    <br/>
                                                </s:if>
                                            </s:iterator>
                                        </div>
                                    </div>
                                    <div class='left' style="text-align:right; width: 180px;"> <%--200--%>
                                        <s:url value="%{IMAGEN}" var="urlTag"/>
                                        <img align="middle" src="<s:property value="#urlTag"/>"/>
                                        
                                    </div>
                                    <div style='clear: both;'></div>
                                </div>
                            </li>
                        </s:if>
                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                        <%-- <s:hidden  name = "modulosAUX[%{#stat.index}].ACTION" id="ACTION"></s:hidden> --%>
                        <s:hidden name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].NAMEUNIDAD" id="NAMEUNIDAD"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].VALORU" id="VALORU"></s:hidden>
                        
                        
                    </s:iterator>
                </ul>                    
            </center>
        </div>
       
                <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
                    <s:hidden name =  "modulosAUXP[%{#stat.index}].CVE_ACCESO_AUX" id="CVE_ACCESO_AUX"></s:hidden>
                </s:iterator>
           
        </s:form>
    </body>
</html>