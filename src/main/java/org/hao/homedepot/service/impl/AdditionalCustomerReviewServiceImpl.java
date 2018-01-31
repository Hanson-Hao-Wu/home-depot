package org.hao.homedepot.service.impl;

import de.hybris.platform.customerreview.CustomerReviewService;
import de.hybris.platform.customerreview.jalo.CustomerReview;
import de.hybris.platform.customerreview.jalo.CustomerReviewManager;
import org.hao.homedepot.constant.ExceptionConstant;
import org.hao.homedepot.exception.HomeDepotException;
import org.hao.homedepot.model.CustomerReviewModel;
import org.hao.homedepot.model.ProductModel;
import org.hao.homedepot.model.UserModel;
import org.hao.homedepot.service.AdditionalCustomerReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class AdditionalCustomerReviewServiceImpl implements AdditionalCustomerReviewService {

    @Autowired
    UtilityService utilityService;

    CustomerReviewService customerReviewService;

    Logger logger = LoggerFactory.getLogger(AdditionalCustomerReviewServiceImpl.class);


    @Override
    public int getCustomerReviewsBetween(ProductModel paramProductModel, double min, double max) {

        List<CustomerReviewModel> customerReviewList = (List<CustomerReviewModel>) this.customerReviewService.getReviewsForProduct(paramProductModel);

        int targetAmount = 0;

        for (CustomerReviewModel customerReview : customerReviewList) {
            Double rating = customerReview.getRating();
            if (rating <= max && rating >= min) {
                targetAmount++;
            }
        }

        return targetAmount;
    }

    @Override
    @ExceptionHandler({HomeDepotException.class})
    public CustomerReviewModel addCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product) {

        if (rating < 0) {
            throw new HomeDepotException(ExceptionConstant.RATE_LESS_THAN_0_EXCEPTION);
        }
        if (utilityService.isHaveCurseWords(comment)) {
            throw new HomeDepotException(ExceptionConstant.HAVE_CURSE_WORDS_EXCEPTION);
        }

        CustomerReview review = CustomerReviewManager.getInstance().createCustomerReview(rating, headline, comment,
                (User) getModelService().getSource(user), (Product) getModelService().getSource(product));

        return (CustomerReviewModel) getModelService().get(review);

    }
}
