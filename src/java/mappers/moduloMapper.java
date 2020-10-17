package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.moduloBean;

 

public class moduloMapper implements Mapper {
	
	public Object mapRow(ResultSet rs) throws SQLException {
		moduloBean mod = new moduloBean();

		mod.setCVE_MODULO(rs.getString("CVEMODULO").trim());
        mod.setDESC_MOD(rs.getString("NAMEMOD").trim());
        mod.setACTION(rs.getString("ACTION"));
        mod.setCVE_MODPADRE(rs.getString("MODPADRE"));
        mod.setIMAGEN(rs.getString("IMAGEN"));
		return mod;
	}
	

}


