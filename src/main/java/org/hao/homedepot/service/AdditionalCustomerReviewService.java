package org.hao.homedepot.service;

import org.hao.homedepot.model.CustomerReviewModel;
import org.hao.homedepot.model.ProductModel;
import org.hao.homedepot.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface AdditionalCustomerReviewService {

    int getCustomerReviewsBetween(ProductModel paramProductModel, double min, double max);

    CustomerReviewModel addCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product);

}