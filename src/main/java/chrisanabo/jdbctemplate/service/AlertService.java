package chrisanabo.jdbctemplate.service;

import java.util.List;

import chrisanabo.jdbctemplate.model.Alert;

public interface AlertService {
	
	public int add(Alert alert);
	
	public int edit(Alert employee);
 
    public int deleteById(int id);
    
    public List<Alert> getAll();
	
	public Alert getById(Object id);
	
	
}
