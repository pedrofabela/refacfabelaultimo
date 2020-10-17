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
public class cotizacionHist implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 
           if (rs.getString("NO_COTIZA") != null) {
            usr.setNO_COTIZA(rs.getString("NO_COTIZA").trim());
        } else {
            usr.setNO_COTIZA(rs.getString("NO_COTIZA"));
        }
        
        
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
        
        
         if (rs.getString("PRECIO_UNITARIO") != null) {
            usr.setPRECIO_UNITARIO(rs.getString("PRECIO_UNITARIO").trim());
        } else {
            usr.setPRECIO_UNITARIO(rs.getString("PRECIO_UNITARIO"));
        }
        
         
           
             if (rs.getString("NO_PRODUCTOCOTIZA") != null) {
            usr.setNO_PRODUCTOCOTIZA(rs.getString("NO_PRODUCTOCOTIZA").trim());
        } else {
            usr.setNO_PRODUCTOCOTIZA(rs.getString("NO_PRODUCTOCOTIZA"));
        }
             
             
             
            
              
            if (rs.getString("PRECIO_FINAL") != null) {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL").trim());
        } else {
            usr.setPRECIO_FINAL(rs.getString("PRECIO_FINAL"));
        }   
         
             if (rs.getString("RESPONSABLE") != null) {
            usr.setRESPONSABLE(rs.getString("RESPONSABLE").trim());
        } else {
            usr.setRESPONSABLE(rs.getString("RESPONSABLE"));
        }   
            
          if (rs.getString("FECHA_COTIZA") != null) {
            usr.setFECHA_COTIZA(rs.getString("FECHA_COTIZA").trim());
        } else {
            usr.setFECHA_COTIZA(rs.getString("FECHA_COTIZA"));
        }      
           
        return usr;
    }
    
}
