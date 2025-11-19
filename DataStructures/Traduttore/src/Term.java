public class Term {
    private String italian;
    private String english;

    public Term(String italian, String english){
        this.italian = italian;
        this.english = english;
    }

    public String getItalian(){
        return italian;
    }

    public String getEnglish(){
        return english;
    }

    @Override
    public String toString(){
        return italian + " - " + english;
    }
}
