package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(IndexController.class)
public class IndexControllerTest {

    WebTestClient webTestClient;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Autowired
    IndexController controller;

    @Before
    public void setUp() throws Exception {
        webTestClient = WebTestClient.bindToController().build();
    }

    @Test
    public void testGetRecipes() throws Exception {
        when(recipeService.getRecipes()).thenReturn(Flux.empty());

        webTestClient.get().uri("/").exchange().expectStatus().isOk().expectBody();
    }

    @Test
    public void getIndexPage() throws Exception {
//
//        //given
//        Set<Recipe> recipes = new HashSet<>();
//        recipes.add(new Recipe());
//
//        Recipe recipe = new Recipe();
//        recipe.setId("1");
//
//        recipes.add(recipe);
//
//        when(recipeService.getRecipes()).thenReturn(recipes);
//
//        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
//
//        //when
//        String viewName = controller.getIndexPage(model);
//
//
//        //then
//        assertEquals("index", viewName);
//        verify(recipeService, times(1)).getRecipes();
//        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
//        Set<Recipe> setInController = argumentCaptor.getValue();
//        assertEquals(2, setInController.size());
    }

}