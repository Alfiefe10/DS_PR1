package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

public class PR1Stack {

    // Se cambia la capacidad a 15, ya que ahora buscamos los 15 primeros valores de la función periódica "f(x) = (x mod 4)^2"
    public final int CAPACITY = 15;

    // Ahora el tipo de datos que utiliza la implementación son enteros, en vez de carácteres
    private Stack<Integer> stack;

    public PR1Stack() {
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<>(CAPACITY);
    }

    public Stack<Integer> getStack() {
        return this.stack;
    }

    public void push(Integer c) {
        this.stack.push(c);
    }

    public Integer pop() {
        return this.stack.pop();
    }
}
