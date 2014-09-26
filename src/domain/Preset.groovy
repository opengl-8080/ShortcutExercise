package domain

def class Preset {
    
    def name
    def shortcutList = []
    
    def Preset(name) {
        this.name = name
    }
    
    def leftShift(shortcut) {
        this.shortcutList << shortcut
    }
    
    def getShortcutListCopy() {
        new ArrayList(this.shortcutList)
    }
}
