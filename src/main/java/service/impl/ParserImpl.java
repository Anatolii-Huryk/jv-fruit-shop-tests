package service.impl;

import model.TransactionDto;
import service.Parser;
import service.Validator;

public class ParserImpl implements Parser {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_PRODUCT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATOR = ",";
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLineToTransaction(String line) {
        validator.validate(line);
        String[] values = line.split(SEPARATOR);
        String operation = values[INDEX_OF_OPERATION];
        String fruitName = values[INDEX_OF_PRODUCT];
        int quantity = Integer.parseInt(values[INDEX_OF_QUANTITY]);
        return new TransactionDto(operation, fruitName, quantity);
    }
}
