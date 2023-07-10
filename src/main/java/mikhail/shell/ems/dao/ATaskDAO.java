package mikhail.shell.ems.dao;

import java.util.ArrayList;
import java.util.List;
import mikhail.shell.ems.models.ATask;
import mikhail.shell.ems.models.AbstractTask;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ATaskDAO extends AbstractDAO<ATask>{
    private final List<ATask> aTasks = new ArrayList<ATask>();
    {
        for (int i = 0; i< 10; i++)
            aTasks.add(new ATask(false,aTasks.size(), "Some task " + aTasks.size()));
    }
    public ATaskDAO(JdbcTemplate jdbc)
    {
        super(jdbc);
    }

    @Override
    public List<ATask> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ATask getOne(long id) {
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
