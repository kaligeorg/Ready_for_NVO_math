package constant;

public enum Topic_Class {
    FIRST("1"), SECOND("2"), THIRD("3"), FOURTH("4"), FIFTH("5"),
    SIXTH("6"), SEVENTH("7"), EIGHT("8"), NINTH("9"), TENTH("10"),
    ELEVENTH("11"), TWELFTH("12");

    private String classNumber;

    Topic_Class(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString(){
        return classNumber;
    }
}
