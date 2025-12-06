package org.example.model;

import java.util.List;

public class ExchangeTable {
    private String table;
    private String no;
    private String effectiveDate;
    private List<org.example.model.Rate> rates;

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<org.example.model.Rate> getRates() {
        return rates;
    }
}
