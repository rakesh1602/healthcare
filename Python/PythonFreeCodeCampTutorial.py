
#String function
'''
string="Giraffe Acadmey"
print(string.lower())
print(string.upper())
print(string.isupper())
print(string.upper().isupper())
print(len(string))
print(string[-1])
print("index of:",string.index("Acad"))
print("will replace char with other:- ",string.replace("Giraffe","Mango"))
'''

#Working with numbers
"""
print((3+4)*2)
print(10 % 3)

number= - 5
#print(number + "My fav number") #Not allowed
print(str(number)+" number")

from math import *

print(abs(number))
print(pow(4,6))
print(max(4,55))
print(round(4.664))
print(floor(3.7)) # from package
print(sqrt(36))
"""

#User input
"""
number1=int(input("Enter first number: "))
number2=int(input("Enter second number: "))
addition=number1 + number2
print(addition)
"""

#Mad--Lib game
"""
color=input("Enter a color name : ")
noun=input("Enter a noun : ")
person=input("Enter a person: ")

print("Roses are "+color)
print(noun + " are blue")
print("I hate "+person)
"""

#List
"""
friends=[False,"virat",2,"hardik","oscar","toby"]
numbers=[4,15,144,23,32,44]
print(friends[-1])
friends[1]="MsDhoni"
print(friends[1:4]) # Range
#print(friends)
#print(numbers)

#List Function
friends.extend(numbers)
print(" ")
friends.append("Rakesh") # To add the element at the end of list
friends.insert(1, "Kl chakka") #To add the element at specific extends
friends.pop() #to remove last element of list
print(friends)
"""

#Tuples - Immutable
"""
coordinates = (4,5)
coordinates [1]=44 #Immutable - can not change the value
print(coordinates[1])
"""

#Functions
"""
def sayHi(name, age):
    print("Hello ",name,age)

sayHi("Rakesh",25)
"""

#Return
"""
def cube(num):
   return(num*num*num)

result= cube(4)
print (result)
"""

#ifElifElse
"""
name1="raffkesh"
name2="chavagn"
if (len(name1)>len(name2)) :
    print("name 1 is greater")
elif(len(name1)<len(name2)):
    print("name 2 is smaller")
else:
    print("both are same")
"""

#Dictionaries - KEY and VALUE PAIR
"""
monthConversions = {
    #KEY : VALUE
    "Jan":"January",
    "Feb":"February",
    "Mar":"March",
    }
print(monthConversions["Feb"])
print(monthConversions.get("Mar", "Not a valid key"))

"""

#While loop
"""
i=1
while i<=10:
    print(i)
    i +=1

print("done with the loop")
"""
# Building a Guessing Game
"""
secreat_word ="giraffe"
guess=""
guessCount=0
guessLimit=3
out_of_guesses=False

while guess!= secreat_word and not (out_of_guesses):
    if guessCount < guessLimit:
        guess=input("Enter guess : ")
        guessCount +=1
    else :
        out_of_guesses=True
if out_of_guesses:
    print("out of gusses, You lose !!")
else :
    print("You win")
"""

#For Loop

"""
for letter in "Giraafe" :
    print(letter)

friends=[False,"virat",2,"hardik","oscar","toby"]

for friend in friends :
    print(friend)
"""


#Python Function

#def function_name - it is defined by the def function

def greet(name):
    print("Hello " + name + " Good Morning")

greet("Rakesh")

def add(num1, num2):
    result=num1+num2
    print("result is : ",result)

add(55,2)

def absolute_value(num):
    if num>=3:
        return num
    else:
        return -num

print(absolute_value(2))
print(absolute_value(-4))


