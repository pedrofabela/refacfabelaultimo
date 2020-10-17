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
public class inventarioMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("NIVEL") != null) {
            usr.setNIVEL(rs.getString("NIVEL").trim());
        } else {
            usr.setNIVEL(rs.getString("NIVEL"));
        }
         if (rs.getString("ANAQUEL") != null) {
            usr.setANAQUEL(rs.getString("ANAQUEL").trim());
        } else {
            usr.setANAQUEL(rs.getString("ANAQUEL"));
        }
        if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }
         
         if (rs.getString("CATIDAD") != null) {
            usr.setCATIDAD(rs.getString("CATIDAD").trim());
        } else {
            usr.setCATIDAD(rs.getString("CATIDAD"));
        }
          if (rs.getString("PRODUCTO") != null) {
            usr.setPRODUCTO(rs.getString("PRODUCTO").trim());
        } else {
            usr.setPRODUCTO(rs.getString("PRODUCTO"));
        }
          
           if (rs.getString("NAME_BODEGA") != null) {
            usr.setNAME_BODEGA(rs.getString("NAME_BODEGA").trim());
        } else {
            usr.setNAME_BODEGA(rs.getString("NAME_BODEGA"));
        }
           
          return usr;
       }
}
