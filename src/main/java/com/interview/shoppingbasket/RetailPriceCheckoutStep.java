package com.interview.shoppingbasket;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            basketItem.setProductRetailPrice(price);
            retailTotal += quantity*price;
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        /*
         * Implement applyPromotion method
         */

    	if (promotion.getDiscount() == 50) {
    		price = price * 0.5;
    	}
    	if (promotion.getDiscount() == 10) {
    		price = price * 0.9;
    	}
    	if (promotion.getExtraItem() == true) {
    		item.setQuantity(item.getQuantity() + 1);
    	}

    	retailTotal = item.getQuantity() * price;

    	return retailTotal;
    }
}
