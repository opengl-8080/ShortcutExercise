def class DummyKeyEvent {
    def keyCode
    def metaKey = 0
    
    def getKeyCode() {
        this.keyCode
    }
    
    def getModifiersEx() {
        this.metaKey
    }
}