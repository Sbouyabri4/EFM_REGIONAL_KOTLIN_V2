class Entree(private var motFrancais: String, private var motAnglais: String) {

    fun setMotFrancais(motFrancais: String) {
        require(!motFrancais.isBlank()) { "Le mot français ne peut pas être vide ou blanc" }
        this.motFrancais = motFrancais
    }

    fun setMotAnglais(motAnglais: String) {
        require(!motAnglais.isBlank()) { "Le mot anglais ne peut pas être vide ou blanc" }
        this.motAnglais = motAnglais
    }

    override fun toString(): String {
        return "$motFrancais:$motAnglais"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Entree) {
            motFrancais == other.motFrancais
        } else {
            false
        }
    }
}
