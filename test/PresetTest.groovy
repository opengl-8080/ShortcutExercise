import domain.*

static test() {
    
    def preset = new Preset('name')
    
    // get name
    assert preset.name == 'name'
    
    def a = new Shortcut('a', Key.A)
    def b = new Shortcut('b', Key.B)
    
    preset << a << b
    
    def list1 = preset.getShortcutListCopy()
    def list2 = preset.getShortcutListCopy()
    
    // both lists have same elements
    assert list1 == list2
    
    list1.pop()
    
    // but list1 is not list2
    assert list1.size() == 1
    assert list2.size() == 2
}
