package com.likai.datebase.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import javax.sql.DataSource;



@Configuration
@EnableTransactionManagement
@MapperScan("com.likai.datebase.dao")
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);



    //    配置类别名
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    //  配置mapper的扫描，找到所有的mapper.xml映射文件
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;


    //  加载全局的配置文件
    @Value("${mybatis.configLocation}")
    private String configLocation;



    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }



    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSourcemaster) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        sqlSessionFactoryBean.setMapperLocations(resources);
//        sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
        sqlSessionFactoryBean.setDataSource(dataSourcemaster);
        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }






}
