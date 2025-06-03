package com.planazo.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseInitializer(DataSource ds) { this.dataSource = ds; }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = new ClassPathResource("scripts/01_init_data.sql");

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(resource);
        populator.setContinueOnError(false);      
        populator.setSqlScriptEncoding("UTF-8"); 
        populator.execute(dataSource);
    }
}
