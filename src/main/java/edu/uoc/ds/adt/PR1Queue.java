package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class PR1Queue {

    // Se cambia la capacidad a 15, ya que ahora buscamos los 15 primeros valores de la función periódica "f(x) = (x mod 4)^2"
    public final int CAPACITY = 15;

    // Ahora el tipo de datos que utiliza la implementación son enteros, en vez de carácteres
    private Queue<Integer> queue;

    public PR1Queue() {
        newQueue();
    }

    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<Integer> getQueue() {
        return this.queue;
    }

    public void add(Integer c) {
        this.queue.add(c);
    }

    public Integer poll() {
        return this.queue.poll();
    }
}
