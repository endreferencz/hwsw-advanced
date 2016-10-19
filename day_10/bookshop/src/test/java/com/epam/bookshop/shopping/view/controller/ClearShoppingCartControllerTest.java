package com.epam.bookshop.shopping.view.controller;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookshop.shopping.view.model.ShoppingCart;
import com.epam.bookshop.shopping.view.model.ShowShoppingCartModel;

public class ClearShoppingCartControllerTest {
    private ClearShoppingCartController underTest;

    @Mock
    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new ClearShoppingCartController();
    }

    @Test
    public void testAddToCartShouldReturnProperSuccessView() {
        // GIVEN in setup
        // WHEN
        String result = underTest.addToCart();
        // THEN
        Assert.assertEquals(result, "shopping_cart");
    }

    @Test
    public void testCreateShoppingCartModelShouldReturnProperSuccessView() {
        // GIVEN in setup
        // WHEN
        ShowShoppingCartModel result = underTest.createShoppingCartModel(shoppingCart);
        // THEN
        Mockito.verify(shoppingCart).clear();

        Assert.assertEquals(result.getClearShoppingCartUrl(), ClearShoppingCartController.REQUEST_MAPPING);
    }

}
