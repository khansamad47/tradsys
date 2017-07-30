package tradsys;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.gdax.GDAXExchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		printTicks(10);
	}
	public static void printTicks(int secs) {
		/* This is a test function.
		 * It will print ETH/USD
		 * tick once per second from GDAX for 'secs' seconds
		 *
		 */
		System.out.println("Start");
		Exchange gdax = ExchangeFactory.INSTANCE.createExchange(
            GDAXExchange.class.getName()
        );

		MarketDataService marketDataService = gdax.getMarketDataService();
		Ticker ticker = null;
		for(int i =0; i != secs; ++i) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ticker = marketDataService.getTicker(CurrencyPair.ETH_USD);
			} catch (NotAvailableFromExchangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotYetImplementedForExchangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExchangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ticker.toString());
		}
		System.out.println("Stop");
    }
}
