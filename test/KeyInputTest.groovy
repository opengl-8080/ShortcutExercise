import static java.awt.event.KeyEvent.*
import static java.awt.event.InputEvent.*

static test() {
    
    // single
    def key = new DummyKeyEvent(keyCode: VK_L)
    
    def input = KeyInput.parse(key)
    
    assert input.has(Key.L) == true
    
    // with Shift key
    key = new DummyKeyEvent(keyCode: VK_S, metaKey: SHIFT_DOWN_MASK)
    
    input = KeyInput.parse(key)
    
    assert input.has(Key.S) == true
    assert input.has(Key.SHIFT) == true
    
    // with Ctrl Shift key
    key = new DummyKeyEvent(keyCode: VK_K, metaKey: SHIFT_DOWN_MASK | CTRL_DOWN_MASK)
    
    input = KeyInput.parse(key)
    
    assert input.has(Key.K) == true
    assert input.has(Key.SHIFT) == true
    assert input.has(Key.CTRL) == true
    
    // with Ctrl Alt key
    key = new DummyKeyEvent(keyCode: VK_RIGHT, metaKey: ALT_DOWN_MASK | CTRL_DOWN_MASK)
    
    input = KeyInput.parse(key)
    
    assert input.has(Key.RIGHT) == true
    assert input.has(Key.SHIFT) == false
    assert input.has(Key.CTRL) == true
    assert input.has(Key.ALT) == true
}
