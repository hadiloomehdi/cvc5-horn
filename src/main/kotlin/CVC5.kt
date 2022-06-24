import io.github.cvc5.Kind
import io.github.cvc5.Solver
import io.github.cvc5.Term


class CVC5 {

    private var variable: MutableMap<String, Term> = mutableMapOf()
    private var solver: Solver = Solver()

    fun sat(solverModel: SolverModel): Boolean {
        solver = Solver()
        solver.setOption("produce-models", "true")
        solver.setOption("produce-unsat-cores", "true")
        variable = mutableMapOf()

        val bodyTerms = solverModel.body.map {
            generateTerm(it.split(" "))
        }

        val fiTerm = generateFi(solverModel.fi.split(" "))
        val headTerm = solverModel.head?.let { generateTerm(it.split(" ")) }

        val allBodyTerms = mutableListOf<Term>()
        allBodyTerms.addAll(bodyTerms)
        allBodyTerms.add(fiTerm)



        allBodyTerms.map { solver.assertFormula(it) }

        val bodyTerm = combinedTerms(allBodyTerms)

        val formula =

            headTerm?.let {
                bodyTerm.impTerm(headTerm)
            } ?: bodyTerm

        return solver.checkSatAssuming(formula).isSat
    }

    fun solve(solverModel: SolverModel): Boolean {
        solver = Solver()
        solver.setOption("produce-models", "true")
        solver.setOption("produce-unsat-cores", "true")
        variable = mutableMapOf()

        val bodyTerms = solverModel.body.map {
            generateTerm(it.split(" "))
        }

        val fiTerm = generateFi(solverModel.fi.split(" "))
        val headTerm = solverModel.head?.let { generateTerm(it.split(" ")) }

        val allBodyTerms = mutableListOf<Term>()
        allBodyTerms.addAll(bodyTerms)
        allBodyTerms.add(fiTerm)



        allBodyTerms.map { solver.assertFormula(it) }

        val bodyTerm = combinedTerms(allBodyTerms)

        val formula =

            headTerm?.let {

                solver.mkTerm(Kind.AND,bodyTerm, solver.mkTerm(Kind.NOT, headTerm))
            } ?: bodyTerm

        val w  = solver.checkSatAssuming(formula)
        println("w")

        return solver.checkSatAssuming(formula).isSat
    }


    fun combinedTerms(terms: List<Term>): Term {
        var termsC = terms
        while (termsC.size != 1) {
            val newTerms = mutableListOf<Term>()
            for (i in 0..termsC.size step 2) {
                newTerms.add(and2Terms(termsC[i], termsC[i + 1]))
            }
            termsC = newTerms
        }
        return termsC.first()
    }

    private fun and2Terms(term1: Term, term2: Term): Term {
        return solver.mkTerm(Kind.GT, term1, term2)
    }

    private fun getVar(newVar: String): Term {
        val integer = solver.integerSort
        return if (newVar !in variable.keys) {
            val varTerm = solver.mkConst(integer, newVar)
            variable[newVar] = varTerm
            varTerm
        } else {
            variable[newVar]!!
        }
    }


    private fun generateFi(fi: List<String>): Term {
        if (fi.size == 3) {
            return generateTerm(fi)
        } else if (fi.size == 5) { // only a =  b + c format
            val rightOp = getVar(fi[4])
            val leftOp = getVar(fi[2])
            val assigned = getVar(fi[0])
            val plus = solver.mkTerm(Kind.ADD, leftOp, rightOp)
            val assign = solver.mkTerm(Kind.EQUAL, assigned, plus)
            return assign
        }
        throw Exception("not defined")
    }


    private fun generateTerm(conditions: List<String>): Term {
        val newVar = getVar(conditions[0])
        val num = solver.mkInteger(conditions[2])

        return when (conditions[1]) {
            "=" -> solver.mkTerm(Kind.EQUAL, newVar, num)
            ">" -> solver.mkTerm(Kind.GT, newVar, num)
            "<" -> solver.mkTerm(Kind.LT, newVar, num)
            ">=" -> solver.mkTerm(Kind.GEQ, newVar, num)
            "<=" -> solver.mkTerm(Kind.LEQ, newVar, num)
            else -> throw Exception(" op not defined")
        }
    }

}