package chrisanabo.excel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chrisanabo.excel.dao.AlertMessageDao;
import chrisanabo.excel.model.Alert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/applicationContext.xml")
public class AlertServiceTest {

        private AlertMessageDao alertMessageDao;
        
        
		private ApplicationContext applicationContext;
        
        @Before
        public void tearDown(){
                JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
                jdbcTemplate.update("delete from topics");
        }
        
        @Autowired
        public void setApplicationContext(ApplicationContext applicationContext) {
                this.applicationContext = applicationContext;
        }

        @Autowired
        public void setAlertMessageDao(AlertMessageDao alertMessageDao) {
			this.alertMessageDao = alertMessageDao;
		}

        @Test
        public void testTopicDaoNotNull() {
                assertTrue(this.alertMessageDao != null);
        }
        
        @Test
        public void testLoadAllTopics() {
                JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
                jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test1",30);
                jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test2",40);
                
                List<Alert> topics = alertMessageDao.getAll();
                assertNotNull(topics.size() == 2);
        }
        
        @Test
        public void testLoadTopic() {
                JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
                jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test1",30);
                int id = jdbcTemplate.queryForObject("select max(id) from topics",Integer.class);
                Alert alert = alertMessageDao.getById(id);
                assertNotNull(alert);
        }
        
        @Test
        public void testInsertTopic() {
                int num = alertMessageDao.insert(new Alert());
                assertTrue(num == 1);
        }
        
}