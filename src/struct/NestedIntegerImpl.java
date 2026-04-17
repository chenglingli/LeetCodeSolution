package struct;

import java.util.ArrayList;
import java.util.List;

public final class NestedIntegerImpl implements NestedInteger {
    private final Integer value;
    private final List<NestedInteger> list;
    public NestedIntegerImpl(int v) {
        this.value = v;
        this.list = new ArrayList<>();
    }
    public NestedIntegerImpl(List<NestedInteger> nested) {
        this.value = null;
        this.list = nested;
    }
    @Override
    public boolean isInteger() {
        return value != null;
    }
    @Override
    public Integer getInteger() {
        return value;
    }
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
