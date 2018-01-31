package org.hao.homedepot.service.impl;

import org.hao.homedepot.constant.ExceptionConstant;
import org.hao.homedepot.exception.HomeDepotException;
import org.hao.homedepot.model.CustomerReviewModel;
import org.hao.homedepot.model.ProductModel;
import org.hao.homedepot.model.UserModel;
import org.hao.homedepot.service.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class CustomerReviewServiceImpl implements CustomerReviewService {

	@Autowired
	UtilityService utilityService;


	@Override
	public int getCustomerReviewsBetween(double min, double max) {
		return 0;
	}

	@Override
	@ExceptionHandler({HomeDepotException.class})
	public CustomerReviewModel addCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product) {

		if(rating < 0) {
			throw new HomeDepotException(ExceptionConstant.RATE_LESS_THAN_0_EXCEPTION);
		}
		if(utilityService.isHaveCurseWords( comment ) ) {
			throw new HomeDepotException(ExceptionConstant.HAVE_CURSE_WORDS_EXCEPTION);
		}

		CustomerReview review = CustomerReviewManager.getInstance().createCustomerReview(rating, headline, comment, 
				(User)getModelService().getSource(user), (Product)getModelService().getSource(product));
		
		return (CustomerReviewModel)getModelService().get(review);

	}
}
