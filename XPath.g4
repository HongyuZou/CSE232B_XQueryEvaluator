grammar XPath;

ap : 'doc("'FILENAME'")/' rp    #directChild
   | 'doc("'FILENAME'")//' rp   #indirectChild
   ;

rp : NAME                     #tagName
   | '*'                      #all
   | '.'                      #current
   | '..'                     #parent
   | 'text()'                 #text
   | '@' NAME                 #attr
   | '(' rp ')'               #parenRP
   | rp '/' rp                #directChildRP
   | rp '//' rp               #indirectChildRP
   | rp '[' f ']'             #filter
   | rp ',' rp                #concat
   ;

f : rp                        #rpFt
  | rp '=' rp                 #eq1
  | rp '=' '"'NAME'"'         #str
  | rp 'eq' rp                #eq2
  | rp IS rp                  #is
  | '(' f ')'                 #parenFt
  | f 'and' f                 #and
  | f 'or' f                  #or
  | 'not' f                   #not
  ;

EQUAL : '=' | 'eq';
IS : '==' | 'is';
NAME: [a-zA-Z0-9]+;
STRING : .*?;
FILENAME : [a-zA-Z0-9._]+;
WS : [ \t\r\n]+ -> skip;
