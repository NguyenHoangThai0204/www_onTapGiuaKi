package vn.edu.iuh.fit.models;

public enum Roles {
    ADMINISTRATION,
    STAFF,
    MANAGER,
    EXECUTIVE;
    private int value;
    Roles(int value){
        this.value =value;
    }
    Roles(){}

    public int getValue() {
        return this.value;
    }
}
