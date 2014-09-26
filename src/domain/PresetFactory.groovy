package domain

def class PresetFactory {
    
    static load(filePath) {
        def file = toFile(filePath)
        
        def preset = new Preset(extractPresetName(filePath))
        
        file.readLines()
            .findAll { !it.trim().isEmpty() }
            .each { line ->
                def elements = line.split(',')
                
                if (elements.size() < 2) {
                    throw new Exception(/invalid file format > "${line}"/)
                }
                
                def description = elements.first()
                
                def keys = elements[1..<elements.size()].collect { Key.map(it) }
                
                preset << new Shortcut(description, keys)
            }
        
        preset
    }
    
    static toFile(filePath) {
        def file = new File(filePath)
        
        if (!file.exists()) {
            throw new Exception("${filePath} is not found.");
        }
        
        file
    }
    
    static extractPresetName(filePath) {
        def index = filePath.indexOf('_shortcut')
        
        if (index == -1) {
            throw new Exception(/file name must be "xxxx_shortcut.txt". but actual is "${filePath}"./)
        }
        
        def name = filePath.substring(0, index)
        
        if (name.isEmpty()) {
            throw new Exception(/file name must be "xxxx_shortcut.txt". but actual is "${filePath}"./)
        }
        
        name
    }
}
