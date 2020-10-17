/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.productosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class contadoresPedidosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        
        
          if (rs.getString("MAX_PRODUCT") != null) {
            usr.setMAX_PRODUCT(rs.getString("MAX_PRODUCT").trim());
        } else {
            usr.setMAX_PRODUCT(rs.getString("MAX_PRODUCT"));
        }
          
            if (rs.getString("MAX_PEDIDO") != null) {
            usr.setMAX_PEDIDO(rs.getString("MAX_PEDIDO").trim());
        } else {
            usr.setMAX_PEDIDO(rs.getString("MAX_PEDIDO"));
        }
        if (rs.getString("MAX_AUXPEDIDO") != null) {
            usr.setMAX_AUXPEDIDO(rs.getString("MAX_AUXPEDIDO").trim());
        } else {
            usr.setMAX_AUXPEDIDO(rs.getString("MAX_AUXPEDIDO"));
        }
          
        return usr;
    }
}
