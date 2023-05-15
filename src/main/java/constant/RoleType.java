package constant;

public enum RoleType {
    TEACHER("TEACHER"), STUDENT("STUDENT"), ADMIN("ADMIN");

    private String roleName;

    private RoleType(String roleName){
        this.roleName = roleName;
    }

    @Override
    public String toString(){
        return roleName;
    }

}
