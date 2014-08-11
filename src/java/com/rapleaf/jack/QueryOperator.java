package com.rapleaf.jack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class QueryOperator<T> implements IQueryOperator<T> {

  private final List<T> parameters;

  public QueryOperator(T parameter) {
    this.parameters = new ArrayList<T>();
    this.parameters.add(parameter);
  }

  public QueryOperator(T param1, T param2) {
    this.parameters = new ArrayList<T>();
    this.parameters.add(param1);
    this.parameters.add(param2);
  }

  public QueryOperator(T param1, T... otherParam) {
    this.parameters = new ArrayList<T>();
    this.parameters.add(param1);
    this.parameters.addAll(Arrays.asList(otherParam));
  }

  public List<T> getParameters() {
    return parameters;
  }

  /*
  Return the first parameter.
  Useful for operators with only one parameter.
   */
  public T getSingleParameter() {
    return parameters.get(0);
  }

  /*
  Check that none of the parameters is null.
  Throw an IllegalArgumentException if a null parameter is found.
   */
  public void ensureNoNullParameter() {
    for (T parameter : parameters) {
      if (parameter == null) {
        throw new IllegalArgumentException("You cannot pass null parameters.");
      }
    }
  }
}
