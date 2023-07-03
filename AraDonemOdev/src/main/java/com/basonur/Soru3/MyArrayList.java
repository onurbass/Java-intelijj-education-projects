package com.basonur.Soru3;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {

    private Object[] dizi;
    private int boyut;

    public MyArrayList() {
        dizi = new Object[10];
        boyut = 0;
    }

    public void add(T element) {
        if (boyut == dizi.length) {
            increaseCapacity();
        }
        dizi[boyut] = element;
        boyut++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > boyut) {
            throw new IndexOutOfBoundsException();
        }
        if (boyut == dizi.length) {
            increaseCapacity();
        }
        for (int i = boyut; i > index; i--) {
            dizi[i] = dizi[i - 1];
        }
        dizi[index] = element;
        boyut++;
    }

    public T get(int index) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        return (T) dizi[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        dizi[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < boyut - 1; i++) {
            dizi[i] = dizi[i + 1];
        }
        dizi[boyut - 1] = null;
        boyut--;
    }

    // 1-2-4-5-6 null
    // 0 1 2 3 4 5

    public boolean contains(T element) {
        for (int i = 0; i < boyut; i++) {
            if (dizi[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int boyut() {
        return boyut;
    }

    public boolean isEmpty() {
        return boyut == 0;
    }

    private void increaseCapacity() {
        int newCapacity = dizi.length * 2;
        dizi = Arrays.copyOf(dizi, newCapacity);
    }


    @Override
    public String toString() {
        String className = MyArrayList.class.getSimpleName();
        StringBuilder result = new StringBuilder(className + "[");

        if (boyut > 0) {
            boolean isFirstElement = true;
            for (int i = 0; i < boyut; i++) {
                if (dizi[i] != null) {
                    if (!isFirstElement) {
                        result.append(", ");
                    }
                    result.append(dizi[i].toString());
                    isFirstElement = false;
                }
            }
        } else {
            result.append("empty");
        }

        result.append("], boyut=" + boyut + "]");

        return result.toString();
    }


}
