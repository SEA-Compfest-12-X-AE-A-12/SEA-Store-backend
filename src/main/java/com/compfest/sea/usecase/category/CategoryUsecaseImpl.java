package com.compfest.sea.usecase.category;

import com.compfest.sea.entity.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("categoryUsecase1")
public class CategoryUsecaseImpl implements CategoryUsecase {
    @Override
    public List<String> getAll() {
        return Stream.of(Category.values()).map(Enum::name).collect(Collectors.toList());
    }
}
