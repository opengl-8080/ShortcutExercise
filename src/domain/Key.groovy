package domain

def enum Key {
    CTRL,ALT,SHIFT,
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,
    F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,
    _0('0'),_1('1'),_2('2'),_3('3'),_4('4'),_5('5'),_6('6'),_7('7'),_8('8'),_9('9'),
    AT('@'),
    BACK_SLASH('\\'),BACK_SPACE('BackSpace'),
    CAPS_LOCK('CapsLock'),CIRCUMFLEX('^'),CLOSE_BRACKET(']'),COLON(':'),COMMA(';'),
    DELETE,DOWN,
    END,ENTER,ESCAPE,
    HOME,
    INSERT,
    LEFT,
    MINUS('-'),
    NUM_LOCK('NumLock'),
    OPEN_BRACKET('['),
    PAGE_DOWN('PageDown'),PAGE_UP('PageUp'),PAUSE,PERIOD('.'),PRINTSCREEN('PrintScreen'),
    RIGHT,
    SCROLL_LOCK('ScrollLock'),SEMICOLON(';'),SLASH('/'),SPACE,
    TAB,
    UP,
    WINDOWS,
    
    def display
    
    def Key() {
        this.display = toLowerCaseWithoutFirstChar(this.name())
    }
    
    def Key(display) {
        this.display = display
    }
    
    String toString() {
        this.display
    }
    
    static final def MAPPING = [
        'ctrl': CTRL,
        'alt': ALT,
        'shift': SHIFT,
        'a': A,
        'b': B,
        'c': C,
        'd': D,
        'e': E,
        'f': F,
        'g': G,
        'h': H,
        'i': I,
        'j': J,
        'k': K,
        'l': L,
        'm': M,
        'n': N,
        'o': O,
        'p': P,
        'q': Q,
        'r': R,
        's': S,
        't': T,
        'u': U,
        'v': V,
        'w': W,
        'x': X,
        'y': Y,
        'z': Z,
        'f1': F1,
        'f2': F2,
        'f3': F3,
        'f4': F4,
        'f5': F5,
        'f6': F6,
        'f7': F7,
        'f8': F8,
        'f9': F9,
        'f10': F10,
        'f11': F11,
        'f12': F12,
        '0': _0,
        '1': _1,
        '2': _2,
        '3': _3,
        '4': _4,
        '5': _5,
        '6': _6,
        '7': _7,
        '8': _8,
        '9': _9,
        '@': AT,
        '\\': BACK_SLASH,
        'bs': BACK_SPACE,
        'back_space': BACK_SPACE,
        'caps': CAPS_LOCK,
        'caps_lock': CAPS_LOCK,
        '^': CIRCUMFLEX,
        ']': CLOSE_BRACKET,
        ':': COLON,
        ',': COMMA,
        'comma': COMMA,
        'del': DELETE,
        'delete': DELETE,
        'down': DOWN,
        'end': END,
        'enter': ENTER,
        'esc': ESCAPE,
        'escape': ESCAPE,
        'home': HOME,
        'ins': INSERT,
        'insert': INSERT,
        'left': LEFT,
        '-': MINUS,
        'num_lock': NUM_LOCK,
        '[': OPEN_BRACKET,
        'page_down': PAGE_DOWN,
        'page_up': PAGE_UP,
        'pause': PAUSE,
        '.': PERIOD,
        'print_screen': PRINTSCREEN,
        'right': RIGHT,
        'scroll_lock': SCROLL_LOCK,
        ';': SEMICOLON,
        '/': SLASH,
        'space': SPACE,
        'tab': TAB,
        'up': UP,
        'win': WINDOWS,
        'windowns': WINDOWS
    ]
    
    static Key map(str) {
        MAPPING[str.toLowerCase()]
    }
    
    static toLowerCaseWithoutFirstChar(str) {
        if (str.length() == 1) {
            str
        } else {
            str[0].toUpperCase() + str.substring(1).toLowerCase()
        }
    }
}
