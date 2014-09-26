import static java.awt.event.KeyEvent.*
import static java.awt.event.InputEvent.*

static test() {
    test_match()
    test_toString()
}

static test_match() {
    // single
    def shortcut = new Shortcut('type a', Key.map('a'))
    def key = new DummyKeyEvent(keyCode: VK_A)
    def input = KeyInput.parse(key)
    
    assert shortcut.match(input) == true
    
    // unmatch single
    shortcut = new Shortcut('type a', Key.map('a'))
    key = new DummyKeyEvent(keyCode: VK_B)
    input = KeyInput.parse(key)
    
    assert shortcut.match(input) == false
    
    // with shift
    shortcut = new Shortcut('type shift-g', Key.map('g'), Key.map('shift'))
    key = new DummyKeyEvent(keyCode: VK_G, metaKey: SHIFT_DOWN_MASK)
    input = KeyInput.parse(key)
    
    assert shortcut.match(input) == true
    
    // unmatch with shift
    shortcut = new Shortcut('type shift-g', Key.map('g'), Key.map('shift'))
    key = new DummyKeyEvent(keyCode: VK_G, metaKey: ALT_DOWN_MASK)
    input = KeyInput.parse(key)
    
    assert shortcut.match(input) == false
    
    // with shift ctrl
    shortcut = new Shortcut('type ctrl-shift-n', Key.map('ctrl'), Key.map('n'), Key.map('shift'))
    key = new DummyKeyEvent(keyCode: VK_N, metaKey: CTRL_DOWN_MASK | SHIFT_DOWN_MASK)
    input = KeyInput.parse(key)
    
    assert shortcut.match(input) == true
    
    // type unnecessary key(alt)
    shortcut = new Shortcut('type ctrl-shift-n', Key.map('ctrl'), Key.map('n'), Key.map('shift'))
    key = new DummyKeyEvent(keyCode: VK_N, metaKey: CTRL_DOWN_MASK | SHIFT_DOWN_MASK | ALT_DOWN_MASK)
    input = KeyInput.parse(key)
    
    assert shortcut.match(input) == false
}

static test_toString() {
    // single
    def shortcut = new Shortcut('type a', Key.map('a'))
    
    assert shortcut.toString() == 'A'
    
    // with shift
    shortcut = new Shortcut('type shift-b', Key.map('shift'), Key.map('b'))
    
    assert shortcut.toString() == 'Shift + B'
    
    // with ctrl + shift
    shortcut = new Shortcut('type shift-c', Key.map('ctrl'), Key.map('shift'), Key.map('c'))
    
    assert shortcut.toString() == 'Ctrl + Shift + C'
}
