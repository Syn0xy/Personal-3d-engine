package engine.utils;

public class MutableNumber<T> {

    private T value;

    public MutableNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MutableNumber [value=" + value + "]";
    }

}
