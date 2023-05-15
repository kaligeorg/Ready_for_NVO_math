package constant;

public enum CorrectAnswer {
        A("A"), B("B"), C("C"), D("D");

    private String correctAnswer;

    private CorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString(){
        return correctAnswer;
    }
}
