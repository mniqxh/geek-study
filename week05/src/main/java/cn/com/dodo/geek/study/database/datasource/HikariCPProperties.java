package cn.com.dodo.geek.study.database.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.zaxxer.hikari.HikariConfig;

@ConfigurationProperties(prefix="geek.hakaricp")
public class HikariCPProperties extends HikariConfig{

}
