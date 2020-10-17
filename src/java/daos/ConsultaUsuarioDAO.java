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
import java.util.List;

/**
 *
 * @author pedro
 */
public interface ConsultaUsuarioDAO {
    
    
     public List clientesCon() throws Exception;
      public List proveedoresCon() throws Exception;
      public List usuariosCon() throws Exception;
      public List clientesBusqueda(camposConBean camp) throws Exception;
       public List proveedoresBusqueda(camposConBean camp) throws Exception;
       public List clientesBusquedaRfc(camposConBean camp) throws Exception;
        public List proveedoresBusquedaRfc(camposConBean camp) throws Exception;
        public boolean GuardaDatos(camposConBean camp) throws Exception;
        public boolean GuardaPBodega(camposConBean camp) throws Exception;
         public boolean GuardaHistoriaBodega(camposConBean camp) throws Exception;
         public boolean guardaProductoVenta(camposConBean camp) throws Exception;
          public boolean guardarAlternativo(camposConBean camp) throws Exception;
          
        
         public boolean Guardausuarios(camposConBean camp) throws Exception;
         public boolean GuardaProv(camposConBean camp) throws Exception;
         public boolean ActualizaDatos(camposConBean camp) throws Exception;
          public boolean ActualizaBodegaStock(camposConBean camp) throws Exception;
            public boolean actualizarNoCotiza(camposConBean camp) throws Exception;
              public boolean actualizaCobra(camposConBean camp) throws Exception;
            public boolean actualizaEstatusEntrega(camposConBean camp) throws Exception;
               public boolean actualizaEstadoCotiza(camposConBean camp) throws Exception;
                public boolean actualizaMovimiento(camposConBean camp) throws Exception;
                 public boolean actualizaMovimientoMenos(camposConBean camp) throws Exception;
                             public boolean actualizaStockCancela(camposConBean camp) throws Exception;
 
             public boolean actualizaEstadoCotizacion(camposConBean camp) throws Exception;
         public boolean pedidoGuardar(camposConBean camp) throws Exception;
         
         public boolean Actualizaproveedores(camposConBean camp) throws Exception;
          public boolean actualizaProductos(camposConBean camp) throws Exception;
           public boolean guardaLlegadaP(camposConBean camp) throws Exception;
            public boolean guardaProductos(camposConBean camp) throws Exception;
              public boolean guardaPedidos(camposConBean camp) throws Exception;
              public boolean guardaProductosHist(camposConBean camp) throws Exception;
              public boolean guardaProductosBodega(camposConBean camp) throws Exception;
          public boolean borrarDatos(camposConBean camp) throws Exception;
            public boolean borrarAlternativo(camposConBean camp) throws Exception;
           public boolean usuariosDatos(camposConBean camp) throws Exception;
            public boolean borrarProducto(camposConBean camp) throws Exception;
             public boolean borrarPedidoProducto(camposConBean camp) throws Exception;
             public boolean borrarProductoVenta(camposConBean camp) throws Exception;
            public boolean pedidosProductosBorrar(camposConBean camp) throws Exception;
            public boolean eliminarProducto(camposConBean camp) throws Exception;
            public boolean eliminarProductoBodegas(camposConBean camp) throws Exception;
            public boolean eliminarProductoAlternativos(camposConBean camp) throws Exception;
              public boolean eliminarProductoHist(camposConBean camp) throws Exception;
               public boolean eliminarProductoHistIn(camposConBean camp) throws Exception;

            public List productosGral() throws Exception;
             public List productosBuscar(camposConBean camp) throws Exception;
              public List catSat(camposConBean camp) throws Exception;
              public List productosBuscarLike(camposConBean camp) throws Exception;
              public List cotizaHist(camposConBean camp) throws Exception;
              public List productosBuscarVenta(camposConBean camp) throws Exception;
               public List carritoPedidos(camposConBean camp) throws Exception;
             public List productosBuscarHist(camposConBean camp) throws Exception;
              public List carroCotizacion(camposConBean camp) throws Exception;
              public List consultaVenta(camposConBean camp) throws Exception;
                public List carroConCotizacion(camposConBean camp) throws Exception;
                 public List ventaAlmacen(camposConBean camp) throws Exception;
                 public List ventaConsulta(camposConBean camp) throws Exception;
                  public List ventaConsultaDia(camposConBean camp) throws Exception;
                  public List ventaConsultaDiaFecha(camposConBean camp) throws Exception;
                  public List ventaDia(camposConBean camp) throws Exception;
                   public List ventaConsultaFechas(camposConBean camp) throws Exception;
                   public List ventaConsultaFechasDetalle(camposConBean camp) throws Exception;
                     public List listaStok0(camposConBean camp) throws Exception;
                       public List listaStok0Fechas(camposConBean camp) throws Exception;
               public List traerProducto(camposConBean camp) throws Exception;
              public List productosBuscarFinal(camposConBean camp) throws Exception;
                public List ganancia(camposConBean camp) throws Exception;
                 public List categoria(camposConBean camp) throws Exception;
                  public List anaquel(camposConBean camp) throws Exception;
                    public List inventarioLista(camposConBean camp) throws Exception;
                   public List consultaBodega(camposConBean camp) throws Exception;
                   public List nivel(camposConBean camp) throws Exception;
                  public List pedidosPendientes(camposConBean camp) throws Exception;
                   public List pedidosBuscar(camposConBean camp) throws Exception;
                   public List valorLlegada(camposConBean camp) throws Exception;
                    public List pedidosBuscarAct(camposConBean camp) throws Exception;
                    public List pedidosFaltantes(camposConBean camp) throws Exception;
                    public List categoriaP(camposConBean camp) throws Exception;
                          public List selectProvee(camposConBean camp) throws Exception;
                           public List contadoresPedidos(camposConBean camp) throws Exception;
             public String iva() throws Exception;
              public String auxCotiza() throws Exception;
              public String noCotiza() throws Exception;
                public String noVenta() throws Exception;
              public String dolar() throws Exception;
              public List productosBuscarAlt(camposConBean camp) throws Exception;
               public List historiaBodegas(camposConBean camp) throws Exception;
                public List productosAlternativos(camposConBean camp) throws Exception;
           public boolean borrarProveedores(camposConBean camp) throws Exception;

            public boolean guardaVentaCiclo(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception;
             public boolean productoTraer(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception;
               public boolean actualizaStok(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception;
                public boolean actualizaEntrega(Connection conn, PreparedStatement stat, camposConBean camp) throws Exception;
    public Connection crearConexion() throws Exception;

    public Statement crearStatement(Connection cone) throws Exception;
    
}
