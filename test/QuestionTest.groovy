import domain.*
import static java.awt.event.KeyEvent.*
import static java.awt.event.InputEvent.*

static test() {
    
    def shortcut = new Shortcut('desc', Key.SHIFT, Key.K)
    def question = new Question(shortcut)
    
    // before answer
    assert question.isAnswered == false
    
    // correct answer
    def event = new DummyKeyEvent(keyCode: VK_K, metaKey: SHIFT_DOWN_MASK)
    def input = KeyInput.parse(event)
    
    assert question.answer(input) == true
    
    // after answer
    assert question.isAnswered == true
    
    // incorrect answer
    event = new DummyKeyEvent(keyCode: VK_K, metaKey: CTRL_DOWN_MASK)
    input = KeyInput.parse(event)
    
    assert question.answer(input) == false
    
    // description as problem text
    assert question.problemText == 'desc'
    
    // shortcut string as correct answer
    assert question.correctAnswer == 'Shift + K'
}
