package com.mrcooper.aws.dynamodb;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired private BookRepository bookRepository;
    @Autowired private AmazonDynamoDB amazonDynamoDB;

    @PostMapping
    public void save(@RequestBody Book book){
        bookRepository.save(book);
    }

    @GetMapping
    public List<Book> fetchAll(@RequestBody Book book){
        return (List<Book>) bookRepository.findAll();
    }

    @DeleteMapping
    public void deleteAll(){
        bookRepository.deleteAll((List<Book>) bookRepository.findAll());
    }


   // @PostConstruct
    public void createTable(){
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Book.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
    }

}
