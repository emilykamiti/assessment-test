package com.resale.app.bean;

import java.io.Serializable;
import java.util.List;

import com.resale.app.model.entity.Bid;

public interface BidBeanI extends Serializable {

    boolean submitBid(Bid bid);

    List<Bid> getAllBids();


}
