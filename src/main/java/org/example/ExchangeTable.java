package org.example;

import java.util.List;

public class ExchangeTable {
    private String table;
    private String no;
    private String effectiveDate;
    private List<org.example.Rate> rates;

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<org.example.Rate> getRates() {
        return rates;
    }
}
