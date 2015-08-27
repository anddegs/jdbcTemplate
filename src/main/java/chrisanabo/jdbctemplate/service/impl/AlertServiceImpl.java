package chrisanabo.jdbctemplate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chrisanabo.jdbctemplate.dao.AlertMessageDao;
import chrisanabo.jdbctemplate.model.Alert;
import chrisanabo.jdbctemplate.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {
    
	@Autowired
	AlertMessageDao alertDao;
	
	@Override
	public List<Alert> getAll() {
		return alertDao.getAll();
	}

	@Override
	public Alert getById(Object id) {
		return alertDao.getById(id);
	}

	@Override
	public int add(Alert alert) {
		return alertDao.add(alert);
	}

	@Override
	public int edit(Alert employee) {
		return alertDao.edit(employee);
	}

	@Override
	public int deleteById(int id) {
		return alertDao.deleteById(id);		
	}

}