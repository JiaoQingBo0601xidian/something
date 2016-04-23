package length;

public class Mile extends LengthUnit {
    public final static int MILE_BASE = 1;

    @Override
    public int getBase() {
        return this.MILE_BASE;
    }

    public Mile(long count) {
        super(count);
    }

}
