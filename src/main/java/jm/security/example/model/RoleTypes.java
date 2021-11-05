package jm.security.example.model;

public enum RoleTypes {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    public static final RoleTypes[] ALL = {ROLE_USER, ROLE_ADMIN};

    private final String name;

    private RoleTypes(String name) {
        this.name = name;
    }

    public static RoleTypes forName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null for feature");
        }
        if (name.toUpperCase().equals("ROLE_USER")) {
            return ROLE_USER;
        } else if (name.toUpperCase().equals("ROLE_ADMIN")) {
            return ROLE_ADMIN;
        }
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Feature");
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
