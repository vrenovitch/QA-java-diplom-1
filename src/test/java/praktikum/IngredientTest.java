package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Тестовый соус", 228.0f},
                {IngredientType.SAUCE, "", 0f},
                {IngredientType.FILLING, "Тестовый наполнитель", 1337.0f},
                {IngredientType.FILLING, "", 0f}
        };
    }

    @Test
    public void testGetType() {
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }
}