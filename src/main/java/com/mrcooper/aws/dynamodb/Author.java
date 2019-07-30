package com.mrcooper.aws.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@Data
@DynamoDBDocument
public class Author {

    @DynamoDBAttribute private String authorId;
    @DynamoDBAttribute private String authorName;
}
