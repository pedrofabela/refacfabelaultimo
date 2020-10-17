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
public class gananciaMapper implements Mapper{
    
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        
        
          if (rs.getString("ID_GANANCIA") != null) {
            usr.setID_GANANCIA(rs.getString("ID_GANANCIA").trim());
        } else {
            usr.setID_GANANCIA(rs.getString("ID_GANANCIA"));
        }
          
          if (rs.getString("GANANCIA") != null) {
            usr.setGANANCIA(rs.getString("GANANCIA").trim());
        } else {
            usr.setGANANCIA(rs.getString("GANANCIA"));
        }
          
        return usr;
    }
         
    
}
