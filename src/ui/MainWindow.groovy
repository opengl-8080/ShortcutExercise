package ui
import static java.awt.event.InputEvent.*
import groovy.swing.SwingBuilder
import java.awt.*
import javax.swing.*
import domain.*
import groovy.io.FileType

def class MainWindow {
    
    def questionGenerator
    def question
    
    def swing
    def presetCombobox
    def questionLabel
    def startButton
    def answerTextArea
    
    static show() {
        def window = new MainWindow()
        window.buildFrame().show()
    }
    
    def MainWindow() {
        def presetList = this.loadPresetFiles()
        this.swing = new SwingBuilder()
        
        this.presetCombobox = this.swing.comboBox(items: presetList)
        
        this.questionLabel = 
            this.swing.label(
                background: new Color(230, 230, 230),
                font: new Font('SansSerif', Font.PLAIN, 25),
                horizontalAlignment: JLabel.CENTER
            )
        
        this.startButton = 
            this.swing.button(
                label: 'Start',
                action: this.swing.action(name: 'start', closure: {
                    def preset = this.presetCombobox.selectedItem
                    questionGenerator = new QuestionGenerator(preset.getShortcutListCopy())
                    this.printNextQuestion()
                    this.startButton.setEnabled(false)
                })
            )
        
        this.answerTextArea =
            this.swing.textArea(
                text: 'type shortcut',
                editable: false,
                keyReleased: { e ->
                    def input = KeyInput.parse(e)
                    
                    /*
                    if (this.question.answer(input)) {
                        println 'correct!!'
                    } else {
                        println 'incorrect...'
                    }
                    */
                }
            )
    }
    
    def loadPresetFiles() {
        def presetList = []
        
        new File('.').eachFileMatch(FileType.FILES, ~/^.+_shortcut.txt$/) {
            presetList << PresetFactory.load(it)
        }
        
        presetList
    }
    
    def printNextQuestion() {
        this.question = this.questionGenerator.next()
        this.questionLabel.text = this.question.description
        this.answerTextArea.requestFocusInWindow()
    }
    
    def buildFrame() {
        swing.frame(
            title:'Shortcut Exercise',
            size:[300,300]
        ) {
            borderLayout()
            
            panel (
                constraints: BorderLayout.NORTH
            ) {
                boxLayout()
                
                widget(this.presetCombobox)
                widget(this.startButton)
            }
            
            panel (
                constraints: BorderLayout.CENTER,
                background: new Color(255, 255, 132)
            ) {
                gridLayout(
                    columns: 1,
                    rows: 2
                )
                
                widget (this.questionLabel)
                widget (this.answerTextArea)
            }
        }
    }
}

