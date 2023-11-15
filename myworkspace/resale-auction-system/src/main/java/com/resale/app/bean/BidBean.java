package com.resale.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.resale.app.model.entity.Bid;

public class BidBean {
    public boolean submitBid(Bid bid) {
        return true;
    }

    public List<Bid> getAllBids() {
        return new ArrayList<>();
    }

    public void addOrUpdateBid(Bid newBid) {
    }
}
