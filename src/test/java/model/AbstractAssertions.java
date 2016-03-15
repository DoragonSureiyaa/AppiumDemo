package model;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
public abstract class AbstractAssertions<T extends Page> {

    protected T page;

    public T endAssertion() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }
}
