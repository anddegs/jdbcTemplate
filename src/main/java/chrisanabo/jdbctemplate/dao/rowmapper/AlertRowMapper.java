package chrisanabo.jdbctemplate.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chrisanabo.jdbctemplate.model.Alert;

public class AlertRowMapper  implements RowMapper<Alert>	{

	@Override
	public Alert mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Alert();
	}


}
