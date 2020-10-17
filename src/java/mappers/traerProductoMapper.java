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
public class traerProductoMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 

        
        
      
        
        
         if (rs.getString("NO_VENTA") != null) {
            usr.setNO_VENTA(rs.getString("NO_VENTA").trim());
        } else {
            usr.setNO_VENTA(rs.getString("NO_VENTA"));
        }
        
         
           if (rs.getString("PRODUCTO") != null) {
            usr.setPRODUCTO(rs.getString("PRODUCTO").trim());
        } else {
            usr.setPRODUCTO(rs.getString("PRODUCTO"));
        }
           
           
           
             if (rs.getString("MARCA") != null) {
            usr.setMARCA(rs.getString("MARCA").trim());
        } else {
            usr.setMARCA(rs.getString("MARCA"));
        }
             
              if (rs.getString("NO_PRODUCTOVENTA") != null) {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA").trim());
        } else {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA"));
        }
              
            if (rs.getString("VENDEDOR") != null) {
            usr.setVENDEDOR(rs.getString("VENDEDOR").trim());
        } else {
            usr.setVENDEDOR(rs.getString("VENDEDOR"));
        }   
            
            
              if (rs.getString("FECHA_VENTA") != null) {
            usr.setFECHA_VENTA(rs.getString("FECHA_VENTA").trim());
        } else {
            usr.setFECHA_VENTA(rs.getString("FECHA_VENTA"));
        }   
              
              
               if (rs.getString("NAME_BODEGA") != null) {
            usr.setNAME_BODEGA(rs.getString("NAME_BODEGA").trim());
        } else {
            usr.setNAME_BODEGA(rs.getString("NAME_BODEGA"));
        }   
               
           if (rs.getString("UBICACION") != null) {
            usr.setUBICACION(rs.getString("UBICACION").trim());
        } else {
            usr.setUBICACION(rs.getString("UBICACION"));
        }         
             if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }         
           
        return usr;
    }
    
    
    
}
