package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Controller;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Category.CategoryUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){this.categoryService = categoryService;}

    @GetMapping("find-all")
    public List<CategoryDto> findAllDto(){
        return categoryService.findAllCategory();
    }

    @PostMapping("insert")
    public ResponseEntity<List<CategoryDto>> insertCategory(@RequestBody CategoryInsertDto newCategory){
        return ResponseEntity.ok().body(
                categoryService.insertCategory(newCategory));
    }

    @PutMapping("{name}")
    public boolean updateCategory(@PathVariable String name, @RequestBody CategoryUpdateDto categoryUpdateDto){
        return categoryService.updateCategory(name, categoryUpdateDto);
    }

    @DeleteMapping("{name}")
    public boolean deleteCategory(@PathVariable String name){
        return categoryService.deleteCategoryByName(name);
    }

    @GetMapping("name")
    public List<CategoryDto> findAllCategoryByName (@RequestParam String name){
        return categoryService.findAllCategoryByName(name);
    }
}
