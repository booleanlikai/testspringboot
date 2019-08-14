package com.likai.datebase.configure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
@EnableConfigurationProperties({DruidDataSourceProperties.class})
@EnableTransactionManagement
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private DruidDataSourceProperties druidDataSourceProperties;

    //    配置类别名
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    //  配置mapper的扫描，找到所有的mapper.xml映射文件
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;


    //  加载全局的配置文件
    @Value("${mybatis.configLocation}")
    private String configLocation;


    @Bean(name = "masterDataSource")
    @Primary
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        dataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        dataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        dataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidDataSourceProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidDataSourceProperties.getValidationQuery());
        dataSource.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidDataSourceProperties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
//        try {
//            dataSource.setFilters(druidDataSourceProperties.getFilters());
//            dataSource.init();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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


    /**
     * 注册Servlet信息， 配置监控视图
     *
     * @return
     */
//    @Bean
//    @ConditionalOnMissingBean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//
//        //白名单：
////        servletRegistrationBean.addInitParameter("allow","192.168.6.195");
//        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
////        servletRegistrationBean.addInitParameter("deny","192.168.6.73");
//        //登录查看信息的账号密码, 用于登录Druid监控后台
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "admin");
//        //是否能够重置数据.
//        servletRegistrationBean.addInitParameter("resetEnable", "true");
//        return servletRegistrationBean;
//
//    }

    /**
     * 注册Filter信息, 监控拦截器
     *
     * @return
     */
//    @Bean
//    @ConditionalOnMissingBean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }




}
