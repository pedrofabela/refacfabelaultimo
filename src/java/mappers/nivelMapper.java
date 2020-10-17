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
public class nivelMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("NIVEL") != null) {
            usr.setNIVEL(rs.getString("NIVEL").trim());
        } else {
            usr.setNIVEL(rs.getString("NIVEL"));
        }
        
        
         
          return usr;
       }
    
}
