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
 * @author pedro
 */
public class historiaBodegasMapper implements Mapper{
    
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
          if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }
         if (rs.getString("CANTIDAD") != null) {
            usr.setCANTIDAD(rs.getString("CANTIDAD").trim());
        } else {
            usr.setCANTIDAD(rs.getString("CANTIDAD"));
        }
          
           if (rs.getString("ANAQUEL") != null) {
            usr.setANAQUEL(rs.getString("ANAQUEL").trim());
        } else {
            usr.setANAQUEL(rs.getString("ANAQUEL"));
        }
        
        
        if (rs.getString("NIVEL") != null) {
            usr.setNIVEL(rs.getString("NIVEL").trim());
        } else {
            usr.setNIVEL(rs.getString("NIVEL"));
        }
        
         if (rs.getString("BODEGA") != null) {
            usr.setBODEGA(rs.getString("BODEGA").trim());
        } else {
            usr.setBODEGA(rs.getString("BODEGA"));
        }
         if (rs.getString("FECHA_INGRESO") != null) {
            usr.setFECHA_INGRESO(rs.getString("FECHA_INGRESO").trim());
        } else {
            usr.setFECHA_INGRESO(rs.getString("FECHA_INGRESO"));
        }
        
        return usr;
    }
    
}
