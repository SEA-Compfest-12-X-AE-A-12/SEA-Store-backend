package com.compfest.sea.delivery.category;

import com.compfest.sea.usecase.category.CategoryUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryDeliveryHttp implements CategoryDelivery {

  private final CategoryUsecase categoryUsecase;

  @Autowired
  public CategoryDeliveryHttp(@Qualifier("categoryUsecase1") CategoryUsecase categoryUsecase) {
    this.categoryUsecase = categoryUsecase;
  }

  @Override
  @GetMapping("/")
  public List<String> getAll() {
    return categoryUsecase.getAll();
  }
}
