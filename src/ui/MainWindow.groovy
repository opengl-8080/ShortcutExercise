package ui

import static java.awt.event.InputEvent.*

import groovy.swing.SwingBuilder
import groovy.io.FileType

import java.awt.*
import javax.swing.*
import java.awt.event.ItemEvent

import domain.*

def class MainWindow {
    
    static def COLORS = [
        QUESTION: new Color(255, 255, 142),
        CORRECT: new Color(147, 255, 147),
        INCORRECT: new Color(255, 147, 147),
        INPUT: new Color(255, 255, 255)
    ]
    
    static Shortcut GIVEUP_AND_NEXT = new Shortcut('.', Key.SHIFT, Key.ESCAPE)
    
    def questionGenerator
    def question
    
    def swing
    def presetCombobox
    def questionLabel
    def startButton
    def answerArea
    
    static show() {
        def window = new MainWindow()
        window.buildFrame().show()
        window.clearDisplay()
    }
    
    def MainWindow() {
        def presetList = this.loadPresetFiles()
        this.swing = new SwingBuilder()
        
        this.presetCombobox =
            this.swing.comboBox(
                items: presetList,
                itemStateChanged: { e ->
                    if (e.stateChange == ItemEvent.SELECTED) {
                        this.clearDisplay()
                    }
                },
                focusGained: {
                    this.clearDisplay()
                }
            )
        
        this.questionLabel = 
            this.swing.label(
                opaque: true,
                background: COLORS.QUESTION,
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
                })
            )
        
        this.answerArea =
            this.swing.label(
                opaque: true,
                background: COLORS.INPUT,
                font: new Font('SansSerif', Font.PLAIN, 25),
                horizontalAlignment: JLabel.CENTER,
                keyReleased: {e -> // Shift + ESC は Released じゃないと検知できない  
                    def input = KeyInput.parse(e)
                    
                    if (input.isOnlyMetaKey()) {
                        return
                    }
                    
                    if (GIVEUP_AND_NEXT.match(input)) {
                        if (this.question.isAnswered) {
                            this.printNextQuestion()
                        } else {
                            this.giveUp()
                        }
                    }
                },
                keyPressed: { e ->
                    def input = KeyInput.parse(e)
                    
                    if (input.isOnlyMetaKey()) {
                        return
                    }
                    
                    if (!this.question.isAnswered) {
                        this.judgeUserType(input)
                    }
                }
            )
    }
    
    def clearDisplay() {
        this.questionLabel.background = COLORS.QUESTION
        this.questionLabel.text = 'click start button...'
        this.answerArea.text = ''
    }
    
    def giveUp() {
        this.questionLabel.text += "(${this.question.correctAnswer})"
        this.questionLabel.background = COLORS.CORRECT
        this.question.isAnswered = true
        this.answerArea.text = 'Give Up...'
    }
    
    def judgeUserType(KeyInput input) {
        if (this.question.answer(input)) {
            this.questionLabel.background = COLORS.CORRECT
        } else {
            this.questionLabel.background = COLORS.INCORRECT
        }
        
        this.questionLabel.text += "(${this.question.correctAnswer})"
        this.answerArea.text = "your type => ${input}"
    }
    
    def loadPresetFiles() {
        def presetList = []
        
        def presetDir = System.getProperty('preset.dir')
        
        new File(presetDir).eachFileMatch(FileType.FILES, ~/^.+_shortcut.txt$/) {
            presetList << PresetFactory.load(it)
        }
        
        presetList
    }
    
    def printNextQuestion() {
        this.question = this.questionGenerator.next()
        this.questionLabel.text = this.question.problemText
        this.questionLabel.background = COLORS.QUESTION
        this.answerArea.text = 'type shortcut'
        this.answerArea.requestFocusInWindow()
    }
    
    def buildFrame() {
        swing.frame(
            title:'Shortcut Exercise',
            size:[500,300],
            locationByPlatform: true,
            defaultCloseOperation: JFrame.EXIT_ON_CLOSE
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
                constraints: BorderLayout.CENTER
            ) {
                gridLayout(
                    columns: 1,
                    rows: 2
                )
                
                widget (this.questionLabel)
                widget (this.answerArea)
            }
        }
    }
}

