package com.programmers.java.engine.repository;

import com.programmers.java.engine.model.Expression;

import java.util.List;

public interface History {
    void save(Expression expression);

    List<Expression> load();

    void clear();
}
