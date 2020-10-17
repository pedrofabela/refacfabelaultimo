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
public class consultaVentaMapper implements Mapper{
    
       public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 

           if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }
        
        if (rs.getString("PRODUCTO") != null) {
            usr.setPRODUCTO(rs.getString("PRODUCTO").trim());
        } else {
            usr.setPRODUCTO(rs.getString("PRODUCTO"));
        }
        
           if (rs.getString("ID_VENTA_PRODUCTO") != null) {
            usr.setID_VENTA_PRODUCTO(rs.getString("ID_VENTA_PRODUCTO").trim());
        } else {
            usr.setID_VENTA_PRODUCTO(rs.getString("ID_VENTA_PRODUCTO"));
        }   
       
        
         
           
             if (rs.getString("NO_PRODUCTOVENTA") != null) {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA").trim());
        } else {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA"));
        }
             
             
             
              if (rs.getString("PRECIO_UNITARIO") != null) {
            usr.setPRECIO_UNITARIO(rs.getString("PRECIO_UNITARIO").trim());
        } else {
            usr.setPRECIO_UNITARIO(rs.getString("PRECIO_UNITARIO"));
        }
              
            if (rs.getString("PRECIO_FINAL") != null) {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL").trim());
        } else {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL"));
        }   
         
              if (rs.getString("STATUS_VENTA") != null) {
            usr.setSTATUS_VENTA(rs.getString("STATUS_VENTA").trim());
        } else {
            usr.setSTATUS_VENTA(rs.getString("STATUS_VENTA"));
        }   
            
          
           
        return usr;
    }
    
    
}
