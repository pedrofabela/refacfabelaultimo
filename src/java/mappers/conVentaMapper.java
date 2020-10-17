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
public class conVentaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
    
     if (rs.getString("NO_VENTA") != null) {
            usr.setNO_VENTA(rs.getString("NO_VENTA").trim());
        } else {
            usr.setNO_VENTA(rs.getString("NO_VENTA"));
        }
        
        
         if (rs.getString("NO_COTIZA") != null) {
            usr.setNO_COTIZA(rs.getString("NO_COTIZA").trim());
        } else {
            usr.setNO_COTIZA(rs.getString("NO_COTIZA"));
        }
        
         
       
        return usr;
    }
    
}
