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
public class pedidosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("ID_PRODUCT") != null) {
            usr.setID_PRODUCT(rs.getString("ID_PRODUCT").trim());
        } else {
            usr.setID_PRODUCT(rs.getString("ID_PRODUCT"));
        }
        
        
         if (rs.getString("ID_PEDIDO") != null) {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO").trim());
        } else {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO"));
        }
        
         
           if (rs.getString("AUXPEDIDO") != null) {
            usr.setAUXPEDIDO(rs.getString("AUXPEDIDO").trim());
        } else {
            usr.setAUXPEDIDO(rs.getString("AUXPEDIDO"));
        }
           
           
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
              
            if (rs.getString("FECHA_PEDIDO") != null) {
            usr.setFECHA_PEDIDO(rs.getString("FECHA_PEDIDO").trim());
        } else {
            usr.setFECHA_PEDIDO(rs.getString("FECHA_PEDIDO"));
        }   
            
            
              if (rs.getString("FECHA_LLEGADA") != null) {
            usr.setFECHA_LLEGADA(rs.getString("FECHA_LLEGADA").trim());
        } else {
            usr.setFECHA_LLEGADA(rs.getString("FECHA_LLEGADA"));
        }   
              
              
               if (rs.getString("PROVEEDOR") != null) {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR").trim());
        } else {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR"));
        }   
               
           if (rs.getString("ESTATUS_PEDIDO") != null) {
            usr.setESTATUS_PEDIDO(rs.getString("ESTATUS_PEDIDO").trim());
        } else {
            usr.setESTATUS_PEDIDO(rs.getString("ESTATUS_PEDIDO"));
        }         
            
           if (rs.getString("CANTIDAD_LLEGADA") != null) {
            usr.setCANTIDAD_LLEGADA(rs.getString("CANTIDAD_LLEGADA").trim());
        } else {
            usr.setCANTIDAD_LLEGADA(rs.getString("CANTIDAD_LLEGADA"));
        }          
        return usr;
    }
    
}
