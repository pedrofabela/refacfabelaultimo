/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.clientesBean;
import beans.usuarioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class clientesMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		clientesBean usr = new clientesBean();

		usr.setCORREO_CLIENT(rs.getString("CORREO_CLIENT"));
		usr.setDIRECCION_CLIENT(rs.getString("DIRECCION_CLIENT"));
		usr.setEMPRESA(rs.getString("EMPRESA"));
		usr.setNOMBRE_CLIENT(rs.getString("NOMBRE_CLIENT"));
		usr.setRESP_REGISTRO(rs.getString("RESP_REGISTRO"));
		usr.setRFC_CLIENT(rs.getString("RFC_CLIENT"));
                usr.setTELEFONO_CLIET(rs.getString("TELEFONO_CLIET"));
                 usr.setRASON_CLIENT(rs.getString("RASON_CLIENT"));
                
		return usr;
	}
    
}
