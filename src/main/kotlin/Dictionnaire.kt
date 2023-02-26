class Dictionnaire {
    private val entrees = ArrayList<Entree>()

    fun nombreEntrees(): Int {
        return entrees.size
    }

    fun ajouter(e: Entree) {
        if (entrees.contains(e)) {
            throw IllegalArgumentException("Cette entrée existe déjà dans le dictionnaire")
        } else {
            entrees.add(e)
        }
    }

    fun supprimer(e: Entree): Boolean {
        return entrees.remove(e)
    }

    fun supprimer(motFrancais: String): Boolean {
        return entrees.removeIf { it.motFrancais == motFrancais }
    }

    fun anFr(motAnglais: String): ArrayList<String> {
        val motsFrancais = ArrayList<String>()
        for (entree in entrees) {
            if (entree.motAnglais == motAnglais) {
                motsFrancais.add(entree.motFrancais)
            }
        }
        return motsFrancais
    }

    fun motsAnglais(): ArrayList<String> {
        val motsAnglais = HashSet<String>()
        for (entree in entrees) {
            motsAnglais.add(entree.motAnglais)
        }
        return ArrayList(motsAnglais)
    }

    fun dictionnaireAnFr(): Map<String, ArrayList<String>> {
        val map = HashMap<String, ArrayList<String>>()
        for (entree in entrees) {
            if (map.containsKey(entree.motAnglais)) {
                map[entree.motAnglais]?.add(entree.motFrancais)
            } else {
                map[entree.motAnglais] = ArrayList(listOf(entree.motFrancais))
            }
        }
        return map
    }

    override fun toString(): String {
        return entrees.joinToString("\n")
    }
}
