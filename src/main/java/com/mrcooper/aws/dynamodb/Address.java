package com.mrcooper.aws.dynamodb;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@Data
@DynamoDBDocument
public class Address {

    @DynamoDBAttribute private String doorNo;
    @DynamoDBAttribute private String state;
}
