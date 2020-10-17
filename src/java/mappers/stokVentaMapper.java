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
public class stokVentaMapper implements Mapper{
    
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
         
          if (rs.getString("NO_PRODUCTOVENTA") != null) {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA").trim());
        } else {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA"));
        }
          
           if (rs.getString("FECHA_VENTA") != null) {
            usr.setFECHA_VENTA(rs.getString("FECHA_VENTA").trim());
        } else {
            usr.setFECHA_VENTA(rs.getString("FECHA_VENTA"));
        }
        
            if (rs.getString("TOTAL_BODEGAS") != null) {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS").trim());
        } else {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS"));
        }
         
       
        return usr;
    }
    
    
}
