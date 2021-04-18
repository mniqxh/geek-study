package cn.com.dodo.geek.study.database.datasource;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataSourceDemoApplication.class)
public class DataSourceDemoApplicationTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@org.junit.Test
	public void context() {
		String sql = "select * from country";
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
		results.stream().forEach(column -> {
			column.forEach((name, value) -> {
				System.out.print(value + "\t");
			});
			System.out.println();
		});
	}
}
