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
public class selectProveeMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
        
        
          if (rs.getString("RFC_PROVEE") != null) {
            usr.setRFC_PROVEE(rs.getString("RFC_PROVEE").trim());
        } else {
            usr.setRFC_PROVEE(rs.getString("RFC_PROVEE"));
        }
           if (rs.getString("RASON_PROVEE") != null) {
            usr.setRASON_PROVEE(rs.getString("RASON_PROVEE").trim());
        } else {
            usr.setRASON_PROVEE(rs.getString("RASON_PROVEE"));
        }
       
          
        return usr;
    }
    
}
