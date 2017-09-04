### Abstraction Inversion

Abstraction inversion is an antipattern. Where you make use of a complicated abstraction
to implement a simple abstraction. You should always use simpler abstraction to build
more complex abstraction. 

examples: 
1. Using java vector (abstraction over dynamically growing arrays) to build a statically
fixed size array. Here you could have simply used an array [].

2. Transaction abstraction is used to implement code locking in some (not sure if it's all)
programming languages.

[Read more at Portland repository](http://wiki.c2.com/?AbstractionInversion)

### Leaky abstraction

Exposing underlying details and limitations of the class to it's users which ideally should
be hidden away. Leaky abstraction is a direct violation of object oriented "abstraction"
principle.

[Read more on wiki](https://en.wikipedia.org/wiki/Leaky_abstraction)