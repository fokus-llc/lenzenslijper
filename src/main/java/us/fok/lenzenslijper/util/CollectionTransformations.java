package us.fok.lenzenslijper.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CollectionTransformations {

    private CollectionTransformations() {} // non-instantiated utility module

    public static <T> List<T> sublist(Collection<T> collection, int offset, int limit) {
        List<T> list = new ArrayList<T>(limit);
        int i = 0, offsetLimit = limit + offset;
        for(T item : collection) {
            if (++i > offset) {
                if (i > offsetLimit) break;
                list.add(item);
            }
        }
        return list;
    }

}
