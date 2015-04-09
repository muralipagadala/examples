package com.thread.examples.agd.pcj.nav;

import java.util.Map;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class SequentialNAV extends AbstractNAV {
  public double computeNetAssetValue(final Map<String, Integer> stocks) throws Exception {
    double netAssetValue = 0.0;
    for(String ticker : stocks.keySet()) {
      netAssetValue += stocks.get(ticker) * YahooFinance.getPrice(ticker);
    }
    return netAssetValue;
  }

  public static void main(final String[] args)throws Exception {
    new SequentialNAV().timeAndComputeValue();
  }
}