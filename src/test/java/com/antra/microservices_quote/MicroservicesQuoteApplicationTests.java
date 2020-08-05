package com.antra.microservices_quote;

import com.antra.microservices_quote.repository.QuotesRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = MicroservicesQuoteApplication.class)
class MicroservicesQuoteApplicationTests {

    @Autowired
    private QuotesRepository quotesRepository;

    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }


}
