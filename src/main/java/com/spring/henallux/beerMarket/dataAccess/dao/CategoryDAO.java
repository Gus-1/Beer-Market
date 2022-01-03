package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.CategoryRepository;
import com.spring.henallux.beerMarket.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Category;
import com.spring.henallux.beerMarket.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess{

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;
    private CategoryTranslationRepository categoryTranslationRepository;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter, CategoryTranslationRepository categoryTranslationRepository){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
        this.categoryTranslationRepository = categoryTranslationRepository;
    }


    public ArrayList<CategoryTranslation> getAllCategories() {
        return categoryTranslationRepository.findAllByTranslationCategoryId_LanguageEntity_LanguageName("french"/*LocaleContextHolder.getLocale().getLanguage()*/)
                .stream().map(translationCategoryEntity -> providerConverter.translationCategoryEntityToCategoryTranslation(translationCategoryEntity))
                .collect(Collectors.toCollection(ArrayList :: new));

        //return new ArrayList<TranslationCategoryEntity>(categoryTranslationRepository.findAllByTranslationCategoryId_LanguageEntity_LanguageName(language));
    }
}
