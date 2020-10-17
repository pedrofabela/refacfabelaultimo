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
public class productosBodegaLikeMapper implements Mapper{
    
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
       if (rs.getString("MARCA") != null) {
            usr.setMARCA(rs.getString("MARCA").trim());
        } else {
            usr.setMARCA(rs.getString("MARCA"));
        }
         
         if (rs.getString("TOTAL_BODEGAS") != null) {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS").trim());
        } else {
            usr.setTOTAL_BODEGAS(rs.getString("TOTAL_BODEGAS"));
        }
         
        return usr;
    }
    
}
