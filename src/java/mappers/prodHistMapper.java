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
public class prodHistMapper implements Mapper{
    
    
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
        
       
          
       
          if (rs.getString("PRECIO") != null) {
            usr.setPRECIO(rs.getString("PRECIO").trim());
        } else {
            usr.setPRECIO(rs.getString("PRECIO"));
        }
          
           if (rs.getString("PRECIO_PESO") != null) {
            usr.setPRECIO_PESO(rs.getString("PRECIO_PESO").trim());
        } else {
            usr.setPRECIO_PESO(rs.getString("PRECIO_PESO"));
        }
          
          
          
          if (rs.getString("GANANCIA") != null) {
            usr.setGANANCIA(rs.getString("GANANCIA").trim());
        } else {
            usr.setGANANCIA(rs.getString("GANANCIA"));
        }
          
           
            if (rs.getString("MARCA") != null) {
            usr.setMARCA(rs.getString("MARCA").trim());
        } else {
            usr.setMARCA(rs.getString("MARCA"));
        }
           
             if (rs.getString("MONEDA") != null) {
            usr.setMONEDA(rs.getString("MONEDA").trim());
        } else {
            usr.setMONEDA(rs.getString("MONEDA"));
        }
             
              
          
           if (rs.getString("PROVEEDOR") != null) {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR").trim());
        } else {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR"));
        }
             if (rs.getString("FECHAINGRESO") != null) {
            usr.setFECHAINGRESO(rs.getString("FECHAINGRESO").trim());
        } else {
            usr.setFECHAINGRESO(rs.getString("FECHAINGRESO"));
        }
        return usr;
    }
    
}
