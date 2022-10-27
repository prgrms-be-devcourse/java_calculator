package com.programmers.cal.engine.validator;

import java.util.regex.Pattern;

public class ExpressionValidator implements Validator {

    private static final Pattern pattern = Pattern.compile("^(-?[0-9]+[+\\-*/])+(-?[0-9]+)");

    @Override
    public boolean isExpression(String inputString) {
        String noSpaceExpression = inputString.replaceAll("\\p{Z}", "");
        return pattern.matcher(noSpaceExpression).matches();
    }
}
