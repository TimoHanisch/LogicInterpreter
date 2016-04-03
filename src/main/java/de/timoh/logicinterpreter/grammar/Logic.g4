grammar Logic;

@header {
package de.timoh.logicinterpreter.parser.generated;
}

parse
    : logic_stmt? EOF
    ;

logic_stmt
    : LEFT_PARREN logic_stmt RIGHT_PARREN
    | Identifier
    | NOT logic_stmt
    | logic_stmt AND logic_stmt
    | logic_stmt OR logic_stmt
    | TRUE | FALSE
    ;

LEFT_PARREN : '(';
RIGHT_PARREN : ')';

NOT : 'NOT';
AND : 'AND';
OR  : 'OR';
TRUE : 'TRUE';
FALSE : 'FALSE';


Identifier
	:	LetterOrDigit LetterOrDigit*
	;

fragment
LetterOrDigit
	:	[a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
	|	~[\u0000-\u007F\uD800-\uDBFF]
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

SKIP
    : (WS | LINE_COMMENT) -> skip
    ;

fragment WS  :  (' '|'\r'|'\t'|'\u000C'|'\n')
    ;

fragment LINE_COMMENT
    : '#' ~('\n'|'\r')* '\r'? '\n'
    ;