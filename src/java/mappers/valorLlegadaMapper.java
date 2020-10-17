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
public class valorLlegadaMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        productosBean usr = new productosBean();
 
 

           if (rs.getString("ID_PEDIDO") != null) {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO").trim());
        } else {
            usr.setID_PEDIDO(rs.getString("ID_PEDIDO"));
        }
        
        if (rs.getString("NO_PARTE") != null) {
            usr.setNO_PARTE(rs.getString("NO_PARTE").trim());
        } else {
            usr.setNO_PARTE(rs.getString("NO_PARTE"));
        }
        
           if (rs.getString("CANTIDAD_LLEGADA") != null) {
            usr.setCANTIDAD_LLEGADA(rs.getString("CANTIDAD_LLEGADA").trim());
        } else {
            usr.setCANTIDAD_LLEGADA(rs.getString("CANTIDAD_LLEGADA"));
        }   
       
        
         
          
           
        return usr;
    }
    
}
