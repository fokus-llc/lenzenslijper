package us.fok.lenzenslijper.domain;

/**
 *
 * Branch user mode bits
 *
 * ADMIN: User may grant/revoke lower order permissions for non-OWNERs
 * OWNER: User may grant/revoke any permissions for any
 *
 */
public enum Privilege {

    NONE(0000),
    ASSESS(0001), SUBMIT(0002), PREVIEW(0004),
    DIRECTORY(0010), PUBLISH(0020),
    OWNER(0100), ADMIN(0200),

    DEFAULT(DIRECTORY.getValue()),

    UPDATE(ASSESS.getValue() | SUBMIT.getValue() | PUBLISH.getValue() | OWNER.getValue() | ADMIN.getValue());

    private static boolean check(Privilege priv, int otherValue) {
        return (otherValue & priv.getValue()) != 0;
    }

    private int value;

    private Privilege(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean check(int otherValue) {
        return check(this, otherValue);
    }

}
