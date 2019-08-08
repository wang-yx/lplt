package com.wyx.proj.util;

import java.util.List;

public class CollectionsUtil {
    public boolean notEmpty(List<Object> list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean empty(List<Object> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
}
