import domain.*

static test() {
    
    def a = new Shortcut('a', Key.A)
    def b = new Shortcut('b', Key.B)
    def c = new Shortcut('c', Key.C)
    
    def list1 = [a, b, c]
    def list2 = [c, a, b]
    
    def gen = new QuestionGenerator(list1)
    gen.randomSort = { list2 }
    
    
    // first iterate
    assert gen.next() == a
    assert gen.next() == b
    assert gen.next() == c
    
    // second iterate
    assert gen.next() == c
    assert gen.next() == a
    assert gen.next() == b
}