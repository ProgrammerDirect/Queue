import org.apache.log4j.Logger;

public class QueueImpl<E> implements Queue<E>{
    final static Logger logger = Logger.getLogger(QueueImpl.class);

    private E[] data;
    private int p;

    public QueueImpl(int len) {
        // TO-DO
        this.data = (E[])new Object[len];
        this.p = 0;
        logger.info("nova cua de " + len+" elements");

    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        logger.info("pre: 'push' nou element "+ e);
        if (isFull()) {
            logger.error("Cua plena");
            throw new FullQueueException();
        }

        this.data[this.p] = e;
        this.p++;
        logger.info("post: nou element "+ e);

    }


    public E pop() throws EmptyQueueException {
        // TO-DO
        logger.info("pre: 'pop' nou element ");

        if (this.isEmpty()) {
            logger.error("Cua buida");
            throw new EmptyQueueException();
        }

        E first_element_in_queue = this.data[0];

        for (int i = 0; i < this.p - 1; i++) {
            this.data[i] = this.data[i + 1];

        }

        this.p--;
        this.data[this.p] = null;
        logger.info("post: nou element extret "+ first_element_in_queue);

        return first_element_in_queue;

    }

    private boolean isFull() {
        // TO-DO
        return this.p == this.data.length;
    }

    private boolean isEmpty() {
        // TO-DO
        return this.p == 0;
    }

    public int size() {
        //TO-DO
        return this.p;
    }
}
