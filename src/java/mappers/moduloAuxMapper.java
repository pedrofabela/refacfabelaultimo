package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.moduloAuxBean;


 
public class moduloAuxMapper implements Mapper {
	
	public Object mapRow(ResultSet rs) throws SQLException {
		moduloAuxBean mod = new moduloAuxBean();

	   
	        mod.setMODULO(rs.getString("CVEMODULO").trim());
	        mod.setMOD(rs.getString("NAMEMOD").trim());
	        mod.setACCION(rs.getString("ACTION"));
	        mod.setMODPADRE(rs.getString("MODPADRE"));
		return mod;
	}
	

}


