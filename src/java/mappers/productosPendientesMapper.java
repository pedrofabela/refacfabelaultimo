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
public class productosPendientesMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("ID_PEDIDO") != null) {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO").trim());
        } else {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO"));
        }
        
         if (rs.getString("TOTAL_PARTES") != null) {
            usr.setTOTAL_PARTES(rs.getString("TOTAL_PARTES").trim());
        } else {
            usr.setTOTAL_PARTES(rs.getString("TOTAL_PARTES"));
        }
        
         if (rs.getString("TOTAL_PRODUCTOS") != null) {
            usr.setTOTAL_PRODUCTOS(rs.getString("TOTAL_PRODUCTOS").trim());
        } else {
            usr.setTOTAL_PRODUCTOS(rs.getString("TOTAL_PRODUCTOS"));
        }
          
        
        return usr;
    }
}
