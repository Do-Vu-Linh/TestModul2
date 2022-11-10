package testmodul2;

import java.io.Serializable;

public class Gender implements Serializable {
    private String name;

    public Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
