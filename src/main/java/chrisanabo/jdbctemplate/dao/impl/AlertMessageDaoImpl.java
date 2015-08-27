package chrisanabo.jdbctemplate.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import chrisanabo.jdbctemplate.dao.AlertMessageDao;
import chrisanabo.jdbctemplate.dao.rowmapper.AlertRowMapper;
import chrisanabo.jdbctemplate.model.Alert;

public class AlertMessageDaoImpl extends JdbcDaoSupport implements AlertMessageDao {
	
	@Autowired
	private DataSource dataSource;
	
	public AlertMessageDaoImpl(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	@Override
    public int edit(Alert alert) {
        String query = "update Employee set name=?, role=? where id=?";
        
        Object[] args = new Object[] {alert};//.getName(), employee.getRole(), employee.getId()};
         
        int out = getJdbcTemplate().update(query, args);
        if(out !=0){
       //     System.out.println("Employee updated with id="+employee.getId());
        }else {
        	//System.out.println("No Employee found with id="+employee.getId());
        }
        return out;
    }
 
    @Override
    public int deleteById(int id) {
 
        String query = "delete from Employee where id=?";
       
        int out = getJdbcTemplate().update(query, id);
        if(out !=0){
            System.out.println("Employee deleted with id="+id);
        }else System.out.println("No Employee found with id="+id);
        
        return out;
    }

	

	@Override
	public List<Alert> getAll() {
		String alertSql = "select * from alert";
		List<Alert> alertList = getJdbcTemplate().query(alertSql,new AlertRowMapper());
		return alertList;
	}

	@Override
	public Alert getById(Object id) {
		  
		String alertSql = "SELECT * FROM USER WHERE ID = ?";
		
		Alert alert = getJdbcTemplate().queryForObject(alertSql, new Object[]{id}, new AlertRowMapper() {
				@Override
	            public Alert mapRow(ResultSet rs, int rowNum)
	                    throws SQLException {
	                Alert alertRs = new Alert();
	                     return alertRs;
	            }
			});
        return alert;
	}

	@Override
	public int add(Alert alert) {
		String query = "insert into topics(title,duration) values(?,?)";
        int out = getJdbcTemplate().update(query, null,null);
        if(out !=0){
      
        }else{
        
        }
        
        return out;
	
	}

}
