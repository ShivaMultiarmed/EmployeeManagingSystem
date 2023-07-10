package mikhail.shell.ems.models;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter private int id;
    @Getter @Setter private String name, surname, position, department;
    @Getter @Setter private byte age;
    public Employee () {}
}
