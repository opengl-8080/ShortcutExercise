package domain

def class QuestionGenerator {
    
    List<Shortcut> shortcutList
    def randomSort
    int i
    
    def QuestionGenerator(shortcutList) {
        this.shortcutList = shortcutList
        
        if (this.shortcutList.isEmpty()) {
            throw new Exception('shortcut is empty.')
        }
    }
    
    def next() {
        if (this.shortcutList.size() <= i) {
            this.shortcutList = this.randomSort(this.shortcutList)
            i = 0
        }
        
        this.shortcutList[i++]
    }
}
