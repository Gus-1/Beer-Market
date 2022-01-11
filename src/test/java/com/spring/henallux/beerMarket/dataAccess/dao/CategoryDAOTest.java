package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDAO;
import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.LanguageEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryId;
import com.spring.henallux.beerMarket.dataAccess.repository.CategoryRepository;
import com.spring.henallux.beerMarket.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.CategoryTranslation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryDAOTest {
    private CategoryDAO categoryDAO;

    @Mock
    private CategoryTranslationRepository categoryRepository;

    @Before
    public void setUp(){
        categoryDAO = new CategoryDAO(new ProviderConverter() ,categoryRepository);
    }

    @Test
    public void getAllCategories(){
        ArrayList<TranslationCategoryEntity> categoryEntities = new ArrayList<>();
        categoryEntities.add(new TranslationCategoryEntity(
                new TranslationCategoryId(
                        new CategoryEntity(1), new LanguageEntity(1, "fr")
                ), "Brune"
            )
        );
        categoryEntities.add(new TranslationCategoryEntity(
                        new TranslationCategoryId(
                                new CategoryEntity(2), new LanguageEntity(1, "fr")
                        ), "Blonde"
                )
        );
        categoryEntities.add(new TranslationCategoryEntity(
                        new TranslationCategoryId(
                                new CategoryEntity(3), new LanguageEntity(1, "fr")
                        ), "Rouge"
                )
        );
        categoryEntities.add(new TranslationCategoryEntity(
                        new TranslationCategoryId(
                                new CategoryEntity(4), new LanguageEntity(1, "fr")
                        ), "Ambrée"
                )
        );
        categoryEntities.add(new TranslationCategoryEntity(
                        new TranslationCategoryId(
                                new CategoryEntity(5), new LanguageEntity(1, "fr")
                        ), "Noir"
                )
        );

        when(categoryRepository.findAllByTranslationCategoryId_LanguageEntity_LanguageName("fr")).thenReturn(categoryEntities);


        ArrayList<CategoryTranslation> categories = new ArrayList<>();
        categories.add(new CategoryTranslation(1,null,"Brune"));
        categories.add(new CategoryTranslation(2,null,"Blonde"));
        categories.add(new CategoryTranslation(3,null,"Rouge"));
        categories.add(new CategoryTranslation(4,null,"Ambrée"));
        categories.add(new CategoryTranslation(5,null,"Noir"));

        ArrayList<CategoryTranslation> allCategories =  categoryDAO.getAllCategories();

        assertThat(allCategories).isEqualTo(categories);
    }
}
