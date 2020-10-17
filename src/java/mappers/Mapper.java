package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public interface Mapper {
	Object mapRow(ResultSet rs) throws SQLException;
} 