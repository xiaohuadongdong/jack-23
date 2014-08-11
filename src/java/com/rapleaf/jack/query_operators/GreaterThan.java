package com.rapleaf.jack.query_operators;

import com.rapleaf.jack.QueryOperator;

public class GreaterThan<N extends Comparable<N>> extends QueryOperator<N> {

  public GreaterThan(N value) {
    super(value);
    ensureNoNullParameter();
  }

  @Override
  public String getSqlStatement() {
    return " > ? ";
  }

  @Override
  public boolean apply(N value) {
    return value.compareTo(getSingleParameter()) > 0;
  }
}
