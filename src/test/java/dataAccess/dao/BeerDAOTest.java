package dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDAO;
import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Beer;
import com.spring.henallux.beerMarket.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BeerDAOTest {
    private BeerDAO beerDataAccess;

    @Mock
    private BeerRepository beerRepository;

    @Before
    public void setUp(){
        beerDataAccess = new BeerDAO(beerRepository, new ProviderConverter());
    }

    @Test
    public void getBeerById(){
        BeerEntity beerEntity = new BeerEntity(1, "Asahi", "Bière numéro un au Japon, Asahi Super Dry est issue d'une sélection des meilleurs ingrédients." +
                " La technologie de filtration sur céramique fait de Asahi une bière sèche en bouche qui lui procure une qualité désaltérante non égalée",
                5.0, "Malté et houblonné", "Asahi Brewers", "Japon", "/images/beers/Asahi.jpg", 2.7,
                new CategoryEntity(2));

        when(beerRepository.findBeerEntityByBeerId(1)).thenReturn(beerEntity);

        Beer beer = new Beer(1, "Asahi", "Bière numéro un au Japon, Asahi Super Dry est issue d'une sélection des meilleurs ingrédients." +
                " La technologie de filtration sur céramique fait de Asahi une bière sèche en bouche qui lui procure une qualité désaltérante non égalée",
                2.7, "Malté et houblonné", "Asahi Brewers", "Japon", "/images/beers/Asahi.jpg", 5.0,
                new Category(2));

        Beer beer1 = beerDataAccess.getBeerById(1);
        assertThat(beerDataAccess.getBeerById(1)).isEqualTo(beer);
    }
}
