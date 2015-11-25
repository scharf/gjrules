package gr.scharf.rules.condition;

import gr.scharf.rules.StateStore;

public final class OrCondition implements ICondition {
    ICondition[] filters;

    public OrCondition(ICondition... filter) {
        this.filters = filter;
    }

    @Override
    public boolean test() {
        for (ICondition filter : filters) {
            if (filter.test()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setStore(StateStore store) {
        for (ICondition iCondition : filters) {
            iCondition.setStore(store);
        }
    }
}
