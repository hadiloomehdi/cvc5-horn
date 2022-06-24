import io.github.cvc5.Kind
import io.github.cvc5.Solver

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


fun main() {
    val horns = ParsData().readFile()
//    val relations = extractRelations(horns)
    val relations = mutableMapOf<String,String>()
    relations["inv-x"] = "x <= 0"
    relations["inv-x\'"] = "x\' <= 0"
    relations["f"] = "z <= 0"
    relations["g"] = "y >= 0"

    propagate(horns,horns[0],relations, mutableSetOf())

    println("a")



    Solver().use { slv ->
        // Prove that for integers x and y:
        //   x > 0 AND y > 0  =>  2x + y >= 3
        val integer = slv.integerSort
        val x = slv.mkConst(integer, "x")
        val y = slv.mkConst(integer, "y")
        val zero = slv.mkInteger(0)
        val x_positive = slv.mkTerm(Kind.GT, x, zero)
        val y_positive = slv.mkTerm(Kind.GT, y, zero)
        val two = slv.mkInteger(2)
        val twox = slv.mkTerm(Kind.MULT, two, x)
        val twox_plus_y = slv.mkTerm(Kind.ADD, twox, y)
        val three = slv.mkInteger(3)
        val twox_plus_y_geq_3 = slv.mkTerm(Kind.GEQ, twox_plus_y, three)
        val formula =
            slv.mkTerm(Kind.AND, x_positive, y_positive).impTerm(twox_plus_y_geq_3)
        println("Checking entailment of formula $formula with cvc5.")
        println("cvc5 should report UNSAT.")
        println(
            "Result from cvc5 is: " + slv.checkSatAssuming(formula.notTerm())
        )

    }

}

fun propagate(horns: List<Horn>, specHorn: Horn, relations: MutableMap<String, String>, visited: MutableSet<Int>) {

    if (specHorn.head.bool == false or (specHorn.hashCode() in visited))
        return

    visited.add(specHorn.hashCode())

    val solverModel  = SolverModel(
        body = specHorn.body.rels.map {
            relations.getValue(getRelationKey(it))
        }.toMutableList(),
        head =     specHorn.head.rel?.let {
             relations.getValue(getRelationKey(it))
        },
        fi = specHorn.body.fi
    )

    val cvc5 = CVC5()
    val a  = cvc5.sat(solverModel)
    val w = cvc5.solve(solverModel)

    println("w")
}

fun getRelationKey(predicate: Predicate) = "${predicate.name}-${predicate.param}"

fun extractRelations(horns: List<Horn>): MutableMap<String, String> {
    val relations = mutableMapOf<String, String>()

    horns.forEach { horn ->
        horn.head.rel?.let {
                relations.putIfAbsent(getRelationKey(it), it.param)
        }
        horn.body.rels.forEach {

                relations.putIfAbsent(getRelationKey(it), it.param)
        }
    }
    return relations
}
