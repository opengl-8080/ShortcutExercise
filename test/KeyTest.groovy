import domain.*

static test() {
    testMap()
    ifMapNotExistsKey_throwException()
}

static testMap() {
    
    def key = Key.map('a')
    assert key == Key.A
    
    key = Key.map('ctrl')
    assert key == Key.CTRL
    
    key = Key.map('WIN')
    assert key == Key.WINDOWS
    
    key = Key.map('\\')
    assert key == Key.BACK_SLASH
    
    key = Key.map('comma')
    assert key == Key.COMMA
    assert key.toString() == ','
}

static ifMapNotExistsKey_throwException() {
    try {
        Key.map('unknown')
        assert 1 == 0
    } catch (e) {
        assert e.message == 'unknown key > "unknown"'
    }
}
