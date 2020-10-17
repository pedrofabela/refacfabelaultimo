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
public class anaquelMapper implements Mapper{
    
       public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        if (rs.getString("ANAQUEL") != null) {
            usr.setANAQUEL(rs.getString("ANAQUEL").trim());
        } else {
            usr.setANAQUEL(rs.getString("ANAQUEL"));
        }
        
        
         
          return usr;
       }
    
}
