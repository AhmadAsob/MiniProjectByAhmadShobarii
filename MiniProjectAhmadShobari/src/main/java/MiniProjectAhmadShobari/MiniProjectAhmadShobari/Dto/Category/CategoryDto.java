package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CategoryDto {

    private final String name;
    private final int floor;
    private final String isle;
    private final String bay;

    public static List<CategoryDto> toList(List<Category> categories){
        List<CategoryDto> result = new ArrayList<>();

        for (Category category : categories){
            result.add(new CategoryDto(category.getName(), category.getFloor(), category.getIsle(), category.getBay()));
        }
        return result;
    }

}
