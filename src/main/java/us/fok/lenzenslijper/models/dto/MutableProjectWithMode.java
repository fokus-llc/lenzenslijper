package us.fok.lenzenslijper.models.dto;

import us.fok.lenzenslijper.domain.Privilege;
import us.fok.lenzenslijper.models.immutable.ProjectWithMode;

public class MutableProjectWithMode extends MutableProjectRecord implements ProjectWithMode {

    private int mode = Privilege.NONE.getValue();
    private String creator;

    public MutableProjectWithMode() {}

    public MutableProjectWithMode(ProjectWithMode orig) {
        setId(orig.getId());
        setName(orig.getName());
        setSlug(orig.getSlug());
        setMode(orig.getMode());
    }

    @Override
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }
}
