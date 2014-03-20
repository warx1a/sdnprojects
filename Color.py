class Color:

    def __init__(this,r,g,b):
        this.r = r
        this.g = g
        this.b = b

    def getColor(this,tipe):
        if tipe == "list":
            return [this.r,this.g,this.b]
        elif tipe == "str":
            return str(this.r) + "," + str(this.g) + "," + str(this.b)
        elif tipe == "int":
            this.signedinteger = 65536 * this.r + 256 * this.g + this.b
            return this.signedinteger
        else:
            return None

    def solve(this,integer):
        red = this.signedinteger >> 16 & 0xFF
        green = this.signedinteger >> 8 & 0xFF
        blue = this.signedinteger & 0xFF
        return[red,green,blue]

    def getRed(this):
        return this.r

    def getGreen(this):
        return this.g

    def getBlue(this):
        return this.b

    def 
