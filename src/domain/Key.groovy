package domain

def enum Key {
    // ※列挙子の順番は、 Key の組み合わせを文字列表現にするときの順序になるので注意（Ctrl + Shift + Alt + A という順番になる）
    CTRL(true),SHIFT(true),ALT(true),
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,
    F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,
    _0('0'),_1('1'),_2('2'),_3('3'),_4('4'),_5('5'),_6('6'),_7('7'),_8('8'),_9('9'),
    AT('@'),
    BACK_SLASH('\\'),BACK_SPACE('BackSpace'),
    CAPS_LOCK('CapsLock'),CIRCUMFLEX('^'),CLOSE_BRACKET(']'),COLON(':'),COMMA(','),
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
    NUMPAD0,NUMPAD1,NUMPAD2,NUMPAD3,NUMPAD4,NUMPAD5,NUMPAD6,NUMPAD7,NUMPAD8,NUMPAD9,
    DIVIDE('Divide(/)'),MULTIPLY('Multiply(*)'),SUBTRACT('Subtract(-)'),ADD('Add(+)'),DECIMAL('Decimal(.)'),
    HALF_WIDTH('Hankaku'),FULL_WIDTH('Zenkaku'),
    NONCONVERT('Muhenkan'),CONVERT('Henkan'),
    KATAKANA('Katakana'),HIRAGANA('Hiragana'),ALPHANUMERIC,
    CONTEXT_MENU('Context Menu'),CLEAR,CANCEL,
    
    
    def display
    def metaKey = false
    
    def Key() {
        this.display = toLowerCaseWithoutFirstChar(this.name())
    }
    
    def Key(String display) {
        this.display = display
    }
    
    def Key(boolean metaKey) {
        this()
        this.metaKey = metaKey
    }
    
    boolean isMetaKey() {
        this.metaKey
    }
    
    @Override
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
        'n0': NUMPAD0,
        'n1': NUMPAD1,
        'n2': NUMPAD2,
        'n3': NUMPAD3,
        'n4': NUMPAD4,
        'n5': NUMPAD5,
        'n6': NUMPAD6,
        'n7': NUMPAD7,
        'n8': NUMPAD8,
        'n9': NUMPAD9,
        'escape': ESCAPE,
        'bs': BACK_SPACE,
        'esc': ESCAPE,
        'enter': ENTER,
        'space': SPACE,
        'back_space': BACK_SPACE,
        'del': DELETE,
        'delete': DELETE,
        'caps': CAPS_LOCK,
        'caps_lock': CAPS_LOCK,
        'tab': TAB,
        'home': HOME,
        'end': END,
        'ins': INSERT,
        'insert': INSERT,
        'up': UP,
        'right': RIGHT,
        'left': LEFT,
        'down': DOWN,
        '^': CIRCUMFLEX,
        '@': AT,
        '/': SLASH,
        '\\': BACK_SLASH,
        '[': OPEN_BRACKET,
        ']': CLOSE_BRACKET,
        ':': COLON,
        ';': SEMICOLON,
        '.': PERIOD,
        'comma': COMMA,
        ',': COMMA,
        '+': ADD,
        '-': MINUS,
        '*': MULTIPLY,
        'subtract': SUBTRACT,
        'decimal': DECIMAL,
        'num_lock': NUM_LOCK,
        'page_down': PAGE_DOWN,
        'page_up': PAGE_UP,
        'pause': PAUSE,
        'print_screen': PRINTSCREEN,
        'scroll_lock': SCROLL_LOCK,
        'half_width': HALF_WIDTH,
        'full_width': FULL_WIDTH,
        'noconvert': NONCONVERT,
        'convert': CONVERT,
        'katakana': KATAKANA,
        'hiragana': HIRAGANA,
        'alphanumeric': ALPHANUMERIC,
        'menu': CONTEXT_MENU,
        'clear': CLEAR,
        'cancel': CANCEL,
        'win': WINDOWS,
        'windowns': WINDOWS
    ]
    
    static Key map(str) {
        if (!MAPPING.containsKey(str.toLowerCase())) {
            throw new Exception(/unknown key > "${str}"/)
        }
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
