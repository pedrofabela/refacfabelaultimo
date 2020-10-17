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
public class productoAltMapper implements Mapper{
    
   public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
          if (rs.getString("ID_ALTERNATIVO") != null) {
            usr.setID_ALTERNATIVO(rs.getString("ID_ALTERNATIVO").trim());
        } else {
            usr.setID_ALTERNATIVO(rs.getString("ID_ALTERNATIVO"));
        }
        
          
           if (rs.getString("NO_PARTE_ALTERNATIVO") != null) {
            usr.setNO_PARTE_ALTERNATIVO(rs.getString("NO_PARTE_ALTERNATIVO").trim());
        } else {
            usr.setNO_PARTE_ALTERNATIVO(rs.getString("NO_PARTE_ALTERNATIVO"));
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
        
         if (rs.getString("CATEGORIA") != null) {
            usr.setCATEGORIA(rs.getString("CATEGORIA").trim());
        } else {
            usr.setCATEGORIA(rs.getString("CATEGORIA"));
        }
          
         if (rs.getString("DESCRIPCION") != null) {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION").trim());
        } else {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION"));
        }
          if (rs.getString("PRECIO") != null) {
            usr.setPRECIO(rs.getString("PRECIO").trim());
        } else {
            usr.setPRECIO(rs.getString("PRECIO"));
        }
          if (rs.getString("GANANCIA") != null) {
            usr.setGANANCIA(rs.getString("GANANCIA").trim());
        } else {
            usr.setGANANCIA(rs.getString("GANANCIA"));
        }
           if (rs.getString("PRECIO_PESO") != null) {
            usr.setPRECIO_PESO(rs.getString("PRECIO_PESO").trim());
        } else {
            usr.setPRECIO_PESO(rs.getString("PRECIO_PESO"));
        }
           
            if (rs.getString("MARCA") != null) {
            usr.setMARCA(rs.getString("MARCA").trim());
        } else {
            usr.setMARCA(rs.getString("MARCA"));
        }
            if (rs.getString("UNIDADMEDIDA") != null) {
            usr.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA").trim());
        } else {
            usr.setUNIDADMEDIDA(rs.getString("UNIDADMEDIDA"));
        }
             if (rs.getString("MONEDA") != null) {
            usr.setMONEDA(rs.getString("MONEDA").trim());
        } else {
            usr.setMONEDA(rs.getString("MONEDA"));
        }
               if (rs.getString("ALTERNATIVO") != null) {
            usr.setALTERNATIVO(rs.getString("ALTERNATIVO").trim());
        } else {
            usr.setALTERNATIVO(rs.getString("ALTERNATIVO"));
        }
                if (rs.getString("RESPONSABLE") != null) {
            usr.setRESPONSABLE(rs.getString("RESPONSABLE").trim());
        } else {
            usr.setRESPONSABLE(rs.getString("RESPONSABLE"));
        }
          if (rs.getString("PRECIO_CAL") != null) {
            usr.setPRECIO_CAL(rs.getString("PRECIO_CAL").trim());
        } else {
            usr.setPRECIO_CAL(rs.getString("PRECIO_CAL"));
        }
           if (rs.getString("TOTAL_BODEGAS") != null) {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS").trim());
        } else {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS"));
        }
           if (rs.getString("PROVEEDOR") != null) {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR").trim());
        } else {
            usr.setPROVEEDOR(rs.getString("PROVEEDOR"));
        }
             if (rs.getString("CATEGORIA_GENERAL") != null) {
            usr.setCATEGORIA_GENERAL(rs.getString("CATEGORIA_GENERAL").trim());
        } else {
            usr.setCATEGORIA_GENERAL(rs.getString("CATEGORIA_GENERAL"));
        }
        return usr;
    }
         
         
      
    
}
