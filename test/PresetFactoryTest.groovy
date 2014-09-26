import domain.*

static test() {
    testStandardSituation()
    testFileNotExists()
    invalidFileName()
    notExistsPresetName()
    ifExistsEmptyLine_skipIt()
    ifElementCountIsOnlyOne_throwException()
}

static testStandardSituation() {
    new File('test_shortcut.txt').write(
        '''\
        |Copy,Ctrl,c
        |Save All,Ctrl,Shift,s
        |'''.stripMargin()
    )
    
    def preset = PresetFactory.load('test_shortcut.txt')
    
    assert preset.name == 'test'
    
    def shortcutList = preset.getShortcutListCopy()
    
    def first = shortcutList[0]
    
    assert first.description == 'Copy'
    assert first.keys == [Key.CTRL, Key.C]
    
    def second = shortcutList[1]
    
    assert second.description == 'Save All'
    assert second.keys == [Key.CTRL, Key.SHIFT, Key.S]
}

static testFileNotExists() {
    try {
        PresetFactory.load('not-exists-file.txt');
        assert 1 == 0
    } catch (e) {
        assert e.message == 'not-exists-file.txt is not found.'
    }
}

static invalidFileName() {
    new File('xxxx.txt').createNewFile()
    
    try {
        PresetFactory.load('xxxx.txt');
        assert 1 == 0
    } catch (e) {
        assert e.message == 'file name must be "xxxx_shortcut.txt". but actual is "xxxx.txt".'
    }
}

static notExistsPresetName() {
    
    new File('_shortcut.txt').createNewFile()
    
    try {
        PresetFactory.load('_shortcut.txt');
        assert 1 == 0
    } catch (e) {
        assert e.message == 'file name must be "xxxx_shortcut.txt". but actual is "_shortcut.txt".'
    }
}

static ifExistsEmptyLine_skipIt() {
    new File('has_empty_line_shortcut.txt').write (
        '''\
        |Copy,Ctrl,C
        |
        |Save All,Ctrl,Shift,s
        |'''.stripMargin()
    )
    
    def preset = PresetFactory.load('has_empty_line_shortcut.txt')
    
    assert preset.name == 'has_empty_line'
    
    def shortcutList = preset.getShortcutListCopy()
    
    def first = shortcutList[0]
    
    assert first.description == 'Copy'
    assert first.keys == [Key.CTRL, Key.C]
    
    def second = shortcutList[1]
    
    assert second.description == 'Save All'
    assert second.keys == [Key.CTRL, Key.SHIFT, Key.S]
}

static ifElementCountIsOnlyOne_throwException() {
    new File('invalid_format_shortcut.txt').write (
        '''\
        |Only Description
        |'''.stripMargin()
    )
    
    try {
        PresetFactory.load('invalid_format_shortcut.txt')
        assert 1==0
    } catch (e) {
        assert e.message == 'invalid file format > "Only Description"'
    }
}

