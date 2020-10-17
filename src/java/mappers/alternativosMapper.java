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
public class alternativosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 

           if (rs.getString("ID_ALTERNATIVOS") != null) {
            usr.setID_ALTERNATIVOS(rs.getString("ID_ALTERNATIVOS").trim());
        } else {
            usr.setID_ALTERNATIVOS(rs.getString("ID_ALTERNATIVOS"));
        }
        
        if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }
        
         
             if (rs.getString("ALTERNATIVO") != null) {
            usr.setALTERNATIVO(rs.getString("ALTERNATIVO").trim());
        } else {
            usr.setALTERNATIVO(rs.getString("ALTERNATIVO"));
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
            if (rs.getString("MARCA") != null) {
            usr.setMARCA(rs.getString("MARCA").trim());
        } else {
            usr.setMARCA(rs.getString("MARCA"));
        }     
           
        return usr;
    }
    
}
