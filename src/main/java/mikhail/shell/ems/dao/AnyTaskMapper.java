package mikhail.shell.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import mikhail.shell.ems.models.AbstractTask;
import mikhail.shell.ems.models.Project;
import org.springframework.jdbc.core.RowMapper;

public class AnyTaskMapper<T extends AbstractTask>
        implements RowMapper<AbstractTask> {
    @Override
    public AbstractTask mapRow(ResultSet set, int i) throws SQLException {
        AbstractTask p = new Project();
        p.setId(set.getLong("id"));
        p.setTitle(set.getString("title"));
        p.setDescription(set.getString("description"));
        return p;
    }
}
