========
Ryulogy
========

A set of function to make creating a web page in clojure (a programming
language) easier. This is a work in progress as I learn clojure. The aim is to
have this in the lib directory and be able to import the functions you need.  I
am working for Rheo systems right now and some of the initial code may be
specific to their needs or copied from David Jagoe.  I will be updating this as
I add different functionality.  The text content of the site can be read from a
text file written in a markup language of the site designer's choice. It is up
to the site creator to specify a parser which meets the parser requiments
listed below. If the user does not specify a parser, the restructuredText
parser is used. 

The text files are version controlled using git. I don't feel like learning
other version control systems at this point so I don't see support for other
version control systems anytime soon. I will allow for using different versions
of the site using git's tags. This will be done through an admin page.  

Configurations for the site are kept in a text file. (Design ongoing) 

Progress
--------

This serves as my arial view of what I have done and intend to do.

- Initial implementation 

  - Design
    I am gonna make the contracts which I ryulogy will honour. I will also
    decide how I am going to test the code. 

  - Implement for rst parser 

Assumptions
-----------
I have made the following assumptions for 

- The program will run from a server running bash and the user's chosen parser.
- running git on the server

Parser requirements
-------------------

- Run from bash

- Output to standard output

- convert from markup language to html

