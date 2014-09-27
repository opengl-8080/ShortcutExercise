package domain

def class Question {
    
    def shortcut
    
    def Question(shortcut) {
        this.shortcut = shortcut
    }
    
    def answer(KeyInput input) {
        this.shortcut.match(input)
    }
    
    def getProblemText() {
        this.shortcut.description
    }
    
    def getCorrectAnswer() {
        this.shortcut.toString()
    }
    
    @Override
    boolean equals(q) {
        if (this.is(q)) return true;
        if (!(q instanceof Question)) return false;
        
        q.shortcut == this.shortcut
    }
    
    @Override
    int hashCode() {
        shortcut.hashCode()
    }
}