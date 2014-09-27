import domain.*

static test() {
    
    def s1 = new Shortcut('a', Key.A)
    def s2 = new Shortcut('b', Key.B)
    def s3 = new Shortcut('c', Key.C)
    
    def q1 = new Question(s1)
    def q2 = new Question(s2)
    def q3 = new Question(s3)
    
    def list1 = [s1, s2, s3]
    def list2 = [s3, s1, s2]
    
    def gen = new QuestionGenerator(list1)
    gen.randomSort = { list2 }
    
    // first iterate
    assert gen.next() == q1
    assert gen.next() == q2
    assert gen.next() == q3
    
    // second iterate
    assert gen.next() == q3
    assert gen.next() == q1
    assert gen.next() == q2
}