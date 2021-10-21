public class Counter {

    private int count;

    public Counter() {
        this(0);
    }

    public Counter(int initialCount) {
        this.count = initialCount;
    }

    public Counter increment() {
        this.count++;
        return this;
    }

    public Counter decrement() {
        this.count--;
        return this;
    }

    public int toInt() {
        return this.count;
    }
}
