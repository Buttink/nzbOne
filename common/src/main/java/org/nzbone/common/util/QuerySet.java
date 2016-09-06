package org.nzbone.common.util;

import rx.Observable;

import java.util.HashSet;

public class QuerySet<T> extends HashSet<T> {

    @Override
    public String toString() {
        return Observable.from(this)
                .map(Object::toString)
                .reduce((c,n) -> c + "|" + n)
                .toBlocking()
                .single();
    }
}
