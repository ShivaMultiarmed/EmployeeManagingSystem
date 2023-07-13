package mikhail.shell.ems.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;

@Entity
@Getter @Setter 
public class Employee {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE)
    private int id;
    
    private String name, surname, position;
    
    @Column (name = "departmentid")
    private short departmentId;
    
    private byte age;
    
    public Employee () {}
    
    public void setId(int id)
    {
        if(this.id == 0)
            this.id = id;
    }
}
