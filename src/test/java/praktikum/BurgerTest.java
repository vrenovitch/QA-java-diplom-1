package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;

    @Mock
    Ingredient secondIngredientMock;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMock() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(secondIngredientMock, burger.ingredients.get(0));
        Assert.assertEquals(ingredientMock, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bunMock.getPrice()).thenReturn(1f);
        burger.setBuns(bunMock);
        Assert.assertEquals(2f, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bunMock.getName()).thenReturn("Тестовая булка");
        Mockito.when(ingredientMock.getName()).thenReturn("Тестовый ингредиент");
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        String expected = "(==== Тестовая булка ====)\n" +
                "= filling Тестовый ингредиент =\n" +
                "(==== Тестовая булка ====)\n\n" +
                "Price: 0,000000\n";

        Assert.assertEquals(expected, burger.getReceipt());
    }
}
