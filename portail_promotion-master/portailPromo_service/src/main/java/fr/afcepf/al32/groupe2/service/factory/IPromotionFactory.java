package fr.afcepf.al32.groupe2.service.factory;

import java.time.Duration;

public interface IPromotionFactory {

	IPromotionFactory setNamePromotion(String name);
	IPromotionFactory setDescriptionPromotion(String description);
	IPromotionFactory setLimitTimePromotion(Duration limitTimePromotion);
	IPromotionFactory setLimitTimeTakePromotion(Duration limitTimeTakePromotion);
	IPromotionFactory setQuantityInitAvailable(Double quantityInitAvailable);
	IPromotionFactory setIsCumulative(Boolean isCumulative);
	//TODO getTypePromotion New Ajout N_gon (AL33) factory à implémenter et tester
	IPromotionFactory getTypePromotion(String promotionType);
}
