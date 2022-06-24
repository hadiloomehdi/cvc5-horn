#----------------------------------------------------------------
# Generated CMake target import file for configuration "Production".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "cvc5::cvc5parser-objs" for configuration "Production"
set_property(TARGET cvc5::cvc5parser-objs APPEND PROPERTY IMPORTED_CONFIGURATIONS PRODUCTION)
set_target_properties(cvc5::cvc5parser-objs PROPERTIES
  IMPORTED_OBJECTS_PRODUCTION "${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_input_imports.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_line_buffered_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/bounded_token_buffer.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/bounded_token_factory.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/line_buffer.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parse_op.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parser.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parser_builder.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/smt2.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/smt2_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/sygus_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/TptpLexer.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/TptpParser.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/tptp.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/tptp_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/Smt2Lexer.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/Smt2Parser.c.o"
  )

list(APPEND _IMPORT_CHECK_TARGETS cvc5::cvc5parser-objs )
list(APPEND _IMPORT_CHECK_FILES_FOR_cvc5::cvc5parser-objs "${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_input_imports.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/antlr_line_buffered_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/bounded_token_buffer.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/bounded_token_factory.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/line_buffer.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parse_op.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parser.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/parser_builder.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/smt2.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/smt2_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/sygus_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/TptpLexer.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/TptpParser.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/tptp.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/tptp/tptp_input.cpp.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/Smt2Lexer.c.o;${_IMPORT_PREFIX}/lib/objects-Production/cvc5parser-objs/smt2/Smt2Parser.c.o" )

# Import target "cvc5::cvc5parser" for configuration "Production"
set_property(TARGET cvc5::cvc5parser APPEND PROPERTY IMPORTED_CONFIGURATIONS PRODUCTION)
set_target_properties(cvc5::cvc5parser PROPERTIES
  IMPORTED_LOCATION_PRODUCTION "${_IMPORT_PREFIX}/lib/libcvc5parser.so.1"
  IMPORTED_SONAME_PRODUCTION "libcvc5parser.so.1"
  )

list(APPEND _IMPORT_CHECK_TARGETS cvc5::cvc5parser )
list(APPEND _IMPORT_CHECK_FILES_FOR_cvc5::cvc5parser "${_IMPORT_PREFIX}/lib/libcvc5parser.so.1" )

# Import target "cvc5::cvc5" for configuration "Production"
set_property(TARGET cvc5::cvc5 APPEND PROPERTY IMPORTED_CONFIGURATIONS PRODUCTION)
set_target_properties(cvc5::cvc5 PROPERTIES
  IMPORTED_LOCATION_PRODUCTION "${_IMPORT_PREFIX}/lib/libcvc5.so"
  IMPORTED_SONAME_PRODUCTION "libcvc5.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS cvc5::cvc5 )
list(APPEND _IMPORT_CHECK_FILES_FOR_cvc5::cvc5 "${_IMPORT_PREFIX}/lib/libcvc5.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
