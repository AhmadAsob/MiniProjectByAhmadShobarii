package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Floor")
    private int floor;

    @Column(name = "Isle")
    private String isle;

    @Column(name = "Bay")
    private String bay;

    public Category(String name, int floor, String isle, String bay) {
        this.name = name;
        this.floor = floor;
        this.isle = isle;
        this.bay = bay;
    }
}
