/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author pedro
 */
public class camposConBean {

    private String RAZONSOCIAL;
    private String RFC_CLIENTE;
    private String NOMBRE_CLIENTE;
    private String DIRECCION_CLIENTE;
    private String TELEFONO_CLIENTE;
    private String EMPRESA_CLIENTE;
    private String CORREO_CLIENTE;
    private String RESPONSABLE;
    private String BUSCARPROVEEDOR;
    private String RFCAUX;
    private String BUSCARCLIENTE;

    // CAMPOS DE COMPRAS
    private String CONSULTA_PARTE;
    private String NO_PARTE;
    private String PRODUCTO;
    private String CATEGORIA;
    private String DESCRIPCION;
    private String PRECIO;
    private String GANANCIA;
    private String PRECIO_PESO;
    private String MARCA;
    private String UNIDADMEDIDA;
    private String MONEDA;
    private String ALTERNATIVO;
    private String PRECIO_CAL;
    private String TOTAL_BODEGAS;
    private String PROVEEDOR;
    private String CATEGORIA_GENERAL;
    private String SIMULADOR_PRECIO;
    private String PARTEAUX;
    private String FECHA_ACTUALIZA;
    private String MAX_PRODUCT;
    private String MAX_PEDIDO;
    private String MAX_AUXPEDIDO;
    private String ID_PRODUCT;
    private String ID_PEDIDO;
    private String AUXPEDIDO;
    private String CANTIDAD;
    private String FECHA_PEDIDO;
    private String FECHA_LLEGADA;
    private String ESTATUS_PEDIDO;
    private String CANTIDAD_LLEGADA;
    private String CONSULTA_PEDIDO;
    private String ANAQUEL;
    private String NIVEL;
    private String BODEGA;
    private String CANTIDAD_VENTA;
    private String TOTAL_PRODUCTO_VENTA;
    private String AUX_RFC_CLIENTE;
    private String RFCCLIENTE;     
    private String ID_COTIZAPRODUCTO;
    private String NO_COTIZA;
    private String PRECIO_UNITARIO;
    private String NO_PRODUCTOCOTIZA;
    private String PRECIO_FINAL;
    private String STATUS_COTIZA;
    private String FECHA_COTIZA;
    private String AUXVENTA;
    private String AUXCOTIZA;
    private String TOTAL_COTIZACION;
    private String NO_COTIZACION;
    private String BORRARPRODUCTO;
    
     private String ID_VENTA_PRODUCTO;
private String NO_VENTA;
private String NO_PARTE_VENTA;
private String PRECIO_UNITARIO_VENTA;
private String NO_PRODUCTOVENTA;
private String PRECIO_FINAL_VENTA;
private String RFC_CLIENTE_VENTA;
private String STATUS_VENTA;
private String VENDEDOR;
private String FECHA_VENTA ; 
private String NUEVOSTOK;
private String CANTIDAD_TRAER;

private String UBICACION;

private String ESTADO_VENTA;

private String FECHA_CONSULTA;
private String FECHA_INICIO;
private String FECHA_FINAL;

private String ID_ALTERNATIVO;
private String AUX_ALTERNATIVO;
private String NO_ALTERNATIVOS;

private String TOTAL_VENTA_DETALLE;

private String ENTREGA;

private String IVA;
private String DOLAR;

private String AGREGAR;
private String NAME_BODEGA;

private String ACTIVA_VENTA;
private String BODEGA_AUXILIAR;
private String TOTAL_PRODUCTO_BODEGAS;
private String CATIDAD;

private String ID_PRODUCTO_BORRAR;
private String CVE_SAT;

private float INCREMENTO;



    public String getCVE_SAT() {
        return CVE_SAT;
    }

    public void setCVE_SAT(String CVE_SAT) {
        this.CVE_SAT = CVE_SAT;
    }



    public float getINCREMENTO() {
        return INCREMENTO;
    }

    public void setINCREMENTO(float INCREMENTO) {
        this.INCREMENTO = INCREMENTO;
    }



    public String getID_PRODUCTO_BORRAR() {
        return ID_PRODUCTO_BORRAR;
    }

    public void setID_PRODUCTO_BORRAR(String ID_PRODUCTO_BORRAR) {
        this.ID_PRODUCTO_BORRAR = ID_PRODUCTO_BORRAR;
    }





    public String getCATIDAD() {
        return CATIDAD;
    }

    public void setCATIDAD(String CATIDAD) {
        this.CATIDAD = CATIDAD;
    }





    public String getTOTAL_PRODUCTO_BODEGAS() {
        return TOTAL_PRODUCTO_BODEGAS;
    }

    public void setTOTAL_PRODUCTO_BODEGAS(String TOTAL_PRODUCTO_BODEGAS) {
        this.TOTAL_PRODUCTO_BODEGAS = TOTAL_PRODUCTO_BODEGAS;
    }



    public String getBODEGA_AUXILIAR() {
        return BODEGA_AUXILIAR;
    }

    public void setBODEGA_AUXILIAR(String BODEGA_AUXILIAR) {
        this.BODEGA_AUXILIAR = BODEGA_AUXILIAR;
    }




    public String getACTIVA_VENTA() {
        return ACTIVA_VENTA;
    }

    public void setACTIVA_VENTA(String ACTIVA_VENTA) {
        this.ACTIVA_VENTA = ACTIVA_VENTA;
    }




    public String getNAME_BODEGA() {
        return NAME_BODEGA;
    }

    public void setNAME_BODEGA(String NAME_BODEGA) {
        this.NAME_BODEGA = NAME_BODEGA;
    }



    public String getAGREGAR() {
        return AGREGAR;
    }

    public void setAGREGAR(String AGREGAR) {
        this.AGREGAR = AGREGAR;
    }



    public String getDOLAR() {
        return DOLAR;
    }

    public void setDOLAR(String DOLAR) {
        this.DOLAR = DOLAR;
    }



    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }



    public String getENTREGA() {
        return ENTREGA;
    }

    public void setENTREGA(String ENTREGA) {
        this.ENTREGA = ENTREGA;
    }



    public String getTOTAL_VENTA_DETALLE() {
        return TOTAL_VENTA_DETALLE;
    }

    public void setTOTAL_VENTA_DETALLE(String TOTAL_VENTA_DETALLE) {
        this.TOTAL_VENTA_DETALLE = TOTAL_VENTA_DETALLE;
    }



    public String getNO_ALTERNATIVOS() {
        return NO_ALTERNATIVOS;
    }

    public void setNO_ALTERNATIVOS(String NO_ALTERNATIVOS) {
        this.NO_ALTERNATIVOS = NO_ALTERNATIVOS;
    }



    public String getAUX_ALTERNATIVO() {
        return AUX_ALTERNATIVO;
    }

    public void setAUX_ALTERNATIVO(String AUX_ALTERNATIVO) {
        this.AUX_ALTERNATIVO = AUX_ALTERNATIVO;
    }




    public String getID_ALTERNATIVO() {
        return ID_ALTERNATIVO;
    }

    public void setID_ALTERNATIVO(String ID_ALTERNATIVO) {
        this.ID_ALTERNATIVO = ID_ALTERNATIVO;
    }




    public String getFECHA_CONSULTA() {
        return FECHA_CONSULTA;
    }

    public void setFECHA_CONSULTA(String FECHA_CONSULTA) {
        this.FECHA_CONSULTA = FECHA_CONSULTA;
    }

    public String getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public void setFECHA_INICIO(String FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public String getFECHA_FINAL() {
        return FECHA_FINAL;
    }

    public void setFECHA_FINAL(String FECHA_FINAL) {
        this.FECHA_FINAL = FECHA_FINAL;
    }




    public String getESTADO_VENTA() {
        return ESTADO_VENTA;
    }

    public void setESTADO_VENTA(String ESTADO_VENTA) {
        this.ESTADO_VENTA = ESTADO_VENTA;
    }



    public String getUBICACION() {
        return UBICACION;
    }

    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }







    public String getCANTIDAD_TRAER() {
        return CANTIDAD_TRAER;
    }

    public void setCANTIDAD_TRAER(String CANTIDAD_TRAER) {
        this.CANTIDAD_TRAER = CANTIDAD_TRAER;
    }



    public String getNUEVOSTOK() {
        return NUEVOSTOK;
    }

    public void setNUEVOSTOK(String NUEVOSTOK) {
        this.NUEVOSTOK = NUEVOSTOK;
    }



    public String getID_VENTA_PRODUCTO() {
        return ID_VENTA_PRODUCTO;
    }

    public void setID_VENTA_PRODUCTO(String ID_VENTA_PRODUCTO) {
        this.ID_VENTA_PRODUCTO = ID_VENTA_PRODUCTO;
    }

    public String getNO_VENTA() {
        return NO_VENTA;
    }

    public void setNO_VENTA(String NO_VENTA) {
        this.NO_VENTA = NO_VENTA;
    }

    public String getNO_PARTE_VENTA() {
        return NO_PARTE_VENTA;
    }

    public void setNO_PARTE_VENTA(String NO_PARTE_VENTA) {
        this.NO_PARTE_VENTA = NO_PARTE_VENTA;
    }

    public String getPRECIO_UNITARIO_VENTA() {
        return PRECIO_UNITARIO_VENTA;
    }

    public void setPRECIO_UNITARIO_VENTA(String PRECIO_UNITARIO_VENTA) {
        this.PRECIO_UNITARIO_VENTA = PRECIO_UNITARIO_VENTA;
    }

    public String getNO_PRODUCTOVENTA() {
        return NO_PRODUCTOVENTA;
    }

    public void setNO_PRODUCTOVENTA(String NO_PRODUCTOVENTA) {
        this.NO_PRODUCTOVENTA = NO_PRODUCTOVENTA;
    }

    public String getPRECIO_FINAL_VENTA() {
        return PRECIO_FINAL_VENTA;
    }

    public void setPRECIO_FINAL_VENTA(String PRECIO_FINAL_VENTA) {
        this.PRECIO_FINAL_VENTA = PRECIO_FINAL_VENTA;
    }

    public String getRFC_CLIENTE_VENTA() {
        return RFC_CLIENTE_VENTA;
    }

    public void setRFC_CLIENTE_VENTA(String RFC_CLIENTE_VENTA) {
        this.RFC_CLIENTE_VENTA = RFC_CLIENTE_VENTA;
    }

    public String getSTATUS_VENTA() {
        return STATUS_VENTA;
    }

    public void setSTATUS_VENTA(String STATUS_VENTA) {
        this.STATUS_VENTA = STATUS_VENTA;
    }

    public String getVENDEDOR() {
        return VENDEDOR;
    }

    public void setVENDEDOR(String VENDEDOR) {
        this.VENDEDOR = VENDEDOR;
    }

    public String getFECHA_VENTA() {
        return FECHA_VENTA;
    }

    public void setFECHA_VENTA(String FECHA_VENTA) {
        this.FECHA_VENTA = FECHA_VENTA;
    }
      
      

    public String getBORRARPRODUCTO() {
        return BORRARPRODUCTO;
    }

    public void setBORRARPRODUCTO(String BORRARPRODUCTO) {
        this.BORRARPRODUCTO = BORRARPRODUCTO;
    }

    public String getNO_COTIZACION() {
        return NO_COTIZACION;
    }

    public void setNO_COTIZACION(String NO_COTIZACION) {
        this.NO_COTIZACION = NO_COTIZACION;
    }

    public String getTOTAL_COTIZACION() {
        return TOTAL_COTIZACION;
    }

    public void setTOTAL_COTIZACION(String TOTAL_COTIZACION) {
        this.TOTAL_COTIZACION = TOTAL_COTIZACION;
    }
     
     

    public String getAUXCOTIZA() {
        return AUXCOTIZA;
    }

    public void setAUXCOTIZA(String AUXCOTIZA) {
        this.AUXCOTIZA = AUXCOTIZA;
    }
    

     
     
     
     
    public String getAUXVENTA() {
        return AUXVENTA;
    }

    public void setAUXVENTA(String AUXVENTA) {
        this.AUXVENTA = AUXVENTA;
    }
    
    

    
    public String getID_COTIZAPRODUCTO() {
        return ID_COTIZAPRODUCTO;
    }

    public void setID_COTIZAPRODUCTO(String ID_COTIZAPRODUCTO) {
        this.ID_COTIZAPRODUCTO = ID_COTIZAPRODUCTO;
    }

    public String getNO_COTIZA() {
        return NO_COTIZA;
    }

    public void setNO_COTIZA(String NO_COTIZA) {
        this.NO_COTIZA = NO_COTIZA;
    }

    public String getPRECIO_UNITARIO() {
        return PRECIO_UNITARIO;
    }

    public void setPRECIO_UNITARIO(String PRECIO_UNITARIO) {
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
    }

    public String getNO_PRODUCTOCOTIZA() {
        return NO_PRODUCTOCOTIZA;
    }

    public void setNO_PRODUCTOCOTIZA(String NO_PRODUCTOCOTIZA) {
        this.NO_PRODUCTOCOTIZA = NO_PRODUCTOCOTIZA;
    }

    public String getPRECIO_FINAL() {
        return PRECIO_FINAL;
    }

    public void setPRECIO_FINAL(String PRECIO_FINAL) {
        this.PRECIO_FINAL = PRECIO_FINAL;
    }

    public String getSTATUS_COTIZA() {
        return STATUS_COTIZA;
    }

    public void setSTATUS_COTIZA(String STATUS_COTIZA) {
        this.STATUS_COTIZA = STATUS_COTIZA;
    }

    public String getFECHA_COTIZA() {
        return FECHA_COTIZA;
    }

    public void setFECHA_COTIZA(String FECHA_COTIZA) {
        this.FECHA_COTIZA = FECHA_COTIZA;
    }
    
    
    

    public String getRFCCLIENTE() {
        return RFCCLIENTE;
    }

    public void setRFCCLIENTE(String RFCCLIENTE) {
        this.RFCCLIENTE = RFCCLIENTE;
    }

    public String getAUX_RFC_CLIENTE() {
        return AUX_RFC_CLIENTE;
    }

    public void setAUX_RFC_CLIENTE(String AUX_RFC_CLIENTE) {
        this.AUX_RFC_CLIENTE = AUX_RFC_CLIENTE;
    }
      

    public String getTOTAL_PRODUCTO_VENTA() {
        return TOTAL_PRODUCTO_VENTA;
    }

    public void setTOTAL_PRODUCTO_VENTA(String TOTAL_PRODUCTO_VENTA) {
        this.TOTAL_PRODUCTO_VENTA = TOTAL_PRODUCTO_VENTA;
    }

   
      

    public String getCANTIDAD_VENTA() {
        return CANTIDAD_VENTA;
    }

    public void setCANTIDAD_VENTA(String CANTIDAD_VENTA) {
        this.CANTIDAD_VENTA = CANTIDAD_VENTA;
    }
    
    

    public String getBODEGA() {
        return BODEGA;
    }

    public void setBODEGA(String BODEGA) {
        this.BODEGA = BODEGA;
    }
    
    

    public String getANAQUEL() {
        return ANAQUEL;
    }

    public void setANAQUEL(String ANAQUEL) {
        this.ANAQUEL = ANAQUEL;
    }

    public String getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(String NIVEL) {
        this.NIVEL = NIVEL;
    }

    
    
    public String getCONSULTA_PEDIDO() {
        return CONSULTA_PEDIDO;
    }

    public void setCONSULTA_PEDIDO(String CONSULTA_PEDIDO) {
        this.CONSULTA_PEDIDO = CONSULTA_PEDIDO;
    }
    
    
    public String getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(String ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public String getAUXPEDIDO() {
        return AUXPEDIDO;
    }

    public void setAUXPEDIDO(String AUXPEDIDO) {
        this.AUXPEDIDO = AUXPEDIDO;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getFECHA_PEDIDO() {
        return FECHA_PEDIDO;
    }

    public void setFECHA_PEDIDO(String FECHA_PEDIDO) {
        this.FECHA_PEDIDO = FECHA_PEDIDO;
    }

    public String getFECHA_LLEGADA() {
        return FECHA_LLEGADA;
    }

    public void setFECHA_LLEGADA(String FECHA_LLEGADA) {
        this.FECHA_LLEGADA = FECHA_LLEGADA;
    }

    public String getESTATUS_PEDIDO() {
        return ESTATUS_PEDIDO;
    }

    public void setESTATUS_PEDIDO(String ESTATUS_PEDIDO) {
        this.ESTATUS_PEDIDO = ESTATUS_PEDIDO;
    }

    public String getCANTIDAD_LLEGADA() {
        return CANTIDAD_LLEGADA;
    }

    public void setCANTIDAD_LLEGADA(String CANTIDAD_LLEGADA) {
        this.CANTIDAD_LLEGADA = CANTIDAD_LLEGADA;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    private String NO_PRODUCTOS_PEDIDOS;

    public String getNO_PRODUCTOS_PEDIDOS() {
        return NO_PRODUCTOS_PEDIDOS;
    }

    public void setNO_PRODUCTOS_PEDIDOS(String NO_PRODUCTOS_PEDIDOS) {
        this.NO_PRODUCTOS_PEDIDOS = NO_PRODUCTOS_PEDIDOS;
    }
    

    public String getID_PRODUCT() {
        return ID_PRODUCT;
    }

    public void setID_PRODUCT(String ID_PRODUCT) {
        this.ID_PRODUCT = ID_PRODUCT;
    }
    
    
    
    
    
    public String getMAX_PRODUCT() {
        return MAX_PRODUCT;
    }

    public void setMAX_PRODUCT(String MAX_PRODUCT) {
        this.MAX_PRODUCT = MAX_PRODUCT;
    }

    public String getMAX_PEDIDO() {
        return MAX_PEDIDO;
    }

    public void setMAX_PEDIDO(String MAX_PEDIDO) {
        this.MAX_PEDIDO = MAX_PEDIDO;
    }

    public String getMAX_AUXPEDIDO() {
        return MAX_AUXPEDIDO;
    }

    public void setMAX_AUXPEDIDO(String MAX_AUXPEDIDO) {
        this.MAX_AUXPEDIDO = MAX_AUXPEDIDO;
    }
   
    
    
    
    

    public String getFECHA_ACTUALIZA() {
        return FECHA_ACTUALIZA;
    }

    public void setFECHA_ACTUALIZA(String FECHA_ACTUALIZA) {
        this.FECHA_ACTUALIZA = FECHA_ACTUALIZA;
    }
    
    

    public String getPARTEAUX() {
        return PARTEAUX;
    }

    public void setPARTEAUX(String PARTEAUX) {
        this.PARTEAUX = PARTEAUX;
    }
    
    

    public String getSIMULADOR_PRECIO() {
        return SIMULADOR_PRECIO;
    }

    public void setSIMULADOR_PRECIO(String SIMULADOR_PRECIO) {
        this.SIMULADOR_PRECIO = SIMULADOR_PRECIO;
    }
    
    
    
    

    public String getNO_PARTE() {
        return NO_PARTE;
    }

    public void setNO_PARTE(String NO_PARTE) {
        this.NO_PARTE = NO_PARTE;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(String PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getGANANCIA() {
        return GANANCIA;
    }

    public void setGANANCIA(String GANANCIA) {
        this.GANANCIA = GANANCIA;
    }

    public String getPRECIO_PESO() {
        return PRECIO_PESO;
    }

    public void setPRECIO_PESO(String PRECIO_PESO) {
        this.PRECIO_PESO = PRECIO_PESO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getUNIDADMEDIDA() {
        return UNIDADMEDIDA;
    }

    public void setUNIDADMEDIDA(String UNIDADMEDIDA) {
        this.UNIDADMEDIDA = UNIDADMEDIDA;
    }

    public String getMONEDA() {
        return MONEDA;
    }

    public void setMONEDA(String MONEDA) {
        this.MONEDA = MONEDA;
    }

    public String getALTERNATIVO() {
        return ALTERNATIVO;
    }

    public void setALTERNATIVO(String ALTERNATIVO) {
        this.ALTERNATIVO = ALTERNATIVO;
    }

    public String getPRECIO_CAL() {
        return PRECIO_CAL;
    }

    public void setPRECIO_CAL(String PRECIO_CAL) {
        this.PRECIO_CAL = PRECIO_CAL;
    }

    public String getTOTAL_BODEGAS() {
        return TOTAL_BODEGAS;
    }

    public void setTOTAL_BODEGAS(String TOTAL_BODEGAS) {
        this.TOTAL_BODEGAS = TOTAL_BODEGAS;
    }

    public String getPROVEEDOR() {
        return PROVEEDOR;
    }

    public void setPROVEEDOR(String PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    public String getCATEGORIA_GENERAL() {
        return CATEGORIA_GENERAL;
    }

    public void setCATEGORIA_GENERAL(String CATEGORIA_GENERAL) {
        this.CATEGORIA_GENERAL = CATEGORIA_GENERAL;
    }

    public String getCONSULTA_PARTE() {
        return CONSULTA_PARTE;
    }

    public void setCONSULTA_PARTE(String CONSULTA_PARTE) {
        this.CONSULTA_PARTE = CONSULTA_PARTE;
    }

    private String RAZONSOCIAL_PROV;
    private String RFC_PROV;
    private String NOMBRE_PROV;
    private String DIRECCION_PROV;
    private String TELEFONO_PROV;
    private String EMPRESA_PROV;
    private String CORREO_PROV;

    private String USUARIO;
    private String PASSWORD;
    private String PERFIL;
    private String NAMEUSUARIO;
    private String NAMEPERFIL;

    public String getNAMEPERFIL() {
        return NAMEPERFIL;
    }

    public void setNAMEPERFIL(String NAMEPERFIL) {
        this.NAMEPERFIL = NAMEPERFIL;
    }

    public String getNAMEUSUARIO() {
        return NAMEUSUARIO;
    }

    public void setNAMEUSUARIO(String NAMEUSUARIO) {
        this.NAMEUSUARIO = NAMEUSUARIO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getPERFIL() {
        return PERFIL;
    }

    public void setPERFIL(String PERFIL) {
        this.PERFIL = PERFIL;
    }

    public String getRAZONSOCIAL_PROV() {
        return RAZONSOCIAL_PROV;
    }

    public void setRAZONSOCIAL_PROV(String RAZONSOCIAL_PROV) {
        this.RAZONSOCIAL_PROV = RAZONSOCIAL_PROV;
    }

    public String getRFC_PROV() {
        return RFC_PROV;
    }

    public void setRFC_PROV(String RFC_PROV) {
        this.RFC_PROV = RFC_PROV;
    }

    public String getNOMBRE_PROV() {
        return NOMBRE_PROV;
    }

    public void setNOMBRE_PROV(String NOMBRE_PROV) {
        this.NOMBRE_PROV = NOMBRE_PROV;
    }

    public String getDIRECCION_PROV() {
        return DIRECCION_PROV;
    }

    public void setDIRECCION_PROV(String DIRECCION_PROV) {
        this.DIRECCION_PROV = DIRECCION_PROV;
    }

    public String getTELEFONO_PROV() {
        return TELEFONO_PROV;
    }

    public void setTELEFONO_PROV(String TELEFONO_PROV) {
        this.TELEFONO_PROV = TELEFONO_PROV;
    }

    public String getEMPRESA_PROV() {
        return EMPRESA_PROV;
    }

    public void setEMPRESA_PROV(String EMPRESA_PROV) {
        this.EMPRESA_PROV = EMPRESA_PROV;
    }

    public String getCORREO_PROV() {
        return CORREO_PROV;
    }

    public void setCORREO_PROV(String CORREO_PROV) {
        this.CORREO_PROV = CORREO_PROV;
    }

    public String getBUSCARPROVEEDOR() {
        return BUSCARPROVEEDOR;
    }

    public void setBUSCARPROVEEDOR(String BUSCARPROVEEDOR) {
        this.BUSCARPROVEEDOR = BUSCARPROVEEDOR;
    }

    public String getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setRESPONSABLE(String RESPONSABLE) {
        this.RESPONSABLE = RESPONSABLE;
    }

    public String getRFCAUX() {
        return RFCAUX;
    }

    public void setRFCAUX(String RFCAUX) {
        this.RFCAUX = RFCAUX;
    }

    public String getBUSCARCLIENTE() {
        return BUSCARCLIENTE;
    }

    public void setBUSCARCLIENTE(String BUSCARCLIENTE) {
        this.BUSCARCLIENTE = BUSCARCLIENTE;
    }

    public String getRAZONSOCIAL() {
        return RAZONSOCIAL;
    }

    public void setRAZONSOCIAL(String RAZONSOCIAL) {
        this.RAZONSOCIAL = RAZONSOCIAL;
    }

    public String getRFC_CLIENTE() {
        return RFC_CLIENTE;
    }

    public void setRFC_CLIENTE(String RFC_CLIENTE) {
        this.RFC_CLIENTE = RFC_CLIENTE;
    }

    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getDIRECCION_CLIENTE() {
        return DIRECCION_CLIENTE;
    }

    public void setDIRECCION_CLIENTE(String DIRECCION_CLIENTE) {
        this.DIRECCION_CLIENTE = DIRECCION_CLIENTE;
    }

    public String getTELEFONO_CLIENTE() {
        return TELEFONO_CLIENTE;
    }

    public void setTELEFONO_CLIENTE(String TELEFONO_CLIENTE) {
        this.TELEFONO_CLIENTE = TELEFONO_CLIENTE;
    }

    public String getEMPRESA_CLIENTE() {
        return EMPRESA_CLIENTE;
    }

    public void setEMPRESA_CLIENTE(String EMPRESA_CLIENTE) {
        this.EMPRESA_CLIENTE = EMPRESA_CLIENTE;
    }

    public String getCORREO_CLIENTE() {
        return CORREO_CLIENTE;
    }

    public void setCORREO_CLIENTE(String CORREO_CLIENTE) {
        this.CORREO_CLIENTE = CORREO_CLIENTE;
    }

}
