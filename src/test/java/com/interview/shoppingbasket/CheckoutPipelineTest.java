package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

    @Mock
    CheckoutContext checkoutContext;

    PricingService pricingService;

    @BeforeEach
    void setup() {
    	pricingService = Mockito.mock(PricingService.class);
    	checkoutContext = Mockito.mock(CheckoutContext.class);
        checkoutPipeline = new CheckoutPipeline();
        basket = new Basket();

        when(checkoutContext.getBasket()).thenReturn(basket);
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        // Exercise - implement testing passing through all checkout steps

        basket.add("productCode", "myproduct", 10);

        Promotion promotion = new Promotion();
        //50%
        promotion.setDiscount(50);

        // different discounts
        //10%
        //promotion.setDiscount(10);
        //2 items for the price of 1
        //promotion.setExtraItem(true);

        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        basket.getItems().get(0).setProductRetailPrice(retailPriceCheckoutStep.applyPromotion(promotion, basket.getItems().get(0), 100));

        assertEquals(basket.getItems().get(0).getProductRetailPrice(), 500.0);
    }

}
