package com.lobster.presenter.rest.controller.category;

import com.lobster.dto.category.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/classification/category")
@Validated
public class CategoryController {

    @GetMapping("/hello")
    public ResponseEntity<CategoryDto> hello() {
        return new ResponseEntity<>(new CategoryDto(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }
}
