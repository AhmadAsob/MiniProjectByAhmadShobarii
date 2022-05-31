package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class CategoryInsertDto {

    private String name;
    private int floor;
    private String isle;
    private String bay;

    public Category convertCategory(){
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return new Category(
                name,
                floor,
                isle,
                bay);
    }
}
