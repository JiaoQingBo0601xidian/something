package length;

import ExceptionHandle.ExceptionHandler;

import java.math.BigDecimal;

public abstract class LengthUnit {
    private long count;

    public LengthUnit(long count) {
        setCount(count);
    }

    public LengthUnit setCount(long count) {
        ExceptionHandler.ensureLengthNotIllegal(count);
        this.count = count;
        return this;
    }

    public long getCount() {
        return count;
    }

    public boolean lengthUnitCompare(LengthUnit lengthUnit) {
        return this.getCount() * lengthUnit.getBase() == lengthUnit.getCount() * this.getBase();
    }

    public abstract int getBase();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LengthUnit that = (LengthUnit) o;


        if (count != that.count) return false;
        return this.getCount() * o.getBase() == o.getCount() * this.getBase();
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (count ^ (count >>> 32));
    }

}
