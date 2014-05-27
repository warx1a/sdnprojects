__author__ = 'WJ001'
class String:
    def __init__(self,string):
        self.string = string

    def toString(self):
        return self.string
x = String("x");
print x.toString()
print type(x)