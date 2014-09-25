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
    
    @Override
    String toString() {
        this.keys.inject(new StringBuilder()) {memo, key ->
            if (memo.size() != 0) {
                memo << ' + '
            }
            
            memo << key
        }
    }
}
