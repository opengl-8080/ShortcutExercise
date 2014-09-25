static test() {
    
    def key = Key.map('a')
    assert key == Key.A
    
    key = Key.map('ctrl')
    assert key == Key.CTRL
    
    key = Key.map('WIN')
    assert key == Key.WINDOWS
    
    key = Key.map('\\')
    assert key == Key.BACK_SLASH
    
}
