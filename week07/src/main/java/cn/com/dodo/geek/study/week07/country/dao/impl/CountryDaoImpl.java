package cn.com.dodo.geek.study.week07.country.dao.impl;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import cn.com.dodo.geek.study.week07.country.dao.ICountryDao;
import cn.com.dodo.geek.study.week07.country.dao.ICountryMapper;
import cn.com.dodo.geek.study.week07.country.model.Country;
import cn.com.dodo.geek.study.week07.spring.DSType;

public class CountryDaoImpl implements ICountryDao {

	SqlSessionFactory sqlSessionFactory;

	public CountryDaoImpl(DataSource dataSource) {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("dev", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(ICountryMapper.class);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	@Override
	@DSType("read")
	public Country findOne(Long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		try {
			return sqlSession.selectOne("cn.com.dodo.geek.study.week07.country.dao.ICountryMapper.findOne", id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	@DSType("write")
	public int saveOne(Country country) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("cn.com.dodo.geek.study.week07.country.dao.ICountryMapper.saveOne", country);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	@DSType("write")
	public int deleteOne(Long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("cn.com.dodo.geek.study.week07.country.dao.ICountryMapper.deleteOne", id);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	@DSType("write")
	public int updateOne(Country country) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update("cn.com.dodo.geek.study.week07.country.dao.ICountryMapper.updateOne",
					country);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

}
