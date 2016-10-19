package com.epam.bookshop.shopping.view.controller;

import java.util.Collections;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookshop.shopping.view.model.BookShoppingCartItem;
import com.epam.bookshop.shopping.view.model.ShoppingCart;
import com.epam.bookshop.shopping.view.model.ShowShoppingCartModel;

@Test
@WebAppConfiguration
@ContextConfiguration
public class ClearShoppingCartControllerIntegrationTest {

	@Autowired
	@SuppressWarnings("unused")
    private WebApplicationContext webappContext;
    private MockMvc mockMvc;
    private MockHttpSession mockSession;

    @BeforeMethod
    public void setUp() {
        mockSession = new MockHttpSession();
        mockMvc = MockMvcBuilders.standaloneSetup(new ClearShoppingCartController()).build();
    }

    @Test
    public void testAddToCartShouldReturnToShoppingPage() throws Exception {
        // GIVEN in setup
        // WHEN
        ResultActions performedRequest = mockMvc.perform(MockMvcRequestBuilders.get(ClearShoppingCartController.REQUEST_MAPPING).session(mockSession));
        // THEN
        performedRequest.andExpect(MockMvcResultMatchers.status().isOk());
        performedRequest.andExpect(MockMvcResultMatchers.view().name("shopping_cart"));

        ShowShoppingCartModel expectedModel = new ShowShoppingCartModel(Collections.<BookShoppingCartItem> emptyList(),
                ClearShoppingCartController.REQUEST_MAPPING);
        performedRequest.andExpect(MockMvcResultMatchers.model().attribute("shoppingCartModel", Matchers.equalTo(expectedModel)));

        ShoppingCart cartInSession = (ShoppingCart) mockSession.getAttribute(ShoppingCart.SHOPPING_CART_KEY);
        MatcherAssert.assertThat(cartInSession, Matchers.equalTo(cartInSession));
    }
}
