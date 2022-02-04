package ElementsOfProgrammingInterview.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StackMax {

    static class MaxElement {
        private final Integer element;
        private final Integer max;

        MaxElement(Integer element, Integer max) {
            this.element = element;
            this.max = max;
        }

        public Integer getMax() {
            return this.max;
        }

        public Integer getElement() {
            return this.element;
        }

    }

    private final Deque<MaxElement> queue;
    StackMax() {
        this.queue = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Integer peek() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        return queue.peek().getElement();
    }

    public Integer pop() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        return queue.pop().getElement();
    }

    public Integer getMax() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        return queue.peek().getMax();
    }

    public void push(Integer x) {
        queue.push(new MaxElement(x, this.isEmpty() ? x : Math.max(x, this.getMax())));
    }
}
