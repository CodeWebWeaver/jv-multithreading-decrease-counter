package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public void decreaseValue() {
        synchronized (this) {
            if (value > 0) {
                logger.info(String.format(MESSAGE,
                        "Before decrementing", Thread.currentThread().getName(), value));
                value--;
                logger.info(String.format(MESSAGE,
                        "After decrementing", Thread.currentThread().getName(), value));
            }
        }
    }
}
