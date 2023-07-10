package mikhail.shell.ems.dao;

import java.util.List;
import lombok.Getter;
import mikhail.shell.ems.models.AbstractTask;
import mikhail.shell.ems.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO<T extends AbstractTask> {
    
    
    @Getter protected final JdbcTemplate jdbc;
    public final static String URL = "jdbc:mysql://localhost:3306/ems",
            USER = "root", PASSWORD = "", DB = "ems";
    @Autowired
    public AbstractDAO(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }
    public abstract List<T> getAll();
    public abstract AbstractTask getOne(long id);
    public abstract void create(T absTask);
    public abstract void edit(T absTask);
    public abstract void remove(long id);
}
