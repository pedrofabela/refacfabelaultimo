/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.camposConBean;
import beans.productosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class categoriaGralMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
         camposConBean usr = new camposConBean();
 
        
        
          if (rs.getString("CATEGORIA_GENERAL") != null) {
            usr.setCATEGORIA_GENERAL(rs.getString("CATEGORIA_GENERAL").trim());
        } else {
            usr.setCATEGORIA_GENERAL(rs.getString("CATEGORIA_GENERAL"));
        }
          
       
          
        return usr;
    }
    
}
