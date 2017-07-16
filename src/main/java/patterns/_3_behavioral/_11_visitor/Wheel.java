package patterns._3_behavioral._11_visitor;

/**
 * @author LinnykOleh
 */
public class Wheel implements AtvPart{

    @Override
    public void accept(AtvPartVisitor visitor) {
        visitor.visit(this);
    }
}
