import java.io.File
import java.io.FileNotFoundException
import java.util.*

class ParsData {


    private fun parseHead(headString: String): Head {
        return if (headString.contains("(")) {
            val par = headString.subSequence(headString.indexOf("(") + 1, headString.indexOf(")")).toString()
            Head(rel = Predicate(name = headString.substringBefore("("), par))

        } else {
            if (headString == "T")
                Head(bool = true)
            else
                Head(bool = false)
        }
    }

    private fun parseBody(body:String): Body{
        return body.split("∧").let {
            val fi  = it.last()

            val rels = mutableListOf<Predicate>()
            it.forEach { cluse ->
                if (cluse.contains("(") and !cluse.contains("~") ) {
                    val par = cluse.subSequence(cluse.indexOf("(") + 1, cluse.indexOf(")")).toString()
                    rels.add( Predicate(name = cluse.substringBefore("("), par))

                }
            }

            Body(rels, fi)



        }    }

    fun readFile(): List<Horn> {
        val horns: MutableList<Horn> = mutableListOf()
        try {
            val myObj = File("/home/mahdi/Desktop/synthesis/project/cvc5-horn/src/main/kotlin/f.txt")
            val myReader = Scanner(myObj)
            while (myReader.hasNextLine()) {
                val data = myReader.nextLine()
                val a = data.split("=>").let { splitted ->
                    val head = parseHead(splitted[1].replace("\\s+".toRegex(), ""))

                    val body = parseBody(splitted[0].replace("\\s+".toRegex(), ""))


                    horns.add(Horn(head, body ))
                }
            }
            myReader.close()
            return horns

        } catch (e: FileNotFoundException) {
            println("An error occurred.")
            e.printStackTrace()
            throw Exception("parse error")
        }
    }
}