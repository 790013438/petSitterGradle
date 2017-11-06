package snippets.jee.base;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    protected Long id;
    protected java.util.Date createAt;
    protected java.util.Date modifiedAt;
    protected int version;
}
