package mikhail.shell.ems.dao;

import java.util.List;
import lombok.Getter;
import mikhail.shell.ems.models.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("Singleton")
public abstract class AbstractDAO<T extends AbstractTask> {
    
    @Getter protected final JdbcTemplate jdbc;
    public final static String URL = "jdbc:mysql://localhost:3306/ems",
            USER = "root", PASSWORD = "", DB = "ems";
    @Autowired
    public AbstractDAO(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }
    public abstract List<T> getAll(int id);
    public abstract T getOne(int id);
    public abstract void create(T absTask);
    public abstract void edit(T absTask);
    public abstract void remove(long id);
}
