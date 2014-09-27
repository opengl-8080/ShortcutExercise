package domain

def class Shortcut {
    
    def description
    List<Key> keys
    
    def Shortcut (description, List<Key> keys) {
        this.description = description
        this.keys = new ArrayList(keys)
    }
    
    def Shortcut (description, Key... keys) {
        this.description = description
        this.keys = keys
    }
    
    def match(KeyInput input) {
        this.keys.size() == input.keyCount() && this.keys.every { input.has(it) }
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
    
    @Override
    boolean equals(s) {
        if (this.is(s)) return true;
        if (!(s instanceof Shortcut)) return false;
        
        s.description == this.description && s.keys == this.keys
    }
    
    @Override
    int hashCode() {
        Objects.hashCode(this.description, this.keys)
    }
}
