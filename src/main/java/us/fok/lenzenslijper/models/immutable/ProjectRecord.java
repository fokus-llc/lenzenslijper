package us.fok.lenzenslijper.models.immutable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public interface ProjectRecord {

    UUID getId();
    String getSlug();
    String getName();

}
