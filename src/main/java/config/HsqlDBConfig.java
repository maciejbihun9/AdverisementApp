package config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:app.properties" })
@EnableJpaRepositories(
        basePackages = "hsqlRepository",
        entityManagerFactoryRef = "userInputEntityManager",
        transactionManagerRef = "userInputTransactionManager"
)
public class HsqlDBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource hsqlDataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .setName("testdb")
                .addScript("db/create-db.sql")
                .addScript("db/insert-data.sql")
                .build();
        return db;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userInputEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(hsqlDataSource());
        em.setPackagesToScan(new String[] { "model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hsql.persist_status"));
        properties.put("hibernate.dialect", env.getProperty("hsql.dialect"));
        properties.put("show-sql", env.getProperty("hsql.show_sql"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager userInputTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userInputEntityManager().getObject());
        return transactionManager;
    }

}
