package com.antra.microservices_quote.controller;

import com.antra.microservices_quote.entity.Quote;
import com.antra.microservices_quote.entity.Quotes;
import com.antra.microservices_quote.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/quote")
public class QuotesController {
    @Autowired
    private QuotesRepository quotesRepository;

    QuotesController(QuotesRepository quotesRepository){
        this.quotesRepository = quotesRepository;
    }

    @RequestMapping(value="/get/{username}", method= RequestMethod.GET)
    public List<String> getQuotes(@PathVariable("username") final String username){
        return getQuotesByUsername(username);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public List<String> add(@RequestBody final Quotes quotes){
        quotes.getQuotes().stream().map(quote->new Quote(quotes.getUserName(),quote)).forEach(quote->{
            quotesRepository.save(quote);
        });
        return getQuotesByUsername(quotes.getUserName());
    }

    @RequestMapping(value = "/delete/{username}",method = RequestMethod.DELETE)
    public List<String> delete(@PathVariable("username") final String username){
        List<Quote> list = quotesRepository.findByUserName(username);
        list.stream().forEach(quote -> quotesRepository.delete(quote));
        return getQuotesByUsername(username);
    }

    /**
     * @param username
     * @return
     */
    private List<String> getQuotesByUsername(@PathVariable("username") String username) {
        return quotesRepository.findByUserName(username).stream().map(Quote::getQuote).collect(Collectors.toList());
    }
}
