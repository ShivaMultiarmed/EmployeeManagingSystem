package mikhail.shell.ems.dao;

import java.util.List;
import mikhail.shell.ems.models.ATask;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TaskDAO extends AbstractDAO<ATask>{
    
    public TaskDAO(JdbcTemplate jdbc)
    {
        super(jdbc);
    }

    @Override
    public List<ATask> getAll(int listId) {
        String sql = "SELECT * FROM `tasks` WHERE `tasklistid` = ?;";
        List<ATask> tasks = getJdbc().query(sql, new String[]{listId+""},
                new BeanPropertyRowMapper(ATask.class));
        return tasks;
    }

    @Override
    public ATask getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(ATask task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(ATask task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(long l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
