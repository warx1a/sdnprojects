class String(object):
    def __init__(this,string):
        this.string = string
    def length(this):
        count = 0
        for x in this.string:
            count += 1
        return count
    def parseInt(this):
        try:
            return int(this.string)
        except ValueError:
            return None
    
    def substring(this,start,end):
        return this.string[start:end + 1]
    
    def isDigit(this,index):
        try:
            x = int(this.string[index])
        except ValueError:
            x = ""
        if(type(x) == int):
            return True
        return False

    def compact(this):
        return this.string.replace(" ","")

    def removeGarbage(this):
        for x in this.string:
            if(ord(x) in range(0,1)):
               pass

    def getLast(this):
        return this.string[-1]

    def getFirst(this):
        return this.string[0]

    def equals(this,value):
        return str(this.string) == str(value)

    def indexOf(this,char):
        i = 0
        for x in this.string:
            if x == char:
                return i
            i += 1
        return None

    def index(this,index):
        return this.string[index]
