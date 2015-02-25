// Define a grammar called Hello
grammar CLI;

@header {
	package edu.cabrillo.vmware.parsers;
}

@parser::members {
   public RecognitionException haserror = null;
}

file : line* EOF; 

line : command? EOL ; 

command 
	: linkedclone
	| move
	| rename
	| mkdir
	| delete
	| create
	| addnet
	| modnet
	| delnet
	| migrate
	| poweron
	| poweroff
	| shutdown
	| reboot
	;

linkedclone : 'linkedclone' vrl vrl ; 
move        : 'move' vrl vrl ; 
rename      : 'rename' vrl STRING ; 
mkdir       : 'mkdir' vrl STRING ; 
delete      : 'delete' vrl ;
create      : 'create' vrl ;
addnet		: 'addnet' vrl STRING ; 
modnet		: 'modnet' vrl STRING ; 
delnet		: 'delnet' vrl STRING ; 
migrate		: 'migrate' vrl vrl ; 
poweron		: 'poweron' vrl ; 
poweroff	: 'poweroff' vrl ; 
shutdown	: 'shutdown' vrl ; 
reboot  	: 'reboot' vrl ; 

vrl: RTYPE ':/' PATH ; 

STRING : '"' (~["] | '\\' '"')* '"' ; 

RTYPE : 'vm' | 'folder' | 'entity' | 'snapshot' | 'portgroup' | 'datastore' ; 

PATH : PATHPART+ '/'; 

fragment PATHPART : '/' [a-z|A-Z|0-9] (~[/]*) ; 

EOL : '\n' '\r'? ; 

WS : [ \t]+ -> skip ; // skip spaces, tabs, newlines
