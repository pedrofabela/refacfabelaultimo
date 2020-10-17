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
public class catSatMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("N_ID") != null) {
            usr.setN_ID(rs.getString("N_ID").trim());
        } else {
            usr.setN_ID(rs.getString("N_ID"));
        }
        
        if (rs.getString("CVE_SAT") != null) {
            usr.setCVE_SAT(rs.getString("CVE_SAT").trim());
        } else {
            usr.setCVE_SAT(rs.getString("CVE_SAT"));
        }
         if (rs.getString("DESCRIPCION") != null) {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION").trim());
        } else {
            usr.setDESCRIPCION(rs.getString("DESCRIPCION"));
        }
        
         
         
         
        return usr;
    }
    
}
