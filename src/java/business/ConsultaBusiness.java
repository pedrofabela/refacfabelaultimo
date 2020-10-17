/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.camposConBean;
import daos.AccesoUsarioDAO;
import daos.AccesoUsarioDAOImpl;
import daos.ConsultaDAOImpl;
import daos.ConsultaUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ConsultaBusiness {
   
    private ConsultaUsuarioDAO ConDAO;

    public ConsultaBusiness() throws Exception{
        this.ConDAO = new ConsultaDAOImpl();
    }
    
   
    
     public List clientesCon() throws Exception{
        List lista = this.ConDAO.clientesCon();
        return lista;
    }
      public List proveedoresCon() throws Exception{
        List lista = this.ConDAO.proveedoresCon();
        return lista;
    }
       public List usuariosCon() throws Exception{
        List lista = this.ConDAO.usuariosCon();
        return lista;
    }
     public List clientesBusqueda(camposConBean camp) throws Exception{
        List lista = this.ConDAO.clientesBusqueda(camp);
        return lista;
    }
     public List proveedoresBusqueda(camposConBean camp) throws Exception{
        List lista = this.ConDAO.proveedoresBusqueda(camp);
        return lista;
    }
      public List clientesBusquedaRfc(camposConBean camp) throws Exception{
        List lista = this.ConDAO.clientesBusquedaRfc(camp);
        return lista;
    }
      public List proveedoresBusquedaRfc(camposConBean camp) throws Exception{
        List lista = this.ConDAO.proveedoresBusquedaRfc(camp);
        return lista;
    }
      public boolean GuardaDatos(camposConBean camp) throws Exception {
        return ConDAO.GuardaDatos(camp);
    }
       public boolean GuardaPBodega(camposConBean camp) throws Exception {
        return ConDAO.GuardaPBodega(camp);
    }
       public boolean GuardaHistoriaBodega(camposConBean camp) throws Exception {
        return ConDAO.GuardaHistoriaBodega(camp);
    }
         public boolean guardaProductoVenta(camposConBean camp) throws Exception {
        return ConDAO.guardaProductoVenta(camp);
    }
           public boolean guardarAlternativo(camposConBean camp) throws Exception {
        return ConDAO.guardarAlternativo(camp);
    }
          
          
          
          
       public Connection crearConexion() throws Exception {
        return ConDAO.crearConexion();
    }   
          
          
       public Statement crearStatement(Connection cone) throws Exception {
        return ConDAO.crearStatement(cone);

    }    
       
       public boolean guardaVentaCiclo(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {
        return this.ConDAO.guardaVentaCiclo(conn, stat, camp);
    }
       
    public boolean productoTraer(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {
        return this.ConDAO.productoTraer(conn, stat, camp);
    }   
       
       public boolean actualizaStok(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {
        return this.ConDAO.actualizaStok(conn, stat, camp);
    }    
    
        public boolean actualizaEntrega(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception {
        return this.ConDAO.actualizaEntrega(conn, stat, camp);
    }    
          
       public boolean Guardausuarios(camposConBean camp) throws Exception {
        return ConDAO.Guardausuarios(camp);
    }
      public boolean GuardaProv(camposConBean camp) throws Exception {
        return ConDAO.GuardaProv(camp);
    }
       public boolean ActualizaDatos(camposConBean camp) throws Exception {
        return ConDAO.ActualizaDatos(camp);
    }
        public boolean ActualizaBodegaStock(camposConBean camp) throws Exception {
        return ConDAO.ActualizaBodegaStock(camp);
    }
        
        public boolean actualizarNoCotiza(camposConBean camp) throws Exception {
        return ConDAO.actualizarNoCotiza(camp);
    } 
          public boolean actualizaCobra(camposConBean camp) throws Exception {
        return ConDAO.actualizaCobra(camp);
    }
           public boolean actualizaEstatusEntrega(camposConBean camp) throws Exception {
        return ConDAO.actualizaEstatusEntrega(camp);
    } 
     
      public boolean actualizaEstadoCotiza(camposConBean camp) throws Exception {
        return ConDAO.actualizaEstadoCotiza(camp);
    } 
       public boolean actualizaMovimiento(camposConBean camp) throws Exception {
        return ConDAO.actualizaMovimiento(camp);
    } 
        public boolean actualizaMovimientoMenos(camposConBean camp) throws Exception {
        return ConDAO.actualizaMovimientoMenos(camp);
    } 
       public boolean actualizaStockCancela(camposConBean camp) throws Exception {
        return ConDAO.actualizaStockCancela(camp);
    } 
    
     public boolean actualizaEstadoCotizacion(camposConBean camp) throws Exception {
        return ConDAO.actualizaEstadoCotizacion(camp);
    } 
       public boolean Actualizaproveedores(camposConBean camp) throws Exception {
        return ConDAO.Actualizaproveedores(camp);
    }
       
       public boolean actualizaProductos(camposConBean camp) throws Exception {
        return ConDAO.actualizaProductos(camp);
    } 
         public boolean guardaLlegadaP(camposConBean camp) throws Exception {
        return ConDAO.guardaLlegadaP(camp);
    } 
         public boolean guardaProductos(camposConBean camp) throws Exception {
        return ConDAO.guardaProductos(camp);
    } 
         public boolean guardaPedidos(camposConBean camp) throws Exception {
        return ConDAO.guardaPedidos(camp);
    } 
        public boolean guardaProductosHist(camposConBean camp) throws Exception {
        return ConDAO.guardaProductosHist(camp);
    } 
         public boolean guardaProductosBodega(camposConBean camp) throws Exception {
        return ConDAO.guardaProductosBodega(camp);
    } 
        public boolean borrarDatos(camposConBean camp) throws Exception {
        return ConDAO.borrarDatos(camp);
    }
       public boolean borrarAlternativo(camposConBean camp) throws Exception {
        return ConDAO.borrarAlternativo(camp);
    }  
         public boolean usuariosDatos(camposConBean camp) throws Exception {
        return ConDAO.usuariosDatos(camp);
    }
          public boolean borrarProducto(camposConBean camp) throws Exception {
        return ConDAO.borrarProducto(camp);
    }
           public boolean borrarPedidoProducto(camposConBean camp) throws Exception {
        return ConDAO.borrarPedidoProducto(camp);
    }
           public boolean borrarProductoVenta(camposConBean camp) throws Exception {
        return ConDAO.borrarProductoVenta(camp);
    }
        public boolean pedidosProductosBorrar(camposConBean camp) throws Exception {
        return ConDAO.pedidosProductosBorrar(camp);
    }  
         public boolean eliminarProducto(camposConBean camp) throws Exception {
        return ConDAO.eliminarProducto(camp);
    }  
         public boolean eliminarProductoBodegas(camposConBean camp) throws Exception {
        return ConDAO.eliminarProductoBodegas(camp);
    }  
          public boolean eliminarProductoAlternativos(camposConBean camp) throws Exception {
        return ConDAO.eliminarProductoAlternativos(camp);
    }  
            public boolean eliminarProductoHist(camposConBean camp) throws Exception {
        return ConDAO.eliminarProductoHist(camp);
    }  
       public boolean eliminarProductoHistIn(camposConBean camp) throws Exception {
        return ConDAO.eliminarProductoHistIn(camp);
    }  
         public boolean pedidoGuardar(camposConBean camp) throws Exception {
        return ConDAO.pedidoGuardar(camp);
    }
         
         public List productosGral() throws Exception{
        List lista = this.ConDAO.productosGral();
        return lista;
    }
         public List productosBuscar(camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscar(camp);
        return lista;
    } 
         
           public List catSat(camposConBean camp) throws Exception{
        List lista = this.ConDAO.catSat(camp);
        return lista;
    }  
         
          public List productosBuscarLike(camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscarLike(camp);
        return lista;
    }  
         
          public List cotizaHist(camposConBean camp) throws Exception{
        List lista = this.ConDAO.cotizaHist(camp);
        return lista;
    }  
          public List productosBuscarVenta(camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscarVenta(camp);
        return lista;
    }  
          public List carritoPedidos(camposConBean camp) throws Exception{
        List lista = this.ConDAO.carritoPedidos(camp);
        return lista;
    }  
          public List productosBuscarHist(camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscarHist(camp);
        return lista;
    }  
           public List carroCotizacion(camposConBean camp) throws Exception{
        List lista = this.ConDAO.carroCotizacion(camp);
        return lista;
    }  
           
           public List carroConCotizacion(camposConBean camp) throws Exception{
        List lista = this.ConDAO.carroConCotizacion(camp);
        return lista;
    }  
            public List consultaVenta(camposConBean camp) throws Exception{
        List lista = this.ConDAO.consultaVenta(camp);
        return lista;
    }  
            public List ventaAlmacen(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaAlmacen(camp);
        return lista;
    }  
             public List ventaConsulta(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaConsulta(camp);
        return lista;
    }  
              public List ventaConsultaDia(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaConsultaDia(camp);
        return lista;
    }  
               public List ventaConsultaDiaFecha(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaConsultaDiaFecha(camp);
        return lista;
    }  
       public List ventaDia(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaDia(camp);
        return lista;
    }          
               public List ventaConsultaFechas(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaConsultaFechas(camp);
        return lista;
    }  
                public List ventaConsultaFechasDetalle(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ventaConsultaFechasDetalle(camp);
        return lista;
    }  
                public List listaStok0(camposConBean camp) throws Exception{
        List lista = this.ConDAO.listaStok0(camp);
        return lista;
    }  
                 public List listaStok0Fechas(camposConBean camp) throws Exception{
        List lista = this.ConDAO.listaStok0Fechas(camp);
        return lista;
    }  
             public List traerProducto(camposConBean camp) throws Exception{
        List lista = this.ConDAO.traerProducto(camp);
        return lista;
    }  
          public List productosBuscarFinal(camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscarFinal(camp);
        return lista;
    }  
           public List ganancia(camposConBean camp) throws Exception{
        List lista = this.ConDAO.ganancia(camp);
        return lista;
    }  
             public List categoria(camposConBean camp) throws Exception{
        List lista = this.ConDAO.categoria(camp);
        return lista;
    }  
               public List anaquel(camposConBean camp) throws Exception{
        List lista = this.ConDAO.anaquel(camp);
        return lista;
    }  
               public List inventarioLista(camposConBean camp) throws Exception{
        List lista = this.ConDAO.inventarioLista(camp);
        return lista;
    }  
                 public List consultaBodega(camposConBean camp) throws Exception{
        List lista = this.ConDAO.consultaBodega(camp);
        return lista;
    }  
                 public List nivel(camposConBean camp) throws Exception{
        List lista = this.ConDAO.nivel(camp);
        return lista;
    }  
         public List pedidosPendientes(camposConBean camp) throws Exception{
        List lista = this.ConDAO.pedidosPendientes(camp);
        return lista;
    }       
         public List pedidosBuscar(camposConBean camp) throws Exception{
        List lista = this.ConDAO.pedidosBuscar(camp);
        return lista;
    }    
         public List valorLlegada(camposConBean camp) throws Exception{
        List lista = this.ConDAO.valorLlegada(camp);
        return lista;
    }    
          public List pedidosBuscarAct(camposConBean camp) throws Exception{
        List lista = this.ConDAO.pedidosBuscarAct(camp);
        return lista;
    }     
         
          public List pedidosFaltantes(camposConBean camp) throws Exception{
        List lista = this.ConDAO.pedidosFaltantes(camp);
        return lista;
    }            
               public List categoriaP(camposConBean camp) throws Exception{
        List lista = this.ConDAO.categoriaP(camp);
        return lista;
    }  
              public List selectProvee(camposConBean camp) throws Exception{
        List lista = this.ConDAO.selectProvee(camp);
        return lista;
    }  
               public List contadoresPedidos(camposConBean camp) throws Exception{
        List lista = this.ConDAO.contadoresPedidos(camp);
        return lista;
    }  
          public String iva() throws Exception{
        String lista = this.ConDAO.iva();
        return lista;
    }  
           public String auxCotiza() throws Exception{
        String lista = this.ConDAO.auxCotiza();
        return lista;
    }  
            public String noCotiza() throws Exception{
        String lista = this.ConDAO.noCotiza();
        return lista;
    }  
             public String noVenta() throws Exception{
        String lista = this.ConDAO.noVenta();
        return lista;
    }  
           public String dolar() throws Exception{
        String lista = this.ConDAO.dolar();
        return lista;
    }  
   
        public List productosBuscarAlt (camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosBuscarAlt(camp);
        return lista;
    }     
        
        public List historiaBodegas (camposConBean camp) throws Exception{
        List lista = this.ConDAO.historiaBodegas(camp);
        return lista;
    }          
        
          public List productosAlternativos (camposConBean camp) throws Exception{
        List lista = this.ConDAO.productosAlternativos(camp);
        return lista;
    }       
          public boolean borrarProveedores(camposConBean camp) throws Exception {
        return ConDAO.borrarProveedores(camp);
    }
}
