package mikhail.shell.ems.config;

import java.nio.charset.Charset;
import java.util.List;
import javax.sql.DataSource;
import mikhail.shell.ems.dao.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("mikhail.shell.ems")
@EnableWebMvc 
public class AppConfig implements WebMvcConfigurer {
    private final ApplicationContext appContext;
    public AppConfig(ApplicationContext context)
    {
        this.appContext = context;
        System.out.println("Context is created " + context);
    }
    /*
    @Bean
    public SpringResourceTemplateResolver templateResolver()
    {
        SpringResourceTemplateResolver resolver = 
                new SpringResourceTemplateResolver();
        resolver.setApplicationContext(appContext);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine tplEngine = 
                new SpringTemplateEngine();
        tplEngine.setTemplateResolver(templateResolver());
        tplEngine.setEnableSpringELCompiler(true);
        return tplEngine;
    }
   
     @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        ThymeleafViewResolver resolver = 
                new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }*/
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }
    
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(AbstractDAO.URL);
        ds.setUsername(AbstractDAO.USER);
        ds.setPassword(AbstractDAO.PASSWORD);
        //ds.setSchema(AbstractDAO.DB);
        
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }
    /*@Bean
    public SessionFactory appSessionFactory()
    {
        SessionFactory sf = null;
        StandardServiceRegistry registry = 
                new StandardServiceRegistryBuilder().
                configure().build();
        System.out.println(registry);
        
        try
        {
             sf = new MetadataSources(registry).
                buildMetadata().buildSessionFactory();
             System.out.println(sf);
        }
        catch (Exception ex)
        {
            StandardServiceRegistryBuilder.destroy(registry);
           ex.printStackTrace(System.out);
        }
        
        sf.setDataSource(dataSource());
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        sf.setHibernateProperties(props);
        return sf;
    }*/
}
