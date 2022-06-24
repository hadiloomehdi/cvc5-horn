/******************************************************************************
 * Top contributors (to current version):
 *   Mudathir Mohamed, Morgan Deters, Andres Noetzli
 *
 * This file is part of the cvc5 project.
 *
 * Copyright (c) 2009-2022 by the authors listed in the file AUTHORS
 * in the top-level source directory and their institutional affiliations.
 * All rights reserved.  See the file COPYING in the top-level source
 * directory for licensing information.
 * ****************************************************************************
 *
 * A simple demonstration of the Java interface.
 *
 * To run the resulting class file, you need to do something like the
 * following:
 *   javac  "-cp" "../build/src/api/java/cvc5.jar" SimpleVC.java
 *   java \
 *     "-Djava.library.path=../build/src/api/java" "-cp" "../build/src/api/java/cvc5.jar:." \
 *     SimpleVC
 *
 *
 *     -Djava.library.path=/home/mahdi/Desktop/synthesis/project/cvc5-horn/libs/lib vm option
 */



fun main(){
    val horns  = ParsData().readFile()
    val r = mutableMapOf<String, String>()
    horns.forEach {
        horn ->
        horn.head.rel?.let {
            if (!it.param.contains("\'"))
            r.putIfAbsent(it.name,it.param)
        }
        horn.body.rels.forEach {

            if (!it.param.contains("\'"))
                r.putIfAbsent(it.name,it.param)
        }
    }

    println("a")
}


