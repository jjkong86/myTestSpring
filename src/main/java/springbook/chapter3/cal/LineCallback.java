package springbook.chapter3.cal;

public interface LineCallback<T> {
	T doSumethingWithLine(String line, T value);
}
