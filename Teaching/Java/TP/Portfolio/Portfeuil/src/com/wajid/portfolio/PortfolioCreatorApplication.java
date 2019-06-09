package com.wajid.portfolio;

import com.wajid.portfolio.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PortfolioCreatorApplication implements CommandLineRunner {

    @Autowired
    TransactionRepository tr;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioCreatorApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//
//        TransactionEntry te = new TransactionEntry();
//        te.setStockName("SBI");
//        te.setStockPrice(300.0);
//        te.setStockQuantity(10L);
//        te.setTransactionType("BUY");
//
//        tr.save(te);
    }
}
