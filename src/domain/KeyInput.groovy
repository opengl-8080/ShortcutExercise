package domain

import java.awt.event.KeyEvent
import static java.awt.event.KeyEvent.*
import static java.awt.event.InputEvent.*
import static Key.*

def class KeyInput {
    static KeyInput parse(key) {
        new KeyInput(key)
    }
    
    List<Key> keys = []
    
    def KeyInput(key) {
        this.keys << MAPPING.get(key.keyCode as String)
        
        int meta = key.modifiersEx
        
        if ((meta & SHIFT_DOWN_MASK) != 0) {
            this.keys << Key.SHIFT
        }
        if ((meta & CTRL_DOWN_MASK) != 0) {
            this.keys << Key.CTRL
        }
        if ((meta & ALT_DOWN_MASK) != 0) {
            this.keys << Key.ALT
        }
    }
    
    def has(key) {
        this.keys.contains(key)
    }
    
    def keyCount() {
        this.keys.size()
    }
    
    static final def MAPPING = [
        (VK_CONTROL as String): CTRL,
        (VK_ALT as String): ALT,
        (VK_SHIFT as String): SHIFT,
        (VK_A as String): A,
        (VK_B as String): B,
        (VK_C as String): C,
        (VK_D as String): D,
        (VK_E as String): E,
        (VK_F as String): F,
        (VK_G as String): G,
        (VK_H as String): H,
        (VK_I as String): I,
        (VK_J as String): J,
        (VK_K as String): K,
        (VK_L as String): L,
        (VK_M as String): M,
        (VK_N as String): N,
        (VK_O as String): O,
        (VK_P as String): P,
        (VK_Q as String): Q,
        (VK_R as String): R,
        (VK_S as String): S,
        (VK_T as String): T,
        (VK_U as String): U,
        (VK_V as String): V,
        (VK_W as String): W,
        (VK_X as String): X,
        (VK_Y as String): Y,
        (VK_Z as String): Z,
        (VK_F1 as String): F1,
        (VK_F2 as String): F2,
        (VK_F3 as String): F3,
        (VK_F4 as String): F4,
        (VK_F5 as String): F5,
        (VK_F6 as String): F6,
        (VK_F7 as String): F7,
        (VK_F8 as String): F8,
        (VK_F9 as String): F9,
        (VK_F10 as String): F10,
        (VK_F11 as String): F11,
        (VK_F12 as String): F12,
        (VK_0 as String): _0,
        (VK_1 as String): _1,
        (VK_2 as String): _2,
        (VK_3 as String): _3,
        (VK_4 as String): _4,
        (VK_5 as String): _5,
        (VK_6 as String): _6,
        (VK_7 as String): _7,
        (VK_8 as String): _8,
        (VK_9 as String): _9,
        (VK_AT as String): AT,
        (VK_BACK_SLASH as String): BACK_SLASH,
        (VK_BACK_SPACE as String): BACK_SPACE,
        (VK_BACK_SPACE as String): BACK_SPACE,
        (VK_CAPS_LOCK as String): CAPS_LOCK,
        (VK_CAPS_LOCK as String): CAPS_LOCK,
        (VK_CIRCUMFLEX as String): CIRCUMFLEX,
        (VK_CLOSE_BRACKET as String): CLOSE_BRACKET,
        (VK_COLON as String): COLON,
        (VK_COMMA as String): COMMA,
        (VK_DELETE as String): DELETE,
        (VK_DELETE as String): DELETE,
        (VK_DOWN as String): DOWN,
        (VK_END as String): END,
        (VK_ENTER as String): ENTER,
        (VK_ESCAPE as String): ESCAPE,
        (VK_ESCAPE as String): ESCAPE,
        (VK_HOME as String): HOME,
        (VK_INSERT as String): INSERT,
        (VK_INSERT as String): INSERT,
        (VK_LEFT as String): LEFT,
        (VK_MINUS as String): MINUS,
        (VK_NUM_LOCK as String): NUM_LOCK,
        (VK_OPEN_BRACKET as String): OPEN_BRACKET,
        (VK_PAGE_DOWN as String): PAGE_DOWN,
        (VK_PAGE_UP as String): PAGE_UP,
        (VK_PAUSE as String): PAUSE,
        (VK_PERIOD as String): PERIOD,
        (VK_PRINTSCREEN as String): PRINTSCREEN,
        (VK_RIGHT as String): RIGHT,
        (VK_SCROLL_LOCK as String): SCROLL_LOCK,
        (VK_SEMICOLON as String): SEMICOLON,
        (VK_SLASH as String): SLASH,
        (VK_SPACE as String): SPACE,
        (VK_TAB as String): TAB,
        (VK_UP as String): UP,
        (VK_WINDOWS as String): WINDOWS,
        (VK_WINDOWS as String): WINDOWS,
    ]
}