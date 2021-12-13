package repository

import com.example.motivation.infra.MotivationContants
import java.util.*

data class Phrase (val description: String, val category: Int)

class Mock {

    private val INFINITY = MotivationContants.PHRASFILTER.INFINITY
    private val FELIZ = MotivationContants.PHRASFILTER.FELIZ
    private val SOLZINHO = MotivationContants.PHRASFILTER.SOLZINHO

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", FELIZ),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", FELIZ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", FELIZ),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", FELIZ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", FELIZ),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", FELIZ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SOLZINHO),
        Phrase("Você perde todas as chances que você não aproveita.", SOLZINHO),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SOLZINHO),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SOLZINHO),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SOLZINHO),
        Phrase("Se você acredita, faz toda a diferença.", SOLZINHO),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SOLZINHO)
    )
fun getphrase(categoryId: Int) : String {

    val filtered = mListPhrases.filter { (it.category == categoryId || categoryId == INFINITY) }
    val rand = Random() .nextInt(filtered.size)

    return mListPhrases[rand].description
}


}