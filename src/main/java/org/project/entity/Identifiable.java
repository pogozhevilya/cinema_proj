package org.project.entity;

import java.io.Serializable;

public interface Identifiable<E extends Serializable> {
    E getId();
}
