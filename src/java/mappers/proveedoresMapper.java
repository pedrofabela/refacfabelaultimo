/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.clientesBean;
import beans.proveedoresBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class proveedoresMapper implements Mapper{
    
    
    public Object mapRow(ResultSet rs) throws SQLException {
		proveedoresBean usr = new proveedoresBean();

		usr.setCORREO_PROVEE(rs.getString("CORREO_PROVEE"));
		usr.setDIRECCION_PROVEE(rs.getString("DIRECCION_PROVEE"));
		usr.setEMPRESA_PROVEE(rs.getString("EMPRESA_PROVEE"));
		usr.setNOMBRE_PROVEE(rs.getString("NOMBRE_PROVEE"));
		usr.setRESP_REGISTRO(rs.getString("RESP_REGISTRO"));
		usr.setRFC_PROVEE(rs.getString("RFC_PROVEE"));
                usr.setTELEFONO_PROVEE(rs.getString("TELEFONO_PROVEE"));
                 usr.setRASON_PROVEE(rs.getString("RASON_PROVEE"));
                
		return usr;
	}
    
}
