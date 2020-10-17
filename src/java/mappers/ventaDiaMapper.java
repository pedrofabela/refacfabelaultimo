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
public class ventaDiaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 

           if (rs.getString("NO_VENTA") != null) {
            usr.setNO_VENTA(rs.getString("NO_VENTA").trim());
        } else {
            usr.setNO_VENTA(rs.getString("NO_VENTA"));
        }
        
         
           
             if (rs.getString("NO_PRODUCTOVENTA") != null) {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA").trim());
        } else {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA"));
        }
             
             
             
            
            if (rs.getString("PRECIO_FINAL") != null) {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL").trim());
        } else {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL"));
        }   
            
            
            
           
        return usr;
    }
    
}
