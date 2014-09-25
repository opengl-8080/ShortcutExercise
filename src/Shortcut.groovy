def class Shortcut {
    
    def description
    def keys
    
    def Shortcut (String description, Key... keys) {
        this.description = description
        this.keys = keys
    }
    
    def match(KeyInput input) {
        this.keys.every { input.has(it) }
    }
}
