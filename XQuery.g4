grammar XQuery;
import XPath;

xq : var                                                         #xqVar
   | STR                                                         #xqStr
   | ap                                                          #xqAp
   | '(' xq ')'                                                  #xqParen
   | xq ',' xq                                                   #xqConcat
   | xq '/' rp                                                   #xqDirectChild
   | xq '//' rp                                                  #xqIndirectChild
   | '<'NAME'>' '{' xq '}' '<' '/' NAME'>'                       #xqTag
   | forclause letclause? whereclause? returnclause              #xqClause
   | letclause xq                                                #xqLet
   ;

forclause: 'for' var 'in' xq (',' var 'in' xq)*;
letclause: 'let' var ':=' xq (',' var ':=' xq)*;
whereclause: 'where' cond;
returnclause: 'return' xq;

cond : xq '=' xq                                                 #condEq1
     | xq 'eq' xq                                                #condEq2
     | xq IS xq                                                  #condIs
     | 'empty' '(' xq ')'                                        #condEmpty
     | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond    #condSome
     | '(' cond ')'                                              #condParen
     | cond 'and' cond                                           #condAnd
     | cond 'or' cond                                            #condOr
     | 'not' cond                                                #condNot
     ;

var: '$' NAME;