package springbase.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class People {
    private int id;
    @NotBlank(message = "You must type name")
    @Size(min = 1, max = 150, message = "Name must be in 1-150 characters")
    private String name;
    @Min(value = 0, message = "Incorrect age")
    @Max(value = 200, message = "Incorrect age")
    private int age;

    public People() {
    }

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
