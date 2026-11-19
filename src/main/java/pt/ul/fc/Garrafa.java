package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Verter o conteúdo de uma garrafa. */
@StateSet({"selada", "aberta", "aVerter", "vazia", "tapada"})
public class Garrafa {

    @StateRefinement(to="selada()")
    public Garrafa() {}

    /** Tira a tampa da garrafa. */
    @StateRefinement(from="selada()", to="aberta()")
    public void abrir() {}

    /** Inclina a garrafa e começa a verter. */
    @StateRefinement(from="aberta()", to="aVerter()")
    public void inclinar() {}

    /** Endireita a garrafa e pára de verter. */
    @StateRefinement(from="aVerter()", to="aberta()")
    public void endireitar() {}

    /** O último conteúdo sai da garrafa. */
    @StateRefinement(from="aVerter()", to="vazia()")
    public void esvaziar() {}

    /** Volta a pôr a tampa (definitivo). */
    @StateRefinement(from="aberta() || vazia()", to="tapada()")
    public void tapar() {}
}
