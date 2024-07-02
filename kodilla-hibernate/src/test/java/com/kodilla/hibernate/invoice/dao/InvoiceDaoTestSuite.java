package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @BeforeEach
    void setUp() {
        // Cleanup database before each test
        itemDao.deleteAll();
        invoiceDao.deleteAll();
        productDao.deleteAll();
    }

    @Test
    void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal("100"), 1, new BigDecimal("100"));
        Item item2 = new Item(product2, new BigDecimal("200"), 2, new BigDecimal("400"));

        Invoice invoice = new Invoice("001/2024");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);

        // Then
        int id = invoice.getId();
        Invoice readInvoice = invoiceDao.findById(id).orElse(null);
        assertThat(readInvoice).isNotNull();
        assertThat(readInvoice.getItems()).hasSize(2);

        Item readItem1 = readInvoice.getItems().get(0);
        Item readItem2 = readInvoice.getItems().get(1);

        assertThat(readItem1.getProduct().getName()).isEqualTo("Product 1");
        assertThat(readItem1.getPrice()).isEqualTo(new BigDecimal("100"));
        assertThat(readItem1.getQuantity()).isEqualTo(1);
        assertThat(readItem1.getValue()).isEqualTo(new BigDecimal("100"));

        assertThat(readItem2.getProduct().getName()).isEqualTo("Product 2");
        assertThat(readItem2.getPrice()).isEqualTo(new BigDecimal("200"));
        assertThat(readItem2.getQuantity()).isEqualTo(2);
        assertThat(readItem2.getValue()).isEqualTo(new BigDecimal("400"));

        // CleanUp
        invoiceDao.deleteById(id);
        productDao.deleteAll();
        itemDao.deleteAll();
    }
}
