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
public class consultaVentaAlmacenMapper implements Mapper{
    
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
        
        
         if (rs.getString("DESCRIPCION") != null) {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION").trim());
        } else {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION"));
        }
        
         
           
             if (rs.getString("NO_PRODUCTOVENTA") != null) {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA").trim());
        } else {
            usr.setNO_PRODUCTOVENTA(rs.getString("NO_PRODUCTOVENTA"));
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
            
          if (rs.getString("ID_VENTA_PRODUCTO") != null) {
            usr.setID_VENTA_PRODUCTO(rs.getString("ID_VENTA_PRODUCTO").trim());
        } else {
            usr.setID_VENTA_PRODUCTO(rs.getString("ID_VENTA_PRODUCTO"));
        }       
        
           if (rs.getString("ESTATUS_ENTREGA") != null) {
            usr.setESTATUS_ENTREGA(rs.getString("ESTATUS_ENTREGA").trim());
        } else {
            usr.setESTATUS_ENTREGA(rs.getString("ESTATUS_ENTREGA"));
        }       
           
        return usr;
    }
    
}
