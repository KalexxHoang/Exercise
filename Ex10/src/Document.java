public class Document {
    /**********************************
     *            Attribute           *
     **********************************/
    private String text;

    /*********************************
     *            Constructor        *
     *********************************/
    public Document(String text) {
        this.text = text;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*********************************
     *              countA           *
     *********************************/
    public int countA() {
        int count = 0;
        for (int i=0; i<formalizeString().length(); i++) {
            if (formalizeString().charAt(i) == 'a' || formalizeString().charAt(i) == 'A')
                count++;
        }
        return count;
    }

    /*********************************
     *        formalizeString        *
     *********************************/
    public String formalizeString() {
        return this.text.trim().replaceAll("\\s+"," ");
    }

    /*********************************
     *           countWord           *
     *********************************/
    public int countWord() {
        String[] wordList = formalizeString().split(" ");
        return wordList.length;
    }
}
