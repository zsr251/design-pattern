package ren.k88.pattern.behaviour;

import java.util.Iterator;

/**
 * 迭代器模式
 * 提供一种方法顺序访问一个聚合对象中的各个元素，而不用暴露其内部显示
 * Created by jasonzhu on 2017/3/15.
 */
public class IteratorPattern {
    public static void main(String[] args) {
        /**
         * String数组的迭代器
         */
        String[] list = {"1"};
        StringIterator si = new StringIterator(list);
        while (si.hasNext()){
            System.out.println(si.next());
        }
    }
}

/**
 * 简单字符串数据迭代器
 */
class StringIterator implements Iterator {
    String[] list;
    int position = 0;

    public StringIterator(String[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.length - position > 0;
    }

    @Override
    public Object next() {
        if (hasNext()){
            return list[position++];
        }
        return null;
    }
}
