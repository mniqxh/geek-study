package cn.com.dodo.geek.study.week07.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class SimpleRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}

}
