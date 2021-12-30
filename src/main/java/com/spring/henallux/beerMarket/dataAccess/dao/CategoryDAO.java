package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.repository.CategoryRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Category;
import com.spring.henallux.beerMarket.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess{

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }


    /*@Override
    public ArrayList<CategoryTranslation> getAllCategories() {
        categoryRepository.findTranslationCategoryEntitiesByLanguageId(LocaleContextHolder.getLocale().getLanguage())
                .stream()
                .map(translationCategoryEntity -> providerConverter.categoryEntityToCategoryModel(translationCategoryEntity.getCategoryId()))
                .collect(Collectors.toCollection(ArrayList::new));
        return null;
    }*/
}
