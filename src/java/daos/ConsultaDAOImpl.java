/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.camposConBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mappers.alternativosMapper;
import mappers.anaquelMapper;
import mappers.carroCotizaMapper;
import mappers.catSatMapper;
import mappers.categoriaGralMapper;
import mappers.categoriaMapper;
import mappers.clientesMapper;
import mappers.conVentaMapper;
import mappers.consultaVentaAlmacenMapper;
import mappers.consultaVentaMapper;
import mappers.contadoresPedidosMapper;
import mappers.cotizacionHist;
import mappers.gananciaMapper;
import mappers.historiaBodegasMapper;
import mappers.inventarioMapper;
import mappers.moduloMapper;
import mappers.nivelMapper;
import mappers.pedidos2Mapper;
import mappers.pedidosMapper;
import mappers.prodHistMapper;
import mappers.productoAltMapper;
import mappers.productosBodegaLikeMapper;
import mappers.productosBodegaMapper;
import mappers.productosGralMapper;
import mappers.productosPendientesMapper;
import mappers.proveedoresMapper;
import mappers.selectProveeMapper;
import mappers.stokVentaMapper;
import mappers.traerProductoMapper;
import mappers.usuarioMapper;
import mappers.valorLlegadaMapper;
import mappers.ventaDiaMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;

/**
 *
 * @author pedro
 */
public class ConsultaDAOImpl extends OracleDAOFactory implements ConsultaUsuarioDAO {

    OracleDAOFactory oraDaoFac = new OracleDAOFactory();

    public List clientesCon() throws Exception {
        String query = "SELECT RASON_CLIENT, RFC_CLIENT, NOMBRE_CLIENT, DIRECCION_CLIENT, TELEFONO_CLIET, CORREO_CLIENT, EMPRESA, RESP_REGISTRO FROM CLIENT   ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new clientesMapper());
        return list;
    }

    public List productosGral() throws Exception {
        String query = "SELECT NO_PARTE, PRODUCTO, CATEGORIA, DESCRIPCION, PRECIO, GANANCIA, PRECIO_PESO, MARCA, UNIDADMEDIDA, MONEDA, ALTERNATIVO, RESPONSABLE, PRECIO_CAL, TOTAL_BODEGAS, PROVEEDOR, CATEGORIA_GENERAL, FECHA_ACTUALIZA, CVE_SAT FROM FINAL_PRODUCTOS WHERE TOTAL_BODEGAS='0' ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosGralMapper());
        return list;
    }

    public List productosBuscar(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, ANAQUEL, NIVEL, CATIDAD, NAME_BODEGA FROM BODEGAS WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosBodegaMapper());
        return list;
    }
     public List catSat(camposConBean camp) throws Exception {
        String query = "SELECT   N_ID, CVE_SAT, DESCRIPCION FROM   CAT_CVESAT ORDER BY DESCRIPCION ASC ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new catSatMapper());
        return list;
    }
    public List productosBuscarLike(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, PRODUCTO, CATEGORIA, DESCRIPCION, MARCA, TOTAL_BODEGAS FROM FINAL_PRODUCTOS WHERE NO_PARTE LIKE '%"+camp.getCONSULTA_PARTE()+"%' OR PRODUCTO LIKE '%"+camp.getCONSULTA_PARTE()+"%' OR CATEGORIA LIKE '%"+camp.getCONSULTA_PARTE()+"%' OR DESCRIPCION LIKE '%"+camp.getCONSULTA_PARTE()+"%' OR MARCA LIKE '%"+camp.getCONSULTA_PARTE()+"%' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosBodegaLikeMapper());
        return list;
    }

    public List cotizaHist(camposConBean camp) throws Exception {
        String query = "SELECT COT.NO_COTIZA,COT.NO_PARTE, PROD.PRODUCTO, COT.PRECIO_UNITARIO, COT.NO_PRODUCTOCOTIZA, COT.PRECIO_FINAL, COT.RESPONSABLE, COT.FECHA_COTIZA FROM (SELECT NO_COTIZA, NO_PARTE, PRECIO_UNITARIO, NO_PRODUCTOCOTIZA, PRECIO_FINAL, RESPONSABLE, FECHA_COTIZA FROM COTIZACION WHERE RFC_CLIENTE='" + camp.getAUX_RFC_CLIENTE() + "' AND NO_PARTE='" + camp.getCONSULTA_PARTE() + "' AND NO_COTIZA IS NOT NULL) COT JOIN (SELECT NO_PARTE, PRODUCTO FROM PRODUCTOS)PROD ON COT.NO_PARTE=PROD.NO_PARTE ORDER BY FECHA_COTIZA DESC";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new cotizacionHist());
        return list;
    }

    public List productosBuscarVenta(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, ANAQUEL, NIVEL, NVL(CATIDAD,'0') AS CATIDAD, NAME_BODEGA FROM BODEGAS WHERE NO_PARTE='" + camp.getNO_PARTE_VENTA() + "' ";
        // System.out.println("CONSULTA BODEGAS%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ---> " + query);
        List list = null;
        list = queryForList(query, new productosBodegaMapper());
        return list;
    }

    public List carritoPedidos(camposConBean camp) throws Exception {
        String query = "SELECT * FROM PRODUCTOS_COMPRA WHERE AUXPEDIDO='" + camp.getMAX_AUXPEDIDO() + "' ORDER BY TO_NUMBER(ID_PRODUCT) ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new pedidosMapper());
        return list;
    }

    public List productosBuscarHist(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, PRODUCTO, MARCA, PRECIO, PRECIO_PESO, MONEDA, GANANCIA, PROVEEDOR,  FECHA_ACTUALIZA AS FECHAINGRESO FROM HISTORIA_INGRESO_PRODUCTO WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "' ORDER BY TO_DATE(FECHA_ACTUALIZA) DESC ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new prodHistMapper());
        return list;
    }

    public List carroCotizacion(camposConBean camp) throws Exception {
        String query = "SELECT ID_COTIZAPRODUCTO, NO_COTIZA, NO_PARTE,PRECIO_UNITARIO, NO_PRODUCTOCOTIZA, PRECIO_FINAL, RFC_CLIENTE, STATUS_COTIZA, RESPONSABLE, FECHA_COTIZA, AUXCOTIZA, NO_VENTA FROM COTIZACION WHERE AUXCOTIZA='" + camp.getAUXCOTIZA() + "' ORDER BY ID_COTIZAPRODUCTO";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new carroCotizaMapper());
        return list;
    }

    public List consultaVenta(camposConBean camp) throws Exception {
        String query = "SELECT NO_VENTA, NO_COTIZA FROM VENTA_PRODUCTOS WHERE NO_COTIZA='" + camp.getAUXCOTIZA() + "'";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new conVentaMapper());
        return list;
    }

    public List carroConCotizacion(camposConBean camp) throws Exception {
        String query = "SELECT ID_COTIZAPRODUCTO, NO_COTIZA, NO_PARTE,PRECIO_UNITARIO, NO_PRODUCTOCOTIZA, PRECIO_FINAL, RFC_CLIENTE, STATUS_COTIZA, RESPONSABLE, FECHA_COTIZA, AUXCOTIZA, NO_VENTA FROM COTIZACION WHERE NO_COTIZA='" + camp.getAUXCOTIZA() + "' ORDER BY ID_COTIZAPRODUCTO";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new carroCotizaMapper());
        return list;
    }

    public List ventaAlmacen(camposConBean camp) throws Exception {
        String query = "SELECT VEN.ID_VENTA_PRODUCTO,  VEN.NO_PARTE, VEN.PRODUCTO, VEN.DESCRIPCION, VEN.NO_PRODUCTOVENTA, VEN.ESTATUS_ENTREGA, LOC.ANAQUEL, LOC.NIVEL FROM (SELECT VENTA.NO_PARTE, PROD.PRODUCTO, PROD.DESCRIPCION, VENTA.NO_PRODUCTOVENTA, VENTA.ID_VENTA_PRODUCTO, VENTA.ESTATUS_ENTREGA FROM (SELECT NO_PARTE, PRODUCTO, DESCRIPCION FROM FINAL_PRODUCTOS)PROD JOIN (SELECT NO_VENTA, NO_PARTE, NO_PRODUCTOVENTA, ID_VENTA_PRODUCTO, ESTATUS_ENTREGA FROM VENTA_PRODUCTOS WHERE NO_VENTA='" + camp.getNO_VENTA() + "')VENTA ON PROD.NO_PARTE=VENTA.NO_PARTE)VEN JOIN (SELECT ANAQUEL, NIVEL, NO_PARTE FROM BODEGAS WHERE NAME_BODEGA='LOCAL')LOC ON VEN.NO_PARTE=LOC.NO_PARTE ORDER BY TO_NUMBER(ID_VENTA_PRODUCTO)";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new consultaVentaAlmacenMapper());
        return list;
    }

    public List ventaConsulta(camposConBean camp) throws Exception {
        String query = "SELECT COT.ID_VENTA_PRODUCTO, COT.NO_PARTE, PROD.PRODUCTO, COT.PRECIO_UNITARIO, COT.NO_PRODUCTOVENTA, COT.PRECIO_FINAL, COT.STATUS_VENTA FROM (SELECT * FROM VENTA_PRODUCTOS)COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE NO_VENTA='" + camp.getNO_VENTA() + "' ORDER BY ID_VENTA_PRODUCTO";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new consultaVentaMapper());
        return list;
    }

    public List ventaConsultaDia(camposConBean camp) throws Exception {
        String query = "SELECT COT.ID_VENTA_PRODUCTO, COT.NO_PARTE, PROD.PRODUCTO, COT.PRECIO_UNITARIO, COT.NO_PRODUCTOVENTA, COT.PRECIO_FINAL, COT.STATUS_VENTA FROM (SELECT * FROM VENTA_PRODUCTOS WHERE NO_VENTA='" + camp.getNO_VENTA() + "')COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE FECHA_VENTA='" + camp.getFECHA_CONSULTA() + "' AND STATUS_VENTA='2' ORDER BY ID_VENTA_PRODUCTO ";
        // System.out.println("consulta con fecha " + query);
        List list = null;
        list = queryForList(query, new consultaVentaMapper());
        return list;
    }

    public List ventaConsultaDiaFecha(camposConBean camp) throws Exception {
        String query = "SELECT COT.ID_VENTA_PRODUCTO, COT.NO_PARTE, PROD.PRODUCTO, COT.PRECIO_UNITARIO, COT.NO_PRODUCTOVENTA, COT.PRECIO_FINAL, COT.STATUS_VENTA FROM (SELECT * FROM VENTA_PRODUCTOS WHERE NO_VENTA='" + camp.getNO_VENTA() + "' AND TO_DATE(FECHA_VENTA)>='" + camp.getFECHA_INICIO() + "' AND TO_DATE(FECHA_VENTA)<='" + camp.getFECHA_FINAL() + "')COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE  STATUS_VENTA='2' ORDER BY ID_VENTA_PRODUCTO ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new consultaVentaMapper());
        return list;
    }

    public List ventaDia(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT (COT.NO_VENTA),  SUM(COT.NO_PRODUCTOVENTA) AS NO_PRODUCTOVENTA, SUM(COT.PRECIO_FINAL) AS PRECIO_FINAL FROM (SELECT * FROM VENTA_PRODUCTOS)COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE FECHA_VENTA='" + camp.getFECHA_CONSULTA() + "' AND STATUS_VENTA='2'  GROUP BY NO_VENTA ORDER BY TO_NUMBER(NO_VENTA) ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new ventaDiaMapper());
        return list;
    }

    public List ventaConsultaFechas(camposConBean camp) throws Exception {
        String query = "SELECT COT.ID_VENTA_PRODUCTO, COT.NO_PARTE, PROD.PRODUCTO, COT.PRECIO_UNITARIO, COT.NO_PRODUCTOVENTA, COT.PRECIO_FINAL, COT.STATUS_VENTA FROM (SELECT * FROM VENTA_PRODUCTOS)COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE TO_DATE(FECHA_VENTA)>='" + camp.getFECHA_INICIO() + "' AND TO_DATE(FECHA_VENTA)<='" + camp.getFECHA_FINAL() + "' AND STATUS_VENTA='2' ORDER BY ID_VENTA_PRODUCTO ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new consultaVentaMapper());
        return list;
    }

    public List ventaConsultaFechasDetalle(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT (COT.NO_VENTA),  SUM(COT.NO_PRODUCTOVENTA) AS NO_PRODUCTOVENTA, SUM(COT.PRECIO_FINAL) AS PRECIO_FINAL FROM (SELECT * FROM VENTA_PRODUCTOS  )COT JOIN (SELECT * FROM PRODUCTOS) PROD ON COT.NO_PARTE=PROD.NO_PARTE WHERE TO_DATE(FECHA_VENTA)>='" + camp.getFECHA_INICIO() + "' AND TO_DATE(FECHA_VENTA)<='" + camp.getFECHA_FINAL() + "' AND STATUS_VENTA='2'  GROUP BY NO_VENTA ORDER BY TO_NUMBER(NO_VENTA) ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new ventaDiaMapper());
        return list;
    }

    public List listaStok0(camposConBean camp) throws Exception {
        String query = "SELECT VENTA.NO_PARTE, PRODUCTOS.PRODUCTO, VENTA.NO_PRODUCTOVENTA, VENTA.FECHA_VENTA, PRODUCTOS.TOTAL_BODEGAS  FROM(SELECT * FROM VENTA_PRODUCTOS WHERE STATUS_VENTA='2' AND FECHA_VENTA='" + camp.getFECHA_CONSULTA() + "')VENTA JOIN(SELECT NO_PARTE, PRODUCTO, TOTAL_BODEGAS FROM FINAL_PRODUCTOS)PRODUCTOS ON VENTA.NO_PARTE=PRODUCTOS.NO_PARTE  ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new stokVentaMapper());
        return list;
    }

    public List listaStok0Fechas(camposConBean camp) throws Exception {
        String query = "SELECT VENTA.NO_PARTE, PRODUCTOS.PRODUCTO, VENTA.NO_PRODUCTOVENTA, VENTA.FECHA_VENTA, PRODUCTOS.TOTAL_BODEGAS  FROM(SELECT * FROM VENTA_PRODUCTOS WHERE STATUS_VENTA='2' AND TO_DATE(FECHA_VENTA)>='" + camp.getFECHA_INICIO() + "' AND TO_DATE(FECHA_VENTA)<='" + camp.getFECHA_FINAL() + "')VENTA JOIN(SELECT NO_PARTE, PRODUCTO, TOTAL_BODEGAS FROM FINAL_PRODUCTOS)PRODUCTOS ON VENTA.NO_PARTE=PRODUCTOS.NO_PARTE  ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new stokVentaMapper());
        return list;
    }

    public List traerProducto(camposConBean camp) throws Exception {
        String query = "SELECT PED.NO_VENTA, PED.PRODUCTO, PED.MARCA, PED.NO_PARTE, PED.NO_PRODUCTOVENTA, PED.VENDEDOR, PED.FECHA_VENTA, PED.NAME_BODEGA, BOD.UBICACION FROM (SELECT TRAER.NO_VENTA, CAT.PRODUCTO, CAT.MARCA, TRAER.NO_PARTE, TRAER.NO_PRODUCTOVENTA, TRAER.VENDEDOR, TRAER.FECHA_VENTA, TRAER.NAME_BODEGA FROM (SELECT NO_VENTA, NO_PARTE, NO_PRODUCTOVENTA, VENDEDOR, FECHA_VENTA, NAME_BODEGA FROM TRAER_PRODUCTO_BODEGAS WHERE TO_NUMBER( NO_PRODUCTOVENTA)>0 AND NO_VENTA='" + camp.getNO_VENTA() + "')TRAER JOIN (SELECT NO_PARTE, PRODUCTO, MARCA FROM FINAL_PRODUCTOS)CAT ON TRAER.NO_PARTE=CAT.NO_PARTE)PED JOIN (SELECT NO_PARTE,CONCAT(ANAQUEL,NIVEL) AS UBICACION, NAME_BODEGA FROM BODEGAS)BOD ON PED.NO_PARTE=BOD.NO_PARTE AND PED.NAME_BODEGA=BOD.NAME_BODEGA";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new traerProductoMapper());
        return list;
    }

    public List productosBuscarFinal(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, PRODUCTO, CATEGORIA, DESCRIPCION, PRECIO, GANANCIA, PRECIO_PESO, MARCA, UNIDADMEDIDA, MONEDA, ALTERNATIVO, RESPONSABLE, PRECIO_CAL, TOTAL_BODEGAS, PROVEEDOR, CATEGORIA_GENERAL, FECHA_ACTUALIZA, CVE_SAT FROM FINAL_PRODUCTOS WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "' ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosGralMapper());
        return list;
    }

    public List ganancia(camposConBean camp) throws Exception {
        String query = "SELECT ID_GANANCIA, GANANCIA FROM GANANCIA  ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new gananciaMapper());
        return list;
    }

    public List categoria(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(CATEGORIA_GENERAL) AS CATEGORIA_GENERAL FROM CATEGORIAS ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new categoriaGralMapper());
        return list;
    }

    public List anaquel(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(ANAQUEL) FROM BODEGAS ORDER BY TO_NUMBER(ANAQUEL) ";
        // System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new anaquelMapper());
        return list;
    }

    public List inventarioLista(camposConBean camp) throws Exception {
        String query = "SELECT BODEGAS.NO_PARTE, PRODUCTOS.PRODUCTO, BODEGAS.ANAQUEL, BODEGAS.NIVEL, BODEGAS.CATIDAD, BODEGAS.NAME_BODEGA FROM (SELECT NO_PARTE, ANAQUEL, NIVEL, CATIDAD, NAME_BODEGA FROM BODEGAS WHERE ANAQUEL='" + camp.getANAQUEL() + "' AND NIVEL='" + camp.getNIVEL() + "' AND NAME_BODEGA='" + camp.getBODEGA() + "')BODEGAS JOIN (SELECT NO_PARTE, PRODUCTO FROM FINAL_PRODUCTOS )PRODUCTOS  ON BODEGAS.NO_PARTE=PRODUCTOS.NO_PARTE ORDER BY TO_NUMBER(CATIDAD) DESC ";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new inventarioMapper());
        return list;
    }

    public List consultaBodega(camposConBean camp) throws Exception {
        String query = "SELECT NO_PARTE, ANAQUEL, NIVEL, CATIDAD,  NAME_BODEGA FROM BODEGAS WHERE NAME_BODEGA='" + camp.getBODEGA() + "' AND NO_PARTE='" + camp.getPARTEAUX() + "'";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosBodegaMapper());
        return list;
    }

    public List nivel(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(NIVEL) FROM BODEGAS ORDER BY NIVEL ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new nivelMapper());
        return list;
    }

    public List pedidosPendientes(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(ID_PEDIDO), COUNT(ID_PEDIDO) AS TOTAL_PARTES, SUM(CANTIDAD) AS TOTAL_PRODUCTOS  FROM PRODUCTOS_COMPRA WHERE ESTATUS_PEDIDO='PEDIDO' OR CANTIDAD<>CANTIDAD_LLEGADA GROUP BY ID_PEDIDO ORDER BY ID_PEDIDO ASC ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productosPendientesMapper());
        return list;
    }

    public List pedidosBuscar(camposConBean camp) throws Exception {
        String query = "SELECT ID_PRODUCT, ID_PEDIDO, AUXPEDIDO, NO_PARTE, CANTIDAD, FECHA_PEDIDO, FECHA_LLEGADA, PROVEEDOR,ESTATUS_PEDIDO, CANTIDAD_LLEGADA, '' AS AGREGAR FROM PRODUCTOS_COMPRA WHERE ID_PEDIDO='" + camp.getCONSULTA_PEDIDO() + "' ORDER BY TO_NUMBER(ID_PRODUCT) ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new pedidosMapper());
        return list;
    }

    public List valorLlegada(camposConBean camp) throws Exception {
        String query = "SELECT  ID_PEDIDO,  NO_PARTE,  CANTIDAD_LLEGADA FROM PRODUCTOS_COMPRA WHERE ID_PEDIDO='" + camp.getCONSULTA_PEDIDO() + "' AND NO_PARTE='" + camp.getPARTEAUX() + "' AND CANTIDAD_LLEGADA>0 ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new valorLlegadaMapper());
        return list;
    }

    public List pedidosBuscarAct(camposConBean camp) throws Exception {
        String query = "SELECT PRODUCT.ID_PRODUCT, PRODUCT.ID_PEDIDO, PRODUCT.AUXPEDIDO, PRODUCT.NO_PARTE, PRODUCT.CANTIDAD, PRODUCT.FECHA_PEDIDO, PRODUCT.FECHA_LLEGADA, PRODUCT.PROVEEDOR, PRODUCT.ESTATUS_PEDIDO, PRODUCT.CANTIDAD_LLEGADA, BODEGAS.ANAQUEL, BODEGAS.NIVEL FROM (SELECT ID_PRODUCT, ID_PEDIDO, AUXPEDIDO, NO_PARTE, CANTIDAD, FECHA_PEDIDO, FECHA_LLEGADA, PROVEEDOR,ESTATUS_PEDIDO, CANTIDAD_LLEGADA FROM PRODUCTOS_COMPRA WHERE ID_PRODUCT='" + camp.getID_PRODUCT() + "')PRODUCT JOIN (SELECT  NO_PARTE, ANAQUEL, NIVEL FROM BODEGAS WHERE  NAME_BODEGA='LOCAL' )BODEGAS ON PRODUCT.NO_PARTE=BODEGAS.NO_PARTE";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new pedidos2Mapper());
        return list;
    }

    public List pedidosFaltantes(camposConBean camp) throws Exception {
        String query = "SELECT  ID_PRODUCT, ID_PEDIDO, AUXPEDIDO, NO_PARTE, CANTIDAD, FECHA_PEDIDO, FECHA_LLEGADA, PROVEEDOR,ESTATUS_PEDIDO, CANTIDAD_LLEGADA,'' AS AGREGAR FROM PRODUCTOS_COMPRA WHERE CANTIDAD<>CANTIDAD_LLEGADA AND ESTATUS_PEDIDO='ALMACEN'";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new pedidosMapper());
        return list;
    }

    public List categoriaP(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(CATEGORIA)  FROM CATEGORIAS WHERE CATEGORIA_GENERAL='" + camp.getCATEGORIA_GENERAL() + "' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new categoriaMapper());
        return list;
    }

    public List selectProvee(camposConBean camp) throws Exception {
        String query = "SELECT DISTINCT(RFC_PROVEE), RASON_PROVEE FROM PROVEE ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new selectProveeMapper());
        return list;
    }

    public List contadoresPedidos(camposConBean camp) throws Exception {
        String query = "SELECT * FROM (SELECT NVL(MAX(ID_PRODUCT),'0') AS MAX_PRODUCT FROM PRODUCTOS_COMPRA),(SELECT NVL(MAX(ID_PEDIDO),'0') AS MAX_PEDIDO FROM PRODUCTOS_COMPRA),(SELECT NVL(MAX(AUXPEDIDO),'0') AS MAX_AUXPEDIDO FROM PRODUCTOS_COMPRA)  ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new contadoresPedidosMapper());
        return list;
    }

    public String iva() throws Exception {
        String query = "SELECT IVA FROM IVA ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        String valor = null;
        valor = queryStringUnCampo(query);
        return valor;
    }

    public String auxCotiza() throws Exception {
        String query = "SELECT NVL(MAX(DISTINCT(TO_NUMBER(AUXCOTIZA))),'0') AS AUXCOTIZA FROM COTIZACION";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        String valor = null;
        valor = queryStringUnCampo(query);
        return valor;
    }

    public String noCotiza() throws Exception {
        String query = "SELECT NVL(MAX(DISTINCT(TO_NUMBER(NO_COTIZA))),'0') AS NO_COTIZA FROM COTIZACION";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        String valor = null;
        valor = queryStringUnCampo(query);
        return valor;
    }

    public String noVenta() throws Exception {
        String query = "SELECT NVL(MAX(DISTINCT(TO_NUMBER(NO_VENTA))),'0') AS NO_COTIZA FROM VENTA_PRODUCTOS";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        String valor = null;
        valor = queryStringUnCampo(query);
        return valor;
    }

    public String dolar() throws Exception {
        String query = "SELECT DOLAR FROM DOLAR ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        String valor = null;
        valor = queryStringUnCampo(query);
        return valor;
    }

    public List productosBuscarAlt(camposConBean camp) throws Exception {
        String query = "SELECT ALTERNA.ID_ALTERNATIVO, ALTERNA.ALTERNATIVO  AS NO_PARTE_ALTERNATIVO, NVL(PROD.NO_PARTE,'NO') AS NO_PARTE , NVL(PROD.PRODUCTO,'SIN DATOS')AS PRODUCTO, PROD.CATEGORIA, PROD.DESCRIPCION, NVL( PROD.PRECIO,'0') AS PRECIO, PROD.MARCA, PROD.UNIDADMEDIDA, NVL( PROD.MONEDA,'NO') AS MONEDA, PROD.ALTERNATIVO, PROD.PRECIO_PESO,NVL( PROD.PRECIO_CAL,'0') AS PRECIO_CAL, PROD.GANANCIA, PROD.RESPONSABLE, PROD.PROVEEDOR, PROD.CATEGORIA_GENERAL, NVL (PROD.TOTAL_BODEGAS,'0') AS TOTAL_BODEGAS  FROM (SELECT  ALT.ID_ALTERNATIVO, ALT.ALTERNATIVO FROM (SELECT * FROM FINAL_PRODUCTOS  WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "')PRODUCTOS, (SELECT * FROM ALTERNATIVOS)ALT WHERE PRODUCTOS.NO_PARTE=ALT.NO_PARTE) ALTERNA LEFT  OUTER JOIN (SELECT * FROM FINAL_PRODUCTOS) PROD ON ALTERNA.ALTERNATIVO=PROD.NO_PARTE";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new productoAltMapper());
        return list;
    }

    public List historiaBodegas(camposConBean camp) throws Exception {
        String query = "SELECT    NO_PARTE,    CANTIDAD,    BODEGA,    ANAQUEL,    NIVEL,    FECHA_INGRESO FROM   historia_ingreso_bodegas  WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "' ORDER BY TO_DATE(FECHA_INGRESO) DESC";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new historiaBodegasMapper());
        return list;
    }

    public List productosAlternativos(camposConBean camp) throws Exception {
        String query = "SELECT ALT.ID_ALTERNATIVO AS ID_ALTERNATIVOS, ALT.NO_PARTE, ALT.ALTERNATIVO, NVL(PROD.PRODUCTO,'NO')AS PRODUCTO, NVL(PROD.DESCRIPCION,'NO') AS DESCRIPCION, NVL(PROD.MARCA,'MARCA') AS MARCA FROM (SELECT * FROM ALTERNATIVOS WHERE NO_PARTE='" + camp.getCONSULTA_PARTE() + "')ALT LEFT OUTER JOIN (SELECT NO_PARTE, PRODUCTO, DESCRIPCION, MARCA FROM PRODUCTOS)PROD ON ALT.ALTERNATIVO=PROD.NO_PARTE";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new alternativosMapper());
        return list;
    }

    public List proveedoresCon() throws Exception {
        String query = "SELECT RASON_PROVEE, RFC_PROVEE, NOMBRE_PROVEE, DIRECCION_PROVEE, TELEFONO_PROVEE, CORREO_PROVEE, EMPRESA_PROVEE, RESP_REGISTRO FROM PROVEE ORDER BY NOMBRE_PROVEE ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new proveedoresMapper());
        return list;
    }

    public List usuariosCon() throws Exception {
        String query = "SELECT NAMEUSUARIO, PASSWORD, PERFIL, NAMEPERFIL, USUARIO, NVL(FILTRO,'NO') AS FILTRO FROM USUARIOS ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new usuarioMapper());
        return list;
    }

    public List clientesBusqueda(camposConBean camp) throws Exception {
        String query = "SELECT RASON_CLIENT, RFC_CLIENT, NOMBRE_CLIENT, DIRECCION_CLIENT, TELEFONO_CLIET, CORREO_CLIENT, EMPRESA, RESP_REGISTRO FROM CLIENT WHERE NOMBRE_CLIENT LIKE '%" + camp.getBUSCARCLIENTE() + "%' OR RFC_CLIENT LIKE '%" + camp.getBUSCARCLIENTE() + "%' OR EMPRESA LIKE '%" + camp.getBUSCARCLIENTE() + "%' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new clientesMapper());
        return list;
    }

    public List proveedoresBusqueda(camposConBean camp) throws Exception {
        String query = "SELECT RASON_PROVEE, RFC_PROVEE, NOMBRE_PROVEE, DIRECCION_PROVEE, TELEFONO_PROVEE, CORREO_PROVEE, EMPRESA_PROVEE, RESP_REGISTRO  FROM PROVEE WHERE NOMBRE_PROVEE LIKE '%" + camp.getBUSCARPROVEEDOR() + "%' OR RFC_PROVEE LIKE '%" + camp.getBUSCARPROVEEDOR() + "%' OR EMPRESA_PROVEE LIKE '%" + camp.getBUSCARPROVEEDOR() + "%' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new proveedoresMapper());
        return list;
    }

    public List clientesBusquedaRfc(camposConBean camp) throws Exception {
        String query = "SELECT RASON_CLIENT, RFC_CLIENT, NOMBRE_CLIENT, DIRECCION_CLIENT, TELEFONO_CLIET, CORREO_CLIENT, EMPRESA, RESP_REGISTRO FROM CLIENT WHERE RFC_CLIENT='" + camp.getRFCAUX() + "' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new clientesMapper());
        return list;
    }

    public List proveedoresBusquedaRfc(camposConBean camp) throws Exception {
        String query = "SELECT RASON_PROVEE, RFC_PROVEE, NOMBRE_PROVEE, DIRECCION_PROVEE, TELEFONO_PROVEE, CORREO_PROVEE, EMPRESA_PROVEE, RESP_REGISTRO  FROM PROVEE WHERE RFC_PROVEE='" + camp.getRFCAUX() + "' ";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new proveedoresMapper());
        return list;
    }

    public boolean GuardaDatos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_CLIENT", "STRING", camp.getRFC_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RASON_CLIENT", "STRING", camp.getRAZONSOCIAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_CLIENT", "STRING", camp.getNOMBRE_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DIRECCION_CLIENT", "STRING", camp.getDIRECCION_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO_CLIET", "STRING", camp.getTELEFONO_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO_CLIENT", "STRING", camp.getCORREO_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMPRESA", "STRING", camp.getEMPRESA_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESP_REGISTRO", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("CLIENT", arregloCampos);
    }

    public boolean GuardaPBodega(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getPARTEAUX());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ANAQUEL", "STRING", camp.getANAQUEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NIVEL", "STRING", camp.getNIVEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getCANTIDAD_LLEGADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INGRESO", "STRING", camp.getFECHA_LLEGADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NAME_BODEGA", "STRING", camp.getBODEGA());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("BODEGAS", arregloCampos);
    }

    public boolean GuardaHistoriaBodega(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getPARTEAUX());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ANAQUEL", "STRING", camp.getANAQUEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NIVEL", "STRING", camp.getNIVEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CANTIDAD", "STRING", camp.getCANTIDAD_LLEGADA());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("BODEGA", "STRING", camp.getBODEGA());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("HISTORIA_INGRESO_BODEGAS", arregloCampos);
    }

    public boolean guardaProductoVenta(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_COTIZA", "STRING", "0");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_UNITARIO", "STRING", camp.getPRECIO_PESO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_PRODUCTOCOTIZA", "STRING", camp.getCANTIDAD_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_FINAL", "STRING", camp.getTOTAL_PRODUCTO_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RFC_CLIENTE", "STRING", camp.getAUX_RFC_CLIENTE());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_COTIZA", "STRING", camp.getFECHA_COTIZA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS_COTIZA", "STRING", "C");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AUXCOTIZA", "STRING", camp.getAUXCOTIZA());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("COTIZACION", arregloCampos);
    }

    public boolean guardarAlternativo(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ALTERNATIVO", "STRING", camp.getNO_ALTERNATIVOS());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("ALTERNATIVOS", arregloCampos);
    }

    public boolean productoTraer(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_VENTA", "STRING", camp.getNO_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_PRODUCTOVENTA", "STRING", camp.getCANTIDAD_TRAER());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NAME_BODEGA", "STRING", camp.getBODEGA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_VENTA", "STRING", camp.getFECHA_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("VENDEDOR", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsertTransaccion(conn, stat, "TRAER_PRODUCTO_BODEGAS", arregloCampos);
    }

    public Connection crearConexion() throws Exception {

        Connection conne;
        conne = createConnection();
        Constantes.enviaMensajeConsola("conexion abierta.........");
        return conne;

    }

    //creando statement
    @Override
    public Statement crearStatement(Connection cone) throws Exception {
        Statement stei;
        stei = createStatement2(cone);
        return stei;
    }

    public boolean guardaVentaCiclo(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_VENTA", "STRING", camp.getNO_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_UNITARIO", "STRING", camp.getPRECIO_UNITARIO_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_FINAL", "STRING", camp.getPRECIO_FINAL_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NO_PRODUCTOVENTA", "STRING", camp.getNO_PRODUCTOVENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RFC_CLIENTE", "STRING", camp.getAUX_RFC_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_VENTA", "STRING", camp.getFECHA_VENTA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS_VENTA", "STRING", "V");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("VENDEDOR", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("NO_COTIZA", "STRING", camp.getNO_COTIZACION());
        arregloCampos.add(temporal);

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsertTransaccion(conn, stat, "VENTA_PRODUCTOS", arregloCampos);
    }

    public boolean actualizaStok(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {

        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getNUEVOSTOK());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE_VENTA() + "" + "'" + " AND  NAME_BODEGA=" + "'" + "" + camp.getBODEGA() + "" + "'" + "";

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdateTransaccion(conn, stat, "BODEGAS", arregloCampos, Condicion);
    }

    public boolean actualizaEntrega(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {

        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("ENTREGA", "STRING", camp.getENTREGA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE_VENTA() + "" + "'" + " AND  NO_VENTA=" + "'" + "" + camp.getNO_VENTA() + "" + "'" + "";

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdateTransaccion(conn, stat, "VENTA_PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean Guardausuarios(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NAMEUSUARIO", "STRING", camp.getNAMEUSUARIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PASSWORD", "STRING", camp.getPASSWORD());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PERFIL", "STRING", camp.getPERFIL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NAMEPERFIL", "STRING", camp.getNAMEPERFIL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("USUARIO", "STRING", camp.getUSUARIO());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("USUARIOS", arregloCampos);
    }

    public boolean GuardaProv(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_PROVEE", "STRING", camp.getRFC_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RASON_PROVEE", "STRING", camp.getRAZONSOCIAL_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_PROVEE", "STRING", camp.getNOMBRE_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DIRECCION_PROVEE", "STRING", camp.getDIRECCION_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO_PROVEE", "STRING", camp.getTELEFONO_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO_PROVEE", "STRING", camp.getCORREO_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMPRESA_PROVEE", "STRING", camp.getEMPRESA_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESP_REGISTRO", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("PROVEE", arregloCampos);
    }

    public boolean ActualizaDatos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_CLIENT", "STRING", camp.getRFC_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RASON_CLIENT", "STRING", camp.getRAZONSOCIAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_CLIENT", "STRING", camp.getNOMBRE_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DIRECCION_CLIENT", "STRING", camp.getDIRECCION_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO_CLIET", "STRING", camp.getTELEFONO_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO_CLIENT", "STRING", camp.getCORREO_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMPRESA", "STRING", camp.getEMPRESA_CLIENTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESP_REGISTRO", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        String Condicion;
        Condicion = "WHERE RFC_CLIENT=" + "'" + "" + camp.getRFC_CLIENTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("CLIENT", arregloCampos, Condicion);
    }

    public boolean ActualizaBodegaStock(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getCANTIDAD());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ANAQUEL", "STRING", camp.getANAQUEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NIVEL", "STRING", camp.getNIVEL());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getPARTEAUX() + "" + "'" + " AND NAME_BODEGA=   " + "'" + "" + camp.getBODEGA() + "" + "'" + "        ";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("BODEGAS", arregloCampos, Condicion);
    }

    public boolean actualizarNoCotiza(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_COTIZA", "STRING", camp.getNO_COTIZACION());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE AUXCOTIZA=" + "'" + "" + camp.getAUXCOTIZA() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("COTIZACION", arregloCampos, Condicion);
    }

    public boolean actualizaCobra(camposConBean camp) throws Exception {
        System.out.println("Estoy Actualizando el estado de la venta");
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("STATUS_VENTA", "STRING", camp.getESTADO_VENTA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_VENTA=" + "'" + "" + camp.getNO_VENTA() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("VENTA_PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean actualizaEstatusEntrega(camposConBean camp) throws Exception {
        System.out.println("Estoy Actualizando el estado de la venta");
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ESTATUS_ENTREGA", "STRING", "ENTREGADO");
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_VENTA_PRODUCTO=" + "'" + "" + camp.getID_VENTA_PRODUCTO() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("VENTA_PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean actualizaEstadoCotiza(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_VENTA", "STRING", camp.getNO_VENTA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_COTIZA=" + "'" + "" + camp.getAUXCOTIZA() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("COTIZACION", arregloCampos, Condicion);
    }

    public boolean actualizaMovimiento(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getNUEVOSTOK());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ANAQUEL", "STRING", camp.getANAQUEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NIVEL", "STRING", camp.getNIVEL());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE() + "" + "'" + " AND NAME_BODEGA=" + "'" + "" + camp.getBODEGA() + "" + "'" + "     ";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("BODEGAS", arregloCampos, Condicion);
    }

    public boolean actualizaMovimientoMenos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getNUEVOSTOK());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE() + "" + "'" + " AND NAME_BODEGA=" + "'" + "" + camp.getBODEGA() + "" + "'" + "     ";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("BODEGAS", arregloCampos, Condicion);
    }

    public boolean actualizaStockCancela(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getNUEVOSTOK());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE() + "" + "'" + " AND NAME_BODEGA='LOCAL'";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("BODEGAS", arregloCampos, Condicion);
    }

    public boolean actualizaEstadoCotizacion(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("STATUS_COTIZA", "STRING", "VENDIDO");
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_COTIZA=" + "'" + "" + camp.getNO_COTIZA() + "" + "'" + " ";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("COTIZACION", arregloCampos, Condicion);
    }

    public boolean pedidoGuardar(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
       
        temporal = new ObjPrepareStatement("ESTATUS_PEDIDO", "STRING", camp.getESTATUS_PEDIDO());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE AUXPEDIDO=" + "'" + "" + camp.getMAX_AUXPEDIDO() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("PRODUCTOS_COMPRA", arregloCampos, Condicion);
    }

    public boolean Actualizaproveedores(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_PROVEE", "STRING", camp.getRFC_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RASON_PROVEE", "STRING", camp.getRAZONSOCIAL_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_PROVEE", "STRING", camp.getNOMBRE_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DIRECCION_PROVEE", "STRING", camp.getDIRECCION_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO_PROVEE", "STRING", camp.getTELEFONO_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO_PROVEE", "STRING", camp.getCORREO_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMPRESA_PROVEE", "STRING", camp.getEMPRESA_PROV());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESP_REGISTRO", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        String Condicion;
        Condicion = "WHERE RFC_PROVEE=" + "'" + "" + camp.getRFC_PROV() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("PROVEE", arregloCampos, Condicion);
    }

    public boolean actualizaProductos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("PRODUCTO", "STRING", camp.getPRODUCTO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA", "STRING", camp.getCATEGORIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DESCRIPCION", "STRING", camp.getDESCRIPCION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO", "STRING", camp.getPRECIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MARCA", "STRING", camp.getMARCA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("UNIDADMEDIDA", "STRING", camp.getUNIDADMEDIDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MONEDA", "STRING", camp.getMONEDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_CAL", "STRING", camp.getPRECIO_CAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GANANCIA", "STRING", camp.getGANANCIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROVEEDOR", "STRING", camp.getPROVEEDOR());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA_GENERAL", "STRING", camp.getCATEGORIA_GENERAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_ACTUALIZA", "STRING", camp.getFECHA_ACTUALIZA());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("CVE_SAT", "STRING", camp.getCVE_SAT());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean guardaLlegadaP(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("FECHA_LLEGADA", "STRING", camp.getFECHA_LLEGADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CANTIDAD_LLEGADA", "STRING", camp.getCANTIDAD_LLEGADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS_PEDIDO", "STRING", camp.getESTATUS_PEDIDO());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_PRODUCT=" + "'" + "" + camp.getID_PRODUCT() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("PRODUCTOS_COMPRA", arregloCampos, Condicion);
    }

    public boolean guardaProductos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRODUCTO", "STRING", camp.getPRODUCTO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA", "STRING", camp.getCATEGORIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DESCRIPCION", "STRING", camp.getDESCRIPCION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO", "STRING", camp.getPRECIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MARCA", "STRING", camp.getMARCA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("UNIDADMEDIDA", "STRING", camp.getUNIDADMEDIDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MONEDA", "STRING", camp.getMONEDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_PESO", "STRING", camp.getSIMULADOR_PRECIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_CAL", "STRING", camp.getPRECIO_CAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GANANCIA", "STRING", camp.getGANANCIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROVEEDOR", "STRING", camp.getPROVEEDOR());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA_GENERAL", "STRING", camp.getCATEGORIA_GENERAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_ACTUALIZA", "STRING", camp.getFECHA_ACTUALIZA());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("CVE_SAT", "STRING", camp.getCVE_SAT());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("PRODUCTOS", arregloCampos);
    }

    public boolean guardaPedidos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("ID_PRODUCT", "STRING", camp.getMAX_PRODUCT());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("AUXPEDIDO", "STRING", camp.getMAX_AUXPEDIDO());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CANTIDAD", "STRING", camp.getNO_PRODUCTOS_PEDIDOS());
        arregloCampos.add(temporal);

        temporal = new ObjPrepareStatement("FECHA_PEDIDO", "STRING", camp.getFECHA_ACTUALIZA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROVEEDOR", "STRING", camp.getPROVEEDOR());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("ID_PEDIDO", "STRING", camp.getID_PEDIDO());
        arregloCampos.add(temporal);
        
        return oraDaoFac.queryInsert("PRODUCTOS_COMPRA", arregloCampos);
    }

    public boolean guardaProductosHist(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRODUCTO", "STRING", camp.getPRODUCTO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA", "STRING", camp.getCATEGORIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DESCRIPCION", "STRING", camp.getDESCRIPCION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO", "STRING", camp.getPRECIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MARCA", "STRING", camp.getMARCA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("UNIDADMEDIDA", "STRING", camp.getUNIDADMEDIDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MONEDA", "STRING", camp.getMONEDA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_CAL", "STRING", camp.getPRECIO_CAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GANANCIA", "STRING", camp.getGANANCIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRECIO_PESO", "STRING", camp.getSIMULADOR_PRECIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROVEEDOR", "STRING", camp.getPROVEEDOR());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATEGORIA_GENERAL", "STRING", camp.getCATEGORIA_GENERAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_ACTUALIZA", "STRING", camp.getFECHA_ACTUALIZA());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("HISTORIA_INGRESO_PRODUCTO", arregloCampos);
    }

    public boolean guardaProductosBodega(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());

        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE", "STRING", camp.getRESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ANAQUEL", "STRING", camp.getANAQUEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NIVEL", "STRING", camp.getNIVEL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CATIDAD", "STRING", camp.getCANTIDAD_LLEGADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NAME_BODEGA", "STRING", camp.getBODEGA());
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("BODEGAS", arregloCampos);
    }

    public boolean borrarDatos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_CLIENT", "STRING", camp.getRFCAUX());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE RFC_CLIENT=" + "'" + "" + camp.getRFCAUX() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("CLIENT", arregloCampos, Condicion);
    }

    public boolean borrarAlternativo(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ID_ALTERNATIVO", "STRING", camp.getAUX_ALTERNATIVO());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_ALTERNATIVO=" + "'" + "" + camp.getAUX_ALTERNATIVO() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("ALTERNATIVOS", arregloCampos, Condicion);
    }

    public boolean usuariosDatos(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NAMEUSUARIO", "STRING", camp.getRFCAUX());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NAMEUSUARIO=" + "'" + "" + camp.getRFCAUX() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("USUARIOS", arregloCampos, Condicion);
    }

    public boolean borrarProducto(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ID_COTIZAPRODUCTO", "STRING", camp.getBORRARPRODUCTO());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_COTIZAPRODUCTO=" + "'" + "" + camp.getBORRARPRODUCTO() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("COTIZACION", arregloCampos, Condicion);
    }

    public boolean borrarPedidoProducto(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ID_PRODUCT", "STRING", camp.getID_PRODUCTO_BORRAR());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_PRODUCT=" + "'" + "" + camp.getID_PRODUCTO_BORRAR() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("PRODUCTOS_COMPRA", arregloCampos, Condicion);
    }

    public boolean borrarProductoVenta(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getNO_PARTE());
         arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NO_VENTA", "STRING", camp.getNO_VENTA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getNO_PARTE() + "" + "'" + " AND  NO_VENTA=" + "'" + "" + camp.getNO_VENTA()  + "" + "'" + "";

       
        
        System.out.print("la condición es:"+Condicion);

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDeleteCondicion("VENTA_PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean pedidosProductosBorrar(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ID_PRODUCT", "STRING", camp.getID_PRODUCT());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE ID_PRODUCT=" + "'" + "" + camp.getID_PRODUCT() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("PRODUCTOS_COMPRA", arregloCampos, Condicion);
    }

    public boolean eliminarProducto(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getCONSULTA_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("PRODUCTOS", arregloCampos, Condicion);
    }

    public boolean eliminarProductoBodegas(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getCONSULTA_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("BODEGAS", arregloCampos, Condicion);
    }

    public boolean eliminarProductoAlternativos(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getCONSULTA_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("ALTERNATIVOS", arregloCampos, Condicion);
    }

    public boolean eliminarProductoHist(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getCONSULTA_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("HISTORIA_INGRESO_BODEGAS", arregloCampos, Condicion);
       
    }
     public boolean eliminarProductoHistIn(camposConBean camp) throws Exception {

        System.out.println("entre a borrar el producto" + camp.getID_PRODUCT());
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("NO_PARTE", "STRING", camp.getCONSULTA_PARTE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE NO_PARTE=" + "'" + "" + camp.getCONSULTA_PARTE() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("HISTORIA_INGRESO_PRODUCTO", arregloCampos, Condicion);
       
    }

    public boolean borrarProveedores(camposConBean camp) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("RFC_PROVEE", "STRING", camp.getRFCAUX());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = "WHERE RFC_PROVEE=" + "'" + "" + camp.getRFCAUX() + "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryDelete("PROVEE", arregloCampos, Condicion);
    }

}
