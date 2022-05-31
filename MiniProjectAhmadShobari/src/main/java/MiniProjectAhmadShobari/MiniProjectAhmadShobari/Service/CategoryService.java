package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepositories categoryRepositories;

    @Autowired
    public CategoryService(CategoryRepositories categoryRepositories){this.categoryRepositories = categoryRepositories;}

    public List<CategoryDto> findAllCategory(){
        return CategoryDto.toList(categoryRepositories.findAll());
    }

    public List<CategoryDto> insertCategory(CategoryInsertDto newCategory){
        Category category = newCategory.convertCategory();
        categoryRepositories.save(category);
        return CategoryDto.toList(categoryRepositories.findAll());
    }

    public boolean updateCategory (String name, CategoryUpdateDto categoryUpdateDto){
        boolean result = false;
        Category oldCategory = categoryRepositories.getById(name);

        oldCategory.setFloor(categoryUpdateDto.getFloor());
        oldCategory.setIsle(categoryUpdateDto.getIsle());
        oldCategory.setBay(categoryUpdateDto.getBay());

        categoryRepositories.save(oldCategory);

        return true;
    }

    public boolean deleteCategoryByName (String name){
        categoryRepositories.deleteById(name);
        return true;
    }

    public List<CategoryDto> findAllCategoryByName (String name){
        return CategoryDto.toList(categoryRepositories.getName(name));
    }
}
